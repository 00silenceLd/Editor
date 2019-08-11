package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CommentInfo;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.service.CommentFacade;
import swtech.service.pageDesign.dao.CommentDataDao;
import swtech.service.pageDesign.dao.impl.CommentDataDaoImpl;

/**
 *
 * @author 曾智宏
 *
 * @version 1.0
 *
 * 创建时间：2019年4月4日 下午14:10:21
 *
 * 点击数据详情显示的评论插件
 *
 */

@Path("commentFacade")
@Component("commentFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class CommentFacadeImpl implements CommentFacade{
	private static final Logger log = LoggerFactory.getLogger(CommentFacadeImpl.class);
	
	@Autowired
	private CommentDataDao commentDataDao;
	
	//查询nodeId与selectId 下的所有已经通过审核的评论
	@Override
	@GET
	@Path("/getComment")
	public ReturnMsg getComment(@QueryParam("nodeId") Integer nodeId,@QueryParam("selectId") Integer selectId) {
		System.out.println("nodeId="+nodeId);
		System.out.println("selectId="+selectId);
		ReturnMsg msg = new ReturnMsg(); 
		try {
			msg = commentDataDao.getComment(nodeId,selectId);
//			log.info("这里是service实现类");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 
	 * 发布评论
	 * 接收参数（nodeId,selectId,pubUser,pubContent,pubTime,uid）
	 * @QueryParam("nodeId")Integer nodeId,
			@QueryParam("selectId")Integer selectId,
			@QueryParam("pubUser")String pubUser,
			@QueryParam("pubContent")String pubContent,
			@QueryParam("pubTime")String pubTime
	 */
	@Override
	@POST
	@Path("/releaseComment")
	public ReturnMsg releaseComment(CommentInfo commentInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = commentDataDao.releaseComment(commentInfo);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	//审核未通过或者撤回评论
	@Override
	@POST
	@Path("/deleteComment")
	public ReturnMsg deleteComment(Integer[] ids) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = commentDataDao.deleteComment(ids);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	//通过审核
	@Override
	@POST
	@Path("/passApproveComment")
	public ReturnMsg passApproveComment(Integer[] ids) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = commentDataDao.passApproveComment(ids);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	//获取未审核的评论
	@Override
	@GET
	@Path("/getNotApproveComment")
	public LayuiTabReturn getNotApproveComment(@QueryParam("page") Integer page,
			@QueryParam("limit") Integer limit) {
		LayuiTabReturn msg = new LayuiTabReturn();
		try {
			msg = commentDataDao.getNotApproveComment(page,limit);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}





}
