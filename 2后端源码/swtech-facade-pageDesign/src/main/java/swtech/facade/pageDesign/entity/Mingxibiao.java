/**
 * 
 */
package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * @author 77568
 *
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "mingxibiao")
public class Mingxibiao extends BaseControl{

	private Integer id;
	
	private String name;
	
	private String title;
	
	private String leipiplugins;
	
	private String orgname;
	
	private String orgwidth;
	
	private String orgid;
	
	private String recordid;
	
	private String orgfontcolor;
	
	private String orgurl;
	
	private String fontsize;
	
	private String placeholder;
	
	private String size;
	

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}

	public String getOrgfontcolor() {
		return orgfontcolor;
	}

	public void setOrgfontcolor(String orgfontcolor) {
		this.orgfontcolor = orgfontcolor;
	}

	public String getOrgurl() {
		return orgurl;
	}

	public void setOrgurl(String orgurl) {
		this.orgurl = orgurl;
	}

	public String getFontsize() {
		return fontsize;
	}

	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
