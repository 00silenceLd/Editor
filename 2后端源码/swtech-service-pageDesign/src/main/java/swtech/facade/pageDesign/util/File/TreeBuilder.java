package swtech.facade.pageDesign.util.File;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import swtech.facade.pageDesign.entity.TreeNode;

/**
 * @描述 将list数组构建成树形结构
 * @author 林致杰
 *
 */
public class TreeBuilder {
	
	/**
	 * @描述 封装list的根节点
	 * @author 林致杰
	 * @param nodeLists
	 * @return List<TreeNode>
	 */
	public static List<TreeNode> TreeRootNode(List<TreeNode> nodeLists){
		List<TreeNode> newNodeLists = new ArrayList<TreeNode>();
		TreeNode node1 = null;
		
		for(TreeNode node : nodeLists){
			if(node.getParent_id() == 0){
				//在list中存入封装好的所有节点信息
				node1 = TreeChildrenNode(nodeLists , node);
			}
		}
		newNodeLists.add(node1);
		
		return newNodeLists;
	}
	
	/**
	 * @描述 递归封装list的子节点
	 * @author 林致杰
	 */
	public static TreeNode TreeChildrenNode(List<TreeNode> nodeLists , TreeNode node){
		
		//用来存储子节点的集合
		List<TreeNode> children = new ArrayList<TreeNode>();
		//用来存储所有节点的父节点
		List<Integer> pid = new ArrayList<Integer>();
		
		for(TreeNode node2 :nodeLists){
			int id = (int) node2.getParent_id();
			pid.add(id);
		}
		
		//list集合使用set去重
		List<Integer> pids = new ArrayList<Integer>(new HashSet<Integer>(pid)); 

		
		//遍历查询根节点下的子节点
		for(TreeNode node1 :nodeLists){
			if(node1.getParent_id() == node.getId()){
				
				//如果没有子节点就给个空的子集合
				if(!pids.contains(node1.getId())){
					node1.setChildren(new ArrayList<TreeNode>());
				}
				
				//将节点信息已childrens的集合形式存到上级父节点中
				children.add(node1);
				node.setChildren(children);
				System.out.println("测试:"+node.getChildren());
				//递归存储子节点的信息
				TreeChildrenNode(nodeLists , node1);
			}
		}
		return node;
	}
	
}
