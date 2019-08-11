package swtech.service.pageDesign.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.UserHasNode;

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

public interface NodeDao extends BaseDao<Node>{

	/**
	 * @return
	 * 查询所有数据
	 */
	public List<Node> getTreeNode();
	
	/**
	 * @return
	 * 根据uId查询所有数据
	 */
	public List<Node> getTreeNodeByUid(Integer uId);

	/**
	 * @return
	 * 根据uId查询所有数据源
	 */
	public List<Node> getDataSourceByUid(Integer uId);
	

	/**
	 * @param node
	 * @return
	 * 添加树节点
	 */
	public int insertTreeNode(Node node);

	/**
	 * @param node
	 * @return
	 * 更新树节点
	 */
	public int updateTreeNode(Node node);

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
	public Node selectNodeSore(int pid, int nodeSore);

	/**
	 * @param nodeId
	 * @return
	 * 根据ID查询对象
	 */
	public Node getByNodeName(Integer nodeId);

	/**
	 * @param pid
	 * @return
	 * 根据pid查询下所有对象
	 */
	public List<Node> getOneNode(Integer pid);

	/**
	 * @param pid
	 * @return
	 * 根据PID查询网站管理
	 */
	public Node getByIds(Integer pid);

	
	/**
	 * 插入网站管理
	 * */
	public int insertNode(Node node);

	/**
	 * 获取数据源可绑定表单对象
	 * */
	public List<Node> getDataSourcePage();

	/**
	 * 获取同名表单树
	 * */
	public Node getNode(String nodeName);

	/**
	 * 获取自定义资源库
	 * */
	public List<Node> searchType(int type);

	public List<Node> getUpSiteChildrenById(Integer nodeId);

	public Node getUpWebsiteNodeById(Integer nodeId);

	public ReturnMsg copyTo(Node node);

	public List<Node> getUpWebsiteTreeNode();
	
	public String getNameByNodeId(long nodeId);

	public List<UserHasNode> getSiteHasNodes(int uid);
	
	public void addNodeToSite(UserHasNode node);
	
	public void updateNodeForSite(UserHasNode node);
	
	public List<Integer> getSiteHasNodesReturnNodeId(int uid);

	public ReturnMsg addUserIndexPage(Map map);

	public Integer selectIndexPageByRoleAndPid(int roleId, int pid);

	// 删除首页
	public void delUserIndexPage(Integer id);

	// 删除用户权限
	public void delUserRoleByOrgWithPosition(Map map);

	// 插入删除的权限
	public void insertUserRoleByOrgWithPosition(JSONObject record);

	// 获取该组织该职位该用户删除的权限
	public List<Map> getUserRoleByOrgWithPosition(JSONObject record);

	// 获取用户对应的组织-职位的拥有节点权限
	public List<Integer> selectUserNodeIdByPidAndRoleId(JSONObject json);

	// 根据用户id删除所有的拥有节点
	public void delNodeToSiteByUid(Integer uId);

	// 批量插入购买的节点
	public void insetNodeToSitebyListNode(@Param("addNode")UserHasNode addNode, @Param("list")List<Integer> nodeIdList);

	public Integer getIdByNodeName(String classname);

	public int getApprove(Long id);

	public ReturnMsg getNotApprovePage();

	public ReturnMsg agreeSavePage(Integer node_id);

	public ReturnMsg notAgreeSavePage(Integer id);

	public Integer getIspublicByNodeId(int node_id);

	public Integer getPopularizeById(String nodeId);

	public Integer saveMasterAndSlaveRel(Node node);

	public Integer deleteMasterAndSlaveRel(Node node);

	public List<Integer> getSlavePageIdByMasterId(Integer nodeId);

	public String getSlavePageNameBySlaveId(Integer slaveId);

	public Integer updateSlavePageName(Node node);
	

}
 