package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ProgressbarControl  extends BaseControl{
//	name -- 该页面控件的唯一id
//	leipiplugins -- 组件名称
//	orgvalue -- 进度条跨度
//	orgsigntype -- 进度条样式
//	src -- 进度条图片地址
	private String value;
	private String orgsigntype;
	private String src;
	
	private String orgwidth;
	private String orgheight;
	
	
	
	public String getOrgwidth() {
		return orgwidth;
	}
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}
	public String getOrgheight() {
		return orgheight;
	}
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOrgsigntype() {
		return orgsigntype;
	}
	public void setOrgsigntype(String orgsigntype) {
		this.orgsigntype = orgsigntype;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
 
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	@Override
	public String toString() {
		return "ProgressbarControl [value=" + value + ", orgsigntype="
				+ orgsigntype + ", src=" + src + "]";
	}
	
}
