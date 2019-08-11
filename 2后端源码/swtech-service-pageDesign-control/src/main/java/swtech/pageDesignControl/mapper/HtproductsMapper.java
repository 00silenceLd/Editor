package swtech.pageDesignControl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import swtech.pageDesignControl.entity.HtProducts;

import java.util.List;



public interface HtproductsMapper extends BaseMapper<HtProducts> {

	int insertSelectiveProducts(HtProducts htProducts);

	List<HtProducts> allProducts(Integer productsCategory);

	HtProducts selectByPrimaryKeyProducts(Integer productsId);

	int updateByPrimaryKeySelectiveProducts(HtProducts htProducts);
}
