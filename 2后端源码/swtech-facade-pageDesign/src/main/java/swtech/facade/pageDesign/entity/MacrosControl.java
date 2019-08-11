package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class MacrosControl extends BaseControl {
	// name -- 该页面控件的唯一id
	// leipiplugins -- 组件名称
	// type -- 控件属性 type
	// orgtype -- 类型
	// ordhide -- 可见属性 0 显示 1 隐藏
	// style -- 控件样式orghide
	private String orghide;
	private String type;
	private String orgtype;
	private String orghight;
	private String orgwidth;
	private String value;
	private String orgfontsize;
	
	public String getOrgfontsize() {
		return orgfontsize;
	}

	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}

	public String getOrghide() {
		return orghide;
	}

	public void setOrghide(String orghide) {
		this.orghide = orghide;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getOrghight() {
		return orghight;
	}

	public void setOrghight(String orghight) {
		this.orghight = orghight;
	}

	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}

	@Override
	public String toString() {
		return "MacrosControl [orghide=" + orghide + ", type=" + type
				+ ", orgtype=" + orgtype + ", orghight=" + orghight
				+ ", orgwidth=" + orgwidth + ", value=" + value
				+ ", orgfontsize=" + orgfontsize + "]";
	}

}
