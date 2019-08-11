package swtech.pageDesignControl.mapper;


import swtech.pageDesignControl.entity.MyStoreManagement;

import java.util.List;

public interface MyStoreManagementMapper {
	
	int insertMyStoreManagement(MyStoreManagement myStoreManagement);

	MyStoreManagement selectSm(Integer smId);

	List<MyStoreManagementMapper> selectMsmAll();
	
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