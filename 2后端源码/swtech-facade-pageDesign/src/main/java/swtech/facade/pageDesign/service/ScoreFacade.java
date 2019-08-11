package swtech.facade.pageDesign.service;

import java.util.List;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ScoreInfo;
import swtech.facade.pageDesign.entity.StatisticalMaterial;

/*
 * 
 * @ClassName: ScoreFacade
 * @author 曾智宏
 * @date 2019年5月25日
 * @Description: 评分控件暴露的接口
 *
 */
public interface ScoreFacade {

	public ReturnMsg  saveScoreInfo(ScoreInfo scoreInfo);

	public ReturnMsg deleteScoreInfo(List<Integer> ids);

	public ReturnMsg getScoreResultToOneRecord(Integer nodeId, Integer selectId);

	public ReturnMsg getScoreResultAndRecordCount(Integer nodeId);

	public ReturnMsg getSelectIdByNodeIdAndscoreResult(Integer nodeId,Integer scoreResult);

	public ReturnMsg getCountsByStatisticalMaterials(List<StatisticalMaterial> smList);




}
