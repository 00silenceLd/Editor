package swtech.service.pageDesign.dao;


import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.ProjectPort;

import java.util.List;

/**
 * @描述 记录jar包修改情况 数据库操作接口
 * @author 曾泽亦
 */
public interface ProjectPortDao extends BaseDao<ProjectPort> {

    /**
     * @描述 新增一条记录
     * @author 曾泽亦
     * @return 0（失败）或1（成功）
     */
    public long insertProjectPort(ProjectPort projectPort);

    /**
     * @描述 查询所有已被项目使用的端口号集合
     * @author 曾泽亦
     * @return 0（失败）或1（成功）
     */
    public List<Integer> selectPortNumberByAll();

}