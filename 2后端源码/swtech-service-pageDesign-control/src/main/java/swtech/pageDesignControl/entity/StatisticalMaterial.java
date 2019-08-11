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
 * @QualifiedName:swtech.pageDesignControl.entity.StatisticalMaterial
 * @ClassName: StatisticalMaterial
 * @Author 曾智宏
 * @Date 2019年7月31日 下午6:03:36
 * @Description: 报表控件中根据评分控件结果等信息进行统计的统计素材
 *
 */
@Data
public class StatisticalMaterial implements Serializable{

	private static final long serialVersionUID = 1L;
	private String statisticsTitle;//该统计素材的标题
	private List<Integer> sourceNodeIds;//数据源nodeId
	private List<String> sourceNames;//数据源中文名
	private List<String> titlefields;//数据源标题字段
	private List<String> contextfields;//数据源简介字段
	private Integer resultCount;//该数据源表的记录数
	
	





}
