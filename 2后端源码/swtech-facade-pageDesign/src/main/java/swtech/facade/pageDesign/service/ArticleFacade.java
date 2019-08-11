package swtech.facade.pageDesign.service;

import swtech.common.entity.ReturnMsg;

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
 * @description : 功能实现接口类
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月22日 下午2:16:14
 **/

public interface ArticleFacade {
	
	//点赞
	public ReturnMsg thumbsUp(int nodeId,int gId,int uId);
	
	//点赞数查询
	public ReturnMsg selectThumbsUp(int nodeId,int gId,Integer uId);
	
	//评论
	public ReturnMsg comment(String data);
	
	//评论查询
	public ReturnMsg selectComment(int nodeId,int gId);
	
	//删除评论
	public ReturnMsg deleteComment(int id);
	
	//收藏
	public ReturnMsg collection(String data);

	//查询收藏
	public ReturnMsg selectCollection(int uId);
	
	//查询是否收藏
	public ReturnMsg selectCollection(int nodeId,int gId,int uId);
	
	//取消收藏
	public ReturnMsg reCollection(int id);
}
 