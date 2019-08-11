package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
 * 审批列表控件
* @author 王小东
* @date 2018年11月15日 下午4:10:48 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Shenpi extends BaseControl{
	private String name ,leipiplugins ,text ,value, title ,datasource ,pluheight ,fontsize ,style,type,spdel,spdbox,spstate,datafiled;

	public String getDatafiled() {
		return datafiled;
	}

	/**
	 * @param datafiled the datafiled to set
	 */
	public void setDatafiled(String datafiled) {
		this.datafiled = datafiled;
	}

	public String getSpstate() {
		return spstate;
	}

	/**
	 * @param spstate the spstate to set
	 */
	public void setSpstate(String spstate) {
		this.spstate = spstate;
	}

	public String getSpdbox() {
		return spdbox;
	}

	/**
	 * @param spdbox the spdbox to set
	 */
	public void setSpdbox(String spdbox) {
		this.spdbox = spdbox;
	}

	public String getSpdel() {
		return spdel;
	}

	/**
	 * @param spdel the spdel to set
	 */
	public void setSpdel(String spdel) {
		this.spdel = spdel;
	}

	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
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

	public String getLeipiplugins() {
		return leipiplugins;
	}

	/**
	 * @param leipiplugins the leipiplugins to set
	 */
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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

	public String getDatasource() {
		return datasource;
	}

	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getPluheight() {
		return pluheight;
	}

	/**
	 * @param pluheight the pluheight to set
	 */
	public void setPluheight(String pluheight) {
		this.pluheight = pluheight;
	}

	public String getFontsize() {
		return fontsize;
	}

	/**
	 * @param fontsize the fontsize to set
	 */
	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
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
 
