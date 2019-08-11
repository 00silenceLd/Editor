package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
public class ListOne extends BaseControl{
	private Integer Id;
	private String type, title, value, name, leipiplugins, style, datasource, pagesize,datapic,datatitle,datacontent,datacontent2, colnumber, bottomline,showpage,orderby,tpl,titlesize,consize,listpich,listpicw,url,titlelabel,conlabel,frmedit,frmdel,fontsize;
	private String searchcon,seardelval,listheight,picfontsize,isnotuser,typesevendate,typesevenurl;

	private String prefix,isheader,headertitle,moreurl,headercolor,titlecolor;

	private String iscomment;

	private String outborder,prefixcolor;

	private String headstyle,headimgsrc;

	private String pagingstyle;

	private String isscore;

	private String onlyshowone;

	private String multisource;
	private String multititles;
	private String multisourcenames;
	private String multinodeids;

	private String multidatapics;
	private String multidatatitles;
	private String multidatacontents;
	private String multititlesizes;
	private String multiconsizes;
	private String multititlelabels;
	private String multiconlabels;
	private String multifontsizes;
	private String multilistpicws;
	private String multilistpichs;
	private String multilisturls;
	private String multisearchcons;
	private String multiseardelvals;
	private String multipicfontsizes;
	private String multilistheights;
	private String multirowsourcecount;
	private String multisourcepublic;
	private String iscolor;



	public String getDatacontent2() {
		return datacontent2;
	}
	public void setDatacontent2(String datacontent2) {
		this.datacontent2 = datacontent2;
	}
	public String getTypesevendate() {
		return typesevendate;
	}
	public void setTypesevendate(String typesevendate) {
		this.typesevendate = typesevendate;
	}
	
	public String getIscolor() {
		return iscolor;
	}
	public void setIscolor(String iscolor) {
		this.iscolor = iscolor;
	}
	public String getMultisourcepublic() {
		return multisourcepublic;
	}
	public void setMultisourcepublic(String multisourcepublic) {
		this.multisourcepublic = multisourcepublic;
	}
	public String getMultirowsourcecount() {
		return multirowsourcecount;
	}
	public void setMultirowsourcecount(String multirowsourcecount) {
		this.multirowsourcecount = multirowsourcecount;
	}
	public String getOnlyshowone() {
		return onlyshowone;
	}
	public void setOnlyshowone(String onlyshowone) {
		this.onlyshowone = onlyshowone;
	}
	public String getMultisource() {
		return multisource;
	}
	public void setMultisource(String multisource) {
		this.multisource = multisource;
	}
	public String getMultititles() {
		return multititles;
	}
	public void setMultititles(String multititles) {
		this.multititles = multititles;
	}
	public String getMultisourcenames() {
		return multisourcenames;
	}
	public void setMultisourcenames(String multisourcenames) {
		this.multisourcenames = multisourcenames;
	}
	public String getMultinodeids() {
		return multinodeids;
	}
	public void setMultinodeids(String multinodeids) {
		this.multinodeids = multinodeids;
	}
	public String getMultidatapics() {
		return multidatapics;
	}
	public void setMultidatapics(String multidatapics) {
		this.multidatapics = multidatapics;
	}
	public String getMultidatatitles() {
		return multidatatitles;
	}
	public void setMultidatatitles(String multidatatitles) {
		this.multidatatitles = multidatatitles;
	}
	public String getMultidatacontents() {
		return multidatacontents;
	}
	public void setMultidatacontents(String multidatacontents) {
		this.multidatacontents = multidatacontents;
	}
	public String getMultititlesizes() {
		return multititlesizes;
	}
	public void setMultititlesizes(String multititlesizes) {
		this.multititlesizes = multititlesizes;
	}
	public String getMulticonsizes() {
		return multiconsizes;
	}
	public void setMulticonsizes(String multiconsizes) {
		this.multiconsizes = multiconsizes;
	}
	public String getMultititlelabels() {
		return multititlelabels;
	}
	public void setMultititlelabels(String multititlelabels) {
		this.multititlelabels = multititlelabels;
	}
	public String getMulticonlabels() {
		return multiconlabels;
	}
	public void setMulticonlabels(String multiconlabels) {
		this.multiconlabels = multiconlabels;
	}
	public String getMultifontsizes() {
		return multifontsizes;
	}
	public void setMultifontsizes(String multifontsizes) {
		this.multifontsizes = multifontsizes;
	}
	public String getMultilistpicws() {
		return multilistpicws;
	}
	public void setMultilistpicws(String multilistpicws) {
		this.multilistpicws = multilistpicws;
	}
	public String getMultilistpichs() {
		return multilistpichs;
	}
	public void setMultilistpichs(String multilistpichs) {
		this.multilistpichs = multilistpichs;
	}
	public String getMultilisturls() {
		return multilisturls;
	}
	public void setMultilisturls(String multilisturls) {
		this.multilisturls = multilisturls;
	}
	public String getMultisearchcons() {
		return multisearchcons;
	}
	public void setMultisearchcons(String multisearchcons) {
		this.multisearchcons = multisearchcons;
	}
	public String getMultiseardelvals() {
		return multiseardelvals;
	}
	public void setMultiseardelvals(String multiseardelvals) {
		this.multiseardelvals = multiseardelvals;
	}
	public String getMultipicfontsizes() {
		return multipicfontsizes;
	}
	public void setMultipicfontsizes(String multipicfontsizes) {
		this.multipicfontsizes = multipicfontsizes;
	}
	public String getMultilistheights() {
		return multilistheights;
	}
	public void setMultilistheights(String multilistheights) {
		this.multilistheights = multilistheights;
	}
	public String getIsscore() {
		return isscore;
	}
	public void setIsscore(String isscore) {
		this.isscore = isscore;
	}
	public String getPagingstyle() {
		return pagingstyle;
	}
	public void setPagingstyle(String pagingstyle) {
		this.pagingstyle = pagingstyle;
	}
	public String getHeadstyle() {
		return headstyle;
	}
	public void setHeadstyle(String headstyle) {
		this.headstyle = headstyle;
	}
	public String getHeadimgsrc() {
		return headimgsrc;
	}
	public void setHeadimgsrc(String headimgsrc) {
		this.headimgsrc = headimgsrc;
	}
	public String getOutborder() {
		return outborder;
	}
	public void setOutborder(String outborder) {
		this.outborder = outborder;
	}
	public String getPrefixcolor() {
		return prefixcolor;
	}
	public void setPrefixcolor(String prefixcolor) {
		this.prefixcolor = prefixcolor;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getIsheader() {
		return isheader;
	}
	public void setIsheader(String isheader) {
		this.isheader = isheader;
	}
	public String getHeadertitle() {
		return headertitle;
	}
	public void setHeadertitle(String headertitle) {
		this.headertitle = headertitle;
	}

	public String getMoreurl() {
		return moreurl;
	}
	public void setMoreurl(String moreurl) {
		this.moreurl = moreurl;
	}
	public String getHeadercolor() {
		return headercolor;
	}
	public void setHeadercolor(String headercolor) {
		this.headercolor = headercolor;
	}
	public String getTitlecolor() {
		return titlecolor;
	}
	public void setTitlecolor(String titlecolor) {
		this.titlecolor = titlecolor;
	}
	public String getIsnotuser() {
		return isnotuser;
	}
	/**
	 * @param isnotuser the isnotuser to set
	 */
	public void setIsnotuser(String isnotuser) {
		this.isnotuser = isnotuser;
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
	public String getPicfontsize() {
		return picfontsize;
	}
	/**
	 * @param picfontsize the picfontsize to set
	 */
	public void setPicfontsize(String picfontsize) {
		this.picfontsize = picfontsize;
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
	public String getSeardelval() {
		return seardelval;
	}
	/**
	 * @param seardelval the seardelval to set
	 */
	public void setSeardelval(String seardelval) {
		this.seardelval = seardelval;
	}
	public String getFontsize() {
		return fontsize;
	}
	/**
	 * @param fontsize the fontsize to set
	 */
	public void setFontsize(String fontsize) {
		this.fontsize = fontsize;
	}
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
	public String getDatasource() {
		return datasource;
	}
	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	public String getDatapic() {
		return datapic;
	}
	public void setDatapic(String datapic) {
		this.datapic = datapic;
	}
	public String getDatatitle() {
		return datatitle;
	}
	public void setDatatitle(String datatitle) {
		this.datatitle = datatitle;
	}
	public String getDatacontent() {
		return datacontent;
	}
	public void setDatacontent(String datacontent) {
		this.datacontent = datacontent;
	}
	public String getColnumber() {
		return colnumber;
	}
	public void setColnumber(String colnumber) {
		this.colnumber = colnumber;
	}
	public String getBottomline() {
		return bottomline;
	}
	public void setBottomline(String bottomline) {
		this.bottomline = bottomline;
	}
	public String getShowpage() {
		return showpage;
	}
	public void setShowpage(String showpage) {
		this.showpage = showpage;
	}
	public String getOrderby() {
		return orderby;
	}
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getTpl() {
		return tpl;
	}
	public void setTpl(String tpl) {
		this.tpl = tpl;
	}

	public String getTitlesize() {
		return titlesize;
	}
	public void setTitlesize(String titlesize) {
		this.titlesize = titlesize;
	}
	public String getConsize() {
		return consize;
	}
	public void setConsize(String consize) {
		this.consize = consize;
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

	public String getTitlelabel() {
		return titlelabel;
	}
	public void setTitlelabel(String titlelabel) {
		this.titlelabel = titlelabel;
	}
	public String getConlabel() {
		return conlabel;
	}
	public void setConlabel(String conlabel) {
		this.conlabel = conlabel;
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
	public String getIscomment() {
		return iscomment;
	}
	public void setIscomment(String iscomment) {
		this.iscomment = iscomment;
	}
	public String getTypesevenurl() {
		return typesevenurl;
	}
	public void setTypesevenurl(String typesevenurl) {
		this.typesevenurl = typesevenurl;
	}
	@Override
	public String toString() {
		return "ListOne [Id=" + Id + ", type=" + type + ", title=" + title + ", value=" + value + ", name=" + name
				+ ", leipiplugins=" + leipiplugins + ", style=" + style + ", datasource=" + datasource + ", pagesize="
				+ pagesize + ", datapic=" + datapic + ", datatitle=" + datatitle + ", datacontent=" + datacontent
				+ ", datacontent2=" + datacontent2 + ", colnumber=" + colnumber + ", bottomline=" + bottomline
				+ ", showpage=" + showpage + ", orderby=" + orderby + ", tpl=" + tpl + ", titlesize=" + titlesize
				+ ", consize=" + consize + ", listpich=" + listpich + ", listpicw=" + listpicw + ", url=" + url
				+ ", titlelabel=" + titlelabel + ", conlabel=" + conlabel + ", frmedit=" + frmedit + ", frmdel="
				+ frmdel + ", fontsize=" + fontsize + ", searchcon=" + searchcon + ", seardelval=" + seardelval
				+ ", listheight=" + listheight + ", picfontsize=" + picfontsize + ", isnotuser=" + isnotuser
				+ ", typesevendate=" + typesevendate + ", typesevenurl=" + typesevenurl + ", prefix=" + prefix
				+ ", isheader=" + isheader + ", headertitle=" + headertitle + ", moreurl=" + moreurl + ", headercolor="
				+ headercolor + ", titlecolor=" + titlecolor + ", iscomment=" + iscomment + ", outborder=" + outborder
				+ ", prefixcolor=" + prefixcolor + ", headstyle=" + headstyle + ", headimgsrc=" + headimgsrc
				+ ", pagingstyle=" + pagingstyle + ", isscore=" + isscore + ", onlyshowone=" + onlyshowone
				+ ", multisource=" + multisource + ", multititles=" + multititles + ", multisourcenames="
				+ multisourcenames + ", multinodeids=" + multinodeids + ", multidatapics=" + multidatapics
				+ ", multidatatitles=" + multidatatitles + ", multidatacontents=" + multidatacontents
				+ ", multititlesizes=" + multititlesizes + ", multiconsizes=" + multiconsizes + ", multititlelabels="
				+ multititlelabels + ", multiconlabels=" + multiconlabels + ", multifontsizes=" + multifontsizes
				+ ", multilistpicws=" + multilistpicws + ", multilistpichs=" + multilistpichs + ", multilisturls="
				+ multilisturls + ", multisearchcons=" + multisearchcons + ", multiseardelvals=" + multiseardelvals
				+ ", multipicfontsizes=" + multipicfontsizes + ", multilistheights=" + multilistheights
				+ ", multirowsourcecount=" + multirowsourcecount + ", multisourcepublic=" + multisourcepublic
				+ ", iscolor=" + iscolor + "]";
	}


}
