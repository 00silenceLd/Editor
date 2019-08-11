package swtech.facade.pageDesign.util.File;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.util.JSONTokener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年11月17日 上午11:08:20 
 *
 * Json分析是数组还是字符串
 *
 */

public class JsonToken {

	//单条数据传回 falase
	//数组传回true
	public static boolean jsonToken(String record) {
		
		JSONObject jsonObject = JSONObject.parseObject(record);
		String str = jsonObject.getString("record");
		
		char[] strChar = str.substring(0, 1).toCharArray();
		if (strChar[0] == '[') {
			return true;
		} else if (strChar[0] == '{') {
			return false;
		}
		return false;
	}
}
 