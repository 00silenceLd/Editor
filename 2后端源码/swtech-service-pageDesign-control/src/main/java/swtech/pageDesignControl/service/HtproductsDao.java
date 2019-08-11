package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtProducts;

import java.util.List;


public interface HtproductsDao {
	
	public ReturnMsg insertSelectiveProducts(HtProducts htProducts);

	ReturnMsg allProducts(Integer productsCategory);

	ReturnMsg selectByPrimaryKeyProducts(Integer productsId);

	ReturnMsg updateByPrimaryKeySelectiveProducts(HtProducts htProducts);
}
