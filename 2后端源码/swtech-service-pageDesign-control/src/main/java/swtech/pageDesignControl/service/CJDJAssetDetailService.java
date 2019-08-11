package swtech.pageDesignControl.service;

import java.util.List;

import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.AssetDetail;
import swtech.pageDesignControl.entity.CommentInfo;

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
 * @QualifiedName:swtech.pageDesignControl.service.CJDJAssetDetailService
 * @ClassName: CJDJAssetDetailService
 * @Author 曾智宏
 * @Date 2019年7月31日 下午4:37:25
 * @Description: 曹江党建站点中资产明细表控件功能的业务层接口
 *
 */
public interface CJDJAssetDetailService {

	QueryReturn getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit);

	ReturnMsg saveAssetDetail(AssetDetail assetDetail);

	ReturnMsg deleteAssetDetail(List<Integer> idList);

	ReturnMsg updateAssetDetail(AssetDetail assetDetail);
}
