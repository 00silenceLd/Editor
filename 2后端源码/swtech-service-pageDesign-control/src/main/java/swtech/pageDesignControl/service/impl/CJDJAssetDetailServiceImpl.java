package swtech.pageDesignControl.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.AssetDetail;
import swtech.pageDesignControl.mapper.CJDJAssetDetailMapper;
import swtech.pageDesignControl.service.CJDJAssetDetailService;



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
 * @QualifiedName:swtech.pageDesignControl.service.impl.CJDJAssetDetailServiceImpl
 * @ClassName: CJDJAssetDetailServiceImpl
 * @Author 曾智宏
 * @Date 2019年7月31日 下午4:37:53
 * @Description: 曹江党建站点中资产明细表控件功能的业务层实现类
 *
 */
@Service
public class CJDJAssetDetailServiceImpl implements CJDJAssetDetailService{
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(CJDJAssetDetailServiceImpl.class);
@Autowired
	private CJDJAssetDetailMapper cjdjAssetDetailMapper;
	
	@Override
	public QueryReturn getAssetDetailByNodeId(Integer nodeId, Integer page, Integer limit) {
		QueryReturn result = new QueryReturn();
		//验证参数合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(page==null)throw new ServiceException("page不能为.空");
		if(limit==null)throw new ServiceException("limit不能为空");

		//根据nodeId、page、limit查询资产明细记录
		List<AssetDetail> assetDetailList = cjdjAssetDetailMapper.getAssetDetailByNodeId(nodeId,page,limit);
		logger.info("查询资产明细表，结果为："+assetDetailList.toString());
		if(assetDetailList==null)throw new ServiceException("从数据库获取资产明细记录失败");

		//查询资产 总数
		Integer count = cjdjAssetDetailMapper.getAssetDetailCountByNodeId(nodeId);
		if(count==null)throw new ServiceException("查询总记录失败");
		
		//设置返回值
		result.setStatus("200");
		result.setStatusMsg("查询资产明细成功");
		result.setMsg(assetDetailList);
		result.setCount(count);
		return result;
	}

	@Override
	public ReturnMsg saveAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		//验证参数合法性
		Integer nodeId = assetDetail.getNodeId();
		if(nodeId==null)throw new ServiceException("nodeId不能为空");

		//将assetDetail保存进数据库
		Integer row = cjdjAssetDetailMapper.saveAssetDetail(assetDetail);
		if(row==0)throw new ServiceException("保存资产明细进数据库失败");


		msg.setStatus("200");
		msg.setStatusMsg("保存资产明细成功");
		return msg;
	}

	@Override
	public ReturnMsg deleteAssetDetail(List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();
		//验证合法性
		if(idList==null||idList.size()==0)throw new ServiceException("需要删除的id不能为空");

		//遍历idList
		for(Integer id:idList) {
			//根据id删除资产明细记录
			Integer row = cjdjAssetDetailMapper.deleteAssetDetail(id);
			if(row==0)throw new ServiceException("删除资产明细数据库记录");
		}

		msg.setStatus("200");
		msg.setStatusMsg("删除资产明细成功");
		return msg;
	}

	@Override
	public ReturnMsg updateAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		//验证合法性
		Integer id = assetDetail.getId();
		if(id==null)throw new ServiceException("id不能为空");

		//根据主键id修改资产明细记录
		Integer row = cjdjAssetDetailMapper.updateAssetDetail(assetDetail);
		if(row==0)throw new ServiceException("修改资产明细数据库记录");

System.out.println(row);
		msg.setStatus("200");
		msg.setStatusMsg("修改资产明细成功");
		System.out.println(msg.toString());
		return msg;
	}
	

}
