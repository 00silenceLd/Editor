package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
*
* @author 林致杰
*
* @Email: 1003392067@qq.com
*
* @version 创建时间：2018年1月31日 上午9:42:21 
*
* 热区控件
*/


@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class wifiBlockControl extends BaseControl {
/*	
	leipiplugins - 控件名称 - wifiBlock
	name - 控件标识
	orgalign - 对齐方式
	orgborder - 边框
	orgfonts - 字体
	orgheight -高度
	orgwidth - 宽度
	orgradius - 圆角
	title - 标题
	value - -值
	orgbghide - 背景隐藏
	orghide - 控件隐藏
	orgthide - 隐藏边框
	orgurl - 对应Url
*/

	private String orgalign;
	private String orgborder;
	private String orgfonts;
	private String orgheight;
	private String orgwidth;
	private String orgradius;
	private String value;
	private String orgbghide;
	private String orghide;
	private String orgthide;
	private String orgurl;
	private String orgcolor;
	

	public String getOrgcolor() {
		return orgcolor;
	}


	public void setOrgcolor(String orgcolor) {
		this.orgcolor = orgcolor;
	}


	public String getOrgalign() {
		return orgalign;
	}


	public void setOrgalign(String orgalign) {
		this.orgalign = orgalign;
	}


	public String getOrgborder() {
		return orgborder;
	}


	public void setOrgborder(String orgborder) {
		this.orgborder = orgborder;
	}


	public String getOrgfonts() {
		return orgfonts;
	}


	public void setOrgfonts(String orgfonts) {
		this.orgfonts = orgfonts;
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


	public String getOrgradius() {
		return orgradius;
	}


	public void setOrgradius(String orgradius) {
		this.orgradius = orgradius;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getOrgbghide() {
		return orgbghide;
	}


	public void setOrgbghide(String orgbghide) {
		this.orgbghide = orgbghide;
	}


	public String getOrghide() {
		return orghide;
	}


	public void setOrghide(String orghide) {
		this.orghide = orghide;
	}


	public String getOrgthide() {
		return orgthide;
	}


	public void setOrgthide(String orgthide) {
		this.orgthide = orgthide;
	}


	public String getOrgurl() {
		return orgurl;
	}


	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
	}


	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}


	@Override
	public String toString() {
		return "wifiBlockControl [orgalign=" + orgalign + ", orgborder=" + orgborder + ", orgfonts=" + orgfonts
				+ ", orgheight=" + orgheight + ", orgwidth=" + orgwidth + ", orgradius=" + orgradius + ", value="
				+ value + ", orgbghide=" + orgbghide + ", orghide=" + orghide + ", orgthide=" + orgthide + ", orgurl="
				+ orgurl + "]";
	}
	
	
}
 