package swtech.facade.pageDesign.util.File;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.mortbay.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import swtech.facade.pageDesign.entity.Node;
import swtech.service.pageDesign.biz.NodeOperatorBiz;
import swtech.service.pageDesign.dao.HerdNodeDao;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.impl.HerdNodeDaoImpl;
import swtech.service.pageDesign.dao.impl.NodeDaoImpl;

/**
 * @描述 将list数组构建成树形结构
 * @author 林致杰
 *
 */
public class ForTreeBuilder {

	//private static NodeDao nodeDao = (NodeDao) SpringTool.getBean("nodeDao");
	private static final Logger logger = LoggerFactory.getLogger(ForTreeBuilder.class);
	

	private static List<Integer> node_First;
	
	/**
	 * @描述 封装list的根节点
	 * @author 林致杰
	 * @param nodeLists
	 * @param nodeStr 
	 * @return List<Node>
	 */
	public static Node TreeRootNode(List<Node> nodeLists,List<Integer> nodeFirst){
		node_First = nodeFirst;
		Node node1 = null;		
		for(Node node : nodeLists){
//			System.out.println("在treeRootNode方法中的 node循环==="+node);
			if(node.getParent_id() == 1){
				//在list中存入封装好的所有节点信息
				node1 = TreeChildrenNode(nodeLists,node);
				node1.setSettings(TreeProperty.getParentIdTree());
				if(node1.getChildren() == null) {
					node1.setChildren(new ArrayList<Node>());
				}
				
				int nType = node1.getNode_type();
				if (nType == 7 || nType == 8) {
					addNodeCss(node1,nType,false);
				}				
				//判断是否是首页
				if(isContainsId(node1)){
					node1.setSettings(new JSONObject());
					addNodeCss(node1,nType,true);
				}				
			}
		}
		return node1;
	}
	
	/**
	 * @描述 递归封装list的子节点
	 * @author 林致杰
	 */
	public static Node TreeChildrenNode(List<Node> nodeLists , Node node){
		
		
		//用来存储子节点的集合
		List<Node> children = new ArrayList<Node>();
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
				}
				if(node1.getParent_id() == 3) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isCollapsedOnInit", true);
					node1.setSettings(jsonObject);
				}
				
				//判断是手机端还是pc端来插入前端类样式
				int nType = node1.getNode_type();
				if (nType == 7 || nType == 8) {
					addNodeCss(node1,nType,false);
				}
				
				//判断是否是首页
				if(isContainsId(node1)){
					
					node1.setSettings(new JSONObject());
					addNodeCss(node1,nType,true);
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
	private static String nodeString="";
	public static Node TreeRootNodeAndStr(List<Node> nodeLists,String nodeStr){
		Node node1 = null;		
		for(Node node : nodeLists){
			if(node.getParent_id() == 1){
				//在list中存入封装好的所有节点信息
				node1 = TreeChildrenNodeAndStr(nodeLists,node,nodeStr);
				node1.setSettings(TreeProperty.getParentIdTree());
				System.out.print(node1.getId());
				nodeStr=nodeStr+ node1.getId()+";";
				if(node1.getChildren() == null) {
					node1.setChildren(new ArrayList<Node>());
				}
			}
		}
		node1.setChildrenStr(nodeString);
		return node1;
	}
	public static Node TreeChildrenNodeAndStr(List<Node> nodeLists , Node node,String nodeStr){
		//用来存储子节点的集合
		List<Node> children = new ArrayList<Node>();
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
				}
				if(node1.getParent_id() == 3) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("isCollapsedOnInit", true);
					node1.setSettings(jsonObject);
				}
				//将节点信息已childrens的集合形式存到上级父节点中
				children.add(node1); 
				Collections.sort(children);
				node.setChildren(children);
				//递归存储子节点的信息
				TreeChildrenNodeAndStr(nodeLists , node1,nodeStr);
			}
		}
		return node;
	}
	
	/**
	 * @描述 根据node_type 添加类样式
	 * @author 张宇
	 */
	public static Node addNodeCss(Node node1,int nType,boolean bool){
		//判断是手机端还是pc端来插入前端类样式
		Integer isPopularize = node1.getIs_popularize();//0为推广页，1为非推广页
//		Log.info("根据是否推广页判断使用样式===="+isPopularize);
		
		JSONObject settings = node1.getSettings();
		if (settings != null) {
			settings.put("templates",TreeProperty.getParentIdTreeByNodeType(nType,bool,isPopularize));
			node1.setSettings(settings);
		}else{
			JSONObject addClass = new JSONObject();
			addClass.put("templates",TreeProperty.getParentIdTreeByNodeType(nType,bool,isPopularize));
			node1.setSettings(addClass);
		}
		
		return node1;
	}
	
	public static boolean isContainsId(Node node1){
		
		if(node_First !=null && node_First.size()>0 && node_First.contains(node1.getId())){
			return true;
		}
		return false;
	}
}
