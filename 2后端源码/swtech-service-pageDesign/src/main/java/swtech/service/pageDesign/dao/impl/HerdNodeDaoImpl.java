package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import swtech.common.config.constants.HostConstants;
import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.service.pageDesign.dao.HerdNodeDao;
import swtech.service.pageDesign.dao.NodeDao;

/**
 *
 * @author 林致杰  
 *
 * @version 1.0
 *
 * 创建时间：2017年12月1日 下午4:40:23 
 *
 * 树节点dao层实现类
 *
 */

@Repository("herdNodeDao")
public class HerdNodeDaoImpl extends BaseDaoImpl<HerdNode> implements HerdNodeDao{
	private static final Logger log = LoggerFactory.getLogger(HerdNodeDaoImpl.class);
	//查询全部数据
	public List<HerdNode> getTreeNode() {
		
		return getSessionTemplate().selectList("FindByHerdNode");
	}

	//插入树节点
	public int insertTreeNode(HerdNode node) {

		return getSessionTemplate().insert("insertTreeHerdNode",node);
	}

	//更新树节点
	public int updateTreeNode(HerdNode node) {

		return getSessionTemplate().update("updateTreeHerdNode", node);
	}

	//删除树节点
	public int deleteTreeNode(int id) {

		return getSessionTemplate().delete("deleteTreeHerdNode", id);
	}

	//计算子节点总和
	public int getChildCountById(int parent_id) {

		return getSessionTemplate().selectOne("getHerdNodeCountByPId",parent_id);
	}

	//查询与Node对象交替前的Node对象
	public HerdNode selectNodeSore(int pid, int newNodeSore) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pid", pid);
		map.put("newNodeSore", newNodeSore);
		return getSessionTemplate().selectOne("selectHerdNodeSore", map);
	}

	
	//根据ID查询对象名称
	public HerdNode getByNodeName(Integer nodeId) {

		return getSessionTemplate().selectOne("getByHerdNodeName",nodeId);
	}

	//根据PID下查询所有对象
	public List<HerdNode> getOneNode(Integer pid) {

		return getSessionTemplate().selectList("getOneHerdNode",pid);
	}

	
	public HerdNode getByIds(Integer pid) {

		return getSessionTemplate().selectOne("getByIds",pid);
	}

	//插入网站管理
	public int insertNode(HerdNode node) {

		return getSessionTemplate().insert("insertHerdNode",node);
	}

	@Override
	public List<HerdNode> getParents(int node_id) {
		// TODO Auto-generated method stub
		String sqlStr="CALL pro_getParentList('id','"+node_id+"','id','parent_id','ht_node',0)";
		return getSessionTemplate().selectOne("selectPublicItemList",sqlStr);
	}
	public void setFirst(Integer id, boolean b){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("isFirst", b);
		String sqlStr="update ht_node set isFirst='"+b+"' where id="+id;
		getSessionTemplate().selectOne("selectPublicItemList",sqlStr);
	}

	@Override
	public List<HerdNode> getChildren(Integer pid) {
		String sqlStr="CALL pro_getChildrenList('"+pid+"','id','parent_id','ht_node',0) ";
		return getSessionTemplate().selectOne("selectPublicItemList",sqlStr);
	}

	@Override
	public void  setSite(int node_id,int site_id,boolean is_pc) {
		// TODO Auto-generated method stub
		String _parameter="update ht_first set is_delete ='1' where is_pc="+is_pc+";insert into ht_first (node_id,site_id,is_pc) values ("+node_id+","+site_id+","+is_pc+")";
		getSessionTemplate().selectOne("insertRecord",_parameter);
	}

	@Override
	public ReturnMsg getSiteFirst(Integer siteId,boolean is_pc) {
		String _parameter="select node_id from ht_first where is_delete=0 and site_id="+siteId+" and is_pc="+is_pc;
		Map map= getSessionTemplate().selectOne("getSiteFirst",_parameter);	
	    String node_id = String.valueOf(map.get("node_id"));
	    Map maps= getSessionTemplate().selectOne("selectNodeNameById",map);
	    String node_name = String.valueOf(maps.get("node_name"));
	    node_name= Pinyin4jUtil.toPinyin(node_name);
	    //String url="folder/staticPage/"+node_name+".html";
	    String url=HostConstants.FILE_HOST +"staticPage/"+node_name+".html";
	    Map result=new HashMap();
	    result.put("node_id", node_id);
	    result.put("is_pc", is_pc);
	    result.put("url", url);
		ReturnMsg msg=new ReturnMsg();
		msg.setMsg(result);
		return msg;
	}

	@Override
	public ReturnMsg change_Nodetype(Integer node_id, Integer node_type) {
		ReturnMsg msg=new ReturnMsg();
		try{			
			String _parameter="update ht_node set node_type="+node_type +" where is_delete=0 and id="+node_id;
			Object obj= getSessionTemplate().selectOne("change_Nodetype",_parameter); 
			msg.setMsg("设置成功");
		} catch (Exception e) {
			msg.setMsg(e.toString());
		} 
		return msg;
	}

	@Override
	public List<Integer> getFirst() {
		log.info("===================+getFirst");
		return getSessionTemplate().selectList("getFirst");
	}
}
 