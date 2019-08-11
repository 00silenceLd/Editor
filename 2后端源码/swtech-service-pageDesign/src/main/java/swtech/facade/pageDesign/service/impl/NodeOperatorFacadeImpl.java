package swtech.facade.pageDesign.service.impl;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.minlog.Log;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CopyNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.UserHasNode;
import swtech.facade.pageDesign.service.NodeOperatorFacade;
import swtech.service.pageDesign.biz.NodeOperatorBiz;
import swtech.service.pageDesign.dao.NodeDao;

/**
 *
 * @author 林致杰
 *
 * @version 1.0
 *
 *          创建时间：2017年12月1日 下午5:11:56
 *
 *          树节点操作接口实现类
 *
 */

@Path("nodeOperatorFacade")
@Component("nodeOperatorFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class NodeOperatorFacadeImpl implements NodeOperatorFacade {
	private static final Logger logger = LoggerFactory.getLogger(NodeOperatorFacadeImpl.class);
	@Autowired
	private NodeOperatorBiz biz;
	
	@Autowired
	private NodeDao dao;

	/**
	 * 添加文件夹
	 * */
	@POST
	@Path("/addTreeNode")
	public ReturnMsg addTreeNode(List<Node> nodeList) {
		ReturnMsg msg = null;
		try {

			msg = biz.addTreeNode(nodeList);

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setMsg(e.getMessage());
			msg.setStatusMsg("添加失败");
		}
		return msg;
	}

	/**
	 * 添加文件
	 * */
	@POST
	@Path("/addPageEditor")
	public ReturnMsg addPageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.addPageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 修改文件夹
	 * */
	@POST
	@Path("/updateTreeNode")
	public ReturnMsg updateTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.updateTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 修改文件
	 * */
	@POST
	@Path("/updatePageEditor")
	public ReturnMsg updatePageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.updatePageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 删除文件夹
	 * */
	@POST
	@Path("/deleteTreeNode")
	public ReturnMsg deleteTreeNode(String entity) {
		ReturnMsg msg = null;
		Map map = new HashMap();
		try {
			msg = biz.deleteTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 删除文件
	 * */
	@POST
	@Path("/deletePageEditor")
	public ReturnMsg deletePageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.deletePageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 移动操作
	 * */
	@POST
	@Path("upTreeNode")
	public ReturnMsg upTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.upTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("updateNodeSite")
	public ReturnMsg updateNodeSite(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = null;
		try {

			msg = biz.updateNodeSite(nodeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("packSite")
	public ReturnMsg packSite(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = null;
		try {

			msg = biz.packSite(nodeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@POST
	@Path("copyTree")
	public ReturnMsg copyTree(CopyNode node) {
		// TODO Auto-generated method stub
		ReturnMsg msg = null;
		try {
			logger.info(node.getExcludeNode());
			msg = biz.copyTree(node.getNode_id(), node.getExcludeNode(),
					node.getUid());
			msg.setStatus("1");
			msg.setStatusMsg("复制节点成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(e.toString());
			msg.setStatus("0");
			msg.setStatusMsg("复制节点失败");
		}
		return msg;
	}

	/**
	 * 选择树节点 张宇 7.11
	 * 
	 * @param node
	 * @return
	 */
	@POST
	@Path("selectTreeNodeToSite")
	public ReturnMsg addTreeNodeToSite(JSONObject record) {
		
		ReturnMsg msg = null;
		try {
			// 获取所有的nodeId
			String nodeIds = (String)record.get("nodeIds");
			JSONObject  nodeJ = record.getJSONObject("UserHasNode");
			UserHasNode node = new UserHasNode();
			if(!nodeJ.get("nodeId").equals("")){
				node.setNodeId((int)nodeJ.get("nodeId"));
			}
			if(!nodeJ.get("roleId").equals("")){
				node.setRoleId((int)nodeJ.get("roleId"));
			}
			if(!nodeJ.get("posId").equals("")){
				node.setPosId((int)nodeJ.get("posId"));
			}
			node.setuId((int)nodeJ.get("uId"));
			//购买者
			node.setCreateUid((int)nodeJ.get("createUid"));
			
			logger.info("node============"+node);
			// 获取user对应的id
			msg = biz.addTreeNodeToSite(node, nodeIds);
			msg.setStatus("1");
			msg.setStatusMsg("选择节点成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("0");
			msg.setStatusMsg("选择节点失败");
		}
		return msg;
	}
	
	/**
	 * 张宇
	 */
	@POST
	@Path("addUserIndexPage")
	public ReturnMsg addUserIndexPage(JSONObject record){
		ReturnMsg msg = null;
		Map map = new HashMap();
		int pid =(int) record.get("pId");
		int roleId =(int) record.get("roleId");
		int nodeId =(int) record.get("nodeId");
//		int nodeType =(int) record.get("nodeType");
		map.put("pId", pid);
		map.put("roleId", roleId);
		map.put("nodeId", nodeId);
//		map.put("nodeType", nodeType);
		//查看是否存在相同的组织职位
		Integer id = dao.selectIndexPageByRoleAndPid(roleId,pid);
		if(id !=null){
			//删除原先的
			dao.delUserIndexPage(id);
		}
		msg = dao.addUserIndexPage(map);
		return msg;
	}
	
	/**
	 * 插入用户关联的职位权限中不包含的节点
	 * 张宇 7.31
	 */
	@POST
	@Path("/insertUserRoleForOrgWithPosition")
	public ReturnMsg insertUserRoleForOrgWithPosition(JSONObject record){
		ReturnMsg msg = new ReturnMsg();
		
		try{
			/*int uId = record.getInteger("uId");
			int roleId = record.getInteger("roleId");
			int pId = record.getInteger("pId");*/
			JSONArray delNodeIds = record.getJSONArray("delNodeIds");
			
			//查看是否有修改过(直接删除)
			//List<Map> excepts  = dao.getUserRoleByOrgWithPosition(record);
			
			dao.delUserRoleByOrgWithPosition(record);
			
			if(delNodeIds !=null &&delNodeIds.size()>0){
				for (Object nodeId : delNodeIds) {
					record.put("nodeId",(int)nodeId);
					dao.insertUserRoleByOrgWithPosition(record);
				}
				
			}
			
			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			
		}catch(Exception e){
			e.printStackTrace();
			msg.setStatus("4");
			msg.setStatusMsg("添加失败");
		}
		
		return msg;
		
	}
	
}