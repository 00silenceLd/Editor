package swtech.service.pageDesign.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.HtShopcar;
import swtech.service.pageDesign.dao.HtShopcarDao;


@Repository("HtShopcarDao")
public class HtShopcarDaoImpl extends BaseDaoImpl<HtShopcar>  implements HtShopcarDao {

	@Override
	public int insertSelectiveShopCar(HtShopcar record) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertSelectiveShopCar", record);
	}

	@Override
	public List<Map<String, Object>> allHtShopcar() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("allHtShopcar");
	}

	@Override
	public int deleteByPrimaryKeyShopCar(Integer productsId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().delete("deleteByPrimaryKeyShopCar", productsId);
	}

	@Override
	public int emptyCart() {
		// TODO Auto-generated method stub
		return getSessionTemplate().delete("emptyCart");
	}

	@Override
	public int updateStatus(Integer getReservationId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updateStatus",getReservationId);
	}

	@Override
	public List<Map<String, Object>> allorder(Integer shopBeiId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("allorder",shopBeiId);
	}

	@Override
	public int cancelorder(Integer shopcarBei){
		// TODO Auto-generated method stub
		return getSessionTemplate().update("cancelorder",shopcarBei);
	}

	@Override
	public int paynow(HtShopcar htShopcar) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("paynow", htShopcar);
	}

}
