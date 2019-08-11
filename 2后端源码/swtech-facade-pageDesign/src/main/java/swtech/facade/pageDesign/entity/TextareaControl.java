package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class TextareaControl extends BaseControl {
	// name -- 该页面控件的唯一id
	// type -- 控件属性 type
	// value -- 控件内容 value
	// leipiplugins -- 组件名称
	// ordrich -- 是否选择富文本格式 1 为 选择
	// style -- 控件样式
	private int orgrich;
	private String orgfontsize;
	private String orgwidth;
	private String orgheight;
	private String value;
	private String datasource;
	private String orgdisabled;
	private String maxlength;
	private String disabled;
	private String dataid;
	private String datafield;
	private String value_2;
	private String orgprintlength;
	private String listheight;

	public String getListheight() {
		return listheight;
	}

	/**
	 * @param listheight the listheight to set
	 */
	public void setListheight(String listheight) {
		this.listheight = listheight;
	}

	public String getValue_2() {
		return value_2;
	}

	public void setValue_2(String value_2) {
		this.value_2 = value_2;
	}

	public String getOrgprintlength() {
		return orgprintlength;
	}

	public void setOrgprintlength(String orgprintlength) {
		this.orgprintlength = orgprintlength;
	}

	public String getDatafield() {
		return datafield;
	}

	public void setDatafield(String datafield) {
		this.datafield = datafield;
	}

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getOrgdisabled() {
		return orgdisabled;
	}

	public void setOrgdisabled(String orgdisabled) {
		this.orgdisabled = orgdisabled;
	}

	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		// &quot;
		if (datasource.contains("&quot;")) {
			this.datasource = datasource = datasource.replaceAll("&quot;", "\"");
		} else {
			this.datasource = datasource;
		}

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getOrgrich() {
		return orgrich;
	}

	public void setOrgrich(int orgrich) {
		this.orgrich = orgrich;
	}

	public String getOrgfontsize() {
		return orgfontsize;
	}

	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
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

	public String getSqlString() {
		String sqlString = this.getName() + " mediumtext COMMENT '" + this.getTitle() + "',";
		return sqlString;
	}

	@Override
	public String toString() {
		return "TextareaControl [orgrich=" + orgrich + ", orgfontsize=" + orgfontsize + ", orgwidth=" + orgwidth
				+ ", orgheight=" + orgheight + ", value=" + value + ", datasource=" + datasource + "]";
	}

}
