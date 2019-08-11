package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.ApproveInfo;

public interface ApproveInfoDao extends BaseDao<ApproveInfo>{
	public Integer insertApproveInfo(int nodeId,int selectId,int isApprove);
	public List<ApproveInfo> queryApproveInfo(int isApprove);
	public Integer updataApproveInfo(int nodeId,int selectId);
}
