package swtech.facade.pageDesign.util.site;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.util.File.SSHUtil;
import swtech.facade.pageDesign.util.File.SpringTool;
import swtech.facade.pageDesign.util.File.TestTreeBuilder2;
import swtech.facade.pageDesign.util.File.WriteMapper;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.facade.pageDesign.util.project.AntExecSql;
import swtech.facade.pageDesign.util.project.FileOperate;
import swtech.facade.pageDesign.util.project.HandleBackgroundProject;
import swtech.facade.pageDesign.util.project.JDBCUtil;
import swtech.service.pageDesign.dao.NodeDao;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 站点工具
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年5月17日 下午4:23:58
 **/
public class SiteUtil {
	private static final Logger log = LoggerFactory.getLogger(SiteUtil.class);
	private static NodeDao nodeDao = (NodeDao) SpringTool.getBean("nodeDao");

	public static boolean homePage(Node node) throws Exception {
		
		SSHUtil ssh = new SSHUtil();

		// 复制编辑器创建前端预览界面
		String path = "/usr/local/nginx/html/swpt_2/editor/*";
		String path1 = PathConstants.STATIC_NIGNX_PATH + node.getId() + "/";
		File file = new File(path1);
		
		if(!file.exists()) {
		
			log.info("-----文件夹创建状态："+file.mkdirs());
		}
		
		ssh = new SSHUtil();
		ssh.exec("cp -rf " + path.trim() + " " + path1.trim());
		log.info("cp -rf " + path.trim() + " " + path1.trim());
		WriteMapper.editorHtml("/usr/local/nginx/html/html/" + node.getId() + "/assets/ueditor/formdesign/preview.html",
				node.getId());
		File file1 = new File("/usr/local/nginx/html/html/"+node.getId()+"/assets/ueditor/formdesign/preview.html");
		return file1.exists();
	}
	
	/**
	 * 子页面操作
	 * @throws Exception 
	 * */
	public static boolean subPage(Node node) throws Exception {
		//递归查询顶节点
		List<Node> nodes = getNodeId(node.getId(),new ArrayList<Node>());
		Node node1 = new Node();
		if(nodes.size() >= 1) {
			node1 = nodes.get(nodes.size() - 1);
		}
		int upId = node1.getId();
		log.info("----------------顶节点"+upId+"-----------------");
		
		//记录创建状态
		boolean b;
		
		//如果是最顶级节点  不创建子页面  创建整个项目
		if(upId == 3) {
			b = homePage(node);
		}else {
			//存储项目下半静态文件
			WriteMapper.editorHtmls("/usr/local/nginx/html/html/"+upId+"/assets/ueditor/formdesign/preview.html",node.getId());
			File file = new File("/usr/local/nginx/html/html/"+upId+"/assets/ueditor/formdesign/"+node.getId()+".html");
			b = file.exists();
		}

		return b;
	}
	
	// 递归查询
	public static List<Node> getNodeId(Integer nodeId, List<Node> node1) {

		Node node = nodeDao.getById(nodeId);
		node1.add(node);
		if (node.getParent_id() == 3) {
			return node1;
		} else {
			getNodeId(node.getParent_id(), node1);
		}

		return node1;
	}
	
	/**
	 * 递归所有需要更新的子页面
	 * @throws IOException 
	 * */
	public static void getAllChild(Integer id,Integer pId) throws IOException {
		List<Node> list1 = nodeDao.getOneNode(id);
		for (Node node : list1) {
			

			//存储项目下半静态文件
			WriteMapper.editorHtmls("/usr/local/nginx/html/html/"+pId+"/assets/ueditor/formdesign/preview.html",node.getId());
			File file = new File("/usr/local/nginx/html/html/"+pId+"/assets/ueditor/formdesign/"+node.getId()+".html");
			//输出状态
			log.info("----------------NodeId:"+node.getId()+"--子页面生成状态："+file.exists()+"-----------------");
			
			//递归
			getAllChild(node.getId(),pId);
		}
	}
	
}
 