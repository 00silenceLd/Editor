package swtech.facade.pageDesign.entity;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import com.alibaba.fastjson.JSONObject;


/*
 * 

 ┏┓　　　┏┓
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
* @ClassName: HeaderAndFooter
* @author 曾智宏
* @date 2019年6月9日
* @Description: 头/底部模板控件
*
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class HeaderAndFooter extends BaseControl{

	
	
	
	
	private String placeholder;
	private String templatename;
	private String headerdefinitions;
	private String footerdefinitions;
	
	
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getTemplatename() {
		return templatename;
	}
	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}
	public String getHeaderdefinitions() {
		return headerdefinitions;
	}
	public void setHeaderdefinitions(String headerdefinitions) {
		this.headerdefinitions = headerdefinitions;
	}
	public String getFooterdefinitions() {
		return footerdefinitions;
	}
	public void setFooterdefinitions(String footerdefinitions) {
		this.footerdefinitions = footerdefinitions;
	}
	@Override
	public String toString() {
		return "HeaderAndFooter [placeholder=" + placeholder + ", templatename=" + templatename + ", headerdefinitions="
				+ headerdefinitions + ", footerdefinitions=" + footerdefinitions + "]";
	}
	
	
	
	
	
	
	
	
}
 