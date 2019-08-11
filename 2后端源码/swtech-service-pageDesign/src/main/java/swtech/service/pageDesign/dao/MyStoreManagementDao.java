package swtech.service.pageDesign.dao;


import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.MyStoreManagement;

public interface MyStoreManagementDao extends BaseDao<MyStoreManagement>{
	
	int insertMyStoreManagement(MyStoreManagement myStoreManagement);

	MyStoreManagement selectSm();
	
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
}