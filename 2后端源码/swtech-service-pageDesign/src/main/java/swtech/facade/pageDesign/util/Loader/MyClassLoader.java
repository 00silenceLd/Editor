package swtech.facade.pageDesign.util.Loader; 

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

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
 * @description : 自定义加载类
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月10日 上午9:57:43
 **/


//自定义类加载器  
public class MyClassLoader extends ClassLoader {  
	private static final Logger log = LoggerFactory.getLogger(MyClassLoader.class);
	public MyClassLoader(ClassLoader parent) {
		super(parent);
	}

	public Class loadClass(String name,String filename, String page) throws ClassNotFoundException {

		if (!name.contains(filename))
			return super.loadClass(name);
		try {
			log.info("------------------地址:"+name+"-------------------名字："+page);
			FileInputStream input = new FileInputStream(new File(name.replace(".java", ".class")));  
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int data = input.read();

			while (data != -1) {
				buffer.write(data);
				data = input.read();
			}

			input.close();

			byte[] classData = buffer.toByteArray();

			return defineClass(filename+"."+page, classData, 0, classData.length);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

   @Override  
   protected void finalize() throws Throwable {  
       log.info("我被抛弃了！");  
   }  
 
}  