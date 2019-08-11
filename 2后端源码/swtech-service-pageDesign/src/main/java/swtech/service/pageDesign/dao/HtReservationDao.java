package swtech.service.pageDesign.dao;

import java.util.List;
import java.util.Map;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.HtReservation;
import swtech.facade.pageDesign.entity.HtShopcar;

public interface HtReservationDao extends BaseDao<HtReservation>{
	
	int deleteByPrimaryKeyReservation(Integer rid);

    int insertReservation(HtReservation record);

    int insertSelectiveReservation(HtReservation record);

    HtReservation selectByPrimaryKeyReservation(Integer rid);

    int updateByPrimaryKeySelectiveReservation(HtReservation record);

    int updateByPrimaryKeyReservation(HtReservation record);
    
    HtReservation latestData();
    
     List<Integer>  useTheCode();
     
    int getReservationId();

    List<Map<String, Object>> ordercentel();
    
    List<Map<String, Object>> orderdetails(Integer reBeiId);
    
    List<HtReservation> allorder(Integer shopcarStatus);
    
    int confirm(Integer reBeiId);
    
    int orderIdrid(HtReservation htReservation);
    
    int estimateReoid(Integer reBeiId);
}
