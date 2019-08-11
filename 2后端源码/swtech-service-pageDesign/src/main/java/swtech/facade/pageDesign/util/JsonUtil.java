package swtech.facade.pageDesign.util;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 负责将Json字符串与Java对象相互转换的工具类
 * @author 郑志良
 * @date 2018年7月25日下午1:10:28
 */
public class JsonUtil {

	private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
	private static final ObjectMapper mapper = new ObjectMapper();
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	static {
		mapper.setSerializationInclusion(JsonSerialize.Inclusion.ALWAYS);
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
	}

	public static <T> String objToJson(T obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			log.warn("Parse Object to Json error", e);
			return null;
		}
	}

	public static <T> String objToJsonPretty(T obj) {
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			log.warn("Parse Object to Json error", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T jsonToObj(String jsonStr, Class<T> clazz) {
		if (StringUtils.isBlank(jsonStr) || null == clazz) {
			return null;
		}

		if (clazz == String.class) {
			return (T) jsonStr;
		}

		try {
			return mapper.readValue(jsonStr, clazz);
		} catch (IOException e) {
			log.warn("parse json to object error", e);
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T jsonToObj(String jsonStr, TypeReference<T> typeReference) {
		if (StringUtils.isBlank(jsonStr) || null == typeReference) {
			return null;
		}

		if (typeReference.getType().equals(String.class)) {
			return (T) jsonStr;
		}

		try {
			return mapper.readValue(jsonStr, typeReference);
		} catch (IOException e) {
			log.warn("parse json to object by TypeReference error", e);
			return null;
		}
	}

	public static <T> T jsonToObj(String jsonStr, Class<?> collectionClass,
			Class<?>... elementClass) {
		if (StringUtils.isBlank(jsonStr) || collectionClass == null
				|| elementClass == null) {
			return null;
		}

		JavaType javaType = mapper.getTypeFactory().constructParametricType(
				collectionClass, elementClass);
		try {
			return mapper.readValue(jsonStr, javaType);
		} catch (IOException e) {
			log.warn("parse json to object by collectionClass and elementClass error", e);
			return null;
		}
	}
}