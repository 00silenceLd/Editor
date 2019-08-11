package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ImageControl extends BaseControl{

	private String name;
	private String src;
	private String title;
	private String type;
	private String value;
    private String datasource;
    private String allowupload;
    private String identity;
    
    private String searchid;
    private String image;
    private String orgpicheight,orgpicwidth,minfilesize,maxfilesize,orgwithin,orgouter,setwtype,sethtype;
    
    
    
    public String getOrgpicheight() {
		return orgpicheight;
	}
	public void setOrgpicheight(String orgpicheight) {
		this.orgpicheight = orgpicheight;
	}
	public String getOrgpicwidth() {
		return orgpicwidth;
	}
	public void setOrgpicwidth(String orgpicwidth) {
		this.orgpicwidth = orgpicwidth;
	}
	public String getMinfilesize() {
		return minfilesize;
	}
	public void setMinfilesize(String minfilesize) {
		this.minfilesize = minfilesize;
	}
	public String getMaxfilesize() {
		return maxfilesize;
	}
	public void setMaxfilesize(String maxfilesize) {
		this.maxfilesize = maxfilesize;
	}
	public String getOrgwithin() {
		return orgwithin;
	}
	public void setOrgwithin(String orgwithin) {
		this.orgwithin = orgwithin;
	}
	public String getOrgouter() {
		return orgouter;
	}
	public void setOrgouter(String orgouter) {
		this.orgouter = orgouter;
	}
	public String getSetwtype() {
		return setwtype;
	}
	public void setSetwtype(String setwtype) {
		this.setwtype = setwtype;
	}
	public String getSethtype() {
		return sethtype;
	}
	public void setSethtype(String sethtype) {
		this.sethtype = sethtype;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSearchid() {
		return searchid;
	}
	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getAllowupload() {
		return allowupload;
	}
	public void setAllowupload(String allowupload) {
		this.allowupload = allowupload;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getSqlString() {
		String sqlString = this.getName() + " TEXT  COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}
	
	@Override
	public String toString() {
		return "ImageControl [name=" + name + ", src=" + src + ", title=" + title + ", type=" + type + ", value="
				+ value + ", datasource=" + datasource + ", allowupload=" + allowupload + "]";
	}
}
