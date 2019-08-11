package swtech.facade.pageDesign.util.File; 


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

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
 * @description : 类说明
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月9日 下午6:45:26
 **/

public class SimpleURLClassLoader extends URLClassLoader {
	// 工程class类所在的路径
	public static String projectClassPath = "E:/IDE/work_place/ZJob-Note/bin/";
	// 所有的测试的类都在同一个包下
	public static String packagePath = "testjvm/testclassloader/";

	public SimpleURLClassLoader() {
		// 设置ClassLoader加载的路径
		super(getMyURLs());
	}

	private static URL[] getMyURLs() {
		URL url = null;
		try {
			url = new File(projectClassPath).toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new URL[] { url };
	}

	public Class load(String name) throws Exception {
		return loadClass(name);
	}

	public Class<?> loadClass(String name) throws ClassNotFoundException {
		return loadClass(name, false);
	}

	/**
	 * 38 * 重写loadClass，不采用双亲委托机制("java."开头的类还是会由系统默认ClassLoader加载) 39
	 */
	@Override
	public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
		Class clazz = null;
		// 查看HotSwapURLClassLoader实例缓存下，是否已经加载过class
		clazz = findLoadedClass(name);
		if (clazz != null) {
			if (resolve) {
				resolveClass(clazz);
			}
			return (clazz);
		}

		// 如果类的包名为"java."开始，则有系统默认加载器AppClassLoader加载
		if (name.startsWith("java.")) {
			try {
				// 得到系统默认的加载cl，即AppClassLoader
				ClassLoader system = ClassLoader.getSystemClassLoader();
				clazz = system.loadClass(name);
				if (clazz != null) {
					if (resolve)
						resolveClass(clazz);
					return (clazz);
				}
			} catch (ClassNotFoundException e) {
				// Ignore
			}
		}

		return customLoad(name, this);
	}

	/**
	 * 72 * 自定义加载 73 * @param name 74 * @param cl 75 * @return 76 * @throws
	 * ClassNotFoundException 77
	 */
	public Class customLoad(String name, ClassLoader cl) throws ClassNotFoundException {
		return customLoad(name, false, cl);
	}

	/**
	 * 83 * 自定义加载 84 * @param name 85 * @param resolve 86 * @return 87 * @throws
	 * ClassNotFoundException 88
	 */
	public Class customLoad(String name, boolean resolve, ClassLoader cl) throws ClassNotFoundException {
		// findClass()调用的是URLClassLoader里面重载了ClassLoader的findClass()方法
		Class clazz = ((SimpleURLClassLoader) cl).findClass(name);
		if (resolve)
			((SimpleURLClassLoader) cl).resolveClass(clazz);
		return clazz;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		return super.findClass(name);
	}
}
