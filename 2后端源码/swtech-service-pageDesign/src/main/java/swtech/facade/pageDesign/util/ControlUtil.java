package swtech.facade.pageDesign.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import swtech.common.config.constants.HostConstants;

/**
 * 
 * @description : 控件权限工具类
 * ---------------------------------
 * @Author : ZhaoQingSen
 * @since : Create in 2018年3月3日 上午11:32:32
 *
 */
public class ControlUtil {
	/**
	 * 此方法根据控件权限，生成动态js
	 * param:html文本
	 * @return 添加js后的html文本
	 * @throws FileNotFoundException 
	 */
	public static StringBuilder createControlMain(String record,List<String> list,int nodeid) throws FileNotFoundException{
		 StringBuilder sb = new StringBuilder();
		  //int uid=123746;
		 /* sb.append("<script src=\"jquery-1.12.4.js\"></script>");
		  sb.append("<script type=\"text/javascript\">");*/
		  sb.append(" $(document).ready(function(){");
		  sb.append("var user;");
		  sb.append("var uid;");
		  sb.append("if (window.localStorage.getItem('user') !== null) {");
		  sb.append("user = JSON.parse(window.localStorage.getItem('user'));");
		  sb.append("}");
		  sb.append("if(user==null){");
		  sb.append("alert(\"对不起，请先登录后访问\");");
		  sb.append("location.href=\"http://192.168.0.213/login2/#!/index\"");
		  sb.append("}else{");
		  sb.append("uid=user.id;");
		  sb.append(" $.ajax({");
		  sb.append(" type: \"GET\",");
		  sb.append("url: \"http://192.168.0.213:20896/htUserService/selectByPositionId?uid=\"+uid,");
		  sb.append("success: function (data) {");
		  sb.append("if (data.msg==null) {");
		  for (String str : list) {          
			  StringBuilder strcontrol=ControlUtil.equalControl(str);
	          sb.append(strcontrol);
		  }
		  sb.append(" }else{ ");
		  sb.append("roleid=data.msg;");
	      sb.append("var nodeid=");
	      sb.append(nodeid);
	      sb.append(";");
	      sb.append("var jsondata={\"roleid\":roleid,\"nodeid\":nodeid};");
	      sb.append("$.ajax({");
	      sb.append(" type: \"POST\",");
          sb.append(" url: \"http://192.168.0.213:20896/htPageEditorService/getSecurity\",");
          sb.append("data: JSON.stringify(jsondata),");
          sb.append("contentType: \"application/json;charset=utf-8;\",");
          sb.append("dataType: \"json\",");
          sb.append(" success: function (data) {");
          sb.append(" for (i in data.msg) {");
		  for (String str : list) {          
			  StringBuilder strcontrol=ControlUtil.equalControl1(str);
	          sb.append(strcontrol);
		  }                
	      //for
          sb.append(" } ");
	      //内success
          sb.append(" } ");
	      //内ajax
	      sb.append(" }) ");
		  //外else
		  sb.append(" } ");
		  //外success
		  sb.append(" } ");
		  //外ajax
		  sb.append(" }) ");
		  //user else
		  sb.append("}");
		  //doucument
		  sb.append(" });");
		 /* sb.append("</script>");*/
		  //把js保存到服务器
		  //文件夹
		  String fileDir ="/usr/local/nginx/html/editor/assets/ueditor/formdesign/";
		  String fileName="conaction.js";	
		  //如果文件存在，先删除
  	      ControlUtil.existsDelete(fileDir, fileName);
		  String filePath ="/usr/local/nginx/html/editor/assets/ueditor/formdesign/conaction.js";
		  File file = new File(filePath);
		  FileOutputStream fos=new FileOutputStream(file);
		  try {
			fos.write(sb.toString().getBytes());
			//关闭
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  StringBuilder strjs=new StringBuilder();
		  strjs.append("<script src=\"jquery-1.12.4.js\"></script>");
		  strjs.append("<script src=\"conaction.js\"></script>");
		 StringBuilder str=ControlUtil.addString(record,strjs.toString());
		 return str;
	}
	
	//dirPath 文件夹路径,fileName 文件名
	public static void existsDelete(String dirPath,String fileName) {
	File pathFile = new File(dirPath);
	 if(!pathFile.exists() || pathFile.isFile()) {
	   return;
	  }
	   for(File file:pathFile.listFiles()) {
	   if(file.isFile() && fileName.equals(file.getName())) {
	   file.delete();
	   break;
	   }
	 }
	}
	/**
	 * 根据匹配字符串，在指定位置插入字符串
	 * @param html 匹配字符串
	 * @param newhtml 需要插入字符串
	 * @return
	 */
	public static StringBuilder addString(String html,String newhtml ){
		  int count=html.indexOf("head");
	      StringBuilder sb = new StringBuilder(html);//构造一个StringBuilder对象
	      sb.insert(count+5, newhtml);
		  return sb;
	}
	/**
	 * 生成没有加入组织动态js
	 */
	public static StringBuilder equalControl(String action){
		 StringBuilder sb = new StringBuilder();
		 switch(action){
			 case "wenbenkuang":
				  sb.append(" $(\"input[name='wenbenkuang']\").hide();");
				 break;
			case "duoxingwenbenkuang":
				  sb.append(" $(\"textarea[name='duoxingwenbenkuang']\").hide();");			  
				 break;
		 }
		return sb;
	}
	/**
	 * 生成加入组织动态js
	 */
	public static StringBuilder equalControl1(String action){
		 StringBuilder sb = new StringBuilder();
		 switch(action){
			 case "wenbenkuang":
				  sb.append(" if(\"wenbenkuang\"==data.msg[i].name){");
				  sb.append(" if(\"xy\"==data.msg[i].term){");
				  sb.append("$(\"input[name='wenbenkuang']\").hide();");
				  sb.append(" }");
				  sb.append(" }");
				 break;
			case "duoxingwenbenkuang":
				  sb.append(" if(\"duoxingwenbenkuang\"==data.msg[i].name){");
				  sb.append("if(\"xy\"==data.msg[i].term){");
				  sb.append("$(\"textarea[name='duoxingwenbenkuang']\").hide();");
				  sb.append(" }");
				  sb.append(" }");		  
				 break;
		 }
		return sb;
	}
}
