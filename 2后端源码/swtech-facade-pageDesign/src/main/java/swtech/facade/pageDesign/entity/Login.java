package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 登陆控件
* @author 王小东
* @date 2018年11月27日 上午11:34:51 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Login extends BaseControl{
	
	private String name ,leipiplugins ,mode ,orgtitle ,value ,orgheight ,orgwidth ,orgfontsize ,orgbgcolor ,orgfontcolor;

	private String toaccount;
	
	
	public String getToaccount() {
		return toaccount;
	}

	public void setToaccount(String toaccount) {
		this.toaccount = toaccount;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Login [name=" + name + ", leipiplugins=" + leipiplugins + ", mode=" + mode + ", orgtitle=" + orgtitle
				+ ", value=" + value + ", orgheight=" + orgheight + ", orgwidth=" + orgwidth + ", orgfontsize="
				+ orgfontsize + ", orgbgcolor=" + orgbgcolor + ", orgfontcolor=" + orgfontcolor + ", toaccount="
				+ toaccount + "]";
	}
	
	
	
	

}
 
