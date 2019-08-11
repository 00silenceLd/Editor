package swtech.facade.pageDesign.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class RadiosControl extends BaseControl{
//	name -- 该页面控件的唯一id
//	leipiplugins -- 组件名称
//	options -- 单选框内容 (对象形式)
//	order -- 排序方向 0 竖排 1 横排 
    private String value; 
	private List<OptionControl> options;
	private String sortord;
	private String selected;
	private String orderby;
	private String datasource;
	private String orgwidth;
	private String orgheight;
	private String orgfontsize;
	
	
	
	
	
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
		this.datasource = datasource;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
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
	public List<OptionControl> getOptions() {
		return options;
	}
	public void setOptions(List<OptionControl> options) {
		this.options = options;
	}
	public String getSortord() {
		return sortord;
	}
	public void setSortord(String sortord) {
		if(sortord.isEmpty()||sortord==""){
			this.sortord="0";
		}
		else {
			this.sortord = sortord;			
		}
	}
	 
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	@Override
	public String toString() {
		return "RadiosControl [value=" + value + ", options=" + options + ", sortord=" + sortord + ", selected="
				+ selected + ", orderby=" + orderby + ", datasource=" + datasource + "]";
	}
	
}
