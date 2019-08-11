package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class WxList extends BaseControl {
	private Integer Id;
	private String type, title, value, name, leipiplugins, style, wxsendtype, msgflag, pagesize;

	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
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


	public String getStyle() {
		return style;
	}


	public void setStyle(String style) {
		this.style = style;
	}


	public String getWxsendtype() {
		return wxsendtype;
	}


	public void setWxsendtype(String wxsendtype) {
		this.wxsendtype = wxsendtype;
	}


	public String getMsgflag() {
		return msgflag;
	}


	public void setMsgflag(String msgflag) {
		this.msgflag = msgflag;
	}


	public String getPagesize() {
		return pagesize;
	}


	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}


	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '" + this.getTitle() + "',";
		return sqlString;
	}
}
