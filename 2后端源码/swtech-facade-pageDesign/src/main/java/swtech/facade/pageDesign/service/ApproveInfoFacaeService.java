package swtech.facade.pageDesign.service;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ApproveInfo;

/**
 * 
 * @author 刘东
   *     审核控件暴露接口
 */
public interface ApproveInfoFacaeService {
	//向表中插入数据
	public ReturnMsg insertApproveInfo(ApproveInfo approveInfo);
	//查询数据
	public ReturnMsg queryApproveInfo(ApproveInfo approveInfo);
	//更新  未审核变已审核
	public ReturnMsg updataApproveInfo(ApproveInfo approveInfo);
}
