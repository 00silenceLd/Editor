package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class QrcodeControl  extends BaseControl{
//	name -- 该页面控件的唯一id
//	leipiplugins -- 组件名称
//	value -- 二维码内容
//	orgtype -- 二维码类型
//	src -- 二维码图片地址
//	style -- 控件样式
	private String orgwidth;
	private String orgheight;
	private String value;
	private String src;
	private String orgtype;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

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
	
	 
	public String getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	@Override
	public String toString() {
		return "QrcodeControl [orgwidth=" + orgwidth + ", orgheight="
				+ orgheight + ", value=" + value + ", src=" + src
				+ ", orgtype=" + orgtype + "]";
	}
	 
	
}
