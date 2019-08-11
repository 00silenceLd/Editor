package swtech.facade.pageDesign.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.AssetDetail;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.service.AssetDetailFacaeService;
import swtech.facade.pageDesign.util.exception.ServiceException;
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
 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeServiceImpl
 * @ClassName: AssetDetailFacaeServiceImpl
 * @Author 曾智宏
 * @Date 2019年7月25日 下午1:27:52
 * @Description: 资产明细表业务实现类
 *
 *
 *
 */
@Component
public class AssetDetailFacaeServiceImpl implements AssetDetailFacaeService {
	private static final Logger logger = LoggerFactory.getLogger(AssetDetailFacaeServiceImpl.class);

	@Autowired
	private AssetDetailDao assetDetailDao;


	@Override
	public LayuiTabReturn getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit) {
		LayuiTabReturn result = new LayuiTabReturn();
		//验证参数合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(page==null)throw new ServiceException("page不能为.空");
		if(limit==null)throw new ServiceException("limit不能为空");

		//根据nodeId、page、limit查询资产明细记录
		List<AssetDetail> assetDetailList = assetDetailDao.getAssetDetailByNodeId(nodeId,page,limit);
		logger.info("查询资产明细表，结果为："+assetDetailList.toString());
		if(assetDetailList==null)throw new ServiceException("从数据库获取资产明细记录失败");

		//查询资产 总数
		Integer count = assetDetailDao.getAssetDetailCountByNodeId(nodeId);
		if(count==null)throw new ServiceException("查询总记录失败");
		
		//设置返回值
		result.setStatus("200");
		result.setStatusMsg("查询资产明细成功");
		result.setMsg(assetDetailList);
		result.setCount(count);
		return result;
	}

	@Override
	@Transactional
	public ReturnMsg saveAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		//验证参数合法性
		Integer nodeId = assetDetail.getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//将assetDetail保存进数据库
		Integer row = assetDetailDao.saveAssetDetail(assetDetail);
		if(row==0)throw new ServiceException("保存资产明细进数据库失败");


		msg.setStatus("200");
		msg.setStatusMsg("保存资产明细成功");
		return msg;
	}

	@Override
	@Transactional
	public ReturnMsg deleteAssetDetail(List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();
		//验证合法性
		if(idList==null||idList.size()==0)throw new ServiceException("需要删除的id不能为空");

		//遍历idList
		for(Integer id:idList) {
			//根据id删除资产明细记录
			Integer row = assetDetailDao.deleteAssetDetail(id);
			if(row==0)throw new ServiceException("删除资产明细数据库记录");
		}

		msg.setStatus("200");
		msg.setStatusMsg("删除资产明细成功");
		return msg;
	}

	@Override
	@Transactional
	public ReturnMsg updateAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		//验证合法性
		Integer id = assetDetail.getId();
		if(id==null)throw new ServiceException("id不能为空");

		//根据主键id修改资产明细记录
		Integer row = assetDetailDao.updateAssetDetail(assetDetail);
		if(row==0)throw new ServiceException("修改资产明细数据库记录");


		msg.setStatus("200");
		msg.setStatusMsg("修改资产明细成功");
		return msg;
	}




}
