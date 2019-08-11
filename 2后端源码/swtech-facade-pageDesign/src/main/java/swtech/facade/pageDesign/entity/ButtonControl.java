package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 类说明
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月3日 上午11:32:32
 **/

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ButtonControl extends BaseControl{

	private String orgname;
	private String orderby;
	private String mode;
	private String orgtitle;
	private String orgwidth;
	private String orgheight;
	private String orgsrc;
	private String orgurl;
	private String orgbgcolor;
	private String orgfontcolor,formnode,btntype,tgnode,winname,orgid;
	private String placeholder;
	private String fontsize;
     
	
	public String getFontsize() {
		return fontsize;
	}
	/**
	 * @param fontsize the fontsize to set
	 */
	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public String getWinname() {
		return winname;
	}
	public void setWinname(String winname) {
		this.winname = winname;
	}
	public String getTgnode() {
		return tgnode;
	}
	public void setTgnode(String tgnode) {
		this.tgnode = tgnode;
	}
	public String getFormnode() {
		return formnode;
	}
	public void setFormnode(String formnode) {
		this.formnode = formnode;
	}
	public String getBtntype() {
		return btntype;
	}
	public void setBtntype(String btntype) {
		this.btntype = btntype;
	}
	public String getOrgname() {
		return orgname;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
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
	public String getOrgsrc() {
		return orgsrc;
	}
	public void setOrgsrc(String orgsrc) {
		this.orgsrc = orgsrc;
	}
	public String getOrgurl() {
		return orgurl;
	}
	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
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
	

	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
	@Override
	public String toString() {
		return "ButtonControl [orgname=" + orgname + ", orderby=" + orderby + ", mode=" + mode + ", orgtitle="
				+ orgtitle + ", orgwidth=" + orgwidth + ", orgheight=" + orgheight + ", orgsrc=" + orgsrc + ", orgurl="
				+ orgurl + ", orgbgcolor=" + orgbgcolor + ", orgfontcolor=" + orgfontcolor  
				 + "]";
	}
	
	
}
 