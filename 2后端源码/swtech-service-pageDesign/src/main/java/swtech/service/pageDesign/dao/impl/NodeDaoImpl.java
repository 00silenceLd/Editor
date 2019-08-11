package swtech.service.pageDesign.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mortbay.util.ajax.JSON;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONObject;
import com.ibm.icu.text.SimpleDateFormat;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ApprovePage;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.UserHasNode;
import swtech.service.pageDesign.dao.NodeDao;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:40:23 
 *
 * 树节点dao层实现类
 *
 */

@Repository("nodeDao")
public class NodeDaoImpl extends BaseDaoImpl<Node> implements NodeDao{

	//查询全部数据
	public List<Node> getTreeNode() {
		String constr= JSON.toString(getSessionTemplate().getConnection());		 
		System.out.print("数据源的连接参数"+constr); 
		return getSessionTemplate().selectList("FindByNode");
	}

	//查询全部数据
	public List<Node> getTreeNodeByUid(Integer uId) {
		String constr= JSON.toString(getSessionTemplate().getConnection());		 
		System.out.print("数据源的连接参数"+constr); 
		return getSessionTemplate().selectList("FindNodeByUid",uId);
	}

	//插入树节点
	public int insertTreeNode(Node node) {
		System.out.print("sql连接是:"+getSessionTemplate().getConnection().toString());
		getSessionTemplate().insert("insertTreeNode",node);
		return node.getId();
	}

	//更新树节点
	public int updateTreeNode(Node node) {

		return getSessionTemplate().update("updateTreeNode", node);
	}

	//删除树节点
	public int deleteTreeNode(int id) {

		return getSessionTemplate().delete("deleteTreeNode", id);
	}

	//计算子节点总和
	public int getChildCountById(int parent_id) {

		return getSessionTemplate().selectOne("getCountByPId",parent_id);
	}

	//查询与Node对象交替前的Node对象
	public Node selectNodeSore(int pid, int newNodeSore) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("newNodeSore", newNodeSore);
		return getSessionTemplate().selectOne("selectNodeSore", map);
	}


	//根据ID查询对象名称
	public Node getByNodeName(Integer nodeId) {

		return getSessionTemplate().selectOne("getByNodeName",nodeId);
	}

	//根据PID下查询所有对象
	public List<Node> getOneNode(Integer pid) {

		return getSessionTemplate().selectList("getOneNode",pid);
	}


	public Node getByIds(Integer pid) {

		return getSessionTemplate().selectOne("getByIds",pid);
	}

	//插入网站管理
	public int insertNode(Node node) {

		return getSessionTemplate().insert("insertNode",node);
	}

	//查询所有可关联表
	public List<Node> getDataSourcePage() {

		return getSessionTemplate().selectList("getDataSourcePage");
	}

	//获取同名表单树
	public Node getNode(String nodeName) {

		return getSessionTemplate().selectOne("getNode",nodeName);
	}

	//获取自定义资源库字段
	public List<Node> searchType(int type) {

		return getSessionTemplate().selectList("searchType",type);
	}
	@Override
	public List<Node> getUpSiteChildrenById(Integer pid) {
		return getSessionTemplate().selectList("getUpSiteChildrenById",pid);
	}

	@Override
	public Node getUpWebsiteNodeById(Integer id) {
		return getSessionTemplate().selectOne("getUpWebsiteNodeById",id);
	}

	@Override
	public ReturnMsg copyTo(Node node) {
		ReturnMsg msg=new ReturnMsg();
		System.out.print("sql连接是:"+getSessionTemplate().getConnection().toString());
		Object obj= getSessionTemplate().insert("insertTreeNode",node);
		msg.setMsg(obj);
		return msg;
	}

	@Override
	public List<Node> getUpWebsiteTreeNode() {
		return getSessionTemplate().selectList("FindUpWebsiteByNode");
	}

	@Override
	public String getNameByNodeId(long nodeId) {
		return getSessionTemplate().selectOne("getNameByNodeId",nodeId);
	}

	@Override
	public List<UserHasNode> getSiteHasNodes(int uid) {
		return getSessionTemplate().selectList("getSiteHasNodes",uid);	
	}

	@Override
	public void addNodeToSite(UserHasNode node) {
		getSessionTemplate().selectList("addNodeToSite",node);
	}

	@Override
	public void updateNodeForSite(UserHasNode node){
		getSessionTemplate().selectList("updateNodeForSite",node);	
	}

	@Override
	public List<Integer> getSiteHasNodesReturnNodeId(int uid) {

		return getSessionTemplate().selectList("getSiteHasNodesReturnNodeId",uid);
	}

	@Override
	public ReturnMsg addUserIndexPage(Map map) {
		ReturnMsg msg=new ReturnMsg();
		Object obj= getSessionTemplate().insert("addUserIndexPage",map);
		msg.setMsg(obj);
		return msg;
	}

	@Override
	public Integer selectIndexPageByRoleAndPid(int roleId, int pid) {
		Map map = new HashMap();
		map.put("roleId", roleId);
		map.put("pId", pid);
		return getSessionTemplate().selectOne("selectIndexPageByRoleAndPid",map);
	}

	@Override
	public void delUserIndexPage(Integer id) {
		getSessionTemplate().delete("delUserIndexPage", id);

	}

	@Override
	public void delUserRoleByOrgWithPosition(Map map) {
		getSessionTemplate().delete("delExceptNode", map);
	}

	@Override
	public void insertUserRoleByOrgWithPosition(JSONObject record) {
		getSessionTemplate().insert("insertExceptNode", record);

	}

	@Override
	public List<Map> getUserRoleByOrgWithPosition(JSONObject record) {

		return getSessionTemplate().selectList("getExceptNode", record);	
	}

	@Override
	public List<Integer> selectUserNodeIdByPidAndRoleId(JSONObject record) {

		return getSessionTemplate().selectList("getUserNodeIdByPidAndRoleId", record);
	}

	@Override
	public void delNodeToSiteByUid(Integer uId) {
		getSessionTemplate().delete("delNodeToSiteByUid", uId);
	}

	@Override
	public void insetNodeToSitebyListNode(UserHasNode addNode, List<Integer> nodeIdList) {
		Map map = new HashMap();
		map.put("nodeIdList",nodeIdList);
		map.put("addNode",addNode);
		getSessionTemplate().insert("insetNodeToSitebyListNode",map);
	}
	//查询全部数据源
	public List<Node> getDataSourceByUid(Integer uId) {
		String constr= JSON.toString(getSessionTemplate().getConnection());		 
		System.out.print("数据源的连接参数"+constr); 
		return getSessionTemplate().selectList("getDataSourceByUid",uId);
	}

	@Override
	public Integer getIdByNodeName(String classname) {
		Map<String, String> param = new HashMap<String,String>();
		param.put("classname", classname);
		return getSqlSession().selectOne("getIdByNodeName", param);
	}

	@Override
	public int getApprove(Long id) {
		int node_id = id.intValue();
		int isApprove = getSqlSession().selectOne("getApproveById", node_id);
		if(isApprove!=0) {
			isApprove=1;
		}

		return isApprove;
	}

	@Override
	public ReturnMsg getNotApprovePage() {
		ReturnMsg msg=new ReturnMsg();
		List<ApprovePage> approvePageList = 
				getSessionTemplate().selectList("getNotApprovePage");
		for(ApprovePage a:approvePageList) {
			//			log.info("=========从ht_node表中查出来的ApprovePage============"+a);
		}
		if(approvePageList.size()==0||approvePageList==null) {
			msg.setStatus("201");
			msg.setStatusMsg("数据库查不到值");
		}
		List<ApprovePage> approvePageList2 = new ArrayList<ApprovePage>();
		for(ApprovePage a:approvePageList) {
			//对a中的时间进行转换
			Date createTime = a.getCreate_time();
			if(createTime==null) {
				createTime=new Date();
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String createTimeStr = simpleDateFormat.format(createTime);
			a.setCreateTimeStr(createTimeStr);


			//根据uid查询ht_user表的chinese_name和username，并封装保存
			Integer uid = a.getCreaterUid();
			Map<String, String> resultMap = new HashMap<String,String>();
			resultMap = getSessionTemplate().selectOne("getUserByUid",uid);
			log.info("=========查出来的resultMap============"+resultMap);
			String chinese_name;
			String username;
			if(resultMap!=null) {
				chinese_name = resultMap.get("chinese_name");
				username = resultMap.get("username");
			}else {
				chinese_name = "胜网坤智无名氏";
				username = "胜网坤智无名氏";
			}

			log.info("=========查出来的chinese_name============"+chinese_name);
			log.info("=========查出来的username============"+username);
			if(chinese_name==null) {
				a.setCreater(username);
				approvePageList2.add(a);
			}else {
				a.setCreater(chinese_name);
				approvePageList2.add(a);
			}


		}

		msg.setMsg(approvePageList2);
		msg.setStatus("200");
		msg.setStatusMsg("OOKK");
		return msg;
	}

	//	public static void main(String[] args) {
	//		Date date = new Date();
	//	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//	String dateStr = simpleDateFormat.format(date);
	//		System.out.println(dateStr);
	//	}


	@Override
	public ReturnMsg agreeSavePage(Integer node_id) {
		ReturnMsg msg = new ReturnMsg();
		int row = getSessionTemplate().update("agreeSavePage",node_id);
		if(row==1) {
			msg.setStatus("200");
			msg.setStatusMsg("通过审核");
		}else {
			msg.setStatus("201");
			msg.setStatusMsg("修改审核标识出问题");
		}
		return msg;
	}

	@Override
	public ReturnMsg notAgreeSavePage(Integer id) {
		ReturnMsg msg = new ReturnMsg();
		//当点击不同意，该节点、对应的pageEditor记录、最好还有其所有对应的控件都要删除
		//1.根据node_id删除ht_node记录
		int row = getSessionTemplate().delete("deleteTreeNode", id);
		if(row!=1) {
			msg.setStatus("201");
			msg.setStatusMsg("删除节点失败");
			return msg;
		}
		//2.根据node_id删除pageEditor所有该条件的记录
		int row2 = getSessionTemplate().delete("deletePageEditor", id);
		if(row!=1) {
			msg.setStatus("201");
			msg.setStatusMsg("删除页面失败");
			return msg;
		}
		msg.setStatus("200");
		msg.setStatusMsg("已成功驳回审核");
		return msg;
	}

	@Override
	public Integer getIspublicByNodeId(int node_id) {
		Integer isPublic = getSessionTemplate().selectOne("getIspublicByNodeId", node_id);
		log.info("=========在getIspublicByNodeId=方法中=========="+isPublic);



		if(isPublic==null) {//如果为null就改为继发布页0、浏览页1之后的第三中状态，2
			isPublic = 2;
		}
		return isPublic;
	}

	@Override
	public Integer getPopularizeById(String nodeId) {
		Integer isPopularize = getSessionTemplate().selectOne("getPopularizeById", nodeId);
		return isPopularize;
	}

	@Override
	public Integer saveMasterAndSlaveRel(Node node) {
		return getSessionTemplate().insert("saveMasterAndSlaveRel",node);
	}

	@Override
	public Integer deleteMasterAndSlaveRel(Node node) {
		return getSessionTemplate().delete("deleteMasterAndSlaveRel",node);
	}

	@Override
	public List<Integer> getSlavePageIdByMasterId(Integer nodeId) {
		return getSessionTemplate().selectList("getSlavePageIdByMasterId",nodeId);
	}

	@Override
	public String getSlavePageNameBySlaveId(Integer slaveId) {
		return getSessionTemplate().selectOne("getSlavePageNameBySlaveId",slaveId);
	}

	@Override
	public Integer updateSlavePageName(Node node) {
		return getSessionTemplate().update("updateSlavePageName",node);
	}
}
