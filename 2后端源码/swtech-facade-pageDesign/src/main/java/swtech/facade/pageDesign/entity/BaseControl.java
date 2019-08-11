package swtech.facade.pageDesign.entity;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

import swtech.common.entity.BaseEntity;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "leipiplugins")
@JsonSubTypes({
	@JsonSubTypes.Type(value = Getuserid.class, name = "getuserid"),
	@JsonSubTypes.Type(value = Meetinglist.class, name = "meetinglist"),
	@JsonSubTypes.Type(value = Liannanzugong.class, name = "liannanzugong"),
	@JsonSubTypes.Type(value = Internal.class, name = "internal"),
	@JsonSubTypes.Type(value = Exchange.class, name = "exchange"),
	@JsonSubTypes.Type(value = Login.class, name = "login"),
	@JsonSubTypes.Type(value = Shenpi.class, name = "shenpi"),
	@JsonSubTypes.Type(value = Export.class, name = "export"),
	@JsonSubTypes.Type(value = Background.class, name = "background"),
	@JsonSubTypes.Type(value = Recordlabel.class, name = "recordlabel"),
	@JsonSubTypes.Type(value = Addnumber.class, name = "addnumber"),
	@JsonSubTypes.Type(value = Lunbo.class, name = "lunbo"),
	@JsonSubTypes.Type(value = Popup.class, name = "popup"),
	@JsonSubTypes.Type(value = Scheduling.class, name = "scheduling"),
	@JsonSubTypes.Type(value = Buylabel.class, name = "buylabel"),
	@JsonSubTypes.Type(value = TimeDate.class, name = "timedate"),
	@JsonSubTypes.Type(value = ListOne.class, name = "listone"),
	@JsonSubTypes.Type(value = WxList.class, name = "wxlist"),
	@JsonSubTypes.Type(value = SettimeoutControl.class, name = "settimeout"),
	@JsonSubTypes.Type(value = SearchControl.class, name = "searchcontrol"),
	@JsonSubTypes.Type(value = SortSearch.class, name = "sortSearch"),
	@JsonSubTypes.Type(value = ClassifyControl.class, name = "classify"),
	@JsonSubTypes.Type(value = Daydate.class, name = "daydate"),
	@JsonSubTypes.Type(value = Flowbtn.class, name = "flowbtn"),
	@JsonSubTypes.Type(value = SearchSelect.class, name = "searchSelect"),
	@JsonSubTypes.Type(value = Slidebox.class, name = "slidebox"),
	@JsonSubTypes.Type(value = WxGroupTag.class, name = "wxgrouptag"),
	@JsonSubTypes.Type(value = FormList.class, name = "formlist"),
	//@JsonSubTypes.Type(value = Search.class, name = "search"),
	@JsonSubTypes.Type(value = SearchSelect.class, name = "searchSelect"),
	@JsonSubTypes.Type(value = Onlinehard.class, name = "onlinehard"),
	@JsonSubTypes.Type(value = Workword.class, name = "workword"),
	@JsonSubTypes.Type(value = Workform.class, name = "workform"),
	@JsonSubTypes.Type(value = Workflow.class, name = "workflow"),
	@JsonSubTypes.Type(value = Schedule.class, name = "schedule"),
	@JsonSubTypes.Type(value = Task.class, name = "task"),
	@JsonSubTypes.Type(value = Beike.class, name = "beike"),
	@JsonSubTypes.Type(value = Resource.class, name = "resource"),
	@JsonSubTypes.Type(value = Teach.class, name = "teach"),
	@JsonSubTypes.Type(value = Classes.class, name = "classes"),
	@JsonSubTypes.Type(value = Curriculum.class, name = "curriculum"),
	@JsonSubTypes.Type(value = Jiangtang.class, name = "jiangtang"),
	@JsonSubTypes.Type(value = Zujuan.class, name = "zujuan"),
	@JsonSubTypes.Type(value = Yuejuan.class, name = "yuejuan"),
	@JsonSubTypes.Type(value = Chaxun.class, name = "chaxun"),
	@JsonSubTypes.Type(value = Audit.class, name = "audit"),
	@JsonSubTypes.Type(value = Mingxibiao.class, name = "mingxibiao"),
	@JsonSubTypes.Type(value = JobProgress.class, name = "jobprogress"),
	@JsonSubTypes.Type(value = TextareaControl.class, name = "textarea"),
	@JsonSubTypes.Type(value = TextControl.class, name = "text"),
	@JsonSubTypes.Type(value = GuanliControl.class, name = "glc"),
	@JsonSubTypes.Type(value = TplControl.class, name = "tpl"),
	@JsonSubTypes.Type(value = MTplControl.class, name = "mtpl"),
	@JsonSubTypes.Type(value = CheckboxsControl.class, name = "checkboxs"),
	@JsonSubTypes.Type(value = ImageControl.class, name = "addimage"),
	@JsonSubTypes.Type(value = ListctrlControl.class, name = "listctrl"),
	@JsonSubTypes.Type(value = MacrosControl.class, name = "macros"),
	@JsonSubTypes.Type(value = OptionControl.class, name = "option"),
	@JsonSubTypes.Type(value = QrcodeControl.class, name = "qrcode"),
	@JsonSubTypes.Type(value = RadiosControl.class, name = "radios"),
	@JsonSubTypes.Type(value = SelectControl.class, name = "select"),
	@JsonSubTypes.Type(value = ProgressbarControl.class, name = "progressbar"),
	@JsonSubTypes.Type(value = ReportControl.class, name = "reportcontrol"),
	@JsonSubTypes.Type(value = wifiBlockControl.class, name = "wifiblock"),
	@JsonSubTypes.Type(value = CommentControl.class, name = "pinglun"),
	@JsonSubTypes.Type(value = assControl.class, name = "asscontrol"),
	@JsonSubTypes.Type(value = ButtonControl.class, name = "button"),
	@JsonSubTypes.Type(value = SortControl.class, name = "classification"),
	@JsonSubTypes.Type(value = iFrameRouterControl.class, name = "iframerouter"),
	@JsonSubTypes.Type(value = Pagekeywords.class, name = "pagekeywords"),
	@JsonSubTypes.Type(value = TreeClassifyControl.class, name = "classifytree"),
	@JsonSubTypes.Type(value = TreeClassify02Control.class, name = "classifytree02"),
	@JsonSubTypes.Type(value = TreeClassify03Control.class, name = "classifytree03"),
	@JsonSubTypes.Type(value = TreeClassify04Control.class, name = "classifytree04"),
	@JsonSubTypes.Type(value = ScoreControl.class, name = "score"),
	@JsonSubTypes.Type(value = HeaderAndFooter.class, name = "headerandfooter"),
	@JsonSubTypes.Type(value = SidebarNav.class, name = "sidebarnav"),
	@JsonSubTypes.Type(value = MultiDataSourcePublic.class, name = "multidatasourcepublic"),
	@JsonSubTypes.Type(value = AssetdetailControl.class, name = "assetdetail"),
	
	@JsonSubTypes.Type(value = AddcategoryControl.class, name = "addcategory"),
	@JsonSubTypes.Type(value = HtProductsuploadControl.class, name = "productsupload"),
	
	@JsonSubTypes.Type(value = HtPreviewProductsControl.class, name = "previewproducts"),
	@JsonSubTypes.Type(value = HtOrdersCentreControl.class, name = "orderscentre"),
	@JsonSubTypes.Type(value = HtVemOrderfoodControl.class, name = "vemorderfood"),
	@JsonSubTypes.Type(value = HtUpproductsControl.class, name = "upproducts"),
	@JsonSubTypes.Type(value = MyReleaseCommoditiesControl.class, name = "myreleasecommodities"),
	@JsonSubTypes.Type(value = MyUploadshopControl.class, name = "myuploadshop"),
	@JsonSubTypes.Type(value = MyBeautybgControl.class, name = "mybeautybg"),
	@JsonSubTypes.Type(value = MybeautypreviewControl.class, name = "mybeautypreview")
})
public class BaseControl extends BaseEntity implements Comparable<BaseControl>{
	private boolean is_delete;
	private long page_id;
	private String name;
	private String title;
	private String leipiplugins;
	private String orgtype;
	private String style;
	private String name1;
	//datasource：{data:"", field:""}
	private String sqldata;
	private String groupcon;
	private String p_or_m;



	public String getP_or_m() {
		return p_or_m;
	}

	public void setP_or_m(String p_or_m) {
		this.p_or_m = p_or_m;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getGroupcon() {
		return groupcon;
	}

	public void setGroupcon(String groupcon) {
		this.groupcon = groupcon;
	}

	public String getSqldata() {
		if(sqldata == null) {
			return sqldata = "[]";
		}else {
			return sqldata;
		}
	}

	public void setSqldata(String sqldata) {
		this.sqldata = sqldata;
	}

	public long getPage_id() {
		return page_id;
	}

	public void setPage_id(long page_id) {
		this.page_id = page_id;
	}

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
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

	public String getLeipiplugins() {
		return leipiplugins;
	}

	public void setLeipiplugins(String leipiplugins) {
		this.leipiplugins = leipiplugins;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSqlString() {
		String sqlString = this.getName() + " varchar(100) COMMENT '"
				+ this.getTitle() + "',";
		return sqlString;
	}

	@Override
	public String toString() {
		return "BaseControl [is_delete=" + is_delete + ", page_id=" + page_id + ", name=" + name + ", title=" + title
				+ ", leipiplugins=" + leipiplugins + ", orgtype=" + orgtype + ", style=" + style + ", sqldata="
				+ sqldata + "]";
	}

	@Override
	public int compareTo(BaseControl o) {
		return id;
		/*		int a = 0;
		int b = 0;



		if(this.getName1() != null) {
			a = Integer.valueOf(this.getName1().replace("data", "").replace("checkboxs_", "").replace("cData", ""));
		}else if(o.getName1() != null) {
			b = Integer.valueOf(o.getName1().replace("data", "").replace("checkboxs_", "").replace("cData", ""));
		}else {
			a = Integer.valueOf(this.getName().replace("data", "").replace("checkboxs_", "").replace("cData", ""));
			b = Integer.valueOf(o.getName().replace("data", "").replace("checkboxs_", "").replace("cData", ""));
		}

		int i = a - b;
		return i;*/
	}
}
