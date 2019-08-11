package swtech.facade.pageDesign.entity;

import java.util.List;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class CheckboxsControl extends BaseControl{
//	name -- 该页面控件的唯一id (这里有多个,返回一个数组)
//	leipiplugins -- 组件名称
//	options -- 单选框内容 (对象形式)
//	order -- 排序方向 0 竖排 1 横排
    private String value;
    private String parse_name; 
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
		//&quot;
		if(datasource.contains("&quot;")) {
			this.datasource = datasource = datasource.replaceAll("&quot;", "\"");
		}else {
			this.datasource = datasource;
		}
		
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
	
	public String getParse_name() {
		return parse_name;
	}
	public void setParse_name(String parse_name) {
		this.parse_name = parse_name;
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
/*	public String getSqlString() {
		String sqlString="";
		List<OptionControl> list=this.getOptions();
		for (int i = 0; i <list.size(); i++) {
			OptionControl optionControl=new OptionControl();
			optionControl=list.get(i);			
			sqlString =sqlString + optionControl.getName() + " varchar(100)  COMMENT '"
					+ optionControl.getValue() + "',";
		}
		return sqlString;
	}*/
	
	public String getSqlString() {
		String sqlString = this.getName1() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
	@Override
	public String toString() {
		return "CheckboxsControl [value=" + value + ", parse_name=" + parse_name + ", options="
				+ options + ", sortord=" + sortord + ", selected=" + selected + ", orderby=" + orderby + ", datasource="
				+ datasource + "]";
	}

}
