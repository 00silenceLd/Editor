package swtech.service.pageDesign.dao.impl;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.MyStoreManagement;
import swtech.service.pageDesign.dao.MyStoreManagementDao;

@Repository("MyStoreManagementDao")
public class MyStoreManagementDaoImpl  extends BaseDaoImpl<MyStoreManagement> implements MyStoreManagementDao{

	@Override
	public int insertMyStoreManagement(MyStoreManagement myStoreManagement) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertMyStoreManagement", myStoreManagement);
	}
//    int deleteByPrimaryKey(Integer smId);
//
//    int insert(MyStoreManagement record);
//
//    int insertSelective(MyStoreManagement record);
//
//    MyStoreManagement selectByPrimaryKey(Integer smId);
//
//    int updateByPrimaryKeySelective(MyStoreManagement record);
//
//    int updateByPrimaryKey(MyStoreManagement record);

	@Override
	public MyStoreManagement selectSm() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("selectSm");
	}
}