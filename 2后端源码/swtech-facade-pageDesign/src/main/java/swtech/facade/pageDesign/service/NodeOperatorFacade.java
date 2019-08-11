
package swtech.facade.pageDesign.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CopyNode;
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

public interface NodeOperatorFacade {

	//增加文件夹
	public ReturnMsg addTreeNode(List<Node> nodeList);

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
	
	//批量更新表单站点数据
	public ReturnMsg updateNodeSite(Integer nodeId);
	
	//打包站点页面
	public ReturnMsg packSite(Integer nodeId);
	
	//复制选择节点到本站节点树
	public ReturnMsg copyTree(CopyNode node);	
	
	//选择权限节点
	public ReturnMsg addTreeNodeToSite(JSONObject record);
	
	//添加默认首页
	public ReturnMsg addUserIndexPage(JSONObject record);
	
	//插入用户关联的职位权限中不包含的节点
	public ReturnMsg insertUserRoleForOrgWithPosition(JSONObject record);
	
}
 