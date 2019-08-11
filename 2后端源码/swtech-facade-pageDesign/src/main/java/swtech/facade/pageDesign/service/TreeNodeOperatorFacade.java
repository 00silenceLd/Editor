package swtech.facade.pageDesign.service;

import swtech.common.entity.ReturnMsg; 
import swtech.facade.pageDesign.entity.TreeNode;

public interface TreeNodeOperatorFacade { 
	public ReturnMsg addMenu(TreeNode node); 
	public ReturnMsg delMenu(TreeNode node);
	public ReturnMsg updateMenu(TreeNode node); 
	public ReturnMsg upMenu(TreeNode node);
	public ReturnMsg downMenu(TreeNode node);
}
