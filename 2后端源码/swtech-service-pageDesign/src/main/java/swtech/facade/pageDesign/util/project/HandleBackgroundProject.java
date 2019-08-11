package swtech.facade.pageDesign.util.project;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import swtech.facade.pageDesign.entity.ProjectPort;
import swtech.facade.pageDesign.util.File.SpringTool;
import swtech.service.pageDesign.dao.ProjectPortDao;

/**
 * @描述 复制项目后台文件，并修改jar包的数据源配置文件和dubbo访问端口配置文件
 * @描述 复制项目前端文件，并修改前端的全局访问配置文件（只需要修改端口）
 * @author 曾泽亦
 */
public class HandleBackgroundProject {
	private static final Logger log = LoggerFactory.getLogger(HandleBackgroundProject.class);
    //注入projectPortDao 的bean实例
    private static ProjectPortDao projectPortDao = (ProjectPortDao) SpringTool.getBean("projectPortDao");

    /**
     * @描述 复制项目后台文件，并修改jar包的数据源配置文件和dubbo访问端口配置文件
     * @描述 复制项目前端文件，并修改前端的全局访问配置文件（只需要修改端口）
     * @author 曾泽亦
     */
    public static String handleProject(String dbName) throws Exception {
        //获取当前时间
        long startTime = System.currentTimeMillis();
        //复制项目后台到新建的公司目录下面
        JarPackageOperationUtil.copyBackgroundProject(dbName);
        //复制百度编辑器项目到新建的公司目录下面
        JarPackageOperationUtil.copyPageDesignProject(dbName);
        //复制项目前端到新建的公司目录下面（nginx的html目录下）
        FileOperate.copyDir("/usr/local/nginx/html/swpt_2" , "/usr/local/nginx/html/"+dbName);
        //查询数据表已分配的端口号集合
        List<Integer> portNumber = projectPortDao.selectPortNumberByAll();
        //调用工具类获取可用端口号集合的第一个端口号
        Integer availablePort = QueryPortNumber.getAvailablePort(portNumber);
        log.info("---------------------------------------------"+1);
        //jar包的新建路径前缀（公司注册）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.companyRegisterServiceJarPath,availablePort.toString());
        ProjectPort projectPort1 = new ProjectPort();
        projectPort1.setProjectName(dbName);
        projectPort1.setJarSuffixName(Constant.companyRegisterServiceJarPath);
        projectPort1.setPortNumber(availablePort);
        long countInsert1 = projectPortDao.insertProjectPort(projectPort1);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.companyRegisterServicePort,availablePort.toString());
        log.info("---------------------------------------------"+2);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（用户权限）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.hbsxtServiceJarPath,availablePort.toString());
        ProjectPort projectPort2 = new ProjectPort();
        projectPort2.setProjectName(dbName);
        projectPort2.setJarSuffixName(Constant.hbsxtServiceJarPath);
        projectPort2.setPortNumber(availablePort);
        long countInsert2 = projectPortDao.insertProjectPort(projectPort2);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.hbsxtServicePort,availablePort.toString());
        log.info("---------------------------------------------"+3);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（雕刻图案）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName, Constant.inciseJarPath,availablePort.toString());
        ProjectPort projectPort3 = new ProjectPort();
        projectPort3.setProjectName(dbName);
        projectPort3.setJarSuffixName(Constant.inciseJarPath);
        projectPort3.setPortNumber(availablePort);
        long countInsert3 = projectPortDao.insertProjectPort(projectPort3);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.incisePort,availablePort.toString());
        log.info("---------------------------------------------"+4);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（office文档）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.officeJarPath,availablePort.toString());
        ProjectPort projectPort5 = new ProjectPort();
        projectPort5.setProjectName(dbName);
        projectPort5.setJarSuffixName(Constant.officeJarPath);
        projectPort5.setPortNumber(availablePort);
        long countInsert5 = projectPortDao.insertProjectPort(projectPort5);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.officePort,availablePort.toString());
        log.info("---------------------------------------------"+5);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（支付中心）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.paymentServiceJarPath,availablePort.toString());
        ProjectPort projectPort6 = new ProjectPort();
        projectPort6.setProjectName(dbName);
        projectPort6.setJarSuffixName(Constant.paymentServiceJarPath);
        projectPort6.setPortNumber(availablePort);
        long countInsert6 = projectPortDao.insertProjectPort(projectPort6);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.paymentServicePort,availablePort.toString());
        log.info("---------------------------------------------"+6);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（备课）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.prepareJarPath,availablePort.toString());
        ProjectPort projectPort7 = new ProjectPort();
        projectPort7.setProjectName(dbName);
        projectPort7.setJarSuffixName(Constant.prepareJarPath);
        projectPort7.setPortNumber(availablePort);
        long countInsert7 = projectPortDao.insertProjectPort(projectPort7);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.preparePort,availablePort.toString());
        log.info("---------------------------------------------"+7);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（购物）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.ziyuankuServiceJarPath,availablePort.toString());
        ProjectPort projectPort8 = new ProjectPort();
        projectPort8.setProjectName(dbName);
        projectPort8.setJarSuffixName(Constant.ziyuankuServiceJarPath);
        projectPort8.setPortNumber(availablePort);
        long countInsert8 = projectPortDao.insertProjectPort(projectPort8);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.ziyuankuServicePort,availablePort.toString());
        log.info("---------------------------------------------"+8);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（百度编辑器）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.pageDesignServiceJarPath,availablePort.toString());
        ProjectPort projectPort9 = new ProjectPort();
        projectPort9.setProjectName(dbName);
        projectPort9.setJarSuffixName(Constant.pageDesignServiceJarPath);
        projectPort9.setPortNumber(availablePort);
        long countInsert9 = projectPortDao.insertProjectPort(projectPort9);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.pageDesignServicePort,availablePort.toString());
        log.info("---------------------------------------------"+9);
        portNumber = projectPortDao.selectPortNumberByAll();
        availablePort = QueryPortNumber.getAvailablePort(portNumber);
        //jar包的新建路径前缀（网络硬盘）
        JarPackageOperationUtil.updateDatasourceAndDubboPort(dbName,Constant.networdHardDiskServiceJarPath,availablePort.toString());
        ProjectPort projectPort4 = new ProjectPort();
        projectPort4.setProjectName(dbName);
        projectPort4.setJarSuffixName(Constant.networdHardDiskServiceJarPath);
        projectPort4.setPortNumber(availablePort);
        long countInsert4 = projectPortDao.insertProjectPort(projectPort4);
        //修改前端的js全局配置文件
        FileOperate.readJSConfig(dbName,Constant.networdHardDiskServicePort,availablePort.toString());
        log.info("---------------------------------------------"+10);
        //获取当前时间
        long endTime = System.currentTimeMillis();
        //计算程序运行总时间
        String time =(endTime-startTime)/1000+"s";
//        String time = (endTime-startTime)+"ms";
        log.info("程序运行时间："+(endTime-startTime)/1000+"s");
        return time;
    }
}
