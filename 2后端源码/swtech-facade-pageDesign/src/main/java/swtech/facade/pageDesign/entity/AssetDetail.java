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

 *	When I wrote this, only God and I understood what I was doing
 *	Now, God only knows
 *	写这段代码的时候，只有上帝和我知道它是干嘛的
 *	现在，只有上帝知道
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
 * @QualifiedName:swtech.facade.pageDesign.entity.AssetDetail
 * @ClassName: AssetDetail
 * @Author 曾智宏
 * @Date 2019年7月25日 下午1:29:01
 * @Description: 资产明细实体类
 *
 *
 *
 */

public class AssetDetail extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer nodeId;
	private String assetName;
	private Double totalArea;
	private Double noContractArea;
	private Double contractArea;
	private Double independentManagementArea;
	private Double independentManagementIncome;
	private Double rentoutManagementArea;
	private String rentoutMan;
	private String rentoutTime;
	private Double rentoutMoney;
	private Double otherManagementArea;
	private Double otherManagementIncome;
	private Double unificationManagementArea;
	private Double unificationManagementIncome;
	private String remark;
	private String remarks;
	private Integer orderNum;//额外属性





	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Double getTotalArea() {
		return totalArea;
	}
	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
	}
	public Double getNoContractArea() {
		return noContractArea;
	}
	public void setNoContractArea(Double noContractArea) {
		this.noContractArea = noContractArea;
	}
	public Double getContractArea() {
		return contractArea;
	}
	public void setContractArea(Double contractArea) {
		this.contractArea = contractArea;
	}
	public Double getIndependentManagementArea() {
		return independentManagementArea;
	}
	public void setIndependentManagementArea(Double independentManagementArea) {
		this.independentManagementArea = independentManagementArea;
	}
	public Double getIndependentManagementIncome() {
		return independentManagementIncome;
	}
	public void setIndependentManagementIncome(Double independentManagementIncome) {
		this.independentManagementIncome = independentManagementIncome;
	}
	public Double getRentoutManagementArea() {
		return rentoutManagementArea;
	}
	public void setRentoutManagementArea(Double rentoutManagementArea) {
		this.rentoutManagementArea = rentoutManagementArea;
	}
	public String getRentoutMan() {
		return rentoutMan;
	}
	public void setRentoutMan(String rentoutMan) {
		this.rentoutMan = rentoutMan;
	}
	public String getRentoutTime() {
		return rentoutTime;
	}
	public void setRentoutTime(String rentoutTime) {
		this.rentoutTime = rentoutTime;
	}
	public Double getRentoutMoney() {
		return rentoutMoney;
	}
	public void setRentoutMoney(Double rentoutMoney) {
		this.rentoutMoney = rentoutMoney;
	}
	public Double getOtherManagementArea() {
		return otherManagementArea;
	}
	public void setOtherManagementArea(Double otherManagementArea) {
		this.otherManagementArea = otherManagementArea;
	}
	public Double getOtherManagementIncome() {
		return otherManagementIncome;
	}
	public void setOtherManagementIncome(Double otherManagementIncome) {
		this.otherManagementIncome = otherManagementIncome;
	}
	public Double getUnificationManagementArea() {
		return unificationManagementArea;
	}
	public void setUnificationManagementArea(Double unificationManagementArea) {
		this.unificationManagementArea = unificationManagementArea;
	}
	public Double getUnificationManagementIncome() {
		return unificationManagementIncome;
	}
	public void setUnificationManagementIncome(Double unificationManagementIncome) {
		this.unificationManagementIncome = unificationManagementIncome;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "AssetDetail [id=" + id + ", nodeId=" + nodeId + ", assetName=" + assetName + ", totalArea=" + totalArea
				+ ", noContractArea=" + noContractArea + ", contractArea=" + contractArea
				+ ", independentManagementArea=" + independentManagementArea + ", independentManagementIncome="
				+ independentManagementIncome + ", rentoutManagementArea=" + rentoutManagementArea + ", rentoutMan="
				+ rentoutMan + ", rentoutTime=" + rentoutTime + ", rentoutMoney=" + rentoutMoney
				+ ", otherManagementArea=" + otherManagementArea + ", otherManagementIncome=" + otherManagementIncome
				+ ", unificationManagementArea=" + unificationManagementArea + ", unificationManagementIncome="
				+ unificationManagementIncome + ", remark=" + remark + ", remarks=" + remarks + ", orderNum=" + orderNum
				+ "]";
	}





}
