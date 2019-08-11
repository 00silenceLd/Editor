package swtech.service.pageDesign.dao;

import java.util.List;


import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.AssetDetail;
import swtech.facade.pageDesign.entity.WebUrlManage;


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
 * @QualifiedName:swtech.service.pageDesign.dao.AssetDetailDao
 * @ClassName: AssetDetailDao
 * @Author 曾智宏
 * @Date 2019年7月25日 下午1:28:11
 * @Description: 资产明细表持久层接口
 *
 *
 *
 */
public interface AssetDetailDao extends BaseDao<AssetDetail>{

	List<AssetDetail> getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit);

	Integer saveAssetDetail(AssetDetail assetDetail);

	Integer deleteAssetDetail(Integer id);

	Integer updateAssetDetail(AssetDetail assetDetail);

	Integer getAssetDetailCountByNodeId(Integer nodeId);


}
