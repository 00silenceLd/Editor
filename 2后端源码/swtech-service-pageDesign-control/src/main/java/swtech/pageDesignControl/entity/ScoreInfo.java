package swtech.pageDesignControl.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;


/*
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
 * @QualifiedName:swtech.pageDesignControl.entity.ScoreInfo
 * @ClassName: ScoreInfo
 * @Author 曾智宏
 * @Date 2019年7月31日 下午5:08:45
 * @Description: 编辑器评分控件功能表实体类
 *
 */

@Data
@TableName("ht_score_info")
public class ScoreInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId
	private Integer id;//
	private Integer nodeId;//该评分所属的页面nodeId
	private Integer selectId;//该评分所属的页面的记录id
	private Integer scoreResult;//评分结果（1~5）




}