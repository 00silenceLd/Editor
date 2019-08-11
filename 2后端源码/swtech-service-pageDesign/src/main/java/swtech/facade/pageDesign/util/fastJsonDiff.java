package swtech.facade.pageDesign.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
 
public class fastJsonDiff {
    /**
     * 递归读取所有的key
     *
     * @param jsonObject
     */
    public static StringBuffer getAllKey(JSONObject jsonObject) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator<String> keys = jsonObject.keySet().iterator();// jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            stringBuffer.append(key.toString()).append(",");
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject innerObject = (JSONObject) jsonObject.get(key);
                stringBuffer.append(getAllKey(innerObject));
            } else if (jsonObject.get(key) instanceof JSONArray) {
                JSONArray innerObject = (JSONArray) jsonObject.get(key);
                stringBuffer.append(getAllKey(innerObject));
            }
        }
        return stringBuffer;
    }
 
    public static StringBuffer getAllKey(JSONArray json1) {
        StringBuffer stringBuffer = new StringBuffer();
        if (json1 != null ) {
            Iterator i1 = json1.iterator();
            while (i1.hasNext()) {
                Object key = i1.next();
                if (key instanceof  JSONObject) {
                    JSONObject innerObject = (JSONObject) key;
                    stringBuffer.append(getAllKey(innerObject));
                } else if (key instanceof JSONArray) {
                    JSONArray innerObject = (JSONArray) key;
                    stringBuffer.append(getAllKey(innerObject));
                }else{
                }
            }
        }
        return stringBuffer;
    }
 
    private final static String st1 = "{\"username\":\"tom\",\"age\":18,\"address\":[{\"province\":\"上海市\"},{\"city\":\"上海市\"},{\"disrtict\":\"静安区\"}]}";
    private final static String st2 = "[\"\"日期控件z1,./?\",\"日期控件\",\"日期控件\"]";
 
    public static void main(String[] args) {
       System.out.println(st2);
       /* JSONObject jsonObject1 = JSONObject.parseObject(st2);
        StringBuffer stb = getAllKey(jsonObject1);
        System.out.println(stb);*/
     /*  JSONArray ar=new JSONArray();
       ar= JSONArray.parseArray(st2);
       List list=new ArrayList();
       for (int i = 0; i < ar.size(); i++) {
		list.add(ar.get(i));
	}*/  
       
        String newselected = "1,2,3";
       String title = "a,b,c";;
    
       String[] newSelected = newselected.split(",");
	  List<String> selectedList = Arrays.asList(newSelected);
	  String[] titleSplit = title.split(",");
	  List<String> titleList = Arrays.asList(titleSplit);
	  String comparativeStudy="";
	  for (int i = 0; i < selectedList.size(); i++) {
			String str1= selectedList.get(i);
			String str2 = titleList.get(i);
			comparativeStudy+=str1+":"+str2+",";
		}
       String str=st2.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+","");
       System.out.println(comparativeStudy);
 
    }
 
}
