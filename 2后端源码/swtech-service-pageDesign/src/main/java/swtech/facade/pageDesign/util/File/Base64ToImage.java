package swtech.facade.pageDesign.util.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.regex.Pattern;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import swtech.common.config.constants.HostConstants;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月14日 下午4:36:28 
 *
 * base64字符转图片
 *
 */

public class Base64ToImage {

	  private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|"  
              + "(\\b(update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";  

		//表示 限定单词边界  比如  select 不通过   1select则是可以的  
		private static Pattern sqlPattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);  
		
		private static boolean isValid(String str)  
		{  
				if (sqlPattern.matcher(str).find())  
				{  
					System.out.println("未通过执行");
					return false;  
				}  
			return true;  
		}    
	
	public static void main(String[] args) {
		String str = "select * from tb_user where id = 123";
		System.out.println(isValid(str));
	}
	
	// base64字符串转化成图片
	public static boolean GenerateImage(String imgStr, String saveFilePath) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		imgStr = imgStr.replaceAll("data:image/jpeg;base64,", "");
		imgStr = imgStr.replaceAll("data:image/png;base64,", "");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			if (!new File(saveFilePath).exists()) {
				System.out.println("file===========:");
				new File(saveFilePath).createNewFile();
			}

			// 生成jpeg图片
			String imgFilePath = saveFilePath;// 新生成的图片

			System.out.println("imgFilePath===========:" + imgFilePath);
			System.out.println("b===========:" + b.length);
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	  //修改图片存储路径(服务器暂时无法兼容)
	  // base64字符串转化成图片
	public static boolean GenerateImageTwo(String imgStr,String saveFilePath,long time) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		String tempFileName =saveFilePath+"SW_"+time+ ".png";
		imgStr = imgStr.replaceAll("data:image/jpeg;base64,","");
		imgStr = imgStr.replaceAll("data:image/png;base64,","");
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			File dir = new File(saveFilePath);
			if(!dir.exists()){
			    dir.mkdirs();
			}
			if(!new File(tempFileName).exists()){
				System.out.println("file===========:");
				new File(tempFileName).createNewFile();
			}
			
			// 生成jpeg图片
			String imgFilePath = tempFileName;// 新生成的图片
			
			System.out.println("imgFilePath===========:"+imgFilePath);
			System.out.println("b===========:"+b.length);
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
 