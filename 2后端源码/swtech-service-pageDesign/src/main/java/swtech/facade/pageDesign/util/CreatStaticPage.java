package swtech.facade.pageDesign.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.esotericsoftware.minlog.Log;

import swtech.common.config.constants.HostConstants;
import swtech.facade.pageDesign.constants.PathConstants;

public class CreatStaticPage {

	//初始化文件名
	private static File file;
	//private static String file_name;

	public static boolean CreatPage(String htmlText,String name,Integer pathnum, String page_path) throws IOException{
		String htmlform=htmlText.substring(htmlText.indexOf("<form id=\"insertForm\" "), htmlText.indexOf("</form>")+7);
		htmlText=htmlText.replaceAll("alert(\"页面预览失败！请关闭页面并重新尝试预览！\");"," ");

		//Log.info(htmlText);
		String substring = htmlText.substring(0, htmlText.indexOf("<section"));
		substring=substring.replaceAll("href=\"", "href=\"\\./");
		substring=substring.replaceAll("src=\"", "src=\"\\./");

		substring=substring.replaceAll("href=\"\\././","href=\"/editor/assets/ueditor/formdesign/");
		substring=substring.replaceAll("src=\"\\././", "src=\"/editor/assets/ueditor/formdesign/");

		substring=substring.replaceAll("href=\"\\./../", "href=\"/editor/assets/ueditor/");
		substring=substring.replaceAll("src=\"\\./../","src=\"/editor/assets/ueditor/");

		substring=substring.replaceAll("href=\"\\./", "href=\"/editor/assets/ueditor/formdesign/");
		substring=substring.replaceAll("src=\"\\./","src=\"/editor/assets/ueditor/formdesign/");

		/* String removeStr="<script src=\"http://192.168.0.213/editor/assets/ueditor/formdesign/self/js/allflow.js\"></script>";
	    substring=substring.replaceAll(removeStr," ");
		 */




		String body = htmlText.substring(htmlText.indexOf("<section"));
		body = body.substring(0,body.indexOf("<!--用户权限管理-->"));
		body=body.replaceAll("alert(\"页面预览失败！请关闭页面并重新尝试预览！\");"," ");

		StringBuilder sb=new StringBuilder();

		PrintStream ps = null;
		try {
			File dir;
			if(pathnum==0) {//判断该页面是否为推广页，以决定保存在哪个地址
				//为推广页
				//File dir = new File( "/usr/local/nginx/html/no.kz38.cn/folder/staticPage");
				dir = new File( HostConstants.POPULARIZE_FILE_PATH +"staticPage");
				Log.info("当前为推广页--存放位置是---"+HostConstants.POPULARIZE_FILE_PATH +"staticPage");
			}else {
				//File dir = new File( "/usr/local/nginx/html/no.kz38.cn/folder/staticPage");
				dir = new File( HostConstants.FILE_PATH +"staticPage");
			}
			
			if(page_path!=null) {
				
				dir = new File( PathConstants.NIGNX_ROOT_PATH +page_path);
				Log.info("页面分类--存放位置是---"+PathConstants.NIGNX_ROOT_PATH +page_path);
				
			}
			
			

			if(!dir.exists()){
				dir.mkdirs();
			}
			file=new File(dir+"/"+name+".html");
			if(file.exists()){
				file.delete();
				file.createNewFile();
				Log.info("文件生成成功！位置:"+file);
				CreatStaticPage.setFile(file);
				Log.info("文件生成成功！位置CreatStaticPage.getFile():"+CreatStaticPage.getFile());
				ps = new PrintStream(new FileOutputStream(file));
			}else{
				try {
					file.createNewFile();
					Log.info("文件生成成功！位置:"+file);
					ps = new PrintStream(new FileOutputStream(file));
					CreatStaticPage.setFile(file);
					Log.info("文件生成成功！位置CreatStaticPage.getFile():"+CreatStaticPage.getFile());
				} catch (IOException e) {
					e.printStackTrace();
					Log.info("文件生成失败！位置:"+file);
					CreatStaticPage.setFile(file);
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		sb.append(substring); 
		sb.append(body);
		//sb.append(htmlform);
		sb.append("</body>");
		sb.append("</html>");

		try {
			// 将HTML文件内容写入文件中
			ps.println(sb.toString());
			ps.close();
			return true;
		} catch (Exception e) {
			ps.close();
			return false;
		}

	}



	public static File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public static void setFile(File file) {
		CreatStaticPage.file = file;
	}





}
