package swtech.service.pageDesign.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.MyBeautyCommodity;
import swtech.service.pageDesign.dao.MyBeautyCommodityDao;

@Repository("MyBeautyCommodityDao")
public class MyBeautyCommodityDaoImpl extends BaseDaoImpl<MyBeautyCommodity> implements MyBeautyCommodityDao{

	@Override
	public int insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertMyBeautyCommodity",myBeautyCommodity);
	}

	@Override
	public List<MyBeautyCommodity> selectAll() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectList("selectAll");
	}

	@Override
	public int updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updateByPrimaryKeySelective", myBeautyCommodity);
	}

	@Override
	public MyBeautyCommodity selectByPrimaryKey(Integer bcId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("selectByPrimaryKeyBeautyCommodity", bcId);
	}

	@Override
	public int deleteByPrimaryKeyCommodity(Integer bcId) {
		// TODO Auto-generated method stub
		return getSessionTemplate().delete("deleteByPrimaryKeyCommodity", bcId);
	}

	@Override
	public int updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updateByPrimaryKeySelectiveCommodity", myBeautyCommodity);
	}

}