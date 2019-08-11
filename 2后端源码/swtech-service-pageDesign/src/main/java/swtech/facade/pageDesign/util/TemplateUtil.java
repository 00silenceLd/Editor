package swtech.facade.pageDesign.util;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @描述 模板类
 * @author Administrator
 *
 */
public class TemplateUtil {

	

	/*
	 * 模版IDaWD5uE-BdVEeXB6C2ajMa190KIKN_NBcv9wWODcbd20 开发者调用模版消息接口时需提供模版ID
	 * 标题课程开课通知 行业教育 - 培训 详细内容 您好，{{userName.DATA}}。
	 * 
	 * 您报名参加的{{courseName.DATA}}将于{{date.DATA}}开课，特此通知。 {{remark.DATA}}
	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例 您好，kantzou。
	 * 
	 * 您报名参加的会计认证课程将于2013年10月9日开课，特此通知。 想了解课程安排，可回复1 想了解师资详情，可回复2 想了解更多课程，可回复3
	 * 感谢您对微信学校的支持。
	 */

//	/**
//	 * 开课通知
//	 * 
//	 * @return
//	 */
//	public static JSONObject classBiginTemplate(Map map) {
//		JSONObject json = new JSONObject();
//		
//		json.put("touser", "");
//		json.put("template_id", "aWD5uE-BdVEeXB6C2ajMa190KIKN_NBcv9wWODcbd20");
//		json.put("url", "http://htjy.kz38.cn");
//		JSONObject data = new JSONObject();
//
//		JSONObject userName = new JSONObject();
//		
//		userName.put("value","");
//		userName.put("color", "#173177");
//		data.put("userName", userName);
//
//		JSONObject courseName = new JSONObject();
//		courseName.put("value", map.get("data2"));
//		courseName.put("color", "#173177");
//		data.put("courseName", courseName);
//
//		JSONObject date = new JSONObject();
//		date.put("value", map.get("data5"));
//		date.put("color", "#173177");
//		data.put("date", date);
//
//		JSONObject remark = new JSONObject();
//		remark.put("value", map.get("data3"));
//		remark.put("color", "#173177");
//		data.put("remark", remark);
//
//		json.put("data", data);
//		return json;
//	}
//
//	/*
//	 * 模版IDSGHH8vFGuErQWPJrumjE8M9BIpMxnJI4f83eJA_Amqc 开发者调用模版消息接口时需提供模版ID
//	 * 标题作业提醒 行业教育 - 培训 详细内容 
//	 * {{first.DATA}} 
//	 * 时间：{{keyword1.DATA}}
//	 * 科目：{{keyword2.DATA}} 
//	 * 作业简介：{{keyword3.DATA}} 
//	 * 作业详情：{{keyword4.DATA}}
//	 * {{remark.DATA}} 
//	 * 
//	 * {data2} 
//	 * 时间：{data3}
//	 * 科目：{data4} 
//	 * 作业简介：{data5} 
//	 * 作业详情：{data6}
//	 * {data7} 
//	 * 
//	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例
//	 * 您好，您有新的作业已发布，请查收。 时间：2014年9月24日 18:00 科目：数学 作业简介：数学第三章课后作业练习
//	 * 作业详情：请大家将数学课本68页面，课后作业3，6，7，8题作业完成，明早上交。 感谢您的查阅，请认真对待，按时完成作业。
//	 */
//
//	/**
//	 * 作业提醒
//	 * 
//	 * @return
//	 */
//	public static JSONObject homeWorkTemplate(Map map) {
//		JSONObject json = new JSONObject();
//
//		json.put("touser", "");
//		json.put("template_id", "SGHH8vFGuErQWPJrumjE8M9BIpMxnJI4f83eJA_Amqc");
//		json.put("url", "http://htjy.kz38.cn");
//		JSONObject data = new JSONObject();
//
//		JSONObject first = new JSONObject();
//		first.put("value", map.get("data2"));
//		first.put("color", "#173177");
//		data.put("first", first);
//
//		JSONObject keyword1 = new JSONObject();
//		keyword1.put("value", map.get("data3"));
//		keyword1.put("color", "#173177");
//		data.put("keyword1", keyword1);
//
//		JSONObject keyword2 = new JSONObject();
//		keyword2.put("value", map.get("data4"));
//		keyword2.put("color", "#173177");
//		data.put("keyword2", keyword2);
//
//		JSONObject keyword3 = new JSONObject();
//		keyword3.put("value", map.get("data5"));
//		keyword3.put("color", "#173177");
//		data.put("keyword3", keyword3);
//
//		JSONObject keyword4 = new JSONObject();
//		keyword4.put("value", map.get("data6"));
//		keyword4.put("color", "#173177");
//		data.put("keyword4", keyword4);
//
//		JSONObject remark = new JSONObject();
//		remark.put("value", map.get("data7"));
//		remark.put("color", "#173177");
//		data.put("remark", remark);
//
//		json.put("data", data);
//		return json;
//	}
//
//	/*
//	 * 模版IDf3L9h2NylVx8UgvVJs5y7_RbzjqH1ZAxGTy0Qs9plBM 开发者调用模版消息接口时需提供模版ID
//	 * 标题请假通知 行业教育 - 培训 详细内容 {{first.DATA}} 请假人：{{keyword1.DATA}}
//	 * 请假时间：{{keyword2.DATA}} 请假事由：{{keyword3.DATA}} {{remark.DATA}}
//	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例 王老师您好，您的班级【荔枝班】有同学请假。
//	 * 
//	 *  {data2} 
//	 *  请假人：{data3}
//	 *  请假时间：{data4}
//	 *  请假事由：{data5} 
//	 *  {data6}
//	 * 
//	 * 请假人：张小小 请假时间：9月1日-9月2日 两天 请假事由：病假，医生说要在家休息两天 请您及时查看并审批。
//	 */
//	
//	/**
//	 * 请假通知
//	 * 
//	 * @return
//	 */
//	public static JSONObject leaveTemplate(Map map) {
//		JSONObject json = new JSONObject();
//
//		json.put("touser", "");
//		json.put("template_id", "f3L9h2NylVx8UgvVJs5y7_RbzjqH1ZAxGTy0Qs9plBM");
//		json.put("url", "http://htjy.kz38.cn");
//		JSONObject data = new JSONObject();
//
//		JSONObject first = new JSONObject();
//		first.put("value", map.get("data2"));
//		first.put("color", "#173177");
//		data.put("first", first);
//
//		JSONObject keyword1 = new JSONObject();
//		keyword1.put("value", map.get("data3"));
//		keyword1.put("color", "#173177");
//		data.put("keyword1", keyword1);
//
//		JSONObject keyword2 = new JSONObject();
//		keyword2.put("value", map.get("data4"));
//		keyword2.put("color", "#173177");
//		data.put("keyword2", keyword2);
//
//		JSONObject keyword3 = new JSONObject();
//		keyword3.put("value", map.get("data5"));
//		keyword3.put("color", "#173177");
//		data.put("keyword3", keyword3);
//
//		JSONObject remark = new JSONObject();
//		remark.put("value", map.get("data6"));
//		remark.put("color", "#173177");
//		data.put("remark", remark);
//
//		json.put("data", data);
//		return json;
//	}
//	
//	/*{{first.DATA}}
//	教师姓名：{{keyword1.DATA}}
//	手机号码：{{keyword2.DATA}}
//	辅导科目：{{keyword3.DATA}}
//	安排日期：{{keyword4.DATA}}
//	{{remark.DATA}}
//	在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息
//	
//	{data2}
//	教师姓名：{data3}
//	手机号码：{data4}
//	辅导科目：{data5}
//	安排日期：{data6}
//	{data8}
//	
//	尊敬的家长，平台已为您孩子安排了老师。
//	教师姓名：刘兆云
//	手机号码：12345678
//	辅导科目：初二物理
//	安排日期：2018-01-23
//	如有疑问，请您致电：12345678。感谢您的支持！
//	yC7JJb5Ut25Va8U7zMACRh6ywmBpzJWuEddG8pS3CYU
//*/
//
//	
//	public static JSONObject teacherPushTemplate(Map map) {
//		JSONObject json = new JSONObject();
//
//		json.put("touser", "");
//		json.put("template_id", "yC7JJb5Ut25Va8U7zMACRh6ywmBpzJWuEddG8pS3CYU");
//		json.put("url", "http://htjy.kz38.cn");
//		JSONObject data = new JSONObject();
//
//		JSONObject first = new JSONObject();
//		first.put("value", map.get("data2"));
//		first.put("color", "#173177");
//		data.put("first", first);
//
//		JSONObject keyword1 = new JSONObject();
//		keyword1.put("value", map.get("data3"));
//		keyword1.put("color", "#173177");
//		data.put("keyword1", keyword1);
//
//		JSONObject keyword2 = new JSONObject();
//		keyword2.put("value", map.get("data4"));
//		keyword2.put("color", "#173177");
//		data.put("keyword2", keyword2);
//
//		JSONObject keyword3 = new JSONObject();
//		keyword3.put("value", map.get("data5"));
//		keyword3.put("color", "#173177");
//		data.put("keyword3", keyword3);
//
//		JSONObject keyword4 = new JSONObject();
//		keyword4.put("value", map.get("data6"));
//		keyword4.put("color", "#173177");
//		data.put("keyword4", keyword4);
//
//		JSONObject remark = new JSONObject();
//		remark.put("value", map.get("data8"));
//		remark.put("color", "#173177");
//		data.put("remark", remark);
//
//		json.put("data", data);
//		return json;
//	}
//
//	


	/*
	 * 模版IDaWD5uE-BdVEeXB6C2ajMa190KIKN_NBcv9wWODcbd20 开发者调用模版消息接口时需提供模版ID
	 * 标题课程开课通知 行业教育 - 培训 详细内容 您好，{{userName.DATA}}。
	 * 
	 * 您报名参加的{{courseName.DATA}}将于{{date.DATA}}开课，特此通知。 {{remark.DATA}}
	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例 您好，kantzou。
	 * 
	 * 您报名参加的会计认证课程将于2013年10月9日开课，特此通知。 想了解课程安排，可回复1 想了解师资详情，可回复2 想了解更多课程，可回复3
	 * 感谢您对微信学校的支持。
	 */

	/**
	 * 开课通知
	 * 
	 * @return
	 */
	public static JSONObject classBiginTemplate(Map map) {
		JSONObject json = new JSONObject();
		
		json.put("touser", "");
		json.put("template_id", "aWD5uE-BdVEeXB6C2ajMa190KIKN_NBcv9wWODcbd20");
		json.put("url", "http://htjy.kz38.cn");
		JSONObject data = new JSONObject();

		JSONObject userName = new JSONObject();
		
		userName.put("value",map.get("userName"));
		userName.put("color", "#173177");
		data.put("userName", userName);

		JSONObject courseName = new JSONObject();
		courseName.put("value", map.get("courseName"));
		courseName.put("color", "#173177");
		data.put("courseName", courseName);

		JSONObject date = new JSONObject();
		date.put("value", map.get("date"));
		date.put("color", "#173177");
		data.put("date", date);

		JSONObject remark = new JSONObject();
		remark.put("value", map.get("remark"));
		remark.put("color", "#173177");
		data.put("remark", remark);

		json.put("data", data);
		return json;
	}

	/*
	 * 模版IDSGHH8vFGuErQWPJrumjE8M9BIpMxnJI4f83eJA_Amqc 开发者调用模版消息接口时需提供模版ID
	 * 标题作业提醒 行业教育 - 培训 详细内容 
	 * {{first.DATA}} 
	 * 时间：{{keyword1.DATA}}
	 * 科目：{{keyword2.DATA}} 
	 * 作业简介：{{keyword3.DATA}} 
	 * 作业详情：{{keyword4.DATA}}
	 * {{remark.DATA}} 
	 * 
	 * {data2} 
	 * 时间：{data3}
	 * 科目：{data4} 
	 * 作业简介：{data5} 
	 * 作业详情：{data6}
	 * {data7} 
	 * 
	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例
	 * 您好，您有新的作业已发布，请查收。 时间：2014年9月24日 18:00 科目：数学 作业简介：数学第三章课后作业练习
	 * 作业详情：请大家将数学课本68页面，课后作业3，6，7，8题作业完成，明早上交。 感谢您的查阅，请认真对待，按时完成作业。
	 */

	/**
	 * 作业提醒
	 * 
	 * @return
	 */
	public static JSONObject homeWorkTemplate(Map map) {
		JSONObject json = new JSONObject();

		json.put("touser", "");
		json.put("template_id", "SGHH8vFGuErQWPJrumjE8M9BIpMxnJI4f83eJA_Amqc");
		json.put("url", "http://htjy.kz38.cn");
		JSONObject data = new JSONObject();

		JSONObject first = new JSONObject();
		first.put("value", map.get("first"));
		first.put("color", "#173177");
		data.put("first", first);

		JSONObject keyword1 = new JSONObject();
		keyword1.put("value", map.get("keyword1"));
		keyword1.put("color", "#173177");
		data.put("keyword1", keyword1);

		JSONObject keyword2 = new JSONObject();
		keyword2.put("value", map.get("keyword2"));
		keyword2.put("color", "#173177");
		data.put("keyword2", keyword2);

		JSONObject keyword3 = new JSONObject();
		keyword3.put("value", map.get("keyword3"));
		keyword3.put("color", "#173177");
		data.put("keyword3", keyword3);

		JSONObject keyword4 = new JSONObject();
		keyword4.put("value", map.get("keyword4"));
		keyword4.put("color", "#173177");
		data.put("keyword4", keyword4);

		JSONObject remark = new JSONObject();
		remark.put("value", map.get("remark"));
		remark.put("color", "#173177");
		data.put("remark", remark);

		json.put("data", data);
		return json;
	}

	/*
	 * 模版IDf3L9h2NylVx8UgvVJs5y7_RbzjqH1ZAxGTy0Qs9plBM 开发者调用模版消息接口时需提供模版ID
	 * 标题请假通知 行业教育 - 培训 详细内容 {{first.DATA}} 请假人：{{keyword1.DATA}}
	 * 请假时间：{{keyword2.DATA}} 请假事由：{{keyword3.DATA}} {{remark.DATA}}
	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例 王老师您好，您的班级【荔枝班】有同学请假。
	 * 
	 *  {data2} 
	 *  请假人：{data3}
	 *  请假时间：{data4}
	 *  请假事由：{data5} 
	 *  {data6}
	 * 
	 * 请假人：张小小 请假时间：9月1日-9月2日 两天 请假事由：病假，医生说要在家休息两天 请您及时查看并审批。
	 */
	
	/**
	 * 请假通知
	 * 
	 * @return
	 */
	public static JSONObject leaveTemplate(Map map) {
		JSONObject json = new JSONObject();

		json.put("touser", "");
		json.put("template_id", "f3L9h2NylVx8UgvVJs5y7_RbzjqH1ZAxGTy0Qs9plBM");
		json.put("url", "http://htjy.kz38.cn");
		JSONObject data = new JSONObject();

		JSONObject first = new JSONObject();
		first.put("value", map.get("first"));
		first.put("color", "#173177");
		data.put("first", first);

		JSONObject keyword1 = new JSONObject();
		keyword1.put("value", map.get("keyword1"));
		keyword1.put("color", "#173177");
		data.put("keyword1", keyword1);

		JSONObject keyword2 = new JSONObject();
		keyword2.put("value", map.get("keyword2"));
		keyword2.put("color", "#173177");
		data.put("keyword2", keyword2);

		JSONObject keyword3 = new JSONObject();
		keyword3.put("value", map.get("keyword3"));
		keyword3.put("color", "#173177");
		data.put("keyword3", keyword3);

		JSONObject remark = new JSONObject();
		remark.put("value", map.get("remark"));
		remark.put("color", "#173177");
		data.put("remark", remark);

		json.put("data", data);
		return json;
	}
	
	/*{{first.DATA}}
	教师姓名：{{keyword1.DATA}}
	手机号码：{{keyword2.DATA}}
	辅导科目：{{keyword3.DATA}}
	安排日期：{{keyword4.DATA}}
	{{remark.DATA}}
	在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息
	
	{data2}
	教师姓名：{data3}
	手机号码：{data4}
	辅导科目：{data5}
	安排日期：{data6}
	{data8}
	
	尊敬的家长，平台已为您孩子安排了老师。
	教师姓名：刘兆云
	手机号码：12345678
	辅导科目：初二物理
	安排日期：2018-01-23
	如有疑问，请您致电：12345678。感谢您的支持！
	yC7JJb5Ut25Va8U7zMACRh6ywmBpzJWuEddG8pS3CYU
*/

	
	public static JSONObject teacherPushTemplate(Map map) {
		JSONObject json = new JSONObject();

		json.put("touser", "");
		json.put("template_id", "yC7JJb5Ut25Va8U7zMACRh6ywmBpzJWuEddG8pS3CYU");
		json.put("url", "http://htjy.kz38.cn");
		JSONObject data = new JSONObject();

		JSONObject first = new JSONObject();
		first.put("value", map.get("first"));
		first.put("color", "#173177");
		data.put("first", first);

		JSONObject keyword1 = new JSONObject();
		keyword1.put("value", map.get("keyword1"));
		keyword1.put("color", "#173177");
		data.put("keyword1", keyword1);

		JSONObject keyword2 = new JSONObject();
		keyword2.put("value", map.get("keyword2"));
		keyword2.put("color", "#173177");
		data.put("keyword2", keyword2);

		JSONObject keyword3 = new JSONObject();
		keyword3.put("value", map.get("keyword3"));
		keyword3.put("color", "#173177");
		data.put("keyword3", keyword3);

		JSONObject keyword4 = new JSONObject();
		keyword4.put("value", map.get("keyword4"));
		keyword4.put("color", "#173177");
		data.put("keyword4", keyword4);

		JSONObject remark = new JSONObject();
		remark.put("value", map.get("remark"));
		remark.put("color", "#173177");
		data.put("remark", remark);

		json.put("data", data);
		return json;
	}

}
