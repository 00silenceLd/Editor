package swtech.service.pageDesign.dao;

import java.util.List;

import swtech.common.core.dao.BaseDao;
import swtech.facade.pageDesign.entity.ClassifyNode;
import swtech.facade.pageDesign.entity.ClassifyTreeInfo;



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
 * @QualifiedName:swtech.service.pageDesign.dao.ClassifyTreeInfoDao
 * @ClassName: ClassifyTreeInfoDao
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:23:27
 * @Description: 树形分类控件持久层接口
 *
 */
public interface ClassifyTreeInfoDao extends BaseDao<ClassifyTreeInfo>{

	ClassifyTreeInfo getClassifyTreeInfoByNodeId(Integer nodeId);

	Integer createClassifyTable(String classifyTableName);

	Integer saveClassifyTreeInfo(ClassifyTreeInfo classifyTreeInfo);

	Integer updateClassifyTreeInfo(ClassifyTreeInfo classifyTreeInfo);

	String getClassifyTableNameByNodeId(Integer nodeId);

	List<ClassifyNode> getClassifyNodeByTableName(String classifyTableName);

	Integer createClassifyNodeByTable(String classifyTableName, Integer pId, String nodeName);

	Integer updateNodeNameByTable(String classifyTableName, String nodeName, Integer id);

	Integer updateNodePIdByTable(String classifyTableName, Integer pId, Integer id);

	Integer deleteClassifyNodeByTable(String classifyTableName, Integer id);

	List<ClassifyTreeInfo> getAllClassify();

	Integer insertShowRelation(Integer nodeId, Integer classifyTreeId);

	List<ClassifyTreeInfo> getClassifyByNodeId(Integer nodeId);

	Integer getRelationCountByNodeId(Integer nodeId);

	void deleteRelationByNodeId(Integer nodeId);

	void createRelTable(String relationshipTableName);





}
