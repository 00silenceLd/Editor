package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/** 
* @author 王小东
* @date 2018年12月19日 下午5:32:49 
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class Meetinglist extends BaseControl{
	
	private String name,leipiplugins,type,value,title,datasource,datafield,pagesize,headshow,tpl,showpage,listpicw,listpich,roomurl,searchcon,seardelval,listfontsize,style,mtype,mtitle;

	public String getMtitle() {
		return mtitle;
	}

	/**
	 * @param mtitle the mtitle to set
	 */
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
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

	public String getSearchcon() {
		return searchcon;
	}

	/**
	 * @param searchcon the searchcon to set
	 */
	public void setSearchcon(String searchcon) {
		this.searchcon = searchcon;
	}

	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getLeipiplugins() {
		return leipiplugins;
	}

	/**
	 * @param leipiplugins the leipiplugins to set
	 */
	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDatasource() {
		return datasource;
	}

	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getDatafield() {
		return datafield;
	}

	/**
	 * @param datafield the datafield to set
	 */
	public void setDatafield(String datafield) {
		this.datafield = datafield;
	}

	public String getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	public String getHeadshow() {
		return headshow;
	}

	/**
	 * @param headshow the headshow to set
	 */
	public void setHeadshow(String headshow) {
		this.headshow = headshow;
	}

	public String getTpl() {
		return tpl;
	}

	/**
	 * @param tpl the tpl to set
	 */
	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getShowpage() {
		return showpage;
	}

	/**
	 * @param showpage the showpage to set
	 */
	public void setShowpage(String showpage) {
		this.showpage = showpage;
	}

	public String getListpicw() {
		return listpicw;
	}

	/**
	 * @param listpicw the listpicw to set
	 */
	public void setListpicw(String listpicw) {
		this.listpicw = listpicw;
	}

	public String getListpich() {
		return listpich;
	}

	/**
	 * @param listpich the listpich to set
	 */
	public void setListpich(String listpich) {
		this.listpich = listpich;
	}

	public String getRoomurl() {
		return roomurl;
	}

	/**
	 * @param roomurl the roomurl to set
	 */
	public void setRoomurl(String roomurl) {
		this.roomurl = roomurl;
	}

	public String getListfontsize() {
		return listfontsize;
	}

	/**
	 * @param listfontsize the listfontsize to set
	 */
	public void setListfontsize(String listfontsize) {
		this.listfontsize = listfontsize;
	}

	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	public String getMtype() {
		return mtype;
	}

	/**
	 * @param mtype the mtype to set
	 */
	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	
	
}
 
