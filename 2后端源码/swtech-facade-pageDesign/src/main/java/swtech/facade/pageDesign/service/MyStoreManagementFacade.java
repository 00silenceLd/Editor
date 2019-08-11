package swtech.facade.pageDesign.service;

import java.util.List;
import java.util.Map;

import swtech.facade.pageDesign.entity.MyBeautyCommodity;
import swtech.facade.pageDesign.entity.MyReservation;
import swtech.facade.pageDesign.entity.MyStoreManagement;

/**
 * 美业
 * @author 袁君选
 *
 */
public interface MyStoreManagementFacade {
	
	/**
	 * 店铺操作
	 */
	int insertMyStoreManagement(MyStoreManagement myStoreManagement);
	
//	MyStoreManagement selectSm();
	
	/**
	 * 商品操作
	 */
	int insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity);
	
	Map<String,Object> selectAll();
	
	int updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity);
	
	MyBeautyCommodity selectByPrimaryKey(Integer bcId);
	
	int deleteByPrimaryKeyCommodity(Integer bcId);
	
	int updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity  myBeautyCommodity);
	
//	MyBeautyCommodity  selectByPrimaryKeyBeautyCommodity(Integer bcId);
	
	/**
	 * 预订操作
	 */ 
	int insertSelectiveMyReservation(MyReservation record);
	
	List<MyReservation> selectReserva(Integer mrStatus);
	
	int updReserva(MyReservation record);
	
	MyReservation  selectCode(Integer Code);
	
	MyReservation selectMrRid(Integer mrRid);

}
