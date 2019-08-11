package swtech.facade.pageDesign.util.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import swtech.facade.pageDesign.constants.PathConstants;

/**
 *
 * @author 林致杰
 *
 * @version 1.0
 *
 *          创建时间：2017年11月17日 上午9:56:15
 *
 *          获取JAR文件
 *
 */

public class CopyFile {
	public static String copyFormJar(String fileName, String node_name)
			throws IOException {
		// 生成访问jar包语句
		String dest = "";
		String fileUrl = "";
		if (fileName.contains("SourceImpl")) {
			fileName = fileName.replace("xml", "java");
		}
		if (System.getProperty("os.name").equals("Windows 10")) {
			fileUrl = "G:\\test\\swtech-service-pageDesign\\src\\main\\resources\\data\\"
					+ fileName;
			if (fileName.contains("generatorConfig")) {
				dest = "G:\\test\\swtech-service-pageDesign\\"
						+ node_name + fileName;
			} else {
				dest = "G:\\test\\swtech-service-pageDesign\\"
						+ fileName;
			}
			File fromFile = new File(fileUrl);
			File toFile = new File(dest);
			FileInputStream ins = new FileInputStream(fromFile);
			FileOutputStream out = new FileOutputStream(toFile);
			byte[] b = new byte[1024];
			int n = 0;
			while ((n = ins.read(b)) != -1) {
				out.write(b, 0, n);
			}
			ins.close();
			out.close();
			System.out.print("文件复制中成功");
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("jar:file:///");
			sb.append(PathConstants.JAR_PATH);
			sb.append("!" + "/data/" + fileName);
			// JarUrl路径
			fileUrl = sb.toString();
			if (fileName.contains("generatorConfig")) {
				dest = PathConstants.TARGET_PATH + node_name + fileName;
			} else {
				dest = PathConstants.TARGET_PATH + fileName;
			}

			System.out.print("读取的源文件路径:" + fileUrl);
			System.out.println("保存路径：" + dest);
			int BUFF_SIZE = 100000;
			byte[] buffer = new byte[BUFF_SIZE];
			InputStream in = null;
			OutputStream out = null;
			// 复制文件
			try {
				URL url = new URL(fileUrl);
				in = url.openStream();

				out = new FileOutputStream(dest);
				while (true) {
					synchronized (buffer) {
						int amountRead = in.read(buffer);
						if (amountRead == -1) {
							System.out.println(buffer.length + dest);
							break;
						}
						out.write(buffer, 0, amountRead);
					}
				}
				System.out.print("文件复制中成功");
			} catch (Exception e) {
				System.out.print("文件复制中出错" + e.toString());
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception e) {
						System.out.print("关闭输入文件" + e.toString());
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (Exception e) {
						System.out.print("关闭输出文件" + e.toString());
					}
				}
			}
		}
		return dest;
	}

	public static boolean copyFile(String origpath, String destpath,
			String filename) throws Exception {
		String osName = System.getProperty("os.name");
		boolean flag = false;
		/* 系统命令支持的操作系统Windows XP, 2000 2003 7 */
		if (!(osName.equalsIgnoreCase("Windows_NT")
				|| osName.equalsIgnoreCase("windows 2000")
				|| osName.equalsIgnoreCase("windows 2003") || osName
					.equalsIgnoreCase("windows 7"))) {
			return flag;
		}
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		File f = new File(destpath);
		if (!f.exists()) {
			f.mkdirs();
		}
		int exitVal;
		p = rt.exec("cmd exe /c copy " + origpath + filename + " " + destpath);
		// 进程的出口值。根据惯例，0 表示正常终止。
		exitVal = p.waitFor();
		if (exitVal == 0) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
}
