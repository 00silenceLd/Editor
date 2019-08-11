package swtech.service.pageDesign.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.SiteFirst;
import swtech.facade.pageDesign.util.File.ForTreeBuilder;
import swtech.facade.pageDesign.util.File.ForTreeBuilder2;
import swtech.facade.pageDesign.util.File.TestTreeBuilder;
import swtech.facade.pageDesign.util.File.TreeProperty;
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

@Component("herdNodeQueryBiz")
//@Transactional(rollbackFor = Exception.class)
public class HerdNodeQueryBiz {
	
	@Autowired
	private HerdNodeDao dao;
	
	/**
	 * 获取所有节点
	 * @return
	 */
	public ReturnMsg getTreeNode() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		List<HerdNode> list = new ArrayList<HerdNode>();
		try {
			
			list = dao.getTreeNode();
			HerdNode node  = ForTreeBuilder2.TreeRootNode(list);
			
			msg.setStatus("0");
			msg.setStatusMsg("查询成功");
			//不显示根节点
			msg.setMsg(node);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(list);
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
			
			HerdNode node = dao.getByNodeName(nodeId);
		
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
			HerdNode node = dao.getById(pid);
			node.setSettings(TreeProperty.getParentIdTree());
			
			//查询子节点children
			List<HerdNode> children = dao.getOneNode(pid);
			
			//设置树形折叠属性
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("isCollapsedOnInit", true);
			for (int i = 0; i < children.size(); i++) {
				HerdNode node1 = children.get(i);
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
	@Transactional(rollbackFor = Exception.class)
	//插入网群管理表
	public ReturnMsg moveNode(int pid) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			
			//查询主节点
			List<HerdNode> list = dao.getTreeNode();
			//list = TestTreeBuilder.TreeRootNode(list);
			
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

	public ReturnMsg getSiteFirst(Integer siteId,boolean is_pc) {
		ReturnMsg msg = null;
		try {
		    msg=dao.getSiteFirst(siteId,is_pc); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg; 
	}
	
}
 