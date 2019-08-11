package swtech.service.pageDesign.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.service.pageDesign.dao.PageDesignDao;
import swtech.service.pageDesign.dao.TreeNodeDao;
import swtech.service.pageDesign.dao.impl.TreeNodeDaoImpl;

@Component("treeNodeQueryBiz")
public class TreeNodeQueryBiz {
	private static final Log log = LogFactory.getLog(TreeNodeQueryBiz.class);
	@Autowired
	private TreeNodeDao treeNodeDao;
	
	@Autowired
	private PageDesignDao pageDesignDao;

	public ReturnMsg getNodeChildren(Long pid) {
		return treeNodeDao.getNodeChildren(pid); 
	}	
	public ReturnMsg getChildCountById(Long id) {
		log.info("查找子节点总数的ID是："+id);
		return treeNodeDao.getChildCountById(id); 
	}
	public ReturnMsg getUpSoreById(Long pid,int node_sore) {
		return treeNodeDao.getUpSoreById(pid,node_sore); 
	}
	public ReturnMsg getDownSoreById(Long pid,int node_sore) {
		return treeNodeDao.getDownSoreById(pid,node_sore); 
	}
	public TreeNode getNodeById(long id){
		return treeNodeDao.getById(id); 
	}

	public ReturnMsg getTreeNode() {
		return treeNodeDao.getTreeNode();
	}

	public ReturnMsg getLikeName(Long pid, String name) {
		name = "%" +name+"%";
		return treeNodeDao.getLikeName(pid,name);
	}

	public ReturnMsg getPageEditor() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			List<TreeNode> list = treeNodeDao.getAllNode();
			List<TreeNode> pages = new ArrayList<TreeNode>();
			PageEditor page = new PageEditor();
			for (TreeNode tree : list) {
				page = pageDesignDao.getByNodeId(tree.getId());
				if(page != null){
					pages.add(tree);
				}
			}
			msg.setMsg(pages);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("0");
			msg.setStatusMsg("查询失败");
		}
		
		return msg;
	}
}
