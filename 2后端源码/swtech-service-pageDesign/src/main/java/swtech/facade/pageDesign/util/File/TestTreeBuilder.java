package swtech.facade.pageDesign.util.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONObject;

import swtech.facade.pageDesign.entity.Node;
import swtech.service.pageDesign.dao.NodeDao;

/**
 * @描述 将list数组构建成树形结构
 * @author 林致杰
 *
 */
public class TestTreeBuilder {
	
	private static List<Node> node1 = new ArrayList<Node>();

	/**
	 * @描述 封装list的根节点
	 * @author 林致杰
	 * @param nodeLists
	 * @return List<Node>
	 */
	public static List<Node> TreeRootNode(List<Node> nodeLists){
		List<Node> newNodeLists = new ArrayList<Node>();
		
		//用来存储子节点的集合
		List<Node> children = new ArrayList<Node>();
		for(Node node : nodeLists){
			if(node.getId() == 0){
				//在list中存入封装好的所有节点信息
				node1 = TreeChildrenNode(nodeLists , node,children);
				if(node1 != null) {
					node.setIsFolder(1);
				}
				node1.add(node);
			}
		}
		return node1;
	}
	
	/**
	 * @描述 递归封装list的子节点
	 * @author 林致杰
	 */
	public static List<Node> TreeChildrenNode(List<Node> nodeLists , Node node,List<Node> children){
		

		//用来存储所有节点的父节点
		List<Integer> pid = new ArrayList<Integer>();
		
		for(Node node2 :nodeLists){
			int id = (int) node2.getParent_id();
			pid.add(id);
		}
		
		//list集合使用set去重
		List<Integer> pids = new ArrayList<Integer>(new HashSet<Integer>(pid)); 

		
		//遍历查询根节点下的子节点
		for(Node node1 :nodeLists){
			if(node1.getParent_id() == node.getId()){
				
				//如果没有子节点就给个空的子集合
				if(!pids.contains(node1.getId())){
					node1.setChildren(new ArrayList<Node>());
					node1.setIsFolder(0);
				}else {
					node1.setIsFolder(1);
				}
				/*if(node1.getParent_id() == 16) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isCollapsedOnInit", true);
					node1.setSettings(jsonObject);
				}*/
				
				//将节点信息已childrens的集合形式存到上级父节点中
				children.add(node1);
				Collections.sort(children);
				//node.setChildren(children);
				//递归存储子节点的信息
				TreeChildrenNode(nodeLists , node1,children);
			}
		}
		return children;
	}
}
