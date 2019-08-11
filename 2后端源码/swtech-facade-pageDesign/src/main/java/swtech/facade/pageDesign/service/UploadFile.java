package swtech.facade.pageDesign.service;

import java.util.Map;
import swtech.common.entity.ReturnMsg;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2018年1月8日 下午5:11:00 
 *
 * 上传文件
 *
 */

public interface UploadFile {
	
	/**
	 * 百度编辑器  默认加载配置文件
	 * */
	public String uploadeditor(String action,String callback);
	
	/**
	 * 百度编辑器  上传文件方法
	 * */
	public Map<String, String> upload(String action,String callback);
	
	/**
	 * base64转图片
	 * */
	public ReturnMsg baseToImage(String data);
	
	/**
	 * 上传资源文件
	 * */
	public ReturnMsg uploadFile();
}
 