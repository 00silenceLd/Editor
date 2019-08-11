package swtech.facade.pageDesign.util.project;

import org.apache.commons.lang.StringUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * @描述 调用 ant.jar 的 SQLExec 执行 SQL 脚本文件
 * @author 曾泽亦
 */
public class AntExecSql {
	private static final Logger log = LoggerFactory.getLogger(AntExecSql.class);
    /**
     * @描述 调用 ant.jar 的 SQLExec 执行 SQL 脚本文件
     * @author 曾泽亦
     */
    public static String execSql(String datasource) throws UnsupportedEncodingException {
        //获取当前时间
        long startTime = System.currentTimeMillis();
        SQLExec sqlExec = new SQLExec();
        //设置数据库参数
        sqlExec.setDriver("com.mysql.jdbc.Driver");
        sqlExec.setUrl("jdbc:mysql://192.168.0.22:33060/"+datasource);
        sqlExec.setUserid("root");
        sqlExec.setPassword("123");
        //获取jar包同级目录的数据库生成脚本路径
        String path = getSqlPath();
        //要执行的脚本
        sqlExec.setSrc(new File(path));
        //有出错的语句该如何处理
        sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(SQLExec.OnError.class, "abort")));
        sqlExec.setPrint(true); //设置是否输出
        //输出到文件 sql.out 中；不设置该属性，默认输出到控制台
//        sqlExec.setOutput(new File("D:\\sql.out"));
        // 要指定这个属性，不然会出错
        sqlExec.setProject(new Project());
        sqlExec.execute();
        log.info("=====数据库创建成功！====");
        //获取当前时间
        long endTime = System.currentTimeMillis();
        //计算程序运行总时间
        String time =(endTime-startTime)/1000+"s";
//        String time = (endTime-startTime)+"ms";
        log.info("程序运行时间："+(endTime-startTime)/1000+"s");
        return time;
    }

    /**
     * @描述 获取sql的绝对路径
     * @author 曾泽亦
     */
    public static String getSqlPath() throws UnsupportedEncodingException {
        String path = AntExecSql.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        //获取jar包同级目录的数据库生成脚本路径
        path = StringUtils.substringBeforeLast(path,"/");
        path = path + "/data.sql";
        return path;
    }
}
