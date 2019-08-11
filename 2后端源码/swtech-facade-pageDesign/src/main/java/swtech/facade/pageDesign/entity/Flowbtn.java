package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")	
public class Flowbtn extends  BaseControl{
	private String orgfontsize;
	private String orgbgcolor;
	private String orgfontcolor;
	private String orgheight;
	private String orgvarfontheight;
	private String orgwidth;
	private String orgvarfontwidth; 
	private String orgurl; 
	private String orgflow; 
	private String orgname; 
	private String orgvalue;
	private String onclick;
	private String type;
	private String name;
	private String value;
	private String title;
	private String leipiplugins;
	private String orgformid ;
	
	
	
	public String getOrgfontsize() {
		return orgfontsize;
	}
	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}
	public String getOrgformid() {
		return orgformid;
	}
	public void setOrgformid(String orgformid) {
		this.orgformid = orgformid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrgbgcolor() {
		return orgbgcolor;
	}
	public void setOrgbgcolor(String orgbgcolor) {
		this.orgbgcolor = orgbgcolor;
	}
	public String getOrgfontcolor() {
		return orgfontcolor;
	}
	public void setOrgfontcolor(String orgfontcolor) {
		this.orgfontcolor = orgfontcolor;
	}
	public String getOrgheight() {
		return orgheight;
	}
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}
	public String getOrgvarfontheight() {
		return orgvarfontheight;
	}
	public void setOrgvarfontheight(String orgvarfontheight) {
		this.orgvarfontheight = orgvarfontheight;
	}
	public String getOrgwidth() {
		return orgwidth;
	}
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}
	public String getOrgvarfontwidth() {
		return orgvarfontwidth;
	}
	public void setOrgvarfontwidth(String orgvarfontwidth) {
		this.orgvarfontwidth = orgvarfontwidth;
	}
	public String getOrgurl() {
		return orgurl;
	}
	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
	}
	public String getOrgflow() {
		return orgflow;
	}
	public void setOrgflow(String orgflow) {
		this.orgflow = orgflow;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrgvalue() {
		return orgvalue;
	}
	public void setOrgvalue(String orgvalue) {
		this.orgvalue = orgvalue;
	}
	public String getOnclick() {
		return onclick;
	}
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLeipiplugins() {
		return leipiplugins;
	}
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}
	
	

}
