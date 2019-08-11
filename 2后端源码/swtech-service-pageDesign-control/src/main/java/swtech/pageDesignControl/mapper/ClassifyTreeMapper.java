package swtech.pageDesignControl.mapper;

import java.util.List;
import java.util.Map;

import swtech.pageDesignControl.entity.ClassifyNode;
import swtech.pageDesignControl.entity.ClassifyNodeAndDataRel;
import swtech.pageDesignControl.entity.ClassifyTreeInfo;
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
 * @QualifiedName:swtech.pageDesignControl.mapper.ClassifyTreeMapper
 * @ClassName: ClassifyTreeMapper
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:36:09
 * @Description:  编辑器树形分类控件应用方面相关功能持久层接口
 *
 */

//@Mapper
public interface ClassifyTreeMapper {

	public ClassifyTreeInfo getClassifyInfoByNodeId(Integer nodeId);

	public List<ClassifyNode> getNextLvClassifyNodeById(Map<String, Object> paramMap);
	
	public Integer saveRelForNodeAndDataId(ClassifyNodeAndDataRel classifyNodeAndDataRel);

	public Integer deleteRelForNodeAndDataId(ClassifyNodeAndDataRel classifyNodeAndDataRel);

	public List<Integer> getDataIdByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel);

	public Integer updatePIdByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel);

	public Integer getRelCountByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel);

	public List<String> getDataUuidByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel);



}
