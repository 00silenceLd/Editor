package swtech.pageDesignControl.entity;

import java.io.Serializable;

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
 * @QualifiedName:swtech.pageDesignControl.entity.ClassifyNode
 * @ClassName: ClassifyNode
 * @Author 曾智宏
 * @Date 2019年8月5日 下午1:49:26
 * @Description: 编辑器树形分类控件中分类节点实体类
 *
 */
@Data
public class ClassifyNode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;//
	private Integer pId;//父id
	private String nodeName;//该节点名字
	
	
	
	
	

}
