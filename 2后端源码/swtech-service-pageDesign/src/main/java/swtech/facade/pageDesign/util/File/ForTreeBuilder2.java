package swtech.facade.pageDesign.util.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import swtech.facade.pageDesign.entity.HerdNode;
import swtech.facade.pageDesign.entity.Node;
import swtech.service.pageDesign.dao.HerdNodeDao;
import swtech.service.pageDesign.dao.NodeDao;

/**
 * @描述 将list数组构建成树形结构
 * @author 林致杰
 *
 */
public class ForTreeBuilder2 {
	
	//private static HerdNodeDao herdNodeDao = (HerdNodeDao) SpringTool.getBean("herdNodeDao");
	
	/**
	 * @描述 封装list的根节点
	 * @author 林致杰
	 * @param nodeLists
	 * @return List<Node>
	 */
	public static HerdNode TreeRootNode(List<HerdNode> nodeLists){
		List<HerdNode> newNodeLists = new ArrayList<HerdNode>();
		HerdNode node1 = null;
		
		for(HerdNode node : nodeLists){
			if(node.getParent_id() == 0){
				//在list中存入封装好的所有节点信息
				node1 = TreeChildrenNode(nodeLists , node);
				node1.setSettings(TreeProperty.getParentIdTree());
				if(node1.getChildren() == null) {
					node1.setChildren(new ArrayList<HerdNode>());
				}
			}
		}
		return node1;
	}
	
	/**
	 * @描述 递归封装list的子节点
	 * @author 林致杰
	 */
	public static HerdNode TreeChildrenNode(List<HerdNode> nodeLists , HerdNode node){
		
		//用来存储子节点的集合
		List<HerdNode> children = new ArrayList<HerdNode>();
		//用来存储所有节点的父节点
		List<Integer> pid = new ArrayList<Integer>();
		
		for(HerdNode node2 :nodeLists){
			int id = (int) node2.getParent_id();
			pid.add(id);
		}		
		//list集合使用set去重
		List<Integer> pids = new ArrayList<Integer>(new HashSet<Integer>(pid)); 

		
		//遍历查询根节点下的子节点
		for(HerdNode node1 :nodeLists){
			if(node1.getParent_id() == node.getId()){
				
				//如果没有子节点就给个空的子集合
				if(!pids.contains(node1.getId())){
					node1.setChildren(new ArrayList<HerdNode>());
				}
				
				if(node1.getParent_id() == 1) {
					//默认二级折叠
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isCollapsedOnInit", true);
					node1.setSettings(jsonObject);
				}

				//将节点信息已childrens的集合形式存到上级父节点中
				children.add(node1);
				Collections.sort(children);
				node.setChildren(children);
				//递归存储子节点的信息
				TreeChildrenNode(nodeLists , node1);
			}
		}
		return node;
	}
}
