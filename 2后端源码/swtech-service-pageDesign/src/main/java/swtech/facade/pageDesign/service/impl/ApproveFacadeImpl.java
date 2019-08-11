package swtech.facade.pageDesign.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ApproveInfo;
import swtech.facade.pageDesign.service.ApproveInfoFacae;
import swtech.facade.pageDesign.service.ApproveInfoFacaeService;

/**
 *
 * @author 
 *
 * @version 1.0
 *

 *
 */

@Path("approveInfoFacae")
@Component("approveInfoFacae")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class ApproveFacadeImpl implements ApproveInfoFacae{
	private static final Logger log = LoggerFactory.getLogger(ApproveFacadeImpl.class);
//service
	@Autowired
	private ApproveInfoFacaeService approveInfoFacaeService;
	@Override
	@POST
	@Path("insertApproveInfo")
	public ReturnMsg insertApproveInfo(ApproveInfo approveInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = approveInfoFacaeService.insertApproveInfo(approveInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存数据失败");
			msg.setMsg(e.getMessage());
		}
		
		return msg;
	}


	@POST
	@Path("queryApproveInfo")
	public ReturnMsg queryApproveInfo(ApproveInfo approveInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg=approveInfoFacaeService.queryApproveInfo(approveInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("查询数据失败");
			msg.setMsg(e.getMessage());		
			}
		return msg;
	}

	@Override
	@POST
	@Path("updataApproveInfo")
	public ReturnMsg updataApproveInfo(ApproveInfo approveInfo) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg = approveInfoFacaeService.updataApproveInfo(approveInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("更新数据失败");
			msg.setMsg(e.getMessage());		
		}
		return msg;
		
	}





}
