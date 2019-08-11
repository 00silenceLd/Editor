package swtech.pageDesignControl.mapper;

import swtech.pageDesignControl.entity.MyBeautyCommodity;

import java.util.List;



public interface MyBeautyCommodityMapper {
	
	int insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity);
	
	List<MyBeautyCommodity> selectAll(Integer smid);
	
	int updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity);
	
	MyBeautyCommodity selectByPrimaryKeyBeautyCommodity(Integer bcId);
	
	int deleteByPrimaryKeyCommodity(Integer bcId);
	
	int updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity);
	
//	MyBeautyCommodity  selectByPrimaryKeyBeautyCommodity(Integer bcId);
}