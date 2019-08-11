package swtech.pageDesignControl.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.HtCategory;

import java.util.List;



public interface HtCategoryMapper {

    int insertSelectiveIn(HtCategory htCategory);

    List<HtCategory> all();
}