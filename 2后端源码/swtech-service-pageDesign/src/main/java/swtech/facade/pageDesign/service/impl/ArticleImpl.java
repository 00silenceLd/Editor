package swtech.facade.pageDesign.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Article;
import swtech.facade.pageDesign.entity.ArticleCollection;
import swtech.facade.pageDesign.entity.ArticleComment;
import swtech.facade.pageDesign.entity.User;
import swtech.facade.pageDesign.service.ArticleFacade;
import swtech.service.pageDesign.dao.ArticleDao;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　        ┃
 * ┃　　　━　            ┃
 * ┃　┳┛　┗┳　    ┃
 * ┃　　　　　　        ┃
 * ┃　　　┻　　        ┃
 * ┃　　　　　　       ┃
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


 **/
@Path("/article")
@Component("articleFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class ArticleImpl implements ArticleFacade {

	@Autowired
	private ArticleDao dao;
	
	/**
	 * 点赞
	 * */
	@GET
	@Path("thumbsUp")
	public ReturnMsg thumbsUp(@QueryParam("nodeId")int nodeId,@QueryParam("gId") int gId, @QueryParam("uId") int uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","点赞失败!");
		try {
			
			//查询是否已有点赞信息
			Article article = dao.getArticle(nodeId,uId,gId);
			//查询点赞数
			int count = 0;
			if(article == null) {
				//插入点赞信息
				int i = dao.insertArticle(nodeId,uId,gId);
				if(i > 0) {
					count = dao.selectCountArticle(nodeId,gId);
					msg.setMsg(count);
					msg.setStatus("0");
					msg.setStatusMsg("点赞成功！");
				}
			}else {
				//更新点赞信息
				article.setTrue(!article.isTrue());
				dao.updateArticle(article);
				//查询点赞数
				count = dao.selectCountArticle(nodeId,gId);
				if(article.isTrue()) {
					msg.setMsg(count);
					msg.setStatus("0");
					msg.setStatusMsg("点赞成功！");
				}else {
					msg.setMsg(count);
					msg.setStatus("1");
					msg.setStatusMsg("取消点赞！");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(0);
			msg.setStatus("2");
			msg.setStatusMsg("点赞失败！");
		}
		return msg;
	}
	
	/**
	 * 查询点赞
	 * */
	@GET
	@Path("selectThumbsUp")
	public ReturnMsg selectThumbsUp(@QueryParam("nodeId")int nodeId,@QueryParam("gId") int gId, @QueryParam("uId") Integer uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("1","查询点赞数失败!");
		try {

			Article article = null;
			if(uId != null) {
				//查询是否已有点赞信息
				article = dao.getArticle(nodeId,uId,gId);
			}
			
			//查询点赞数
			int count = dao.selectCountArticle(nodeId,gId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("count", count);
			
			if(article == null) {
				map.put("istrue", false);
			}else {
				map.put("istrue", article.isTrue());
			}
			
			msg.setMsg(map);
			msg.setStatus("0");
			msg.setStatusMsg("查询点赞数成功！");
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(0);
			msg.setStatus("2");
			msg.setStatusMsg("查询点赞数失败！");
		}
		return msg;
	}

	/**
	 * 插入评论 
	 */
	@POST
	@Path("comment")
	public ReturnMsg comment(String data) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","评论失败!");
		try {
			//获取评论信息
			ArticleComment comment = JSONObject.parseObject(data,ArticleComment.class);
			
			if(comment != null && !comment.getContent().equals("")) {
				//插入评论信息
				User user = dao.selectUser(comment.getUid());
				System.out.println("---------------"+user.toString());
				if(user != null) {
					if(user.getChineseName() != null) {
						comment.setNickName(user.getChineseName());
					}else {
						comment.setNickName(user.getUserName()+"");
					}
				}
				
				int i = dao.insertComment(comment);
				if(i > 0) {
					List<ArticleComment> list = dao.selectComment(comment.getNodeId(),comment.getGid());
					msg.setMsg(list);
					msg.setStatus("0");
					msg.setStatusMsg("评论成功！");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("评论失败！");
		}
		return msg;
	}
	
	/**
	 * 查询评论
	 * */
	@GET
	@Path("selectComment")
	public ReturnMsg selectComment(@QueryParam("nodeId")int nodeId,@QueryParam("gId") int gId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","查询评论失败!");
		try {
			
			//查询所有评论集合
			List<ArticleComment> list = dao.selectComment(nodeId,gId);
			msg.setMsg(list);
			msg.setStatus("0");
			msg.setStatusMsg("查询评论成功");
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询评论失败！");
		}
		return msg;
	}
	
	/**
	 * 删除评论
	 * */
	@GET
	@Path("delComment")
	public ReturnMsg deleteComment(@QueryParam("id")int id) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","删除异常");
		try {
			
			int i = (int) dao.deleteById(id);
			if(i > 0) {
				msg.setStatus("0");
				msg.setStatusMsg("删除成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("删除失败！");
		}
		
		return msg;
	}
	
	/**
	 * 收藏
	 */
	@SuppressWarnings("unused")
	@POST
	@Path("collection")
	public ReturnMsg collection(String data) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","收藏失败!");
		try {
			
			//获取收藏信息
			ArticleCollection collection = JSONObject.parseObject(data,ArticleCollection.class);
			
			//查询是否已有收藏信息
			ArticleCollection collections  = dao.getCollectionGid(collection.getNodeId(), collection.getGid(), collection.getUid());

			//查询收藏数
			if(collections == null) {
				//插入收藏信息
				int i = dao.insertCollection(collection);
				if(i > 0) {
					msg.setMsg(true);
					msg.setStatus("0");
					msg.setStatusMsg("收藏成功！");
				}
			}else {
				//更新收藏信息
				collections.setIsTrue(!collections.getIsTrue());
				dao.updateCollection(collections);
				if(collections.getIsTrue()) {
					msg.setMsg(collections.getIsTrue());
					msg.setStatus("0");
					msg.setStatusMsg("收藏成功！");
				}else {
					msg.setMsg(collections.getIsTrue());
					msg.setStatus("1");
					msg.setStatusMsg("取消收藏！");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("收藏失败！");
		}
		return msg;
	}

	/**
	 * 查询收藏夹 - 个人中心
	 * */
	@GET
	@Path("selectCollection")
	public ReturnMsg selectCollection(@QueryParam("uId")int uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","查询收藏夹失败！");
		try {
			
			List<ArticleCollection> articleCollection = dao.selectCollection(uId);
			if(articleCollection != null) {
				msg.setMsg(articleCollection);
				msg.setStatus("0");
				msg.setStatusMsg("查询收藏夹成功！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询收藏夹失败！");
		}
		return msg;
	}
	
	/**
	 * 获取是否已经收藏
	 * */
	@GET
	@Path("getCollectionGid")
	public ReturnMsg selectCollection(@QueryParam("nodeId")int nodeId,@QueryParam("gId") int gId, @QueryParam("uId") int uId) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","查询是否收藏异常！");
		try {
			
			ArticleCollection articleCollection = dao.getCollectionGid(nodeId,gId,uId);
			if(articleCollection != null) {
				msg.setMsg(true);
				msg.setStatus("0");
				msg.setStatusMsg("已收藏！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("2");
			msg.setStatusMsg("查询是否收藏异常！");
		}
		return msg;
	}


	/**
	 * 删除收藏 - 个人中心
	 * */
	@GET
	@Path("reCollection")
	public ReturnMsg reCollection(@QueryParam("id")int id) {
		ReturnMsg<Object> msg = new ReturnMsg<Object>("2","取消异常！");
		try {
			
			int i = dao.reCollection(id);
			if(i > 0) {
				msg.setMsg(true);
				msg.setStatus("0");
				msg.setStatusMsg("取消成功！");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			msg.setMsg(false);
			msg.setStatus("2");
			msg.setStatusMsg("取消失败！");
		}
		return msg;
	}

}
 