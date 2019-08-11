package swtech.facade.pageDesign.service.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CascadeClassify;
import swtech.facade.pageDesign.entity.KePuVideo;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.PaiCourse;
import swtech.facade.pageDesign.entity.QueryVo;
import swtech.facade.pageDesign.entity.WebShell;
import swtech.facade.pageDesign.service.PageDesignQueryFacade;
import swtech.facade.pageDesign.util.FastJsonUtil;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.File.WriteMapper;
import swtech.service.pageDesign.biz.NodeQueryBiz;
import swtech.service.pageDesign.biz.PageDesignOperatorBiz;
import swtech.service.pageDesign.biz.PageDesignQueryBiz;
import swtech.service.pageDesign.biz.TreeNodeQueryBiz;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;
import util.Answer;
import util.BeforeTheSuffix;

@Path("pageDesignQueryFacade")
@Component("pageDesignQueryFacade")
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
public class PageDesignQueryFacadeImpl implements PageDesignQueryFacade {

	private static final Log log = LogFactory.getLog(PageDesignQueryFacadeImpl.class);

	@Autowired
	private TreeNodeQueryBiz treeNodeQueryBiz;
	@Autowired
	private PageDesignQueryBiz pageQueryBiz;
	@Autowired
	private PageDesignOperatorBiz pageDesignOperatorBiz;
	@Autowired
	private PageDesignDao pageDesignDao;
	@Autowired
	private NodeQueryBiz nodeQueryBiz;
	@Autowired
	private NodeDao dao;

	@GET
	@Path("/getPageContent")
	public ReturnMsg getPageContent(@QueryParam("id") long id) {
		//曾智宏
		//通过id查询ht_node表记录，获取其中is_approve字段
		int approve = nodeQueryBiz.getApprove(id);
//		log.info("==================刚刚查询到的approve的值==================="+approve);
		
		ReturnMsg msg = new ReturnMsg();
		
		if(approve==0) {//未被审核
			msg.setStatus("201");
			msg.setStatusMsg("该页面未被审核！！！");
		}else {
			msg = pageQueryBiz.getPageEditor(id);
		}
		return msg;
	}

	@POST
	@Path("/selectFormRecordByNodeId")
	public ReturnMsg selectFormRecordByNodeId(String record ) {
		ReturnMsg msg = new ReturnMsg();
		Object o = null;
		try {
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = new JSONObject();
			jsonObject=JSONObject.parseObject(record);
			Long nodeId = jsonObject.getLong("nodeId");
			PageEditor page = pageDesignOperatorBiz.selectPage(nodeId);

			
			Map<String, Object> map = new HashMap<String, Object>();
			// 操作数据库
			// String tableName = page.getTable_name();
			// 获取动态类名字
			String nodeName = dao.getNameByNodeId(nodeId);

//			log.info("===========进入getPageEditorf方法之前============");			
			PageEditor page123 = getPageEditorByNodeId(nodeId);//曾智宏
//			log.info("===========进入getPageEditorf方法之前============");	
			
			if(page123.getShareTo_name()!=null) {//曾智宏
				nodeName = page123.getShareTo_name();
//				log.info("====这里是selectFormRecordByNodeId更换nameName之后的nodeName============="+nodeName);
			}
			
			
			if (nodeName != null) {
				Map<String,Object> maps=new HashMap<String, Object>();
				Integer pageNum=jsonObject.getInteger("page");
				Integer pageSize=jsonObject.getInteger("pageSize");
				String orderByClause=jsonObject.getString("orderby");
				String classname=jsonObject.getString("classname");
				
				
				List<KePuVideo> keQueryPage=null;
				List<PaiCourse> paiCourse=null;
				//从哪个ID开始分页查询
				Integer pages=0;
				//总页数
				Integer totalPages=0;
				//记录总数
				Integer count=0;
				
				//判断页码是否为空  或者为0
				if(pageNum>1&&pageNum !=null){
					pages=(pageNum-1)*pageSize;
				}else{
					pages=0;
				}
				//设置数据库查询字段
				maps.put("page", pages);
				maps.put("pageSize", pageSize);
				maps.put("orderByClause", orderByClause);
				if (jsonObject.getString("table_field_all")!=null) {
					String table_field_all=BeforeTheSuffix.Prefix+jsonObject.getString("table_field_all");
					maps.put("tableFieldAll",table_field_all);
				}
				
				if (jsonObject.getString("searchContent")!=null) {
					String searchContent=jsonObject.getString("searchContent");
					maps.put("searchContent",searchContent);
					log.info("============searchContent++++++=="+maps);
				}
				
				
				//判断是否是内部数据源
				if(classname.equals("科普视频资源库")){
					keQueryPage = pageDesignDao.getKPQueryPage(maps);
					map.put("data", keQueryPage);
					log.info("===============此时列表为："+keQueryPage.toString());
					count = pageDesignDao.getKPCount();
					map.put("count", count);
					if (count >= 1) {
						// 求余等于0 或不等于0 页码加1
						totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
					} else {
						totalPages = count;
					}
					map.put("totalPages", totalPages);
				}if(classname.equals("排课管理")){
					paiCourse = pageDesignDao.getPaiCourseQueryPage(maps);
					map.put("data", paiCourse);
					log.info("===============此时列表为："+paiCourse.toString());
					count = pageDesignDao.getPaiCourseCount();
					map.put("count", count);
					if (count >= 1) {
						// 求余等于0 或不等于0 页码加1
						totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
					} else {
						totalPages = count;
					}
					map.put("totalPages", totalPages);
			}else{
				//外部数据源
				System.out.print("========nodeName======" + nodeName);
				String[] arr = WriteMapper.writeNodeName(nodeName);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Constructor con = cls.getConstructor();
				Object obj = con.newInstance();// 初始化一个实例
				//Method method = cls.getMethod("selectList");// 方法名和对应的参数类型
				Method method=cls.getDeclaredMethod("getQueryPage", Map.class);//方法名和对应的参数类型
				// o = pageDesignDao.selectPageByTableName("Tzfb");
//				log.info(maps+"============测试=======");
				o = method.invoke(obj,maps);// 调用得到的上边的方法method
			    String jsonString = FastJsonUtil.toJSONString(o);
			    String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
			    log.info("=============jsonString==========="+jsonString);
			    Object parse = JSONArray.parse(replaceAll);
			    map.put("data", parse);
			    
			    //获取页码
				//method = cls.getMethod("getCount");
				method = cls.getMethod("getCountByQuery", Map.class);
			    o=method.invoke(obj,maps);
			    map.put("count", o);
			    count=Integer.valueOf(o.toString());
			    if(count>=1){
			    	//求余
			    	totalPages=count % pageSize==0 ? count /pageSize :(count/pageSize)+1;
			    }else{
			    	totalPages=count;
			    }
			    map.put("totalPages", totalPages);
		}
				
			//分割并取出字段
			String[] selectds=page.getSelected().split(",");
			String str="";
			for (int i = 0; i < selectds.length; i++) {
				str=selectds[i].split(":")[0];
				selectds[i]=str.substring(str.indexOf('"')+1, str.length()-1);
			}
				
			if (page != null) {
				jsonArray = JSONArray.parseArray(page.getTitle());
				//jsonObject = JSONObject.parseObject(page.getSelected());
				map.put("title", jsonArray);
				map.put("selected", page.getSelected());
				map.put("selecteds", selectds);
			}

			msg.setMsg(map);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("查询全部数据成功！");
			}
			} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(e);
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败！");
		}

		return msg;
	}

	private PageEditor getPageEditorByNodeId(Long nodeId) {

		PageEditor pageEditor = null;
			pageEditor = pageDesignDao.getByNodeId(nodeId);
//			log.info("==========//通过nodeId查出来的pageEditor==================="+pageEditor);
			String shareTo_name = pageEditor.getShareTo_name();//从数据库查出来该页面的shareTo_name
//			log.info("==========//从数据库查出来该页面的shareTo_name==================="+shareTo_name);
			int shareTo_nodeId = pageEditor.getShareTo_nodeId();//从数据库查出来该页面的shareTo_nodeId
//			log.info("==========从数据库查出来该页面的shareTo_nodeId==================="+shareTo_nodeId);
		return pageEditor;
	}
	
	
	@GET
	@Path("/getPageContentGid")
	public ReturnMsg getPageContent(@QueryParam("id") Integer id, @QueryParam("gid") long gid) {
		ReturnMsg msg = new ReturnMsg();
		msg = pageQueryBiz.getPageEditorGid(id, gid);
		return msg;
	}

	@GET
	@Path("/getPageEditorData")
	public ReturnMsg getPageEditorData(@QueryParam("id") long nodeId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = pageQueryBiz.getPageEditorData(nodeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	// 搜索热区关键字
	@POST
	@Path("/searchWifiKey")
	public ReturnMsg searchWifiKey(String data) {
		ReturnMsg msg = null;
		try {

			msg = pageQueryBiz.searchWifiKey(data);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("searchDatabase")
	public ReturnMsg searchDatabase(@QueryParam("baseName") String baseName) {
		ReturnMsg msg = null;
		try {

			msg = pageQueryBiz.searchDatabase(baseName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("searchDataField")
	public ReturnMsg searchDataField(@QueryParam("baseName") String baseName,
			@QueryParam("tableName") String tableName) {
		ReturnMsg msg = null;
		try {

			msg = pageQueryBiz.searchDataField(baseName, tableName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("/getInformGroupTags")
	public ReturnMsg getInformGroupTags() {
		ReturnMsg msg = new ReturnMsg();
		String appid = "wxc1236b8d3ed297c5";
		String secret = "342feb2e83aad0c171e1eef7ab1f6553";
		String token;
		String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid
				+ "&secret=" + secret;

		try {
			/*
			 * boolean bool = CacheManage.isTimeOut(token_KEY); if(bool){ String
			 * value =
			 * swtech.facade.pageDesign.util.HttpUtils.sendGet(token_url, null);
			 * Map valueMap = JSON.parseObject(value); token =
			 * (String)valueMap.get("access_token");
			 * CacheManage.putCache("token_KEY", token, timeOut); }else{ token =
			 * (String)CacheManage.getCacheDataByKey(token_KEY); }
			 */
			String value = swtech.facade.pageDesign.util.HttpUtils.sendGet(token_url, null);
			Map valueMap = JSON.parseObject(value);
			token = (String) valueMap.get("access_token");

			// 获取标签列表
			log.info("token==========" + token);
			String tag_url = "https://api.weixin.qq.com/cgi-bin/tags/get?access_token=" + token;
			String tagInfo = swtech.facade.pageDesign.util.HttpUtils.sendGet(tag_url, null);
			log.info("tagInfo==========" + tagInfo);
			JSONObject tagdata = JSON.parseObject(tagInfo);

			JSONArray tags = tagdata.getJSONArray("tags");
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setMsg(tags);
			msg.setStatusMsg("获取通知标签成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("获取通知标签失败");
			e.printStackTrace();
		}
		return msg;
	}

	// 级联分类查询
	@GET
	@Path("/getCascadeClassifyRecord")
	public ReturnMsg getCascadeClassify(@QueryParam("rootId") Integer rootId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			// 根据id获取当前根节点id
			CascadeClassify cascadeCassify = pageDesignDao.getCascadeClassifyByRootId(rootId);

			List list = getCascadeClassify(new ArrayList(), rootId);

			if (list != null && list.size() > 0) {

				cascadeCassify.setChildren(list);
			}

			msg.setMsg(cascadeCassify);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("获取成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("获取失败");
		}

		return msg;
	}

	// 递归分组
	public List getCascadeClassify(List listParent, int rootId) {

		// 根据父id查询子分组
		List<Map> list = pageDesignDao.getCascadeClassifyByParentId(rootId);
		System.out.print("=====================list2=" + list);
		if (list != null && list.size() > 0) {
			for (Map map : list) {
				CascadeClassify classify = new CascadeClassify();
				classify.setId((int) map.get("id"));
				classify.setName((String) map.get("name"));
				classify.setParentId((int) map.get("parentId"));
				getCascadeClassify(classify.getChildren(), classify.getId());
				listParent.add(classify);
			}
		}
		log.info("==============lispParent==" + listParent);
		return listParent;
	}

	// 根据父id查询子分类
	@GET
	@Path("/getclassifyByParentId")
	public ReturnMsg getclassifyByParentId(@QueryParam("pid") Integer pid) {
		ReturnMsg msg = new ReturnMsg();
		try {
			List<Map> list = pageDesignDao.getCascadeClassifyByParentId(pid);
			msg.setMsg(list);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败");
		}

		return msg;
	}

	@GET
	@Path("/getAllCascadeClassify")
	public ReturnMsg getAllCascadeClassify(@QueryParam("uId") Integer uId) {
		ReturnMsg<List<?>> msg = new ReturnMsg();
		try {
			// 通过uId获取所拥有的组织分类
			List<CascadeClassify> classifyList = pageDesignDao.getRoleClassifyIdByUid(uId);

			for (CascadeClassify cascadeClassify : classifyList) {
				cascadeClassify.setChildren((getCascadeClassify(new ArrayList(), cascadeClassify.getId())));
			}

			// List classifys = returnTrimClassify(classifyList);

			msg.setMsg(classifyList);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败");
		}

		return msg;
	}

	// 张宇8.8
	/*
	 * public static List returnTrimClassify(List<CascadeClassify> list){ for
	 * (CascadeClassify classify : list) { for(CascadeClassify classifyNew :
	 * list){ if(classify.getId() == classifyNew.getParentId()){
	 * classify.getChildren().add(classifyNew); list.remove(classifyNew);
	 * log.info("==========2-====list=="+list.size()); returnTrimClassify(list);
	 * break; } } } return list; }
	 */

	@GET
	@Path("/getTableInformationByName")
	// 根据中文名字转换拼音，拼音缩写即表名，查出该表字段名及备注
	public ReturnMsg getTableInformationByName(@QueryParam("tableName") String tableName) {
		ReturnMsg<List<Map>> msg = new ReturnMsg<List<Map>>();
		String name = Pinyin4jUtil.toPinyin(tableName);
		tableName = name.substring(0, 1).toUpperCase() + name.substring(1);
		try {
			List<Map> map = pageDesignDao.getTableInformationByName(tableName);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setMsg(map);
			msg.setStatusMsg("查询成功！");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败！");
		}

		return msg;
	}

	/**
	 * 废弃了
	 * 搜索控件 (根据不定数据源及不定搜索条件搜索)
	 */
	@POST
	@Path("/selectDynamicSearch")
	public ReturnMsg selectDynamicSearch(JSONObject record) {
		QueryVo vo = (QueryVo) JSON.parseObject(record.toJSONString(), QueryVo.class);
		ReturnMsg msg = new ReturnMsg();
		PageHelper.startPage(vo.getCurrentPage(), 3);
		// 中文转为拼音
		String table_name = Pinyin4jUtil.toPinyin(vo.getTable_name());

		table_name = table_name.toLowerCase();
		table_name = captureName(table_name);
		// 驼峰命名法转数据库字段
        vo.setTable_name(captureName(table_name));
		List<String> tableField = pageDesignDao.getTableFieldionByName(vo.getTable_name());
		vo.setTable_field_all(String.join(",", tableField));
		try {

			// 只查询，分页准备用PageHelper
			List<Map> map = pageDesignDao.selectDynamicSearch(vo);

			String jsonString = JSON.toJSONString(map);
			PageInfo<Map> page = new PageInfo<>(map);
			Map<String, Object> maps = new HashMap<String, Object>();
			maps.put("SearchContent", vo.getSearchContent());
			maps.put("SortingConditions", vo.getSortingConditions());
			maps.put("currentPage", page.getPageNum());
			maps.put("total", page.getTotal());
			maps.put("searchId", vo.getSearchId());
			msg.setStatus(Answer.SUCCESS_MSG);
			Map result = new HashMap();
			result.put("map", map);
			result.put("maps", maps);
			msg.setMsg(result);
			msg.setStatusMsg("查询成功！");

		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败!");
		}
		return msg;
	}

	/**
	 * 将传来的节点名转为拼音，数据库表名即拼音缩写 首字母大写
	 */
	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
	}

	/**
	 * 驼峰命名转为下划线命名,实现将排序条件对象转为表字段名
	 */
	public String HumpToUnderline(String para) {
		StringBuilder sb = new StringBuilder(para);
		int temp = 0;// 定位
		for (int i = 0; i < para.length(); i++) {
			if (Character.isUpperCase(para.charAt(i))) {
				sb.insert(i + temp, "_");
				temp += 1;
			}
		}
		return sb.toString().toUpperCase();
	}

	// 根据组织id获取组织下所有用户及openid
	public List getAllUidByRoleId(Integer roleId) {

		// 获取大于当前的组织id和父id
		List<Map> maps = pageDesignDao.getRoleByThanRoleId(roleId);
		int id;
		List<Integer> resultList = new ArrayList<Integer>();
		resultList.add(roleId);
		for (Map map : maps) {
			if ((int) map.get("pid") == roleId) {
				id = (int) map.get("id");
				resultList.add(id);

				// 获取
				getChildrenRoleByParentRole(id, maps, resultList, new ArrayList<Map>());
			}
		}

		List<Integer> map = new ArrayList<Integer>();
		if (resultList.size() > 0) {
			// TODO 获取组织和权限下的人
			map = pageDesignDao.getUserWeiXinOpenidByRoleIdList(resultList);
		}
		log.info("map=========" + map);
		return map;
	}

	// 递归获取子组织
	public static List getChildrenRoleByParentRole(Integer roleId, List<Map> maps, List resultList,
			List<Map> tempList) {
		for (Map map : maps) {
			if ((int) map.get("pid") == roleId) {
				System.out.print("==(int) map.get(id)==" + (int) map.get("id"));
				resultList.add((int) map.get("id"));
				getChildrenRoleByParentRole((int) map.get("id"), maps, resultList, new ArrayList());
			}
		}
		return tempList;
	}

	@GET
	@Path("/getAdminWebshell")
	public ReturnMsg getAdminWebshell(@QueryParam("uId") Integer uId) {

		ReturnMsg msg = new ReturnMsg();
		try {
			Map selectWebshell = pageDesignDao.selectWebshell(uId);
			if (selectWebshell.size() > 0) {
				msg.setMsg(selectWebshell);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("编辑器管理员权限");
			} else {
				msg.setMsg(selectWebshell);
				msg.setStatus(Answer.DATA_ISNULL);
				msg.setStatusMsg("查无此人");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	// 临时用的注册编辑器权限方法
	@POST
	@Path("/registerWebShell")
	public ReturnMsg registerWebShell(JSONObject json) {
		WebShell webShell = (WebShell) JSON.parseObject(json.toJSONString(), WebShell.class);
		ReturnMsg msg = new ReturnMsg();
		String username = webShell.getUsername();
		String chinesename = webShell.getChinesename();
		String password = DigestUtils.md5Hex(webShell.getPassword());
		try {
			int count = pageDesignDao.registerWebShell(username, password, chinesename);
			if (count > 0) {
				msg.setMsg(username);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg(username + "注册成功");
			} else {
				msg.setMsg(username);
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg(username + "注册失败");
			}
		} catch (Exception e) {
			msg.setMsg(username);
			msg.setStatus(Answer.DATAERR_MSG);
			msg.setStatusMsg("注册" + username + "时数据库操作失败");
		}

		return msg;
	}

	// 临时用的登录编辑器权限方法
	@POST
	@Path("/logWebShell")
	public ReturnMsg logWebShell(JSONObject json) {
		WebShell webShell = (WebShell) JSON.parseObject(json.toJSONString(), WebShell.class);
		ReturnMsg msg = new ReturnMsg();
		String username = webShell.getUsername();
		String password = DigestUtils.md5Hex(webShell.getPassword());
		try {
			webShell = pageDesignDao.logWebShell(username, password);
			String chinesename = webShell.getChinesename();
			String name = webShell.getUsername();
			Map map = new HashMap();
			map.put("chinesename", chinesename);
			map.put("name", name);
			if (webShell != null) {
				msg.setMsg(map);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg(webShell.getUsername() + "登录成功");
			} else {
				msg.setMsg(webShell.getUsername());
				msg.setStatus(Answer.DATAERR_MSG);
				msg.setStatusMsg(webShell.getUsername() + "登录失败");
			}
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("登录失败");
		}
		return msg;
	}

	@GET
	@Path("/getAdminWebShell")
	public ReturnMsg getAdminWebShell() {
		ReturnMsg msg = new ReturnMsg();
		try {
			List<Map> webShell = pageDesignDao.getWebShell();
			msg.setMsg(webShell);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	@GET
	@Path("/updateAdminWebShell")
	public ReturnMsg updateAdminWebShell(@QueryParam("id") Integer id, @QueryParam("isdelete") Integer isdelete) {
		ReturnMsg msg = new ReturnMsg();
		try {
			pageDesignDao.updateWebShell(id, isdelete);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("修改成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("修改失败");
		}
		return msg;
	}
	@GET
	@Path("/getPageControl")
    //获取页面表单控件
	public ReturnMsg getPageControl(@QueryParam("node_id") long node_id){
		ReturnMsg msg=new ReturnMsg();
		try {
			PageEditor pageControl = pageDesignDao.getPageControl(node_id);
			Map map=new HashMap();
			map.put("title", pageControl.getTitle());
			map.put("selected", pageControl.getSelected());
			msg.setMsg(map);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			msg.setMsg(e.toString());
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败");
		}
		return msg;
		
	}

	
	
	//根据nodeId查询对应的表，再从表中根据selectId查
	/*@POST
	@Path("/selectTableByNodeIdAndId")
	public ReturnMsg selectTableByNodeIdAndId(JSONObject record) {
		ReturnMsg msg=new ReturnMsg();
		Map<Object,String> map=new HashMap<Object,String>();
		long node_id=record.getInteger("nodeId");
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(node_id);
		map.put("node_name",captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString())));
		String selectId=record.getString("selectId");
		map.put("selectId", selectId);
		List<Map> listMap=pageDesignDao.selectTableByNodeIdAndId(map);
		if(listMap.size()>0) {
			msg.setMsg(listMap);
			msg.setStatus("200");
			msg.setStatusMsg("查询成功");
		}else {
			msg.setMsg(listMap);
			msg.setStatus("0");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}*/
	/**
	 * 根据节点id查询出对应的表，再根据id查出表中的记录
	 * 根据nodeId查询对应的表，再从表中根据selectId查
	 * @author 王小东
	 * @date 2019年1月15日上午10:35
	 */
	@GET
	@Path("/selectTableByNodeIdAndId")
	public ReturnMsg selectTableByNodeIdAndId(@QueryParam("nodeId")Integer nodeId,@QueryParam("selectId")String selectId) {
		ReturnMsg msg=new ReturnMsg();
		Map<String, Object> map = new HashMap<String, Object>();
		String sw=BeforeTheSuffix.Prefix;
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(nodeId);
		String node_name=captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString()));
		map.put("node_name", node_name);
		map.put("selectId", selectId);
		List<Map> listMap=pageDesignDao.selectTableByNodeIdAndId(map);
		
		//根据nodeid查询出对应表的字段
		PageEditor page = pageDesignOperatorBiz.selectPage(nodeId);
		//分割并取出字段
		String[] selectds=page.getSelected().split(",");
		String str="";
		for (int i = 0; i < selectds.length; i++) {
			str=selectds[i].split(":")[0];
			selectds[i]=sw+str.substring(str.indexOf('"')+1, str.length()-1);
		}
		
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		JSONArray jsonArray = new JSONArray();
		if (page != null) {
			jsonArray = JSONArray.parseArray(page.getTitle());
			resultMap.put("title", jsonArray);
			resultMap.put("selecteds", selectds);
			resultMap.put("data", listMap);
		}
		
		if(listMap.size()>0) {
			msg.setMsg(resultMap);
			msg.setStatus("200");
			msg.setStatusMsg("查询成功");
		}else {
			msg.setMsg(listMap);
			msg.setStatus("0");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}
	
	/**
	 * 根据nodeId查询对应的表，再从表中根据selectId删除
	 * @author 王小东
	 * @date 2019年1月15日下午15:12
	 */
	@GET
	@Path("/deleteTableByNodeIdAndId")
	public ReturnMsg deleteTableByNodeIdAndId(@QueryParam("nodeId")Integer nodeId,@QueryParam("id")String selectId) {
		ReturnMsg msg=new ReturnMsg();
		Map<String, Object> map = new HashMap<String, Object>();
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(nodeId);
		String node_name=captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString()));
		map.put("node_name", node_name);
		map.put("selectId", selectId);
		//List<Map> listMap=pageDesignDao.selectTableByNodeIdAndId(map);
		int row=pageDesignDao.deleteTableByNodeIdAndId(map);
		if(row>0) {
			msg.setStatus("200");
			msg.setStatusMsg("删除成功");
		}else {
			msg.setStatus("0");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}
	

}
