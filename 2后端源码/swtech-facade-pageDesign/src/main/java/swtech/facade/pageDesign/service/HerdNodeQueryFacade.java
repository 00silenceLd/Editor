package swtech.facade.pageDesign.service;

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
public interface HerdNodeQueryFacade {

	//获取所有节点
	public ReturnMsg getTreeNode();
	
	//根据ID查询节点名
	public ReturnMsg getByNodeName(Integer nodeId);
	
	//根据pid查询
	public ReturnMsg getOneNode(Integer pid);
	
	//迁移数据
	public ReturnMsg moveNode();
	
	public ReturnMsg getSiteFirst(String entStr);
}
 