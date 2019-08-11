package swtech.pageDesignControl.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ScoreInfo;
import swtech.pageDesignControl.entity.StatisticalMaterial;
import swtech.pageDesignControl.service.ScoreService;

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
 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
 * @ClassName: ScoreController
 * @Author 曾智宏
 * @Date 2019年7月31日 下午5:10:01
 * @Description: 编辑器评分控件控制层
 *
 */
@RestController
@RequestMapping(value="/scoreFacade")
@CrossOrigin
public class ScoreController {
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ScoreController.class);

	@Autowired
	private ScoreService scoreService;

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:08:55
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: saveScoreInfo
	 * @param scoreInfo
	 * @return
	 * @Description:保存评分信息
	 *
	 */
	@RequestMapping(value="/saveScoreInfo",method=RequestMethod.POST)
	public ReturnMsg saveScoreInfo(@RequestBody ScoreInfo scoreInfo) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.saveScoreInfo(scoreInfo);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
			msg.setMsg(e.getMessage());
		}


		return msg;
	}


	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:08:44
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: deleteScoreInfo
	 * @param ids
	 * @return
	 * @Description:该接口用于删除评分信息
	 *
	 */
	@RequestMapping(value="/deleteScoreInfo",method=RequestMethod.POST)
	public ReturnMsg deleteScoreInfo(@RequestBody List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.deleteScoreInfo(ids);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("删除失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}




	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:08:33
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: getScoreResultToOneRecord
	 * @param nodeId
	 * @param selectId
	 * @return
	 * @Description:该接口用于查询单条记录的评分结果
	 *
	 */
	@RequestMapping(value="/getScoreResultToOneRecord",method=RequestMethod.GET)
	public ReturnMsg getScoreResultToOneRecord(Integer nodeId, Integer selectId) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.getScoreResultToOneRecord(nodeId,selectId);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}



	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:08:23
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: getScoreResultAndRecordCount
	 * @param nodeId
	 * @return
	 * @Description: 该接口用于查询当前数据源下，各级评分的人数。
	 *
	 */
	@RequestMapping(value="/getScoreResultAndRecordCount",method=RequestMethod.GET)
	public ReturnMsg getScoreResultAndRecordCount(Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.getScoreResultAndRecordCount(nodeId);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}


	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:08:08
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: getSelectIdByNodeIdAndscoreResult
	 * @param nodeId
	 * @param scoreResult
	 * @return
	 * @Description:该接口用于查询当前数据源该级分数下所有记录id
	 *
	 */

	@RequestMapping(value="/getSelectIdByNodeIdAndscoreResult",method=RequestMethod.GET)
	public ReturnMsg getSelectIdByNodeIdAndscoreResult(Integer nodeId,Integer scoreResult) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.getSelectIdByNodeIdAndscoreResult(nodeId,scoreResult);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午6:07:52
	 * @QualifiedName:swtech.pageDesignControl.controller.ScoreController
	 * @MethodName: getCountsByStatisticalMaterials
	 * @param smList
	 * @return
	 * @Description: 该接口用于根据传入的统计素材，查询该素材的数量
	 *
	 */
	@RequestMapping(value="/getCountsByStatisticalMaterials",method=RequestMethod.POST)
	public ReturnMsg getCountsByStatisticalMaterials(@RequestBody List<StatisticalMaterial> smList) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = scoreService.getCountsByStatisticalMaterials(smList);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

}
