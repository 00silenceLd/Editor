package swtech.common.config.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import com.alibaba.fastjson.JSONObject;

import swtech.common.config.constants.HostConstants;

public class FileUtil {

	//读取config.json 配置文件
	@SuppressWarnings("resource")
	public static String getKey(String field) {
		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();
		String result = null;
		try {
			//读取文件流
			reader = new BufferedReader(new FileReader(HostConstants.CONFIG_PATH));
//			System.out.println("config.json文件的动态地址====="+PathUtils.NEW_PATH+"/config.json");
			String tempString = null;
			//一行一行读取
			while ((tempString = reader.readLine()) != null) {
				//拼接字符串
				sb.append(tempString+"\n");
			}
			//将文件内容转为json对象
			JSONObject json = JSONObject.parseObject(sb.toString());
			//获取json键值对某个属性
			result = json.get(field).toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
