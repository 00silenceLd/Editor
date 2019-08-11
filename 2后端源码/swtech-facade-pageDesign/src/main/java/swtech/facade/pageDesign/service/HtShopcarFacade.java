package swtech.facade.pageDesign.service;

import java.util.List;
import java.util.Map;

import swtech.facade.pageDesign.entity.HtShopcar;

public interface HtShopcarFacade {
   

    int insertSelectiveShopCar(HtShopcar record);

    List<Map<String, Object>> allHtShopcar();
    
    int deleteByPrimaryKeyShopCar(Integer productsId);
    
    int emptyCart();
    
    List<Map<String, Object>>  allorder(Integer shopBeiId);
    
    int paynow(HtShopcar htShopcar);
    
}