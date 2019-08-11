package swtech.pageDesignControl.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
 * @QualifiedName:swtech.pageDesignControl.entity.CJDJUserEx
 * @ClassName: CJDJUserEx
 * @Author 曾智宏
 * @Date 2019年8月9日 下午6:15:37
 * @Description: 曹江党建用户拓展信息表实体类
 *
 */

@Data
@TableName("ht_cjdj_user_ex")
public class CJDJUserEx implements Serializable{

	private static final long serialVersionUID = 1L;

	@TableId
    private Integer id;//
    private Integer userId;//用户id
    private String name;//用户中文名
    private String sex;//性别
    private Date birthday;//出生日期
    private Integer age;//年龄
    private String degree;//学历
    private Date joinPartyTime;//入党时间
    private String scoreResult;//评分结果
    private String partyBranch;//党支部
    private Date regularTime;//转正时间
    private String address;//住址
    private String partyMemberType;//党员类型
    private String condolencesSituation;//慰问情况
    private String isOutflow;//是否流出
    private Date outflowTime;//流出时间
    private String outflowAddress;//流出地址
    private String nation;//民族
    private Integer idNum;//身份证号
    private Integer phoneNum;//电话号码
    private String industry;//行业
    private String developType;//发展类型
    private Date vigorousTime;//加入 积极分子时间
    private Date developObjectTime;//列入发展对象时间
    private Date readyPartyMemberTime;//成为预备党员时间
    private String remarks;//备注

}