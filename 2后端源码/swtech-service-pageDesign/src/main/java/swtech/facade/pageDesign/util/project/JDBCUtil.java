package swtech.facade.pageDesign.util.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 数据库操作工具
 * ---------------------------------
 * @Author : Lin.Zhijie
 * @since : Create in 2018年3月31日 下午12:22:13
 **/
public class JDBCUtil {
	private static final Logger log = LoggerFactory.getLogger(JDBCUtil.class);

	/**
	 * @描述 	jdbc获取数据库连接工具类（初始 url = "jdbc:mysql://localhost:3306/zengzeyi"）
	 * @author 曾泽亦
	 * @return	Connection
	 */
	public static Connection getConnection() {
		String mysqlDriver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://192.168.0.22:33060/hbsxt";
		String username = "root";
		String password = "123";
		Connection conn = null;

		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.info("数据库驱动类启动失败！");

		} catch (SQLException e){
			e.printStackTrace();
			log.info("数据库连接失败！");
		}
		
		return conn;
	}

	/**
	 * @描述 动态创建一个数据库
	 * @author 曾泽亦
	 */
	public static int dynamicCreateDatabase(String database){
		Connection conn = null;
		Statement st = null;
		int creatDatabase = 0;

		//新建的数据库名
		String databaseSql = "create database " + database;

		//原理：先设置一个旧的数据库url连上数据库，动态创建新的数据库名，然后再进行动态设置新的数据库名为数据库新的url，重新连接
		conn = JDBCUtil.getConnection();

		if (conn != null) {
			log.info("数据库连接成功！");
			try {
				st = conn.createStatement();
				creatDatabase = st.executeUpdate(databaseSql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return creatDatabase;
	}

	/**
	 * @描述 使用jdbc根据传进的数据库名动态创建数据库,获取新的数据库连接（数据库端口到时按需要更改）
	 * @原理	先设置一个旧的数据库url连上数据库，动态创建新的数据库名，然后再进行动态设置新的数据库名为数据库新的url，重新连接
	 * @author 曾泽亦
	 * @param database
	 * @return	Connection
	 */
	public static Connection getConnectionDynamicAndCreateDatabase(String database){
		String newUrl = "jdbc:mysql://192.168.0.22:33060/";
		String username = "root";
		String password = "123";
		Connection conn = null;
		Connection newConnection = null;
		Statement st = null;
		
		//新建的数据库名
		String databaseSql = "create database " + database;

		//原理：先设置一个旧的数据库url连上数据库，动态创建新的数据库名，然后再进行动态设置新的数据库名为数据库新的url，重新连接
		conn = JDBCUtil.getConnection();
		
		if (conn != null) {
			log.info("数据库连接成功！");
			try {
				st = conn.createStatement();
				st.executeUpdate(databaseSql);
				newConnection = DriverManager.getConnection(newUrl + database,
						username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return newConnection;
	}
	
	/**
	 * @描述 使用jdbc根据传进的数据库名动态连接数据库（数据库端口到时按需要更改）
	 * @author 曾泽亦
	 * @param database
	 * @return	Connection
	 */
	public static Connection getConnectionDynamic(String database){
		String mysqlDriver = "com.mysql.jdbc.Driver";
		String newUrl = "jdbc:mysql://192.168.0.22:33060/";
		String username = "root";
		String password = "123";
		Connection conn = null;
		
		try {
			Class.forName(mysqlDriver);
			conn = DriverManager.getConnection(newUrl + database, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.info("数据库驱动类启动失败！");

		} catch (SQLException e){
			e.printStackTrace();
			log.info("数据库连接失败！");
		}
		return conn;
	}

	/**
	 * @描述 使用jdbc根据传进的数据库名动态创建数据库并且创建用户表、角色表和资源表（暂时不用）
	 * @author 曾泽亦
	 * @param database
	 * @return	int 0或1，1为成功，0为不成功
	 */
	public static int DynamicDatabase(String database) {
		int returnMsg = 0;
		Connection newConnection = null;
		Statement newSmt = null;

		try {
			//新建的用户表
			String tableSql = "CREATE TABLE t_user ("
					+" id int(20) NOT NULL AUTO_INCREMENT,"
					 +" user_name varchar(255) COLLATE utf8_bin DEFAULT NULL unique,"
					 +" password varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" create_time datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					 +" PRIMARY KEY (id)"
					+" );";
			
			//新建的角色表
			String tableSql2 = "CREATE TABLE t_role ("
						+" id int(20) NOT NULL AUTO_INCREMENT,"
					  +" role_name varchar(255) COLLATE utf8_bin NOT NULL unique,"
					  +" role_describe varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" parent_id int(20) DEFAULT NULL,"
					 +" create_time datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					 +" PRIMARY KEY (id)"
					+" );";
			
			//新建的用户角色关联表
			String tableSql3 = "CREATE TABLE user_role ("
					  +"id int(20) NOT NULL AUTO_INCREMENT,"
					  +"user_id int(20) NOT NULL,"
					  +"role_id int(20) NOT NULL,"
					  +"PRIMARY KEY (id),"
					  +"KEY user_id (user_id),"
					  +"KEY role_id (role_id),"
					  +"CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES t_user (id),"
					  +"CONSTRAINT role_id FOREIGN KEY (role_id) REFERENCES t_role (id)"
					+") ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
			
			//新建的资源表
			String tableSql4 = "CREATE TABLE t_resource ("
					  +" id int(20) NOT NULL AUTO_INCREMENT,"
					  +" resource_name varchar(255) COLLATE utf8_bin NOT NULL unique,"
					  +" resource_describe varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" resource_url varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" icon varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" permission varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" create_time datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					  +" resource_type varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" parent_id int(20) DEFAULT NULL,"
					  +" update_time datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					  +" PRIMARY KEY (id)"
					+" ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
			
			//新建的资源角色关联表
			String tableSql5 = "CREATE TABLE resource_role ("
					  +" id int(20) NOT NULL AUTO_INCREMENT,"
					  +" resource_id int(20) NOT NULL,"
					  +" role_fk int(20) NOT NULL,"
					  +" PRIMARY KEY (id),"
					  +" KEY resource_id (resource_id),"
					  +" KEY role_fk (role_fk),"
					  +" CONSTRAINT resource_id FOREIGN KEY (resource_id) REFERENCES t_resource (id),"
					  +" CONSTRAINT role_fk FOREIGN KEY (role_fk) REFERENCES t_role (id)"
					+" ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
			
			//新建的加入公司申请表
			String tableSql6 = "CREATE TABLE t_join_application ("
					  +" id int(20) NOT NULL AUTO_INCREMENT,"
					  +" applicant varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" application_date datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					  +" approval varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" approval_time datetime(6) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(6),"
					  +" approval_status int(20) DEFAULT NULL,"
					  +" applicant_company varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" applicant_company_code varchar(255) COLLATE utf8_bin DEFAULT NULL,"
					  +" PRIMARY KEY (id)"
					+" ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;";
			
			newConnection = JDBCUtil.getConnectionDynamicAndCreateDatabase(database);
			if (newConnection != null) {
				log.info("已经连接到新创建的数据库：" + database);

				newSmt = newConnection.createStatement();
				int i = newSmt.executeUpdate(tableSql);// DDL语句返回值为0;（用户表）
				int i2 = newSmt.executeUpdate(tableSql2);// DDL语句返回值为0;（角色表）
				int i4 = newSmt.executeUpdate(tableSql4);// DDL语句返回值为0;（资源表）
				int i6 = newSmt.executeUpdate(tableSql6);// DDL语句返回值为0;（加入公司申请表）
				if (i == 0 && i2 == 0 && i4 == 0 && i6 == 0) {
					log.info(tableSql + "用户表已经创建成功！");
					log.info(tableSql2 + "角色表已经创建成功！");
					log.info(tableSql4 + "资源表已经创建成功！");
					log.info(tableSql6 + "公司加入申请表已经创建成功！");
					int i3 = newSmt.executeUpdate(tableSql3);// DDL语句返回值为0;
					int i5 = newSmt.executeUpdate(tableSql5);// DDL语句返回值为0;
					if(i3 == 0 && i5 == 0){
						log.info(tableSql3 + "用户角色关联表已经创建成功！");
						log.info(tableSql5 + "资源角色关联表已经创建成功！");
						//成功返回1，否则返回0
						returnMsg = 1;
					}else{
						log.info(tableSql3 +tableSql5 + "关联表创建失败！");
					}
				}else{
					log.info(tableSql +tableSql2 + tableSql4+ "单表创建失败！");
				}
			}
		//关闭连接资源
		JDBCUtil.getCloseConn(null, newSmt, newConnection);
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		return returnMsg;
	}
	
	
	/**
	 * @描述 	使用jdbc获取当前数据库端口的所有数据库名（数据库端口到时按需要更改）
	 * @author 曾泽亦
	 * @return	List<String>
	 */
	public static List<String> selectAllDatabases() {
		Connection conn = null;
		List<String> list=new ArrayList<String>();

		try {
			
			//查询所有数据库名
			String databaseSql ="show databases;";
			
			conn = JDBCUtil.getConnection();
			Statement st = conn.createStatement();
			if (conn != null) {
				log.info("数据库连接成功！");

			}
			ResultSet rs=st.executeQuery(databaseSql);
			 int col = rs.getMetaData().getColumnCount();
		        log.info("=============输出存在的数据库名字===============");
		        while (rs.next()) {
		            for (int i = 1; i <= col; i++) {
		                System.out.print(rs.getString(i) + "\t");
		                list.add(rs.getString(i));
		                if ((i == 2) && (rs.getString(i).length() < 8)) {
		                    System.out.print("\t");
		                }
		             }
		            log.info("");
		        }
		            log.info("=============输出结束================");
		            
		    //关闭连接资源
			JDBCUtil.getCloseConn(rs, st, conn);
		
		} catch (SQLException e1) {
			e1.printStackTrace();
			
		}
		
		return list;
	}
	
	/** 
     * @描述	依次关闭ResultSet、Statement、Connection （关闭连接等资源，若对象不存在则创建一个空对象 ）
     * @author 曾泽亦
     * @param rs 
     * @param st 
     * @param conn
     */  
    public static void getCloseConn(ResultSet rs,Statement st,Connection conn){
        if(rs != null){  
            try {  
                rs.close();  
            } catch (SQLException e) {  
                e.printStackTrace();  
            } finally{
                if(st != null){  
                    try {  
                        st.close();  
                    } catch (SQLException e) {  
                        e.printStackTrace();  
                    } finally{
                        if(conn != null){
                            try {  
                                conn.close();  
                            } catch (SQLException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
                }  
            }  
        }  
    } 
	
	
}
 