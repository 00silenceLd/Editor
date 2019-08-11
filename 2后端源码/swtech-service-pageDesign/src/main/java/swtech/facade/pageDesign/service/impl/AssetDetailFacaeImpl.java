package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.AssetDetail;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.WebUrlManage;
import swtech.facade.pageDesign.service.AssetDetailFacae;
import swtech.facade.pageDesign.service.AssetDetailFacaeService;
import swtech.facade.pageDesign.service.WebUrlManageFacadeService;



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
 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeImpl
 * @ClassName: AssetDetailFacaeImpl
 * @Author 曾智宏
 * @Date 2019年7月25日 下午12:53:42
 * @Description: 资产明细表dubbo暴露接口实现类
 * 
 *
 *
 */

//
@Path("assetDetailFacae")
@Component("assetDetailFacae")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class AssetDetailFacaeImpl implements AssetDetailFacae{
	private static final Logger logger = LoggerFactory.getLogger(AssetDetailFacaeImpl.class);


	@Autowired
	private AssetDetailFacaeService assetDetailFacaeService;

	/*
	 * 
	 * @Author 曾智宏
	 * @Date 2019年7月25日 下午12:49:19
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeImpl
	 * @MethodName: getAssetDetailByNodeId
	 * @param nodeId
	 * @return LayuiTabReturn
	 * @Description: 根据当前页面nodeId查询该页面的资产明细记录
	 */
	@Override
	@GET
	@Path("/getAssetDetailByNodeId")
	public LayuiTabReturn getAssetDetailByNodeId(@QueryParam("nodeId") Integer nodeId
			,@QueryParam("page") Integer page,@QueryParam("limit") Integer limit) {
		LayuiTabReturn result = new LayuiTabReturn();
		try {
			result = assetDetailFacaeService.getAssetDetailByNodeId(nodeId,page,limit);
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
	 * @Date 2019年7月25日 下午1:31:36
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeImpl
	 * @MethodName: saveAssetDetail
	 * @param assetDetail
	 * @return ReturnMsg
	 * @Description: 保存资产明细信息
	 *
	 */
	@Override
	@POST
	@Path("/saveAssetDetail")
	public ReturnMsg saveAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = assetDetailFacaeService.saveAssetDetail(assetDetail);
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
	 * @Date 2019年7月25日 下午1:32:31
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeImpl
	 * @MethodName: deleteAssetDetail
	 * @param idList
	 * @return ReturnMsg
	 * @Description: 删除资产明细记录
	 *
	 */

	@Override
	@POST
	@Path("/deleteAssetDetail")
	public ReturnMsg deleteAssetDetail(List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = assetDetailFacaeService.deleteAssetDetail(idList);
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
	 * @Date 2019年7月25日 下午1:33:01
	 * @QualifiedName:swtech.facade.pageDesign.service.impl.AssetDetailFacaeImpl
	 * @MethodName: updateAssetDetail
	 * @param assetDetail
	 * @return ReturnMsg
	 * @Description: 修改资产明细信息
	 *
	 */
	@Override
	@POST
	@Path("/updateAssetDetail")
	public ReturnMsg updateAssetDetail(AssetDetail assetDetail) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = assetDetailFacaeService.updateAssetDetail(assetDetail);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("修改资产明细信息失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}







}
