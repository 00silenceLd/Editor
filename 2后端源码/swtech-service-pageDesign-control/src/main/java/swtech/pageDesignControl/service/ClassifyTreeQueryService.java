package swtech.pageDesignControl.service;

import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.ClassifyNodeAndDataRel;

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
 * @QualifiedName:swtech.pageDesignControl.service.ClassifyTreeQueryService
 * @ClassName: ClassifyTreeQueryService
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:51:49
 * @Description:  编辑器树形分类控件应用方面相关功能查询业务接口
 *
 */
public interface ClassifyTreeQueryService {


	ReturnMsg getNextLvClassifyNodeByNodeIdAndId(Integer nodeId, Integer id);

	ReturnMsg getRelByClassifyNodeAndDataRel(ClassifyNodeAndDataRel classifyNodeAndDataRel );

}
