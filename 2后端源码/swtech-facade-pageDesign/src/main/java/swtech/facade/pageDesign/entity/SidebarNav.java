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
public class SidebarNav extends BaseControl{
	private String placeholder;
	private String leftnavdefinitions;
	private String bluestyle;
	
	
	
	public String getBluestyle() {
		return bluestyle;
	}
	public void setBluestyle(String bluestyle) {
		this.bluestyle = bluestyle;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getLeftnavdefinitions() {
		return leftnavdefinitions;
	}
	public void setLeftnavdefinitions(String leftnavdefinitions) {
		this.leftnavdefinitions = leftnavdefinitions;
	}
	@Override
	public String toString() {
		return "SidebarNav [placeholder=" + placeholder + ", leftnavdefinitions=" + leftnavdefinitions + ", bluestyle="
				+ bluestyle + "]";
	}
	
	
	
	
	
	
}
 