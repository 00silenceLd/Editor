package swtech.pageDesignControl.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReservation;
import swtech.pageDesignControl.mapper.HtReservationMapper;
import swtech.pageDesignControl.mapper.HtShopcarMapper;
import swtech.pageDesignControl.service.HtReservationDao;



@Service
public class HtReservationDaoImpl implements HtReservationDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtReservationDaoImpl.class);

	@Autowired
	private HtShopcarMapper htShopcarMapper;

	@Autowired
	private HtReservationMapper htReservationMapper;



//	@Transactional
//	@Override
//	public ReturnMsg insertSelectiveReservation(HtReservation record) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(record==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		    msg.setMsg(ordercentel);
//
//
//		return msg;
//			// TODO Auto-generated method stub
////		return getSessionTemplate().insert("insertSelectiveReservation",record);
//	}

	

	@Override
	@Transactional
	public  ReturnMsg latestData() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		HtReservation latestData = htReservationMapper.latestData();
		//对查询结果进行判断
		if(latestData==null)throw new ServiceException("操作失败");

		if(latestData!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(latestData);
		}

		return msg;
//		return getSessionTemplate().selectOne("latestData");
	}

	@Override
	@Transactional
	public ReturnMsg cencel(HtReservation htReservation) {

		ReturnMsg msg = new ReturnMsg();

		if(htReservation==null)throw new ServiceException("参数不能为空");

		int shopcarBei=htReservation.getRid();
		int rid=htReservation.getRid();
		int orderId=3;
		HtReservation htqwe=new HtReservation();
		htqwe.setRid(rid);
		htqwe.setOrderId(orderId);
		int orderIdrid = htReservationMapper.orderIdrid(htqwe);

//		System.out.println(shopcarBei);
		int cancelall = htShopcarMapper.cancelorder(shopcarBei);
		//对查询结果进行判断
		if(cancelall==0)throw new ServiceException("操作失败");

		if(cancelall!=0) {
			int updateByPrimaryKeySelectiveReservation = htReservationMapper.updateByPrimaryKeySelectiveReservation(htReservation);
				if(updateByPrimaryKeySelectiveReservation==0)throw new ServiceException("操作失败");
				msg.setStatus("200");
				msg.setStatusMsg("操作成功");
				msg.setMsg(updateByPrimaryKeySelectiveReservation+cancelall);

		}
		return msg;
//		return null;
	}


//	@Override
//	@Transactional
//	public  ReturnMsg useTheCode() {
//		ReturnMsg msg = new ReturnMsg();
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//			msg.setMsg(ordercentel);
//
//
//		return msg;
//		// TODO Auto-generated method stub
////		return getSessionTemplate().selectList("useTheCode");
//	}

//	@Override
//	@Transactional
//	public  ReturnMsg getReservationId() {
//		ReturnMsg msg = new ReturnMsg();
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//			msg.setMsg(ordercentel);
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return getSessionTemplate().selectOne("getReservationId");
//	}
	
	@Override
	@Transactional
	public  ReturnMsg ordercentel() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
		//对查询结果进行判断
		if(ordercentel==null)throw new ServiceException("操作失败");

		if(ordercentel!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(ordercentel);
		}

		return msg;
//		return getSessionTemplate().selectList("ordercentel");
	}


	
//	@Override
//	@Transactional
//	public  ReturnMsg deleteByPrimaryKeyReservation(Integer rid) {
//		// TODO Auto-generated method stub
//		ReturnMsg msg = new ReturnMsg();
//
//		if(rid==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//			msg.setMsg(ordercentel);
//		}
//
//		return msg;
////		return 0;
//	}



//	@Override
//	@Transactional
//	public  ReturnMsg insertReservation(HtReservation record) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(record==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return 0;
//	}



//	@Override
//	@Transactional
//	public  ReturnMsg selectByPrimaryKeyReservation(Integer rid) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(rid==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return null;
//	}



//	@Override
//	@Transactional
//	public  ReturnMsg updateByPrimaryKeySelectiveReservation(HtReservation record) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(record==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}

//		return msg;
//		// TODO Auto-generated method stub
////		return getSessionTemplate().update("updateByPrimaryKeySelectiveReservation", record);
//	}



//	@Override
//	@Transactional
//	public  ReturnMsg updateByPrimaryKeyReservation(HtReservation record) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(record==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return 0;
//	}



	@Override
	@Transactional
	public  ReturnMsg orderdetails(Integer reBeiId) {
		ReturnMsg msg = new ReturnMsg();

		if(reBeiId==null)throw new ServiceException("参数不能为空");
		List<Map<String,Object>> orderdetails = htReservationMapper.orderdetails(reBeiId);

		//对查询结果进行判断
		if(orderdetails==null)throw new ServiceException("操作失败");

		if(orderdetails!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(orderdetails);
		}

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().selectList("orderdetails", reBeiId);
	}



	@Override
	@Transactional
	public  ReturnMsg allorder(Integer shopcarStatus) {
		ReturnMsg msg = new ReturnMsg();

		if(shopcarStatus==null)throw new ServiceException("参数不能为空");

		List<HtReservation> allorder = htReservationMapper.allsss(shopcarStatus);
		//对查询结果进行判断
		if(allorder==null)throw new ServiceException("操作失败");

		if(allorder!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(allorder);
		}

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().selectList("allsss",shopcarStatus);
	}



	@Override
	@Transactional
	public  ReturnMsg confirm(Integer reBeiId) {
		ReturnMsg msg = new ReturnMsg();

		if(reBeiId==null)throw new ServiceException("参数不能为空");

		int estimateReoid = htReservationMapper.estimateReoid(reBeiId);
		if(estimateReoid==0) {
			int confirm = htReservationMapper.confirm(reBeiId);
			if(confirm ==0)throw new ServiceException("操作失败");

			if(confirm!=0) {
				msg.setStatus("200");
				msg.setStatusMsg("操作成功");
			}
		}
		//对查询结果进行判断


		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().update("confirm",reBeiId);
	}



//	@Override
//	public  ReturnMsg orderIdrid(HtReservation htReservation) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(htReservation==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return getSessionTemplate().update("orderIdrid",htReservation);
//	}



//	@Override
//	public  ReturnMsg estimateReoid(Integer reBeiId) {
//		ReturnMsg msg = new ReturnMsg();
//
//		if(reBeiId==null)throw new ServiceException("参数不能为空");
//
//		List<Map<String, Object>> ordercentel = htReservationMapper.ordercentel();
//		//对查询结果进行判断
//		if(ordercentel==null)throw new ServiceException("操作失败");
//
//		if(ordercentel!=null) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}
//
//		return msg;
//		// TODO Auto-generated method stub
////		return getSessionTemplate().selectOne("estimateReoid", reBeiId);
//	}

	@Override
	@Transactional
	public ReturnMsg reservation(HtReservation htReservation) {
		ReturnMsg msg = new ReturnMsg();

		if(htReservation==null)throw new ServiceException("参数不能为空");

		int machineId=1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV<0) {
			hashCodeV = - hashCodeV;
		}
		String orderid=machineId+String.format("%015d", hashCodeV);
		int reBeiId = 0;
		List<Integer> useTheCode = htReservationMapper.useTheCode();
		for(int i=0;i<useTheCode.size();i++) {
			int useThe=(int)((Math.random()*9+1)*100000);
			if(useThe!=useTheCode.get(i)) {
				reBeiId=useThe;
				break;
			}
		}
		htReservation.setOrderid(orderid);
		htReservation.setReBeiId(reBeiId);
		int insertSelectiveReservation=htReservationMapper.insertSelectiveReservation(htReservation);
		if(insertSelectiveReservation==0)throw new ServiceException("操作失败");
		if(insertSelectiveReservation!=0) {
			int getReservationId=htReservationMapper.getReservationId();
			int updateStatus=htShopcarMapper.updateStatus(getReservationId);

			if(updateStatus>0) {
				msg.setStatus("200");
				msg.setStatusMsg("添加成功");
				msg.setMsg(updateStatus);
			}
		}
		return msg;
	}


}
