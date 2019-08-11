package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

import swtech.common.entity.BaseEntity;

/** 
*
* @author 林致杰
*
* @Email: 1003392067@qq.com
*
* @version 创建时间：2018年1月25日 下午3:35:48 
*
* 路由控件
*/

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class iFrameRouterControl  extends BaseControl{

/*	orderby - 方位
	orgchecked - 默认选中路由
	orgsrc - 图标base64格式 ( 你到时候返回个我，需要返回一个链接给我 )
	orgtarget - 目标链接
	orgtitle - 标题*/
	
	private String orderby;
	private String orgchecked;
	private String orgsrc;
	private String orgtarget;
	private String orgtitle;
	private String type;
	private String style,orgwidth, orgheight;

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
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	public String getOrgchecked() {
		return orgchecked;
	}
	public void setOrgchecked(String orgchecked) {
		this.orgchecked = orgchecked;
	}
	public String getOrgsrc() {
		return orgsrc;
	}
	public void setOrgsrc(String orgsrc) {
		this.orgsrc = orgsrc;
	}
	public String getOrgtarget() {
		return orgtarget;
	}
	public void setOrgtarget(String orgtarget) {
		this.orgtarget = orgtarget;
	}
	public String getOrgtitle() {
		return orgtitle;
	}
	public void setOrgtitle(String orgtitle) {
		this.orgtitle = orgtitle;
	}
	
	@Override
	public String toString() {
		return "iFrameRouterControl [orderby=" + orderby + ", orgchecked=" + orgchecked + ", orgsrc=" + orgsrc
				+ ", orgtarget=" + orgtarget + ", orgtitle=" + orgtitle + "]";
	}	
	
	public String getSqlString() {
		String sqlString = this.getName() + " TEXT  COMMENT '"
				+ this.getOrgtitle() + "',";
		return sqlString;
	}
	
}
 