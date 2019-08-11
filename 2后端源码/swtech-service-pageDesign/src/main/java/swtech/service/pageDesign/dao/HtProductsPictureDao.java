package swtech.service.pageDesign.dao;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.HtProductsPicture;

public interface HtProductsPictureDao extends BaseDao<HtProductsPicture> {
	
	  int  insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture);
	  HtProductsPicture  theme();
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