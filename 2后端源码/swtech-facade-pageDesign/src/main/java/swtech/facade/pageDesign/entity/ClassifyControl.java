package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")	
public class ClassifyControl extends BaseControl {

	private String cid;
	private String sonid;
	private Integer nid;
	private String name;
	private String title;
	private String type;
	private String leipiplugins;
	private String value;
	private String classtype,datasource,datafiled;



	public String getDatasource() {
		return datasource;
	}

	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDatafiled() {
		return datafiled;
	}

	/**
	 * @param datafiled the datafiled to set
	 */
	public void setDatafiled(String datafiled) {
		this.datafiled = datafiled;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getSonid() {
		return sonid;
	}

	public void setSonid(String sonid) {
		this.sonid = sonid;
	}

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getClasstype() {
		return classtype;
	}

	public void setClasstype(String classtype) {
		this.classtype = classtype;
	}

	
}
