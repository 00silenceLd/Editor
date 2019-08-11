package swtech.facade.pageDesign.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ClassifyShowRelation;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;
import swtech.facade.pageDesign.service.ClassifyFacade;
import swtech.facade.pageDesign.service.ClassifyFacadeService;

/*
 * 


 *
 *
 *             ,%%%%%%%%, 
 *           ,%%/\%%%%/\%% 
 *          ,%%%\c "" J/%%% 
 * %.       %%%%/ o  o \%%% 
 * `%%.     %%%%    _  |%%% 
 *  `%%     `%%%%(__Y__)%%' 
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%' 
 *  \\    .'          | 
 *   \\  /       \  | | 
 *    \\/         ) | | 
 *     \         /_ | |__ 
 *     (___________))))))) 攻城湿 
 *
 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
 * @ClassName: ClassifyFacadeImpl
 * @Author 曾智宏
 * @Date 2019年8月4日 下午4:14:30
 * @Description: 树形分类控件1、2的资源入口类
 *
 */

@Path("classifyFacade")
@Component("classifyFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class ClassifyFacadeImpl implements ClassifyFacade{
	private static final Logger log = LoggerFactory.getLogger(ClassifyFacadeImpl.class);

	@Autowired
	private ClassifyFacadeService classifyService;





	/*
	 * 第一个控件
	 * 第一步，在编辑器弹框中定义该分类的名字，在点击确定之后根据名字创建对应的节点分类表xxxClassifyNode
	 * 并将该分类表的基本信息保存在中央调度表中（ht_classify_tree_info）
	 */
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 上午11:48:04
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: createClassifyTable
	 * @param nodeId 当前页面nodeId
	 * @param treeName 该分类树名称
	 * @return 
	 * @Description: 创建树形结构表及其与保存数据记录的关系表，并在ht_classify_tree_info表中记录结构表名与关系表名
	 *
	 */
	@POST
	@Path("/createClassifyTable")
	@Override
	public ReturnMsg createClassifyTable(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.createClassifyTable(classifyTreeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("创建失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}


	//显示当前页面树形中所有分类节点，nodeId-分类表名-查所有分类节点数据
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午12:21:33
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: getAllClassifyNodeByNodeId
	 * @param nodeId 当前页面nodeId
	 * @return
	 * @Description: 获取当前创建的树形中所有节点信息
	 *
	 */
	@GET
	@Path("/getAllClassifyNodeByNodeId")
	@Override
	public ReturnMsg getAllClassifyNodeByNodeId(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.getAllClassifyNodeByNodeId(nodeId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}


	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午12:23:19
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: createClassify
	 * @param nodeId 当前页面nodeId
	 * @param nodeName 要添加节点的名字
	 * @param pId 要添加节点的父id
	 * @return
	 * @Description: 添加分类节点
	 *
	 */
	@POST
	@Path("/createClassify")
	@Override
	public ReturnMsg createClassify(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.createClassify(classifyTreeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("创建分类节点失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午12:27:33
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: updateClassifyNode
	 * @param nodeId 当前页面nodeid
	 * @param id 节点id
	 * @param pId 节点父id（可选。若有值，移动节点；否则，为修改节点名字）
	 * @param nodeName 节点名字
	 * @return
	 * @Description: 修改分类节点信息（移动/修改名字）
	 *
	 */
	@POST
	@Path("/updateClassify")
	@Override
	public ReturnMsg updateClassifyNode(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.updateClassifyNode(classifyTreeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("更新失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	//删除分类节点
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午12:33:57
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: deleteClassify
	 * @param nodeId 当前页面nodeId
	 * @param id 要删除的节点id
	 * @return
	 * @Description: 删除分类节点
	 *
	 */
	@POST
	@Path("/deleteClassify")
	@Override
	public ReturnMsg deleteClassify(ClassifyTreeInfo classifyTreeInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.deleteClassify(classifyTreeInfo);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("删除失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}






	//第二个控件，在预览页面中，以下拉框的形式，选择不同的分类源	
	//在“下拉控件”中添加可以选择的分类源供预览页面中的下拉框显示。
	//或许不用创建对象表，只需要创建一个关系表（id、nodeId、classifyTreeInfoId）
	//一对多关系表
	//显示所有分类源
	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年8月5日 下午1:18:52
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.ClassifyFacadeImpl
	 * @MethodName: getAllClassify
	 * @return
	 * @Description: 显示所有分类源
	 *
	 */
	@GET
	@Path("/getAllClassify")
	@Override
	public ReturnMsg getAllClassify() {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.getAllClassify();
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}
	
	
	
	//（暂无用）
	//控件二点击保存之后，根据nodeId分类源主键id，保存期一对多的关系
	@POST
	@Path("/saveShowClassifyRelation")
	@Override
	public ReturnMsg saveShowClassifyRelation(ClassifyShowRelation classifyShowRelation) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.saveShowClassifyRelation(classifyShowRelation);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	//（暂无用）
	//根据nodeId显示其所有的分类源
	@GET
	@Path("/getClassifyByNodeId")
	@Override
	public ReturnMsg getClassifyByNodeId(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = classifyService.getClassifyByNodeId(nodeId);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

}
