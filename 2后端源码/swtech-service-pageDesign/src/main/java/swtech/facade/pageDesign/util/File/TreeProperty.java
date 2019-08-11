package swtech.facade.pageDesign.util.File;

import com.alibaba.fastjson.JSONObject;

/** 
*
* @author 林致杰
*
* @Email: 1003392067@qq.com
*
* @version 创建时间：2018年1月17日 下午3:26:28 
*
* 树形属性赋值
*/
public class TreeProperty {

	public static JSONObject getParentIdTree() {
		JSONObject json3 = new JSONObject();
	       json3.put("expanded", "fa fa-caret-down");
	       json3.put("collapsed", "fa fa-caret-right");
	       json3.put("empty", "fa fa-caret-right disabled");
	       json3.put("leaf", "fa");
	       JSONObject json2 = new JSONObject(); 
	       json2.put("cssClasses", json3);
	       
	      /* JSONObject json5 = new JSONObject();
	       json5.put("node", "<i class=\"fa fa-folder-o\"></i>");
	       json5.put("leaf", "<i class=\"fa fa-file-o\"></i>");
	       JSONObject json4 = new JSONObject(); 
	       json4.put("templates", json5);*/
	       
	       JSONObject jsonObj = new JSONObject();
	       //jsonObj.putAll(json4);
	       jsonObj.putAll(json2);	       
		return jsonObj;
	}
	
	public static JSONObject getParentIdTreeByNodeType(int Node_type,boolean bool,Integer isPopularize) {
	    JSONObject json3 = new JSONObject();
	    String homePage = "<i class='fa fa-sitemap'></i>";
	    if (7 == Node_type) {
	    	if(bool){
	    		json3.put("node", "<i class='fa fa-desktop'></i> "+homePage);
	    	}else{
	    		json3.put("node", "<i class='fa fa-desktop'></i>");
	    	}
	    	
	    }else if (8 == Node_type) {	
	    	if(bool){
	    		json3.put("node", "<i class='fa fa-tablet'></i> "+homePage);
	    	}else{
	    		json3.put("node", "<i class='fa fa-tablet'></i>");
	    	}
	    }else{
	    	//首页
	    	json3.put("node", homePage);
	    }
      /*  json3.put("leaf", "<i class='fa fa-file-o'></i>");*/
        
	    
	    //如果为推广页,曾
	    if(isPopularize==0) {
	    	if(bool){
	    		json3.put("node", "<i class='fa fa-adn'></i> "+homePage);
	    	}else{
	    		json3.put("node", "<i class='fa fa-adn'></i>");
	    	}
	    }
	    
	    
	    
	       
		return json3;
	}
	
}
 