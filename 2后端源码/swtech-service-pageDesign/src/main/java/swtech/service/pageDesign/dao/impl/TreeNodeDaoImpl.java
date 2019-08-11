package swtech.service.pageDesign.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.core.mybatis.interceptor.ExecutorInterceptor;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.facade.pageDesign.util.File.TreeBuilder;
import swtech.service.pageDesign.dao.TreeNodeDao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.Msg;

@Repository("treeNodeDao")
public class TreeNodeDaoImpl extends BaseDaoImpl<TreeNode> implements
		TreeNodeDao {
	private static final Log log = LogFactory.getLog(TreeNodeDaoImpl.class);

	public ReturnMsg getNodeChildren(Long pid) {
		
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pid", pid);
		log.info("pid的值是:" + pid);
		try {
			log.info("来到了这里");
			msg.setMsg(getSessionTemplate().selectList("findNodeByparentId",pid));
			msg.setStatus("1");
			msg.setStatusMsg("success");
			log.info("获取的树节点："+msg.getMsg().toString());
		} catch (Exception e) {
			msg.setMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg change_is_delete(long id) {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		try {
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(getSessionTemplate().update("change_is_delete", id));
		} catch (Exception e) {
			msg.setMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg getChildCountById(long id) {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		try {
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(getSqlSession().selectOne("getChildCountById", param));
		} catch (Exception e) {
			msg.setMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg getDownSoreById(Long pid, int node_sore) {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("parent_id", pid);
		param.put("node_sore", node_sore);
		try {
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(getSessionTemplate()
					.selectList("getDownSoreById", param));
		} catch (Exception e) {
			msg.setMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg getUpSoreById(Long pid, int node_sore) {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("node_sore", node_sore);
			param.put("pid", pid);
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(getSessionTemplate().selectList("getUpSoreById", param));
		} catch (Exception e) {
			msg.setMsg(e.toString());
		}
		return msg;
	}

	public ReturnMsg getTreeNode() {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			List<TreeNode> list = getSessionTemplate().selectList("getTreeNode");
			list = TreeBuilder.TreeRootNode(list);
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public List<TreeNode> getAllNode() {
		List<TreeNode> list = new ArrayList<TreeNode>();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			list = getSessionTemplate().selectList("getTreeNode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ReturnMsg getLikeName(Long pid, String name) {
		ReturnMsg msg = new ReturnMsg();
		msg.setStatus("0");
		msg.setStatusMsg("false");
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pid",pid);
			map.put("name", name);
			List<TreeNode> list = getSessionTemplate().selectList("getLikeName", map);
			
			msg.setStatus("1");
			msg.setStatusMsg("success");
			msg.setMsg(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
