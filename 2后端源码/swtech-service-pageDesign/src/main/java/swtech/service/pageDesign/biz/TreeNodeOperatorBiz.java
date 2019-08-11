package swtech.service.pageDesign.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.service.pageDesign.dao.TreeNodeDao;

@Component("treeNodeOperatorBiz")
@Transactional(rollbackFor = Exception.class)
public class TreeNodeOperatorBiz {
	
	@Autowired
	private TreeNodeDao treeNodeDao;
	public long addMenu(TreeNode node){  
		return treeNodeDao.insert(node);
	}
	public ReturnMsg delMenu(Long id){
		return treeNodeDao.change_is_delete(id);
	}
	public long updateMenu(TreeNode node){
		return treeNodeDao.update(node);
	}
//	public long getUpdateMenu(TreeNode node){
//		return treeNodeDao.update(node);
//	}
//	public void getUpMenu(String data){
//		
//	}
//	public void getDownMenu(String data){
//		
//	}
}
