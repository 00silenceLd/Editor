package swtech.service.pageDesign.dao;

import java.util.List;
import java.util.Map;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.HtShopcar;

public interface HtShopcarDao extends BaseDao<HtShopcar>{
   

    public int insertSelectiveShopCar(HtShopcar record);

    List<Map<String, Object>> allHtShopcar();
    
    int deleteByPrimaryKeyShopCar(Integer productsId);
    
    int emptyCart();
    
    int updateStatus(Integer getReservationId);
    
    List<Map<String, Object>>  allorder(Integer shopBeiId);
    
    int cancelorder(Integer shopBeiId);
    
    int paynow(HtShopcar htShopcar);
}