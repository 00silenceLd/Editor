package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;


/*
 * 
* @ClassName: ScoreInfo
* @author 曾智宏
* @date 2019年5月25日
* @Description: 评分控件中央记录表实体类
*
 */
public class ScoreInfo extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;//
	private Integer nodeId;//该评分所属的页面nodeId
	private Integer selectId;//该评分所属的页面的记录id
	private Integer scoreResult;//评分结果（1~5）
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getSelectId() {
		return selectId;
	}
	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}
	public Integer getScoreResult() {
		return scoreResult;
	}
	public void setScoreResult(Integer scoreResult) {
		this.scoreResult = scoreResult;
	}
	@Override
	public String toString() {
		return "ScoreInfo [id=" + id + ", nodeId=" + nodeId + ", selectId=" + selectId + ", scoreResult=" + scoreResult
				+ "]";
	}
	
	
	
	
	
	
	
	
}
 