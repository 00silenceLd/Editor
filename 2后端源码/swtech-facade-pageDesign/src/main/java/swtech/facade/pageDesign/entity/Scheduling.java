package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")		
public class Scheduling extends BaseControl{
	public String leipiplugins,type,value,title,datasource,datafield,pagesize,headshow,tpl,frmedit,frmdel,showpage,listpicw,listpich,style,name;

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDatafield() {
		return datafield;
	}

	public void setDatafield(String datafield) {
		this.datafield = datafield;
	}

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getHeadshow() {
		return headshow;
	}

	public void setHeadshow(String headshow) {
		this.headshow = headshow;
	}

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getFrmedit() {
		return frmedit;
	}

	public void setFrmedit(String frmedit) {
		this.frmedit = frmedit;
	}

	public String getFrmdel() {
		return frmdel;
	}

	public void setFrmdel(String frmdel) {
		this.frmdel = frmdel;
	}

	public String getShowpage() {
		return showpage;
	}

	public void setShowpage(String showpage) {
		this.showpage = showpage;
	}

	public String getListpicw() {
		return listpicw;
	}

	public void setListpicw(String listpicw) {
		this.listpicw = listpicw;
	}

	public String getListpich() {
		return listpich;
	}

	public void setListpich(String listpich) {
		this.listpich = listpich;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
