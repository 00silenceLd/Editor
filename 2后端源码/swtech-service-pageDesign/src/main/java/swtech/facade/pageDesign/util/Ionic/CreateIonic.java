package swtech.facade.pageDesign.util.Ionic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.File.SSHUtil;
import swtech.facade.pageDesign.util.File.SpringTool;
import swtech.facade.pageDesign.util.File.WriteMapper;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.service.pageDesign.dao.NodeDao;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　        ┃
 * ┃　　　━　            ┃
 * ┃　┳┛　┗┳　    ┃
 * ┃　　　　　　        ┃
 * ┃　　　┻　　        ┃
 * ┃　　　　　　        ┃
 * ┗━┓　　　┏━┛
 *　      ┃　　　┃神兽保佑
 *　 　 ┃　　　┃代码无BUG！
 *　 　 ┃　　　┗━━━┓
 *　 　 ┃　　　　　　┣┓
 *　　  ┃　　　　　　┏┛
 *　　  ┗┓┓┏━┳┓┏┛
 *　　 　┃┫┫ ┃┫┫
 *　　 　┗┻┛ ┗┻┛
 *
 *
 * @description : 创建Ionic自响应页面数据
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月13日 上午10:07:29
 **/
public class CreateIonic {
	
	private static SSHUtil ssh = new SSHUtil();
	private static String savePaths;
	private static NodeDao dao = (NodeDao) SpringTool.getBean("nodeDao"); 
	
	public static String moveIonic(PageEditor page,String nodeName) throws IOException {
		
		//获取最顶节点 判断是否有主项目页面
		List<Node> list = getNodeId(page.getNode_id(), new ArrayList<Node>());
		
		
		if(list.size() >= 1) {
			Node node = list.get(list.size() - 1);
			Node thisNode = dao.getById(page.getNode_id());
			//获取最顶节点项目  拼音
			if(thisNode.getParent_id() == 3) {
				//中文名字转换类名
				String className = Pinyin4jUtil.toPinyin(thisNode.getValue());
				className = invokeUtil.captureName(className.toLowerCase());
				//创建ionic 整个项目
//				savePaths = "/root/java/config/ionic/" + nodeName + "/";曾
				savePaths = PathConstants.THIS_ROOT_ATALOGUE + "java/config/ionic/" + nodeName + "/";
				ssh.copyFile(PathConstants.IONIC_PATH,savePaths,"-r");
				
				//替换必备配置文件内容
				editIonicConfig(className);
				
			}else {
				//子节点保存
				String className = Pinyin4jUtil.toPinyin(node.getValue());
				className = invokeUtil.captureName(className.toLowerCase());
				//判断父节点ionic项目是否存在
//				savePaths = "/root/java/config/ionic/" + className + "/";
				savePaths = PathConstants.THIS_ROOT_ATALOGUE +"java/config/ionic/" + className + "/";
				File file = new File(savePaths);
				if(!file.exists()) {
					return "没有ionic网站根目录,创建失败！";
				}else {
					//建立子节点ionic页面
					editIonic(page,nodeName,node);
				}
			}
			
		}
		return "success";
	}

	/*	
	 * 替换必备配置文件内容
	 * className 类名
	 * */
	private static void editIonicConfig(String className) throws IOException {
		BufferedReader reader = null;
		File file = new File(savePaths+"ionic.config.json");
		reader = new BufferedReader(new FileReader(file));
		String tempString = null;
		StringBuffer sb = new StringBuffer();
		
		while ((tempString = reader.readLine()) != null) {
			
			if(tempString.contains("swApp")) {
				sb.append(tempString.replace("swApp", className));
			}else {
				sb.append(tempString + "\n");
			}
			
		}
		WriteMapper.createFile(sb.toString(), file.getAbsolutePath());
		reader.close();

	}


	/*	
	 * 建立子节点ionic页面
	 * 表单对象 page
	 * nodeName 当前节点名
	 * node 父节点Node对象
	 * */
	private static void editIonic(PageEditor page, String nodeName,Node node) throws IOException {
		
		try {
			
			BufferedReader reader = null;
			File file = new File(savePaths+"src/app/app.module.ts");
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			StringBuffer sb = new StringBuffer();
			int i = 1;
			//修改app.module.ts文件
			while ((tempString = reader.readLine()) != null) {

				if (tempString.contains("MyApp")) {
					switch (i) {
					case 1:
						sb.append(tempString + "\n"+"import { "+nodeName+"Page } from '../pages/"+nodeName.toLowerCase()+"/"+nodeName.toLowerCase()+"';"+"\n");
						break;
					case 2:
						sb.append(tempString + "\n"+"    "+nodeName+"Page,"+"\n");
						break;
					case 4:
						sb.append(tempString + "\n"+"    "+nodeName+"Page,"+"\n");
						break;
					default:
						sb.append(tempString + "\n");
						break;
					}
					i++;
				}else {
					sb.append(tempString + "\n");
				}
			}
			WriteMapper.createFile(sb.toString(), file.getAbsolutePath());
			reader.close();
			
			//移动默认ionic模板
			String ionicPath = savePaths+"src/pages/"+nodeName.toLowerCase()+"/";
			ssh.copyFile(savePaths+"src/pages/ABCDEFG/", ionicPath, "-r");
			BufferedReader reader1 = null;
			File file1 = new File(ionicPath+"home.ts");
			reader1 = new BufferedReader(new FileReader(file1));
			StringBuffer sb1 = new StringBuffer();
			String tempString1 = null;
			while ((tempString1 = reader1.readLine()) != null) {
				if(tempString1.contains("HomePage")) {
					sb1.append(tempString1.replace("HomePage", nodeName+"Page") + "\n");
				}else if(tempString1.contains("home.html")){
					sb1.append(tempString1.replace("home.html", nodeName.toLowerCase()+".html") + "\n");
				}else {
					sb1.append(tempString1 + "\n");
				}
			}
			
			WriteMapper.createFile(sb1.toString(), file1.getAbsolutePath());
			reader1.close();
			
			//重命名
			ssh.moveTo(ionicPath+"/home.html", ionicPath+"/"+nodeName.toLowerCase()+".html");
			ssh.moveTo(ionicPath+"/home.scss", ionicPath+"/"+nodeName.toLowerCase()+".scss");
			ssh.moveTo(ionicPath+"/home.ts", ionicPath+"/"+nodeName.toLowerCase()+".ts");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	//递归查询主项目
	public static List<Node> getNodeId(Integer nodeId, List<Node> node1) {

		Node node = dao.getById(nodeId);
		node1.add(node);
		if (node.getParent_id() == 3) {
			return node1;
		} else {
			getNodeId(node.getParent_id(), node1);
		}

		return node1;
	}

}
 