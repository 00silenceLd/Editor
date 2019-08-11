package swtech.facade.pageDesign.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ApproveInfo;
import swtech.facade.pageDesign.service.ApproveInfoFacaeService;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.ApproveInfoDao;
@Component
//@Transactional
public class ApproveFacadeServiceImpl implements ApproveInfoFacaeService {
	private static final Logger log = LoggerFactory.getLogger(ApproveFacadeServiceImpl.class);
	
	@Autowired
	private ApproveInfoDao approveInfoDao;

	@Transactional
	@Override
	public ReturnMsg insertApproveInfo(ApproveInfo approveInfo) {
		ReturnMsg msg = new ReturnMsg();
		//参数合法性
		
		Integer row = approveInfoDao.insertApproveInfo(approveInfo.getNodeId(), approveInfo.getSelectId(), approveInfo.getIsApprove());
		if(row==0)throw new ServiceException("保存进数据库出错");
		
		msg.setStatus("200");
		msg.setStatusMsg("保存数据成功");
		return msg;
		
	}
//    
	@Override
	public ReturnMsg queryApproveInfo(ApproveInfo approveInfo) {
    	ReturnMsg msg = new ReturnMsg();
    	List<ApproveInfo> approveInfoList = approveInfoDao.queryApproveInfo(approveInfo.getIsApprove());
//    	if(approveInfoList==null)throw new ServiceException("查询数据库出错");
    	msg.setStatus("200");
		msg.setStatusMsg("查询数据成功");
		msg.setMsg(approveInfoList);
    	return msg;
		
		
	}
	@Transactional
	@Override
	public ReturnMsg updataApproveInfo(ApproveInfo approveInfo) {
		ReturnMsg msg = new ReturnMsg();
		Integer row= approveInfoDao.updataApproveInfo(approveInfo.getNodeId(), approveInfo.getSelectId());
		if(row==0)throw new ServiceException("更新数据库出错");
		msg.setStatus("200");
		msg.setStatusMsg("查询数据成功");
    	return msg;
		
	}

}
