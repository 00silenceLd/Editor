package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id 

.CLASS, property = "typeName")	
public class SearchSelect extends BaseControl{
	private String data,name,type,leipiplugins,style,title,value,datasource,orghide,orgthide,orgheight,orgbghide,orgalign,orgwidth,orgtype,searchid,image,identity;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
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

	public String getOrgheight() {
		return orgheight;
	}

	public void setOrgheight(String orgheight) {
		this.orgheight = orgheight;
	}

	public String getOrgbghide() {
		return orgbghide;
	}

	public void setOrgbghide(String orgbghide) {
		this.orgbghide = orgbghide;
	}

	public String getOrgalign() {
		return orgalign;
	}

	public void setOrgalign(String orgalign) {
		this.orgalign = orgalign;
	}

	public String getOrgwidth() {
		return orgwidth;
	}

	public void setOrgwidth(String orgwidth) {
		this.orgwidth = orgwidth;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getSearchid() {
		return searchid;
	}

	public void setSearchid(String searchid) {
		this.searchid = searchid;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}
	

}
