package swtech.facade.pageDesign.util.File;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
*
* @author 林致杰  
*
* @version 1.0
*
* 创建时间：2017年10月23日 上午11:46:31 
*
* 工具类
*
*/ 

public class FormUploadUtil {

	private final int MEMORY_THRESHOLD = 1024 * 1024 * 500; // 500MB
	private final int MAX_FILE_SIZE = 1024 * 1024 * 500; // 500MB
	private final int MAX_REQUEST_SIZE = 1024 * 1024 * 500; // 500MB

	// 临时存储目录
	private final String templePath = "";
	// 构造临时路径来存储上传的文件
	private final String uploadPath = "";

	/**
	 * 
	 * @作用： TODO 返回每个字段唯一的情况返回值 如果为文件，则为数组 [byte数组，md5,后缀名，文件名,length]
	 * @param req
	 * @return
	 * @throws FileUploadException
	 * @时间：上午9:42:55
	 */
	public Map<String, Object> getSingleField(HttpServletRequest req)
			throws FileUploadException {
		Map<String, Object> map = new HashMap<String, Object>();
		List<FileItem> items = getItemList(req);
		if (items != null) {
			for (FileItem item : items) {
				String fileName = item.getName();
				String fieldName = item.getFieldName();

				// 判断是否为文件
				if (fileName == null) {
					System.out.println(fieldName + "为字段");
					if (item.getString().length() <= 0)
						continue;
					try {
						map.put(fieldName, item.getString("UTF-8"));
					} catch (UnsupportedEncodingException e) {
						System.out.println("表单中文乱码转换出错");
						e.printStackTrace();
					}
				} else {
					System.out.println(fieldName + "为文件");
					String suffix = fileName.substring(fileName
							.lastIndexOf(".") + 1);
					byte[] bytes = item.get();
					if (bytes.length <= 0)
						continue;
					Object[] objs = new Object[] { bytes, suffix, fileName,
							bytes.length };
					map.put(fieldName, objs);
				}
			}
		}
		return map;
	}

	/**
	 * 
	 * @作用： TODO
	 * @param request
	 * @return 返回数组 0 为保存字符的Map,1为文件的Map bytes,md5, suffix,fileName
	 * @时间：上午11:52:16
	 */
	public List<Map<String, Object>> formDataList(HttpServletRequest request) {
		// if (!ServletFileUpload.isMultipartContent(request)) {
		// log.info("Error: 表单必须包含 enctype=multipart/form-data");
		// return null;
		// }

		// 配置上传参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		// factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		// factory.setRepository(new File(templePath));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);


		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapStr = new HashMap<String, Object>();
		Map<String, Object> mapBytes = new HashMap<String, Object>();
		result.add(mapStr);
		result.add(mapBytes);
		try {
			List<FileItem> formItems = upload.parseRequest(request);

			if (formItems != null && formItems.size() > 0) {

				for (FileItem item : formItems) {
					String fileName = item.getName();
					String fieldName = item.getFieldName();
					// 判断是否为文件
					if (item.isFormField()) {
						System.out.println(fieldName + "为字段");
						if (item.getString().length() <= 0)
							continue;
						try {
							mapStr.put(fieldName, item.getString("UTF-8"));
						} catch (UnsupportedEncodingException e) {
							System.out.println("表单中文乱码转换出错");
							e.printStackTrace();
						}
					} else {
						System.out.println(fieldName + "为文件");
						String suffix = fileName.substring(fileName
								.lastIndexOf(".") + 1);

						byte[] bytes = item.get();

						String md5 = getFileMd5(bytes);

						if (bytes.length <= 0)
							continue;
						// 确保文件名不为路径+名
						String isDir = null;
						if (fileName.indexOf("/") >= 0)
							isDir = "/";
						if (fileName.indexOf("\\") >= 0)
							isDir = "\\";
						if (isDir != null) {
							fileName = fileName.substring(fileName
									.lastIndexOf(isDir) + 1);
						}
						if (mapBytes.containsKey(fieldName)) {
							List<Object[]> list = (List<Object[]>) mapBytes
									.get(fieldName);
							
							Object[] objs = new Object[] { bytes, md5, suffix,
									fileName };
							list.add(objs);
						} else {
							List<Object[]> newList = new ArrayList<Object[]>();
							Object[] objs = new Object[] { bytes, md5, suffix,
									fileName };
							newList.add(objs);
							mapBytes.put(fieldName, newList);
						}
					}

				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		return result;
	}

	private String getFileMd5(byte[] obj) {
		
		return DigestUtils.md5Hex(obj);
	}

	@SuppressWarnings("unused")
	private List<FileItem> getItemList(HttpServletRequest request)
			throws FileUploadException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
		// factory.setSizeThreshold(MEMORY_THRESHOLD);
		// 设置临时存储目录
		// factory.setRepository(new File(templePath));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		// 设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);

		// 设置最大请求值 (包含文件和表单数据)
		upload.setSizeMax(MAX_REQUEST_SIZE);

		return upload.parseRequest(request);
	}

}
