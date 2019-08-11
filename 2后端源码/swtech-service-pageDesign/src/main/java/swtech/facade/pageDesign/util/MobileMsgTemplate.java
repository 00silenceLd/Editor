package swtech.facade.pageDesign.util;

import java.text.MessageFormat;
import java.util.Map;

/**
 * 手机短信模板
 * @author 郑志良
 * @date 2018年9月12日下午4:09:32
 */
@SuppressWarnings("rawtypes")
public class MobileMsgTemplate {

	private static final String SEPARATE = "\r\n";
	
	/*
	 * 模版IDaWD5uE-BdVEeXB6C2ajMa190KIKN_NBcv9wWODcbd20 开发者调用模版消息接口时需提供模版ID
	 * 标题课程开课通知 行业教育 - 培训 详细内容 您好，{{userName.DATA}}。
	 * 
	 * 您报名参加的{{courseName.DATA}}将于{{date.DATA}}开课，特此通知。 {{remark.DATA}}
	 * 在发送时，需要将内容中的参数（{{.DATA}}内为参数）赋值替换为需要的信息 内容示例 您好，kantzou。
	 * 
	 * 您报名参加的会计认证课程将于2013年10月9日开课，特此通知。
	 */

	/**
	 * 开课通知
	 * 
	 * @return
	 */
	public static String schoolBeginTemplate(Map map) {
		return MessageFormat.format(
				"您报名参加的{0}将于{1}开课，特此通知。{2}", 
				map.get("data2"), 
				map.get("data5"), 
				map.get("data3"));
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
	public static String homeWorkTemplate(Map map) {
		return MessageFormat.format(
				"{0}。" + SEPARATE
				+ "时间：{1}" + SEPARATE
				+ "科目：{2}" + SEPARATE
				+ "作业简介：{3}" + SEPARATE
				+ "作业详情：{4}" + SEPARATE
				+ "{5}。", 
				map.get("first"), 
				map.get("keyword1"), 
				map.get("keyword2"), 
				map.get("keyword3"), 
				map.get("keyword4"), 
				map.get("remark"));
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
	public static String leaveTemplate(Map map) {
		return MessageFormat.format(
				"{0}" + SEPARATE
				+ "请假人：{1}" + SEPARATE
				+ "请假时间：{2}" + SEPARATE
				+ "请假事由：{3}" + SEPARATE
				+ "{4}", 
				map.get("data2"),
				map.get("data3"),
				map.get("data4"),
				map.get("data5"),
				map.get("data6"));
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
	public static String teacherPushTemplate(Map map) {
		return MessageFormat.format(
				"{0}" + SEPARATE
				+ "教师姓名：{1}" + SEPARATE
				+ "手机号码：{2}" + SEPARATE
				+ "辅导科目：{3}" + SEPARATE
				+ "安排日期：{4}" + SEPARATE
				+ "{5}", 
				map.get("first"),
				map.get("keyword1"),
				map.get("keyword2"),
				map.get("keyword3"),
				map.get("keyword4"),
				map.get("remark"));
	}
	
}
