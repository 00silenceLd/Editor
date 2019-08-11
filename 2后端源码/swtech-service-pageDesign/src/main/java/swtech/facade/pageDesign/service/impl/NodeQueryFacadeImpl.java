package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.service.NodeQueryFacade;
import swtech.service.pageDesign.biz.NodeQueryBiz;
import swtech.service.pageDesign.dao.NodeDao;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:28:10 
 *
 * 树节点查询实现类
 *
 */

@Path("nodeQueryFacade")
@Component("nodeQueryFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class NodeQueryFacadeImpl implements NodeQueryFacade{

	@Autowired
	private NodeQueryBiz biz;

	@Autowired
	private NodeDao dao;

	@GET
	@Path("/getTreeNode")
	public ReturnMsg getTreeNode() {
		ReturnMsg msg = null;
		try {			
			msg = biz.getTreeNode();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}

	@GET
	@Path("/getTreeNodeByUid")
	public ReturnMsg getTreeNodeByUid(@QueryParam("uId")Integer uId) {
		ReturnMsg msg = null;
		try {			
			msg = biz.getTreeNode(uId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}


	@GET
	@Path("/getByNodeName")
	public ReturnMsg getByNodeName(@QueryParam("nodeId")Integer nodeId) {
		ReturnMsg msg = null;
		try {


			msg = biz.getByNodeName(nodeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}


	@GET
	@Path("/getOneNode")
	public ReturnMsg getOneNode(@QueryParam("pid")Integer pid) {
		ReturnMsg msg = null;
		try {

			msg = biz.getOneNode(pid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@GET
	@Path("/moveNode")
	public ReturnMsg moveNode() {
		ReturnMsg msg = null;
		try {

			msg = biz.moveNode(16);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}


	@GET
	@Path("/getDataSourcePage")
	public ReturnMsg getDataSourcePage(@QueryParam("nodeId")Integer nodeId,@QueryParam("uid")Integer uid)  {
		ReturnMsg msg = null;
		try {

			msg = biz.getDataSourcePage(nodeId,uid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}


	@POST
	@Path("/getUpWebsiteTreeNode")
	public ReturnMsg getOuterPage(@QueryParam("uid")Integer uid) {
		ReturnMsg msg = null;
		try {			
			msg = biz.getUpWebsiteTreeNode(uid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}


	@Override
	public ReturnMsg compareUpWebsite() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 获取用户对应的组织-职位的拥有节点权限，return nodeId
	 * 张宇
	 * 7.31
	 */
	@POST
	@Path("/selectUserNodeIdByRoleAndPosition")
	public ReturnMsg selectUserNodeIdByRoleAndPosition(JSONObject json) {
		ReturnMsg msg = new ReturnMsg();
		try{
			List<Integer> nodeIds = dao.selectUserNodeIdByPidAndRoleId(json);
			msg.setMsg(nodeIds);
			msg.setStatusMsg("查询成功");
			msg.setStatus("200");
		}catch(Exception e){
			e.printStackTrace();
			msg.setStatusMsg("查询失败");
			msg.setStatus("4");
		}
		return msg;
	}
	@GET
	@Path("/getDataSourceByUid")
	public ReturnMsg getDataSourceByUid(@QueryParam("uId")Integer uId) {
		//		Log.info("到底有没有进来啊===getDataSourceByUid========");
		ReturnMsg msg = null;
		try {			
			msg = biz.getDataSourceByUid(uId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}


	/**
	 *
	 * @author 曾智宏 
	 *
	 * 
	 *
	 * 创建时间：2019年3月25日 
	 *
	 * 审核保存页面相关的接口
	 *
	 */
	//	@Override
	@GET
	@Path("/getNotApprovePage")
	public ReturnMsg getNotApprovePage() {

		//		Log.info("到底有没有进来啊===========");
		ReturnMsg msg = null;
		try {			
			msg = dao.getNotApprovePage();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}

	@GET
	@Path("/agreeSavePage")
	//	@Override
	public ReturnMsg agreeSavePage(@QueryParam("node_id") Integer node_id) {

		ReturnMsg msg = new ReturnMsg();
		try {			
			msg = dao.agreeSavePage(node_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}




	//	@Override
	@GET
	@Path("/notAgreeSavePage")
	public ReturnMsg notAgreeSavePage(@QueryParam("node_id") Integer node_id) {
		ReturnMsg msg = new ReturnMsg();
		try {			
			msg = dao.notAgreeSavePage(node_id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;	
	}

	@GET
	@Path("/getThisSlavePage")
	public ReturnMsg getThisSlavePage(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = null;
		try {			
			msg = biz.getThisSlavePage(nodeId);

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
			
		}
		return msg;	
	}

}
