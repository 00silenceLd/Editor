package swtech.facade.pageDesign.service;


import java.util.List;


import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CommentInfo;
import swtech.facade.pageDesign.entity.LayuiTabReturn;

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

public interface CommentFacade {
	//根据nodeId、selectId查询该记录下的评论信息
	public ReturnMsg getComment(Integer nodeId,Integer selectId);
	//发布评论CommentInfo commentInfo
	public ReturnMsg releaseComment(CommentInfo commentInfo);
	//撤回或者不通过审核
	public ReturnMsg deleteComment(Integer[] ids);
	
	//通过审核
	public ReturnMsg passApproveComment(Integer[] ids);
	//获取未审核的评论
	public LayuiTabReturn getNotApproveComment(Integer page,Integer limit);
	
	

}
