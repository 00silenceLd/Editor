package swtech.pageDesignControl.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.AssetDetail;
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
 * @QualifiedName:swtech.pageDesignControl.controller.CJDJAssetDetailController
 * @ClassName: CJDJAssetDetailController
 * @Author 曾智宏
 * @Date 2019年7月31日 下午4:35:34
 * @Description: 曹江党建站点中资产明细表控件功能的控制层
 *
 */
@RestController
@RequestMapping(value="/assetDetailFacae")
@CrossOrigin
public class CJDJAssetDetailController {
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(CJDJAssetDetailController.class);

	@Autowired
	private CJDJAssetDetailService cjdjAssetDetailService;


	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午4:40:13
	 * @QualifiedName:swtech.pageDesignControl.controller.CJDJAssetDetailController
	 * @MethodName: getAssetDetailByNodeId
	 * @param nodeId
	 * @param page
	 * @param limit
	 * @return QueryReturn
	 * @Description: 根据页面nodeId获取资产明细表信息
	 *
	 */

	@RequestMapping(value="/getAssetDetailByNodeId",method=RequestMethod.GET)
	public QueryReturn getAssetDetailByNodeId(Integer nodeId,Integer page, Integer limit) {
		QueryReturn result = new QueryReturn();
		try {
			result = cjdjAssetDetailService.getAssetDetailByNodeId(nodeId,page,limit);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			result.setStatus("201");
			result.setStatusMsg("查询资产明细失败");
			result.setMsg(e.getMessage());
		}
		return result;
	}

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午4:41:02
	 * @QualifiedName:swtech.pageDesignControl.controller.CJDJAssetDetailController
	 * @MethodName: saveAssetDetail
	 * @param assetDetail
	 * @return ReturnMsg
	 * @Description: 保存资产明细表内容
	 *
	 */

	@RequestMapping(value="/saveAssetDetail",method=RequestMethod.POST)
	public ReturnMsg saveAssetDetail(@RequestBody AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = cjdjAssetDetailService.saveAssetDetail(assetDetail);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存资产明细信息失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午4:41:40
	 * @QualifiedName:swtech.pageDesignControl.controller.CJDJAssetDetailController
	 * @MethodName: deleteAssetDetail
	 * @param idList
	 * @return ReturnMsg
	 * @Description: 删除资产明细表记录
	 *
	 */

	@RequestMapping(value="/deleteAssetDetail",method=RequestMethod.POST)
	public ReturnMsg deleteAssetDetail(@RequestBody List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = cjdjAssetDetailService.deleteAssetDetail(idList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("删除资产明细记录失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月31日 下午4:42:10
	 * @QualifiedName:swtech.pageDesignControl.controller.CJDJAssetDetailController
	 * @MethodName: updateAssetDetail
	 * @param assetDetail
	 * @return ReturnMsg
	 * @Description:修改资产明细表内容
	 *
	 */

	@RequestMapping(value="/updateAssetDetail",method=RequestMethod.POST)
	public ReturnMsg updateAssetDetail(@RequestBody AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = cjdjAssetDetailService.updateAssetDetail(assetDetail);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("修改资产明细信息失败");
			msg.setMsg(e.getMessage());
		}
		System.out.println(msg.toString());
		return msg;
	}




}
