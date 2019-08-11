package swtech.service.pageDesign.dao.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import swtech.common.config.constants.HostConstants;
import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.AddcategoryControl;
import swtech.facade.pageDesign.entity.Addnumber;
import swtech.facade.pageDesign.entity.AssetdetailControl;
import swtech.facade.pageDesign.entity.Audit;
import swtech.facade.pageDesign.entity.Background;
import swtech.facade.pageDesign.entity.BaseControl;
import swtech.facade.pageDesign.entity.Beike;
import swtech.facade.pageDesign.entity.ButtonControl;
import swtech.facade.pageDesign.entity.Buylabel;
import swtech.facade.pageDesign.entity.CascadeClassify;
import swtech.facade.pageDesign.entity.Chaxun;
import swtech.facade.pageDesign.entity.CheckboxsControl;
import swtech.facade.pageDesign.entity.Classes;
import swtech.facade.pageDesign.entity.ClassifyControl;
import swtech.facade.pageDesign.entity.CommentControl;
import swtech.facade.pageDesign.entity.Curriculum;
import swtech.facade.pageDesign.entity.Daydate;
import swtech.facade.pageDesign.entity.Exchange;
import swtech.facade.pageDesign.entity.Export;
import swtech.facade.pageDesign.entity.Flowbtn;
import swtech.facade.pageDesign.entity.FormList;
import swtech.facade.pageDesign.entity.Getuserid;
import swtech.facade.pageDesign.entity.GuanliControl;
import swtech.facade.pageDesign.entity.HeaderAndFooter;
import swtech.facade.pageDesign.entity.MybeautypreviewControl;
import swtech.facade.pageDesign.entity.HtOrdersCentreControl;
import swtech.facade.pageDesign.entity.HtPreviewProductsControl;
import swtech.facade.pageDesign.entity.HtProductsuploadControl;
import swtech.facade.pageDesign.entity.HtUpproductsControl;
import swtech.facade.pageDesign.entity.HtVemOrderfoodControl;
import swtech.facade.pageDesign.entity.ImageControl;
import swtech.facade.pageDesign.entity.Internal;
import swtech.facade.pageDesign.entity.Jiangtang;
import swtech.facade.pageDesign.entity.JobProgress;
import swtech.facade.pageDesign.entity.KePuVideo;
import swtech.facade.pageDesign.entity.Liannanzugong;
import swtech.facade.pageDesign.entity.ListOne;
import swtech.facade.pageDesign.entity.ListctrlControl;
import swtech.facade.pageDesign.entity.Login;
import swtech.facade.pageDesign.entity.Lunbo;
import swtech.facade.pageDesign.entity.MTplControl;
import swtech.facade.pageDesign.entity.MacrosControl;
import swtech.facade.pageDesign.entity.Meetinglist;
import swtech.facade.pageDesign.entity.Mingxibiao;
import swtech.facade.pageDesign.entity.MultiDataSourcePublic;
import swtech.facade.pageDesign.entity.MyBeautybgControl;
import swtech.facade.pageDesign.entity.MyReleaseCommoditiesControl;
import swtech.facade.pageDesign.entity.MyUploadshopControl;
import swtech.facade.pageDesign.entity.Onlinehard;
import swtech.facade.pageDesign.entity.OptionControl;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.Pagekeywords;
import swtech.facade.pageDesign.entity.PaiCourse;
import swtech.facade.pageDesign.entity.Popup;
import swtech.facade.pageDesign.entity.ProgressbarControl;
import swtech.facade.pageDesign.entity.PushMsg;
import swtech.facade.pageDesign.entity.QrcodeControl;
import swtech.facade.pageDesign.entity.QueryVo;
import swtech.facade.pageDesign.entity.RadiosControl;
import swtech.facade.pageDesign.entity.Recordlabel;
import swtech.facade.pageDesign.entity.ReportControl;
import swtech.facade.pageDesign.entity.Resource;
import swtech.facade.pageDesign.entity.Schedule;
import swtech.facade.pageDesign.entity.Scheduling;
import swtech.facade.pageDesign.entity.ScoreControl;
import swtech.facade.pageDesign.entity.Search;
import swtech.facade.pageDesign.entity.SearchControl;
import swtech.facade.pageDesign.entity.SelectControl;
import swtech.facade.pageDesign.entity.SettimeoutControl;
import swtech.facade.pageDesign.entity.Shenpi;
import swtech.facade.pageDesign.entity.SidebarNav;
import swtech.facade.pageDesign.entity.Slidebox;
import swtech.facade.pageDesign.entity.SortChildren;
import swtech.facade.pageDesign.entity.SortControl;
import swtech.facade.pageDesign.entity.Task;
import swtech.facade.pageDesign.entity.Teach;
import swtech.facade.pageDesign.entity.TextControl;
import swtech.facade.pageDesign.entity.TextareaControl;
import swtech.facade.pageDesign.entity.TimeDate;
import swtech.facade.pageDesign.entity.TplControl;
import swtech.facade.pageDesign.entity.TreeClassify02Control;
import swtech.facade.pageDesign.entity.TreeClassify03Control;
import swtech.facade.pageDesign.entity.TreeClassify04Control;
import swtech.facade.pageDesign.entity.TreeClassifyControl;
import swtech.facade.pageDesign.entity.UserHasNode;
import swtech.facade.pageDesign.entity.WebShell;
import swtech.facade.pageDesign.entity.Workflow;
import swtech.facade.pageDesign.entity.Workform;
import swtech.facade.pageDesign.entity.Workword;
import swtech.facade.pageDesign.entity.WxGroupTag;
import swtech.facade.pageDesign.entity.WxList;
import swtech.facade.pageDesign.entity.Yuejuan;
import swtech.facade.pageDesign.entity.Zujuan;
import swtech.facade.pageDesign.entity.assControl;
import swtech.facade.pageDesign.entity.iFrameRouterControl;
import swtech.facade.pageDesign.entity.wifiBlockControl;
import swtech.facade.pageDesign.service.impl.PageDesignOperatorFacadeImpl;
import swtech.facade.pageDesign.util.fastJsonDiff;
import swtech.facade.pageDesign.util.File.Base64ToImage;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;
import util.BeforeTheSuffix;

@Repository("pageDesignDao")
//@Transactional
public class PageDesignDaoImpl extends BaseDaoImpl<PageEditor> implements PageDesignDao {

	private static final Log log = LogFactory.getLog(PageDesignDaoImpl.class);

	// 获取表单内容
	public ReturnMsg getPageEditor(Long node_id, String key, String groupCon, String wifiField, String nodeName) {
		ReturnMsg msg = new ReturnMsg();
		Object o = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("node_id", node_id);
		try {
			PageEditor pageEditor = getSqlSession().selectOne("getByNode_Id", param);
			logger.info("=========pageEditor.getId(=======" + pageEditor.getId());
			List<BaseControl> list = new ArrayList<BaseControl>();



			/*Stirng
			switch (key) {
			case value:

				break;
			}*/

			List<Onlinehard> onlinehards = getSqlSession().selectList("selectOnlinehard", pageEditor.getId());
			int size = onlinehards.size();
			for (int i = 0; i < size; i++) {
				list.add(onlinehards.get(i));
			}
			List<Workword> workwords = getSqlSession().selectList("selectWorkword", pageEditor.getId());
			size = workwords.size();
			for (int i = 0; i <size; i++) {
				list.add(workwords.get(i));
			}
			List<Workform> workforms = getSqlSession().selectList("selectWorkform", pageEditor.getId());
			size = workforms.size();
			for (int i = 0; i < size; i++) {
				list.add(workforms.get(i));
			}
			List<Workflow> workflows = getSqlSession().selectList("selectWorkflow", pageEditor.getId());
			size = workflows.size();
			for (int i = 0; i < size; i++) {
				list.add(workflows.get(i));
			}
			List<Schedule> schedules = getSqlSession().selectList("selectSchedule", pageEditor.getId());
			size = schedules.size();
			for (int i = 0; i < size; i++) {
				list.add(schedules.get(i));
			}
			List<Task> tasks = getSqlSession().selectList("selectTask", pageEditor.getId());
			size = tasks.size();
			for (int i = 0; i <size; i++) {
				list.add(tasks.get(i));
			}
			List<Beike> beikes = getSqlSession().selectList("selectBeike", pageEditor.getId());
			size = beikes.size();
			for (int i = 0; i < size; i++) {
				list.add(beikes.get(i));
			}
			List<Resource> resources = getSqlSession().selectList("selectResource", pageEditor.getId());
			size = resources.size();
			for (int i = 0; i < size; i++) {
				list.add(resources.get(i));
			}
			List<Teach> teachs = getSqlSession().selectList("selectTeach", pageEditor.getId());
			size = teachs.size();
			for (int i = 0; i < size; i++) {
				list.add(teachs.get(i));
			}
			List<Classes> classes = getSqlSession().selectList("selectClasses", pageEditor.getId());
			size = classes.size();
			for (int i = 0; i < size; i++) {
				list.add(classes.get(i));
			}
			List<Curriculum> curriculum = getSqlSession().selectList("selectCurriculum", pageEditor.getId());
			size = curriculum.size();
			for (int i = 0; i <size; i++) {
				list.add(curriculum.get(i));
			}
			List<Jiangtang> jiangtangs = getSqlSession().selectList("selectJiangtang", pageEditor.getId());
			size = jiangtangs.size();
			for (int i = 0; i <size; i++) {
				list.add(jiangtangs.get(i));
			}
			List<Zujuan> zujuans = getSqlSession().selectList("selectZujuan", pageEditor.getId());
			size = zujuans.size();
			for (int i = 0; i < size; i++) {
				list.add(zujuans.get(i));
			}
			List<Yuejuan> yuejuans = getSqlSession().selectList("selectYuejuan", pageEditor.getId());
			size = yuejuans.size();
			for (int i = 0; i <size; i++) {
				list.add(yuejuans.get(i));
			}
			List<Chaxun> chaxuns = getSqlSession().selectList("selectChaxun", pageEditor.getId());
			size=chaxuns.size();
			for (int i = 0; i < size; i++) {
				list.add(chaxuns.get(i));
			}
			List<Audit> audits = getSqlSession().selectList("selectAudit", pageEditor.getId());
			size=audits.size();
			for (int i = 0; i < size; i++) {
				list.add(audits.get(i));
			}

			List<MTplControl> mptls = getSqlSession().selectList("selectMTplControls", pageEditor.getId());
			size=mptls.size();
			for (int i = 0; i <size; i++) {
				list.add(mptls.get(i));
			}
			log.info("mtpl控件：" + mptls.size());
			List<TplControl> tpls = getSqlSession().selectList("selectTplControls", pageEditor.getId());
			size=tpls.size();
			for (int i = 0; i < size; i++) {
				list.add(tpls.get(i));
			}
			log.info("tpl控件：" + tpls.size());
			List<GuanliControl> guanlis = getSqlSession().selectList("selectGuanliControls", pageEditor.getId());
			size=guanlis.size();
			for (int i = 0; i < size; i++) {
				list.add(guanlis.get(i));
			}
			log.info("管理控件：" + guanlis.size());
			List<Search> search = getSqlSession().selectList("selectSearch", pageEditor.getId());
			size=search.size();
			for (int i = 0; i < size; i++) {
				list.add(search.get(i));
			}
			log.info("搜索控件：" + search.size());
			List<FormList> formlist = getSqlSession().selectList("selectFormList", pageEditor.getId());
			size=formlist.size();
			for (int i = 0; i < size; i++) {
				list.add(formlist.get(i));
			}
			log.info("formlist控件：" + formlist.size());

			log.info("级联分类控件：" + search.size());
			List<ClassifyControl> cascadeClassify = getSqlSession().selectList("selectClassifyControl",
					pageEditor.getId());
			size=cascadeClassify.size();
			for (int i = 0; i <size; i++) {
				list.add(cascadeClassify.get(i));
			}
			log.info("倒计时控件：" + search.size());
			List<SettimeoutControl> settimeoutControl = getSqlSession().selectList("selectSettimeoutControl",
					pageEditor.getId());
			size=settimeoutControl.size();
			for (int i = 0; i < size; i++) {
				list.add(settimeoutControl.get(i));
			}
			log.info("微信列表控件：" + search.size());
			List<WxList> wxList = getSqlSession().selectList("selectWxList",
					pageEditor.getId());
			size=wxList.size();
			for (int i = 0; i < size; i++) {
				list.add(wxList.get(i));
			}
			log.info("列表模板1控件：" + search.size());
			List<ListOne> listOne = getSqlSession().selectList("selectListOne",
					pageEditor.getId());
			size=listOne.size();
			for (int i = 0; i < size; i++) {
				list.add(listOne.get(i));
			}
			log.info("时间控件：" + search.size());
			List<TimeDate> timedate = getSqlSession().selectList("selectTimeDate",
					pageEditor.getId());
			size=timedate.size();
			for (int i = 0; i < size; i++) {
				list.add(timedate.get(i));
			}
			log.info("购买标签：" + search.size());
			List<Buylabel> buylabel = getSqlSession().selectList("selectBuylabel",
					pageEditor.getId());
			size=buylabel.size();
			for (int i = 0; i < size; i++) {
				list.add(buylabel.get(i));
			}
			log.info("弹窗控件：" + search.size());
			List<Popup> popup = getSqlSession().selectList("selectPopup",
					pageEditor.getId());
			size=popup.size();
			for (int i = 0; i < size; i++) {
				list.add(popup.get(i));
			}

			log.info("排课控件：" + search.size());
			List<Scheduling> scheduling = getSqlSession().selectList("selectScheduling",
					pageEditor.getId());
			size=scheduling.size();
			for (int i = 0; i < size; i++) {
				list.add(scheduling.get(i));
			}

			log.info("轮播控件：" + search.size());
			List<Lunbo> lunbo = getSqlSession().selectList("selectLunbo",
					pageEditor.getId());
			size=lunbo.size();
			for (int i = 0; i < size; i++) {
				list.add(lunbo.get(i));
			}

			log.info("报名控件：" + search.size());
			List<Addnumber> addnumber = getSqlSession().selectList("selectAddnumber",
					pageEditor.getId());
			size=addnumber.size();
			for (int i = 0; i < size; i++) {
				list.add(addnumber.get(i));
			}

			log.info("记录/统计控件：" + search.size());
			List<Recordlabel> recordlabel = getSqlSession().selectList("selectRecordlabel",
					pageEditor.getId());
			size=recordlabel.size();
			for (int i = 0; i < size; i++) {
				list.add(recordlabel.get(i));
			}

			log.info("背景控件：" + search.size());
			List<Background> background = getSqlSession().selectList("selectBackground",
					pageEditor.getId());
			size=background.size();
			for (int i = 0; i < size; i++) {
				list.add(background.get(i));
			}

			log.info("导出Excel控件：" + search.size());
			List<Export> export = getSqlSession().selectList("selectExport",
					pageEditor.getId());
			size=export.size();
			for (int i = 0; i < size; i++) {
				list.add(export.get(i));
			}

			log.info("审批列表控件：" + search.size());
			List<Shenpi> shenpi = getSqlSession().selectList("selectShenpi",
					pageEditor.getId());
			size=shenpi.size();
			for (int i = 0; i < size; i++) {
				list.add(shenpi.get(i));
			}

			log.info("登陆控件：" + search.size());
			List<Login> login = getSqlSession().selectList("selectLogin",
					pageEditor.getId());
			size=login.size();
			for (int i = 0; i < size; i++) {
				list.add(login.get(i));
			}
			// 资产管理明细表控件
			List<Mingxibiao> mingxibiao = getSqlSession().selectList("selectMingxibiao", pageEditor.getId());
			size=mingxibiao.size();
			for (int i = 0; i < size; i++) {
				list.add(mingxibiao.get(i));
			}
			log.info("资产管理明细表控件：" + size);

			List<JobProgress> jobprogress = getSqlSession().selectList("selectJobprogress", pageEditor.getId());
			size=jobprogress.size();
			for (int i = 0; i < size; i++) {
				list.add(jobprogress.get(i));
			}
			log.info("重要工作进度表控件：" + size);
			// 页面关键字控件
			List<Pagekeywords> pagekeywords = getSqlSession().selectList("selectPagekeywords", pageEditor.getId());
			size=pagekeywords.size();
			for (int i = 0; i < size; i++) {
				list.add(pagekeywords.get(i));
			}
			log.info("页面关键字控件：" + size);

			// 评分控件
			List<ScoreControl> scoreControls = getSqlSession().selectList("selectScoreControl", pageEditor.getId());
			size=scoreControls.size();
			for (int i = 0; i < size; i++) {
				list.add(scoreControls.get(i));
			}
			log.info("评分控件：" + size);

			// 头/底部模板控件
			List<HeaderAndFooter> headerAndFooter = getSqlSession().selectList("selectHeaderAndFooter", pageEditor.getId());
			size=headerAndFooter.size();
			for (int i = 0; i < size; i++) {
				list.add(headerAndFooter.get(i));
			}
			log.info("头/底部模板控件：" + size);

			// 侧栏导航控件
			List<SidebarNav> sidebarnavList = getSqlSession().selectList("selectSidebarNav", pageEditor.getId());
			size=sidebarnavList.size();
			for (int i = 0; i < size; i++) {
				list.add(sidebarnavList.get(i));
			}
			log.info("侧栏导航控件：" + size);

			// 多数源发布标识控件
			List<MultiDataSourcePublic> multidatasourcepublicList = getSqlSession().selectList("selectMultiDataSourcePublic", pageEditor.getId());
			size=multidatasourcepublicList.size();
			for (int i = 0; i < size; i++) {
				list.add(multidatasourcepublicList.get(i));
			}
			log.info("多数源发布标识控件：" + size);
			// 资产明细表
			List<AssetdetailControl> assetdetailControl = getSqlSession().selectList("selectAssetdetailControl", pageEditor.getId());
			size=assetdetailControl.size();
			for (int i = 0; i < size; i++) {
				list.add(assetdetailControl.get(i));
			}
			log.info("资产明细表：" + size);

			
			
			
			// 添加类别
			List<AddcategoryControl> addcategoryControl = getSqlSession().selectList("selectAddcategoryControl", pageEditor.getId());
			size=addcategoryControl.size();
			for (int i = 0; i < size; i++) {
				list.add(addcategoryControl.get(i));
			}
			log.info("添加类别：" + size);
			
			//餐品上传
			List<HtProductsuploadControl> productsuploadControl = getSqlSession().selectList("selectHtProductsuploadControl", pageEditor.getId());
			size=productsuploadControl.size();
			for (int i = 0; i < size; i++) {
				list.add(productsuploadControl.get(i));
			}
			log.info("餐品上传：" + size);
			
			//预览餐品
			List<HtPreviewProductsControl> previewproductsControl = getSqlSession().selectList("selectHtPreviewProductsControl", pageEditor.getId());
			size=previewproductsControl.size();
			for (int i = 0; i < size; i++) {
				list.add(previewproductsControl.get(i));
			}
			log.info("预览餐品：" + size);
			
			//订单中心
			List<HtOrdersCentreControl> orderscentreControl = getSqlSession().selectList("selectHtOrdersCentreControl", pageEditor.getId());
			size=orderscentreControl.size();
			for (int i = 0; i < size; i++) {
				list.add(orderscentreControl.get(i));
			}
			log.info("订单中心：" + size);
			
			//自助机点餐
			List<HtVemOrderfoodControl> vemorderfoodControl = getSqlSession().selectList("selectHtVemOrderfoodControl", pageEditor.getId());
			size=vemorderfoodControl.size();
			for (int i = 0; i < size; i++) {
				list.add(vemorderfoodControl.get(i));
			}
			log.info("自助机点餐：" + size);
			
			//页面广告上传
			List<HtUpproductsControl> upproductsControl = getSqlSession().selectList("selectHtUpproductsControl", pageEditor.getId());
			size=upproductsControl.size();
			for (int i = 0; i < size; i++) {
				list.add(upproductsControl.get(i));
			}
			log.info("页面广告上传：" + size);
			
			//美业商品
			List<MyReleaseCommoditiesControl> myreleasecommoditiesControl = getSqlSession().selectList("selectMyReleaseCommoditiesControl", pageEditor.getId());
			size=myreleasecommoditiesControl.size();
			for (int i = 0; i < size; i++) {
				list.add(myreleasecommoditiesControl.get(i));
			}
			log.info("美业商品：" + size);
			
			//美业店铺上传
			List<MyUploadshopControl> myuploadshopControl = getSqlSession().selectList("selectMyUploadshopControl", pageEditor.getId());
			size=myuploadshopControl.size();
			for (int i = 0; i < size; i++) {
				list.add(myuploadshopControl.get(i));
			}
			log.info("美业店铺上传：" + size);
			
			//美业后台
			List<MyBeautybgControl> mybeautybgControl = getSqlSession().selectList("selectMyBeautybgControl", pageEditor.getId());
			size=mybeautybgControl.size();
			for (int i = 0; i < size; i++) {
				list.add(mybeautybgControl.get(i));
			}
			log.info("美业后台：" + size);
			
			//美业客户预览
			List<MybeautypreviewControl> mybeautypreviewControl = getSqlSession().selectList("selectMybeautypreviewControl", pageEditor.getId());
			size=mybeautypreviewControl.size();
			for (int i = 0; i < size; i++) {
				list.add(mybeautypreviewControl.get(i));
			}
			log.info("美业客户预览：" + size);
			
			
			
			// 树形分类控件
			List<TreeClassifyControl> treeClassify = getSqlSession().selectList("selectTreeClassify", pageEditor.getId());
			size=treeClassify.size();
			for (int i = 0; i < size; i++) {
				list.add(treeClassify.get(i));
			}
			log.info("树形分类控件：" + size);

			// 树形分类2控件
			List<TreeClassify02Control> treeClassify02 = getSqlSession().selectList("selectTreeClassify02", pageEditor.getId());
			size=treeClassify02.size();
			for (int i = 0; i < size; i++) {
				list.add(treeClassify02.get(i));
			}
			log.info("树形分类2控件：" + size);


			// 树形分类3控件
			List<TreeClassify03Control> treeClassify03 = getSqlSession().selectList("selectTreeClassify03", pageEditor.getId());
			size=treeClassify03.size();
			for (int i = 0; i < size; i++) {
				list.add(treeClassify03.get(i));
			}
			log.info("树形分类3控件：" + size);

			// 树形分类2控件
			List<TreeClassify04Control> treeClassify04 = getSqlSession().selectList("selectTreeClassify04", pageEditor.getId());
			size=treeClassify04.size();
			for (int i = 0; i < size; i++) {
				list.add(treeClassify04.get(i));
			}
			log.info("树形分类4控件：" + size);




			log.info("兑换控件：" + search.size());
			List<Exchange> exchange = getSqlSession().selectList("selectExchange",
					pageEditor.getId());
			size=exchange.size();
			for (int i = 0; i < size; i++) {
				list.add(exchange.get(i));
			}

			log.info("兑换记录控件：" + search.size());
			List<Internal> internal = getSqlSession().selectList("selectInternal",
					pageEditor.getId());
			size=internal.size();
			for (int i = 0; i < size; i++) {
				list.add(internal.get(i));
			}

			log.info("连南组工控件：" + search.size());
			List<Liannanzugong> liannanzugong = getSqlSession().selectList("selectLiannanzugong",
					pageEditor.getId());
			size=liannanzugong.size();
			for (int i = 0; i < size; i++) {
				list.add(liannanzugong.get(i));
			}

			log.info("会议列表控件：" + search.size());
			List<Meetinglist> meetinglist = getSqlSession().selectList("selectMeetinglist",
					pageEditor.getId());
			size=meetinglist.size();
			for (int i = 0; i < size; i++) {
				list.add(meetinglist.get(i));
			}

			log.info("用户id控件：" + search.size());
			List<Getuserid> getuserid = getSqlSession().selectList("selectGetuserid",
					pageEditor.getId());
			size=getuserid.size();
			for (int i = 0; i < size; i++) {
				list.add(getuserid.get(i));
			}

			log.info("节点搜索控件：" + search.size());
			List<SearchControl> searchControl = getSqlSession().selectList("selectSearchControl", pageEditor.getId());
			log.info("========打印出来看看pageEditor.getId()==========" + pageEditor.getId());
			log.info("========打印出来看看searchControl==========" + searchControl);
			size=searchControl.size();
			for (int i = 0; i <size; i++) {
				list.add(searchControl.get(i));
			}
			log.info("========打印出来看看list==========" + list);

			/*
			 * //搜索功能根据条件搜索 List<SearchSelect> searchselect =
			 * getSqlSession().selectList("selectSearchSelect",
			 * pageEditor.getId()); for(int i = 0;i<searchselect.size(); i++){
			 * list.add(searchselect.get(i)); } log.info("搜索功能:"+
			 * searchselect.size());
			 */

			// 排序
			/*
			 * List<SearchSelect> searchSelect =
			 * getSqlSession().selectList("SearchSelectSelect",
			 * pageEditor.getId()); for(int i = 0;i<searchSelect.size(); i++){
			 * list.add(searchSelect.get(i)); } log.info("筛选功能:" +
			 * searchSelect.size());
			 */

			// log.info("formlist控件：" + formlist.size());
			List<WxGroupTag> wxgrouptag = getSqlSession().selectList("selectWxGroupTag", pageEditor.getId());
			size=wxgrouptag.size();
			for (int i = 0; i < size; i++) {
				list.add(wxgrouptag.get(i));
			}
			log.info("微信推送标签控件：" + wxgrouptag.size());

			List<Slidebox> slidebox = getSqlSession().selectList("selectSlidebox", pageEditor.getId());
			size=slidebox.size();
			for (int i = 0; i < size; i++) {
				list.add(slidebox.get(i));
			}
			log.info("轮播图控件：" + slidebox.size());

			List<Flowbtn> flowbtn = getSqlSession().selectList("selectFlowbtn", pageEditor.getId());
			size=flowbtn.size();
			for (int i = 0; i < size; i++) {
				list.add(flowbtn.get(i));
			}
			log.info("flowbtn控件：" + flowbtn.size());

			List<Daydate> daydate = getSqlSession().selectList("selectDaydate", pageEditor.getId());
			size=daydate.size();
			for (int i = 0; i < size; i++) {
				list.add(daydate.get(i));
			}
			log.info("daydate控件：" + daydate.size());

			// 文本控件
			List<TextControl> txts = getSqlSession().selectList("selectTextControls", pageEditor.getId());
			size=txts.size();
			for (int i = 0; i < size; i++) {
				TextControl text = txts.get(i);
				// 添加搜索关联热区控件
				if (isNotNull(text.getDatasource())) {

					// 根据数据源获取数据
					JSONObject jsonObj = JSONObject.parseObject(text.getDatasource());
					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");
					// 执行查询命令
					if (groupCon == null || !groupCon.equals(text.getGroupcon())) {
						log.info("------普通查询");
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						// 执行高级搜索
						log.info("------高级查询");
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					log.info("=============文本框属性===================" + value + "==================");
					/*if (text.getTitle().equals("文本框")) {
						List<data3> lr3 = JSONObject.parseArray(value, data3.class);
						Collections.sort(lr3);
						text.setSqldata(lr3.toString());
						if (lr3.size() > 0) {
							if (lr3.get(0).getData3() == null) {
								List<rank> lr2 = JSONObject.parseArray(value, rank.class);
								Collections.sort(lr2);
								text.setSqldata(lr2.toString());
								log.info("=============文本框属性========" + lr2.toString() + "==============");
							}
						}
						log.info("=============文本框属性========" + lr3.toString() + "==============");
					} else {
						text.setSqldata(value);
					}
					 */
					text.setSqldata(value);
					list.add(text);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, text.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, text.getName(), null);
					}
					// 添加查询到的数据源
					text.setSqldata(value);

					list.add(text);
				}

				/*
				 * //只传送搜索热区数据 if(text.getGroupcon() != null && groupCon !=
				 * null) { if(key != null &&
				 * text.getGroupcon().equals(groupCon)) { list.add(text); }
				 * }else { if(key == null) { list.add(text); } } } else {
				 * if(text.getGroupcon() != null && groupCon != null) { if(key
				 * != null && text.getGroupcon().equals(groupCon)) {
				 * list.add(text); } }else { if(key == null) { list.add(text); }
				 * } }
				 */
			}

			log.info("文本控件：" + guanlis.size());
			// 多行文本控件
			List<TextareaControl> textareas = getSqlSession().selectList("selectTextareaControls", pageEditor.getId());
			size=textareas.size();
			for (int i = 0; i < size; i++) {
				TextareaControl text = textareas.get(i);
				// 根据数据源获取数据
				if (isNotNull(text.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(text.getDatasource());
					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					if (groupCon == null || !text.getGroupcon().equals(groupCon)) {
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					text.setSqldata(value);

					list.add(text);
				} else {

					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, text.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, text.getName(), null);
					}
					// 添加查询到的数据源
					text.setSqldata(value);
					list.add(text);
				}

				// list.add(textareas.get(i));
			}
			log.info("多行文本控件：" + guanlis.size());
			// 复选框控件
			List<CheckboxsControl> cbos = getSqlSession().selectList("selectCheckboxsControls", pageEditor.getId());
			size=cbos.size();
			for (int i = 0; i < size; i++) {
				log.info("来到了复选框的选项获取");
				CheckboxsControl cbo = cbos.get(i);
				List<OptionControl> ops = getSqlSession().selectList("selectCboOptions", cbo.getId());
				cbo.setOptions(ops);

				// 根据数据源获取数据
				if (isNotNull(cbo.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(cbo.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					if (groupCon == null || !cbo.getGroupcon().equals(groupCon)) {
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);

						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					cbo.setSqldata(value);

					list.add(cbo);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, cbo.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, cbo.getName(), null);
					}
					// 添加查询到的数据源
					cbo.setSqldata(value);
					list.add(cbo);
				}
			}
			log.info("复选框控件：" + guanlis.size());
			// 单选框控件
			List<RadiosControl> rdos = getSqlSession().selectList("selectRadiosControls", pageEditor.getId());
			size=rdos.size();
			for (int i = 0; i < size; i++) {
				log.info("来到了单选框的选项获取");
				RadiosControl rdo = rdos.get(i);
				List<OptionControl> ops = getSqlSession().selectList("selectRdoOptions", rdo.getId());
				rdo.setOptions(ops);
				// 根据数据源获取数据
				if (isNotNull(rdo.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(rdo.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					if (groupCon == null || !rdo.getGroupcon().equals(groupCon)) {
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					rdo.setSqldata(value);

					list.add(rdo);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, rdo.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, rdo.getName(), null);
					}
					// 添加查询到的数据源
					rdo.setSqldata(value);
					list.add(rdo);
				}
			}
			log.info("单选框控件：" + rdos.size());
			/*
			 * for (int i = 0; i < rdos.size(); i++) { list.add(rdos.get(i)); }
			 */

			List<MacrosControl> macros = getSqlSession().selectList("selectMacrosControls", pageEditor.getId());
			size=macros.size();
			for (int i = 0; i < size; i++) {
				list.add(macros.get(i));
			}
			log.info("宏控件：" + rdos.size());
			List<QrcodeControl> qrcodes = getSqlSession().selectList("selectQrcodeControls", pageEditor.getId());
			size=qrcodes.size();
			for (int i = 0; i < size; i++) {
				list.add(qrcodes.get(i));
			}
			log.info("二维码控件：" + rdos.size());
			// 下拉框控件
			List<SelectControl> sels = getSqlSession().selectList("selectSelectControls", pageEditor.getId());
			size=sels.size();
			for (int i = 0; i < size; i++) {
				SelectControl select = sels.get(i);
				if (isNotNull(select.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(select.getDatasource());
					//String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					if (groupCon == null || !select.getGroupcon().equals(groupCon)) {
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					select.setSqldata(value);

					list.add(select);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, select.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, select.getName(), null);
					}
					// 添加查询到的数据源
					select.setSqldata(value);
					list.add(select);
				}

			}
			log.info("下拉框控件：" + rdos.size());
			List<ListctrlControl> listctrls = getSqlSession().selectList("selectListctrlControls", pageEditor.getId());
			size=listctrls.size();
			for (int i = 0; i < size; i++) {
				list.add(listctrls.get(i));
			}
			log.info("列表LIST控件：" + rdos.size());
			// 进度条控件
			List<ProgressbarControl> pros = getSqlSession().selectList("selectProgressbarControls", pageEditor.getId());
			size=pros.size();
			for (int i = 0; i < size; i++) {
				list.add(pros.get(i));
			}
			log.info("进度条控件：" + rdos.size());
			// 图片控件

			List<ImageControl> image = getSqlSession().selectList("selectImageControls", pageEditor.getId());
			logger.info("===========img.size()==========" + image.size());
			size=image.size();
			for (int i = 0; i < size; i++) {

				ImageControl img = image.get(i);
				if (isNotNull(img.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(img.getDatasource());
					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");
					// 执行查询命令
					if (groupCon == null || !img.getGroupcon().equals(groupCon)) {
						logger.info("nodeName==========" + nodeName);
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}
					// 储存数据源键值对
					String value = null;
					logger.info("className==========" + className + "===========o==========" + o);
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
						logger.info("===========className==========" + className + "  field " + field + "==value=="
								+ value);
					}
					// logger.info("===========className=========="+className+"
					// field "+field+"==value=="+value);
					log.info("===========value==========" + value);
					log.info("===========img.getSqldata==========" + img.getSqldata());
					/*					if (img.getTitle().equals("视频上传")) {
						List<rank> lr = JSONObject.parseArray(value, rank.class);
						Collections.sort(lr);
						img.setSqldata(lr.toString());
					} else {
						List<data1> lr1 = JSONObject.parseArray(value, data1.class);
						Collections.sort(lr1);
						img.setSqldata(lr1.toString());
					}*/

					img.setSqldata(value);
					log.info("===========img.getSqldata==========" + img);
					list.add(img);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, img.getName(), null);
					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, img.getName(), null);
					}
					// 添加查询到的数据源
					/*	if (img.getTitle().equals("视频上传")) {
						List<rank> lr = JSONObject.parseArray(value, rank.class);
						Collections.sort(lr);
						img.setSqldata(lr.toString());
					} else {
						List<data1> lr1 = JSONObject.parseArray(value, data1.class);
						Collections.sort(lr1);
						img.setSqldata(lr1.toString());
					}*/
					img.setSqldata(value);
					list.add(img);
				}

			}
			log.info("图片框控件：" + rdos.size());
			// 内嵌路由控件
			List<iFrameRouterControl> routers = getSqlSession().selectList("selectiFrameRouterControls",
					pageEditor.getId());
			size=routers.size();
			for (int i = 0; i < size; i++) {
				list.add(routers.get(i));
			}
			log.info("内嵌路由控件：" + rdos.size());
			// 报表控件
			List<ReportControl> rcs = getSqlSession().selectList("selectReportControls", pageEditor.getId());
			size=rcs.size();
			for (int i = 0; i < size; i++) {
				ReportControl rc = rcs.get(i);
				o = null;
				if (rc.getSqlStr() != null || rc.getSqlStr() != "") {
					// 调用执行sql语句
					o = invokeUtil.invoke(rc.getNode_name(), rc.getSqlStr());
					rc.setData(o);
					rc.setSqlStr("5L2g5bCx5piv5Liq5YK76YC8");
					String field = rc.getField();
					String[] fieldArray = field.split(";");
					List<Integer> statisticsDatas = new ArrayList<Integer>();
					System.out.println(fieldArray[0]);
					for(int l=1;l<fieldArray.length;l++) {
						String statisticsNodeId = fieldArray[l].split(",")[0];
						String statisticsField = fieldArray[l].split(",")[2];
						System.out.println(statisticsField);
						statisticsField = "swprefix"+statisticsField;
						System.out.println(statisticsField);

						//根据nodeId查询该数据源的数据表。
						String tableName = getSessionTemplate().selectOne("getDataTableByStatisticsNodeId", statisticsNodeId);
						System.out.println(tableName);
						//查询该数据表中该字段的最后一条记录的内容。
						Map<String, String> paramMap = new HashMap<String,String>();
						paramMap.put("tableName", tableName);
						paramMap.put("statisticsField", statisticsField);
						Integer statisticsData = null;
						try {
							statisticsData = getSessionTemplate().selectOne("getStatisticsData", paramMap);
						} catch (Exception e) {
							statisticsData = 1;
						}
						System.out.println("这是统计素材的数据statisticsData="+statisticsData);
						statisticsDatas.add(statisticsData);

					}
					//for(String s:statisticsDatas) {
					//	System.out.println(s);
					//}
					rc.setData(statisticsDatas);
					rcs.set(i, rc);
					list.add(rcs.get(i));
				} else {
					list.add(rcs.get(i));
				}

			}
			log.info("报表控件：" + rdos.size());
			// 热区控件
			List<wifiBlockControl> wifiBlockControl = getSqlSession().selectList("selectwifiBlockControls",
					pageEditor.getId());
			size=wifiBlockControl.size();
			for (int i = 0; i < size; i++) {
				list.add(wifiBlockControl.get(i));
			}
			log.info("热框控件：" + rdos.size());
			// 关联控件
			List<assControl> assControl = getSqlSession().selectList("selectassControls", pageEditor.getId());
			size=assControl.size();
			for (int i = 0; i < size; i++) {
				list.add(assControl.get(i));
			}
			log.info("关联控件：" + rdos.size());
			// 按钮控件
			List<ButtonControl> buttonControl = getSqlSession().selectList("selectButtonControls", pageEditor.getId());
			size=buttonControl.size();
			for (int i = 0; i < size; i++) {
				list.add(buttonControl.get(i));
			}
			log.info("按钮控件：" + rdos.size());
			// 评论显示控件
			List<CommentControl> commentControl = getSqlSession().selectList("selectCommentControls",
					pageEditor.getId());
			size=commentControl.size();
			for (int i = 0; i < size; i++) {
				CommentControl comment = commentControl.get(i);
				if (isNotNull(comment.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(comment.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					if (groupCon == null || !comment.getGroupcon().equals(groupCon)) {
						o = invokeUtil.invoke2(nodeName, field, null, null, null, className);
					} else {
						String params = invokeUtil.getParams(className);
						o = invokeUtil.invoke2(nodeName, field, params, key, null, className);
					}

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					comment.setSqldata(value);

					list.add(comment);
				} else {
					// 没有数据源的操作
					o = invokeUtil.invoke3(nodeName, comment.getName(), null);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, comment.getName(), null);
					}
					// 添加查询到的数据源
					comment.setSqldata(value);
					list.add(comment);
				}
			}

			log.info("==========list===" + list);

			log.info("==========wifiField===" + wifiField);
			//Collections.sort(list);
			pageEditor.setData(list);
			pageEditor.setWifiField(wifiField);
			String selected = pageEditor.getSelected();
			pageEditor.setSelected(selected.replaceAll(BeforeTheSuffix.Prefix, ""));
			msg.setStatus("0");
			msg.setStatus("获取编辑页面成功！！");      
			msg.setMsg(pageEditor);

		} catch (Exception e) {
			msg.setStatus("2");
			msg.setStatus("获取编辑页面失败！！");
			msg.setMsg(e.toString());
			e.printStackTrace();
		}
		return msg;
	}
	@Autowired
	private NodeDao nodeDao;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public ReturnMsg savePage(PageEditor pageEditor) {
		ReturnMsg msg = new ReturnMsg();
		String[] images = null;
		Map<String, Object> param = new HashMap<String, Object>();
		int node_id = pageEditor.getNode_id();
		log.info("node_id的值是：" + node_id);
		param.put("node_id", node_id);
		param.put("fields", pageEditor.getFields());
		param.put("node_name", pageEditor.getNode_name());
		param.put("parse", pageEditor.getParse());
		param.put("phoneParse", pageEditor.getPhoneParse());
		param.put("title", pageEditor.getTitle());
		param.put("name", pageEditor.getName());
		param.put("shareTo_name", pageEditor.getShareTo_name());
		param.put("shareTo_nodeId", pageEditor.getShareTo_nodeId());
		msg.setStatus("0");
		msg.setStatusMsg("false");
		log.info("title==============="+pageEditor.getTitle());
		log.info("name==============="+pageEditor.getName());
		log.info("shareTo_name=========这里应该是中文======"+pageEditor.getShareTo_name());
		log.info("shareTo_nodeId==============="+ pageEditor.getShareTo_nodeId());

		try {
			// 查找是否已经有node_id的记录，如果有，修改is_delete为ture
			int count = getSqlSession().selectOne("getCountForNodeId", param);
			log.info("node_id的记录数是：" + count);
			if (count > 0) {
				getSqlSession().update("change_pageDesign_is_delete", param);
			}
			log.info("=========让我看看里面是什么===准备插入的pageEditor=========="+pageEditor);
			getSessionTemplate().insert("savePageEditor", pageEditor);


			//在保存后获取他的值，已做对比
			String selected =null;
			String title =null;
			PageEditor page1 = getSqlSession().selectOne("getByNode_Id", param);//正常
			log.info("在保存后获取他的值-=====的Selected========"+page1.getSelected());
			selected = page1.getSelected();
			title=page1.getTitle();



			/*
			 * 8.16修改PC端与手机端数据源问题
			 * 
			 * Integer ex =
			 * getSessionTemplate().selectOne("existsPageEditorByNodeId",
			 * pageEditor);
			 * log.info("======================================ex是："+ex);
			 * if(ex==null){ getSessionTemplate().insert("savePageEditor",
			 * pageEditor); }else { Map<String, Object> map=new HashMap<String,
			 * Object>(); map.put("id",ex); map.put("parse",
			 * pageEditor.getParse()); map.put("phoneParse",
			 * pageEditor.getPhoneParse());
			 * log.info("map==========================="+map);
			 * getSessionTemplate().update("updatePageEditorByex",map);
			 * pageEditor.setId(getSessionTemplate().selectOne("findPageId",
			 * map)); }
			 */
			long page_id =pageEditor.getId();
			log.info("==========正常执行pageEditor.getId(),看看可不可以执行==========page_id==="+page_id);
			List<BaseControl> list = pageEditor.getData();
			log.info("===============1=========list.size()=====" + list.size());
			String sqlString = "";
			String sqlFiled="";
			List<Integer> taIndexList = new ArrayList<Integer>();//多行文本框的index
			for (int i = 0; i < list.size(); i++) {
				sqlString = sqlString +BeforeTheSuffix.Prefix+list.get(i).getSqlString();
				sqlFiled=sqlFiled+BeforeTheSuffix.Prefix+list.get(i).getName()+",";
				//sqlString = sqlString +list.get(i).getSqlString();
				log.info("====================sqlString:"+sqlString);
				list.get(i).setPage_id(page_id);
				String type = list.get(i).getClass().getSimpleName();
				log.info("控件的类型名称是：" + type);
				// 如果是图片控件 base64 转图片
				log.info("=====================这里是关于控件的保存处理，正常执行=======================");
				if (type.equals("ImageControl")) {
					ImageControl imageControl = (ImageControl) list.get(i);
					String tempFileName = HostConstants.FILE_PATH + new Date().getTime() + ".png";
					if (imageControl.getSrc() != null && !imageControl.getSrc().equals("http://")) {
						Base64ToImage.GenerateImage(imageControl.getSrc(), tempFileName);
						imageControl
						.setSrc(tempFileName.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST).trim());
						list.set(i, imageControl);
						// getSqlSession().insert("ImageControl", list.get(i));
					}
				}
				if (type.equals("Mingxibiao")) {
					Mingxibiao biao = (Mingxibiao) list.get(i);
					biao.setLeipiplugins("mingxibiao");
					log.info("===============明细表 ：============================="+biao.getLeipiplugins());
					list.set(i, biao);

				}
				if (type.equals("JobProgress")) {
					JobProgress job = (JobProgress) list.get(i);
					job.setLeipiplugins("jobprogress");
					log.info("===============工作进度表 ：============================="+job.getTitle());
					list.set(i, job);

				}
				if (type.equals("Pagekeywords")) {
					Pagekeywords words = (Pagekeywords) list.get(i);
					words.setLeipiplugins("pagekeywords");
					log.info("===============页面关键字表 ：============================="+words.getLeipiplugins());
					list.set(i, words);

				}

				if (type.equals("ScoreControl")) {
					ScoreControl words = (ScoreControl) list.get(i);
					words.setLeipiplugins("score");
					log.info("===============评论控件表 ：============================="+words.getLeipiplugins());
					list.set(i, words);

				}
				if (type.equals("HeaderAndFooter")) {
					HeaderAndFooter words = (HeaderAndFooter) list.get(i);
					words.setLeipiplugins("headerandfooter");
					log.info("===============头/底部模板控件表 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				if (type.equals("SidebarNav")) {
					SidebarNav words = (SidebarNav) list.get(i);
					words.setLeipiplugins("sidebarnav");
					log.info("===============侧栏导航控件表 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				if (type.equals("MultiDataSourcePublic")) {
					MultiDataSourcePublic words = (MultiDataSourcePublic) list.get(i);
					words.setLeipiplugins("multidatasourcepublic");
					log.info("===============多数源发布标识控件表 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				if (type.equals("AssetdetailControl")) {
					AssetdetailControl words = (AssetdetailControl) list.get(i);
					words.setLeipiplugins("assetdetail");
					log.info("===============资产明细表 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				
				
				if (type.equals("AddcategoryControl")) {
					AddcategoryControl words = (AddcategoryControl) list.get(i);
					words.setLeipiplugins("addcategory");
					log.info("===============添加类别 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("HtProductsuploadControl")) {
					HtProductsuploadControl words = (HtProductsuploadControl) list.get(i);
					words.setLeipiplugins("productsupload");
					log.info("===============餐品上传 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("HtPreviewProductsControl")) {
					HtPreviewProductsControl words = (HtPreviewProductsControl) list.get(i);
					words.setLeipiplugins("previewproducts");
					log.info("===============预览餐品 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("HtOrdersCentreControl")) {
					HtOrdersCentreControl words = (HtOrdersCentreControl) list.get(i);
					words.setLeipiplugins("orderscentre");
					log.info("===============订单中心 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("HtVemOrderfoodControl")) {
					HtVemOrderfoodControl words = (HtVemOrderfoodControl) list.get(i);
					words.setLeipiplugins("vemorderfood");
					log.info("===============自助机点餐：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("HtUpproductsControl")) {
					HtUpproductsControl words = (HtUpproductsControl) list.get(i);
					words.setLeipiplugins("upproducts");
					log.info("===============页面广告上传 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("MyReleaseCommoditiesControl")) {
					MyReleaseCommoditiesControl words = (MyReleaseCommoditiesControl) list.get(i);
					words.setLeipiplugins("myreleasecommodities");
					log.info("===============美业商品 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("MyUploadshopControl")) {
					MyUploadshopControl words = (MyUploadshopControl) list.get(i);
					words.setLeipiplugins("myuploadshop");
					log.info("===============美业店铺上传 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("MyBeautybgControl")) {
					MyBeautybgControl words = (MyBeautybgControl) list.get(i);
					words.setLeipiplugins("mybeautybg");
					log.info("===============美业后台 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				if (type.equals("MybeautypreviewControl")) {
					MybeautypreviewControl words = (MybeautypreviewControl) list.get(i);
					words.setLeipiplugins("mybeautypreview");
					log.info("===============美业客户预览 ：============================="+words.getLeipiplugins());
					list.set(i, words);
				}
				
				
				
				
				if (type.equals("TreeClassifyControl")) {
					TreeClassifyControl ct = (TreeClassifyControl) list.get(i);
					ct.setLeipiplugins("classifytree");
					log.info("===============树形分类控件 ：============================="+ct.getLeipiplugins());
					list.set(i, ct);

				}
				if (type.equals("TreeClassify02Control")) {
					TreeClassify02Control tc = (TreeClassify02Control) list.get(i);
					tc.setLeipiplugins("classifytree02");
					log.info("===============树形分类2控件 ：============================="+tc.getLeipiplugins());
					list.set(i, tc);

				}

				if (type.equals("TreeClassify03Control")) {
					TreeClassify03Control tc = (TreeClassify03Control) list.get(i);
					tc.setLeipiplugins("classifytree03");
					log.info("===============树形分类3控件 ：============================="+tc.getLeipiplugins());
					list.set(i, tc);

				}

				if (type.equals("TreeClassify04Control")) {
					TreeClassify04Control tc = (TreeClassify04Control) list.get(i);
					tc.setLeipiplugins("classifytree04");
					log.info("===============树形分类4控件 ：============================="+tc.getLeipiplugins());
					list.set(i, tc);

				}






				// 如果是内嵌路由控件
				if (type.equals("iFrameRouterControl")) {
					iFrameRouterControl iFrameRouterControl = (iFrameRouterControl) list.get(i);
					if (!new File(HostConstants.FILE_PATH).exists()) {
						new File(HostConstants.FILE_PATH).mkdirs();
					}
					String[] length = iFrameRouterControl.getOrgchecked().split("`");
					if (iFrameRouterControl.getOrgsrc() != null) {
						String str = "";
						// 内嵌路由base64转图片链接
						images = iFrameRouterControl.getOrgsrc().split("`", -1);

						for (int j = 0; j < images.length - 1; j++) {
							String tempFileName = HostConstants.FILE_PATH + new Date().getTime() + ".png";
							if (images[j].equals("") || images[j] == null) {
								str += "`";
							} else if (images[j].contains("http://")) {
								str += images[j] + "`";
							} else {
								Base64ToImage.GenerateImage(images[j], tempFileName);
								str += tempFileName.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST).trim()
										+ "`";
							}
						}
						// 删除最后一个字符
						/*
						 * if(images.length > 1) { str = str.substring(0,
						 * str.length()-1); }
						 */
						iFrameRouterControl.setOrgsrc(str);
						list.set(i, iFrameRouterControl);
						// list.set(i, iFrameRouterControl);
					}
				}

				// 如果是按钮控件
				if (type.equals("ButtonControl")) {
					ButtonControl buttonControl = (ButtonControl) list.get(i);
					if (!new File(HostConstants.FILE_PATH).exists()) {
						new File(HostConstants.FILE_PATH).mkdirs();
					}

					String tempFileName = HostConstants.FILE_PATH + new Date().getTime() + ".png";

					if (buttonControl.getOrgsrc() != null && !buttonControl.getOrgsrc().contains("http://")) {
						Base64ToImage.GenerateImage(buttonControl.getOrgsrc(), tempFileName);
						buttonControl.setOrgsrc(tempFileName.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST));
					}

					// 删除最后一个字符
					/*
					 * if(images.length > 1) { str = str.substring(0,
					 * str.length()-1); }
					 */
					buttonControl.setOrgsrc(buttonControl.getOrgsrc());
					list.set(i, buttonControl);
					// list.set(i, iFrameRouterControl);

				}

				// 如果是报表控件
				if (type.equals("ReportControl")) {
					ReportControl rc = (ReportControl) list.get(i);
					// 类名
					String className = Pinyin4jUtil.toPinyin(rc.getNode_name());
					className = PageDesignOperatorFacadeImpl.captureName(className.toLowerCase());
					String sql = "SELECT * FROM " + className + "";
					// 储存数组
					String[] str = null;

					String[] fields = rc.getField().split("`");
					if (fields.length >= 1) {
						for (int j = 0; j < fields.length; j++) {
							if (j == 0) {
								str = fields[j].split(",");
								sql += " WHERE " + str[0] + "*1 " + tihuan(str[1]) + " " + str[2];
							} else {
								str = fields[j].split(",");
								sql += " AND " + str[0] + "*1 " + tihuan(str[1]) + " " + str[2];
							}
						}
					}

					// 获取字段标题
					PageEditor page = this.selectPageEditor(rc.getPid());
					JSONObject jsonObj = new JSONObject();
					if (page != null) {
						JSONArray jsonArray = JSONArray.parseArray(page.getTitle());
						// JSONObject jsonObject =
						// JSONObject.parseObject(page.getSelected());
						LinkedHashMap<String, Object> jsonMap = JSON.parseObject(page.getSelected(),
								new TypeReference<LinkedHashMap<String, Object>>() {
						});
						int k = 1;
						for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
							// log.info(entry.getKey() + ":" +
							// entry.getValue());
							jsonObj.put(entry.getKey(), jsonArray.get(k - 1));
							k++;
						}
						rc.setFields(jsonObj.toString());
					}
					rc.setSqlStr(sql);
					list.set(i, rc);
					// getSqlSession().insert("ReportControl", list.get(i));
				}

				if(type.equals("TextareaControl")) {
					taIndexList.add(i);
					log.info("这里是多行文本框的索引号 ===="+i);
				}

				log.info("这里准备进入insert，type========="+type);
				log.info("这里准备进入insert，list.get(i)========="+list.get(i));
				getSqlSession().insert(type, list.get(i));
				long ret_id = 0;
				if (list.get(i).getId() != null) {
					ret_id = list.get(i).getId();
				}

				if (type.equals("RadiosControl")) {
					RadiosControl radiosControl = (RadiosControl) list.get(i);
					List<OptionControl> ops = radiosControl.getOptions();
					for (int j = 0; j < ops.size(); j++) {
						log.info("单选框序号为：" + ret_id + "，它的选项：" + ops.get(j).getName());
						ops.get(j).setControl_id(ret_id);
						getSqlSession().insert("OptionControl", ops.get(j));
					}
				}
				if (type.equals("CheckboxsControl")) {
					CheckboxsControl chControl = (CheckboxsControl) list.get(i);
					List<OptionControl> ops = chControl.getOptions();
					for (int j = 0; j < ops.size(); j++) {
						log.info("复选框序号为：" + ret_id + "，它的选项：" + ops.get(j).getName());
						ops.get(j).setControl_id(ret_id);
						getSqlSession().insert("OptionControl", ops.get(j));
					}
				}
				/*
				 * //如果是分类树形控件 if (type.equals("SortControl")) { SortControl
				 * sort = (SortControl) list.get(i); SortChildren sortChildren =
				 * new SortChildren(); sortChildren.setPid(0);
				 * sortChildren.setName("分类树");
				 * sortChildren.setNodeId(sort.getNodeid());
				 * 
				 * //查询是否已经存在子节点 List<SortControl> sorts =
				 * getSqlSession().selectList("searchSort", sort.getNodeid());
				 * if(sorts.size() >= 1) { //已经存在删除旧的节点
				 * getSqlSession().insert("delAllSort", sort.getNodeid()); }
				 * //新增默认节点 getSqlSession().insert("addSort", sortChildren); }
				 */
			}
			param = new HashMap<String, Object>();
			log.info("这里准备进入拼音==================");
			// 中文转为拼音shareTo_name，曾智宏
			if(pageEditor.getShareTo_name()!=null) {
				String shareTo_name = Pinyin4jUtil.toPinyin(pageEditor.getShareTo_name());
				shareTo_name = shareTo_name.toLowerCase();
				shareTo_name = PageDesignOperatorFacadeImpl.captureName(shareTo_name);//
				pageEditor.setShareTo_name(shareTo_name);
			}


			/*曾智宏*/
			String formName;
			log.info("这里准备进入判断shareTo_name=================="+pageEditor.getShareTo_name());
			if(pageEditor.getShareTo_name()==null) {
				formName = pageEditor.getNode_name();
				log.info("=========进入了formNameIf判断=======formName============="+formName);
			}else {
				Map<String, String> paramForDeleteTable = new HashMap<String,String>();
				paramForDeleteTable.put("table_names", pageEditor.getNode_name());
				getSqlSession().delete("deleteTableById", paramForDeleteTable);//删表

				formName = pageEditor.getShareTo_name();
				log.info("=========进入了formNameIf判断=======formName============="+formName);
			}
			/*曾智宏*/

			param.put("tableName", formName);
			// 格式化时间字符
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
			String new_tableName = formName + simpleDateFormat.format(new Date());
			param.put("new_tableName", new_tableName);
			param.put("fieldsStr", sqlString);
			log.info("======sqlString==================="+sqlString.toString());
			log.info("======要准备创建表的param的String==================="+param.toString());

			//曾智宏

			Integer isPublic = nodeDao.getIspublicByNodeId(pageEditor.getNode_id());
			log.info("=====if之前===isPublic=========="+isPublic);
			if(isPublic==0||isPublic==2) {//当页面不为浏览页时创建表
				// 判断表名是否存在
				Object name = getSqlSession().selectOne("existsTable", param);
				if(name==null){
					// 创建新表
					getSqlSession().update("createTable", param);
				}
			}
			log.info("=====if之后===isPublic=========="+isPublic);
			// 判断表名是否存在
			//			Object name = getSqlSession().selectOne("existsTable", param);
			//			if(name==null){
			//				// 创建新表
			//				getSqlSession().update("createTable", param);
			//			}
			//============捷程序控件数据管理1.0版本=============
			//fastJsonDiff工具类  只取Json字符串的key值
			fastJsonDiff fjd=new fastJsonDiff();
			JSONObject job = JSONObject.parseObject(selected);
			log.info("selected:======================="+selected);
			StringBuffer selectedfjd= fjd.getAllKey(job);
			log.info("selectedfjd-============="+selectedfjd);
			String newselected=new String(selectedfjd);
			// 删除最后一个字符
			if(newselected.length() > 1) { 
				newselected = newselected.substring(0,
						newselected.length()-1); 
			}

			title=title.replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.，,。？“”]+","");
			String sw=BeforeTheSuffix.Prefix;
			//将selected和title合并为一个List
			String[] newSelected = newselected.split(",");
			List<String> selectedList = Arrays.asList(newSelected);
			String[] titleSplit = title.split(",");
			List<String> titleList = Arrays.asList(titleSplit);
			String comparativeStudy="";
			log.info("selectedList============="+selectedList.size()+"========="+selectedList.toString());
			for (int i = 0; i < selectedList.size(); i++) {
				String str1= selectedList.get(i);
				String str2 = titleList.get(i);
				comparativeStudy+=sw+str1+":"+str2+",";
			}
			if (comparativeStudy.equals(sw+":"+",")) {
				comparativeStudy="";
			}
			//删除最后一个字符
			if (comparativeStudy.length()>0) {
				comparativeStudy = comparativeStudy.substring(0,comparativeStudy.length()-1);
			}
			log.info("comparativeStudy=============="+comparativeStudy);
			//求出数据库的控件字段及其备注
			log.info("========这里表名应该是shareTo_name吧=====param===="+param);
			List<Map<String,String>> selectList = getSessionTemplate().selectList("getTableCOLUMNNAME", param);
			log.info("selectList============"+selectList);
			String comparativeStudyTwo="";
			if(selectedList!=null){
				String COLUMN_NAME="";
				String column_comment="";

				for(Map<String, String> map:selectList){
					for (String m:map.keySet()) {
						column_comment= map.get(m);
						comparativeStudyTwo+=column_comment+",";
					}
				}
				log.info("comparativeStudyTwo============"+comparativeStudyTwo);
				//删除最后一个字符
				if(comparativeStudyTwo.length()>1){
					comparativeStudyTwo=comparativeStudyTwo.substring(0,comparativeStudyTwo.length()-1);
				}
				String[] str=comparativeStudyTwo.split(",");
				List<String> asList = Arrays.asList(str);
				String value1="";
				String value2="";
				String value="";

				for (int i = 0; i < asList.size()-1; i++) {
					value1=asList.get(i);
					value2=asList.get(i+1);
					i++;
					value+=value1+":"+value2+",";
				}
				// 删除最后一个字符
				if(value.length() > 1) { 
					value = value.substring(0,
							value.length()-1); 
				}
				comparativeStudyTwo=value;
				log.info("comparativeStudy=============="+comparativeStudy);
				log.info("comparativeStudyTwo=============="+value);
			}
			List<String> comparativeStudyList = Arrays.asList(comparativeStudy.split(","));
			List<String> comparativeStudyTwoList = Arrays.asList(comparativeStudyTwo.split(","));
			String temp1=comparativeStudyList.toString().replaceAll("[\\[\\]]", ",").replaceAll("\\s+", "");
			String temp2=comparativeStudyTwoList.toString().replaceAll("[\\[\\]]", ",").replaceAll("\\s+", "");
			String result1="";
			String result2="";
			String result="";
			for (int i = 0; i < comparativeStudyList.size(); i++) {
				if (temp2.indexOf(","+comparativeStudyList.get(i)+",")==-1) {
					result1+=comparativeStudyList.get(i)+",";
				}
			}
			for (int i = 0; i < comparativeStudyTwoList.size(); i++) {
				if(temp1.indexOf(","+comparativeStudyTwoList.get(i)+",")==-1){
					result2+=comparativeStudyTwoList.get(i)+",";
				}
			}

			if(result1==""&&result2==""){
				result="";
				log.info("2个List完全一致");
			}
			if(result2!=""&&result1!=""){
				log.info("2个list完全不一致");
				//1.0版本 此处未做细致处理,将list2不一致的字段从数据库删除，再将list1的字段写入数据库
				//当2个list完全不一致时，代表前端页面直接被用代码修改了控件属性,此时暂时无法保证原有数据丢失问题，需要前端传一个控件的唯一属性进行逻辑判断
				List<String> resultList = Arrays.asList(result2.trim().split(","));
				List<String> resultList1 = Arrays.asList(result1.trim().split(","));
				Map<String,Object> map=new HashMap<String, Object>();

				/*曾智宏*///如果shareTo_name就取代node_name
				if(pageEditor.getShareTo_name()!=null) {
					pageEditor.setNode_name(pageEditor.getShareTo_name());
					log.info("====开始准备处理数据表字段=shareTo_name取代node_name后的getNode_name============="+pageEditor.getNode_name());
				}
				/*曾智宏*/

				if (resultList.size()>0) {
					for (int i = 0; i < resultList.size(); i++) {
						for (String s:resultList.get(i).split(",")) {
							String[] resultListMap = s.split(":");
							map.put("control_name",resultListMap[0].trim());
							map.put("title",resultListMap[1].trim());
							map.put("node_name",pageEditor.getNode_name().trim());
							try {
								getSessionTemplate().delete("deleteControl", map);
								log.info("删除成功");
							} catch (Exception e) {
								log.info("删除失败"+e.toString());
							}
						}
					}
				}
				if ( resultList1.size()>0) {
					for (int i = 0; i < resultList1.size(); i++) {
						for (String s:resultList1.get(i).split(",")) {
							String[] resultListMap = s.split(":");
							map.put("control_name",resultListMap[0].trim());
							map.put("title",resultListMap[1].trim());
							map.put("node_name",pageEditor.getNode_name().trim());
							try {
								getSessionTemplate().insert("insertControl", map);
								log.info("添加成功");
							} catch (Exception e) {
								log.info("添加失败"+e.toString());
							}
						}
					}
				}

			}
			if(result1!=""&&result2==""){
				result=result1;
				log.info("存在list1而不存在list2的元素有：" + result1);
				List<String> resultList = Arrays.asList(result.trim().split(","));
				Map<String,Object> map=new  HashMap<String, Object>();
				for (int i = 0; i < resultList.size(); i++) {
					for (String s:resultList.get(i).split(",")) {
						String[] resultListMap = s.split(":");
						map.put("control_name",resultListMap[0].trim());
						map.put("title",resultListMap[1].trim());
						map.put("node_name",pageEditor.getNode_name().trim());
						try {
							getSessionTemplate().insert("insertControl", map);
							log.info("添加成功");
						} catch (Exception e) {
							log.info("添加失败"+e.toString());
						}
					}
				}
			}
			if(result1==""&&result2!=""){
				result=result2;
				log.info("存在list2而不存在list1的元素有：" + result2);
				List<String> resultList = Arrays.asList(result.split(","));
				Map<String,Object> map=new  HashMap<String, Object>();
				for (int i = 0; i < resultList.size(); i++) {
					for (String s:resultList.get(i).split(",")) {
						String[] resultMap = s.split(":");
						map.put("control_name",resultMap[0]);
						map.put("title",resultMap[1]);
						map.put("node_name",pageEditor.getNode_name());
						try {
							getSessionTemplate().delete("deleteControl", map);
							log.info("删除成功");
						} catch (Exception e) {
							log.info("删除失败"+e.toString());
						}
					}
				}
			}

			// 重命名表
			/*if (name != null) {
				getSqlSession().update("changeTableName", param);
			}

			// 创建新表
			getSqlSession().update("createTable", param);*/
			// 复制旧表数据到新表
			// msg.setMsg(images);
			msg.setStatus("1");
			msg.setStatusMsg("success");
		} catch (Exception e) {
			msg.setMsg(e.toString());
			log.info("出错的原因是：" + e.toString());

		}

		return msg;
	}




	// 查询noteId
	public PageEditor getByNodeId(long node_id) {
		PageEditor page = new PageEditor();
		try {
			page = getSqlSession().selectOne("getByNode_Id", node_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	// 更新文件
	public int updatePageEditor(PageEditor page) {

		return getSessionTemplate().update("updatePageEditor", page);
	}

	// 添加文件
	public int addPageEditor(PageEditor page) {

		return getSessionTemplate().insert("insertPageEditor", page);
	}

	// 查询node_id是否存在
	public int getCountForNodeId(Map<String, Object> param) {

		return getSessionTemplate().selectOne("getCountForNodeId", param);
	}

	// 更新文件is_delete状态
	public int updateIsDelete(Map<String, Object> param) {

		return getSessionTemplate().update("change_pageDesign_is_delete", param);
	}

	/**
	 * 查询表单
	 */
	public PageEditor selectPageEditor(long id) {

		return getSessionTemplate().selectOne("selectPageEditor", id);
	}

	/**
	 * 替换报表公式判断大于等于
	 */
	public static String tihuan(String str) {
		// reportcontrol,&lt;,1,报表控件`reportcontrol,&lt;=,2,报表控件`reportcontrol,=,3,
		// 报表控件`reportcontrol,&gt;=,4,报表控件`reportcontrol,&gt;,5,报表控件
		str = str.replace("&lt;", "<");
		str = str.replace("&gt;", ">");

		return str;
	}

	/**
	 * 获取关联表单对象
	 */
	public ReturnMsg getPageEditorGid(Integer node_id, Long gid, String nodeName) {
		ReturnMsg msg = new ReturnMsg();
		Object o = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("node_id", node_id);
		PageEditor pageEditor = getSqlSession().selectOne("getByNode_Id", param);
		log.info("===============pageEditor===" + pageEditor.getData());

		List<BaseControl> list = new ArrayList<BaseControl>();
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！" + gid);
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！");
		log.info("-----------------------------关联查询！");
		try {

			// 文本控件
			List<TextControl> txts = getSqlSession().selectList("selectTextControls", pageEditor.getId());
			for (int i = 0; i < txts.size(); i++) {
				TextControl text = txts.get(i);
				// 根据数据源获取数据
				if (isNotNull(text.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(text.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, field, className);
					}
					text.setSqldata(value);

					list.add(text);
				} else {
					// 执行查询命
					o = invokeUtil.invoke3(nodeName, text.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, text.getName(), null);
					}

					text.setSqldata(value);
					list.add(text);
				}
			}

			// 多行文本控件
			List<TextareaControl> textareas = getSqlSession().selectList("selectTextareaControls", pageEditor.getId());
			for (int i = 0; i < textareas.size(); i++) {
				TextareaControl text = textareas.get(i);
				// 根据数据源获取数据
				if (isNotNull(text.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(text.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					text.setSqldata(value);

					list.add(text);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, text.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, text.getName(), null);
					}

					text.setSqldata(value);
					list.add(text);
				}

				// list.add(textareas.get(i));
			}

			// 复选框控件
			List<CheckboxsControl> cbos = getSqlSession().selectList("selectCheckboxsControls", pageEditor.getId());
			for (int i = 0; i < cbos.size(); i++) {
				log.info("来到了复选框的选项获取");
				CheckboxsControl cbo = cbos.get(i);
				List<OptionControl> ops = getSqlSession().selectList("selectCboOptions", cbo.getId());
				cbo.setOptions(ops);

				// 根据数据源获取数据
				if (isNotNull(cbo.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(cbo.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					cbo.setSqldata(value);

					list.add(cbo);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, cbo.getName1(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, cbo.getName1(), null);
					}

					cbo.setSqldata(value);
					list.add(cbo);
				}
			}
			/*
			 * for (int i = 0; i < cbos.size(); i++) { list.add(cbos.get(i)); }
			 */
			// 单选框控件
			List<RadiosControl> rdos = getSqlSession().selectList("selectRadiosControls", pageEditor.getId());
			for (int i = 0; i < rdos.size(); i++) {
				log.info("来到了单选框的选项获取");
				RadiosControl rdo = rdos.get(i);
				List<OptionControl> ops = getSqlSession().selectList("selectRdoOptions", rdo.getId());
				rdo.setOptions(ops);
				// 根据数据源获取数据
				if (isNotNull(rdo.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(rdo.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					rdo.setSqldata(value);

					list.add(rdo);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, rdo.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, rdo.getName(), null);
					}

					rdo.setSqldata(value);
					list.add(rdo);
				}

			}
			/*
			 * for (int i = 0; i < rdos.size(); i++) { list.add(rdos.get(i)); }
			 */

			List<MacrosControl> macros = getSqlSession().selectList("selectMacrosControls", pageEditor.getId());
			for (int i = 0; i < macros.size(); i++) {
				MacrosControl macro = macros.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(pageEditor.getNode_name(), macro.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, macro.getName(), null);
				}

				macro.setSqldata(value);
				list.add(macro);
			}

			List<QrcodeControl> qrcodes = getSqlSession().selectList("selectQrcodeControls", pageEditor.getId());
			for (int i = 0; i < qrcodes.size(); i++) {
				QrcodeControl qrcode = qrcodes.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, qrcode.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, qrcode.getName(), null);
				}

				qrcode.setSqldata(value);
				list.add(qrcode);
			}

			// 下拉框控件
			List<SelectControl> sels = getSqlSession().selectList("selectSelectControls", pageEditor.getId());
			for (int i = 0; i < sels.size(); i++) {
				SelectControl select = sels.get(i);
				if (isNotNull(select.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(select.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					select.setSqldata(value);

					list.add(select);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, select.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, select.getName(), null);
					}

					select.setSqldata(value);
					list.add(select);
				}

			}

			List<ListctrlControl> listctrls = getSqlSession().selectList("selectListctrlControls", pageEditor.getId());
			for (int i = 0; i < listctrls.size(); i++) {
				ListctrlControl listctrl = listctrls.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(pageEditor.getNode_name(), listctrl.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, listctrl.getName(), null);
				}

				listctrl.setSqldata(value);
				list.add(listctrl);
			}

			// 进度条控件
			List<ProgressbarControl> pros = getSqlSession().selectList("selectProgressbarControls", pageEditor.getId());
			for (int i = 0; i < pros.size(); i++) {
				ProgressbarControl pro = pros.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, pro.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, pro.getName(), null);
				}

				pro.setSqldata(value);
				list.add(pro);
			}

			// 图片控件
			List<ImageControl> image = getSqlSession().selectList("selectImageControls", pageEditor.getId());
			for (int i = 0; i < image.size(); i++) {

				ImageControl img = image.get(i);
				if (isNotNull(img.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(img.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					img.setSqldata(value);

					list.add(img);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, img.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, img.getName(), null);
					}

					img.setSqldata(value);
					list.add(img);
				}

			}

			// 内嵌路由控件
			List<iFrameRouterControl> routers = getSqlSession().selectList("selectiFrameRouterControls",
					pageEditor.getId());
			for (int i = 0; i < routers.size(); i++) {
				iFrameRouterControl router = routers.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, router.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, router.getName(), null);
				}

				router.setSqldata(value);
				list.add(router);
			}

			// 报表控件
			List<ReportControl> rcs = getSqlSession().selectList("selectReportControls", pageEditor.getId());
			for (int i = 0; i < rcs.size(); i++) {
				ReportControl rc = rcs.get(i);
				o = null;
				if (rc.getSqlStr() != null || rc.getSqlStr() != "") {

					// 调用执行sql语句
					o = invokeUtil.invoke(rc.getNode_name(), rc.getSqlStr());

					rc.setData(o);
					rc.setSqlStr("5L2g5bCx5piv5Liq5YK76YC8");

					list.add(rc);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, rc.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, rc.getName(), null);
					}

					rc.setSqldata(value);
					list.add(rc);
				}

			}

			// 热区控件
			List<wifiBlockControl> wifiBlockControls = getSqlSession().selectList("selectwifiBlockControls",
					pageEditor.getId());
			for (int i = 0; i < wifiBlockControls.size(); i++) {

				wifiBlockControl wifiBlockControl = wifiBlockControls.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, wifiBlockControl.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, wifiBlockControl.getName(), null);
				}

				wifiBlockControl.setSqldata(value);
				list.add(wifiBlockControl);
			}

			// 关联控件
			List<assControl> assControls = getSqlSession().selectList("selectassControls", pageEditor.getId());
			for (int i = 0; i < assControls.size(); i++) {

				assControl assControl = assControls.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, assControl.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, assControl.getName(), null);
				}

				assControl.setSqldata(value);
				list.add(assControl);
			}

			// 按钮控件
			List<ButtonControl> buttonControls = getSqlSession().selectList("selectButtonControls", pageEditor.getId());
			for (int i = 0; i < buttonControls.size(); i++) {

				ButtonControl buttonControl = buttonControls.get(i);
				// 执行查询命令
				o = invokeUtil.invoke3(nodeName, buttonControl.getName(), gid);

				// 储存数据源键值对
				String value = null;
				if (o != null) {
					value = invokeUtil.toString(o, buttonControl.getName(), null);
				}

				buttonControl.setSqldata(value);
				list.add(buttonControl);
			}

			// 评论显示控件
			List<CommentControl> commentControl = getSqlSession().selectList("selectCommentControls",
					pageEditor.getId());
			for (int i = 0; i < commentControl.size(); i++) {
				CommentControl comment = commentControl.get(i);
				if (isNotNull(comment.getDatasource())) {
					JSONObject jsonObj = JSONObject.parseObject(comment.getDatasource());
					String data = jsonObj.getString("data");

					String className = jsonObj.getString("data");
					String field = jsonObj.getString("field");

					// 执行查询命令
					o = invokeUtil.invoke3(className, field, gid);

					// 储存数据源键值对
					String value = invokeUtil.toString(o, field, className);
					comment.setSqldata(value);

					list.add(comment);
				} else {
					// 执行查询命令
					o = invokeUtil.invoke3(nodeName, comment.getName(), gid);

					// 储存数据源键值对
					String value = null;
					if (o != null) {
						value = invokeUtil.toString(o, comment.getName(), null);
					}

					comment.setSqldata(value);
					list.add(comment);
				}
			}

			// 关联控件
			List<SortControl> sortControl = getSqlSession().selectList("selectSortControls", pageEditor.getId());
			for (int i = 0; i < sortControl.size(); i++) {
				list.add(sortControl.get(i));
			}

			Collections.sort(list);
			pageEditor.setData(list);
			msg.setStatus("0");
			msg.setStatus("获取关联详情页面成功！！");
			msg.setMsg(pageEditor);
		} catch (Exception e) {
			msg.setStatus("2");
			msg.setStatus("获取关联详情页面失败！！");
		}

		return msg;
	}

	// 回复评论
	public ReturnMsg insertComment(String content, String field, Integer contentId, String userName, String datasource,
			Integer nodeId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "评论失败");
		try {
			Object obj = null;
			if (datasource == null || datasource.equals("")) {
				return new ReturnMsg<Object>("1", "没有绑定数据源");
			} else {
				Object o = null;
				JSONObject jsonObj = JSONObject.parseObject(datasource);
				String data = jsonObj.getString("data");
				String fields = jsonObj.getString("field");
				// 绑定源不等于空
				if (!data.equals("") && !fields.equals("")) {
					String className = jsonObj.getString("data");
					o = invokeUtil.invoke2(className, fields, null, null, contentId, null);
					String value = null;
					value = invokeUtil.toString(o, fields, null);
					// 已有评论 处理数据
					if (value != null) {
						JSONArray jsonArr = JSONArray.parseArray(value);
						for (int i = 0; i < jsonArr.size(); i++) {
							Map<String, Object> map = (Map<String, Object>) jsonArr.get(i);
							// 取map里面数值
							String comment = (String) map.get(fields);
							Integer id = (Integer) map.get("id");

							if (comment.equals("")) {
								// 没有评论 处理数据
								JSONArray arr = new JSONArray();
								// 生成评论内容信息
								JSONObject json = new JSONObject();
								json.put("contentId", contentId);
								json.put("username", userName);
								json.put("content", content);
								json.put("id", contentId);
								arr.add(json);
								// 更新评论信息
								obj = invokeUtil.invoke4(className, fields, contentId, arr.toString());
								if (obj == null) {
									return new ReturnMsg<Object>("1", "更新评论失败");
								}
							} else {
								// 评论转换
								JSONArray arr = JSONArray.parseArray(comment);
								// 生成评论内容信息
								JSONObject json = new JSONObject();
								json.put("contentId", contentId);
								json.put("username", userName);
								json.put("content", content);
								json.put("id", contentId);
								arr.add(json);
								// 更新评论信息
								obj = invokeUtil.invoke4(className, fields, contentId, arr.toString());
								if (obj == null) {
									return new ReturnMsg<Object>("1", "更新评论失败");
								}
							}
						}
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("评论出现异常");
		}
		return msg;
	}

	// 数据源校验
	public static boolean isNotNull(String datasource) {

		try {

			if (datasource == null || datasource.equals("") || datasource.equals("null")) {
				return false;
			} else {
				JSONObject jsonObj = JSONObject.parseObject(datasource);
				if (jsonObj.getString("field").equals("") || jsonObj.getString("field") == null) {
					return false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	// 发布资源 提交表单
	public ReturnMsg ReleaseResources(PageEditor pageEditor) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "提交表单异常");
		try {

			List<BaseControl> base = pageEditor.getData();
			for (int i = 0; i < base.size(); i++) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	// 删除分类节点
	public int delSort(int id) {

		return getSessionTemplate().delete("delSort", id);
	}

	// 更新分类节点
	public int upSort(SortChildren sort) {

		return getSessionTemplate().update("upSort", sort);
	}

	// 插入分类节点
	public int addSort(SortChildren sort) {

		return getSessionTemplate().insert("addSort", sort);
	}

	public List<String> searchDatabase(String baseName) {

		return getSessionTemplate().selectList("searchDatabase", baseName);
	}

	public List<String> searchDataField(String baseName, String tableName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("baseName", baseName);
		map.put("tableName", tableName);

		return getSessionTemplate().selectList("searchDataField", map);
	}

	@Override
	public List<Map> getCourseEq() {
		return getSessionTemplate().selectList("getCourseEq");
	}

	@Override
	public List<Map> searchCourse(JSONObject json) {
		return getSessionTemplate().selectList("searchCourse");
	}

	@Override
	public int addUserNode(UserHasNode user) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertUserHasNode", user);
	}

	@Override
	public CascadeClassify getCascadeClassifyByRootId(Integer rootId) {

		return getSessionTemplate().selectOne("getCascadeClassifyByRootId", rootId);
	}

	@Override
	public void delCascadeClassifyById(Integer id) {

		getSessionTemplate().delete("delCascadeClassifyById", id);
	}

	@Override
	public Integer insertCascadeClassifyRecord(CascadeClassify classify) {
		return getSessionTemplate().insert("insertCascadeClassifyRecord", classify);
	}

	@Override
	public List<Map> getCascadeClassifyByParentId(int rootId) {

		return getSessionTemplate().selectList("getCascadeClassifyByParentId", rootId);
	}

	@Override
	public void updateCascadeClassify(CascadeClassify classify) {
		getSessionTemplate().selectOne("updateCascadeClassify", classify);
	}

	@Override
	public List<Map> getAllCascadeClassify() {

		return getSessionTemplate().selectList("getAllCascadeClassify");
	}

	// 搜索控件之添加绑定数据源
	@Override
	public Integer insertSearchControlRecord(SearchControl searchControl) {
		return getSessionTemplate().insert("insertSearchControlRecord", searchControl);
	}

	/**
	 * 搜索控件 (根据不定数据源及不定搜索条件搜索)
	 */
	public List<Map> selectDynamicSearch(QueryVo vo) {
		return getSessionTemplate().selectList("selectDynamicSearch", vo);
	}

	@Override
	public Map getUserWxOpenidByUid(int uId) {

		return getSessionTemplate().selectOne("getUserWxOpenidByUid", uId);
	}

	@Override
	public List getUserWxOpenidByGroup(Integer groupId) {

		return getSessionTemplate().selectList("getUserWxOpenidByGroup", groupId);
	}

	// 根据中文名字转换拼音，拼音缩写即表名，查出该表字段名及备注
	@Override
	public List<Map> getTableInformationByName(String tableName) {
		return getSessionTemplate().selectList("getTableInformationByName", tableName);
	}

	@Override
	public List<CascadeClassify> getRoleClassifyIdByUid(Integer uId) {
		return getSessionTemplate().selectList("getRoleClassifyIdByUid", uId);
	}

	@Override
	public List<Map> getRoleByThanRoleId(Integer roleId) {
		return getSessionTemplate().selectList("getRoleByThanRoleId", roleId);
	}

	@Override
	public List<String> getTableFieldionByName(String tableName) {
		return getSessionTemplate().selectList("getTableFieldionByName", tableName);
	}

	@Override
	public List<Map> getUserWeiXinOpenidByUserList(List list) {
		return getSessionTemplate().selectList("getUserWeiXinOpenidByUserList", list);
	}

	@Override
	public List<Integer> getUserWeiXinOpenidByRoleIdList(List<Integer> paramList) {
		return getSessionTemplate().selectList("getUserWeiXinOpenidByRoleIdList", paramList);
	}

	@Override
	public List<Integer> getUserWeiXinOpenidByPidList(List<Integer> paramList) {
		return getSessionTemplate().selectList("getUserWeiXinOpenidByPidList", paramList);
	}

	@Override
	public void insertPushMsg(PushMsg push) {
		getSessionTemplate().insert("insertPushMsg", push);
	}

	@Override
	public void insertPushReceive(Map param) {
		getSessionTemplate().insert("insertPushReceive", param);
	}

	@Override
	public Map selectWebshell(Integer uId) {
		return getSessionTemplate().selectOne("selectWebshell", uId);
	}

	// 临时用的注册编辑器权限方法
	@Override
	public int registerWebShell(String username, String password, String chinesename) {
		Map map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		map.put("chinesename", chinesename);
		return getSessionTemplate().insert("registerWebShell", map);
	}

	// 临时用的登录编辑器权限方法
	@Override
	public WebShell logWebShell(String username, String password) {
		Map map = new HashMap();
		map.put("username", username);
		map.put("password", password);
		return getSessionTemplate().selectOne("logWebShell", map);
	}

	@Override
	public List<Map> getWebShell() {
		return getSessionTemplate().selectList("getWebShell");
	}

	@Override
	public void updateWebShell(Integer id, Integer isdelete) {
		Map map = new HashMap();
		map.put("id", id);
		map.put("isdelete", isdelete);
		getSessionTemplate().update("updateWebShell", map);
	}

	@Override
	public List<Map> selectUserMobileByuIds(List list) {

		return getSessionTemplate().selectList("selectUserMobileByuIds", list);
	}

	@Override
	public Map getNodeByNodeId(long nodeId) {
		return getSessionTemplate().selectOne("getNodeByNodeId", nodeId);
	}

	/**
	 * 科普视频资源库
	 */
	@Override
	public int getKPCount() {
		return getSessionTemplate().selectOne("getKPCount");
	}

	@Override
	public List<KePuVideo> getKPQueryPage(Map map) {
		return getSessionTemplate().selectList("getKPQueryPage", map);
	}
	/**
	 * 排课
	 */
	@Override
	public int getPaiCourseCount() {
		return getSessionTemplate().selectOne("getPaiCourseCount");
	}

	@Override
	public List<PaiCourse> getPaiCourseQueryPage(Map map) {
		return getSessionTemplate().selectList("getPaiCourseQueryPage", map);
	}
	//ajax修改控件
	@Override
	public void updateControl(Map map) {
		getSessionTemplate().update("updateControl", map);
	}
	//增加控件
	@Override
	public void insertControl(Map map) {
		getSessionTemplate().insert("insertControl", map);
	}

	//删除控件
	@Override
	public void deleteControl(Map map) {
		getSessionTemplate().insert("deleteControl", map);

	}
	//获取页面表单控件
	public PageEditor getPageControl(long node_id){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("node_id", node_id);
		PageEditor pageEditor = getSqlSession().selectOne("getByNode_Id", param);
		getSqlSession().close();
		return pageEditor;
	}


	//导出Excel表格方法derivedForm
	@Override
	public List<Map> derivedForm(Map map) {
		return getSessionTemplate().selectList("derivedForm", map);
	}

	//根据树形节点查询对应的表与下属的表
	@Override
	public List<Map> selectTableById(Map map){
		return getSessionTemplate().selectList("selectTableById",map);
	}

	//根据树形节点删除对应的表与下属的表接方法deleteTableById
	@Override
	public int deleteTableById(Map map) {
		return getSessionTemplate().delete("deleteTableById", map);
	}

	@Override
	public void deleteNodeRecordById(Map map) {
		getSessionTemplate().delete("deleteNodeRecordById", map);
	}

	@Override
	public int checkColumn(String column,String shareToName) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("tableName", shareToName);
		return getSqlSession().selectOne("checkColumn", map);
	}
	//根据nodeId查询对应的表，再从表中根据selectId查
	@Override
	public List<Map> selectTableByNodeIdAndId(Map<String, Object> map) {
		return getSessionTemplate().selectList("selectTableByNodeIdAndId",map);
	}
	//根据nodeId查询对应的表，再从表中根据selectId删除
	@Override
	public int deleteTableByNodeIdAndId(Map<String, Object> map) {
		return getSessionTemplate().delete("deleteTableByNodeIdAndId", map);
	}




	@Override
	public String getNodeNameByNodeId(Integer dataTableId) {
		String nodeName = getSessionTemplate().selectOne("getNodeNameByNodeId", dataTableId);
		return nodeName;
	}


}
