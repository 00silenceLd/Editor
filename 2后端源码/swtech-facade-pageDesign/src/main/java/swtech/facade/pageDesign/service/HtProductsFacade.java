package swtech.facade.pageDesign.service;

import java.util.List;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtProducts;
import swtech.facade.pageDesign.entity.HtProductsPicture;

public interface HtProductsFacade {
	
    ReturnMsg insertSelectiveProducts(HtProducts htProducts);
	
	List<HtProducts> allProducts(Integer productsCategory);
	
    HtProducts selectByPrimaryKeyProducts(Integer productsId);
    
    /**
     * 
     * @param htProductsPicture
     * @return
     */
	
    int  insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture);
    
    HtProductsPicture  theme();
	
//	int updateByPrimaryKeySelectiveProducts(HtProducts htProducts);

}
