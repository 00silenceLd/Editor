package swtech.facade.pageDesign.util;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.net.ftp.FTPClient;

import swtech.facade.pageDesign.util.File.SSHUtil;
 
/**
 * 静态页面引擎技术
 */
public class HtmlGenerator {
	HttpClient httpClient = null; //HttpClient实例
	GetMethod getMethod =null; //GetMethod实例
	BufferedWriter fw = null;
	String page = null;
	String webappname = null;
	String fileCatalog=null;
	BufferedReader br = null;
	InputStream in = null;
	StringBuffer sb = null;
	String line = null; 
	String account = null; 
	//构造方法
	public HtmlGenerator(String webappname){
		this.webappname = webappname;
	}
	
	/** 根据模版及参数产生静态页面 */
	public boolean createHtmlPage(String url,String htmlFileName){
		boolean status = false;	
		int statusCode = 0;				
		try{
			//创建一个HttpClient实例充当模拟浏览器
			httpClient = new HttpClient();
			//设置httpclient读取内容时使用的字符集
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"UTF-8");			
			//创建GET方法的实例
			getMethod = new GetMethod(url);
			//使用系统提供的默认的恢复策略，在发生异常时候将自动重试3次
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			//设置Get方法提交参数时使用的字符集,以支持中文参数的正常传递
			getMethod.addRequestHeader("Content-Type","text/html;charset=UTF-8");
			//执行Get方法并取得返回状态码，200表示正常，其它代码为异常
			statusCode = httpClient.executeMethod(getMethod);			
			if (statusCode!=200) {
				System.out.println("静态页面引擎在解析"+url+"产生静态页面"+htmlFileName+"时出错:");		
			     }else{
				//读取解析结果
				sb = new StringBuffer();
				in = getMethod.getResponseBodyAsStream();
				br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
				while((line=br.readLine())!=null){
					sb.append(line+"\n");
				}
				if(br!=null)br.close();
				page = sb.toString();
				//将页面中的相对路径替换成绝对路径，以确保页面资源正常访问
				page = formatPage(page);
				//将解析结果写入指定的静态HTML文件中，实现静态HTML生成
				/*
				FTPClient ftpClient=new FTPClient();
				FileInputStream fis = null;
				fis = new FileInputStream(page);
				// 设置上传目录
				ftpClient.changeWorkingDirectory("");
				ftpClient.setBufferSize(1024);
				ftpClient.setControlEncoding("GBK");
				// 设置文件类型（二进制）
				ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
				ftpClient.storeFile("test.html", fis);*/
				writeHtml(htmlFileName,page);
				System.out.println("=======打印出解析的看看+++"+page);
				System.out.println("=======打印出解析的主机看看+++"+htmlFileName);
				status = true;
			}			
		}catch(Exception ex){
			System.out.println("=======打印出解析的看看+++"+page);
			System.out.println("(创建)静态页面引擎在解析"+url+"产生静态页面"+htmlFileName+"时出错:"+ex.getMessage()	);		
        }finally{
        	//释放http连接
        	getMethod.releaseConnection();
        }
		return status;
	}
	
	//将解析结果写入指定的静态HTML文件中
	private synchronized void writeHtml(String htmlFileName,String content) throws Exception{
		fw = new BufferedWriter(new FileWriter(htmlFileName));
		OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(htmlFileName),"UTF-8");
		fw.write(page);	
		if(fw!=null)fw.close();		
	}
	
	//替换内容，获取想要的
    private String formatPage(String page){    
   
     //将页面中的相对路径替换成绝对路径，以确保页面资源正常访问  
    //page = page.replaceAll("\\.\\./\\.\\./\\.\\./","\\.\\./\\.\\./\\.\\./");  
   // page = page.replaceAll("\\.\\./\\.\\./","\\.\\./\\.\\./");  
  //page = page.replaceAll("\\.\\./","\\.\\./");
      String head="<html>";
      String rump="</html>";
    	
      page=page.replaceAll("href=\"", "href=\"\\./");
      page=page.replaceAll("src=\"", "src=\"\\./");
      
      page=page.replaceAll("href=\"\\././", "href=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");
      page=page.replaceAll("src=\"\\././", "src=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");

      page=page.replaceAll("href=\"\\./../", "href=\"http://192.168.0.213/editor/assets/ueditor/");
      page=page.replaceAll("src=\"\\./../", "src=\"http://192.168.0.213/editor/assets/ueditor/");
   
      page=page.replaceAll("href=\"\\./", "href=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");
      page=page.replaceAll("src=\"\\./", "src=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");
      page=head+page;
      page=page+rump;
      
    /*  page=page.replaceAll("href=\"\\../", "href=\"http://192.168.0.213/editor/assets/ueditor/");
      page=page.replaceAll("src=\"\\../", "src=\"http://192.168.0.213/editor/assets/ueditor/");
      page=page.replaceAll("href=\"\\./", "href=\"");
      page=page.replaceAll("src=\"\\./", "src=\"");
      page=page.replaceAll("href=\"", "href=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");
      page=page.replaceAll("src=\"", "src=\"http://192.168.0.213/editor/assets/ueditor/formdesign/");
   */
     return page;  
    } 
	//测试方法
/*	public static void main(String[] args) throws Exception{
		HtmlGenerator h = new HtmlGenerator("http://192.168.0.213/editor/assets/ueditor/formdesign/preview.html?link=14810");
		//HtmlGenerator h = new HtmlGenerator("http://192.168.0.213/editor/");
		h.createHtmlPage("http://192.168.0.213/editor/assets/ueditor/formdesign/preview.html?link=14810","d:/ccc.html");
		System.out.println("静态页面已经生成到d:/a.html");
		System.out.println("href=\"/");
	
	}*/
	public static void main(String[] args){
	  //截取#之前的字符串
	    String str = "dsdfs#d##";
	   // String substring = str.substring(str.indexOf("s"));
	    String substring = str.substring(str.indexOf(1));
	    System.out.println(substring);
	    //输出的结果为：sdfs
	    //indexOf返回的索引也是从0开始的，所以indexOf("#") = 4。
	    //java中的substring的第一个参数的索引是从0开始，而第二个参数是从1开始
	 
	
	}
	
	
	
	
	
/*	public static void main(String[] args){
		  String encoding = "GBK";
		  try {
			
		    File file = new File("d:/xbc.html");
		    if (file.isFile() && file.exists()) { //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		                new FileInputStream(file), encoding);//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while ((lineTxt = bufferedReader.readLine()) != null) {
		        	String page=lineTxt.replace("src=\"\"", "src=\"http://192.168.0.213/editor/assets/ueditor/formdesign/preview.html?link=1077\"");
		              
		        	System.out.println(page);         
		         }       
		        read.close();
		    } else {
		        System.out.println("找不到指定的文件");
		    }
		} catch (Exception e) {
		    System.out.println("读取文件内容出错");
		    e.printStackTrace();
		}
	}
 
	*/
}
