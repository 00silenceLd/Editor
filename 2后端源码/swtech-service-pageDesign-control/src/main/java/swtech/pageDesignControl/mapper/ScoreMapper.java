package swtech.pageDesignControl.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.CommentInfo;
import swtech.pageDesignControl.entity.ScoreInfo;
import swtech.pageDesignControl.entity.TestEntity;

/*
 * 
   

 *
 *
 *             ,%%%%%%%%, 
 *           ,%%/\%%%%/\%% 
 *          ,%%%\c "" J/%%% 
 * %.       %%%%/ o  o \%%% 
 * `%%.     %%%%    _  |%%% 
 *  `%%     `%%%%(__Y__)%%' 
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%' 
 *  \\    .'          | 
 *   \\  /       \  | | 
 *    \\/         ) | | 
 *     \         /_ | |__ 
 *     (___________))))))) 攻城湿 
 *
 * @QualifiedName:swtech.pageDesignControl.mapper.ScoreMapper
 * @ClassName: ScoreMapper
 * @Author 曾智宏
 * @Date 2019年7月31日 下午5:11:54
 * @Description: 编辑器评分控件持久层接口
 *
 */
public interface ScoreMapper extends BaseMapper<ScoreInfo>{

	Integer saveScoreInfo(ScoreInfo scoreInfo);

	Integer updateScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo);

	Integer deleteScoreInfoById(Integer id);

	Integer getScoreResultByNodeIdAndSelectId(ScoreInfo scoreInfo);

	String getSourceNameBySourceNodeId(Integer nodeId);

	List<Integer> getIdsByNodeIdAndScoreResult(Integer nodeId, Integer scoreResult);

	Integer getIdOfNotDelete(Integer id, String tableName);//可能有问题

	Integer getResultCountByTableName(String tableName);

	List<Integer> getSelectIdByNodeIdAndscoreResult(ScoreInfo scoreInfo);

	Integer getCountByNodeIdAndSelectId(ScoreInfo scoreInfo);


}
