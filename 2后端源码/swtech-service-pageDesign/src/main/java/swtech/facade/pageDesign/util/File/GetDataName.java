package swtech.facade.pageDesign.util.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月29日 下午4:45:39 
 *
 * 获取数据名字
 *
 */

public class GetDataName {

	public static String GetDataName(String str) {
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile("\\{([^\\}]+)\\}");
		Matcher m = p.matcher(str);
		while(m.find()){ 
	            String t = m.group(1); 
	            t.replace("{","");
	            t.replace("}", "");
	            sb.append(t.trim()+",");
	            //System.out.println(sb); 
	    }
		return sb.toString();
	}
	
	
	public static String getWifiblock(String str) {
		str = str.substring(str.indexOf("<div class=\"wifiblock\""));
		str = str.substring(0,str.indexOf("</div>"));
		str = GetDataName.GetDataName(str);
		
		return str;
	}
}
 