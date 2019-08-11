package swtech.service.pageDesign.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.page.PageBean;
import swtech.common.page.PageParam;
import swtech.facade.pageDesign.entity.ApproveInfo;
import swtech.service.pageDesign.dao.ApproveInfoDao;
@Repository("approveInfoDao")
public class ApproveInfoDaoImpl extends BaseDaoImpl<ApproveInfo> implements ApproveInfoDao {	

	@Override
	public Integer insertApproveInfo(int nodeId, int selectId, int isApprove) {
		// TODO Auto-generated method stub
		ApproveInfo approveInfo = new ApproveInfo();
		approveInfo.setNodeId(nodeId);
		approveInfo.setSelectId(selectId);
		approveInfo.setIsApprove(isApprove);
		int row = getSessionTemplate().insert("insertApproveInfo",approveInfo);
		return row;
	}

	@Override
	public List<ApproveInfo> queryApproveInfo(int isApprove) {
		// TODO Auto-generated method stub
		//		ApproveInfo approveInfo = new ApproveInfo();
		//		approveInfo.setIsApprove(isApprove);

		List<ApproveInfo> approveInfoList =getSessionTemplate().selectList("queryApproveInfo", isApprove);
		return approveInfoList;

	}

	@Override
	public Integer updataApproveInfo(int nodeId, int selectId) {
		ApproveInfo approveInfo = new ApproveInfo();
		approveInfo.setNodeId(nodeId);
		approveInfo.setSelectId(selectId);
		return getSessionTemplate().update("updataApproveInfo", approveInfo);

	}

}
