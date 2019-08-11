package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Article;
import swtech.facade.pageDesign.entity.ArticleCollection;
import swtech.facade.pageDesign.entity.ArticleComment;
import swtech.facade.pageDesign.entity.CommentInfo;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.Node;
import swtech.facade.pageDesign.entity.User;

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
 * @description : 评论功能dao
 * ---------------------------------
 * @Author : 曾智宏
 * @since : Create in 2019-4-4 16:35:55
 **/
public interface CommentDataDao extends BaseDao<CommentInfo>{

	public ReturnMsg getComment(Integer nodeId,Integer selectId);
	public ReturnMsg releaseComment(CommentInfo commentInfo);

	public ReturnMsg deleteComment(Integer[] ids);
	public ReturnMsg passApproveComment(Integer[] ids);
	public LayuiTabReturn getNotApproveComment(Integer page, Integer limit);



}
