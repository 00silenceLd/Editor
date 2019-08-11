package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
 * 报名控件
* @author 王小东
* @date 2018年11月2日 上午10:04:02 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Addnumber extends BaseControl {
	private String name,leipiplugins,mode,orgtitle,orgsrc,value,orgheight,orgwidth,orgfontsize,orgbgcolor,orgfontcolor,datasource,datafiled,addvalue;

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getAddvalue() {
		return addvalue;
	}

	/**
	 * @param addvalue the addvalue to set
	 */
	public void setAddvalue(String addvalue) {
		this.addvalue = addvalue;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	/**
	 * @param leipiplugins the leipiplugins to set
	 */
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getOrgtitle() {
		return orgtitle;
	}

	/**
	 * @param orgtitle the orgtitle to set
	 */
	public void setOrgtitle(String orgtitle) {
		this.orgtitle = orgtitle;
	}

	public String getOrgsrc() {
		return orgsrc;
	}

	/**
	 * @param orgsrc the orgsrc to set
	 */
	public void setOrgsrc(String orgsrc) {
		this.orgsrc = orgsrc;
	}

	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String getOrgheight() {
		return orgheight;
	}

	/**
	 * @param orgheight the orgheight to set
	 */
	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	/**
	 * @param orgwidth the orgwidth to set
	 */
	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getOrgfontsize() {
		return orgfontsize;
	}

	/**
	 * @param orgfontsize the orgfontsize to set
	 */
	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}

	public String getOrgbgcolor() {
		return orgbgcolor;
	}

	/**
	 * @param orgbgcolor the orgbgcolor to set
	 */
	public void setOrgbgcolor(String orgbgcolor) {
		this.orgbgcolor = orgbgcolor;
	}

	public String getOrgfontcolor() {
		return orgfontcolor;
	}

	/**
	 * @param orgfontcolor the orgfontcolor to set
	 */
	public void setOrgfontcolor(String orgfontcolor) {
		this.orgfontcolor = orgfontcolor;
	}

	public String getDatasource() {
		return datasource;
	}

	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDatafiled() {
		return datafiled;
	}

	/**
	 * @param datafiled the datafiled to set
	 */
	public void setDatafiled(String datafiled) {
		this.datafiled = datafiled;
	}

}
 
