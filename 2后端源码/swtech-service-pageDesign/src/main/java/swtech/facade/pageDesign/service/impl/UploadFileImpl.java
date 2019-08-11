package swtech.facade.pageDesign.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.LogFactory; 
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType; 
import org.apache.commons.logging.Log;
import com.google.common.collect.Maps;
import com.ibm.icu.text.SimpleDateFormat;

import swtech.common.config.constants.HostConstants;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.service.UploadFile;
import swtech.facade.pageDesign.util.File.Base64ToImage;
import swtech.facade.pageDesign.util.File.CopyFile;
import swtech.facade.pageDesign.util.File.FormUploadUtil;
import swtech.facade.pageDesign.util.baidu.ueditor.ActionEnter;
import swtech.facade.pageDesign.util.baidu.ueditor.FileUtil;
import swtech.facade.pageDesign.util.baidu.ueditor.ResponseUtils;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2018年1月8日 下午5:13:05 
 *
 * ueditor 编辑器上传功能
 *
 */

@Path("ueditor")
@Component("uploadFile")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
public class UploadFileImpl implements UploadFile {
	private static final Log log = LogFactory.getLog(UploadFileImpl.class);
	/**
	 * 加载默认配置文件
	 * */
	@GET
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/ueditorUpload")
	public String uploadeditor(@QueryParam("action")String action,@QueryParam("callback")String callback) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		//JSONObject jo = new JSONObject();
		String exec = "";
		try {
			HttpServletRequest req = RpcContext.getContext().getRequest(
					HttpServletRequest.class);
			HttpServletResponse res = RpcContext.getContext().getResponse(
					HttpServletResponse.class);

//			String rootPath = System.getProperty("user.dir") + "/";//曾
			String rootPath = PathConstants.UECONFIG_PATH;
			log.info("==========rootpath=="+rootPath);
			String path = rootPath + "ConfigFile/config.json";//曾智宏
			log.info("==========加载百度编辑器配置文件地址=="+path);
			String originalFilename = "";
			log.info("==========path=="+path);
			// 上传初始化
			if ("config".equals(action)) {
				// 如果是初始化
				//读取配置文件
				exec = new ActionEnter(req, path).exec();
				
				/*//设置默认配置
				if(callback != null && !"".equals(callback)) {
					exec +=callback+"(";
				}
				
				exec += "{\"videoMaxSize\":102400000,\"videoActionName\":\"uploadvideo\",\"fileActionName\":\"uploadfile\",\"fileManagerListPath\":\"/swpt_2/ueditor/jsp/upload/file/\",\"imageCompressBorder\":1600,\"imageManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"imageManagerListPath\":\"/swpt_2/ueditor/jsp/upload/image/\",\"fileMaxSize\":51200000,\"fileManagerAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"fileManagerActionName\":\"listfile\",\"snapscreenInsertAlign\":\"none\",\"scrawlActionName\":\"uploadscrawl\",\"videoFieldName\":\"upfile\",\"imageCompressEnable\":true,\"videoUrlPrefix\":\"\",\"fileManagerUrlPrefix\":\"\",\"catcherAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"imageManagerActionName\":\"listimage\",\"snapscreenPathFormat\":\"/swpt_2/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlPathFormat\":\"/swpt_2/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"scrawlMaxSize\":2048000,\"imageInsertAlign\":\"none\",\"catcherPathFormat\":\"/swpt_2/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"catcherMaxSize\":20480000,\"snapscreenUrlPrefix\":\"\",\"imagePathFormat\":\"/swpt_2/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}\",\"imageManagerUrlPrefix\":\"\",\"scrawlUrlPrefix\":\"\",\"scrawlFieldName\":\"upfile\",\"imageMaxSize\":20480000,\"imageAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\"],\"snapscreenActionName\":\"uploadimage\",\"catcherActionName\":\"catchimage\",\"fileFieldName\":\"upfile\",\"fileUrlPrefix\":\"\",\"imageManagerInsertAlign\":\"none\",\"catcherLocalDomain\":[\"127.0.0.1\",\"localhost\",\"img.baidu.com\"],\"filePathFormat\":\"/swpt_2/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}\",\"videoPathFormat\":\"/swpt_2/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}\",\"fileManagerListSize\":20,\"imageActionName\":\"ueditorUpload\",\"imageFieldName\":\"upfile\",\"imageUrlPrefix\":\"\",\"scrawlInsertAlign\":\"none\",\"fileAllowFiles\":[\".png\",\".jpg\",\".jpeg\",\".gif\",\".bmp\",\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\",\".rar\",\".zip\",\".tar\",\".gz\",\".7z\",\".bz2\",\".cab\",\".iso\",\".doc\",\".docx\",\".xls\",\".xlsx\",\".ppt\",\".pptx\",\".pdf\",\".txt\",\".md\",\".xml\"],\"catcherUrlPrefix\":\"\",\"imageManagerListSize\":20,\"catcherFieldName\":\"source\",\"videoAllowFiles\":[\".flv\",\".swf\",\".mkv\",\".avi\",\".rm\",\".rmvb\",\".mpeg\",\".mpg\",\".ogg\",\".ogv\",\".mov\",\".wmv\",\".mp4\",\".webm\",\".mp3\",\".wav\",\".mid\"]}";
				
				//设置默认配置
				if(callback != null && !"".equals(callback)) {
					exec +=callback+");";
				}*/
				
				/*PrintWriter writer = res.getWriter();
				writer.write(exec);
				writer.flush();
				writer.close();*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return exec;
	}
	
	/**
	 * 上传图片
	 * */
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/ueditorUpload")
	public Map<String, String> upload(@QueryParam("action")String action,@QueryParam("callback")String callback) {    
		HttpServletRequest req = RpcContext.getContext().getRequest(HttpServletRequest.class);
		HttpServletResponse res = RpcContext.getContext().getResponse(HttpServletResponse.class);
		String originalFilename = "";
		JSONObject json = new JSONObject();
		Map<String, String> map = new HashMap<String, String>();
		try {
			
			if ("uploadimage".equals(action)|| "uploadvideo".equals(action)
					|| "uploadfile".equals(action)||"ueditorUpload".equals(action)) { // 如果是上传图片、视频、和其他文件
					MultipartResolver resolver = new CommonsMultipartResolver(
							req.getSession().getServletContext());
					MultipartHttpServletRequest Murequest = resolver
							.resolveMultipart(req);
					Map<String, MultipartFile> files = Murequest.getFileMap();// 得到文件map对象					
					//遍历上传文件
					for (MultipartFile pic : files.values()) {						
						// 文件大小
						long size = pic.getSize(); 
						// 原来的文件名
						originalFilename = new String(pic.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
						log.info("-----------------"+originalFilename);
						//存放地址
						String tempPath = HostConstants.FILE_PATH + new Date().getTime()+originalFilename;
						try {
							log.info("Posth上传图片的路径是:"+tempPath);							
							FileUtil.savaFile(pic.getBytes(), tempPath);
						} catch (IOException e) {
							e.printStackTrace();
						}
						//文件是否储存成功
						if(new File(tempPath).exists()){
							map.put("state", "SUCCESS");
							map.put("url", tempPath.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST));
							map.put("title",originalFilename);
							map.put("original",originalFilename);
						}else{
							//上传失败
						}
						
						//响应页面
						//res.getWriter().print(json.toString());
						//ResponseUtils.renderJSON(res, json.toString());
					}	
			 }
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return map;	
	}
	
	/**
	 * base64 转 图片
	 * */
	@POST
	@Path("/baseToImage")
	public ReturnMsg baseToImage(String data){
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		com.alibaba.fastjson.JSONObject json = com.alibaba.fastjson.JSONObject.parseObject(data);
		String src = json.getString("src");
		try {
			
			if(src.contains("/9j")){
				String tempFileName = HostConstants.FILE_PATH + new Date().getTime() + ".png";
				Base64ToImage.GenerateImage(src.replace("data:image/png;base64,", ""), tempFileName);
				src = tempFileName.replace(HostConstants.FILE_PATH+"folder/","").trim();
			}else{
				return new ReturnMsg("1","转换异常");
			}
			
			msg.setMsg(src);
			msg.setStatus("0");
			msg.setStatusMsg("转换成功");
		} catch (Exception e) {
			msg.setStatus("2");
			msg.setStatusMsg("转换失败");
			e.printStackTrace();      
		}
		
		return msg;
	}
	
	protected String getFilePath(CommonsMultipartFile uploadFile) {
		String absolutePath = HostConstants.FILE_PATH;
		File folder = new File(absolutePath);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		String rawName = uploadFile.getFileItem().getName();
		String fileExt = rawName.substring(rawName.lastIndexOf("."));
		String newName = System.currentTimeMillis()
				+ UUID.randomUUID().toString() + fileExt;
		File saveFile = new File(absolutePath + File.separator + newName);
		try {
			uploadFile.getFileItem().write(saveFile);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return absolutePath + "/" + newName;
	}

	protected File getFile(String path) {
		File file = new File(path);
		return file;
	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("uoloadFile")
	public ReturnMsg uploadFile() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		HttpServletRequest req = RpcContext.getContext().getRequest(HttpServletRequest.class);
		try {
			
			FormUploadUtil util = new FormUploadUtil();
			List<Map<String, Object>> list = util.formDataList(req);
			//获取表单文件
			Map<String, Object> files = list.get(1);
			//获取表单文字
			Map<String, Object> form = list.get(0);
			
			//获取xls
			List<Object[]> fileMessages = (List<Object[]>) files.get("fileVideo");
			String fileUrl = null;
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM");
			Date date=new Date();
			String format = sf.format(date);
			for (Object[] fm : fileMessages) {
				File dir = new File(HostConstants.FILE_PATH +"file_directory"+"/"+format);
				if(!dir.exists()){
				    dir.mkdirs();
				}
				log.info("============dir============="+dir);
				fileUrl = dir+"/"+ fm[3];
				log.info("-----------------"+fileUrl);
				// 路径不存在就创建路径
				FileUtil.savaFile((byte[]) fm[0], fileUrl);
			}
			log.info("-----------------"+fileUrl);
			//msg.setMsg(fileUrl.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST));
			msg.setMsg(fileUrl.replace(HostConstants.FILE_PATH,"/folder/"));
			log.info("=======FILE_PATH========"+HostConstants.FILE_PATH+"====FILE_HOST=="+HostConstants.FILE_HOST);
			msg.setStatus("0");
			msg.setStatusMsg("保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("保存失败");
		}
		return msg;
	}
	

}
 