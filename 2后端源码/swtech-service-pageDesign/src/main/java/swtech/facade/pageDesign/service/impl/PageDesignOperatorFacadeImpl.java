package swtech.facade.pageDesign.service.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ibm.icu.text.SimpleDateFormat;

import swtech.common.config.constants.HostConstants;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.constants.PathConstants;
import swtech.facade.pageDesign.entity.BaseControl;
import swtech.facade.pageDesign.entity.CascadeClassify;
import swtech.facade.pageDesign.entity.KePuVideo;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.entity.PaiCourse;
import swtech.facade.pageDesign.entity.PushMsg;
import swtech.facade.pageDesign.entity.SearchControl;
import swtech.facade.pageDesign.entity.SortChildren;
import swtech.facade.pageDesign.service.PageDesignOperatorFacade;
import swtech.facade.pageDesign.util.ControlUtil;
import swtech.facade.pageDesign.util.CreatStaticPage;
import swtech.facade.pageDesign.util.FastJsonUtil;
import swtech.facade.pageDesign.util.HttpUtils;
import swtech.facade.pageDesign.util.MobileMsgTemplate;
import swtech.facade.pageDesign.util.MySqlImportAndExport;
import swtech.facade.pageDesign.util.SendMessageUtil;
import swtech.facade.pageDesign.util.TemplateUtil;
import swtech.facade.pageDesign.util.File.Base64ToImage;
import swtech.facade.pageDesign.util.File.CopyFile;
import swtech.facade.pageDesign.util.File.FileUtil;
import swtech.facade.pageDesign.util.File.FormUploadUtil;
import swtech.facade.pageDesign.util.File.GetDataName;
import swtech.facade.pageDesign.util.File.PathReplace;
import swtech.facade.pageDesign.util.File.Pinyin4jUtil;
import swtech.facade.pageDesign.util.File.SSHUtil;
import swtech.facade.pageDesign.util.File.WriteMapper;
import swtech.facade.pageDesign.util.File.invokeUtil;
import swtech.facade.pageDesign.util.Loader.DynamicCompilerUtil;
import swtech.service.pageDesign.biz.PageDesignOperatorBiz;
import swtech.service.pageDesign.dao.NodeDao;
import swtech.service.pageDesign.dao.PageDesignDao;
import swtech.service.pageDesign.dao.TreeNodeDao;
import util.Answer;
import util.BeforeTheSuffix;


@Path("pageDesignOperatorFacade")
@Component("pageDesignOperatorFacade")
@Consumes(MediaType.APPLICATION_XML)
public class PageDesignOperatorFacadeImpl implements PageDesignOperatorFacade {
	@Autowired
	PageDesignOperatorBiz pageDesignOperatorBiz;

	@Autowired
	private NodeDao nodeDao;

	@Autowired
	private PageDesignQueryFacadeImpl pageDesignQueryFacadeImpl;

	@Autowired
	private TreeNodeDao treeNodeDao;

	@Autowired
	private PageDesignDao pageDesignDao;

	private static final Log log = LogFactory.getLog(PageDesignOperatorFacadeImpl.class);
	private static final String savePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

	private static final String token_KEY = "Template_access_token";
	private static final Long timeOut = 2 * 60 * 60 * 1000l;
	private static final String appid = "wxc1236b8d3ed297c5";
	private static final String secret = "342feb2e83aad0c171e1eef7ab1f6553";

	@POST
	@Path("/saveDesignPage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg saveDesignPage(PageEditor pageEditor) {
		ReturnMsg msg = new ReturnMsg();
		//根据保存页面的nodeId,查询该页面有哪些从页面，将该页面内容同样保存进所有的从页面中（该功能用于多数据源发布标识控件）
		List<Integer> slaveIdList = nodeDao.getSlavePageIdByMasterId(pageEditor.getNode_id());
		slaveIdList.add(pageEditor.getNode_id());//将主页面的nodeId也加进去
		for(Integer nId:slaveIdList) {
			//根据slaveId查询该从页面的中文名字
			String slavePageName = nodeDao .getSlavePageNameBySlaveId(nId);
			pageEditor.setNode_id(nId);
			pageEditor.setNode_name(slavePageName);
			
			PageEditor p1 = pageDesignDao.getByNodeId(pageEditor.getNode_id());
			if(p1!=null) {//如果不是第一次创建的话

				if(pageEditor.getShareTo_nodeId()==0){//默认

					pageEditor.setShareTo_name(p1.getShareTo_name());
					pageEditor.setShareTo_nodeId(p1.getShareTo_nodeId());

				} 
				if(pageEditor.getShareTo_nodeId()==-1) {//取消绑定
					pageEditor.setShareTo_name(null);
					pageEditor.setShareTo_nodeId(0);
				}
			}

			JSONArray jsonArray = new JSONArray();
			List<BaseControl> list = pageEditor.getData();
			BaseControl baseControl = new BaseControl();
			SSHUtil ssh = new SSHUtil();
			try {
				// 保存android 页面
				if (pageEditor != null) {
					if (pageEditor.getPhoneParse() != null) {
						// 查询node_id 是否存在
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("node_id", pageEditor.getNode_id());
						// 存在就更新android 页面
						if (pageDesignDao.getCountForNodeId(param) >= 1) {
							// 更新表单数据
							PageEditor page = new PageEditor();
							page = pageDesignDao.getByNodeId(pageEditor.getNode_id());
							if (page != null) {
								page.setPhoneParse(pageEditor.getPhoneParse());
								pageDesignDao.updatePageEditor(page);//曾智宏，sql语句加了字段
								// return new
								// ReturnMsg("0","更新Android页面成功 ！ 哈 你说ios不存在的");
							} else {
								return new ReturnMsg("1", "更新Android页面异常 ！");
							}
						}
					}
				}
				// 截取保存表单数据名
				String param = null;

				if (pageEditor.getParse() != null) {
					param = GetDataName.GetDataName(pageEditor.getParse());
				} else {
					param = GetDataName.GetDataName(pageEditor.getPhoneParse());
				}

				jsonArray = new JSONArray();
				net.sf.json.JSONObject jsonObj = new net.sf.json.JSONObject();
				int value = 1;
				for (int i = 0; i < list.size(); i++) {
					// 获取表头数据
					baseControl = list.get(i);
					String title = baseControl.getTitle();
					jsonArray.add(title);

					// 设置默认表单显示隐藏数据
					if (i >= 10) {
						value = 0;
					}
					String name = list.get(i).getName();
					jsonObj.put(name, value);

				}
				// 表单key value 储存
				pageEditor.setTitle(jsonArray.toJSONString());
				pageEditor.setSelected(jsonObj.toString());

				log.info("对象：" + pageEditor.toString());





				/*曾智宏*/
				if(pageEditor.getShareTo_name()!=null) {
					msg= doSaveShare(pageEditor,ssh,msg,param);
				}else{
					// 中文转为拼音
					String node_name = Pinyin4jUtil.toPinyin(pageEditor.getNode_name());
					node_name = node_name.toLowerCase();
					node_name = captureName(node_name);
					pageEditor.setNode_name(node_name);

					// 根据ID当做名字 防重复
					/*
					 * String node_name = "Swtech"+pageEditor.getNode_id();
					 * pageEditor.setNode_name(node_name);
					 */

					// 清空已有文件
					System.out.print("项目运行当前目录" + PathConstants.TARGET_PATH + node_name + "/");
					ssh.deleteFile(PathConstants.TARGET_PATH + node_name + "/");
					ssh.deleteFile(PathConstants.TARGET_PATH + "SourceImpl.xml");
					ssh.deleteFile(PathConstants.TARGET_PATH + "Source-mybatis-config.xml");
					ssh.deleteFile(PathConstants.TARGET_PATH + "*generatorConfig.xml");
					// 读出Jar配置文件
					// CopyFile.copyFormJar("Source-mybatis-nomapper-config.xml");
					// 储存当前表单文件夹

					CopyFile.copyFormJar("SourceImpl.xml", node_name);
					CopyFile.copyFormJar("Source-mybatis-config.xml", node_name);
					CopyFile.copyFormJar("generatorConfig.xml", node_name);

					// 更换配置地址
					// 动态类名 nodeName
					String nodeName = PathReplace.replaceFile(node_name + "generatorConfig.xml", node_name);
					PathReplace.replaceFile("Source-mybatis-config.xml", null);
					log.info("------nodeName:" + nodeName);
					msg = pageDesignOperatorBiz.savePage(pageEditor);
					if (msg.getStatus() == "1") {
						log.info("节点的名称：" + node_name);
						generator(node_name);

						// 生成mapperImpl.java文件
						// node_name 初始类名 nodeName 新类名
						writeJavaImpl(node_name, nodeName);
						// 生成sqlconfig文件
						writeSqlFactoryConfig(node_name, nodeName);
						// mapper添加方法接口
						WriteMapper.writeMapperFile(node_name, nodeName, param);
						// 储存类名
						WriteMapper.createFile(nodeName, PathConstants.TARGET_PATH + node_name + "/" + node_name + ".sw");

						// 动态编译java类
						ReturnMsg m = DynamicCompilerUtil.compiler(node_name);
						// 热部署 作废
						// CompilerMain.testCompiler(node_name);
						// DynamicUninstallClass.uninstallClass(node_name);

						// 删除自动生成类配置文件
						// ssh.deleteFile(PathConstants.TARGET_PATH + node_name
						// + "generatorConfig.xml");

						/*
						 * -- 5.17作废 生成页面在新建node里面 //生成html String savePaths = savePath
						 * + node_name + "/exportRar/";
						 * ssh.copyFile(PathConstants.EXPORT_RAR, savePaths,"-r");
						 * 
						 * //替换显示页面内容 WriteMapper.Html(savePaths+"index.html",
						 * pageEditor.getNode_id());
						 */
					} else {
						msg.setStatus(Answer.DATA_ISNULL);
						if (msg.getStatus().equals(Answer.DATA_ISNULL)) {
							msg.setMsg("编译表单的java文件时出错！！");
						}
//						msg.setMsg("操作数据库出错");
					}
				}




			} catch (Exception e) {
				e.printStackTrace();
			}
		}



		return msg;
	}




	private ReturnMsg doSaveShare(PageEditor pageEditor, SSHUtil ssh, ReturnMsg msg, String param) throws IOException, InterruptedException {

		//		PageEditor pageEditor2 = pageEditor;//用于同步
		//				pageEditor2.setIsForShare(1);//定义为1


		// 中文转为拼音node_name
		String node_name = Pinyin4jUtil.toPinyin(pageEditor.getNode_name());
		node_name = node_name.toLowerCase();
		node_name = captureName(node_name);
		pageEditor.setNode_name(node_name);

		// 中文转为拼音shareTo_name，不应该现在转换
		String shareTo_name = Pinyin4jUtil.toPinyin(pageEditor.getShareTo_name());
		shareTo_name = shareTo_name.toLowerCase();
		shareTo_name = captureName(shareTo_name);//已是拼音
		//pageEditor.setShareTo_name(shareTo_name);

		//		log.info("==========转成拼音之后=======node_name====="+pageEditor.getNode_name());
		//		log.info("==========转成拼音之后=======shareTo_name====="+pageEditor.getShareTo_name());

		// 清空已有文件
		System.out.print("项目运行当前目录" + PathConstants.TARGET_PATH + shareTo_name + "/");
		ssh.deleteFile(PathConstants.TARGET_PATH + shareTo_name + "/");
		ssh.deleteFile(PathConstants.TARGET_PATH + "SourceImpl.xml");
		ssh.deleteFile(PathConstants.TARGET_PATH + "Source-mybatis-config.xml");
		ssh.deleteFile(PathConstants.TARGET_PATH + "*generatorConfig.xml");
		// 读出Jar配置文件
		// CopyFile.copyFormJar("Source-mybatis-nomapper-config.xml");
		// 储存当前表单文件夹

		CopyFile.copyFormJar("SourceImpl.xml", shareTo_name);
		CopyFile.copyFormJar("Source-mybatis-config.xml", shareTo_name);
		CopyFile.copyFormJar("generatorConfig.xml", shareTo_name);

		// 更换配置地址
		// 动态类名 nodeName
		String shareToName = PathReplace.replaceFile(shareTo_name + "generatorConfig.xml", shareTo_name);
		PathReplace.replaceFile("Source-mybatis-config.xml", null);
		//		log.info("-----动态类名-shareToName:" + shareToName);
		msg = pageDesignOperatorBiz.savePage(pageEditor);
		if (msg.getStatus() == "1") {
			//			log.info("节点的名称：" + shareTo_name);
			generator(shareTo_name);

			// 生成mapperImpl.java文件
			// node_name 初始类名 nodeName 新类名
			writeJavaImpl(shareTo_name, shareToName);
			// 生成sqlconfig文件
			writeSqlFactoryConfig(shareTo_name, shareToName);
			// mapper添加方法接口
			WriteMapper.writeMapperFile(shareTo_name, shareToName, param);
			// 储存类名
			WriteMapper.createFile(shareToName, PathConstants.TARGET_PATH + shareTo_name + "/" + shareTo_name + ".sw");

			// 动态编译java类
			ReturnMsg m = DynamicCompilerUtil.compiler(shareTo_name);


		} else {
			msg.setStatus(Answer.DATA_ISNULL);
			if (msg.getStatus().equals(Answer.DATA_ISNULL)) {
				msg.setMsg("编译表单的java文件时出错！！");
			}
			msg.setMsg("操作数据库出错");
		}
		/*曾智宏*/
		return msg;


	}

	private String getFileStr(String fileName) {
		File sourceFile = new File(fileName);
		// log.info("sql的文件大小："+sourceFile.length());
		StringBuffer sb = new StringBuffer();
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
			s = sb.toString();
		} catch (Exception e) {

		}
		return s;
	}

	private void writeSqlFactoryConfig(String node_name, String nodeName) {
		File sourceFile = new File(savePath + "Source-mybatis-config.xml");
		// log.info("sql的文件大小："+sourceFile.length());
		StringBuffer sb = new StringBuffer();
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
			s = sb.toString();
			s = s.replace("{mapperPath}", "/" + node_name + "/" + nodeName + "Mapper.xml");
			// 保存文件
			// log.info("sql的字符串："+s);
			File newFile = new File(PathConstants.TARGET_PATH + node_name + "/" + nodeName + "-mybatis-config.xml");
			FileOutputStream fos = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			bos.write(s.getBytes());
			br.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void writeNoMapperSqlFactoryConfig(String node_name) {
		File sourceFile = new File(savePath + "Source-mybatis-nomapper-config.xml");
		// log.info("sql的文件大小："+sourceFile.length());
		StringBuffer sb = new StringBuffer();
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
			s = sb.toString();
			// 保存文件
			// log.info("sql的字符串："+s);
			File newFile = new File(
					PathConstants.TARGET_PATH + node_name + "/" + node_name + "-mybatis-nomapper-config.xml");
			FileOutputStream fos = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(s.getBytes());
			br.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void writeJavaImpl(String node_name, String nodeName) {
		File sourceFile = new File(savePath + "SourceImpl.java");
		// log.info("impl的文件大小："+sourceFile.length());
		StringBuffer sb = new StringBuffer();
		String s = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(sourceFile));
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}
			s = sb.toString();

			s = s.replace("{className}", nodeName);
			s = s.replace("{className1}", node_name);
			// log.info("impl的字符串："+s);
			// 保存文件
			File newFile = new File(PathConstants.TARGET_PATH + node_name + "/" + nodeName + "MapperImpl.java");

			FileOutputStream fos = new FileOutputStream(newFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			bos.write(s.getBytes());
			br.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void generator(String node_name) throws IOException {

		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;

		// 加载配置文件
		String pathString = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		File file = new File(PathConstants.TARGET_PATH + node_name + "generatorConfig.xml");
		// log.info("文件的大小是：" + file.length());
		// operatorXml(node_name, file);
		ConfigurationParser cp = new ConfigurationParser(warnings);
		try {
			Configuration config = cp.parseConfiguration(file);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void operatorXml(String node_name, File file) throws IOException {
		// URL url = this.getClass().getResource("/spring/generatorConfig.xml");
		// URLConnection urlConnection = url.openConnection();
		Document doc = null;
		try {
			SAXReader reader = new SAXReader();
			InputStream inputStream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
			doc = reader.read(br);
			Element rootElement = doc.getRootElement();

			Element javaModelGeneratorElement = (Element) rootElement
					.selectSingleNode("/generatorConfiguration/context/javaModelGenerator");
			Attribute modelAttribute = javaModelGeneratorElement.attribute("targetPackage");
			modelAttribute.setValue(node_name);
			Element sqlMapGeneratorElement = (Element) rootElement
					.selectSingleNode("/generatorConfiguration/context/sqlMapGenerator");
			Attribute sqlAttribute = sqlMapGeneratorElement.attribute("targetPackage");
			sqlAttribute.setValue(node_name);
			Element javaClientGeneratorElement = (Element) rootElement
					.selectSingleNode("/generatorConfiguration/context/javaClientGenerator");
			Attribute javaAttribute = javaClientGeneratorElement.attribute("targetPackage");
			javaAttribute.setValue(node_name);

			Element tableElement = (Element) rootElement.selectSingleNode("/generatorConfiguration/context/table");
			Attribute tableName = tableElement.attribute("tableName");

			tableName.setValue(node_name);

			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			OutputStream out = new FileOutputStream(file);
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(doc); // 向流写入数据
			inputStream.close();
			br.close();
			out.close();
			writer.close(); // 关闭流

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private SqlSessionFactory sqlSessionFactory;


	@POST
	@Path("/insertFormRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg insertFormRecord(String record) {
		//		log.info("+++============================");
		ReturnMsg msg = new ReturnMsg();
		try {

			PageEditor pageEditor = getShareToNameAndShareToNodeId(record);

			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			String className = jsonObj.getString("classname");

			String shareTo_name = pageEditor.getShareTo_name();//曾智宏
			int shareTo_nodeId = pageEditor.getShareTo_nodeId();//曾智宏
			if(shareTo_name!=null) {//曾智宏
				className = shareTo_name;
				//				log.info("=======应该是中文===从数据库查出该页面是有绑定页面的，所以我将className改掉========================"+className);
			}

			String recordStr = jsonObj.getString("record");

			if(shareTo_name!=null) {//曾智宏
				//				log.info("==========进入replaceNodeId方法之前========================");
				recordStr = replaceNodeId(recordStr,shareTo_nodeId);
				//				log.info("==========进入replaceNodeId方法之后========================");
			}


			FastJsonUtil fju=new FastJsonUtil();
			String sw=BeforeTheSuffix.Prefix;
			LinkedHashMap map=new LinkedHashMap();

			recordStr=fju.JsonFormatterAddPrefix(recordStr,sw,map);//19.5.29 因出现轮播图，图片显示等情况将此段注释，曾智宏

			String userAccount = jsonObj.getString("user_account");

			JSONObject json = JSONObject.parseObject(recordStr);
			String methodStr = jsonObj.getString("method");

			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);
			for(String a:arr) {
				log.info("=======获取动态类名字============="+a);
			}
			// 包含图片格式
			if (jsonObj.getString("src") != null) {
				String src = jsonObj.getString("src");
				// 获取包含图片base64的保存key
				String[] s = src.split(",");
				for(int i=0;i<s.length;i++){
					s[i]=sw+s[i];
				}
				// 遍历转换
				for (int i = 0; i < s.length; i++) {
					// 如果是图片控件 base64 转图片
					String empty = json.getString(s[i]);
					if (empty != null && !empty.equals("http://")) {
						SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
						Date date = new Date();
						String format = sf.format(date);
						File fileimg =new File(HostConstants.FILE_PATH+"img");
						//如果文件夹不存在则创建 
						if (!fileimg.exists() && !fileimg.isDirectory()) {    
							fileimg.mkdir(); 
						}
						String tempFileName = HostConstants.FILE_PATH +"img/"+ format + "/";
						log.info("====================存放目录:===========================" + tempFileName);
						long time = new Date().getTime();
						Base64ToImage.GenerateImageTwo(empty, tempFileName, time);
						String saveFilePath = tempFileName + "SW_" + time + ".png";
						json.put(s[i], saveFilePath.replace(HostConstants.FILE_PATH, "/folder/").trim());
						log.info("=========insertFormRecord的替换后的文件路径:"
								+ saveFilePath.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST).trim());
					} 
					else
						json.put(s[i], "");

				}
			} else {

				//				log.info("-------------没 ---------------------------");
			}

			try {

				// 单条数据传回 false
				log.info("=====arr[0] + \".\" + arr[1]========" + arr[0] + "." + arr[1]);
				Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, parmetercls);// 方法名和对应的参数类型
				log.info("==============method=============="+method);
				Object o = null;
				if (jsonObj.getString("src") != null) {
					log.info("-============json.toString()======="+json.toString());
					o = method.invoke(obj, JSONObject.parseObject(json.toString(), parmetercls));// 调用得到的上边的方法method
				} else {
					log.info("============recordStr================"+recordStr);
					o = method.invoke(obj, JSONObject.parseObject(recordStr, parmetercls));// 调用得到的上边的方法method
					log.info("============o是什么？================"+o);
				}

				if (o != null) {

					try {
						// 获取数据发送微信推送、
						JSONObject data = jsonObj.getJSONObject("record");

						if (data.containsKey("msgflag") && !data.getInteger("msgflag").equals("")) {
							jointTemplateMsg(data);
						}

					} catch (Exception e) {
						e.printStackTrace();
						msg.setMsg(o);
						msg.setStatus(Answer.ERR_MSG);
						msg.setStatusMsg("推送失败！");
					}
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("单条数据插入成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("单条数据插入异常！");

				}
			} catch (Exception e) {
				e.printStackTrace();
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg(e.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("插入失败！");
			msg.setMsg(e.toString());
		}

		return msg;
	}





	private String replaceNodeId(String recordStr, int shareTo_nodeId) {
		JSONObject recordStrJson = JSONObject.parseObject(recordStr);
		recordStrJson.put("node_id", shareTo_nodeId);
		recordStr = recordStrJson.toString();
		//		log.info("========我将record中node_id替换之后的recordStr============="+recordStr);
		return recordStr;

	}

	private PageEditor getShareToNameAndShareToNodeId(String record) {
		JSONObject jsonObj = new JSONObject();
		jsonObj = JSONObject.parseObject(record);

		String classname = jsonObj.getString("classname");
		//		log.info("==========有没有接收到classname这个值==================="+classname);
		Integer node_id =nodeDao.getIdByNodeName(classname);//通过nodeId查出来的pageEditor
		//		log.info("==========//通过classname查ht_node表的node_id==================="+node_id);

		PageEditor pageEditor = pageDesignDao.getByNodeId(node_id);//通过nodeId查出来的pageEditor
		//		log.info("==========//通过nodeId查出来的pageEditor==================="+pageEditor);
		String shareTo_name = pageEditor.getShareTo_name();//从数据库查出来该页面的shareTo_name
		//		log.info("==========//从数据库查出来该页面的shareTo_name==================="+shareTo_name);
		int shareTo_nodeId = pageEditor.getShareTo_nodeId();//从数据库查出来该页面的shareTo_nodeId
		//		log.info("==========从数据库查出来该页面的shareTo_nodeId==================="+shareTo_nodeId);

		return pageEditor;
	}

	private String checkColumn(String recordStr, String shareToName) {

		//中文转拼音
		shareToName = Pinyin4jUtil.toPinyin(shareToName);
		shareToName = shareToName.toLowerCase();
		shareToName = captureName(shareToName);
		//		log.info("让我看看这个shareToname有什么问题"+shareToName);



		JSONObject recordStrJson = JSONObject.parseObject(recordStr);
		String[] recordStrSplit = recordStr.split(",");

		for(String r:recordStrSplit) {
			System.out.println("分割之后"+r);
		}
		for(int i=0;i<recordStrSplit.length;i++) {
			int index = recordStrSplit[i].indexOf(":");
			if(i==0) {
				String column = recordStrSplit[i].trim().substring(2, index-1);
				System.out.println("减掉：之后"+column);
				log.info("减掉：之后"+column);
				if(!column.equals("isDelete")&&!column.equals("swprefixuId")&&!column.equals("swprefixnode_id")) {

					int checkColumn = pageDesignOperatorBiz.checkColumn(column,shareToName);
					if(checkColumn==0) {
						recordStrJson.remove(column);
					}

				}
			} else {
				String column = recordStrSplit[i].trim().substring(1, index-2);
				System.out.println("减掉：之后"+column);
				log.info("减掉：之后"+column);
				if(!column.equals("isDelete")&&!column.equals("swprefixuId")&&!column.equals("swprefixnode_id")) {
					int checkColumn = pageDesignOperatorBiz.checkColumn(column,shareToName);
					if(checkColumn==0) {
						recordStrJson.remove(column);
					}
				}
			}
		}

		recordStr = recordStrJson.toString();



		return recordStr;


	}

	@POST
	@Path("/deleteFormRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg deleteFormRecord(String record) {
		ReturnMsg msg = new ReturnMsg();


		try {
			//			log.info("===========进入getPageEditorf方法之前============");			
			PageEditor page123 = getPageEditor(record);//曾智宏
			//			log.info("===========进入getPageEditorf方法之前============");	

			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			//			log.info("==============前端传入的record转换成jsonObj==============="+jsonObj);
			String className = jsonObj.getString("classname");
			//			log.info("==============从jsonobj中取出的className==============="+className);
			if(page123.getShareTo_name()!=null) {//曾智宏
				className = page123.getShareTo_name();
				//				log.info("===========改className============"+className);
			}
			long recordLo = jsonObj.getLongValue("record");
			//			log.info("==============从jsonobj中取出的recordLo，这是一个long类型==============="+recordLo);
			String methodStr = jsonObj.getString("method");
			//			log.info("==============从jsonobj中取出的methodStr==============="+methodStr);

			Map<String, Object> map = new HashMap<String, Object>();

			// 表单名 转换
			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);
			for(String a :arr) {
				log.info("=========这是获取到的动态类名字a[]==========="+a);
			}

			Integer flag = jsonObj.getInteger("flag");
			log.info("===========从jsonObj中获取到的flag，是一个integer类型=================="+flag);
			// 删除判断
			if (flag == 0) {
				// 完全删除
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, long.class);// 方法名和对应的参数类型
				Object o = method.invoke(obj, recordLo);// 调用得到的上边的方法method

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("完全删除成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("完全删除异常！");
				}

			} else if (flag == 1) {
				// 临时删除
				map.put("bl", flag);
				map.put("id", recordLo);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, Map.class);// 方法名和对应的参数类型
				Object o = method.invoke(obj, map);// 调用得到的上边的方法method

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("回收删除成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("回收删除异常！");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("删除失败！");
		}

		return msg;
	}



	@POST
	@Path("/deleteArray")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg deleteArray(String record) {
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			log.info("===========进入getPageEditorf方法之前============");			
			PageEditor page123 = getPageEditor(record);//曾智宏
			log.info("===========进入getPageEditorf方法之后============");	
			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			String className = jsonObj.getString("classname");
			if(page123.getShareTo_name()!=null) {//曾智宏
				className = page123.getShareTo_name();
				log.info("===========改className============"+className);
			}

			String ids = jsonObj.getString("record");
			String methodStr = jsonObj.getString("method");

			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);

			Integer flag = jsonObj.getInteger("flag");
			if (flag == 0) {
				// 转为数组
				int[] array = StringtoInt(ids);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, int[].class);// 方法名和对应的参数类型
				Object o = method.invoke(obj, new Object[] { array });// 调用得到的上边的方法method

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("删除多个成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("删除多个异常！");
				}
			} else if (flag == 1) {
				// 转为数组
				int[] array = StringtoInt(ids);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, int[].class);// 方法名和对应的参数类型
				Object o = method.invoke(obj, new Object[] { array });// 调用得到的上边的方法method

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("删除多个成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("删除多个异常！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("删除多个失败！");
		}

		return msg;
	}

	@POST
	@Path("/reNewData")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg reNewData(String record) {
		ReturnMsg msg = new ReturnMsg();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			String className = jsonObj.getString("classname");
			String ids = jsonObj.getString("record");
			String methodStr = jsonObj.getString("method");

			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);

			int[] array = StringtoInt(ids);
			if (array.length == 1) {

				// 恢复一条数据
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				Method method = cls.getMethod(methodStr, int.class);// 方法名和对应的参数类型
				Object o = method.invoke(obj, array[0]);// 调用得到的上边的方法method

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("恢复成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("恢复异常！");
				}

			} else if (array.length > 1) {
				// 恢复多条数据
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				// 初始化一个实例
				Object obj = cls.newInstance();
				// 方法名和对应的参数类型
				Method method = cls.getMethod(methodStr, int[].class);
				// 调用得到的上边的方法method
				Object o = method.invoke(obj, new Object[] { array });

				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("恢复多条成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("恢复多条异常！");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("恢复失败！");
		}

		return msg;
	}

	@POST
	@Path("/updateFormRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updateFormRecord(String record) {
		ReturnMsg msg = new ReturnMsg();
		try {

			//			log.info("===========进入getPageEditorf方法之前============");			
			PageEditor page123 = getPageEditor(record);//曾智宏
			//			log.info("===========进入getPageEditorf方法之前============");	



			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			String className = jsonObj.getString("classname");

			if(page123.getShareTo_name()!=null) {//曾智宏
				className = page123.getShareTo_name();
				//				log.info("===========改className============"+className);
			}

			String recordStr = jsonObj.getString("record");
			log.info("参数============"+recordStr);

			if(page123.getShareTo_name()!=null) {//曾智宏
				//				log.info("==========进入replaceNodeId方法之前========================");
				recordStr = replaceNodeId(recordStr,page123.getShareTo_nodeId());
				//				log.info("==========进入replaceNodeId方法之后========================");
			}



			FastJsonUtil fju=new FastJsonUtil();
			String sw=BeforeTheSuffix.Prefix;
			LinkedHashMap map=new LinkedHashMap();
			recordStr=fju.JsonFormatterAddPrefix(recordStr,sw,map);
			String methodStr = jsonObj.getString("method");

			JSONObject recordStrObj = JSONObject.parseObject(recordStr);
			if(jsonObj.getString("src") != null){
				String src = jsonObj.getString("src");
				String empty=recordStrObj.getString(sw+src);
				if(empty !=null&&!empty.equals("http://")){
					SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM");
					Date date =new Date();
					String format = sf.format(date);
					String tempFileName=HostConstants.FILE_PATH+format+"/";
					long time=new Date().getTime();
					Base64ToImage.GenerateImageTwo(empty, tempFileName, time);
					String saveFilePath=tempFileName +"SW_"+time+".png";
					log.info("===============saveFilePath:========" + saveFilePath);
					recordStrObj.put(sw+src, saveFilePath.replace(HostConstants.FILE_PATH, "/folder/").trim());
					recordStr=recordStrObj.toString();
					log.info("===============recordStr:========" + recordStr);
				}
			}
			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);

			try {

				/*JSONObject parmObj = JSONObject.parseObject(recordStr);*/
				Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
				Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
				Object obj = cls.newInstance();// 初始化一个实例
				log.info("recordStr======:"+recordStr);
				log.info("对象======:"+JSONObject.parseObject(recordStr, parmetercls));
				Method method = cls.getMethod(methodStr, parmetercls);// 方法名和对应的参数类型
				Object o = method.invoke(obj, JSONObject.parseObject(recordStr, parmetercls));// 调用得到的上边的方法method
				msg.setMsg(o);
				if (o != null) {
					msg.setMsg(o);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("更新成功！");
				} else {
					msg.setMsg(o);
					msg.setStatus(Answer.ERR_MSG);
					msg.setStatusMsg("更新异常！");
				}
			} catch (Exception e) {
				e.printStackTrace();
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg("更新失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("更新失败！");
		}

		return msg;
	}

	@POST
	@Path("/selectFormRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg selectFormRecord(String record) {
		ReturnMsg msg = new ReturnMsg();
		Object o = null;
		try {
			//			log.info("===========进入getPageEditorf方法之前============");			
			PageEditor page123 = getPageEditor(record);//曾智宏
			//			log.info("===========进入getPageEditorf方法之前============");	

			// 格式化类名
			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);
			String className = jsonObj.getString("classname");

			if(page123.getShareTo_name()!=null) {//曾智宏
				className = page123.getShareTo_name();
				log.info("========该页面有绑定，修改className============="+className);
			}

			String methodone = jsonObj.getString("method");
			log.info("==============method是:=========================="+methodone);
			log.info("==============jsonObj现在是：=========tableName================="+jsonObj.getString("tableName"));
			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);
			for(String a:arr) {
				log.info("========获取动态类名字============"+a);
			}
			// getById
			long id = 0;
			Integer b = null;
			if (jsonObj.getLong("node_id") != null) {
				id = jsonObj.getLong("node_id");
				b = 1;
			}

			// selectList
			long recordLo = 0;
			if (jsonObj.getString("record") != null) {
				recordLo = jsonObj.getLongValue("record");
				b = 2;
			}

			// searchKey
			String searchKey = null;
			if (jsonObj.getString("searchValue") != null) {

				b = 3;
			}

			// searchAllKey
			String str = null;
			if (jsonObj.getString("searchAllKey") != null) {
				str = jsonObj.getString("searchAllKey");
				b = 4;
			}

			// 方法名
			String methodStr = jsonObj.getString("method");

			// searchIsDelete
			if (jsonObj.getString("method").equals("searchIsDelete")) {
				b = 5;
			}
			// selectListone
			if (jsonObj.getString("method").equals("getQueryPage")) {
				b = 6;
			}
			log.info("==============b现在是：=========================="+b);
			try {

				PageEditor page = pageDesignOperatorBiz.selectPage(id);
				log.info("现在的pageEditor:==============================="+page);
				JSONArray jsonArray = new JSONArray();
				JSONObject jsonObject = new JSONObject();
				Map<String, Object> map = new HashMap<String, Object>();
				String nodeName = nodeDao.getNameByNodeId(jsonObj.getLong("node_id"));
				if (b == 1) {

					Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
					log.info("=========cls===" + cls.getName());
					Constructor con = cls.getConstructor();
					Object obj = con.newInstance();// 初始化一个实例
					Method method = cls.getMethod(methodStr);// 方法名和对应的参数类型
					o = method.invoke(obj);// 调用得到的上边的方法method

					String jsonString = FastJsonUtil.toJSONString(o);
					String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
					log.info("=============jsonString==========="+jsonString);
					Object parse = JSONArray.parse(replaceAll);
					map.put("data", parse);
					if (page != null) {
						jsonArray = JSONArray.parseArray(page.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						map.put("title", jsonArray);
						map.put("selected", page.getSelected());
					}
					msg.setMsg(map);
					msg.setStatus(Answer.SUCCESS_MSG);
					msg.setStatusMsg("查询全部数据成功！");
				} else if (b == 2) {

					Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
					Object obj = cls.newInstance();// 初始化一个实例
					Method method = cls.getMethod(methodStr, long.class);// 方法名和对应的参数类型
					o = method.invoke(obj, recordLo);// 调用得到的上边的方法method
					String jsonString = FastJsonUtil.toJSONString(o);
					String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
					log.info("=============jsonString==========="+jsonString);
					Object parse = JSONArray.parse(replaceAll);
					map.put("data", parse);
					if (page != null) {
						jsonArray = JSONArray.parseArray(page.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						map.put("title", jsonArray);
						map.put("selected", page.getSelected());
					}
					if (o != null) {
						msg.setMsg(map);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("查询全部数据成功！");
					} else {
						msg.setMsg(map);
						msg.setStatus(Answer.ERR_MSG);
						msg.setStatusMsg("查询全部数据异常！");
					}
				} else if (b == 3) {
					// 凭接成一个jsonobject 对象
					JSONObject json = new JSONObject();
					json.put(jsonObj.getString("searchKey"), jsonObj.getString("searchValue"));

					Class parmetercls = Class.forName(arr[0] + "." + arr[1]);
					Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
					Object obj = cls.newInstance();// 初始化一个实例

					Method method = cls.getMethod(methodStr, parmetercls);// 方法名和对应的参数类型
					o = method.invoke(obj, JSONObject.parseObject(json.toString(), parmetercls));// 调用得到的上边的方法method
					String jsonString = FastJsonUtil.toJSONString(o);
					String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
					log.info("=============jsonString==========="+jsonString);
					Object parse = JSONArray.parse(replaceAll);
					map.put("data", parse);
					if (page != null) {
						jsonArray = JSONArray.parseArray(page.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						map.put("title", jsonArray);
						map.put("selected", page.getSelected());
					}

					if (o != null) {
						msg.setMsg(map);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("搜索该字段包含该关键字内容成功！");
					} else {
						msg.setMsg(map);
						msg.setStatus(Answer.ERR_MSG);
						msg.setStatusMsg("搜索该字段包含该关键字内容异常！");
					}
				} else if (b == 4) {

					Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
					Object obj = cls.newInstance();// 初始化一个实例
					Method method = cls.getMethod(methodStr, String.class);// 方法名和对应的参数类型
					o = method.invoke(obj, str);// 调用得到的上边的方法method
					log.info("================o4为：=============" + o);
					String jsonString = FastJsonUtil.toJSONString(o);
					String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
					log.info("=============jsonString==========="+jsonString);
					Object parse = JSONArray.parse(replaceAll);
					map.put("data", parse);
					if (page != null) {
						jsonArray = JSONArray.parseArray(page.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						map.put("title", jsonArray);
						map.put("selected", page.getSelected());
					}

					if (o != null) {
						msg.setMsg(map);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("搜索全部字段包含该关键字内容成功！");
					} else {
						msg.setMsg(map);
						msg.setStatus(Answer.ERR_MSG);
						msg.setStatusMsg("搜索全部字段包含该关键字内容异常！");
					}
				} else if (b == 5) {

					Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
					Object obj = cls.newInstance();// 初始化一个实例
					Method method = cls.getMethod(methodStr);// 方法名和对应的参数类型
					o = method.invoke(obj);// 调用得到的上边的方法method
					log.info("================o5为：=============" + o);
					String jsonString = FastJsonUtil.toJSONString(o);
					String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
					log.info("=============jsonString==========="+jsonString);
					Object parse = JSONArray.parse(replaceAll);
					map.put("data", parse);
					if (page != null) {
						jsonArray = JSONArray.parseArray(page.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						map.put("title", jsonArray);
						map.put("selected", page.getSelected());
					}

					if (o != null) {
						msg.setMsg(map);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("查询回收站成功！");
					} else {

						msg.setMsg(map);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("查询回收站成功！");
					}
				}else if(b==6){

					JSONArray jsonArraya = new JSONArray();
					JSONObject jsonObjecta = new JSONObject();
					jsonObjecta=JSONObject.parseObject(record);
					Long nodeId = jsonObjecta.getLong("node_id");
					PageEditor pagea = pageDesignOperatorBiz.selectPage(nodeId);
					Map<String, Object> mapa = new HashMap<String, Object>();
					String nodeNamea = nodeDao.getNameByNodeId(nodeId);
					log.info("==========外部数据源？？什么鬼啊=======nodeNamea====="+nodeNamea);
					Map<String, Object> maps = new HashMap<String, Object>();
					Integer pageNum = jsonObjecta.getInteger("page");
					Integer pageSize = jsonObjecta.getInteger("pagesize");
					String orderByClause = jsonObjecta.getString("orderby");
					String classname = jsonObjecta.getString("classname");
					log.info("=======不知道为什么有重新取出来====他是可能是外部数据源======classname=========="+classname);

					/*if(page123.getShareTo_name()!=null) {//曾智宏
						classname = page123.getShareTo_name();
						log.info("====在b=6里面====该页面有绑定，修改className============="+className);
					}*/


					List<KePuVideo> kpQueryPage=null;
					List<PaiCourse> paiCourse=null;
					// 从哪个ID开始分页查询
					Integer pages= 0;
					// 总页数
					Integer totalPages = 0;
					// 记录总数
					Integer count = 0;

					// 判断页码是否为空 或者为0
					if (pageNum > 1 && pageNum != null) {
						pages = (pageNum-1) * pageSize;
					} else {
						pages = 0;
					}

					// 设置数据库查询字段
					maps.put("page", pages);
					maps.put("pageSize", pageSize);
					maps.put("orderByClause", orderByClause);
					if (jsonObjecta.getString("table_field_all")!=null) {
						String table_field_all=BeforeTheSuffix.Prefix+jsonObjecta.getString("table_field_all");
						maps.put("tableFieldAll",table_field_all);
						log.info("===============table_field_all"+table_field_all);
					}

					if (jsonObjecta.getString("searchContent")!=null) {
						String searchContent=jsonObjecta.getString("searchContent");
						maps.put("searchContent",searchContent);
						log.info("============searchContent++++++=="+maps);
					}

					//判断是否是内部数据源
					if(classname.equals("科普视频资源库")){
						kpQueryPage = pageDesignDao.getKPQueryPage(maps);
						mapa.put("data", kpQueryPage);
						log.info("===============此时列表为："+kpQueryPage.toString());
						count = pageDesignDao.getKPCount();
						mapa.put("count", count);
						if (count >= 1) {
							// 求余等于0 或不等于0 页码加1
							totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
						} else {
							totalPages = count;
						}
						mapa.put("totalPages", totalPages);
					}if(classname.equals("排课管理")){
						paiCourse = pageDesignDao.getPaiCourseQueryPage(maps);
						mapa.put("data", paiCourse);
						log.info("===============此时列表为："+paiCourse.toString());
						count = pageDesignDao.getPaiCourseCount();
						mapa.put("count", count);
						if (count >= 1) {
							// 求余等于0 或不等于0 页码加1
							totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
						} else {
							totalPages = count;
						}
						mapa.put("totalPages", totalPages);
					}else{
						//外部数据源
						System.out.print("========nodeName======" + nodeNamea);

						if(page123.getShareTo_name()!=null) {//曾智宏
							nodeNamea = page123.getShareTo_name();
							log.info("====在b=6的外部数据源的判断中====该数据源有绑定，修改nodeNamea============="+nodeNamea);
						}




						String[] arrs = WriteMapper.writeNodeName(nodeNamea);
						Class cls = Class.forName(arrs[0] + "." + arrs[1] + "MapperImpl");
						// 获取实体类
						Object obj = cls.newInstance();// 初始化一个实例
						Method method = cls.getDeclaredMethod(methodone, Map.class);// 方法名和对应的参数类型
						o = method.invoke(obj, maps);// 调用得到的上边的方法method
						String jsonString = FastJsonUtil.toJSONString(o);
						String replaceAll = jsonString.replaceAll(BeforeTheSuffix.Prefix, "");
						Object parse = JSONArray.parse(replaceAll);
						mapa.put("data", parse);
						// 获取页码
						//method = cls.getMethod("getCount");
						method = cls.getMethod("getCountByQuery", Map.class);
						o = method.invoke(obj,maps);
						mapa.put("count", o);
						count = Integer.valueOf(o.toString());
						if (count >= 1) {
							// 求余等于0 或不等于0 页码加1
							totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
						} else {
							totalPages = count;
						}

						mapa.put("totalPages", totalPages);

						log.info("================o6为：=============" + o);
					}
					if (pagea != null) {
						jsonArraya = JSONArray.parseArray(pagea.getTitle());
						//jsonObject = JSONObject.parseObject(page.getSelected());
						mapa.put("title", jsonArraya);
						mapa.put("selected", pagea.getSelected());
						log.info("================最终查询结果===============："+mapa);
					}

					if (o != null||kpQueryPage!=null) {
						msg.setMsg(mapa);
						msg.setStatus(Answer.SUCCESS_MSG);
						msg.setStatusMsg("列表查询成功！");
					} else {

						msg.setMsg(mapa);
						msg.setStatus(Answer.ERR_MSG);
						msg.setStatusMsg("列表为空！");
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg("查询失败！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败！");
		}

		return msg;
	}

	private PageEditor getPageEditor(String record) {

		JSONObject recordJson = JSONObject.parseObject(record);//再将recordStr变成json
		//		log.info("==========//再将recordStr变成json==================="+recordJson);
		String classname = recordJson.getString("classname");//获取传入record中的classname;
		//		log.info("==========//获取传入record中的classname;==================="+classname);
		PageEditor pageEditor = null;
		if(classname!=null) {
			Integer node_id =nodeDao.getIdByNodeName(classname);//通过nodeId查出来的pageEditor
			//			log.info("==========//通过classname查出来的node_id==================="+node_id);
			pageEditor = pageDesignDao.getByNodeId(node_id);
			//			log.info("==========//通过nodeId查出来的pageEditor==================="+pageEditor);
			String shareTo_name = pageEditor.getShareTo_name();//从数据库查出来该页面的shareTo_name
			//			log.info("==========//从数据库查出来该页面的shareTo_name==================="+shareTo_name);
			int shareTo_nodeId = pageEditor.getShareTo_nodeId();//从数据库查出来该页面的shareTo_nodeId
			//			log.info("==========从数据库查出来该页面的shareTo_nodeId==================="+shareTo_nodeId);
		}
		return pageEditor;
	}

	@POST
	@Path("getDataSource")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getDataSource(String data) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {
			// 结果
			Object o = null;
			Map<String, Object> map = new HashMap<String, Object>();
			// 格式化类名
			JSONObject jsonObj = JSONObject.parseObject(data);
			// 类名
			String className = jsonObj.getString("node_name");

			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);

			// 获取nodeId
			Integer nodeId = jsonObj.getInteger("node_id");
			String field = jsonObj.getString("field");
			String[] fields = field.split("`");
			String[] str;

			// 获取字段标题
			Map<String, Object> maps = new HashMap<String, Object>();
			PageEditor page = pageDesignDao.getByNodeId(nodeId);
			Map<String, Object> maps1 = new HashMap<String, Object>();
			if (page != null) {
				JSONArray jsonArray = JSONArray.parseArray(page.getTitle());
				JSONObject jsonObject = JSONObject.parseObject(page.getSelected());
				int k = 1;
				for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
					// log.info(entry.getKey() + ":" +
					// entry.getValue());
					maps.put("text", jsonArray.get(k - 1));
					maps.put("value", entry.getKey());
					maps1.put(k + "", maps);
					maps = new HashMap<String, Object>();
					k++;
				}
			}

			// 拼接查询字符串
			String sql = "SELECT * FROM " + arr[0] + "";
			if (fields.length >= 1) {
				for (int i = 0; i < fields.length; i++) {
					if (i == 0) {
						str = fields[i].split(",");
						sql += " WHERE " + str[0] + "*1 " + tihuan(str[1]) + " " + str[2];
					} else {
						str = fields[i].split(",");
						sql += " AND " + str[0] + "*1 " + tihuan(str[1]) + " " + str[2];
					}
				}

				// 调用执行sql语句
				o = invokeUtil.invoke(jsonObj.getString("node_name"), sql);

				map.put("data", o);
				map.put("fields", maps1);
				msg.setMsg(map);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("获取报表成功");
			} else {
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg("获取报表失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("获取报表失败");
		}
		return msg;
	}

	@POST
	@Path("/getQueryPage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getQueryPage(String record) {
		ReturnMsg msg = new ReturnMsg();
		try {

			// 获取json数据
			JSONObject jsonObj = new JSONObject();
			jsonObj = JSONObject.parseObject(record);

			// 节点名 处理 中文转拼音
			String className = jsonObj.getString("classname");

			// 获取动态类名字
			String[] arr = WriteMapper.writeNodeName(className);

			// 方法名
			String methodStr = jsonObj.getString("method");
			// 参数
			String recordStr = jsonObj.getString("record");
			FastJsonUtil fju=new FastJsonUtil();
			String sw=BeforeTheSuffix.Prefix;
			LinkedHashMap linkmap=new LinkedHashMap();
			recordStr=fju.JsonFormatterAddPrefix(recordStr,sw,linkmap);
			// 表单ID
			Integer nodeId = jsonObj.getInteger("node_id");

			JSONObject json = JSONObject.parseObject(recordStr);
			Map<String, Object> map = new HashMap<String, Object>();

			// 页码
			Integer pageNum = json.getInteger("pageNum");
			// 最大显示数据条数
			Integer pageSize = json.getInteger("pageSize");
			// 从哪个ID开始分页查询
			Integer page = 0;
			// 总页数
			Integer totalPages = 0;
			// 记录总数
			Integer count = 0;

			// 判断页码是否为空 或者为0
			if (pageNum != 0 && pageNum != null) {
				page = pageNum * pageSize;
			} else {
				page = 0;
			}

			// 设置数据库查询字段
			map.put("page", page);
			map.put("pageSize", pageSize);

			// 获取mapper实现类
			Class cls = Class.forName(arr[0] + "." + arr[1] + "MapperImpl");
			// 获取实体类
			Object obj = cls.newInstance();// 初始化一个实例
			Method method = cls.getMethod(methodStr, Map.class);// 方法名和对应的参数类型
			Object o = method.invoke(obj, map);// 调用得到的上边的方法method
			map.put("data", o);

			// 获取页码
			method = cls.getMethod("getCount");
			o = method.invoke(obj);
			map.put("count", o);
			count = Integer.valueOf(o.toString());
			if (count >= 1) {
				// 求余等于0 或不等于0 页码加1
				totalPages = count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
			} else {
				totalPages = count;
			}

			map.put("totalPages", totalPages);
			if (o != null) {
				msg.setMsg(map);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("分页查询数据成功！");
			} else {
				msg.setMsg(map);
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg("分页查询数据异常！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("查询失败！");
		}

		return msg;
	}


	/**
	 * 更新显示隐藏数据
	 */
	@POST
	@Path("/updatePageEditor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updatePageEditor(String record) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		// 转换json 获取数据
		JSONObject jsonObj = new JSONObject();
		jsonObj = JSONObject.parseObject(record);
		String selected = jsonObj.getString("selected");
		int id = jsonObj.getIntValue("id");

		PageEditor page = new PageEditor();

		try {

			PageEditor pageEditor = pageDesignOperatorBiz.selectPageEditor(id);
			pageEditor.setSelected(selected);

			int i = pageDesignOperatorBiz.updatePageEditor(pageEditor);
			if (i > 0) {
				msg.setMsg(pageEditor);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("更新成功");
			} else {
				msg.setMsg(pageEditor);
				msg.setStatus(Answer.ERR_MSG);
				msg.setStatusMsg("更新异常！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("更新失败！");
			e.printStackTrace();
		}

		return msg;
	}

	/**
	 * 在线更新 beta 1.0
	 */
	@GET
	@Path("/updateEditor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updateEditor() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>();
		try {

			List<Node> list = nodeDao.getTreeNode();
			List<Node> pages = new ArrayList<Node>();
			PageEditor page = new PageEditor();
			for (Node tree : list) {
				page = pageDesignDao.getByNodeId(tree.getId());
				if (page != null) {
					pages.add(tree);
				}
			}

			for (Node treeNode : pages) {
				update(treeNode.getId());
				// Thread.sleep(2000);
			}

			msg.setMsg(pages);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("应该是更新成功了吧！");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg(Answer.ERR_MSG);
			e.printStackTrace();
		}

		return msg;
	}

	// 首字母大写
	public static String captureName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1);
		return name;
		// char[] cs = name.toCharArray();
		// cs[0] -= 32;
		// return String.valueOf(cs);
	}

	// String 逗号分隔 转int数组
	public int[] StringtoInt(String str) {

		int ret[] = new int[str.length()];
		StringTokenizer toKenizer = new StringTokenizer(str, ",");
		int i = 0;
		while (toKenizer.hasMoreElements()) {
			ret[i++] = Integer.valueOf(toKenizer.nextToken());
		}
		return ret;

	}

	/**
	 * 根据nodeId更新
	 */
	@GET
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg update(@QueryParam("nodeId") Integer nodeId) {
		/*
		 * try{ SSHUtil ssh = new SSHUtil(); //获取更新文件名 Node node =
		 * nodeDao.getByNodeName(nodeId); //获取更新文件字段 PageEditor pageEditor =
		 * pageDesignOperatorBiz.selectPage(nodeId);
		 * log.info("-----------------------对象："+pageEditor); System.out
		 * .println("-----------------------电脑页面："+pageEditor.getParse());
		 * System
		 * .out.println("-----------------------手机页面："+pageEditor.getPhoneParse
		 * ()); String param = ""; if(pageEditor.getParse() != null) { param =
		 * GetDataName.GetDataName(pageEditor.getParse()); }else { param =
		 * GetDataName.GetDataName(pageEditor.getPhoneParse()); }
		 * 
		 * if (node != null && pageEditor != null) { String name =
		 * node.getValue(); //中文转为拼音 //获取动态类名字 String[] arr =
		 * WriteMapper.writeNodeName(name);
		 * 
		 * File tempFile = new File(PathConstants.TARGET_PATH + arr[0] +"/"); if
		 * (!tempFile.exists()) { tempFile.mkdir(); }
		 * 
		 * // 清空文件夹 Test.delAllFile(PathConstants.TARGET_PATH + arr[0] +"/");
		 * 
		 * //读出Jar配置文件
		 * //CopyFile.copyFormJar("Source-mybatis-nomapper-config.xml");
		 * CopyFile.copyFormJar("SourceImpl.xml",arr[0]);
		 * CopyFile.copyFormJar("Source-mybatis-config.xml",arr[0]);
		 * CopyFile.copyFormJar("generatorConfig.xml",arr[0]);
		 * 
		 * //更换配置地址 //动态类名 nodeName String nodeName =
		 * PathReplace.replaceFile("generatorConfig.xml",arr[0]);
		 * PathReplace.replaceFile("Source-mybatis-config.xml",null);
		 * 
		 * generator(arr[0] );
		 * 
		 * //生成mapperImpl.java文件 //node_name 初始类名 nodeName 新类名
		 * writeJavaImpl(arr[0] ,nodeName); //生成sqlconfig文件
		 * writeSqlFactoryConfig(arr[0] ,nodeName); //mapper添加方法接口
		 * WriteMapper.writeMapperFile(arr[0] ,nodeName,param); //储存类名
		 * WriteMapper.createFile(nodeName, PathConstants.TARGET_PATH + arr[0]
		 * +"/"+arr[0] +".sw");
		 * 
		 * //动态编译java类 DynamicCompilerUtil.compiler(arr[0] );
		 * 
		 * //热部署 //CompilerMain.testCompiler(node_name);
		 * //DynamicUninstallClass.uninstallClass(node_name);
		 * 
		 * //生成html String savePaths = savePath + arr[0] + "/exportRar/";
		 * ssh.copyFile(PathConstants.EXPORT_RAR, savePaths,"-r");
		 * 
		 * //替换显示页面内容 WriteMapper.Html(savePaths+"index.html",
		 * pageEditor.getNode_id());
		 * 
		 * } } catch (Exception e) { e.printStackTrace(); }
		 */
		return null;

	}

	public static String tihuan(String str) {
		// reportcontrol,&lt;,1,报表控件`reportcontrol,&lt;=,2,报表控件`reportcontrol,=,3,
		// 报表控件`reportcontrol,&gt;=,4,报表控件`reportcontrol,&gt;,5,报表控件

		str = str.replace("&lt;", "<");
		str = str.replace("&gt;", ">");

		return str;
	}

	// 评论控件回复插入
	@POST
	@Path("/insertComment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg insertComment(String data) {
		ReturnMsg msg = null;
		try {

			JSONObject json = JSONObject.parseObject(data);
			String content = json.getString("content");
			String contentId = json.getString("contentId");
			String field = json.getString("field");
			String userName = json.getString("userName");
			String datasource = json.getString("datasource");
			Integer nodeId = json.getInteger("nodeId");

			if (contentId.equals("") || contentId == null) {
				contentId = "0";

			}

			msg = pageDesignOperatorBiz.insertComment(content, field, Integer.valueOf(contentId), userName, datasource,
					nodeId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	// 发布资源提交表单
	@POST
	@Path("/releaseResources")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg ReleaseResources(PageEditor pageEditor) {
		ReturnMsg msg = null;
		try {

			msg = pageDesignOperatorBiz.ReleaseResources(pageEditor);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	// 删除分类树形控件
	@GET
	@Path("/delSort")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg delSort(@QueryParam("id") int id) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "异常！");
		try {

			int i = pageDesignDao.delSort(id);
			if (i >= 1) {
				msg.setMsg(true);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("删除成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("删除失败！");
		}
		return msg;
	}

	// 更新分类树形控件
	@POST
	@Path("/upSort")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg upSort() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "异常！");
		try {
			// 获取request
			HttpServletRequest req = RpcContext.getContext().getRequest(HttpServletRequest.class);

			FormUploadUtil util = new FormUploadUtil();
			List<Map<String, Object>> list = util.formDataList(req);
			// 获取表单文件
			Map<String, Object> files = list.get(1);
			// 获取表单文字
			Map<String, Object> form = list.get(0);

			// 获取图片
			List<Object[]> fileMessages = (List<Object[]>) files.get("image");
			String fileUrl = "";
			boolean b = false;
			// 判断图片是否为空
			if (fileMessages != null) {
				fileUrl = HostConstants.FILE_PATH + new Date().getTime() + ".png";
				b = false;
				for (Object[] fm : fileMessages) {
					// 路径不存在就创建路径
					b = FileUtil.savaFile((byte[]) fm[0], fileUrl);
				}
			}

			SortChildren sort = new SortChildren();
			sort.setName(form.get("name").toString());
			sort.setNodeId(Integer.parseInt(form.get("nodeId").toString()));
			sort.setPid(Integer.parseInt(form.get("pid").toString()));
			sort.setId(Integer.parseInt(form.get("id").toString()));
			if (form.get("attributes").toString() != null) {
				sort.setAttributes(form.get("attributes").toString());
			}
			if (b) {
				sort.setUrl(fileUrl.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST));
			} else {
				if (null != form.get("url")) {
					sort.setUrl(form.get("url").toString());
				}
			}

			Map<String, Object> map = new HashMap<String, Object>();
			int i = pageDesignDao.upSort(sort);
			if (i >= 1) {
				map.put("id", sort.getId());
				map.put("url", sort.getUrl());
				msg.setMsg(map);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("修改成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("修改失败！");
		}
		return msg;
	}

	// 添加分类树形控件
	@POST
	@Path("/addSort")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg addSort() {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1", "异常！");
		try {

			// 获取request
			HttpServletRequest req = RpcContext.getContext().getRequest(HttpServletRequest.class);

			FormUploadUtil util = new FormUploadUtil();
			List<Map<String, Object>> list = util.formDataList(req);
			// 获取表单文件
			Map<String, Object> files = list.get(1);
			// 获取表单文字
			Map<String, Object> form = list.get(0);

			// 获取图片
			List<Object[]> fileMessages = (List<Object[]>) files.get("image");
			String fileUrl = "";
			// 判断图片是否为空
			if (fileMessages != null) {
				fileUrl = HostConstants.FILE_PATH + new Date().getTime() + ".png";
				for (Object[] fm : fileMessages) {
					// 路径不存在就创建路径
					FileUtil.savaFile((byte[]) fm[0], fileUrl);
				}
			}

			SortChildren sort = new SortChildren();
			sort.setName(form.get("name").toString());
			log.info("------" + form.get("nodeId").toString());
			sort.setNodeId(Integer.parseInt(form.get("nodeId").toString()));
			sort.setPid(Integer.parseInt(form.get("pid").toString()));
			if (form.get("attributes").toString() != null) {
				sort.setAttributes(form.get("attributes").toString());
			}
			log.info("--------------------" + fileUrl);
			log.info("--------------------" + HostConstants.FILE_PATH);
			log.info("--------------------" + HostConstants.FILE_HOST);
			sort.setUrl(fileUrl.replace(HostConstants.FILE_PATH, HostConstants.FILE_HOST));

			Map<String, Object> map = new HashMap<String, Object>();
			int i = pageDesignDao.addSort(sort);
			if (i >= 1) {
				map.put("id", sort.getId());
				map.put("url", sort.getUrl());
				msg.setMsg(map);
				msg.setStatus(Answer.SUCCESS_MSG);
				msg.setStatusMsg("添加成功！");
			}

		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("添加失败！");
		}
		return msg;
	}

	// 获取课程条件
	@GET
	@Path("/getCourseEq")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg getCourseEq() {
		ReturnMsg<List<Map>> msg = new ReturnMsg<List<Map>>();
		try {

			msg.setMsg(pageDesignDao.getCourseEq());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	// 搜索课程
	@GET
	@Path("/searchCourse")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg searchCourse(JSONObject json) {
		ReturnMsg msg = new ReturnMsg();

		try {
			String key = json.getString("key");
			String eq_field = json.getString("eq_field");
			msg.setMsg(pageDesignDao.searchCourse(json));

		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("搜素失败");
		}

		return msg;
	}


	/**
	 * @描述 拼接模板消息
	 * @author 张宇
	 * @param record
	 * @time 2018-8-2
	 * @return
	 */
	@POST
	@Path("/jointTemplateMsg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg jointTemplateMsg(JSONObject data) {
		ReturnMsg msg = new ReturnMsg();
		String msgTitle = "";

		log.info("====data========" + data);

		int msgflag = Integer.valueOf(data.get("msgflag").toString());
		JSONObject params = new JSONObject();

		// 创建一个变量，用来存放发送的短信内容
		String msgContent = "";

		System.out.print("msgflag============" + msgflag);
		if (msgflag == 3) {
			// 作业发布
			params = TemplateUtil.homeWorkTemplate(data);
			msgTitle = "作业提醒";
			msgContent = MobileMsgTemplate.homeWorkTemplate(data);
		} else if (msgflag == 2) {
			// 请假发布
			params = TemplateUtil.leaveTemplate(data);

			msgTitle = "请假通知";
			msgContent = MobileMsgTemplate.leaveTemplate(data);
		} else if (msgflag == 1) {
			params = TemplateUtil.teacherPushTemplate(data);
			msgTitle = "教师安排通知";
			msgContent = MobileMsgTemplate.teacherPushTemplate(data);
		} else {
			// 家校通知
			params = TemplateUtil.classBiginTemplate(data);
			msgTitle = "课程开课通知";
			msgContent = MobileMsgTemplate.schoolBeginTemplate(data);
		}

		List<Map> wxUser = new ArrayList();
		Set set = new HashSet();

		String type = "";

		// 组织
		if (data.containsKey("swPowerJob") && !data.getString("swPowerJob").trim().equals("")) {
			List<Integer> paramList = new ArrayList<Integer>();
			String swPowerJob = data.getString("swPowerJob");
			String[] jobUser = swPowerJob.split(",");
			for (int i = 0; i < jobUser.length; i++) {
				paramList.add(Integer.parseInt(jobUser[i]));
			}
			if (jobUser.length > 0) {
				// 根据组织获取用户,并获取用户下的职位openid
				List userList = pageDesignDao.getUserWeiXinOpenidByRoleIdList(paramList);

				if (userList != null && userList.size() > 0) {
					set.addAll(userList);
				}

				set.addAll(userList);
			}
			type = "swPowerJob";
		}

		log.info("=================.trim()====="+data.getString("swPowerRole").trim().equals(""));
		// 职位
		if (data.containsKey("swPowerRole") && !data.getString("swPowerRole").trim().equals("")) {
			List<Integer> paramList = new ArrayList<Integer>();
			String swPowerRole = data.getString("swPowerRole");
			String[] roleUser = swPowerRole.split(",");
			for (int i = 0; i < roleUser.length; i++) {

				paramList.add(Integer.parseInt(roleUser[i]));
			}
			// 获取职位下的用户openid
			List userList = pageDesignDao.getUserWeiXinOpenidByPidList(paramList);

			if (userList != null && userList.size() > 0) {
				set.addAll(userList);
			}

			set.addAll(userList);

			type = "swPowerRole";
		}

		// 用户
		if (data.containsKey("swPowerRoleUser") && !data.getString("swPowerRoleUser").trim().equals("")) {
			String swPowerRoleUser = data.getString("swPowerRoleUser");
			String[] user = swPowerRoleUser.split(",");
			log.info("===========user===" + user.length);
			for (int i = 0; i < user.length; i++) {
				set.add(Integer.parseInt(user[i]));
			}

			type = "swPowerRoleUser";
		}

		// 获取所有的微信绑定用户

		if (set.size() <= 0) {
			msg.setStatus(Answer.DATA_ISNULL);
			msg.setStatusMsg("没有用户！");
			return msg;
		}

		List list = new ArrayList(set);
		log.info("===========set===" + list.size());
		wxUser = pageDesignDao.getUserWeiXinOpenidByUserList(list);

		if (wxUser == null || wxUser.size() <= 0) {
			msg.setStatus(Answer.DATA_ISNULL);
			msg.setStatusMsg("没有微信绑定用户！");
			return msg;
		}

		log.info("=============wxUser.SIZE()==" + wxUser.size());

		// TODO 获取所有有手机号的用户
		List<Map> users = pageDesignDao.selectUserMobileByuIds(list);

		/**
		 * 新增发送短信功能
		 * @author 郑志良 
		 * @date 2018年9月10日下午12:16:13
		 */
		log.info("=================发送短信==================");
		sendMessage(users, msgContent, msgTitle);

		log.info("=============mobile.SIZE()==" + users.size());

		//HttpUtils.sendPost(url, map);

		// 发送的通知保存到数据库（微信推送，不含手机短信通知）
		PushMsg push = new PushMsg();
		push.setContent(data.toJSONString());
		push.setAddTime(System.currentTimeMillis());
		push.setIsDelete(0);
		push.setWxtagtype(type);
		push.setMsgflag(msgflag);
		push.setSendUid(data.getInteger("uId"));
		push.setTitle(msgTitle);

		pageDesignDao.insertPushMsg(push);

		Map param = new HashMap();
		param.put("pushId", push.getId());

		log.info("==============pushId=============" + push.getId());

		for (Map map : wxUser) {
			param.put("uId", map.get("uid"));
			pageDesignDao.insertPushReceive(param);
		}

		JSONObject json = new JSONObject();
		json.put("template", params);
		json.put("wxUser", wxUser);
		json.put("msgflag", msgflag);

		return sendTemplateMsgByOpenid(json);
	}

	/**
	 * 发送短信
	 * @param users 短信接收者
	 * @param msgContent 发送的短信内容
	 * @param msgTitle 短信标题
	 * @return
	 *
	 * @author 郑志良 
	 * @date 2018年9月10日下午12:16:13
	 */
	private void sendMessage(List<Map> users, String msgContent, String msgTitle) {
		if (CollectionUtils.isEmpty(users)) {
			log.info("---users为空，接收短信的用户为空");
			return;
		}

		try {
			// 组装接收人，多个手机号之间使用","号隔开。
			String mobiles = getMobiles(users);
			// 组装短信内容，内容必须以"【】"开关，否则将出现短信发送成功，并接收者接收不到的情况。
			String content = String.format("【%s】%s", StringUtils.trim(msgTitle), msgContent);

			log.info("短信接收人手机号，mobiles: " + mobiles + ", 短信内容，content: " + content);

			// 发送短信
			String sendResult = SendMessageUtil.send(mobiles.toString(), content, null, null);

			// 校验发送是否成功
			Map<String, String> map = SendMessageUtil.parseXmlStr(sendResult);
			// 获取返回的状态码和说明信息
			String status = map.get("returnstatus");
			String message = map.get("message");
			// 返回"Success"表示成功，其他的表示失败
			if (StringUtils.equals("Success", status)) {
				log.info("短信发送成功，status: " + status + ", message: " + message);
			} else {
				log.error("短信发送失败：status: " + status + ", message: " + message);
				//				throw new Exception("短信发送失败：status: " + status + ", message: " + message);
			}
		} catch (Exception e) {
			log.error("短信发送失败", e);
			//			throw new RuntimeException(e);
		}
	}

	/**
	 * 组装接收人，多个手机号之间使用","号隔开。
	 * @param users
	 * @return
	 *
	 * @author 郑志良
	 * @date 2018年9月10日下午2:57:23
	 */
	private String getMobiles(List<Map> users) {
		StringBuilder mobiles = new StringBuilder();
		for (Map map : users) {
			String mobile = (String) map.get("mobile");
			mobiles.append(mobile).append(",");
		}
		// 去掉末尾多出来的","
		mobiles.deleteCharAt(mobiles.length() - 1);
		return mobiles.toString();
	}

	/**
	 * @描述 发送模板消息
	 * @author 张宇
	 * @param record
	 * @time 2018-8-2
	 * @return
	 */
	public ReturnMsg sendTemplateMsgByOpenid(JSONObject record) {

		JSONObject template = record.getJSONObject("template");
		JSONArray wxUser = record.getJSONArray("wxUser");

		String token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid
				+ "&secret=" + secret;

		ReturnMsg msg = new ReturnMsg();
		/* try { */
		String token;

		// 获取token
		String value = swtech.facade.pageDesign.util.HttpUtils.sendGet(token_url, null);
		Map valueMap = JSON.parseObject(value);
		token = (String) valueMap.get("access_token");

		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;

		int error = 0;
		int success = 0;
		for (Object user : wxUser) {
			JSONObject userJ = (JSONObject) user;
			// TODO
			template.put("touser", userJ.get("openid"));

			// 如果有名字，还需要修改名字
			int msgflag = record.getInteger("msgflag");
			/*
			 * if (msgflag == 1) { JSONObject data =
			 * template.getJSONObject("data"); JSONObject userName =
			 * data.getJSONObject("userName"); userName.put("value",
			 * userJ.get("nickname")); }
			 */

			// 发送模板消息
			String result = swtech.facade.pageDesign.util.HttpUtils.sendPost(url, template.toJSONString());
			JSONObject status = JSON.parseObject(result);
			log.info("========status===" + status);
			if ((int) status.get("errcode") != 0 && !status.get("errcode").equals("0")) {

				error++;

			}else{
				success++;
			}

		}

		// TODO 消息发送失败后修改状态或者删除发送记录（或者回滚）
		msg.setStatusMsg("微信通知成功："+success+"个，失败："+error+"个！");
		msg.setStatus(Answer.SUCCESS_MSG);
		msg.setMsg("通知已发送");

		return msg;
	}

	public void sendTemplate(JSONObject params, String openid, String token) throws Exception {
		String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + token;
		params.put("touser", openid);

		JSONObject changData = params.getJSONObject("data");
		if (changData.containsKey("userName")) {
			JSONObject name = changData.getJSONObject("userName");

			// 获取用户的基本信息
			String user_url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + token + "&openid=" + openid
					+ "&lang=zh_CN";
			String userInfo = swtech.facade.pageDesign.util.HttpUtils.sendGet(user_url, null);
			JSONObject info = JSON.parseObject(userInfo);
			name.put("value", info.get("nickname"));
		}

		// 发送模板消息
		String result = swtech.facade.pageDesign.util.HttpUtils.sendPost(url, params.toJSONString());
		JSONObject status = JSON.parseObject(result);
		if ((int) status.get("errcode") != 0 && !status.get("errcode").equals("0")) {
			throw new Exception();
		}
	}

	// 模板

	// 级联分类增加
	@POST
	@Path("/addCascadeClassifyRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg addCascadeClassify(JSONObject json) {

		ReturnMsg msg = new ReturnMsg();
		try {
			CascadeClassify classify = (CascadeClassify) JSON.parseObject(json.toJSONString(), CascadeClassify.class);
			Integer pkid = pageDesignDao.insertCascadeClassifyRecord(classify);

			log.info("==========classify====" + classify.getId());
			msg.setMsg(classify.getId());
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("添加失败");
		}

		return msg;
	}

	// 级联分类删除
	@GET
	@Path("/delCascadeClassifyRecord")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg delCascadeClassify(@QueryParam("id") Integer id) {
		ReturnMsg msg = new ReturnMsg();
		try {
			pageDesignDao.delCascadeClassifyById(id);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("删除失败");
		}
		return msg;
	}

	// 级联分类修改
	@POST
	@Path("/updateCascadeClassifyRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updateCascadeClassify(JSONObject json) {
		ReturnMsg msg = new ReturnMsg();
		try {
			CascadeClassify classify = (CascadeClassify) JSON.parseObject(json.toJSONString(), CascadeClassify.class);
			log.info("==========getParentId==" + classify.getParentId());
			pageDesignDao.updateCascadeClassify(classify);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("修改失败");
		}
		return msg;
	}

	/**
	 * 搜索控件之添加绑定数据源(废弃了)
	 */
	@POST
	@Path("/addSearchControlRecord")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg addSearchControl(JSONObject record) {
		ReturnMsg msg = new ReturnMsg();

		try {
			SearchControl searchControl = (SearchControl) JSON.parseObject(record.toJSONString(), SearchControl.class);
			Integer i = pageDesignDao.insertSearchControlRecord(searchControl);
			msg.setMsg(i);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("添加失败！");
		}
		return msg;
	}

	//静态页面
	@POST
	@Path("/creatStaticPage")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg creatStaticPage(JSONObject record) {
		ReturnMsg msg=new ReturnMsg();
		String nodeId = record.getString("nodeId");
		String htmlText = record.getString("record");
		String name = record.getString("name");	
		String page_path = record.getString("page_path");
		name=Pinyin4jUtil.toPinyin(name);		

		Integer pathnum = 1;
		if(nodeId != null) {
			Integer isPopularize = nodeDao.getPopularizeById(nodeId);

			//log.info("当前页面是否为推广页===="+isPopularize);
			pathnum = isPopularize;
		}



		try {
			CreatStaticPage.CreatPage(htmlText,name,pathnum,page_path);
			String a=CreatStaticPage.getFile().getName();
			msg.setMsg(a);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("生成静态页面成功！");
		} catch (IOException e) {
			e.printStackTrace();
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("生成静态页面失败！");
		}

		return msg;


	}
	/**
	 * @Description: ajax增加控件
	 * @param record   
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	@POST
	@Path("/insertControl")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg insertControl(JSONObject record){
		ReturnMsg msg=new ReturnMsg();
		Map map=new HashMap();
		String sw=BeforeTheSuffix.Prefix;
		long node_id = record.getLong("node_id");
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(node_id);
		map.put("node_name",captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString())));
		map.put("title", record.getString("title"));
		map.put("control_name", sw+record.getString("control_name"));
		try {
			pageDesignDao.insertControl(map);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("添加成功！");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("添加失败！");
		}
		return msg;

	}
	/**
	 * @Description: ajax修改控件
	 * @param record   
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	@POST
	@Path("/updateControl")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg updateControl(JSONObject record){
		ReturnMsg msg=new ReturnMsg();
		Map map=new HashMap();
		String sw=BeforeTheSuffix.Prefix;
		long node_id = record.getLong("node_id");
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(node_id);
		map.put("node_name",captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString())));
		map.put("title",record.getString("title"));
		map.put("control_name",sw+record.getString("control_name"));
		map.put("new_control_name",sw+record.getString("new_control_name"));
		try {
			pageDesignDao.updateControl(map);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("修改成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("修改失败");
		}


		return msg;

	}
	/**
	 * @Description: 删除控件
	 * @param record   
	 * @return 200 成功 ;400 失败
	 * @throws
	 * @author pyb
	 * @date 2018.10.06
	 */
	@POST
	@Path("/deleteControl")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
	public ReturnMsg deleteControl(JSONObject record){
		ReturnMsg msg=new ReturnMsg();
		Map map=new HashMap();
		String sw=BeforeTheSuffix.Prefix;
		long node_id = record.getLong("node_id");
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(node_id);
		map.put("node_name",captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString())));
		map.put("control_name", sw+record.getString("control_name"));
		try {
			pageDesignDao.deleteControl(map);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("删除成功！");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("删除失败！");
		}
		return msg;

	}
	@POST
	@Path("/contrastiveAnalysis")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_PLAIN_UTF_8})
	public ReturnMsg contrastiveAnalysis(JSONObject record){
		JSONArray data = record.getJSONArray("data");
		if(data.size()>0){
			for(int i=0;i<data.size();i++){
				JSONObject jsonObject = data.getJSONObject(i);
				System.out.println(jsonObject.get("name"));
				System.out.println(jsonObject.get("title"));
			}/*	//在修改前获取他的值
		PageEditor page = getSqlSession().selectOne("getByNode_Id", param);
		log.info("page.getSelected()-============="+page.getSelected());
		 selected = page.getSelected();*/

		}
		return null;

	}

	/**
	 * @描述  导出Excel表格
	 * @param record
	 * @author 王小东
	 * @date 2018年12月03日下午14:23:52
	 */
	@POST
	@Path("/derivedForm")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg derivedForm(JSONObject record){
		ReturnMsg msg=new ReturnMsg();
		Map<Object,String> map=new HashMap<Object,String>();
		String sw=BeforeTheSuffix.Prefix;
		long node_id = record.getLong("nodeId");
		Map nodeByNodeIdAndNodeName = pageDesignDao.getNodeByNodeId(node_id);
		map.put("node_name",captureName(Pinyin4jUtil.toPinyin(nodeByNodeIdAndNodeName.get("node_name").toString())));
		//获取字段
		String str=record.getString("datafield");
		System.out.println("str="+str);
		//取出字段放入数组
		String[] strs=str.split(",");
		//声明数组变量 初始化位数为取出字段的位数
		String[] datas= new String[strs.length];
		//将取出的字段数组遍历出来 每个字段加前缀 然后在重新存进新的数组变量中
		for(int i=0;i<strs.length;i++) {
			datas[i]=sw+strs[i];
		}
		System.out.println("datas="+datas);
		//将数组转换为字符串
		String datafield=StringUtils.join(datas,",");
		map.put("datafield", datafield);
		System.out.println("map="+map);
		//查出的数据放进集合
		List<Map> listMap=pageDesignDao.derivedForm(map);
		System.out.println("listMap="+listMap);
		//生成Excel
		File fileExcel =new File(HostConstants.FILE_PATH+"Excel"); 
		System.out.println("fileExcel="+fileExcel);
		//如果文件夹不存在则创建 
		if (!fileExcel.exists() && !fileExcel.isDirectory()) {    
			fileExcel.mkdir(); 
		}
		File file = new File(HostConstants.FILE_PATH+"Excel"+"/template1.xls");
		System.out.println("file="+file);
		FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		//HSSFWorkbook生成Excel   org.apache.poi
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sheet1");
		HSSFCellStyle cellStyle = workbook.createCellStyle();    
		HSSFRow row = sheet.createRow(0);
		row.setHeightInPoints(30); // 设置行的高度

		//将字段遍历出来为字段起别名作为表格的标题
		for(int x=0;x<datas.length;x++) {
			if(datas[x].equals("swprefixyonghu")) {
				row.createCell(x).setCellValue("用户");
			}
			if(datas[x].equals("swprefixjingyan")) {
				row.createCell(x).setCellValue("禁言");
			}
			if(datas[x].equals("swprefixshijianw")) {
				row.createCell(x).setCellValue("时间");
			}
		}

		//将动态查询出的数据遍历出来重新放进map中
		for(int i = 0;i < listMap.size();i++){
			row = sheet.createRow(i + 1);
			Map<String,Object> maps = listMap.get(i);

			//遍历出字段将字段的记录数据放入表格中
			System.out.println("maps中="+maps);
			for(String d:datas) {
				System.out.println("datas中="+d);
			}

			for(int j=0;j<datas.length;j++) {
				System.out.println("datas[j]="+datas[j]);
				if(maps.get(datas[j])!=null) {
					String authorStr = maps.get(datas[j]).toString();
					row.createCell(j).setCellValue(authorStr);
				}

			}
		}

		workbook.setActiveSheet(0);
		try {
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			msg.setMsg(listMap);
			msg.setStatus(Answer.SUCCESS_MSG);
			msg.setStatusMsg("导出成功");
		} catch (Exception e) {
			msg.setStatus(Answer.ERR_MSG);
			msg.setStatusMsg("导出失败");
		}
		return msg;

	}


	/**
	 * @描述  根据树形节点id删除对应的表与下属的表接方法deleteTableById
	 * @param record
	 * @author 王小东
	 * @date 2018年12月13日下午15:29:16
	 */
	@POST
	@Path("/deleteTableById")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg deleteTableById(JSONObject record) {
		ReturnMsg msg=new ReturnMsg();
		long node_id=record.getInteger("nodeId");
		Map map=new HashMap<>();
		map.put("node_id", node_id);
		//查询该树节点下所有的数据库表名
		List<Map> nodeNames=pageDesignDao.selectTableById(map);
		log.info("============nodeNames============================"+nodeNames.size());
		String[] names=new String[nodeNames.size()];
		for(int i=0;i<nodeNames.size();i++) {
			if(!"".equals(nodeNames.get(i))&&nodeNames.get(i)!=null) {
				Map maps=nodeNames.get(i);
				names[i]=(String)maps.get("node_name");
			}
		}
		String tableName=StringUtils.join(names,",");
		log.info("========tableName================================"+tableName.toString());
		map.put("table_names", tableName);
		try {
			//根据查询出来的表名进行删除表操作
			if(tableName!="") {
				pageDesignDao.deleteTableById(map);
			}
			pageDesignDao.deleteNodeRecordById(map);
			msg.setStatus("200");
			msg.setStatusMsg("删除成功");
		} catch (Exception e) {
			msg.setStatus("0");
			msg.setStatusMsg("删除失败");
		}

		return msg;
	}


	@POST
	@Path("/importExportSqlFile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_PLAIN_UTF_8 })
	public ReturnMsg importExportSqlFile(JSONObject record) {
		ReturnMsg msg=new ReturnMsg();
		long node_id=record.getInteger("nodeId");
		Map map=new HashMap<>();
		map.put("node_id", node_id);
		//查询该树节点下所有的数据库表名
		List<Map> nodeNames=pageDesignDao.selectTableById(map);
		log.info("============nodeNames============================"+nodeNames.size());
		String[] names=new String[nodeNames.size()];
		for(int i=0;i<nodeNames.size();i++) {
			if(!"".equals(nodeNames.get(i))&&nodeNames.get(i)!=null) {
				Map maps=nodeNames.get(i);
				names[i]=(String)maps.get("node_name");
			}
		}


		Properties properties = new Properties();  
		MySqlImportAndExport mySqlImportAndExport=new MySqlImportAndExport();

		try {
			mySqlImportAndExport.export(names);
			MySqlImportAndExport.importSql();
			msg.setStatus("200");
			msg.setStatusMsg("导出成功");
		} catch (IOException e) {
			msg.setStatus("0");
			msg.setStatusMsg("导出失败");
		}  

		return msg;
	}


}
