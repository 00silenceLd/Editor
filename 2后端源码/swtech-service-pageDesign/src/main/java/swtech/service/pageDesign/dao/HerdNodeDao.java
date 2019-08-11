package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:38:50 
 *
 * 树节点dao层
 *
 */

public interface HerdNodeDao extends BaseDao<HerdNode>{

	/**
	 * @return
	 * 查询所有数据
	 */
	public List<HerdNode> getTreeNode();

	/**
	 * @param node
	 * @return
	 * 添加树节点
	 */
	public int insertTreeNode(HerdNode node);

	/**
	 * @param node
	 * @return
	 * 更新树节点
	 */
	public int updateTreeNode(HerdNode node);

	/**
	 * @param id
	 * @return
	 * 删除树节点
	 */
	public int deleteTreeNode(int id);

	/**
	 * @param parent_id
	 * @return
	 * 计算子节点总和
	 */
	public int getChildCountById(int parent_id);

	/**
	 * @param pid
	 * @param nodeSore
	 * @return
	 * 查询与Node对象交替前的Node对象
	 */
	public HerdNode selectNodeSore(int pid, int nodeSore);

	/**
	 * @param nodeId
	 * @return
	 * 根据ID查询对象
	 */
	public HerdNode getByNodeName(Integer nodeId);

	/**
	 * @param pid
	 * @return
	 * 根据pid查询下所有对象
	 */
	public List<HerdNode> getOneNode(Integer pid);

	/**
	 * @param pid
	 * @return
	 * 根据PID查询网站管理
	 */
	public HerdNode getByIds(Integer pid);

	
	/**
	 * 插入网站管理
	 * */
	public int insertNode(HerdNode node);

	public List<HerdNode> getParents(int node_id);

	public void setFirst(Integer id, boolean b);

	public List<HerdNode> getChildren(Integer pid);

	public void setSite(int node_id,int site_id,boolean is_pc);

	public ReturnMsg getSiteFirst(Integer siteId,boolean is_pc);

	public ReturnMsg change_Nodetype(Integer node_id, Integer node_type);
	
	public List<Integer> getFirst();

}
 