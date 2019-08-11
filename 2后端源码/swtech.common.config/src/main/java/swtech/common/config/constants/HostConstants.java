package swtech.common.config.constants;

import swtech.common.config.utils.FileUtil;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月9日 上午11:24:43 
 *
 * 常量
 *
 */

public class HostConstants {
	//	private String newPath= PathUtils.NEW_PATH;

	//主站Host
	public static final String HOST_PATH = FileUtil.getKey("HOST");

	//主站FILE_HOST
	public static final String FILE_HOST = FileUtil.getKey("FILE_HOST");

	//文件FILE_PATH
	public static final String FILE_PATH = FileUtil.getKey("FILE_PATH");

	//文件FDFS_PATH
	public static final String FDFS_PATH = FileUtil.getKey("FDFS_PATH");

	//文件根目录
	public static final String NGINX_PATH = FileUtil.getKey("NGINX_PATH");

	//文件根目录
	public static final String JAR_PATH = FileUtil.getKey("JAR_PATH");

	//推广页存放路径，曾
	public static final String POPULARIZE_FILE_PATH = FileUtil.getKey("POPULARIZE_FILE_PATH");


	//配置文件路径
	public static final String CONFIG_PATH = "/root/config.json";//

	//工作流ip+端口
	public static final String ACTIVITI_IP = "http://127.0.0.1:8088";

}
