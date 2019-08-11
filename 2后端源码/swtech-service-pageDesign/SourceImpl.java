package {className1};

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.lang.Integer;
import java.util.HashMap;
import {className1}.{className};
import {className1}.{className}Example;
import {className1}.{className}Mapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.page.PageBean;
import swtech.common.page.PageParam;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.facade.pageDesign.service.impl.PageDesignOperatorFacadeImpl;
import swtech.service.pageDesign.dao.PageDesignDao;

@Repository
public class {className}MapperImpl extends BaseDaoImpl<{className}> implements {className}Mapper { 
	private static final Log log = LogFactory
			.getLog(PageDesignOperatorFacadeImpl.class);
 
 	/**
 	*  插入方法
 	*  @param entity
 	*  @return long
 	*/
	public long insert({className} entity) {
		try {
			log.info(entity.toString());
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.insert(entity);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return entity.getId();
	}
	
	/**
 	*  删除方法
 	*  @param id
 	*  @return long
 	*/
	public long deleteById(long id) {
		try {
			log.info("ID:"+id);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return 0;
	}
	
	/**
 	*  更新方法
 	*  @param id
 	*  @return long
 	*/
	public long update({className} entity) {
		try {
			log.info(entity.toString());
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.updateByPrimaryKey(entity);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return 0;
	}
	
	/**
 	*  查询方法
 	*  @param id
 	*  @return {className}
 	*/
	public {className} getById(long id) {
		{className} entity = null;
		try {
			log.info("ID:"+id);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			entity = mpr.selectByPrimaryKey(id);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return entity;
	}
	
	
	/**
 	*  查询方法
 	*  @param id
 	*  @return {className}
 	*/
	public List<{className}> selectList() {
		List<{className}> list = new ArrayList<{className}>();
		try {
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			list = mpr.selectList();
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
	/**
 	*  关联查询搜索方法
 	*  @param id
 	*  @return {className}
 	*/
	public List<{className}> searchKey({className} entity) {
		List<{className}> list = new ArrayList<{className}>();
		try {
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			list = mpr.searchKey(entity);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
	/**
 	*  全部查询方法
 	*  @param str
 	*  @return {className}
 	*/
	public List<{className}> searchAllKey(String str) {
		List<{className}> list = new ArrayList<{className}>();
		try {
			log.info("key:"+str);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			list = mpr.searchAllKey(str);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
	/**
 	*  批量删除方法
 	*  @param id
 	*  @return long
 	*/
	public long deleteArray(int[] ids) {
		try {
			log.info("ID:"+ids);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.deleteArray(ids);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return 0;
	}
	
	/**
	* 分页查询
	*/
	public List<{className}> getQueryPage(Map<String, Object> map) {
		List<{className}> list = new ArrayList<{className}>();
		try {
			log.info("key:"+map);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 

			list = mpr.getQueryPage(map);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
	/**
	* 查询数据总数
	*/
	public long getCount() {
	    long i = 0;
		try {
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			i = mpr.getCount();
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return i;
	}
	
	/**
	* 更新is_delete字段
	*/
	public long updateDelete(Map<String, Object> map) {
		long i = 0;
		try {
			log.info("key:"+map);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 

			i = mpr.updateDelete(map);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return i;
	}
	
	/**
 	*  批量回收方法
 	*  @param id
 	*  @return long
 	*/
	public long isDeleteArray(int[] ids) {
		try {
			log.info("map:"+ids);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.isDeleteArray(ids);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return 0;
	}
	
	/**
	* 恢复单条数据
	*/
	public long reNewData(int id) {
		long i = 0;
		try {
			log.info("id:"+id);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 

			i = mpr.reNewData(id);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return i;
	}
	
	/**
 	*  恢复多条数据
 	*  @param ids
 	*  @return long
 	*/
	public long reNewDataArray(int[] ids) {
		try {
			log.info("ids:"+ids);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			mpr.reNewDataArray(ids);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return 0;
	}
	
	
	/**
 	*  查询报表信息
 	*  @param str
 	*  @return {className}
 	*/
	public List<{className}> getReportForm(String sql) {
		List<{className}> list = new ArrayList<{className}>();
		try {
			log.info("key:"+sql);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			list = mpr.getReportForm(sql);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
	/**
 	*  查询报表信息
 	*  @param str
 	*  @return {className}
 	*/
	public List<Map<String, String>> getResourceLibrary(String sql) {
		List<Map<String, String>> listMap = new ArrayList<Map<String, String>>();
		try {
			log.info("key:"+sql);
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			listMap = mpr.getResourceLibrary(sql);
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return listMap;
	}
	
	/**
 	*  查询回收站信息
 	*  @param str
 	*  @return {className}
 	*/
	public List<{className}> searchIsDelete() {
		List<{className}> list = new ArrayList<{className}>();
		try {
			String resource ="{className1}/{className}-mybatis-config.xml";		    
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream(resource);
			} catch (IOException e) {
				e.printStackTrace();
			}
			SqlSessionFactory sqlSessFac = new SqlSessionFactoryBuilder().build(inputStream);
			{className}Mapper mpr = sqlSessFac.openSession(true).getMapper(
					{className}Mapper.class); 
			list = mpr.searchIsDelete();
		} catch (Exception e) {
			log.info("出错" + e.toString());
		}
		return list;
	}
	
}