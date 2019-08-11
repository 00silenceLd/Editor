package swtech.service.pageDesign.dynamicForm.facade;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import swtech.service.pageDesign.dynamicForm.model.Haha;
import swtech.service.pageDesign.dynamicForm.model.HahaExample;

public interface HahaMapper {
    long countByExample(HahaExample example);

    int deleteByExample(HahaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Haha record);

    int insertSelective(Haha record);

    List<Haha> selectByExample(HahaExample example);

    Haha selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Haha record, @Param("example") HahaExample example);

    int updateByExample(@Param("record") Haha record, @Param("example") HahaExample example);

    int updateByPrimaryKeySelective(Haha record);

    int updateByPrimaryKey(Haha record);
}