package swtech.facade.pageDesign.constants;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月16日 上午10:16:54 
 *
 * 常量类
 *
 */

public class PathConstants {

	//jar包目录
	public static final String JAR_PATH = PathConstants.class.getProtectionDomain().getCodeSource().getLocation().getPath();

	//项目根目录
	//	public static final String TARGET_PATH = System.getProperty("user.dir")+"/";曾"/root/java/"
	public static final String TARGET_PATH = "/root/java/";

	//配置文件存放
	//	public static final String Mapper_PATH = System.getProperty("user.dir")+"/../config/mapper/";

	//项目根目录
	//	public static final String ROOT_PATH = System.getProperty("user.dir")+"/";
	public static final String ROOT_PATH = "/root/java/";

	/*	//base64转图片 路径
	public static final String TEMP_FILE = "/usr/local/nginx/html/swpt_2/folder/";

	//编辑器图片路径
	public static final String IMAGE_FILE = "/usr/local/nginx/html/swpt_2/folder/";*/

	//nginx 根目录
	public static final String NIGNX_ROOT_PATH = "/usr/local/nginx/html";

	//nginx 半静态文件存放
	public static final String STATIC_NIGNX_PATH = "/usr/local/nginx/html/html/";

	//独立表单页面存放地址
	//	public static final String EXPORT_RAR = System.getProperty("user.dir")+"/config/exportRar/";
	public static final String EXPORT_RAR = "/root/java/config/exportRar/";
	//ionic页面存放
	//	public static final String IONIC_PATH = System.getProperty("user.dir")+"/config/swApp/";
	public static final String IONIC_PATH = "/root/java/config/swApp/";

	//nignx 配置文件
	public static final String NGINX_PATH = "/usr/local/nginx/conf/nginx.conf";

	//读取百度编辑器配置文件的目录地址，曾
	public static final String UECONFIG_PATH = "/root/java/";
	//截取路径获取包名用的路径，位于swtech.facade.pageDesign.util.Loader.DynamicCompilerUtil，曾
	public static final String DY_PATH = "/root/java";
	//项目中所有“/root/”目录，出于一个服务器多个项目，导致原来的“/root/”变成“/root/xxx/”，曾
	public static final String THIS_ROOT_ATALOGUE = "/root/";





}
