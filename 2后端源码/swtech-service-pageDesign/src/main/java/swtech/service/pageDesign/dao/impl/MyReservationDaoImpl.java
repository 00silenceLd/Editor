package swtech.service.pageDesign.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.MyReservation;
import swtech.service.pageDesign.dao.MyReservationDao;

@Repository("MyReservationDao")
public class MyReservationDaoImpl extends BaseDaoImpl<MyReservation> implements MyReservationDao{

	@Override
	public int insertSelectiveMyReservation(MyReservation record) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertSelectiveMyReservation", record);
	}

	@Override
	public List<Integer> useTheCode() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("mrAuthCode");
	}

	@Override
	public List<MyReservation> selectReserva(Integer mrStatus) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("selectReserva",mrStatus);
	}

	@Override
	public int updReserva(MyReservation record) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updReserva", record);
	}

	@Override
	public MyReservation selectCode(Integer Code) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("selectCode", Code);
	}

	@Override
	public MyReservation selectMrRid(Integer mrRid) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("selectMrRid", mrRid);
	}

}
