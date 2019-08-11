package swtech.pageDesignControl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.QueryReturn;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.CommentInfo;
import swtech.pageDesignControl.mapper.ListOneCommentMapper;
import swtech.pageDesignControl.service.ListOneCommentService;


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
 * @QualifiedName:swtech.pageDesignControl.service.impl.ListOneCommentServiceImpl
 * @ClassName: ListOneCommentServiceImpl
 * @Author 曾智宏
 * @Date 2019年7月30日 上午12:25:59
 * @Description: 编辑器自定义模板控件中评论功能的业务层实现类
 *
 */

@Service
public class ListOneCommentServiceImpl implements ListOneCommentService{
	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(ListOneCommentServiceImpl.class);

	@Autowired
	private ListOneCommentMapper listOneCommentMapper;

	@Override
	public ReturnMsg getComment(Integer nodeId, Integer selectId) {
		ReturnMsg<List<CommentInfo>> msg = new ReturnMsg<List<CommentInfo>>();
		//验证参数合法性
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(selectId==null)throw new ServiceException("selectId不能为空");

		//查询数据库
		List<CommentInfo> commentInfoList =listOneCommentMapper.getComment(nodeId,selectId);
		logger.info(commentInfoList);
		
		//对查询结果进行判断
		if(commentInfoList==null||commentInfoList.size()==0) throw new ServiceException("该记录没有评论！！");
		msg.setMsg(commentInfoList);
		msg.setStatus("200");
		msg.setStatusMsg("查询成功");
		return msg;
	}

	@Override
	public ReturnMsg releaseComment(CommentInfo commentInfo) {
		ReturnMsg msg = new ReturnMsg();

		//默认每一个发布消息都需要通过审核
		commentInfo.setPubApprove(0);//强迫症
		Integer pubApprove = commentInfo.getPubApprove();

		//验证参数合法性
		Integer nodeId = commentInfo.getNodeId();
		Integer selectId = commentInfo.getSelectId();
		String pubUser = commentInfo.getPubUser();
		String pubContent = commentInfo.getPubContent();
		String pubTime = commentInfo.getPubTime();
		Integer uid = commentInfo.getUid();
		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(selectId==null)throw new ServiceException("selectId不能为空");
		if(pubUser==null);//可以为空
		if(pubContent==null)throw new ServiceException("pubContent不能为空");
		if(pubTime==null)throw new ServiceException("pubTime不能为空");
		if(uid==null)throw new ServiceException("uid不能为空");

		//根据接收到的uid查询该用户
		Map<String, String> pubUserMap = listOneCommentMapper.getUserByUidOnComment(uid);
		String chinese_name;
		String username;
		if(pubUserMap!=null) {
			chinese_name = pubUserMap.get("chinese_name");
			username = pubUserMap.get("username");
		}else {
			chinese_name = "无名氏";
			username = "无名氏";
		}
		if(chinese_name==null) {
			pubUser = username;
		}else {
			pubUser = chinese_name;
		}

		//将发布消息保存
		int row = listOneCommentMapper.releaseComment(commentInfo);

		//对结果进行判断
		if(row==0)throw new ServiceException("保存进数据库失败");

		msg.setStatus("200");
		msg.setStatusMsg("发布成功");
		return msg;
	}

	@Override
	public ReturnMsg deleteComment(List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();
		//验证参数合法性
		if(ids==null||ids.size()==0)throw new ServiceException("id不能为空");

		for(Integer id:ids) {
			//检查一下数据库有没有该记录
			Integer count = listOneCommentMapper.commentCount(id);
			if(count==0)throw new ServiceException("数据库没有id="+id+"的评论");
			//删除记录
			int row = listOneCommentMapper.deleteComment(id);
			//结果验证
			if(row==0)throw new ServiceException("删除失败");
		}
		msg.setStatus("200");
		msg.setStatusMsg("删除成功");
		return msg;
	}

	@Override
	public ReturnMsg passApproveComment(List<Integer> ids) {
		ReturnMsg msg = new ReturnMsg();
		if(ids==null||ids.size()==0)throw new ServiceException("id不能为空");
		//验证参数合法性
		for(Integer id:ids) {
			
			//检查一下数据库有没有该记录
			Integer count = listOneCommentMapper.commentCount(id);
			if(count==0)throw new ServiceException("数据库没有id="+id+"的评论");

			//
			int row = listOneCommentMapper.passApproveComment(id);

			//结果验证
			if(row==0)throw new ServiceException("审核失败");

		}
		msg.setStatus("200");
		msg.setStatusMsg("审核成功");
		return msg;
	}

	@Override
	public QueryReturn getNotApproveComment(Integer page, Integer limit) {
		QueryReturn msg = new QueryReturn();
		//获取所有未通过审核的评论
		Integer begin = page*limit-limit;
		List<CommentInfo> commentInfoList = 
				listOneCommentMapper.getNotApproveComment(begin,limit);

		if(commentInfoList.size()==0||commentInfoList==null) {
			msg.setStatus("200");
			msg.setStatusMsg("没有未审核的评论");
			return msg;
		}

		//用于保存处理过的commentInfo,然后返回
		List<CommentInfo> commentInfoList2 = new ArrayList<CommentInfo>();
		for(CommentInfo commentInfo:commentInfoList) {
			//处理时间，年月日
			String pubTime = commentInfo.getPubTime();
			String[] split = pubTime.split(" ");
			pubTime = split[0];
			commentInfo.setPubTime(pubTime);
			


			//获取当前评论的uid
			Integer uid = commentInfo.getUid();
			//根据uid查询ht_user，获取username和chineseName
			Map<String, String> pubUserMap = listOneCommentMapper.getUserByUidOnComment(uid);
			String chineseName;
			String username;
			if(pubUserMap!=null) {
				username = pubUserMap.get("username");
				chineseName = pubUserMap.get("chinese_name");

			}else {
				username = "无名氏";
				chineseName = "无名氏";
			}
			commentInfo.setUsername(username);
			commentInfo.setChineseName(chineseName);

			//根据nodeId和selectId查询数据表，获取其中的title字段
			//1.根据nodeId获取ht_pageEditor表中node_name字段
			Integer nodeId = commentInfo.getNodeId();
			String nodeName = listOneCommentMapper.getNodeNameByNodeIdz(nodeId);
			if(nodeName==null)throw new ServiceException("获取nodeName="+nodeName+",失败！！");
			//2.根据node_name找到该表，并根据selectId获取该表的title字段
			Map<String, String> paramMap = new HashMap<String,String>();
			paramMap.put("nodeName", nodeName);
			paramMap.put("selectId", commentInfo.getSelectId().toString());
			String theme ;
			try {
				//这是获取动态数据表的字段，可能不存在，会报错
				theme = listOneCommentMapper.getThemeByNodeName(paramMap);
				if(theme==null) {
					theme="无主题";
				}
			} catch (Exception e) {
				theme="无主题";
			}
			commentInfo.setTheme(theme);


			commentInfoList2.add(commentInfo);
		}

		//获取当前未审核的评论数
		Integer commentCount = listOneCommentMapper.getNotApproveCommentCount();

		msg.setCount(commentCount);
		msg.setMsg(commentInfoList2);
		msg.setStatus("200");
		msg.setStatusMsg("查询成功");

		return msg;
	}

	
	

}
