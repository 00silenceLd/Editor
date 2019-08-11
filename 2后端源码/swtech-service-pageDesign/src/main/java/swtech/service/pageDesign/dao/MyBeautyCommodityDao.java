package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.MyBeautyCommodity;

public interface MyBeautyCommodityDao extends BaseDao<MyBeautyCommodity> {
	
	int insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity);
	
	List<MyBeautyCommodity> selectAll();
	
	int updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity);
	
	MyBeautyCommodity selectByPrimaryKey(Integer bcId);
	
	int deleteByPrimaryKeyCommodity(Integer bcId);
	
	int updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity);
	
//	MyBeautyCommodity  selectByPrimaryKeyBeautyCommodity(Integer bcId);
}