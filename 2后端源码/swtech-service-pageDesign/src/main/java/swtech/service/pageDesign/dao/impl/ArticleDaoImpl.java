package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.Article;
import swtech.facade.pageDesign.entity.ArticleCollection;
import swtech.facade.pageDesign.entity.ArticleComment;
import swtech.facade.pageDesign.entity.User;
import swtech.service.pageDesign.dao.ArticleDao;

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
 * @description : 章节内容dao实现
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月22日 下午2:55:45
 **/
@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {
	private static final Logger log = LoggerFactory.getLogger(ArticleDaoImpl.class);

	public Article getArticle(int nodeId, int uId, int gId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", nodeId);
		map.put("uId", uId);
		map.put("gId", gId);
		return getSessionTemplate().selectOne("selectArticle", map);
	}

	public int insertArticle(int nodeId, int uId, int gId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", nodeId);
		map.put("uId", uId);
		map.put("gId", gId);
		return getSessionTemplate().insert("insertArticle",map);
	}

	public int updateArticle(Article article) {
		return getSessionTemplate().update("updateArticle",article);
	}


	public int selectCountArticle(int nodeId, int gId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", nodeId);
		map.put("gId",gId);
		
		return getSessionTemplate().selectOne("selectCountArticle", map);
	}

	public int insertComment(ArticleComment comment) {
		
		return getSessionTemplate().insert("insertComment",comment);
	}

	public List<ArticleComment> selectComment(int nodeId, int gId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", nodeId);
		map.put("gId", gId);
		
		return getSessionTemplate().selectList("selectComment",map);
	}

	public int insertCollection(ArticleCollection collection) {

		return getSessionTemplate().insert("insertCollection",collection);
	}

	public List<ArticleCollection>  selectCollection(int uId) {
		
		return getSessionTemplate().selectList("selectCollection",uId);
	}

	public User selectUser(int uid) {
		log.info("--------------------------"+uid);
		log.info("--------------------------"+uid);
		return getSessionTemplate().selectOne("selectUser",uid);
	}

	public ArticleCollection getCollectionGid(int nodeId, int gId, int uId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nodeId", nodeId);
		map.put("uId", uId);
		map.put("gId", gId);
		return getSessionTemplate().selectOne("getCollectionGid", map);
	}

	public int reCollection(int id) {

		return getSessionTemplate().delete("reCollection", id);
	}

	public int updateCollection(ArticleCollection collection) {

		return getSessionTemplate().update("updateCollection",collection);
	}

}
 