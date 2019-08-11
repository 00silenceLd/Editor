package swtech.pageDesignControl.service;


import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.MyStoreManagement;

public interface MyStoreManagementDao {

	ReturnMsg insertMyStoreManagement(MyStoreManagement myStoreManagement);

	ReturnMsg selectSm();
	
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