package swtech.pageDesignControl.service;

import java.util.List;

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
 * @QualifiedName:swtech.pageDesignControl.service.ClassifyTreeOperateService
 * @ClassName: ClassifyTreeOperateService
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:52:24
 * @Description:  编辑器树形分类控件应用方面相关功能操作业务接口
 *
 */
public interface ClassifyTreeOperateService {

	ReturnMsg saveRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels );

	ReturnMsg deleteRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels);

	ReturnMsg moveDataToOtherClassifyNode(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels );

	ReturnMsg saveSecondRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels);

	ReturnMsg saveThirdRelForDataIdWithClassifyPid(List<ClassifyNodeAndDataRel> classifyNodeAndDataRels);


}
