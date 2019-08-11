package swtech.service.pageDesign.biz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import swtech.common.config.constants.HostConstants;
import swtech.common.entity.ReturnMsg;
import swtech.common.utils.string.StringUtil;
import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.TreeNode;
import swtech.facade.pageDesign.entity.UserHasNode;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.File.SSHUtil;
import swtech.facade.pageDesign.util.File.TestTreeBuilder;
import swtech.facade.pageDesign.util.File.TestTreeBuilder2;
import swtech.facade.pageDesign.util.File.TreeProperty;
import swtech.facade.pageDesign.util.File.WriteMapper;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.facade.pageDesign.util.project.AntExecSql;
import swtech.facade.pageDesign.util.project.Command;
import swtech.facade.pageDesign.util.project.FileOperate;
import swtech.facade.pageDesign.util.project.HandleBackgroundProject;
import swtech.facade.pageDesign.util.project.JDBCUtil;
import swtech.facade.pageDesign.util.site.SiteNodeBuilder;
import swtech.facade.pageDesign.util.site.SiteUtil;
import swtech.facade.pageDesign.util.site.zip;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;
import util.Answer;

/**
 *
 * @author 林致杰
 *
 * @version 1.0
 *
 *          创建时间：2017年12月1日 下午5:16:15
 *
 *          树节点操作业务逻辑层
 *
 */

@Component("nodeOperatorBiz")
@Transactional()
public class NodeOperatorBiz {

	@Autowired
	private NodeDao dao;

	@Autowired
	private PageDesignDao pageDesignDao;

	/**
	 * @param node
	 * @return
	 */
	public ReturnMsg addTreeNode(List<Node> nodeList) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();


		try {





			Integer is_del=1;
			//Node node = JSONObject.parseObject(entity, Node.class);//将接收到的对象用node实体类封装
			for(Node node:nodeList) {

				//根据page_classify、module_classify、is_project,决定是否创建文件夹,并返回文件夹路径
				if(node.getIs_project()!=null&& node.getModule_classify()!=null&& node.getPage_classify()!=null) {
						
				String page_path =createStaticPageDir(node);
				//封装该节点页面在服务器中所在文件夹位置 
				node.setPage_path(page_path);

				System.out.println("page_path="+page_path);

				}
				

				System.out.println("===========nodeType======" + node.getType());
				System.out.println("===========nodeName======" + node.getNode_name());
				System.out.println("===========node======" + node.getType());
				// 私有
				node.setUserPrivate(0);
				// 查询子节点总数
				int count = dao.getChildCountById(node.getParent_id());//回看
				node.setNode_sore(count);
				node.setCreate_time(new Date());//曾智宏
				System.out.println("==========让我看看保存之前的内容，有没有id==========="+node);

				Integer isPopularize = node.getIs_popularize();
				if(isPopularize==0)node.setIs_public(null);
				System.out.println("==========判断是否为推广页，以清空is_public==========="+node.getIs_public());


				int i = 0;
				if(node.getId()==null) {
					System.out.println("是否有id==="+node.getId());
					i = dao.insertTreeNode(node);//插入啦插入啦！！！
				}

				if(node.getIs_slave_page()==1) {//如果该页面为多数源发布标识控件中从页面，就将主id与从id保存进ht_master_slave_rel关系表中
					//重新删除添加
					if(is_del==1) {
						Integer row1 = dao.deleteMasterAndSlaveRel(node);
						//if(row1 == 0 )throw new ServiceException("删除主从关系失败");
						is_del=0;
					}

					Integer row2 = dao.saveMasterAndSlaveRel(node);
					if(row2 == 0 )throw new ServiceException("保存主从关系失败");

					Integer row3 = dao.updateSlavePageName(node);
					//if(row3 == 0 )throw new ServiceException("修改节点名失败");



					i=1;
				}

				// 获取插入后返回的ID 再添加url
				node.setUrl("/pageDesignQueryFacade/getPageContent?id=" + node.getId());
				System.out.println("-==========type===" + node.getType());
				System.out.println("=========再我看看更新之前的内容，URL的情况==========="+node);
				dao.updateTreeNode(node);

				boolean b;

				// 如果是创建项目 nodeType: 1
				if (node.getNode_type() == 1 || node.getParent_id() == 3) {

					// 主页面操作
					// b = SiteUtil.homePage(node);
					System.out.println("----------------主页面生成----------------");
				} else {

					// 子页面操作
					// TODO 暂时注释
					// b = SiteUtil.subPage(node);
					System.out.println("----------------子页面生成----------------");
				}
				// System.out.println("----------------静态页面生成状态：----------------" +
				// b);

				// TODO 添加权限
				UserHasNode hasNode = new UserHasNode();
				hasNode.setAddTime(System.currentTimeMillis());
				hasNode.setNodeId(node.getId());
				hasNode.setIs_delete(0);
				hasNode.setCreateUid(node.getCreaterUid());
				hasNode.setuId(node.getCreaterUid());
				dao.addNodeToSite(hasNode);


				if (i > 0) {
					msg.setMsg(node);
					msg.setStatus("0");
					msg.setStatusMsg("添加成功");
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("添加失败:"+e.getMessage());
		}
		return msg;
	}

	private String createStaticPageDir(Node node) {
		//根据page_classify、module_classify、is_project,决定是否创建文件夹
		Integer is_project = node.getIs_project();//是否为项目节点
		Integer module_classify = node.getModule_classify();//模块分类
		Integer page_classify = node.getPage_classify();//页面分类
		String page_path = node.getPage_path();//该节点所在父节点的文件夹
		if(page_path==null)page_path="/folder/staticPage";
		Integer randomNum=	(int) (Math.random()*100);
		String pageDirName = Pinyin4jUtil.toPinyin(node.getValue())+randomNum;
		File dir =null;
//		String commonPath = "/usr/local/nginx/html";
		String commonPath =PathConstants.NIGNX_ROOT_PATH;
				
		
		System.out.println("这里是createStaticPageDir");
		//根据路径中有几级目录，判断是否为静态页文件
		if(page_path.charAt(page_path.length()-1)=='/') {
			return page_path;
		}

		if(page_path.split("/").length==6) {
			String newPagePath =page_path+"/";
			return newPagePath;
		}

		/*if(is_project==1) {//为项目节点
			String newPagePath ="/folder/staticPage/"+pageDirName;
			dir = new File(commonPath+newPagePath);
			if(!dir.exists()) {
				boolean mkdir = dir.mkdir();
				if(mkdir) {
					System.out.println("创建项目文件夹成功");
				}else {
					System.out.println("创建项目文件夹失败");
				}
			}
			return newPagePath;
		}
*/
		//为模块节点、页面节点
		
		String newPagePath = page_path+"/"+pageDirName;
		dir = new File(commonPath+newPagePath);
		if(!dir.exists()) {
			boolean mkdir = dir.mkdir();
			if(mkdir) {
				System.out.println("创建模块页面文件夹成功");
			}else {
				System.out.println("创建模块页面文件夹失败");
			}
		}
		return newPagePath;


	}

	/**
	 * @param page
	 * @return
	 */
	public ReturnMsg addPageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			PageEditor page = JSONObject.parseObject(entity, PageEditor.class);
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("node_id", page.getNode_id());
			param.put("is_delete", page.isIs_delete());
			int count = pageDesignDao.getCountForNodeId(param);
			if (count > 0) {
				pageDesignDao.updateIsDelete(param);
			}
			int i = pageDesignDao.addPageEditor(page);

			if (i > 0) {
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("添加失败");
		}
		return msg;
	}

	/**
	 * @param node
	 * @return
	 */
	public ReturnMsg updateTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			Node node = JSONObject.parseObject(entity, Node.class);
			int i = (int) dao.updateTreeNode(node);
			if (i > 0) {
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("更新成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("更新失败");
		}
		return msg;
	}

	/**
	 * @param entity
	 * @return
	 */
	public ReturnMsg updatePageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			PageEditor page = JSONObject.parseObject(entity, PageEditor.class);
			int i = pageDesignDao.updatePageEditor(page);
			if (i > 0) {
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("更新成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("更新失败");
		}
		return msg;
	}

	/**
	 * @param id
	 * @return
	 */
	public ReturnMsg deleteTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			Node node = JSONObject.parseObject(entity, Node.class);

			node.setIs_delete(true);
			int i = (int) dao.updateTreeNode(node);
			if (i > 0) {
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}

	/**
	 * @param id
	 * @return
	 */
	public ReturnMsg deletePageEditor(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			PageEditor page = JSONObject.parseObject(entity, PageEditor.class);
			page.setIs_delete(true);
			int i = pageDesignDao.updatePageEditor(page);
			if (i > 0) {
				msg.setMsg(page);
				msg.setStatus("0");
				msg.setStatusMsg("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}

	/**
	 * @param entity
	 * @return
	 */
	public ReturnMsg upTreeNode(String entity) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			JSONObject json = JSONObject.parseObject(entity);
			int id = json.getInteger("id");
			int nodeSore = json.getInteger("node_sore");
			int newNodeSore = json.getInteger("node_sore1");
			int pid = json.getInteger("parent_id");

			// 查询现在Node对象
			Node node = dao.selectNodeSore(pid, nodeSore);

			// 查询与Node对象交替前的Node对象
			Node node1 = dao.selectNodeSore(pid, newNodeSore);

			node.setNode_sore(newNodeSore);
			node1.setNode_sore(nodeSore);

			// 更新Node位置
			int i = dao.updateTreeNode(node);
			int j = dao.updateTreeNode(node1);
			if (i > 0 && j > 0) {
				msg.setMsg(node);
				msg.setStatus("0");
				msg.setStatusMsg("移动成功");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("0");
			msg.setStatusMsg("移动失败");
		}
		return msg;
	}

	// 批量更新系统
	public ReturnMsg<Object> updateNodeSite(Integer nodeId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "异常");
		try {

			// 查询主节点
			Node node = dao.getById(nodeId);
			boolean b;

			// 主节点更新
			b = SiteUtil.homePage(node);

			// 子节点更新
			SiteUtil.getAllChild(node.getId(), node.getId());

			System.out.println("----------------主项目生成状态：----------------" + b);

			if (b) {
				msg.setStatus("0");
				msg.setStatusMsg("更新成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("更新失败！");
		}
		return msg;
	}

	// 打包站点网页
	public ReturnMsg packSite(Integer nodeId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "异常");
		try {

			// 判断打包目录是否存在
			if (!new File(HostConstants.FILE_PATH).exists()) {

				System.out.println("-----文件夹创建状态：" + new File(HostConstants.FILE_PATH).mkdir());
			}

			// 设置打包文件名字
			String fileName = HostConstants.FILE_PATH + nodeId + ".zip";
			// 打包zip格式
			zip.createZip(PathConstants.STATIC_NIGNX_PATH + nodeId + "/", fileName);

			// 更换网址输出下载地址
			File file = new File(fileName);
			if (file.exists()) {
				msg.setMsg(fileName.replace("/usr/local/nginx/html/swpt_2/", HostConstants.HOST_PATH));
				msg.setStatus("0");
				msg.setStatusMsg("创建成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("创建失败！");
		}
		return msg;
	}

	public ReturnMsg copyTree(Integer nodeId, String excludeNode, Integer uid) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		try {
			Node node = dao.getUpWebsiteNodeById(nodeId);
			copyTo(node, excludeNode, uid);
		} catch (Exception e) {
			msg.setMsg(e.toString());
			msg.setStatus("0");
		}
		return msg;
	}

	private ReturnMsg copyTo(Node node, String excludeNode, Integer uid) {
		ReturnMsg msg = new ReturnMsg();
		try {
			List<Node> nodes = dao.getUpSiteChildrenById(node.getId());
			System.out.print("子节点个数有：" + nodes.size());
			node.setId(null);
			ReturnMsg m = new ReturnMsg();
			m = dao.copyTo(node);
			int new_id = node.getId();
			for (int i = 0; i < nodes.size(); i++) {
				Node childNode = nodes.get(i);
				String idstr = childNode.getId().toString();
				System.out.print("节点" + childNode.getId());
				if (excludeNode.indexOf(String.valueOf(idstr)) == -1) {
					System.out.print("属于排除节点" + childNode.getId());
					childNode.setParent_id(new_id);
					childNode.setCreaterUid(uid);
					copyTo(childNode, excludeNode, uid);
				}
			}

		} catch (Exception e) {
			System.out.print(e.toString());
		}
		return msg;
	}

	/**
	 * 
	 * @Description: 购买节点（直接删除和插入，避免重复）
	 * @param @param
	 *            addNode
	 * @param @param
	 *            nodeIds
	 * @param @return
	 * @return ReturnMsg
	 * @throws @author
	 *             张宇
	 * @date 2018年9月26日上午11:47:30
	 */
	public ReturnMsg addTreeNodeToSite(UserHasNode addNode, String nodeIds) {
		ReturnMsg msg = new ReturnMsg();
		List<Integer> nodeIdList = new ArrayList<Integer>();
		try {
			if (nodeIds.contains(",")) {
				String[] nodes = nodeIds.split(",");
				for (int k = 0; k < nodes.length; k++) {
					nodeIdList.add(Integer.valueOf(nodes[k]));
				}

			}else if(StringUtil.isNotNull(nodeIds)){
				nodeIdList.add(Integer.valueOf(nodeIds));
			}
			addNode.setIs_delete(0);
			addNode.setAddTime(System.currentTimeMillis());

			if (nodeIdList.size() > 0) {
				// 删除之前选择的节点
				dao.delNodeToSiteByUid(addNode.getuId());

				dao.insetNodeToSitebyListNode(addNode, nodeIdList);
				msg.setStatus(Answer.SUCCESS_MSG);
			} else {
				msg.setStatus(Answer.ERR_MSG);
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
		}
		return msg;
	}

	/**
	 * 
	 * @Description: 选择节点（方法太笨重，不删除原先的，只是修改、新增）
	 * @param @param
	 *            addNode
	 * @param @param
	 *            nodeIds
	 * @param @return
	 * @return ReturnMsg
	 * @throws @author
	 *             张宇
	 * @date 2018年7月11日上午11:40:09
	 */
	// public ReturnMsg addTreeNodeToSite(UserHasNode addNode, String nodeIds) {
	// ReturnMsg msg = new ReturnMsg();
	// List<Integer> nodeIdList = new ArrayList<Integer>();
	// if (nodeIds.contains(",")) {
	// String[] nodes = nodeIds.split(",");
	// for (int k = 0; k < nodes.length; k++) {
	// nodeIdList.add(Integer.valueOf(nodes[k]));
	// }
	//
	// }
	// addNode.setIs_delete(0);
	// addNode.setAddTime(System.currentTimeMillis());
	//
	// try {
	// // 获取所有的已添加的权限节点
	// System.out.println("=====uid==" + addNode.getuId());
	// List<UserHasNode> nodeList = dao.getSiteHasNodes(addNode.getuId());
	// System.out.println("=====nodeList.size==" + nodeList.size());
	// if (!nodeList.isEmpty() && nodeList.size() > 0) {
	// for (Object node : nodeIdList) {
	// boolean bool = false;
	// int flag = 0;
	// for (UserHasNode userHasNode : nodeList) {
	// if (addNode.getuId() == addNode.getCreateUid()) {
	// if ((int) node == userHasNode.getNodeId() && userHasNode.getIs_delete()
	// != 0) {
	// bool = true;
	// }
	//
	// } else if ((int) node == userHasNode.getNodeId() && addNode.getPosId() ==
	// userHasNode.getPosId()
	// && addNode.getRoleId() == userHasNode.getRoleId()) {
	// if (userHasNode.getIs_delete() != 0) {
	// // 之前存在，但无效。 修改is_delete = 0
	// bool = true;
	// }
	// // 存在
	// }
	//
	// if ((int) node == userHasNode.getNodeId() && userHasNode.getIs_delete()
	// == 0) {
	// flag = 1;
	// }
	//
	// if (bool) {
	// userHasNode.setIs_delete(0);
	// dao.updateNodeForSite(userHasNode);
	// }
	// }
	// if (!bool && flag != 1) {
	// // 插入
	// addNode.setNodeId((int) node);
	// dao.addNodeToSite(addNode);
	// }
	// }
	//
	// // 修改is_delete = 1
	// // nodeList.removeAll(nodeIdList);
	//
	// for (int i = 0; i < nodeList.size(); i++) {
	// boolean isHas = false;
	// for (int nodeId : nodeIdList) {
	// if (nodeList.get(i).getNodeId() == nodeId) {
	// isHas = true;
	// System.out.println("========node===" + nodeList.get(i).getNodeId());
	// }
	// }
	// if (!isHas) {
	// // 自己的节点不被覆盖
	// System.out.println("========删除===" + nodeList.get(i).getNodeId());
	// nodeList.get(i).setIs_delete(1);
	// dao.updateNodeForSite(nodeList.get(i));
	// }
	//
	// }
	// } else {
	// // 首次加入node
	// System.out.print("===================list===" + nodeIdList.size());
	// for (Object node : nodeIdList) {
	// addNode.setNodeId((int) node);
	// dao.addNodeToSite(addNode);
	// }
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return msg;
	// }

}
