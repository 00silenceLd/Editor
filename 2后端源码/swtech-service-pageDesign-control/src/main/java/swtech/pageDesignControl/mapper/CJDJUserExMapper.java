package swtech.pageDesignControl.mapper;

import swtech.pageDesignControl.entity.CJDJUserEx;


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
 * @QualifiedName:swtech.pageDesignControl.mapper.CJDJUserExMapper
 * @ClassName: CJDJUserExMapper
 * @Author 曾智宏
 * @Date 2019年8月9日 下午6:21:51
 * @Description: 曹江党建用户拓展信息表持久层接口
 *
 */
public interface CJDJUserExMapper {
	//    int deleteByPrimaryKey(Integer id);
	int deleteCJDJUserById(Integer id);

	//    int insert(CJDJUserEx record);
	int insertCJDJUserEx(CJDJUserEx record);

	//    int insertSelective(CJDJUserEx record);
	int insertCJDJUserExSelective(CJDJUserEx record);

	//    CJDJUserEx selectByPrimaryKey(Integer id);
	CJDJUserEx selectCJDJUserExById(Integer id);

	//    int updateByPrimaryKeySelective(CJDJUserEx record);
	int updateCJDJUserExBySelective(CJDJUserEx record);

	//    int updateByPrimaryKey(CJDJUserEx record);
	int updateCJDJUserExById(CJDJUserEx record);
}