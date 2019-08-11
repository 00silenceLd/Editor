package swtech.service.pageDesign.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.util.File.ForTreeBuilder;
import swtech.facade.pageDesign.util.File.TestTreeBuilder;
import swtech.facade.pageDesign.util.File.TestTreeBuilder2;
import swtech.facade.pageDesign.util.File.TreeProperty;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.HerdNodeDao;
import swtech.service.pageDesign.dao.NodeDao;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:33:40 
 *
 * 树节点业务逻辑层
 *
 */

@Component("nodeQueryBiz")
//@Transactional(rollbackFor = Exception.class)
public class NodeQueryBiz {

	@Autowired
	private NodeDao dao;

	@Autowired
	HerdNodeDao herdNodeDao;

	private static Logger logger = LoggerFactory.getLogger(NodeQueryBiz.class);

	/**
	 * 获取所有节点
	 * @return
	 */
	public ReturnMsg getTreeNode() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {			
			List<Node> list = dao.getTreeNode();
			System.out.println("=======nodeList============"+list);
			List<Integer> nodeFirst = herdNodeDao.getFirst();
			System.out.println("=======nodeFirst=====不知道干什么的======="+list);
			Node node  = ForTreeBuilder.TreeRootNode(list,nodeFirst);
			System.out.println("这里才是重点啊，ForTreeBuilder.TreeRootNode(list,nodeFirst);===========node=================="+node);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
			//不显示根节点
			msg.setMsg(node);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	/**
	 * 根据uId获取所有节点
	 * @return
	 */
	public ReturnMsg getTreeNode(int uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {			
			List<Node> list = dao.getTreeNodeByUid(uId);

			List<Integer> nodeFirst = herdNodeDao.getFirst();

			Node node  = ForTreeBuilder.TreeRootNode(list,nodeFirst);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
			//不显示根节点
			msg.setMsg(node);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}
	/**
	 * @param parent_id
	 * @return
	 * 查询子节点总数
	 */
	public ReturnMsg  getChildCountById(int parent_id) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {



		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * @return
	 * 根据ID查询节点名
	 */
	public ReturnMsg getByNodeName(Integer nodeId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			Node node = dao.getByNodeName(nodeId);

			msg.setMsg(node);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	/**
	 * @param nodeId
	 * @return
	 * 根据PID查询
	 */
	public ReturnMsg getOneNode(Integer pid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			//查询主节点
			Node node = dao.getById(pid);
			node.setSettings(TreeProperty.getParentIdTree());

			//查询子节点children
			List<Node> children = dao.getOneNode(pid);

			//设置树形折叠属性
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isCollapsedOnInit", true);
			for (int i = 0; i < children.size(); i++) {
				Node node1 = children.get(i);
				node1.setSettings(jsonObject);
				children.set(i, node1);
			}
			node.setChildren(children);


			msg.setMsg(false);
			msg.setStatus("1");
			msg.setStatusMsg("查询异常");
			if(node != null){
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("查询成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}


	//插入网群管理表
	public ReturnMsg moveNode(int pid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			//查询主节点
			List<Node> list = dao.getTreeNode();
			list = TestTreeBuilder.TreeRootNode(list);

			for (int i = 0; i < list.size(); i++) {
				dao.insertNode(list.get(i));
			}

			msg.setMsg(list);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}


	//查询该节点最顶级节点 下所有数据
	public ReturnMsg getDataSourcePage(Integer nodeId,Integer uid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			List<Node> nodes = getNodeId(nodeId,new ArrayList<Node>());
			if(nodes.size() >= 1) {
				Node node = nodes.get(nodes.size() - 1);
				List<Node> list = dao.getTreeNodeByUid(uid);
				logger.info("--------------list大小="+list.size());
				//转为集合方式显示
				nodes = TestTreeBuilder2.TreeRootNode(list,node.getId());
			}
			//张宇注释//7.17
			List<Node> node = dao.searchType(3);
			for (int i = 0; i < node.size(); i++) {
				nodes.add(node.get(i));
			}

			msg.setMsg(nodes);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}


	//递归查询
	public List<Node> getNodeId(Integer nodeId,List<Node> node1) {

		Node node = dao.getById(nodeId);
		node1.add(node);
		if(node.getParent_id() == 3) {
			return node1;	
		}else {
			getNodeId(node.getParent_id(),node1);
		}

		return node1;
	}
	public ReturnMsg getUpWebsiteTreeNode(Integer uid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {			
			Map map = new HashMap();
			List<Node> list = dao.getUpWebsiteTreeNode(); 
			Node node  = ForTreeBuilder.TreeRootNode(list,null);
			//获取已存在的node
			List selectNode = dao.getSiteHasNodesReturnNodeId(uid);
			String nodeStr=JSON.toJSONString(node);
			msg.setStatus("0"); 
			//			System.out.print(nodeStr);
			//			msg.setStatusMsg(nodeStr);
			//不显示根节点
			map.put("allNode", node);
			map.put("selectNode", selectNode);
			msg.setMsg(map);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}
	//查询该节点最顶级节点 下所有数据
	public ReturnMsg getDataSourceByUid(Integer nodeId,Integer uid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			List<Node> nodes = getNodeId(nodeId,new ArrayList<Node>());
			if(nodes.size() >= 1) {
				Node node = nodes.get(nodes.size() - 1);
				List<Node> list = dao.getDataSourceByUid(uid);
				logger.info("--------------list大小="+list.size());
				//转为集合方式显示
				nodes = TestTreeBuilder2.TreeRootNode(list,node.getId());
			}
			//张宇注释//7.17
			List<Node> node = dao.searchType(3);
			for (int i = 0; i < node.size(); i++) {
				nodes.add(node.get(i));
			}

			msg.setMsg(nodes);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	/**
	 * 根据uId获取所有节点
	 * @return
	 */
	public ReturnMsg getDataSourceByUid(int uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {			
			List<Node> list = dao.getDataSourceByUid(uId);
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
			//不显示根节点
			msg.setMsg(list);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询失败");
		}
		return msg;
	}

	public int getApprove(long id) {
		int approve = dao.getApprove(id);

		return approve;
		// TODO Auto-generated method stub

	}

	public ReturnMsg getThisSlavePage(Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();

		if(nodeId==null)throw new ServiceException("nodeId不能为空");


	
		List<Map> slaveInfoMaps = new ArrayList();
		//根据nodeId查询该页面存在哪些从页面
		List<Integer> slaveIdList = dao.getSlavePageIdByMasterId(nodeId);

		for(Integer slaveId:slaveIdList) {
			Map<String, Object> slaveMap = new HashMap<String,Object>();
			//根据slaveId查询该从页面的中文名字
			String slavePageName = dao .getSlavePageNameBySlaveId(slaveId);
			
			if(StringUtils.isBlank(slavePageName)) throw new ServiceException("查询从页面失败");
			
			slaveMap.put("nodeId", slaveId);
			slaveMap.put("nodeName", slavePageName);
			
			slaveInfoMaps.add(slaveMap);
		}



		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(slaveInfoMaps);
		return msg;
	}
}
