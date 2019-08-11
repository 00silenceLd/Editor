package swtech.service.pageDesign.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.CommentInfo;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.CommentDataDao;
/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛━━━━┛┻━┓
 * ┃　　　　　　┃
 * ┃　　　━　     ┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　┃
 * ┃　　　┻　　 ┃
 * ┃　　　　　　┃
 * ┗━┓　　　┏━┛
 *　     ┃　　　┃神兽保佑
 *　　 ┃　　　┃代码无BUG！
 *　　 ┃　　　┗━━━┓
 *　　 ┃　　　　　　┣┓
 *　　 ┃　　　　　　┏┛
 *　　 ┗┓┓┏━┳┓┏┛
 *　　　┃┫┫ ┃┫┫
 *　　　┗┻┛ ┗┻┛
 *
 *
 * @description : 章节功能实现
 * ---------------------------------
 * @Author : 曾智宏
 * @since : Create in 2019-4-4 16:35:55
 **/
@Repository("commentDataDao")
//@Transactional
public class CommentDataDaoImpl extends BaseDaoImpl<CommentInfo> implements CommentDataDao{

	private static final Logger log = LoggerFactory.getLogger(CommentDataDaoImpl.class);

	@Override
	public  ReturnMsg  getComment(Integer nodeId,Integer selectId) {
		ReturnMsg<List<CommentInfo>> msg = new ReturnMsg<List<CommentInfo>>();
		//验证参数合法性

		if(nodeId==null)throw new ServiceException("nodeId不能为空");
		if(selectId==null)throw new ServiceException("selectId不能为空");

		//封装参数，查询数据库
		Map<String, Integer> params = new HashMap<String,Integer>();
		params.put("nodeId", nodeId);
		params.put("selectId", selectId);
		List<CommentInfo> commentInfoList = getSessionTemplate().selectList("getComment",params);

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
		Map<String, String> pubUserMap = getSessionTemplate().selectOne("getUserByUidOnComment",uid);
		String chinese_name;
		String username;
		if(pubUserMap!=null) {
			chinese_name = pubUserMap.get("chinese_name");
			username = pubUserMap.get("username");
		}else {
			chinese_name = "无名氏";
			username = "无名氏";
		}
//		log.info("=========查出来的chinese_name============"+chinese_name);
//		log.info("=========查出来的username============"+username);
		if(chinese_name==null) {
			pubUser = username;
		}else {
			pubUser = chinese_name;
		}

		//封装参数（我知道有点多余。。。。）
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("nodeId", nodeId);
		params.put("selectId", selectId);
		params.put("pubUser", pubUser);
		params.put("pubContent", pubContent);
		params.put("pubTime", pubTime);
		params.put("pubApprove", pubApprove);
		params.put("uid", uid);
		//将发布消息保存
		int row = getSessionTemplate().insert("releaseComment", params);

		//对结果进行判断
		if(row==0)throw new ServiceException("保存进数据库失败");

		msg.setStatus("200");
		msg.setStatusMsg("发布成功");
		return msg;
	}

	@Override
	public ReturnMsg deleteComment(Integer[] ids) {
		ReturnMsg msg = new ReturnMsg();
		//验证参数合法性
		for(Integer id:ids) {
			System.out.println(id);
			
		}
		if(ids==null||ids.length==0)throw new ServiceException("id不能为空");

		for(Integer id:ids) {

			//检查一下数据库有没有该记录
			Integer count = getSessionTemplate().selectOne("commentCount", id);
			if(count==0)throw new ServiceException("数据库没有id="+id+"的评论");

			//删除记录
			int row = getSessionTemplate().delete("deleteComment", id);

			//结果验证
			if(row==0)throw new ServiceException("删除失败");

		}
		msg.setStatus("200");
		msg.setStatusMsg("删除成功");
		return msg;
	}

	@Override
	public ReturnMsg passApproveComment(Integer[] ids) {
		ReturnMsg msg = new ReturnMsg();
		if(ids==null||ids.length==0)throw new ServiceException("id不能为空");
		//验证参数合法性
		for(Integer id:ids) {
			
			//检查一下数据库有没有该记录
			Integer count = getSessionTemplate().selectOne("commentCount", id);
			if(count==0)throw new ServiceException("数据库没有id="+id+"的评论");

			//删除记录
			int row = getSessionTemplate().update("passApproveComment", id);

			//结果验证
			if(row==0)throw new ServiceException("审核失败");

		}
		msg.setStatus("200");
		msg.setStatusMsg("审核成功");
		return msg;
	}

	@Override
	public LayuiTabReturn getNotApproveComment(Integer page,Integer limit) {
		LayuiTabReturn msg = new LayuiTabReturn();
		//获取所有未通过审核的评论
		Integer begin = page*limit-limit;
		Map<String, Integer> pageMap = new HashMap<String,Integer>();
		pageMap.put("begin", begin);
		pageMap.put("limit", limit);
		List<CommentInfo> commentInfoList = 
				getSessionTemplate().selectList("getNotApproveComment",pageMap);

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
			Map<String, String> pubUserMap = getSessionTemplate().selectOne("getUserByUidOnComment",uid);
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
			System.out.println(nodeId);
			String nodeName = getSessionTemplate().selectOne("getNodeNameByNodeIdz", nodeId);
			if(nodeName==null)throw new ServiceException("获取nodeName="+nodeName+",失败！！");
			System.out.println(nodeName);
			System.out.println(commentInfo.getSelectId().toString());
			//2.根据node_name找到该表，并根据selectId获取该表的title字段
			Map<String, String> paramMap = new HashMap<String,String>();
			paramMap.put("nodeName", nodeName);
			paramMap.put("selectId", commentInfo.getSelectId().toString());

			String theme ;
			try {
				//这是获取动态数据表的字段，可能不存在，会报错
				theme = getSessionTemplate().selectOne("getThemeByNodeName",paramMap);
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
		Integer commentCount = getSessionTemplate().selectOne("getNotApproveCommentCount");

		msg.setCount(commentCount);
		msg.setMsg(commentInfoList2);
		msg.setStatus("200");
		msg.setStatusMsg("查询成功");

		return msg;
	}







}
