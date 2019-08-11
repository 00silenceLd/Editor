package swtech.facade.pageDesign.entity; 
/** 
* @author 王小东
* @date 2019年1月9日 上午9:57:41 
*/

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Getuserid extends BaseControl{
	
	private String name,disabled,leipiplugins,placeholder,style,value;

	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getDisabled() {
		return disabled;
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	/**
	 * @param leipiplugins the leipiplugins to set
	 */
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	/**
	 * @param placeholder the placeholder to set
	 */
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	

}
 
