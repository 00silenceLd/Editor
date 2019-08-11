package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ScoreInfo;
import swtech.facade.pageDesign.entity.StatisticalMaterial;
import swtech.facade.pageDesign.service.ScoreFacade;
import swtech.facade.pageDesign.service.ScoreFacadeService;





/*
 * 
 * @ClassName: ScoreFacadeImpl
 * @author 曾智宏
 * @date 2019年5月25日
 * @Description: 评分控件暴露接口的实现类，用于接收请求
 *
 */
@Path("scoreFacade")
@Component("scoreFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class ScoreFacadeImpl implements ScoreFacade{
	private static final Logger log = LoggerFactory.getLogger(ScoreFacadeImpl.class);

	@Autowired
	private ScoreFacadeService sfs;



	/*
	 * 该接口用于保存评分信息，
	 * 将信息保存进ht_score_info表中
	 * 
	 */
	@Override
	@Path("/saveScoreInfo")
	@POST
	public ReturnMsg saveScoreInfo(ScoreInfo scoreInfo) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.saveScoreInfo(scoreInfo);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("保存失败");
			msg.setMsg(e.getMessage());
		}


		return msg;
	}


	/*
	 * 该接口用于删除评分信息
	 * 
	 */
	@Override
	@Path("/deleteScoreInfo")
	@POST
	public ReturnMsg deleteScoreInfo(List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.deleteScoreInfo(ids);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("删除失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}




	/*
	 * 该接口用于查询单条记录的评分结果
	 * 根据nodeId、selectId
	 */
	@Override
	@Path("/getScoreResultToOneRecord")
	@GET
	public ReturnMsg getScoreResultToOneRecord(
			@QueryParam("nodeId") Integer nodeId,@QueryParam("selectId") Integer selectId) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.getScoreResultToOneRecord(nodeId,selectId);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}



	/*
	 * 该接口用于查询当前数据源下，各级评分的人数。
	 * 根据nodeId
	 * lv1:12.....
	 */
	@Override
	@Path("/getScoreResultAndRecordCount")
	@GET
	public ReturnMsg getScoreResultAndRecordCount(@QueryParam("nodeId") Integer nodeId) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.getScoreResultAndRecordCount(nodeId);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}


	/*
	 * 该接口用于查询当前数据源该级分数下所有记录id
	 * 根据nodeId、scoreResult.
	 */
	@Override
	@Path("/getSelectIdByNodeIdAndscoreResult")
	@GET
	public ReturnMsg getSelectIdByNodeIdAndscoreResult(
			@QueryParam("nodeId") Integer nodeId,@QueryParam("scoreResult") Integer scoreResult) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.getSelectIdByNodeIdAndscoreResult(nodeId,scoreResult);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 该接口用于根据传入的统计素材，查询该素材的数量
	 *
	 * title;//该统计素材的标题
	 * sourceNodeId;//数据源nodeId
	 * sourceName;//数据源中文名
	 * browseNodeId;//浏览页面nodeId
	 * browseName;//浏览页中文名
	 * resultCount;//该数据源表的记录数
	 */
	@Override
	@Path("/getCountsByStatisticalMaterials")
	@POST
	public ReturnMsg getCountsByStatisticalMaterials(List<StatisticalMaterial> smList) {
		ReturnMsg msg = new ReturnMsg();

		try {
			msg = sfs.getCountsByStatisticalMaterials(smList);
		} catch (Exception e) {
			msg.setStatus("201");
			msg.setStatusMsg("查询失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}





}
