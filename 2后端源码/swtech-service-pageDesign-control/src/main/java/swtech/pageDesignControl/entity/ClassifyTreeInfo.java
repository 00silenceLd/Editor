package swtech.pageDesignControl.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

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
 * @QualifiedName:swtech.pageDesignControl.entity.ClassifyTreeInfo
 * @ClassName: ClassifyTreeInfo
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:39:21
 * @Description: 编辑器树形分类控件中树形分类信息实体类
 *
 */

@Data
public class ClassifyTreeInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;//
	private String treeName;//该节点名字
	private Integer nodeId;//该分类所属的页面nodeId
	private String classifyTableName;//该分类的表名
	private String relationshipTableName;//该分类表中节点与数据的关系表
	
	private List<ClassifyNode> classifyNodeList;//该树形图的分类节点

	
	

	
	
	
	
	

}
