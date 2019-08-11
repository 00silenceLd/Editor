package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * code is far away from bug with the animal protecting ┏┓ ┏┓ ┏┛━━━━┛┻━┓ ┃ ┃ ┃ ━
 * ┃ ┃ ┳┛ ┗┳ ┃ ┃ ┃ ┃ ┻ ┃ ┃ ┃ ┗━┓ ┏━┛ ┃ ┃神兽保佑 ┃ ┃代码无BUG！ ┃ ┗━━━┓ ┃ ┣┓ ┃ ┏┛
 * ┗┓┓┏━┳┓┏┛ ┃┫┫ ┃┫┫ ┗┻┛ ┗┻┛
 *
 *
 * @description : 文章功能类-点赞功能 ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月22日 下午2:46:24
 **/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class FormList extends BaseControl {

	private String nodeid, orgwidth, orgheight, orgfontsize, title, leipiplugins, style, datasource, datafield, tpl,listpich,listpicw,url,listheight,frmexa;

	private Integer pagesize;
	private Integer headshow;
	private String name;
	private String frmedit;
	private String frmdel;
	private String value;
	private String classname;
	private String type;
	private String showpage;
	private String searchcon;
	private String listfontsize;
	private String seardelval;
	private String personage_info;
	
	private String searchbyidorname;
	private String center;
	private String theaderbackground;
	
	

	public String getTheaderbackground() {
		return theaderbackground;
	}

	public void setTheaderbackground(String theaderbackground) {
		this.theaderbackground = theaderbackground;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getSearchbyidorname() {
		return searchbyidorname;
	}

	public void setSearchbyidorname(String searchbyidorname) {
		this.searchbyidorname = searchbyidorname;
	}

	public String getPersonage_info() {
		return personage_info;
	}

	/**
	 * @param personage_info the personage_info to set
	 */
	public void setPersonage_info(String personage_info) {
		this.personage_info = personage_info;
	}

	public String getFrmexa() {
		return frmexa;
	}

	/**
	 * @param frmexa the frmexa to set
	 */
	public void setFrmexa(String frmexa) {
		this.frmexa = frmexa;
	}

	public String getListheight() {
		return listheight;
	}

	/**
	 * @param listheight the listheight to set
	 */
	public void setListheight(String listheight) {
		this.listheight = listheight;
	}

	public String getSeardelval() {
		return seardelval;
	}

	/**
	 * @param seardelval the seardelval to set
	 */
	public void setSeardelval(String seardelval) {
		this.seardelval = seardelval;
	}

	public String getListfontsize() {
		return listfontsize;
	}

	public void setListfontsize(String listfontsize) {
		this.listfontsize = listfontsize;
	}

	public String getSearchcon() {
		return searchcon;
	}

	public void setSearchcon(String searchcon) {
		this.searchcon = searchcon;
	}

	public String getListpich() {
		return listpich;
	}

	public void setListpich(String listpich) {
		this.listpich = listpich;
	}

	public String getListpicw() {
		return listpicw;
	}

	public void setListpicw(String listpicw) {
		this.listpicw = listpicw;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShowpage() {
		return showpage;
	}

	public void setShowpage(String showpage) {
		this.showpage = showpage;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

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

	public String getOrgfontsize() {
		return orgfontsize;
	}

	public void setOrgfontsize(String orgfontsize) {
		this.orgfontsize = orgfontsize;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
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

	public String getTpl() {
		return tpl;
	}

	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public Integer getPagesize() {
		return pagesize;
	}

	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}

	public Integer getHeadshow() {
		return headshow;
	}

	public void setHeadshow(Integer headshow) {
		this.headshow = headshow;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getSqlString() {
		String sqlString = this.getName() + " varchar(255)  COMMENT '" + this.getTitle() + "',";
		return sqlString;
	}

	@Override
	public String toString() {
		return "FormList [nodeid=" + nodeid + ", orgwidth=" + orgwidth + ", orgheight=" + orgheight + ", orgfontsize="
				+ orgfontsize + ", title=" + title + ", leipiplugins=" + leipiplugins + ", style=" + style
				+ ", datasource=" + datasource + ", datafield=" + datafield + ", tpl=" + tpl + ", listpich=" + listpich
				+ ", listpicw=" + listpicw + ", url=" + url + ", listheight=" + listheight + ", frmexa=" + frmexa
				+ ", pagesize=" + pagesize + ", headshow=" + headshow + ", name=" + name + ", frmedit=" + frmedit
				+ ", frmdel=" + frmdel + ", value=" + value + ", classname=" + classname + ", type=" + type
				+ ", showpage=" + showpage + ", searchcon=" + searchcon + ", listfontsize=" + listfontsize
				+ ", seardelval=" + seardelval + ", personage_info=" + personage_info + ", searchbyidorname="
				+ searchbyidorname + ", center=" + center + ", theaderbackground=" + theaderbackground + "]";
	}




}
