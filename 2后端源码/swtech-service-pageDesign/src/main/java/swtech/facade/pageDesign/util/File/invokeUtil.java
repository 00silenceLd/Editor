package swtech.facade.pageDesign.util.File;

import com.alibaba.fastjson.JSONArray;

import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.util.FastJsonUtil;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.mortbay.log.Log;

public class invokeUtil {

	
	private static PageDesignDao pageDesignDao = (PageDesignDao) SpringTool.getBean("pageDesignDao");
	private static NodeDao nodeDao = (NodeDao) SpringTool.getBean("nodeDao");

	//根据控件查询表单对象字段
	public static String getParams(String nodeName) {
		String params = null;
		try {
			
			// 查询同名表单
			Node node = nodeDao.getNode(nodeName);
			if (node != null) {
				PageEditor page = pageDesignDao.getByNodeId(node.getId());
				
				if (page.getParse() != null) {
					params = GetDataName.GetDataName(page.getParse());
				} else {
					params = GetDataName.GetDataName(page.getPhoneParse());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return params;
	}
	
	// 执行sql语句
	public static Object invoke(String nodeName, String sql) {
		Object o = null;
		
		try {

			//获取动态类名字
			String[] arr = WriteMapper.writeNodeName(nodeName);
			
			Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
			Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
			Object obj = cls.newInstance();
			Method method = cls.getMethod("getReportForm", new Class[] { String.class });
			o = method.invoke(obj, new Object[] { sql });
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("什么鬼出错了！错误是：" + e.toString());
		}
		return o;
	}

	//查询数据源绑定字段
	public static Object invoke2(String nodeName, String field, String params, String key,Integer contentId,String className) {
		Object o = null;
	
		try {
			
			//获取动态类名字
			String[] arr = WriteMapper.writeNodeName(nodeName);
			//反射获取类
			Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
			Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
			Object obj = cls.newInstance();
			String sql = null;
			
			//绑定外数据库资源
			if(className != null && className.equals("科普资源库")) {
				//拼接高级模糊查询
				if (params != null && key != null) {
					sql = "SELECT science_id," + field + " FROM tb_polular_science where book_examine = 2";
					String[] str = params.split(",");
					for (int i = 0; i < str.length; i++) {
						if(i == 0) {
							sql = sql + " and " + str[i] + " like '%" + key + "%'";
						}else {
							sql = sql + " or " + str[i] + " like '%" + key + "%'";
						}
						Log.info("================此条Sql语句为:===================================="+sql);
					}
				} else if (field != null) {
					sql = "SELECT science_id," + field + " FROM tb_polular_science where book_examine = 2";
					if(contentId != null) {
						sql += " and id = "+contentId;
					}
					Log.info("================此条Sql语句为:===================================="+sql);
				}
				//改为降序
				sql=sql+" order by id desc";
				Log.info("================此时Sql语句为:===================================="+sql);
				Method method = cls.getMethod("getResourceLibrary", new Class[] { String.class });
				List<Map<String, String>> map = (List<Map<String, String>>) method.invoke(obj, new Object[] { sql });
				
				System.out.println("--------结果集:"+map);
				
				return map;
			}else {
				//绑定内数据库资源
				String sw="swprefix";
				String[] s = field.split(",");
				for(int i=0;i<s.length;i++){
					s[i]=sw+s[i];
				}
				field=StringUtils.join(s,",");
				//获取动态类名字
				arr = WriteMapper.writeNodeName(className);
				//反射获取类
				parmetercls = Class.forName(arr[0] + "." + arr[1]);
				cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				obj = cls.newInstance();
				sql = null;
				
				//拼接高级模糊查询
				if (params != null && key != null) {
					
					sql = "SELECT id," + field + " FROM " + arr[0] + " where is_delete = 0";
					String[] str = params.split(",");
					for (int i = 0; i < str.length; i++) {
						if(i == 0) {
							sql = sql + " and " + str[i] + " like '%" + key + "%'";
						}else {
							sql = sql + " or " + str[i] + " like '%" + key + "%'";
						}
					}
					Log.info("================此条Sql语句为:===================================="+sql);
				} else if (field != null) {
					sql = "SELECT id," + field + " FROM " + arr[0] + " where is_delete = 0";
					if(contentId != null) {
						sql += " and id = "+contentId;
					}
					Log.info("================此条Sql语句为:===================================="+sql);
				}
				//改为降序
				sql=sql+" order by id desc";
				Log.info("================此时Sql语句为:===================================="+sql);
				Method method = cls.getMethod("getReportForm", new Class[] { String.class });
				o = method.invoke(obj, new Object[] { sql });
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("什么鬼出错了！错误是：" + e.toString());
		}
		return o;
	}

	//查询关联表单数据
	public static Object invoke3(String nodeName, String field, Long gid) {
		Object o = null;
		String sw="swprefix";
		String[] s = field.split(",");
		for(int i=0;i<s.length;i++){
			s[i]=sw+s[i];
		}
		field=StringUtils.join(s,",");
		try {
			//获取动态类名字
			String[] arr = WriteMapper.writeNodeName(nodeName);
			
			Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
			Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");

			Object obj = cls.newInstance();

			String sql = null;
			if (field != null && gid != null) {
				sql = "SELECT id," + field + " FROM " + arr[0] + " WHERE gid=" + gid + " and is_delete = 0 ORDER BY id DESC";
				Log.info("================此条Sql语句为:===================================="+sql);
			}else {
				sql = "SELECT id," + field + " FROM " + arr[0] + " where is_delete = 0";
				Log.info("================此条Sql语句为:===================================="+sql);
			}
			//改为降序
			sql=sql+" order by id desc";
			Log.info("================此时Sql语句为:===================================="+sql);
			Method method = cls.getMethod("getReportForm", new Class[] { String.class });

			o = method.invoke(obj, new Object[] { sql });
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("什么鬼出错了！错误是：" + e.toString());
		}
		return o;
	}
	
	//更新数据源字段
	public static Object invoke4(String nodeName, String field,Integer id,String value) {
		Object o = null;
		String sw="swprefix";
		String[] s = field.split(",");
		for(int i=0;i<s.length;i++){
			s[i]=sw+s[i];
		}
		field=StringUtils.join(s,",");
		try {
			//获取动态类名字
			String[] arr = WriteMapper.writeNodeName(nodeName);
			
			Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
			Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");

			Object obj = cls.newInstance();
			String sql = null;
			if (field != null) {
				sql = "update " + arr[0] + " set "+field+" = '"+value+"' where id = "+id;
			}
			Method method = cls.getMethod("getReportForm", new Class[] { String.class });
			o = method.invoke(obj, new Object[] { sql });

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("什么鬼出错了！错误是：" + e.toString());
		}
		return o;
	}
	
	public static String toString(Object o, String field, String className) {
		JSONArray jsonArr = new JSONArray();
		Map<String, Object> map = new HashMap();
		if(className!= null && className.equals("科普资源库")) {
			
			List<Map<String, String>> mapList = (List<Map<String, String>>) o;
			for (int i = 0; i < mapList.size(); i++) {
				map = new HashMap();
				map.put(field, mapList.get(i).get(field));
				jsonArr.add(map);
			}
			
		}else {
			String sw="swprefix";
			String[] s = field.split(",");
			for(int i=0;i<s.length;i++){
				s[i]=sw+s[i];
			}
			field=StringUtils.join(s,",");
			List<Object> list1 = (List) o;
			Object obj = null;
			String str = null;
			Integer id = null;
			String createTimes = null;
			if (list1 != null) {
				for (int j = 0; j < list1.size(); j++) {
					map = new HashMap();
					obj = new Object();
					obj = list1.get(j);
					str = new String();
					if (getFieldValueByName(field, obj) == null) {
						str = "";
					} else {
						str = getFieldValueByName(field, obj).toString();
						if (getFieldValueByName("id", obj) != null) {
							id = Integer.valueOf(getFieldValueByName("id", obj).toString());
						}
					}
					map.put(field.replace("swprefix", ""), str);
					if (id != null) {
						map.put("id", id);
					}
					jsonArr.add(map);
				}
			}
		}
		
		return jsonArr.toString();
	}

	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}

	public static String pinyiToClassName(String className) {
		className = Pinyin4jUtil.toPinyin(className);
		className = captureName(className.toLowerCase());

		return className;
	}

	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[0]);
			return method.invoke(o, new Object[0]);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

	private static String reg = "(?:')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(update|union|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
	private static Pattern sqlPattern = Pattern.compile(reg, 2);

	private static boolean isValid(String str) {
		if (sqlPattern.matcher(str).find()) {
			System.out.println("未能通过过滤器：str=" + str);
			return false;
		}
		return true;
	}
	
}
