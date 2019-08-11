package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.AssetDetail;
import swtech.facade.pageDesign.entity.WebUrlManage;
import swtech.service.pageDesign.dao.AssetDetailDao;




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
 * @QualifiedName:swtech.service.pageDesign.dao.impl.AssetDetailDaoImpl
 * @ClassName: AssetDetailDaoImpl
 * @Author 曾智宏
 * @Date 2019年7月25日 下午1:28:23
 * @Description: 资产明细表持久层接口实现类
 *
 *
 *
 */


@Repository("assetDetailDao")
public class AssetDetailDaoImpl extends BaseDaoImpl<AssetDetail> implements AssetDetailDao{
	private static final Logger logger = LoggerFactory.getLogger(AssetDetailDaoImpl.class);

	@Override
	public List<AssetDetail> getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit) {
		Integer begin = page*limit-limit;
		Map<String, Integer> pageMap = new HashMap<String,Integer>();
		pageMap.put("begin", begin);
		pageMap.put("limit", limit);
		pageMap.put("nodeId", nodeId);
		
		List<AssetDetail> assetDetailList = 
				getSessionTemplate().selectList("getAssetDetailByNodeId",pageMap);

		return assetDetailList;
	}

	@Override
	public Integer saveAssetDetail(AssetDetail assetDetail) {
		Integer row = getSessionTemplate().insert("saveAssetDetail", assetDetail);
		return row;
	}

	@Override
	public Integer deleteAssetDetail(Integer id) {
		Integer row = getSessionTemplate().delete("deleteAssetDetail", id);
		return row;
	}

	@Override
	public Integer updateAssetDetail(AssetDetail assetDetail) {
		Integer row = getSessionTemplate().update("updateAssetDetail", assetDetail);
		return row;
	}

	@Override
	public Integer getAssetDetailCountByNodeId(Integer nodeId) {
		Integer count = getSessionTemplate().selectOne("getAssetDetailCountByNodeId", nodeId);
		return count;
	}






}
