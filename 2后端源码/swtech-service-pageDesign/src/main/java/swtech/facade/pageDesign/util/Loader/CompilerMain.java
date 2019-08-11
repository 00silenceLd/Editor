package swtech.facade.pageDesign.util.Loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Random;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;

import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.util.File.WriteMapper;

import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 编译类
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月12日 上午11:05:18
 **/
public class CompilerMain {  
	private static final Logger log= LoggerFactory.getLogger(CompilerMain.class);
	public static void testCompiler(String filename) throws Exception {


		// 地址
		StringBuffer sb = new StringBuffer();
		sb.append(PathConstants.TARGET_PATH+filename+"/"+filename+".java,");
		sb.append(PathConstants.TARGET_PATH+filename+"/"+filename+"Mapper.java,");
		sb.append(PathConstants.TARGET_PATH+filename+"/"+filename+"MapperImpl.java,");
		sb.append(PathConstants.TARGET_PATH+filename+"/"+filename+"Mapper.xml");
		
		//更新class文件处理
		sb = readerClass(sb,filename);
		
		
		String body = "";
		String[] page  = sb.toString().split(",");
		for (int i = 0; i < page.length; i++) {
			
			body = page[i].substring(page[i].lastIndexOf("/")+1, page[i].length());
			body = body.replace(".java", "");
			
			// 使用JavaCompiler 编译java文件
			JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = jc.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> fileObjects = fileManager.getJavaFileObjects(page[i]);
			CompilationTask cTask = jc.getTask(null, fileManager, null, null, null, fileObjects);
			cTask.call();
			fileManager.close();
			
			// 使用自定义ClassLoader加载class到内存
			ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
			MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
			Class myObjectClass = classLoader.loadClass(page[i],filename,body);

			
			ClassLoader parentClassLoader1 = MyClassLoader.class.getClassLoader();
			MyClassLoader classLoader1 = new MyClassLoader(parentClassLoader1);
			Class myObjectClass1 = classLoader1.loadClass(page[0],filename,filename);
			Object obj1 = myObjectClass1.newInstance();
			log.info("--------------新对象1:"+obj1);
			
		}
	}

	private static StringBuffer readerClass(StringBuffer sb,String filename) throws IOException {
		
		//修改实体类bean文件
		String[] arr = sb.toString().split(",");
		BufferedReader buff = null;
		File file = new File(arr[0]);
		buff = new BufferedReader(new FileReader(file));		
		String tempString = "";
		StringBuffer sbf = new StringBuffer();
		
		Random ran = new Random();
		int random = ran.nextInt(1000);
		
		int i = 0;
		while((tempString = buff.readLine()) != null) {
			
			if(tempString.contains(filename)) {
				
				if(i >= 2) {
					sbf.append(tempString.replace(filename, filename+random) + "\n");
				}
				i++;
			}else {
				sbf.append(tempString + "\n");
			}
			
		}
		WriteMapper.createFile(sbf.toString(),PathConstants.TARGET_PATH+filename+"/"+filename+random+".java");
		buff.close();
		sb.delete(0, sb.length());
		sb.append(PathConstants.TARGET_PATH+filename+"/"+filename+random+".java,");
		
		
		//修改mapper 文件
		BufferedReader buff1 = null;
		File file1 = new File(arr[1]);
		buff = new BufferedReader(new FileReader(file1));		
		String tempString1 = "";
		StringBuffer sbf1 = new StringBuffer();
		while ((tempString1 = buff.readLine()) != null) {
			
			if(tempString1.contains(filename+"."+filename+";")) {
				sbf1.append(tempString1.replace(filename+"."+filename+";", filename+"."+filename+random+";") + "\n");
			}else if(tempString1.contains("<"+filename+">")) {
				sbf1.append(tempString1.replace("<"+filename+">", "<"+filename+random+">") + "\n");
			}else if(tempString1.contains(filename+" entity")) {
				sbf1.append(tempString1.replace(filename+" entity", filename+random+" entity") + "\n");
			}else {
				sbf1.append(tempString1+"\n");
			}
		}
		WriteMapper.createFile(sbf1.toString(),file1.getAbsolutePath());
		buff.close();
		sb.append(file1.getAbsolutePath()+",");
		
		
		//修改mapperImpl 文件
		BufferedReader buff2 = null;
		File file2 = new File(arr[2]);
		buff = new BufferedReader(new FileReader(file2));		
		String tempString2 = "";
		StringBuffer sbf2 = new StringBuffer();
		while ((tempString2 = buff.readLine()) != null) {
			
			if(tempString2.contains(filename+"."+filename+";")) {
				sbf2.append(tempString2.replace(filename+"."+filename+";", filename+"."+filename+random+";") + "\n");
			}else if(tempString2.contains("<"+filename+">")) {
				sbf2.append(tempString2.replace("<"+filename+">", "<"+filename+random+">") + "\n");
			}else if(tempString2.contains(filename+" entity")) {
				sbf2.append(tempString2.replace(filename+" entity", filename+random+" entity") + "\n");
			}else if(tempString2.contains("public "+filename)) {
				sbf2.append(tempString2.replace("public "+filename,"public "+filename+random) + "\n");
			}else {
				sbf2.append(tempString2+"\n");
			}
			
		}
		WriteMapper.createFile(sbf2.toString(),file2.getAbsolutePath());
		buff.close();
		sb.append(file2.getAbsolutePath());
		
		//修改mapper.xml 文件
		BufferedReader buff3 = null;
		File file3 = new File(arr[3]);
		buff = new BufferedReader(new FileReader(file3));		
		String tempString3 = "";
		StringBuffer sbf3 = new StringBuffer();
		while ((tempString3 = buff.readLine()) != null) {
			
			if(tempString3.contains("\"Kongjian.Kongjian\"")) {
				sbf3.append(tempString3.replace("\"Kongjian.Kongjian\"", "\""+filename+"."+filename+random+"\"") + "\n");
			}else {
				sbf3.append(tempString3+"\n");
			}
			
		}
		WriteMapper.createFile(sbf3.toString(),file3.getAbsolutePath());
		buff.close();
		return sb;
	}
}  
 