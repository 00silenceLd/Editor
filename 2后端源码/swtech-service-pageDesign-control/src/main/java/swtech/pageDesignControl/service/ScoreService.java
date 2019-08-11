package swtech.pageDesignControl.service;

import java.util.List;

import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.CommentInfo;
import swtech.pageDesignControl.entity.ScoreInfo;
import swtech.pageDesignControl.entity.StatisticalMaterial;

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
 * @QualifiedName:swtech.pageDesignControl.service.ScoreService
 * @ClassName: ScoreService
 * @Author 曾智宏
 * @Date 2019年7月31日 下午5:10:34
 * @Description:  编辑器评分控件业务层接口
 *
 */
public interface ScoreService {

	ReturnMsg saveScoreInfo(ScoreInfo scoreInfo);

	ReturnMsg deleteScoreInfo(List<Integer> ids);

	ReturnMsg getScoreResultToOneRecord(Integer nodeId, Integer selectId);

	ReturnMsg getScoreResultAndRecordCount(Integer nodeId);

	ReturnMsg getSelectIdByNodeIdAndscoreResult(Integer nodeId, Integer scoreResult);

	ReturnMsg getCountsByStatisticalMaterials(List<StatisticalMaterial> smList);

}
