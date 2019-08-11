package swtech.service.pageDesign.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.page.PageBean;
import swtech.common.page.PageParam;
import swtech.facade.pageDesign.entity.HtReseat;
import swtech.service.pageDesign.dao.HtReseatDao;

@Repository("HtReseatDao")
public class HtReseatDaoImpl extends BaseDaoImpl<HtReseat> implements HtReseatDao {

	@Override
	public List<HtReseat> resertall() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("resertall");
	}

	@Override
	public int insertSelectiveReseat(HtReseat htReseat) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertSelectiveReseat",htReseat);
	}

	@Override
	public int delseat() {
		// TODO Auto-generated method stub
		return getSessionTemplate().delete("delseat");
	}

//	public int updseat(List<String> seatnum) {
	@Override
	public int updseat(Map<String, Object> upd) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updseat",upd);
	}

	@Override
	public List<HtReseat> selno(Integer seatstatus) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("selno",seatstatus);
	}

	
}
