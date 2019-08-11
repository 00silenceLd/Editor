package swtech.service.pageDesign.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.service.pageDesign.dao.HerdNodeDao;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午5:16:15 
 *
 * 树节点操作业务逻辑层
 *
 */

@Component("herdNodeOperatorBiz")
@Transactional(noRollbackFor = Exception.class)
public class HerdNodeOperatorBiz {

	@Autowired
	private HerdNodeDao dao;
	
	@Autowired
	private PageDesignDao pageDesignDao; 
	
	/**
	 * @param node
	 * @return
	 */
	public ReturnMsg addTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			HerdNode node = JSONObject.parseObject(entity,HerdNode.class);
			
			//查询子节点总数
			int count = dao.getChildCountById(node.getParent_id());
			node.setNode_sore(count);
			
			int i = dao.insertTreeNode(node);
			if(i>0){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("添加成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("添加失败");
		}
		return msg;
	}

	/**
	 * @param page
	 * @return
	 */
	public ReturnMsg addPageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			PageEditor page = JSONObject.parseObject(entity,PageEditor.class);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("node_id", page.getNode_id());
			param.put("is_delete", page.isIs_delete());
			int count = pageDesignDao.getCountForNodeId(param);
			if (count > 0) {
				pageDesignDao.updateIsDelete(param);
			}
			int i = pageDesignDao.addPageEditor(page);
			
			if(i>0){
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("添加失败");
		}
		return msg;
	}

	/**
	 * @param node
	 * @return
	 */
	public ReturnMsg updateTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			HerdNode node = JSONObject.parseObject(entity,HerdNode.class);
			int i = (int)dao.updateTreeNode(node);
			if(i>0){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("更新成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("更新失败");
		}
		return msg;
	}

	/**
	 * @param entity
	 * @return
	 */
	public ReturnMsg updatePageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			PageEditor page = JSONObject.parseObject(entity,PageEditor.class);
			int i = pageDesignDao.updatePageEditor(page);
			if(i>0){
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("更新成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("更新失败");
		}
		return msg;
	}

	/**
	 * @param id
	 * @return
	 */
	public ReturnMsg deleteTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			//树形删除
			HerdNode node = JSONObject.parseObject(entity,HerdNode.class);
			node.setIs_delete(true);
			int i = (int)dao.updateTreeNode(node);
			//表单删除
			PageEditor page = pageDesignDao.getByNodeId(node.getId());
			page.setIs_delete(true);
			int j = pageDesignDao.updatePageEditor(page);
			if(i > 0 && j > 0){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}

	/**
	 * @param id
	 * @return
	 */
	public ReturnMsg deletePageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			PageEditor page = JSONObject.parseObject(entity,PageEditor.class);
			page.setIs_delete(true);
			int i = pageDesignDao.updatePageEditor(page);
			if(i>0){
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}

	/**
	 * @param entity
	 * @return
	 */
	public ReturnMsg upTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			JSONObject json = JSONObject.parseObject(entity);
			int id = json.getInteger("id");
			int nodeSore = json.getInteger("node_sore");
			int newNodeSore = json.getInteger("node_sore1");
			int pid = json.getInteger("parent_id");
			
			//查询现在Node对象
			HerdNode node = dao.selectNodeSore(pid,nodeSore);
			
			//查询与Node对象交替前的Node对象
			HerdNode node1 = dao.selectNodeSore(pid,newNodeSore);
			
			node.setNode_sore(newNodeSore);
			node1.setNode_sore(nodeSore);
			
			//更新Node位置
			int i = dao.updateTreeNode(node);
			int j = dao.updateTreeNode(node1);
			if(i>0 && j>0){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("移动成功");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("0");
			msg.setStatusMsg("移动失败");
		}
		return msg;
	}

	public ReturnMsg setSite(int node_id,int site_id,boolean is_pc) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			dao.setSite(node_id,site_id,is_pc);
			/*
			HerdNode node = JSONObject.parseObject(entity,HerdNode.class);
			int node_id=node.getId();
			//回溯获取所有上级节点,获取倒数第二个节点(即为站点节点)
			List<HerdNode> parents = dao.getParents(node_id);
			int count=parents.size();
			int siteId=parents.get(count-2).getId();
			//获取站点id下所有节点，并将所有的is_first设置为false
			List<HerdNode> childrenNodes = dao.getChildren(siteId);
			for(int i=0;i<childrenNodes.size();i++){
				dao.setFirst(childrenNodes.get(i).getId(),  false);
			}
			dao.setFirst(node_id,true);
			if(i>0){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("设置首页成功");
			}	
			*/		
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg change_Nodetype(Integer node_id, Integer node_type) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			msg=dao.change_Nodetype(node_id,node_type);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg(e.toString());
		}
		return msg;
	}

}
 