package swtech.facade.pageDesign.util.baidu.ueditor.upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	// 单文件
	public static String uploadImg(MultipartFile file, String uploadPath) throws Exception {

		System.out.println(uploadPath);
		File upLoadFile = new File(uploadPath);
		if (!upLoadFile.exists()) {
			upLoadFile.mkdirs();
		}
		String newFileName = getNewFileName(file.getOriginalFilename());
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(new File(uploadPath, newFileName));
		IOUtils.copy(in, out);
		in.close();
		out.close();
		return "uploadimg/" + newFileName;
	}

	// 多文件
	public static List<String> moreUploadImg(MultipartFile[] file, String uploadPath) throws Exception {
		List<String> imglist = new ArrayList<>();
		for (int i = 0; i < file.length; i++) {
			imglist.add(uploadImg(file[i], uploadPath));
		}
		return imglist;
	}

	// 根据文件名生成新的文件
	private static String getNewFileName(String fileName) {
		String newFileName = "";
		if (fileName != null) {
			String extion = fileName.substring(fileName.lastIndexOf("."));
			newFileName = UUID.randomUUID().toString() + extion;
		}

		return newFileName;

	}

}