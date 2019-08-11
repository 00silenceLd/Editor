package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo; 
 
 

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class TextControl extends BaseControl {  
	private String orghide;
	private String orgthide;
	private String orgbghide;
	private String orgwidth;
	private String value;
    private String orgalign;
    private String orgfontsize;
    private String orgheight;
    private String type; 
    private String orgtype;
    private String datasource;
    private String maxlength;
    private Integer lineclamp;
    private String disabled;
    private String orgdisabled;
    private String value_2;
    private String orgprintlength;
    private String fontset;
    private String writenickname;
   
    
    public String getWritenickname() {
		return writenickname;
	}
	public void setWritenickname(String writenickname) {
		this.writenickname = writenickname;
	}
	public String getFontset() {
		return fontset;
	}
	/**
	 * @param fontset the fontset to set
	 */
	public void setFontset(String fontset) {
		this.fontset = fontset;
	}
	public String getValue_2() {
		return value_2;
	}
	public void setValue_2(String value_2) {
		this.value_2 = value_2;
	}
	public String getOrgprintlength() {
		return orgprintlength;
	}
	public void setOrgprintlength(String orgprintlength) {
		this.orgprintlength = orgprintlength;
	}
	private String searchid;
    
 
	public String getMaxlength() {
		return maxlength;
	}
	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}
	public String getOrgdisabled() {
		return orgdisabled;
	}
	public void setOrgdisabled(String orgdisabled) {
		this.orgdisabled = orgdisabled;
	}
	
	public Integer getLineclamp() {
		return lineclamp;
	}
	public void setLineclamp(Integer lineclamp) {
		this.lineclamp = lineclamp;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public String getSearchid() {
		return searchid;
	}
	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}
	public String getDataid() {
		return dataid;
	}
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		//&quot;
		if(datasource.contains("&quot;")) {
			this.datasource = datasource = datasource.replaceAll("&quot;", "\"");
		}else {
			this.datasource = datasource;
		}
		
	}
	public String getOrgbghide() {
		return orgbghide;
	}

	public void setOrgbghide(String orgbghide) {
		this.orgbghide = orgbghide;
	}

	public String getOrgthide() {
		return orgthide;
	}

	public void setOrgthide(String orgthide) {
		this.orgthide = orgthide;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getOrgfontsize() {
		return orgfontsize;
	}

	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}

	public String getOrgheight() {
		return orgheight;
	}

	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}

	public String getOrgalign() {
		return orgalign;
	}

	public void setOrgalign(String orgalign) {
		this.orgalign = orgalign;
	}
 
    
	public String getOrghide() {
		return orghide;
	}

	public void setOrghide(String orghide) {
		this.orghide = orghide;
	} 

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	 

	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " TEXT COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	public String rendHtml() {
		String htmlString = "<input type=\"text\" value=\""+this.getValue()+"\"  name=\""+this.getName()+"\"  style=\""+this.getStyle()+"\"/>";
		return htmlString;
	}


	private String dataid;
	private String datafield;



	public String getDatafield() {
		return datafield;
	}
	public void setDatafield(String datafield) {
		this.datafield = datafield;
	}
	@Override
	public String toString() {
		return "TextControl [orghide=" + orghide + ", orgthide=" + orgthide + ", orgbghide=" + orgbghide + ", orgwidth="
				+ orgwidth + ", value=" + value + ", orgalign=" + orgalign + ", orgfontsize=" + orgfontsize
				+ ", orgheight=" + orgheight + ", type=" + type + ", orgtype=" + orgtype + ", datasource=" + datasource
				+ ", maxlength=" + maxlength + ", lineclamp=" + lineclamp + ", disabled=" + disabled + ", orgdisabled="
				+ orgdisabled + ", value_2=" + value_2 + ", orgprintlength=" + orgprintlength + ", fontset=" + fontset
				+ ", writenickname=" + writenickname + ", searchid=" + searchid + ", dataid=" + dataid + ", datafield="
				+ datafield + "]";
	}
	
	

	
	 
}