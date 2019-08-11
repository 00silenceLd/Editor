package swtech.pageDesignControl.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.AssetDetail;
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
 * @QualifiedName:swtech.pageDesignControl.mapper.CJDJAssetDetailMapper
 * @ClassName: CJDJAssetDetailMapper
 * @Author 曾智宏
 * @Date 2019年7月31日 下午4:38:53
 * @Description: 曹江党建站点中资产明细表控件功能的持久层接口
 *
 */

public interface CJDJAssetDetailMapper extends BaseMapper<AssetDetail>{

	List<AssetDetail> getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit);

	Integer getAssetDetailCountByNodeId(Integer nodeId);

	Integer saveAssetDetail(AssetDetail assetDetail);

	Integer deleteAssetDetail(Integer id);

	Integer updateAssetDetail(AssetDetail assetDetail);

}
