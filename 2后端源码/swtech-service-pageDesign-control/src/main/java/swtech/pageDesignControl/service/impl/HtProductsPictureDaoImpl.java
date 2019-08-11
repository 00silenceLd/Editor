package swtech.pageDesignControl.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;

import swtech.pageDesignControl.entity.HtProductsPicture;

import swtech.pageDesignControl.mapper.HtProductsPictureMapper;
import swtech.pageDesignControl.service.HtProductsPictureDao;


@Service
public class HtProductsPictureDaoImpl  implements HtProductsPictureDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtProductsPictureDaoImpl.class);

	@Autowired
	private HtProductsPictureMapper htProductsPictureMapper;


	@Override
	@Transactional
	public ReturnMsg insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture) {
		ReturnMsg msg = new ReturnMsg();

		int i = htProductsPictureMapper.insertSelectiveHtProductsPicture(htProductsPicture);

		if(i==0)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
		msg.setMsg(i);

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().insert("insertSelectiveHtProductsPicture", htProductsPicture);
	}

	@Override
	@Transactional
	public  ReturnMsg theme(Integer nodeIdqwe) {
		ReturnMsg msg = new ReturnMsg();

		HtProductsPicture theme = htProductsPictureMapper.theme(nodeIdqwe);

		if(theme==null)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(theme);

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().selectOne("theme");
	}

}
