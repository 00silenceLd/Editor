package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.facade.pageDesign.service.TreeNodeOperatorFacade;    
import swtech.service.pageDesign.biz.TreeNodeOperatorBiz;
import swtech.service.pageDesign.biz.TreeNodeQueryBiz;
import swtech.service.pageDesign.dao.impl.TreeNodeDaoImpl;

@Path("treeNodeOperatorFacade")
@Component("treeNodeOperatorFacade")
@Consumes(MediaType.APPLICATION_XML)
public class TreeNodeOperatorFacadeImpl implements TreeNodeOperatorFacade {
	
	private static final Log log = LogFactory.getLog(TreeNodeDaoImpl.class);
	@Autowired 
	private TreeNodeOperatorBiz treeNodeOperatorBiz;
	@Autowired
	private TreeNodeQueryBiz treeNodeQueryBiz;
	
	@POST
	@Path("/addFormMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg addMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg();
		if(node.node_type==1){
			node.isLeaf=false;
		}else {
			node.isLeaf=true;
		}
		long parent_id=node.parent_id;
		int count=Integer.parseInt(treeNodeQueryBiz.getChildCountById(node.parent_id).getMsg().toString());
		node.node_sore=count;
		int addCount=0;
        addCount= (int)treeNodeOperatorBiz.addMenu(node);
		if(addCount>0){
			msg.setMsg(addCount);
			msg.setStatus("1");
			msg.setStatusMsg("insert 'form' successful");			
		}
		else {
			msg.setMsg(false);
			msg.setStatus("0");
			msg.setStatusMsg("insert 'form' failed");
		}
        return msg;
	}

	@POST
	@Path("/delFormMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg delMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg(); 
		node.setIs_delete(true);
        long count = treeNodeOperatorBiz.updateMenu(node);
		if (count > 0) {
			msg.setMsg(true);
			msg.setStatus("1");
			msg.setStatusMsg("delete 'form' successful");
		} else {
			msg.setMsg(false);
			msg.setStatus("0");
			msg.setStatusMsg("data is non-existent");
		}
		return msg;
	}

	@POST
	@Path("/updateFormMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updateMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg();
		treeNodeOperatorBiz.updateMenu(node);
		return msg;
	}
	/**
	 * 修改父节点
	 * 
	 * @param pid
	 * @param id
	 *            首先需要根据需要修改父节点的 id ，之后在菜单栏目中选择放入父节点里面 拿id 将id的值赋值给选中父节点pid中
	 */
	@POST
	@Path("/getUpdateMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getUpdateMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg();
		
		return msg;
	}
	
	/**
	 * 对菜单栏目进行上拉操作
	 * 
	 * @param form_id
	 *            主键Id
	 * @param sort
	 *            排序序号
	 */

	@POST
	@Path("/getUpMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg upMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg();
		long id=node.getId();
		long pid=node.parent_id;
		node=treeNodeQueryBiz.getNodeById(id);
		if (node.getNode_sore().equals(0)) {
			msg.setMsg("当前已经处于第一位！");
			msg.setStatus("0");
			msg.setStatusMsg("error");
			return msg;
		} else if (!node.isLeaf()) {
			msg.setMsg("必须是页面！");
			msg.setStatus("0");
			msg.setStatusMsg("error");
			return msg;
		} 
		long parent_id=node.parent_id;
		int node_sore=node.node_sore;
		List<TreeNode> list=(List<TreeNode>)treeNodeQueryBiz.getUpSoreById(parent_id, node_sore).getMsg();
		log.info("返回的集合数:"+list.size());
		if(list.size()>0){
			log.info("node0的sore:"+list.get(0));
			log.info("node1的sore:"+list.get(1));
			TreeNode node0=list.get(0);
			TreeNode node1= list.get(1);
			log.info(node1.toString());
			int old_sore=node0.getNode_sore();
			node0.setNode_sore(node1.getNode_sore());
		    node1.setNode_sore(old_sore);
		    treeNodeOperatorBiz.updateMenu(node1);
		    treeNodeOperatorBiz.updateMenu(node0);
		    msg=treeNodeQueryBiz.getNodeChildren(pid); 
			msg.setStatusMsg("上拉成功!");
			msg.setStatus("true");
			return msg;
		}
		
		return msg;
	}
	
	/**
	 * 对菜单栏目进行下拉操作
	 * 
	 * @param form_id主键Id
	 * @param sort
	 *            排序序号
	 */
	@POST
	@Path("/getDownMenu")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8,
			ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg downMenu(TreeNode node) {
		ReturnMsg msg = new ReturnMsg(); 
		long id=node.getId();
		long pid=node.parent_id;
		node=treeNodeQueryBiz.getNodeById(id);
		int count=Integer.parseInt(treeNodeQueryBiz.getChildCountById(node.parent_id).getMsg().toString());
		count=count-1;
		if (node.getNode_sore().equals(count)) {
			msg.setMsg("当前已经处于最后位！");
			msg.setStatus("0");
			msg.setStatusMsg("error");
			return msg;
		} else if (!node.isLeaf) {
			msg.setMsg("必须是页面！");
			msg.setStatus("0");
			msg.setStatusMsg("error");
			return msg;
		} 
		int node_sore=node.node_sore;
		long parent_id=node.getParent_id();
		List<TreeNode> list=(List<TreeNode>)treeNodeQueryBiz.getDownSoreById(parent_id, node_sore).getMsg();
		if(list.size()>0){
			TreeNode node0= list.get(0);
			TreeNode node1= list.get(1);
			int old_sore=node0.getNode_sore();
			node0.setNode_sore(node1.getNode_sore());
		    node1.setNode_sore(old_sore);
		    treeNodeOperatorBiz.updateMenu(node1);
		    treeNodeOperatorBiz.updateMenu(node0);
		    msg=treeNodeQueryBiz.getNodeChildren(pid); 
			msg.setStatusMsg("下拉成功!");
			msg.setStatus("true");
			return msg;
		}
		return msg;
	}
}
