package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ListctrlControl extends BaseControl{
//	该控件需要返回的数据
//	name -- 该页面控件的唯一id
//	leipiplugins -- 组件名称
//	orgtitle -- 表头名称
//	orgcoltype -- 类型
//	orgunit -- 单位
//	orgsum -- 合计 0 为 不 1 为 合计
//	orgcolvalue -- 默认值
//	style -- 控件样式
	private String orgtitle;
	private String type;
	private String orgcoltype;
	private String orgunit;
	private String orgsum;
	private String orgcolvalue;
	private String orgwidth;
	private String readonly;  
	private String value;
	private String orgrowvalue;
	private String orgsumvalue;
	
	public String getOrgsumvalue() {
		return orgsumvalue;
	}

	public void setOrgsumvalue(String orgsumvalue) {
		this.orgsumvalue = orgsumvalue;
	}

	public String getOrgrowvalue(){
		return orgrowvalue;
	}
	
	public void setOrgrowvalue(String orgrowvalue){
		this.orgrowvalue = orgrowvalue;
	}
	
	public String getOrgtitle() {
		return orgtitle;
	}

	public void setOrgtitle(String orgtitle) {
		this.orgtitle = orgtitle;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrgcoltype() {
		return orgcoltype;
	}

	public void setOrgcoltype(String orgcoltype) {
		this.orgcoltype = orgcoltype;
	}

	public String getOrgunit() {
		return orgunit;
	}

	public void setOrgunit(String orgunit) {
		this.orgunit = orgunit;
	}

	

	public String getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(String orgsum) {
		this.orgsum = orgsum;
	}

	public String getOrgcolvalue() {
		return orgcolvalue;
	}

	public void setOrgcolvalue(String orgcolvalue) {
		this.orgcolvalue = orgcolvalue;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getReadonly() {
		return readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
 

	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}

	@Override
	public String toString() {
		return "ListctrlControl [orgtitle=" + orgtitle + ", orgcoltype="
				+ orgcoltype + ", orgunit=" + orgunit + ", orgsum=" + orgsum
				+ ", orgcolvalue=" + orgcolvalue + ", orgwidth=" + orgwidth
				+ ", readonly=" + readonly + ", value=" + value + ", type=" + type + "]";
	}
	
}
