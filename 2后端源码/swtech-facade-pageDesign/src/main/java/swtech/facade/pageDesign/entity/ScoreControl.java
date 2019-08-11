package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/**
*
* @author 曾智宏
*
* @version 1.0
*
* 创建时间：
*
*评分控件
* 
* 实体类
*
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ScoreControl extends BaseControl{

	
	private Integer id;//
	private String placeholder ;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	@Override
	public String toString() {
		return "ScoreControl [id=" + id + ", placeholder=" + placeholder + "]";
	}
	
	
	
	
	
	
}
 