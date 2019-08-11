package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * 
 * @author admin 搜索控件 ht_search
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")	
public class SearchControl extends BaseControl{
	private Integer id; // id
	private String name; // 定义搜索的名称
	private String type; //
	private String style; //
	private String prdid; //
	private String searchname; // 控件名称
	private Integer nodeid; // 节点ID(也就是绑定的数据源)
	private String orgtitle; // 节点字段名
	private String leipiplugins; // 雷劈网编辑器（标识用）
	private String orgwidth; // 宽度
	private String orgheight;// 长度
	private String orgchecked;
	private String searchcontent; //提示内容(也就是备注)
	private String searchfieldtext; //提示内容(也就是备注)
	private String searchfieldvalue; //提示内容(也就是备注)
	private String searchkeydatavalue; //提示内容(也就是备注)
	private String searchkeydatatext; //提示内容(也就是备注)
	
	
	public String getOrgchecked() {
		return orgchecked;
	}
	public void setOrgchecked(String orgchecked) {
		this.orgchecked = orgchecked;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrdid() {
		return prdid;
	}
	public void setPrdid(String prdid) {
		this.prdid = prdid;
	}
	public String getSearchname() {
		return searchname;
	}
	public void setSearchname(String searchname) {
		this.searchname = searchname;
	}
	public Integer getNodeid() {
		return nodeid;
	}
	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}
	public String getOrgtitle() {
		return orgtitle;
	}
	public void setOrgtitle(String orgtitle) {
		this.orgtitle = orgtitle;
	}
	public String getLeipiplugins() {
		return leipiplugins;
	}
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
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
	public String getSearchcontent() {
		return searchcontent;
	}
	public void setSearchcontent(String searchcontent) {
		this.searchcontent = searchcontent;
	}
	public String getSearchfieldtext() {
		return searchfieldtext;
	}
	public void setSearchfieldtext(String searchfieldtext) {
		this.searchfieldtext = searchfieldtext;
	}
	public String getSearchfieldvalue() {
		return searchfieldvalue;
	}
	public void setSearchfieldvalue(String searchfieldvalue) {
		this.searchfieldvalue = searchfieldvalue;
	}
	public String getSearchkeydatavalue() {
		return searchkeydatavalue;
	}
	public void setSearchkeydatavalue(String searchkeydatavalue) {
		this.searchkeydatavalue = searchkeydatavalue;
	}
	public String getSearchkeydatatext() {
		return searchkeydatatext;
	}
	public void setSearchkeydatatext(String searchkeydatatext) {
		this.searchkeydatatext = searchkeydatatext;
	}
	
	@Override
	public String getSqlString() {
		String sqlString = this.getSearchname() + " varchar(255)  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
}
