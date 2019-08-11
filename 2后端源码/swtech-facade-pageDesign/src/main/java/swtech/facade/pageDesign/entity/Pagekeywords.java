package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo; 



@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Pagekeywords extends BaseControl {  

	private String value; 
	private String type; 
	private String pagetitle; 
	private String keywords; 
	private String description;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPagetitle() {
		return pagetitle;
	}
	public void setPagetitle(String pagetitle) {
		this.pagetitle = pagetitle;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Pagekeywords [value=" + value + ", type=" + type + ", pagetitle=" + pagetitle + ", keywords=" + keywords
				+ ", description=" + description + "]";
	} 
	
	
	
	





}