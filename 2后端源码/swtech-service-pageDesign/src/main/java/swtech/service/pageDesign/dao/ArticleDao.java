package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.Article;
import swtech.facade.pageDesign.entity.ArticleCollection;
import swtech.facade.pageDesign.entity.ArticleComment;
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
 * @description : 章节功能dao
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月22日 下午2:54:56
 **/
public interface ArticleDao extends BaseDao<Article>{

	public Article getArticle(int nodeId, int uId, int gId);

	public int insertArticle(int nodeId, int uId, int gId);

	public int updateArticle(Article article);

	public int selectCountArticle(int nodeId, int gId);

	public int insertComment(ArticleComment comment);

	public List<ArticleComment> selectComment(int nodeId, int gId);

	public int insertCollection(ArticleCollection collection);

	public List<ArticleCollection> selectCollection(int uId);

	public User selectUser(int uid);

	public ArticleCollection getCollectionGid(int nodeId, int gId, int uId);

	public int reCollection(int id);

	public int updateCollection(ArticleCollection collection);

}
 