package swtech.facade.pageDesign.service;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ApproveInfo;

/**
 * 
 * @author 刘东
   *     审核控件暴露接口
 */
public interface ApproveInfoFacae {
	//向表中插入数据
	public ReturnMsg insertApproveInfo(ApproveInfo a);
	//查询数据
	public ReturnMsg queryApproveInfo(ApproveInfo a);
	//更新  未审核变已审核
	public ReturnMsg updataApproveInfo(ApproveInfo a);
}
