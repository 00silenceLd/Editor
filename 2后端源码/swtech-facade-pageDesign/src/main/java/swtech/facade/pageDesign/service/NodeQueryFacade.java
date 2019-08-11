package swtech.facade.pageDesign.service;



import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:25:01 
 *
 * 树节点查询
 *
 */

public interface NodeQueryFacade {

	//获取所有节点
	public ReturnMsg getTreeNode();
	
	//根據userId获取他所有节点
	public ReturnMsg getTreeNodeByUid(Integer uId);
	
	//根据ID查询节点名
	public ReturnMsg getByNodeName(Integer nodeId);
	
	//根据pid查询
	public ReturnMsg getOneNode(Integer pid);
	
	//迁移数据
	public ReturnMsg moveNode();
	
	//显示所有可关联操作
	public ReturnMsg getDataSourcePage(Integer nodeId,Integer uid);
	
	//平台对外可选取资源
	public ReturnMsg getOuterPage(Integer uid);
	
	//本子站资源与总站对外资源比对
	public ReturnMsg compareUpWebsite();
	
	//获取用户对应的组织-职位的拥有节点权限，return nodeId
	public ReturnMsg selectUserNodeIdByRoleAndPosition(JSONObject json);
	
	//根據userId获取他所有节点
	public ReturnMsg getDataSourceByUid(Integer uId);
	
	//获取所有未审核的页面
	public ReturnMsg getNotApprovePage();
	
	//点击同意审核
	public ReturnMsg agreeSavePage(Integer node_id);
	
	//点击不同意审核
	public ReturnMsg notAgreeSavePage(Integer node_id);
	
	public ReturnMsg getThisSlavePage(Integer nodeId);
	
}
 