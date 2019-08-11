package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
 *  背景控件
* @author 王小东
* @date 2018年11月10日 上午11:27:39 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Background extends BaseControl{
	
	private String name,leipiplugins,type,value,title,bagcolor,bagpic;

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set。。。
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	/**
	 * @param leipiplugins the leipiplugins to set。。
	 */
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set。。
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getBagcolor() {
		return bagcolor;
	}

	/**
	 * @param bagcolor the bagcolor to set
	 */
	public void setBagcolor(String bagcolor) {
		this.bagcolor = bagcolor;
	}

	public String getBagpic() {
		return bagpic;
	}

	/**
	 * @param bagpic the bagpic to set
	 */
	public void setBagpic(String bagpic) {
		this.bagpic = bagpic;
	}
	
	//实体类

}
 
