package swtech.facade.pageDesign.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.SiteFirst;
import swtech.facade.pageDesign.service.HerdNodeOperatorFacade;
import swtech.service.pageDesign.biz.HerdNodeOperatorBiz;

/**
 *
 * @author 林致杰
 *
 * @version 1.0
 *
 *          创建时间：2017年12月1日 下午5:11:56
 *
 *          树节点操作接口实现类
 *
 */

@Path("herdNodeOperatorFacade")
@Component("herdNodeOperatorFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HerdNodeOperatorFacadeImpl implements HerdNodeOperatorFacade {

	@Autowired
	private HerdNodeOperatorBiz biz;

	@POST
	@Path("/changeNodetype")
	public ReturnMsg ChangeNode_Type(String data) {
		ReturnMsg msg = null;
		try {
			msg = new ReturnMsg<Object>();
			Map<String, Object> maps = new HashMap<String, Object>();
			JSONObject jsonObject = JSON.parseObject(data);
			Integer node_id = jsonObject.getInteger("node_id"); 
			Integer node_type = jsonObject.getInteger("node_type");
			msg = biz.change_Nodetype(node_id, node_type);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@POST
	@Path("/setSite")
	public ReturnMsg setFirstPage(String entity) {
		// 获取当前节点所在的站点(回溯所有上级节点,得到倒数第二个节点ID)，并将当前站点内所有页面设置为非首页，设置当前节点为首页
		ReturnMsg msg = null;
		try {
			SiteFirst ent = JSONObject.parseObject(entity, SiteFirst.class);
			msg = biz.setSite(ent.getNode_id(), ent.getSite_id(), ent.isIs_pc());
			/*HtmlGenerator html=new HtmlGenerator(ent.getDomain());
			html.createHtmlPage(ent.getDomain(),File.separator+"usr"+File.separator+"local"+File.separator+"nginx"+File.separator+"html"+File.separator+"html"+File.separator+"sy.html");
			*/msg.setStatus("200");
			msg.setStatusMsg("设为首页成功！");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("400");
			msg.setStatusMsg("设为首页失败！");
		}
		return msg;
	}

	/**
	 * 添加文件夹
	 * */
	@POST
	@Path("/addTreeNode")
	public ReturnMsg addTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.addTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 添加文件
	 * */
	@POST
	@Path("/addPageEditor")
	public ReturnMsg addPageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.addPageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 修改文件夹
	 * */
	@POST
	@Path("/updateTreeNode")
	public ReturnMsg updateTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.updateTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 修改文件
	 * */
	@POST
	@Path("/updatePageEditor")
	public ReturnMsg updatePageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.updatePageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 删除文件夹
	 * */
	@POST
	@Path("/deleteTreeNode")
	public ReturnMsg deleteTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.deleteTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 删除文件
	 * */
	@POST
	@Path("/deletePageEditor")
	public ReturnMsg deletePageEditor(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.deletePageEditor(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/**
	 * 移动操作
	 * */
	@POST
	@Path("upTreeNode")
	public ReturnMsg upTreeNode(String entity) {
		ReturnMsg msg = null;
		try {

			msg = biz.upTreeNode(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
