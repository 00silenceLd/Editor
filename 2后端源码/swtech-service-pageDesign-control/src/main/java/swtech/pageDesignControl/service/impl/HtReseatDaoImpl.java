package swtech.pageDesignControl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReseat;
import swtech.pageDesignControl.mapper.HtReseatMapper;
import swtech.pageDesignControl.service.HtReseatDao;


@Service
public class HtReseatDaoImpl  implements HtReseatDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtReseatDaoImpl.class);

	@Autowired
	private HtReseatMapper htReseatMapper;

	@Override
	@Transactional
	public ReturnMsg resertall(Integer seatstatus) {
		ReturnMsg msg = new ReturnMsg();
		if(seatstatus==null)throw new ServiceException("参数不能为空");
		Map<String, Object> all=new HashMap<>();
		all.put("resertall",htReseatMapper.resertall() );
		all.put("selno",htReseatMapper.selno(seatstatus));

		if(all==null)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(all);

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().selectList("resertall");
	}

	@Override
	@Transactional
	public  ReturnMsg insertSelectiveReseat(HtReseat htReseat) {
		ReturnMsg msg = new ReturnMsg();
		if(htReseat==null)throw new ServiceException("htReseat不能为空");
		int i = htReseatMapper.insertSelectiveReseat(htReseat);
		if(i==0)throw new ServiceException("操作失败");

			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
		msg.setMsg(i);

		return msg;
		// TODO Auto-generated method stub


//		return getSessionTemplate().insert("insertSelectiveReseat",htReseat);
	}

	@Override
	@Transactional
	public  ReturnMsg delseat() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		int delseat = htReseatMapper.delseat();
		if(delseat==0)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
		msg.setMsg(delseat);

		return msg;
//		return getSessionTemplate().delete("delseat");
	}

//	public int updseat(List<String> seatnum) {
	@Override
	@Transactional
	public  ReturnMsg updseat(String svalue,Integer updsert) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		if(svalue==null)throw new ServiceException("svalue不能为空");
		if(updsert==null)throw new ServiceException("updsert不能为空");

		String[] aa=svalue.split(",");
		List<String> seatnum=new ArrayList<String>();
		for(int i=0;i<aa.length;i++){
			if(aa[i]!=""&&aa[i]!=null) {
				seatnum.add(aa[i]);
			}
		}
//		for(String qq:seatnum) {
//			System.out.println(qq);
//		}
		Map<String, Object> upd=new HashMap<String, Object>();
		upd.put("seatnum", seatnum);
		upd.put("updsert", updsert);
		int updseat=htReseatMapper.updseat(upd);
		if(updseat==0)throw new ServiceException("操作失败");

		if(updseat!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(updseat);
		}
		return msg;
//		return getSessionTemplate().update("updseat",upd);
	}

	@Override
	@Transactional
	public  ReturnMsg selno(Integer seatstatus) {
		ReturnMsg msg = new ReturnMsg();
		// TODO Auto-generated method stub
		return msg;
//		return getSessionTemplate().selectList("selno",seatstatus);
	}

	
}
