package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtProducts;

public interface HtproductsDao extends BaseDao<HtProducts>{
	
	public ReturnMsg insertSelectiveProducts(HtProducts htProducts);
	
	List<HtProducts> allProducts(Integer productsCategory);

	public HtProducts selectByPrimaryKeyProducts(Integer productsId);
	
	int updateByPrimaryKeySelectiveProducts(HtProducts htProducts);
}
