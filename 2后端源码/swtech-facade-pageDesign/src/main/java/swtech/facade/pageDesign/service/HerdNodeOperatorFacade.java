
package swtech.facade.pageDesign.service;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午5:01:57 
 *
 * 树节点操作接口
 *
 */

public interface HerdNodeOperatorFacade {
	//增加文件夹
	public ReturnMsg setFirstPage(String entity);
	//增加文件夹
	public ReturnMsg addTreeNode(String entity);

	//增加文件
	public ReturnMsg addPageEditor(String entity);
	
	//修改文件夹
	public ReturnMsg updateTreeNode(String entity);
	
	//修改文件
	public ReturnMsg updatePageEditor(String entity);
	
	//删除文件夹
	public ReturnMsg deleteTreeNode(String entity);
	
	//删除文件
	public ReturnMsg deletePageEditor(String entity);
	
	//上拉操作
	public ReturnMsg upTreeNode(String entity);
	public ReturnMsg ChangeNode_Type(String data);
}
 