package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.MyBeautyCommodity;

import java.util.List;



public interface MyBeautyCommodityDao {

	ReturnMsg insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity);

	ReturnMsg selectAll();

	ReturnMsg updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity);

	ReturnMsg selectByPrimaryKey(Integer bcId);

	ReturnMsg deleteByPrimaryKeyCommodity(Integer bcId);

	ReturnMsg updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity);
	
//	MyBeautyCommodity  selectByPrimaryKeyBeautyCommodity(Integer bcId);
}