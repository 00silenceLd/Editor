package swtech.facade.pageDesign.util; 
/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 资源库集合
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年5月17日 上午11:43:33
 **/

import java.util.HashMap;
import java.util.Map;

public class resourceLibraryCollection {

	/**
	 * 获取科普资源字段
	 * */
	public static Map<String, Object> getKePu(){
		
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> maps = new HashMap<String, Object>();
		map.put("text", "封面图片");
		map.put("value", "cover_photo");
		maps.put("1", map);
		map = new HashMap<String, Object>();
		map.put("text", "书籍名称");
		map.put("value", "book_name");
		maps.put("2", map);
		map = new HashMap<String, Object>();
		map.put("text", "书籍作者");
		map.put("value", "book_author");
		maps.put("3", map);
		map = new HashMap<String, Object>();
		map.put("text", "书籍出版社");
		map.put("value", "book_press");
		maps.put("4", map);
		map = new HashMap<String, Object>();
		map.put("text", "书籍编号/条形码");
		map.put("value", "book_ibsn");
		maps.put("5", map);
		map = new HashMap<String, Object>();
		map.put("text", "推荐理由");
		map.put("value", "recommended_reasons");
		maps.put("6", map);
		map = new HashMap<String, Object>();
		map.put("text", "书籍简介");
		map.put("value", "brief_introduction");
		maps.put("7", map);
		map = new HashMap<String, Object>();
		map.put("text", "收费价格");
		map.put("value", "charge_price");
		maps.put("8", map);
		map = new HashMap<String, Object>();
		map.put("text", "创建时间");
		map.put("value", "upload_time");
		maps.put("9", map);
		return maps;
	}
	public static Map<String, Object> getKuPuVideo(){
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> maps=new HashMap<String, Object>();
		map.put("text", "视频名称");
		map.put("value", "name");
		maps.put("1", map);
		map = new HashMap<String, Object>();
		map.put("text", "视频图片");
		map.put("value", "pic");
		maps.put("2", map);
		map = new HashMap<String, Object>();
		map.put("text", "视频URL");
		map.put("value", "url");
		maps.put("3", map);
		map = new HashMap<String, Object>();
		map.put("text", "视频类型");
		map.put("value", "ftype");
		maps.put("4", map);
		map = new HashMap<String, Object>();
		map.put("text", "视频所属年级");
		map.put("value", "grade");
		maps.put("5", map);
		map = new HashMap<String, Object>();
		map.put("text", "年级描述");
		map.put("value", "grade_desc");
		maps.put("6", map);
		map = new HashMap<String, Object>();
		map.put("text", "点赞次数");
		map.put("value", "praise_cnt");
		maps.put("7", map);
		map = new HashMap<String, Object>();
		map.put("text", "被浏览次数");
		map.put("value", "browse_cnt");
		maps.put("8", map);
		map = new HashMap<String, Object>();
		map.put("text", "是否为推荐视频");
		map.put("value", "is_recommend");
		maps.put("9", map);
		map = new HashMap<String, Object>();
		map.put("text", "该资源是否来自科普，0：是，1：不是");
		map.put("value", "is_from_kp");
		maps.put("10", map);
		map = new HashMap<String, Object>();
		map.put("text", "创建时间");
		map.put("value", "create_time");
		maps.put("11", map);
		map = new HashMap<String, Object>();
		map.put("text", "更新时间");
		map.put("value", "last_update_time");
		maps.put("12", map);
		
		return maps;
		
	}
	public static Map<String,Object> getPaiCourse(){
		Map<String,Object> map=new HashMap<String, Object>();
		Map<String,Object> maps=new HashMap<String, Object>();
		map.put("value", "applicant");
		map.put("text", "申请人");
		maps.put("1", map);
		map=new HashMap<String, Object>();
		map.put("value", "createTime");
		map.put("text", "排课时间");
		maps.put("2", map);
		map=new HashMap<String, Object>();
		map.put("value", "attendTime");
		map.put("text", "上课时段");
		maps.put("3", map);
		map=new HashMap<String, Object>();
		map.put("value", "className");
		map.put("text", "班级");
		maps.put("4", map);
		map=new HashMap<String, Object>();
		map.put("value", "subject");
		map.put("text", "学习科目");
		maps.put("5", map);
		map=new HashMap<String, Object>();
		map.put("value", "teacher");
		map.put("text", "任课老师");
		maps.put("6", map);
		map=new HashMap<String, Object>();
		map.put("value", "teachingmethods");
		map.put("text", "授课方式");
		maps.put("7", map);
		map=new HashMap<String, Object>();
		map.put("value", "classroom");
		map.put("text", "申请教室");
		maps.put("8", map);
		map=new HashMap<String, Object>();
		map.put("value", "result");
		map.put("text", "提交状态");
		maps.put("9", map);
		map=new HashMap<String, Object>();
		map.put("value", "status");
		map.put("text", "审核状态");
		maps.put("10", map);
		return maps;
		
	}
}
 