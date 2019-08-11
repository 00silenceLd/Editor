package swtech.facade.pageDesign.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * 使用HttpClient发送Http请求的工具类
 * 
 * @author 郑志良
 * @date 2018年8月25日上午9:25:19
 */
public class HttpUtil {
	
	private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);
	
	/** 默认字符集 */
	public static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * 使用httpclient发送get方法
	 * @param uri 请求的uri
	 * @param paramMap 封装了请求参数的map
	 * @param typeReference 返回值的类型
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年9月10日上午9:46:35
	 */
	public static <T> T get(String uri, Map<String, String> paramMap, TypeReference<T> typeReference) throws Exception {
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		
		try {
			client = HttpClientBuilder.create().build();

			List<NameValuePair> params = assemableParams(paramMap);
			String paramStr = EntityUtils.toString(new UrlEncodedFormEntity(params, DEFAULT_CHARSET));
			String url = uri + "?" + paramStr;
			
			log.info("请求的url: {}", url);
			
			HttpGet get = new HttpGet(url);
			
			response = client.execute(get);
			entity = response.getEntity();
			String content = EntityUtils.toString(entity, DEFAULT_CHARSET);
			if (StringUtils.isNotBlank(content)) {
				log.info("content: {}", content);
				T result = JsonUtil.jsonToObj(content, typeReference);
				return result;
			}
		} catch (Exception e) {
			if (e instanceof ClientProtocolException) {
				try {
					EntityUtils.consume(entity);
				} catch (Exception e1) {
					log.warn("consumeing httpEntity error", e1);
				}
			}
			throw e;
		} finally {
			client.close();
		}
		return null;
	}
	
	/**
	 * 发送POST请求
	 * @param uri 请求的URI
	 * @param paramMap 封装了请求参数的map
	 * @param typeReference 返回的Java对象类型
	 * @return
	 * @throws Exception
	 *
	 * @author 郑志良
	 * @date 2018年8月25日上午9:34:48
	 */
	public static <T> T post(String uri, Map<String, String> paramMap,
			TypeReference<T> typeReference) throws Exception {
		log.info("---uri: " + uri);
		log.info("---params: " + paramMap);
		
		CloseableHttpClient client = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		
		try {
			// 创建HttpClient对象
			client = HttpClientBuilder.create().build();
			// 创建要发送的Http请求对象
			HttpPost post = new HttpPost(uri);

			// 将入参paramMap中的元素封装到List<NameValuePair>中
			List<NameValuePair> params = assemableParams(paramMap);
			// 设置参数
			post.setEntity(new UrlEncodedFormEntity(params, DEFAULT_CHARSET));

			// 执行Http请求，并返回响应对象HttpResponse
			response = client.execute(post);
			// 获取响应信息对象
			entity = response.getEntity();
			// 将响应的信息对象转换成字符串
			String content = EntityUtils.toString(entity, DEFAULT_CHARSET);
			if (content != null) {
				// 将字符串转换成Java对象，并返回
				T result = JsonUtil.jsonToObj(content, typeReference);
				return result;
			}
		} catch (Exception e) {
			if (e instanceof ClientProtocolException) {
				try {
					EntityUtils.consume(entity);
				} catch (Exception e1) {
					log.warn("consumeing httpEntity error", e1);
				}
			}
			throw e;
		} finally {
			client.close();
		}
		
		if (log.isDebugEnabled()){
			log.debug("---------------响应的数据为空-------------");
		}
		
		return null;
	}

	/**
	 * 解析并重新封装请求参数
	 * @param paramMap 封装了请求参数的map
	 * @return
	 *
	 * @author 郑志良
	 * @date 2018年8月30日下午2:19:46
	 */
	private static List<NameValuePair> assemableParams(Map<String, String> paramMap) {
		List<NameValuePair> params = Lists.newArrayList();
		if (paramMap != null && !paramMap.isEmpty()) {
			for (Entry<String, String> entry : paramMap.entrySet()) {
				params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		return params;
	}
	
	public static void main(String[] args) throws Exception {
//		String url = "http://192.168.0.213:20896/htUserService/getUserById?id=528";
//		String uri = "http://192.168.0.213:20896/htUserService/getUserById";
//		String url_role_user = "http://192.168.0.213:20896/htRoleService/selectRoleUserInfo";
//		String url_role_info = "http://192.168.0.213:20896/htRoleService/selectRoleInfo";
//		Map<String, String> paramMap = Maps.newHashMap();
//		paramMap.put("id", "528");
//		ReturnMsg<Map<String, User>> result = HttpUtil.get(uri, paramMap, new TypeReference<ReturnMsg<Map<String, User>>>() {});
//		System.out.println(JsonUtil.objToJsonPretty(result));
//		System.out.println(result.getMsg().get("htUser").getUId());
		
//		ReturnMsg<Map<String, List<Role>>> result = HttpUtil.get(url_role_user, null, new TypeReference<ReturnMsg<Map<String, List<Role>>>>() {});
//		System.out.println(JsonUtil.objToJsonPretty(result));
		
//		ReturnMsg<Map<String, List<Role>>> result = HttpUtil.get(url_role_info, null, new TypeReference<ReturnMsg<Map<String, List<Role>>>>() {});
//		System.out.println(JsonUtil.objToJsonPretty(result));
		
//		Object htUser = result.getMsg().get("htUser");
//		System.out.println(htUser);
//		
//		String json = JsonUtil.objToJson(htUser);
//		System.out.println(json);
//		HtUser user = JsonUtil.jsonToObj(json, HtUser.class);
//		System.out.println(user.getUsername() + " " + user.getCreateTime() + " " + user.getVersion() + " " + user.getuId() + " " + user.getChinese_name());
		
//		Map<String, HtUser> map = Maps.newHashMap();
//		HtUser user = new HtUser();
//		user.setId(1);
//		user.setChinese_name("张三");
//		user.setCreateTime(new Date());
//		user.setEmail("zhangsan@163.com");
//		map.put("user", user);
//		
//		String json = JsonUtil.objToJson(map);
//		System.err.println(json);
//		
//		String json = "{\"status\":\"1\",\"statusMsg\":\"success\",\"msg\":{\"htUser\":{\"id\":null,\"version\":0,\"createTime\":1535615174073,\"resource_type\":null,\"uId\":528,\"username\":\"13376694078\",\"chinese_name\":\"王明\",\"password\":null,\"reg_data\":\"2018-06-29\",\"reg_ip\":null,\"lastloginip\":null,\"lastlogintime\":0,\"level\":0,\"email\":null,\"face\":null,\"is_online\":0,\"mobile\":null,\"sex\":0,\"address\":null,\"family_phone\":null,\"registerCompanyName\":null,\"approvalStatus\":null,\"companyId\":null,\"wxopenid\":null,\"wxpush\":null,\"picblog\":null,\"isadmin\":null,\"resource_id\":null}}}";
//		System.out.println(json);
//		ReturnMsg<Map<String, User>> result = JsonUtil.jsonToObj(json, new TypeReference<ReturnMsg<Map<String, User>>>() {});
//		System.out.println(JsonUtil.objToJsonPretty(result));
		
//		User user = new User();
//		user.setUId(123);
//		user.setChinese_name("zhangsan");
//		user.setEmail("zs@163.com");
//		user.setReg_data("2018-12-12");
//		
//		Map<String, User> map = new HashMap<>();
//		map.put("user", user);
//		
//		String json = JsonUtil.objToJson(map);
//		System.out.println(json);
//		map = JsonUtil.jsonToObj(json, new TypeReference<Map<String, User>>(){});
//		System.out.println("value: " + map.get("user"));
	}
	
}
