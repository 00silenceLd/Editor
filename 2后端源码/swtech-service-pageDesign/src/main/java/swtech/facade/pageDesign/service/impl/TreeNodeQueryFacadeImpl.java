package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.facade.pageDesign.service.TreeNodeQueryFacade;
import swtech.service.pageDesign.biz.TreeNodeQueryBiz;
import swtech.service.pageDesign.dao.TreeNodeDao;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

@Path("treeNodeQueryFacade")
@Component("treeNodeQueryFacade")
@Consumes(MediaType.APPLICATION_XML)
public class TreeNodeQueryFacadeImpl implements TreeNodeQueryFacade{
	
	@Autowired
	private TreeNodeQueryBiz treeNodeQueryBiz; 
	
	
	@Path("/getPageTree")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getPageTree(@QueryParam("pid") Long pid) { 		
	    return treeNodeQueryBiz.getNodeChildren(pid); 
	}
	
	@GET
	@Path("/getLikeName")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getLikeName(@QueryParam("pid") Long pid,@QueryParam("name")String name) { 		
	    return treeNodeQueryBiz.getLikeName(pid,name); 
	}


	@GET
	@Path("/getPageEditor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getPageEditor() {
		ReturnMsg msg = null;
		try {
			
			msg = treeNodeQueryBiz.getPageEditor();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg;
	}
}
