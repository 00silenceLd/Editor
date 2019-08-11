package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
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
 * @QualifiedName:swtech.pageDesignControl.entity.AssetDetail
 * @ClassName: AssetDetail
 * @Author 曾智宏
 * @Date 2019年7月31日 下午4:36:38
 * @Description: 曹江党建站点中资产明细表控件功能的实体类
 *
 */
@Data
@TableName("ht_asset_detail")
public class AssetDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId
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





}