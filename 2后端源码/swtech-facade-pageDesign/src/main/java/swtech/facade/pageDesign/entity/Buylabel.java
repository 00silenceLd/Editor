package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Buylabel extends BaseControl {
	private Integer Id;
	private String  name , leipiplugins , mode , orgtitle , orgsrc , value , orgheight , orgwidth , orgfontsize , orgbgcolor , orgfontcolor , orgfurl , orgurl;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLeipiplugins() {
		return leipiplugins;
	}
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getOrgtitle() {
		return orgtitle;
	}
	public void setOrgtitle(String orgtitle) {
		this.orgtitle = orgtitle;
	}
	public String getOrgsrc() {
		return orgsrc;
	}
	public void setOrgsrc(String orgsrc) {
		this.orgsrc = orgsrc;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOrgheight() {
		return orgheight;
	}
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}
	public String getOrgwidth() {
		return orgwidth;
	}
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}
	public String getOrgfontsize() {
		return orgfontsize;
	}
	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
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
	public String getOrgfurl() {
		return orgfurl;
	}
	public void setOrgfurl(String orgfurl) {
		this.orgfurl = orgfurl;
	}
	public String getOrgurl() {
		return orgurl;
	}
	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
	}
	
}
