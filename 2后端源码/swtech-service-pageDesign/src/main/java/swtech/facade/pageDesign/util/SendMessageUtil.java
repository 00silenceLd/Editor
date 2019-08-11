package swtech.facade.pageDesign.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.type.TypeReference;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 使用第三方接口发送短信工具类
 * @author 郑志良
 * @date 2018年9月8日下午3:32:47
 */
public class SendMessageUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(SendMessageUtil.class);
	
	/** 企业ID */
	private static final String USERID = "154";
	/** 用户账号 */
	private static final String USERNAME = "zhangzong";
	/** 账号密码 */
	private static final String PASSWORD = "123456";
	
	/** 客户端主机IP */
	private static final String HOST = "120.78.206.123";
	/** 客户端端口号 */
	private static final int PORT = 8088;

	/** 发送短信相关的uri */
	private static final String URI_SEND = MessageFormat.format("http://{0}:{1}/v2sms.aspx", HOST, String.valueOf(PORT));
	/** 查询状态报告接口的uri */
	private static final String URI_STATUS = MessageFormat.format("http://{0}:{1}/v2statusApi.aspx", HOST, String.valueOf(PORT));
	/** 上行接口的uri */
	private static final String URI_QUERY = MessageFormat.format("http://{0}:{1}/v2callApi.aspx", HOST, String.valueOf(PORT));
	
	/** 时间戳的格式 */
	private static final SimpleDateFormat PATTERN_TIMESTAMP = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 上行接口
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:30:53
	 */
	public static String query() throws Exception {
		Map<String, String> params = getParamMap();
		params.put("action", "query");
		
		String result = HttpUtil.post(URI_QUERY, params, new TypeReference<String>() {});
		System.out.println(result);
		return result;
	}
	
	/**
	 * 状态报告接口
	 * @param statusNum （可选参数）每次取得号码数，必须为数字，默认4000，可不填
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:26:45
	 */
	public static String status(String statusNum) throws Exception {
		Map<String, String> params = getParamMap();
		params.put("action", "query");
		params.put("statusNum", statusNum);
		
		String result = HttpUtil.post(URI_STATUS, params, new TypeReference<String>() {});
		System.out.println(result);
		return result;
	}
	
	/**
	 * 非法关键词查询
	 * @param content 发送的短信内容，内容需要进行UTF-8编码
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:22:23
	 */
	public static String checkKeyword(String content) throws Exception {
		Map<String, String> params = getParamMap();
		params.put("action", "checkkeyword");
		params.put("content", content);
		
		String result = HttpUtil.post(URI_SEND, params, new TypeReference<String>(){});
		System.out.println(result);
		return result;
	}
	
	/** 
	 * 余额及已发送量查询接口
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:20:52
	 */
	public static String overage() throws Exception {
		Map<String, String> params = getParamMap();
		params.put("action", "overage");
		
		String result = HttpUtil.post(URI_SEND, params, new TypeReference<String>() {});
		return result;
	}
	
	/**
	 * 短信发送接口
	 * @param mobile 要发送的手机号，多个手机号之间使用逗号隔开
	 * @param content 要发送的内容，必须以"【】"开关，否则会出现发送成功，但接收方接收不到信息的问题
	 * @param sendTime （可选字段），定时发送时间，格式：2010-10-24 09:08:10
	 * @param extno （可选字段），扩展子号，请先询问配置的通道是否支持扩展子号，如果不支持，请填空。子号只能为数字，且最多10位数
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:10:34
	 */
	public static String send(String mobile, String content, String sendTime, String extno) throws Exception {
		Map<String, String> params = getParamMap();
		params.put("action", "send");
		params.put("mobile", mobile);
		params.put("content", content);
		params.put("sendTime", sendTime);
		params.put("extno", extno);
		
		String result = HttpUtil.post(URI_SEND, params, new TypeReference<String>() {});
		return result;
	}

	/**
	 * 获取一些公用参数，如：userid,timestamp,sign
	 * @return 封装了公用参数的一个Map
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午3:17:55
	 */
	private static Map<String, String> getParamMap(){
		HashMap<String, String> params = new HashMap<>();
		
		String timestampStr = getTimestampStr();
		params.put("timestamp", timestampStr);
		params.put("sign", getSignature(timestampStr));
		params.put("userid", USERID);
		
		return params;
	}
	
	/**
	 * 获取时间戳的字符串，格式:yyyyMMddHHmmss
	 * @return 如：20180908140753
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午2:44:43
	 */
	private static String getTimestampStr() {
		return PATTERN_TIMESTAMP.format(new Date());
	}
	
	/**
	 * 获取签名，将username+password+timestamp组成的字符串进行MD5加密
	 * @param timestamp 时间戳
	 * @return 加密后的字符串，如：a7ad3db0e9fb9c575a3c0417fb54c5b1
	 *
	 * @author 郑志良
	 * @date 2018年9月8日下午2:48:08
	 */
	private static String getSignature(String timestamp) {
		return getMD5(USERNAME + PASSWORD + timestamp);
	}

    /**
     * 对字符串md5加密(需要将字符串转换成小写)
     * @param str 传入要加密的字符串
     * @return MD5加密后的字符串
     *
     * @author 郑志良
     * @date 2018年9月8日下午2:46:08
     */
   private static String getMD5(String str) {  
       try {  
           // 生成一个MD5加密计算摘要下面的MD5也可换成SHA或SHA-1  SHA也是一种和MD5类似的单向散列加密算法
           MessageDigest md = MessageDigest.getInstance("MD5");  
           // 计算md5函数  
           md.update(str.toLowerCase().getBytes());  
           // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
           // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
           String md5Str = new BigInteger(1, md.digest()).toString(16); 
           // md5加密算法会自动丢弃首位的0，所以需要手动补0
           return fillZero(md5Str);
       } catch (Exception e) {  
    	   LOG.error("MD5加密出错， 要加密的字符串：{}", str, e);
          return null;  
       }  
   }

   /**
    * 手动补零，如果字符串不够32位，在前面补零
    * @param md5Str
    * @return
    *
    * @author 郑志良
    * @date 2018年9月13日上午10:37:57
    */
	private static String fillZero(String md5Str) {
		int len = md5Str.length();
		if (len == 32) {
			return md5Str;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (32 - len); i++) {
			sb.append("0");
		}
		sb.append(md5Str);
		
		return sb.toString();
	}
	
	/**
	 * 解析返回的xml响应信息
	 * @param xmlStr xml字符串
	 * @return
	 * @throws DocumentException
	 *
	 * @author 郑志良
	 * @date 2018年9月10日上午11:48:53
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXmlStr(String xmlStr) throws DocumentException {
		if (StringUtils.isBlank(xmlStr)) {
			return null;
		}

		Document document = DocumentHelper.parseText(StringUtils.trim(xmlStr));
		Element root = document.getRootElement();
		Iterator<Element> iterator = root.elementIterator();

		Map<String, String> map = new HashMap<>();
		while (iterator.hasNext()) {
			Element e = iterator.next();
			map.put(e.getName(), e.getText());
		}

		return map;
	}
}
