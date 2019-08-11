package swtech.facade.pageDesign.service;


import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.ClassifyShowRelation;
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
 * @QualifiedName:swtech.facade.pageDesign.service.ClassifyFacadeService
 * @ClassName: ClassifyFacadeService
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:22:26
 * @Description: 树形分类控件业务接口
 *
 */

public interface ClassifyFacadeService {
	//根据需求重做的接口
	public ReturnMsg createClassifyTable(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg getAllClassifyNodeByNodeId(Integer nodeId);

	public ReturnMsg createClassify(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg updateClassifyNode(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg deleteClassify(ClassifyTreeInfo classifyTreeInfo);

	public ReturnMsg getAllClassify();

	public ReturnMsg saveShowClassifyRelation(ClassifyShowRelation classifyShowRelation);

	public ReturnMsg getClassifyByNodeId(Integer nodeId);









}
