package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
 * 导出表格控件
* @author 王小东
* @date 2018年11月14日 下午2:15:42 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Export extends BaseControl{
	
	private String name,leipiPlugins,type,value ,title, datasource ,datafield, pluwidth, pluheight ,fontsize ,style,bgcolor,fontcolor;

	public String getBgcolor() {
		return bgcolor;
	}

	/**
	 * @param bgcolor the bgcolor to set
	 */
	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public String getFontcolor() {
		return fontcolor;
	}

	/**
	 * @param fontcolor the fontcolor to set
	 */
	public void setFontcolor(String fontcolor) {
		this.fontcolor = fontcolor;
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

	public String getLeipiPlugins() {
		return leipiPlugins;
	}

	/**
	 * @param leipiPlugins the leipiPlugins to set
	 */
	public void setLeipiPlugins(String leipiPlugins) {
		this.leipiPlugins = leipiPlugins;
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

	public String getDatafield() {
		return datafield;
	}

	/**
	 * @param datafield the datafield to set
	 */
	public void setDatafield(String datafield) {
		this.datafield = datafield;
	}

	public String getPluwidth() {
		return pluwidth;
	}

	/**
	 * @param pluwidth the pluwidth to set
	 */
	public void setPluwidth(String pluwidth) {
		this.pluwidth = pluwidth;
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
 
