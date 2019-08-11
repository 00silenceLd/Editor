package swtech.service.pageDesign.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.ClassifyNode;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.ClassifyTreeInfoDao;
/*
 * 
   

 *
 *
 *             ,%%%%%%%%, 
 *           ,%%/\%%%%/\%% 
 *          ,%%%\c "" J/%%% 
 * %.       %%%%/ o  o \%%% 
 * `%%.     %%%%    _  |%%% 
 *  `%%     `%%%%(__Y__)%%' 
 *  //       ;%%%%`\-/%%%'
 * ((       /  `%%%%%%%' 
 *  \\    .'          | 
 *   \\  /       \  | | 
 *    \\/         ) | | 
 *     \         /_ | |__ 
 *     (___________))))))) 攻城湿 
 *
 * @QualifiedName:swtech.service.pageDesign.dao.impl.ClassifyTreeInfoDaoImpl
 * @ClassName: ClassifyTreeInfoDaoImpl
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:22:52
 * @Description: 树形分类控件持久层实现类
 *
 */
@Repository("classifyTreeInfoDao")
public class ClassifyTreeInfoDaoImpl extends BaseDaoImpl<ClassifyTreeInfo> implements ClassifyTreeInfoDao{
	private static final Logger log = LoggerFactory.getLogger(ClassifyTreeInfoDaoImpl.class);

	@Override
	public ClassifyTreeInfo getClassifyTreeInfoByNodeId(Integer nodeId) {
		
		ClassifyTreeInfo classifyTreeInfo = 
				getSessionTemplate().selectOne("getClassifyTreeInfoByNodeId", nodeId);
		
		return classifyTreeInfo;
	}

	@Override
	public Integer createClassifyTable(String classifyTableName) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("classifyTableName", classifyTableName);
		Integer row = getSessionTemplate().update("createClassifyTable", paramMap);
		return row;
	}

	@Override
	public Integer saveClassifyTreeInfo(ClassifyTreeInfo classifyTreeInfo) {
		Integer row = getSessionTemplate().insert("saveClassifyTreeInfo", classifyTreeInfo);
		return row;
	}

	@Override
	public Integer updateClassifyTreeInfo(ClassifyTreeInfo classifyTreeInfo) {
		Integer row = getSessionTemplate().update("updateClassifyTreeInfo", classifyTreeInfo);
		return row;
	}

	@Override
	public String getClassifyTableNameByNodeId(Integer nodeId) {
		Map<String, Object> paramMap = getSessionTemplate().selectOne("getClassifyTableNameByNodeId", nodeId);
		String classify_table_name = (String) paramMap.get("classify_table_name");
		
		return classify_table_name;
	}

	@Override
	public List<ClassifyNode> getClassifyNodeByTableName(String classifyTableName) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("classifyTableName", classifyTableName);
		List<ClassifyNode> classifyNodeList =
				getSessionTemplate().selectList("getClassifyNodeByTableName", paramMap);
		return classifyNodeList;
	}

	@Override
	public Integer createClassifyNodeByTable(String classifyTableName, Integer pId, String nodeName) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("classifyTableName", classifyTableName);
		paramMap.put("pId", pId);
		paramMap.put("nodeName", nodeName);
		paramMap.put("id", null);
		
		Integer row = getSessionTemplate().insert("createClassifyNodeByTable", paramMap);
		
		Integer id = (Integer) paramMap.get("id");
		
		return id;
	}

	@Override
	public Integer updateNodeNameByTable(String classifyTableName, String nodeName,Integer id) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("classifyTableName", classifyTableName);
		paramMap.put("nodeName", nodeName);
		paramMap.put("id", id);
		Integer row = getSessionTemplate().update("updateNodeNameByTable", paramMap);
		
		
		return row;
	}

	@Override
	public Integer updateNodePIdByTable(String classifyTableName, Integer pId, Integer id) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("classifyTableName", classifyTableName);
		paramMap.put("pId", pId);
		paramMap.put("id", id);
		Integer row = getSessionTemplate().update("updateNodePIdByTable", paramMap);
		
		
		return row;
	}

	@Override
	public Integer deleteClassifyNodeByTable(String classifyTableName, Integer id) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("classifyTableName", classifyTableName);
		paramMap.put("id", id);
		Integer row = getSessionTemplate().delete("deleteClassifyNodeByTable", paramMap);
		
		
		return row;
	}

	@Override
	public List<ClassifyTreeInfo> getAllClassify() {
		List<ClassifyTreeInfo> classifyTreeInfoList = 
				getSessionTemplate().selectList("getAllClassify");
		return classifyTreeInfoList;
	}

	@Override
	public Integer insertShowRelation(Integer nodeId, Integer classifyTreeId) {
		
		Map<String, Object> paramMap = new HashMap<String,Object>();
		paramMap.put("nodeId", nodeId);
		paramMap.put("classifyTreeId", classifyTreeId);
		
		Integer row = getSessionTemplate().insert("insertShowRelation", paramMap);
		
		
		return row;
	}

	@Override
	public List<ClassifyTreeInfo> getClassifyByNodeId(Integer nodeId) {
		 List<ClassifyTreeInfo> classifyTreeInfoList = 
				 getSessionTemplate().selectList("getClassifyByNodeId", nodeId);
		return classifyTreeInfoList;
	}

	@Override
	public Integer getRelationCountByNodeId(Integer nodeId) {
		 Integer count = 
				 getSessionTemplate().selectOne("getRelationCountByNodeId", nodeId);
		return count;
	}

	@Override
	public void deleteRelationByNodeId(Integer nodeId) {
				 getSessionTemplate().delete("deleteRelationByNodeId", nodeId);
	}

	@Override
	public void createRelTable(String relationshipTableName) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("relationshipTableName", relationshipTableName);
		getSessionTemplate().update("createRelTable", paramMap);
	}

	
	
	
	
}
