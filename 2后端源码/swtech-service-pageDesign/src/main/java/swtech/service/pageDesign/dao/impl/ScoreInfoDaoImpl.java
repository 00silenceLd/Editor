package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.ClassifyNode;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;
import swtech.facade.pageDesign.entity.ScoreInfo;
import swtech.service.pageDesign.dao.ScoreInfoDao;



/*
 * 

 ┏┓　　　┏┓
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
 * @ClassName: ScoreInfoDaoImpl
 * @author 曾智宏
 * @date 2019年5月25日
 * @Description: 评分控件dao实现类
 *
 */
@Repository("scoreInfoDao")
//@Transactional
public class ScoreInfoDaoImpl extends BaseDaoImpl<ScoreInfo> implements ScoreInfoDao{
	private static final Logger log = LoggerFactory.getLogger(ScoreInfoDaoImpl.class);

	@Override
	public Integer getCountByNodeIdAndSelectId(ScoreInfo scoreInfo) {
		Integer count = getSessionTemplate().selectOne("getCountByNodeIdAndSelectId", scoreInfo);
		return count;
	}

	@Override
	public Integer saveScoreInfo(ScoreInfo scoreInfo) {
		getSessionTemplate().insert("saveScoreInfo", scoreInfo);
		Integer id = scoreInfo.getId();
		return id;
	}

	@Override
	public Integer updateScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo) {
		Integer row = getSessionTemplate().update("updateScoreResultByNodeIdAndSelectId", scoreInfo);
		return row;
	}

	@Override
	public Integer deleteScoreInfoById(Integer id) {
		Integer row = getSessionTemplate().delete("deleteScoreInfoById", id);
		return row;
	}

	@Override
	public Integer getScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo) {
		Integer scoreResult = getSessionTemplate().selectOne("getScoreResultByNodeIdAndSelectId", scoreInfo);
		return scoreResult;
	}

	@Override
	public Integer getcountByNodeIdAndScoreResult(Integer nodeId, Integer scoreResult) {
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("nodeId", nodeId);
		paramMap.put("scoreResult", scoreResult);
		Integer count = getSessionTemplate().selectOne("getcountByNodeIdAndScoreResult", paramMap);
		return count;
	}

	@Override
	public List<Integer> getSelectIdByNodeIdAndscoreResult(ScoreInfo scoreInfo) {
		List<Integer> selectIdList = 
				getSessionTemplate().selectList("getSelectIdByNodeIdAndscoreResult", scoreInfo);
		return selectIdList;
	}

	@Override
	public String getSourceNameBySourceNodeId(Integer sourceNodeId) {
		String tableName = 
				getSessionTemplate().selectOne("getSourceNameBySourceNodeId", sourceNodeId);
		return tableName;
	}

	@Override
	public Integer getResultCountByTableName(String tableName) {
		Map<String, String> paramMap = new HashMap<String,String>();
		paramMap.put("tableName", tableName);
		Integer resultCount = getSessionTemplate().selectOne("getResultCountByTableName", paramMap);
		return resultCount;
	}

	@Override
	public List<Integer> getIdsByNodeIdAndScoreResult(Integer nodeId, Integer scoreResult) {
		Map<String, Integer> paramMap = new HashMap<String,Integer>();
		paramMap.put("nodeId", nodeId);
		paramMap.put("scoreResult", scoreResult);
		List<Integer> ids = getSessionTemplate().selectList("getIdsByNodeIdAndScoreResult", paramMap);
		return ids;
	}

	@Override
	public Integer getIdOfNotDelete(Integer id, String tableName) {
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("tableName", tableName);
		Integer id2 = getSessionTemplate().selectOne("getIdOfNotDelete", paramMap);
		return id2;
	}




}
