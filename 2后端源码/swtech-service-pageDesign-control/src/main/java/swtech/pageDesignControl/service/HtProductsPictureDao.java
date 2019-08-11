package swtech.pageDesignControl.service;


import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtProductsPicture;

public interface HtProductsPictureDao  {

	ReturnMsg insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture);
	ReturnMsg  theme(Integer nodeIdqwe);
//    int deleteByPrimaryKey(Integer hppId);
//
//    int insert(HtProductsPicture record);
//
//    int insertSelective(HtProductsPicture record);
//
//    HtProductsPicture selectByPrimaryKey(Integer hppId);
//
//    int updateByPrimaryKeySelective(HtProductsPicture record);
//
//    int updateByPrimaryKeyWithBLOBs(HtProductsPicture record);
}