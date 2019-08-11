package swtech.pageDesignControl.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.HtProductsPicture;

public interface HtProductsPictureMapper extends BaseMapper<HtProductsPicture> {
	
	  int  insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture);
	  HtProductsPicture  theme(Integer nodeId);
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