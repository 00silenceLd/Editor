package swtech.pageDesignControl.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;
import swtech.pageDesignControl.entity.HtReservation;
import swtech.pageDesignControl.entity.HtShopcar;
import swtech.pageDesignControl.mapper.HtReservationMapper;
import swtech.pageDesignControl.mapper.HtShopcarMapper;

import swtech.pageDesignControl.service.HtShopcarDao;


@Service
public class HtShopcarDaoImpl  implements HtShopcarDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtShopcarDaoImpl.class);

	@Autowired
	private HtShopcarMapper htShopcarDaoMapper;

	@Autowired
	private HtReservationMapper htReservationMapper;

	@Override
	@Transactional
	public ReturnMsg insertSelectiveShopCar(HtShopcar record) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		if(record==null)throw new ServiceException("参数不能为空");

		int insertSelectiveShopCar=htShopcarDaoMapper.insertSelectiveShopCar(record);
		//对查询结果进行判断
		if(insertSelectiveShopCar==0)throw new ServiceException("操作失败");

		if(insertSelectiveShopCar!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(insertSelectiveShopCar);
		}

		return msg;
	}

	@Override
	@Transactional
	public  ReturnMsg allHtShopcar() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();
		List<Map<String, Object>> allHtShopcar=htShopcarDaoMapper.allHtShopcar();

		if(allHtShopcar==null)throw new ServiceException("操作失败");

		if(allHtShopcar!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(allHtShopcar);
		}

		return msg;

	}

	@Override
	@Transactional
	public  ReturnMsg deleteByPrimaryKeyShopCar(Integer productsId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		if(productsId==null)throw new ServiceException("参数不能为空");

		int deleteByPrimaryKeyShopCar= htShopcarDaoMapper.deleteByPrimaryKeyShopCar(productsId);


		if(deleteByPrimaryKeyShopCar==0)throw new ServiceException("操作失败");

		if(deleteByPrimaryKeyShopCar!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(deleteByPrimaryKeyShopCar);
		}

		return msg;
	}

	@Override
	@Transactional
	public  ReturnMsg emptyCart() {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		int emptyCart=htShopcarDaoMapper.emptyCart();


		if(emptyCart==0)throw new ServiceException("操作失败");

		if(emptyCart!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(emptyCart);
		}

		return msg;
	}


	@Override
	@Transactional
	public ReturnMsg allorder(Integer shopBeiId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		if(shopBeiId==null)throw new ServiceException("参数不能为空");

		List<Map<String,Object>> allorder = htShopcarDaoMapper.allorder(shopBeiId);


		if(allorder==null)throw new ServiceException("操作失败");

		if(allorder!=null) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(allorder);
		}

		return msg;
	}



	@Override
	@Transactional
	public  ReturnMsg paynow(HtShopcar htShopcar) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();

		if(htShopcar==null)throw new ServiceException("参数不能为空");

		int rid=htShopcar.getShopcarBei();
		int orderId=2;
		HtReservation htReservation=new HtReservation();
		htReservation.setRid(rid);
		htReservation.setOrderId(orderId);
		int orderIdrid = htReservationMapper.orderIdrid(htReservation);

		int paynow = htShopcarDaoMapper.paynow(htShopcar);


		if(paynow==0 && orderIdrid==0)throw new ServiceException("操作失败");

		if(paynow!=0 && orderIdrid!=0) {
			msg.setStatus("200");
			msg.setStatusMsg("操作成功");
			msg.setMsg(paynow);
		}

		return msg;
	}

	/**
	 *
	 * @param shopcarBei
	 * @return
	 */
	@Override
	@Transactional
	public  ReturnMsg cancelorder(Integer shopcarBei){

		ReturnMsg msg = new ReturnMsg();

		if(shopcarBei==null)throw new ServiceException("参数不能为空");

		// TODO Auto-generated method stub
//		return getSessionTemplate().update("cancelorder",shopcarBei);
		return msg;
	}

	@Override
	@Transactional
	public  ReturnMsg updateStatus(Integer getReservationId) {
		// TODO Auto-generated method stub
		ReturnMsg msg = new ReturnMsg();




//		if(deleteByPrimaryKeyShopCar==0)throw new ServiceException("操作失败");
//
//		if(deleteByPrimaryKeyShopCar!=0) {
//			msg.setStatus("200");
//			msg.setStatusMsg("操作成功");
//		}

		return msg;
	}

}
