package swtech.facade.pageDesign.service;


import java.util.List;


import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.AssetDetail;
import swtech.facade.pageDesign.entity.LayuiTabReturn;

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
 *
 * @ClassName: AssetDetailFacae
 * @author 曾智宏
 * @date 2019年7月25日
 * @Description: 资产明细表dubbo暴露接口
 * 	
 */

public interface AssetDetailFacae {

	public LayuiTabReturn getAssetDetailByNodeId(Integer nodeId,Integer page,Integer limit);

	public ReturnMsg saveAssetDetail(AssetDetail assetDetail);

	public ReturnMsg deleteAssetDetail(List<Integer> idList);

	public ReturnMsg updateAssetDetail(AssetDetail assetDetail);




}
