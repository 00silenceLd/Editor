package swtech.facade.pageDesign.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;

import swtech.common.entity.BaseEntity;

/**
 *
 * @author 曾智宏
 *
 * @version 1.0
 *
 * 创建时间：
 *
 *统计素材
 * 
 * 实体类
 *
 */

public class StatisticalMaterial extends BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String statisticsTitle;//该统计素材的标题
	private List<Integer> sourceNodeIds;//数据源nodeId
	private List<String> sourceNames;//数据源中文名
	private List<String> titlefields;//数据源标题字段
	private List<String> contextfields;//数据源简介字段
	private Integer resultCount;//该数据源表的记录数
	
	
	
	
	public List<String> getTitlefields() {
		return titlefields;
	}
	public void setTitlefields(List<String> titlefields) {
		this.titlefields = titlefields;
	}
	public List<String> getContextfields() {
		return contextfields;
	}
	public void setContextfields(List<String> contextfields) {
		this.contextfields = contextfields;
	}
	public String getStatisticsTitle() {
		return statisticsTitle;
	}
	public void setStatisticsTitle(String statisticsTitle) {
		this.statisticsTitle = statisticsTitle;
	}
	public Integer getResultCount() {
		return resultCount;
	}
	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}
	public List<Integer> getSourceNodeIds() {
		return sourceNodeIds;
	}
	public void setSourceNodeIds(List<Integer> sourceNodeIds) {
		this.sourceNodeIds = sourceNodeIds;
	}
	public List<String> getSourceNames() {
		return sourceNames;
	}
	public void setSourceNames(List<String> sourceNames) {
		this.sourceNames = sourceNames;
	}
	@Override
	public String toString() {
		return "StatisticalMaterial [statisticsTitle=" + statisticsTitle + ", sourceNodeIds=" + sourceNodeIds
				+ ", sourceNames=" + sourceNames + ", titlefields=" + titlefields + ", contextfields=" + contextfields
				+ ", resultCount=" + resultCount + "]";
	}






}
