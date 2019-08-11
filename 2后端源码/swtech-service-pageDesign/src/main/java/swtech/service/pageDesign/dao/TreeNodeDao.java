package swtech.service.pageDesign.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.TreeNode;

public interface TreeNodeDao  extends BaseDao<TreeNode> { 
	public ReturnMsg getNodeChildren(Long pid);
	public ReturnMsg change_is_delete(long id);
	public ReturnMsg getChildCountById(long id);
	public ReturnMsg getDownSoreById(Long pid,int node_sore);
	public ReturnMsg getUpSoreById(Long pid,int node_sore);
	public ReturnMsg getTreeNode();
	public ReturnMsg getLikeName(Long pid, String name);
	public List<TreeNode> getAllNode();
}
