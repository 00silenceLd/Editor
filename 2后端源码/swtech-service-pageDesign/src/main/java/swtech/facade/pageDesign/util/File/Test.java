package swtech.facade.pageDesign.util.File;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月20日 下午5:48:50 
 *
 * short转boolean
 *
 */

public class Test {
		
	public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
	   /*String arr = "[\"姓名\",\"复选框\",\"出生日期\",\"参加工作年份\",\"连续工龄（年）\",\"缴费年限\",\"退休时间\",\"退休说明\"]";
	   String obj = "{\"checkboxs_1\":1,\"data1\":1,\"data4\":1,\"data5\":1,\"data6\":1,\"data7\":1,\"data8\":1,\"data9\":1}";
	
	   JSONArray array = JSONArray.parseArray(arr);
	   System.out.println(array);
	   JSONObject object = JSONObject.parseObject(obj);
	   System.out.println(object);*/
       /*JSONObject json3 = new JSONObject();
       json3.put("expanded", "fa fa-caret-down");
       json3.put("collapsed", "fa fa-caret-right");
       json3.put("empty", "fa fa-caret-right disabled");
       json3.put("leaf", "fa");
       JSONObject json2 = new JSONObject(); 
       json2.put("cssClasses", json3);
       
       JSONObject json5 = new JSONObject();
       json5.put("node", "<i class=\"fa fa-folder-o\"></i>");
       json5.put("leaf", "<i class=\"fa fa-file-o\"></i>");
       JSONObject json4 = new JSONObject(); 
       json4.put("templates", json5);
       
       JSONObject jsonObj = new JSONObject();
       jsonObj.putAll(json4);
       jsonObj.putAll(json2);
       
       System.out.println(jsonObj);*/
		
		
		//Object o = "[Jarjar [Hash = 1472104135, isDelete=null, data1=1, data2=null, gid=null, assignee=null, taskid=null, processinsid=null, processdefid=null, userid=null, other=null, deploymentid=null, username=null, updateTime=null, serialVersionUID=1], Jarjar [Hash = 1375214633, isDelete=null, data1=2, data2=null, gid=null, assignee=null, taskid=null, processinsid=null, processdefid=null, userid=null, other=null, deploymentid=null, username=null, updateTime=null, serialVersionUID=1], Jarjar [Hash = 1081811626, isDelete=null, data1=3, data2=null, gid=null, assignee=null, taskid=null, processinsid=null, processdefid=null, userid=null, other=null, deploymentid=null, username=null, updateTime=null, serialVersionUID=1], Jarjar [Hash = 788408619, isDelete=null, data1=4, data2=null, gid=null, assignee=null, taskid=null, processinsid=null, processdefid=null, userid=null, other=null, deploymentid=null, username=null, updateTime=null, serialVersionUID=1]]";
		
	
		//JSONArray json = JSONArray.parseArray(o.toString());
		//JSONObject json = JSONObject.parseObject(o.toString());
		
		/*JSONObject jsonObject = JSONObject.parseObject("{\"data1\":1,\"data2\":1,\"data3\":1,\"data4\":1}");
		System.out.println(jsonObject.toString());

		LinkedHashMap<String, String> jsonMap = JSON.parseObject(jsonObject.toString(),
				new TypeReference<LinkedHashMap<String, String>>() {
				});
		for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}*/
		
		String str = "<table data-sort=\"sortDisabled\"><tbody><tr class=\"firstRow\"><td valign=\"top\" rowspan=\"1\" colspan=\"10\" style=\"word-break: break-all;\">&nbsp;{data1}&nbsp; &nbsp;高级搜索</td></tr><tr><td valign=\"top\" rowspan=\"1\" colspan=\"10\" style=\"word-break: break-all;\">&nbsp;<span style=\"color: rgb(84, 141, 212);\">精品</span>&nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; &nbsp; 推荐&nbsp; &nbsp; &nbsp; &nbsp;|&nbsp; &nbsp; &nbsp;&nbsp;已读&nbsp; &nbsp; &nbsp; &nbsp; |&nbsp; &nbsp; &nbsp;收藏<br/></td></tr><tr><td rowspan=\"1\" colspan=\"10\" style=\"word-break: break-all;\"><div class=\"wifiblock\" orgurl=\"http://www.1388w.cn/editor/assets/ueditor/formdesign/preview.html?link=\" name=\"leipiNewField\" leipiplugins=\"wifiblock\" orgthide=\"1\" value=\"\" title=\"请输入内容\" orgalign=\"left\" orgheight=\"150\" orgwidth=\"auto\" orgfonts=\"\" orgborder=\"1px solid\" orgcolor=\"#000000\" orgradius=\"1\" style=\"display:block; border:1px solid #000000;border-radius:1px; text-align:left;width:autopx;height:150px;font-size:px;\"><p>{data2}</p><p>{data3}</p><p>{data4}</p><p>{data5}</p><p>{data6}</p></div><p><br/></p><span style=\"color: rgb(146, 146, 146); font-family: BlinkMacSystemFont, &quot;Helvetica Neue&quot;, Arial, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Pingfang SC&quot;, sans-serif; font-size: 12px; white-space: pre-wrap; background-color: rgb(255, 255, 255);\"><br/></span><span style=\"color: rgb(146, 146, 146); font-family: BlinkMacSystemFont, &quot;Helvetica Neue&quot;, Arial, &quot;Microsoft Yahei&quot;, &quot;WenQuanYi Micro Hei&quot;, &quot;Pingfang SC&quot;, sans-serif; font-size: 12px; white-space: pre-wrap; background-color: rgb(255, 255, 255);\"></span></td></tr><tr><td style=\"word-break: break-all;\" rowspan=\"1\" colspan=\"10\"><p>&nbsp; &nbsp;&nbsp;<img src=\"http://1388w.cn:8888/swpt_2/ueditor/jsp/upload/image/1516354973111xuexi.png\" title=\"xuexi.png\" alt=\"xuexi.png\" width=\"28\" height=\"28\" border=\"0\" vspace=\"0\" style=\"width: 28px; height: 28px;\"/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://1388w.cn:8888/swpt_2/ueditor/jsp/upload/image/1516355647833ziyuank.png\" title=\"ziyuank.png\" alt=\"ziyuank.png\" width=\"24\" height=\"24\" border=\"0\" vspace=\"0\" style=\"width: 24px; height: 24px;\"/>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<img src=\"http://1388w.cn:8888/swpt_2/ueditor/jsp/upload/image/1516353340336wangzhan.png\" title=\"wangzhan.png\" alt=\"wangzhan.png\" width=\"28\" height=\"24\" border=\"0\" vspace=\"0\" style=\"width: 28px; height: 24px;\"/>&nbsp; &nbsp; &nbsp; &nbsp;<img src=\"http://1388w.cn:8888/swpt_2/ueditor/jsp/upload/image/1516352256244xiaoxijieshou.png\" title=\"xiaoxijieshou.png\" alt=\"xiaoxijieshou.png\" width=\"30\" height=\"30\" border=\"0\" vspace=\"0\" style=\"width: 30px; height: 30px;\"/>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<img src=\"http://1388w.cn:8888/swpt_2/ueditor/jsp/upload/image/1516355784193me.png\" title=\"me.png\" alt=\"me.png\" width=\"24\" height=\"24\" border=\"0\" vspace=\"0\" style=\"width: 24px; height: 24px;\"/></p><p>&nbsp; &nbsp;<span style=\"color: rgb(84, 141, 212);\">学习</span>&nbsp; &nbsp; &nbsp; &nbsp;资源库&nbsp; &nbsp; &nbsp; &nbsp;发现&nbsp; &nbsp; &nbsp; &nbsp;圈子&nbsp; &nbsp; &nbsp; 我的</p></td></tr></tbody></table><p><br/></p>";
		System.out.println(str = str.substring(str.indexOf("<div class=\"wifiblock\"")));
		System.out.println(str = str.substring(0,str.indexOf("</div>")));
		str = GetDataName.GetDataName(str);
		System.out.println("----"+str);
	}
	
	

	//首字母大写
	public static String captureName(String name) {
		// name = name.substring(0, 1).toUpperCase() + name.substring(1);
		// return name;
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	
	public static Date getTime(Date date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		return sdf.parse(sdf.format(date));
	}
	
	//String 逗号分隔 转int数组
		public static int[] StringtoInt(String str) {

			int ret[] = new int[str.length()];
			StringTokenizer toKenizer = new StringTokenizer(str, ",");
			int i = 0;
			while (toKenizer.hasMoreElements()) {
				ret[i++] = Integer.valueOf(toKenizer.nextToken());
			}
			return ret;
			
		}
		

	// 删除指定文件夹下所有文件
	// param path 文件夹完整绝对路径
	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				flag = true;
			}
		}
		return flag;
	}
	
	
	/** 
     * 通过对象得到所有的该对象所有定义的属性值 
     * @param obj 目标对象 
     */  
    public static void method(Object obj){  
       try{  
           Class clazz = obj.getClass();  
           Field[] fields = obj.getClass().getDeclaredFields();//获得属性  
           for (Field field : fields) {  
               PropertyDescriptor pd = new PropertyDescriptor(field.getName(),clazz);  
               Method getMethod = pd.getReadMethod();//获得get方法  
               Object o = getMethod.invoke(obj);//执行get方法返回一个Object  
               System.out.println(o);  
           }  
       }catch (Exception e) {  
           e.printStackTrace();  
       }   
     }  
      
    /** 
     * 通过对象和具体的字段名字获得字段的值 
     * @param obj 目的对象 
     * @param filed 字段名 
     * @return 通过字段名得到字段值 
     */  
    public static Object method(Object obj,String filed)   {  
       try {  
           Class clazz = obj.getClass();  
           PropertyDescriptor pd = new PropertyDescriptor(filed,clazz);  
           Method getMethod = pd.getReadMethod();//获得get方法  
           Object o = getMethod.invoke(obj);//执行get方法返回一个Object  
           return o;  
       }catch (Exception e) {  
           e.printStackTrace();  
           return null;  
       }   
     }  

}
 