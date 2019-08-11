package swtech.pageDesignControl.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import swtech.pageDesignControl.entity.TestEntity;



public interface TestMapper extends BaseMapper<TestEntity>{

	List<TestEntity> check();

//	@Select("select * from bk_user")

	
}
