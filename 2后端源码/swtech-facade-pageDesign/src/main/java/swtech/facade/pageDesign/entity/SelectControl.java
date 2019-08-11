package swtech.facade.pageDesign.entity;

import java.util.Arrays;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class SelectControl extends BaseControl { 
//	name -- 该页面控件的唯一id
//	style -- 控件样式
//	leipiplugins -- 组件名称
//	value -- 控件内容 value (可以有多个,这需要返回一个数组)
//	selected -- 选择状态 (如果没点击选择按钮，就没有这个返回值，所以要判断)
//	size -- 行高
	private int size; 
	private String orgwidth;
	private String orgheight;
	private String orgfontsize;
	private String selected;
	private String value;
	private String datasource;
	private String isstate;
	private String datatitle;
	private String datasources;
	private String conhide;
	

	
    public String getConhide() {
		return conhide;
	}
	/**
	 * @param conhide the conhide to set
	 */
	public void setConhide(String conhide) {
		this.conhide = conhide;
	}
	public String getDatasources() {
		return datasources;
	}
	/**
	 * @param datasources the datasources to set
	 */
	public void setDatasources(String datasources) {
		this.datasources = datasources;
	}
	public String getDatatitle() {
		return datatitle;
	}
	/**
	 * @param datatitle the datatitle to set
	 */
	public void setDatatitle(String datatitle) {
		this.datatitle = datatitle;
	}
	public String getIsstate() {
		return isstate;
	}
	/**
	 * @param isstate the isstate to set
	 */
	public void setIsstate(String isstate) {
		this.isstate = isstate;
	}
	public String getOrgheight() {
		return orgheight;
	}
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}
	public String getOrgfontsize() {
		return orgfontsize;
	}
	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		//&quot;
		if(datasource.contains("&quot;")) {
			this.datasource = datasource = datasource.replaceAll("&quot;", "\"");
		}else {
			this.datasource = datasource;
		}
		
	}
	public String getOrgwidth() {
		return orgwidth;
	}
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	 
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String rendHtml(){
		String htmlStr="";
		 //设置过默认值  清空它  
		return htmlStr;
	}
	 
	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	@Override
	public String toString() {
		return "SelectControl [size=" + size + ", orgwidth=" + orgwidth
				+ ", selected=" + selected + ", value="
				+ value + "]";
	}
	
}
