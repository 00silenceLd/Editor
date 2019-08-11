package swtech.service.pageDesign.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.ProjectPort;
import swtech.service.pageDesign.dao.ProjectPortDao;

import java.util.List;

/**
 * @描述 记录jar包修改情况 数据库操作类
 * @author 曾泽亦
 */
@Repository("projectPortDao")
public class ProjectPortDaoImpl extends BaseDaoImpl<ProjectPort> implements ProjectPortDao {

    /**
     * @描述 新增一条记录
     * @author 曾泽亦
     * @return 0（失败）或1（成功）
     */
    public long insertProjectPort(ProjectPort projectPort){
        return getSessionTemplate().insert("insertProjectPort", projectPort);
    }

    /**
     * @描述 查询所有已被项目使用的端口号集合
     * @author 曾泽亦
     * @return 0（失败）或1（成功）
     */
    public List<Integer> selectPortNumberByAll(){
        return getSessionTemplate().selectList("selectAllPort");
    }
}
