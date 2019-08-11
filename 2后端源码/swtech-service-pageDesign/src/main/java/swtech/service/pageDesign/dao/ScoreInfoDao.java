package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.ScoreInfo;

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
* @ClassName: ScoreInfoDao
* @author 曾智宏
* @date 2019年5月25日
* @Description: 评分控件dao接口
*
 */
public interface ScoreInfoDao extends BaseDao<ScoreInfo>{

	Integer getCountByNodeIdAndSelectId(ScoreInfo scoreInfo);

	Integer saveScoreInfo(ScoreInfo scoreInfo);

	Integer updateScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo);

	Integer deleteScoreInfoById(Integer id);

	Integer getScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo);

	Integer getcountByNodeIdAndScoreResult(Integer nodeId, Integer scoreResult);

	List<Integer> getSelectIdByNodeIdAndscoreResult(ScoreInfo scoreInfo);


	String getSourceNameBySourceNodeId(Integer sourceNodeId);

	Integer getResultCountByTableName(String tableName);

	List<Integer> getIdsByNodeIdAndScoreResult(Integer nodeId, Integer scoreResult);

	Integer getIdOfNotDelete(Integer id, String tableName);





}
