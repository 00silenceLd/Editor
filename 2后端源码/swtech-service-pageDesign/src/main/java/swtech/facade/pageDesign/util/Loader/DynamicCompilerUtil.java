package swtech.facade.pageDesign.util.Loader;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.constants.PathConstants;

import com.alibaba.druid.support.logging.Log;


/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月13日 下午3:21:48 
 *
 * 动态编译所有类
 *
 */

public class DynamicCompilerUtil extends ClassLoader {  
	private static final Logger log = LoggerFactory.getLogger(DynamicCompilerUtil.class);
    /** 
     * 编译java文件 
     * @param filePath     文件或者目录（若为目录，自动递归编译） 
     * @param sourceDir    java源文件存放目录 
     * @param targetDir    编译后class类文件存放目录 
     * @param diagnostics  存放编译过程中的错误信息 
     * @throws Exception 
     */  
    public static boolean compiler(String filePath, String sourceDir, String targetDir, DiagnosticCollector<JavaFileObject> diagnostics)  
            throws Exception {  
    	
    	
    	 log.info("这里是DynamicCompilerUtil.java文件中");
         log.info("filePath============="+filePath);
         log.info("sourceDir=================="+sourceDir);
         log.info("targetDir=================="+targetDir);
         log.info("diagnostics================"+diagnostics);
    	List<File> sourceFileList =null;
        // 获取编译器实例  
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();  
        // 获取标准文件管理器实例  
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);  
        try {  
            if (StringUtils.isEmpty(filePath) && StringUtils.isEmpty(sourceDir) && StringUtils.isEmpty(targetDir)) {  
                return false;  
            }  
            // 得到filePath目录下的所有java源文件  
            File sourceFile = new File(filePath);  
            sourceFileList = new ArrayList<File>();  
            getSourceFiles(sourceFile, sourceFileList);  
            // 没有java文件，直接返回  
            if (sourceFileList.size() == 0) {  
                log.info(filePath + "目录下查找不到任何java文件");  
                return false;  
            }
            
            // 获取要编译的编译单元  
            Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);  
            /** 
             * 编译选项，在编译java文件时，编译程序会自动的去寻找java文件引用的其他的java源文件或者class。 -sourcepath选项就是定义java源文件的查找目录， -classpath选项就是定义class文件的查找目录。 
             */  
            Iterable<String> options = Arrays.asList("-encoding","UTF-8","-d", targetDir, "-sourcepath", sourceDir);  
            CompilationTask compilationTask = compiler.getTask(null, fileManager, diagnostics, options, null, compilationUnits);  
            return compilationTask.call();  
        } finally {  
            fileManager.close();  
        }  
    }  
  
    /** 
     * 类的动态加载 
     *  
     * @param path 路径
     * @param javaCode 包名  x.x.xx
     * @throws Exception 
     */  
    public static Class<?> dynamicLoad(String path) throws Exception{
    	
    	Class classes = null;
    	Constructor constructor = null;
    	String javaCode = null;
    	try {
    		
    		javaCode = cutJavaCode(path);
    		log.info("包名是："+javaCode+";loader的路径是："+path);  
            URL[] urls = new URL[]{new URL("file:/"+ path)};   
            URLClassLoader ucl = new URLClassLoader(urls);  
            classes = ucl.loadClass(javaCode);  
            log.info("加载类["+javaCode+"] 来自 "+ucl);  
            
            //测试方法
            /*  constructor = classes.getConstructor(null);  
            Role role = (Role) constructor.newInstance(null);
            log.info(role.getCreateTime());
            User user = new User();
            user.setId(1);
            user.setName("test");
            role.setUser(user);
            log.info(role.toString());*/
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
    }
    
    /** 
     * 查找该目录下的所有的java文件 
     *  
     * @param sourceFile 文件
     * @param sourceFileList 文件list集合
     * @throws Exception 
     */  
    private static void getSourceFiles(File sourceFile, List<File> sourceFileList) throws Exception {  
        if (sourceFile.exists() && sourceFileList != null) {// 文件或者目录必须存在  
            if (sourceFile.isDirectory()) {// 若file对象为目录  
                // 得到该目录下以.java结尾的文件或者目录  
                File[] childrenFiles = sourceFile.listFiles(new FileFilter() {  
                    public boolean accept(File pathname) {  
                        if (pathname.isDirectory()) {  
                            return true;  
                        } else {  
                            String name = pathname.getName();  
                            return name.endsWith(".java") ? true : false;  
                        }  
                    }  
                });  
                // 递归调用  
                for (File childFile : childrenFiles) {  
                    getSourceFiles(childFile, sourceFileList);  
                }  
            } else {// 若file对象为文件  
                sourceFileList.add(sourceFile);  
            }  
        }  
    }  


    /** 
     * 截取路径获取包名
     *  
     * @param path 路径
     */  
    public static String cutJavaCode(String path){
    	try {
			
    		path = path.substring(0,path.length()-5);
//        	path = path.replace(System.getProperty("user.dir")+"\\src\\main\\java\\", "");曾
        	path = path.replace(PathConstants.DY_PATH+"\\src\\main\\java\\", "");
        	path = path.replace("\\", ".");
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
    }
    
    
    //测试方法
    public static ReturnMsg compiler(String node_name) { 
    	ReturnMsg msg=new ReturnMsg();
        try {  
            // 编译src目录下的所有java文件  
            String filePath =  PathConstants.TARGET_PATH+node_name;  
            String sourceDir = PathConstants.TARGET_PATH+node_name; 
            String targetDir = PathConstants.TARGET_PATH;  
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();  
            //编译方法
            boolean compilerResult = compiler(filePath, sourceDir, targetDir, diagnostics);  
            log.info(filePath);
            log.info(targetDir);
            if (compilerResult) {  
                log.info("编译成功"); 
                msg.setStatus("1");
            } 
            else {  
                log.info("编译失败");  
                msg.setStatus("0"); 
                for (Diagnostic diagnostic : diagnostics.getDiagnostics()) { 
                    log.info(diagnostic.getMessage(null));  
                    msg.setMsg(diagnostic.getMessage(null));
                }  
            }  
        } catch (Exception e) {  
        	  msg.setStatusMsg(e.toString());
            e.printStackTrace();  
        }  
        return msg;
    }  
    
}  