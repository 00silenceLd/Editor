package swtech.service.pageDesign.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.page.PageBean;
import swtech.common.page.PageParam;
import swtech.facade.pageDesign.entity.HtReservation;
import swtech.facade.pageDesign.entity.HtShopcar;
import swtech.service.pageDesign.dao.HtReservationDao;

@Repository("HtReservationDao")
public class HtReservationDaoImpl extends BaseDaoImpl<HtReservation> implements HtReservationDao {



	@Override
	public int insertSelectiveReservation(HtReservation record) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertSelectiveReservation",record);
	}

	

	@Override
	public HtReservation latestData() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("latestData");
	}


	@Override
	public List<Integer> useTheCode() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("useTheCode");
	}

	@Override
	public int getReservationId() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("getReservationId");
	}
	
	@Override
	public List<Map<String, Object>> ordercentel() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("ordercentel");
	}


	
	@Override
	public int deleteByPrimaryKeyReservation(Integer rid) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int insertReservation(HtReservation record) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public HtReservation selectByPrimaryKeyReservation(Integer rid) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public int updateByPrimaryKeySelectiveReservation(HtReservation record) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updateByPrimaryKeySelectiveReservation", record);
	}



	@Override
	public int updateByPrimaryKeyReservation(HtReservation record) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<Map<String, Object>> orderdetails(Integer reBeiId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("orderdetails", reBeiId);
	}



	@Override
	public List<HtReservation> allorder(Integer shopcarStatus) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("allsss",shopcarStatus);
	}



	@Override
	public int confirm(Integer reBeiId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("confirm",reBeiId);
	}



	@Override
	public int orderIdrid(HtReservation htReservation) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("orderIdrid",htReservation);
	}



	@Override
	public int estimateReoid(Integer reBeiId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("estimateReoid", reBeiId);
	}



	

	

	



	
	

}
