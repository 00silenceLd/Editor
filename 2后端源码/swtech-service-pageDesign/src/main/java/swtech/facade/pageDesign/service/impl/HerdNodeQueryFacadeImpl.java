package swtech.facade.pageDesign.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.SiteFirst;
import swtech.facade.pageDesign.service.HerdNodeQueryFacade;
import swtech.facade.pageDesign.service.NodeQueryFacade;
import swtech.service.pageDesign.biz.HerdNodeQueryBiz;
import swtech.service.pageDesign.biz.NodeQueryBiz;

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

@Path("herdNodeQueryFacade")
@Component("herdNodeQueryFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class HerdNodeQueryFacadeImpl implements HerdNodeQueryFacade{

	@Autowired
	private HerdNodeQueryBiz biz;
	
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
	
	@POST
	@Path("/getSiteFirst")
	public ReturnMsg getSiteFirst(String entity){
		ReturnMsg msg = null;
		try {	
			
			
			SiteFirst ent = JSONObject.parseObject(entity,SiteFirst.class);
			Map map=new HashMap();
			msg = biz.getSiteFirst(ent.getSite_id(),ent.isIs_pc());
			
			System.out.println("====================ent.isIs_pc()==========="+ent.isIs_pc());
			System.out.println("====================msg==========="+msg);
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(e.toString());
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


}
 