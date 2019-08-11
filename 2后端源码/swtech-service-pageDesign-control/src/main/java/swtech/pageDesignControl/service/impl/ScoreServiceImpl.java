package swtech.pageDesignControl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ScoreInfo;
import swtech.pageDesignControl.entity.StatisticalMaterial;
import swtech.pageDesignControl.mapper.ScoreMapper;
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
 * @QualifiedName:swtech.pageDesignControl.service.impl.ScoreServiceImpl
 * @ClassName: ScoreServiceImpl
 * @Author 曾智宏
 * @Date 2019年7月31日 下午5:11:01
 * @Description: 编辑器评分控件业务层实现类
 *
 */
@Service
public class ScoreServiceImpl implements ScoreService{
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ScoreServiceImpl.class);

	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public ReturnMsg saveScoreInfo(ScoreInfo scoreInfo) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		Integer nodeId = scoreInfo.getNodeId();
		Integer selectId = scoreInfo.getSelectId();
		Integer scoreResult = scoreInfo.getScoreResult();
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(selectId==null)throw new ServiceException("selectId不能为空");
		if(scoreResult==null)throw new ServiceException("scoreResult不能为空");

		System.out.println(scoreInfo);
		//判断数据库是否已存在该记录
		Integer count = scoreMapper.getCountByNodeIdAndSelectId(scoreInfo);

		Integer flat;
		Integer id = null;
		if(count==0) {//如果不存在，就执行保存
			id = scoreMapper.saveScoreInfo(scoreInfo);
			System.out.println("id="+id);
			if(id==null)throw new ServiceException("评分信息保存失败");
			flat = 1;
		}else {//执行修改
			Integer row = scoreMapper.updateScoreResultByNodeIdAndSelectId(scoreInfo);
			if(row==0)throw new ServiceException("评分结果修改失败");
			flat = 2;
		}




		if(flat==1) {
			msg.setStatus("200");
			msg.setStatusMsg("保存成功");
			msg.setMsg(id);
		}else {
			msg.setStatus("200");
			msg.setStatusMsg("修改成功");
		}


		return msg;
	}

	@Override
	public ReturnMsg deleteScoreInfo(List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();
		//检查合法性
		if(ids==null||ids.size()==0)throw new  ServiceException("id不能为空");

		//遍历ids
		for(Integer id:ids) {
			//删除scoreInfo
			Integer row = scoreMapper.deleteScoreInfoById(id);
			if(row==0)throw new  ServiceException("删除失败");
		}


		msg.setStatus("200");
		msg.setStatusMsg("删除成功");
		return msg;
	}

	@Override
	public ReturnMsg getScoreResultToOneRecord(Integer nodeId, Integer selectId) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		if(nodeId==null)throw new  ServiceException("nodeId不能为空");
		if(selectId==null)throw new  ServiceException("selectId不能为空");

		//根据nodeId和selectId查询该记录的分数
		ScoreInfo scoreInfo = new ScoreInfo();
		scoreInfo.setNodeId(nodeId);
		scoreInfo.setSelectId(selectId);
		Integer scoreResult = scoreMapper.getScoreResultByNodeIdAndSelectId(scoreInfo);
		if(scoreResult==null)scoreResult=0;



		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(scoreResult);
		return msg;
	}

	@Override
	public ReturnMsg getScoreResultAndRecordCount(Integer nodeId) {	
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		if(nodeId==null)throw new  ServiceException("nodeId不能为空");

		//根据nodeId查询该数据源中被评1~5分的记录各有多少人。
		Integer scoreResult = null;
		Map<String, Integer> resultMap = new HashMap<String,Integer>();

		//被评级的总数（因0级不在记录表中）
		Integer scoreCount = 0;

		//查询该数据源表名
		String tableName = scoreMapper.getSourceNameBySourceNodeId(nodeId);
		//查询各分人数/记录数
		for(int i=1;i<=5;i++) {
			//定义要查询的评分
			scoreResult = i;

			//根据nodeId与scoreResult查询ids
			List<Integer> ids = scoreMapper.getIdsByNodeIdAndScoreResult(nodeId,scoreResult);

		

			//根据表名查询该表ids中is_delete=0的id,用来过滤ids中已被删除记录的id
			List<Integer> ids2 = new ArrayList<>();
			for(Integer id:ids) {
				Integer tid = scoreMapper.getIdOfNotDelete(id,tableName);
				if(tid!=null) {
					ids2.add(tid);
				}
			}

			Integer count = ids2.size();

			resultMap.put("lv"+i, count);

			//获取被被评级的记录的总数
			scoreCount = scoreCount+count;
		}

		//查询数据表的记录数
		Integer allCount = scoreMapper.getResultCountByTableName(tableName);

		//求出未评级的个数（即0级）
		resultMap.put("lv0", allCount-scoreCount);



		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(resultMap);
		return msg;
	}

	@Override
	public ReturnMsg getSelectIdByNodeIdAndscoreResult(Integer nodeId, Integer scoreResult) {
		ReturnMsg msg = new ReturnMsg();

		//检查合法性
		if(nodeId==null)throw new  ServiceException("nodeId不能为空");
		if(scoreResult==null)throw new  ServiceException("scoreResult不能为空");

		//根据nodeId与scoreResult查询该评分下有哪些记录（selectId）
		ScoreInfo scoreInfo = new ScoreInfo();
		scoreInfo.setNodeId(nodeId);
		scoreInfo.setScoreResult(scoreResult);
		List<Integer> selectIdList = scoreMapper.getSelectIdByNodeIdAndscoreResult(scoreInfo);
		if(selectIdList==null)throw new  ServiceException("查询记录id失败");


		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(selectIdList);
		return msg;
	}

	@Override
	public ReturnMsg getCountsByStatisticalMaterials(List<StatisticalMaterial> smList) {
		ReturnMsg msg = new ReturnMsg();

		List<StatisticalMaterial> smList2 = new ArrayList<StatisticalMaterial>();
		//遍历
		for(StatisticalMaterial sm : smList) {
			//检查合法性
			String statisticsTitle = sm.getStatisticsTitle();
			List<Integer> sourceNodeIds = sm.getSourceNodeIds();
			List<String> sourceNames = sm.getSourceNames();
			List<String> titlefields = sm.getTitlefields();
			List<String> contextfields = sm.getContextfields();
			if(!StringUtils.hasText(statisticsTitle))throw new  ServiceException("title不能为空");
			if(sourceNodeIds.size()==0)throw new  ServiceException("sourceNodeIds不能为空");
			if(sourceNames.size()==0)throw new  ServiceException("sourceNames不能为空");
			if(titlefields.size()==0)throw new  ServiceException("titlefields不能为空");
			if(contextfields.size()==0)throw new  ServiceException("contextfields不能为空");

			//根据nodeId查询数据表名
			Integer resultCount = 0;
			for(Integer sourceNodeId: sourceNodeIds) {
				String tableName = scoreMapper.getSourceNameBySourceNodeId(sourceNodeId);
				if(!StringUtils.hasText(tableName))throw new  ServiceException("查询数据表失败");

				//查询数据表的记录数
				Integer count = scoreMapper.getResultCountByTableName(tableName);
				//				if(count==0)throw new  ServiceException("查询数据记录失败");

				resultCount+=count;
			}






			StatisticalMaterial sm2 = new StatisticalMaterial();
			sm2.setStatisticsTitle(statisticsTitle);
			sm2.setSourceNodeIds(sourceNodeIds);
			sm2.setSourceNames(sourceNames);
			sm2.setTitlefields(titlefields);
			sm2.setContextfields(contextfields);
			sm2.setResultCount(resultCount);
			smList2.add(sm2);
		}




		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		msg.setMsg(smList2);
		return msg;
	}


	
	

}
