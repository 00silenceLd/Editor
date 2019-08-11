package swtech.facade.pageDesign.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.facade.pageDesign.entity.HtProducts;
import swtech.facade.pageDesign.entity.HtReservation;
import swtech.facade.pageDesign.entity.HtShopcar;
import swtech.facade.pageDesign.service.HtReservationFacade;
import swtech.service.pageDesign.dao.HtReservationDao;
import swtech.service.pageDesign.dao.HtShopcarDao;
import swtech.service.pageDesign.dao.HtproductsDao;


/**
 * 袁君选
 * @author Administrator
 *	餐品上传操作
 */
@Path("htReservationFacade")
@Component("htReservationFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HtReservationFacadeImpl implements HtReservationFacade {
	
	@Autowired
	private HtShopcarDao htShopcarDao;
	
	@Autowired
	private HtReservationDao htReservationDao;

	

	/**
	 * 餐品预订
	 * 袁君选
	 */
	@POST
	@Path("/reservation")   
	public int reservation(HtReservation htReservation) {
		// TODO Auto-generated method stub
		int machineId=1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV<0) {
			hashCodeV = - hashCodeV;
		}
		System.out.println(hashCodeV);
		String orderid=machineId+String.format("%015d", hashCodeV);
		int reBeiId = 0;
		List<Integer> useTheCode = htReservationDao.useTheCode();
		for(int i=0;i<useTheCode.size();i++) {
			int useThe=(int)((Math.random()*9+1)*100000);
			if(useThe!=useTheCode.get(i)) {
				reBeiId=useThe;
				break;
			}
		}
		htReservation.setOrderid(orderid);
		htReservation.setReBeiId(reBeiId);
		int insertSelectiveReservation=htReservationDao.insertSelectiveReservation(htReservation);	
		if(insertSelectiveReservation!=0) {
			int getReservationId=htReservationDao.getReservationId();
			int updateStatus=htShopcarDao.updateStatus(getReservationId);
			if(updateStatus>0) {
				return insertSelectiveReservation+updateStatus;
			}else {
				return 0;
			}
			
		}else {
			return 0;
		}
//		return 0;
	}

	/**
	 * 预订成功
	 * 袁君选
	 */
	@POST
	@Path("/latestData")
	public HtReservation latestData() {
		// TODO Auto-generated method stub
		HtReservation latestData = htReservationDao.latestData();
		return latestData;
	}
	
	/**
	 * 取消订单
	 * 袁君选
	 */
	@POST
	@Path("/cencel")
	public int cencel(HtReservation htReservation) {
		// TODO Auto-generated method stub
		int shopcarBei=htReservation.getRid();
		int rid=htReservation.getRid();
		int orderId=3;
		HtReservation htqwe=new HtReservation();
		htqwe.setRid(rid);
		htqwe.setOrderId(orderId);
		int orderIdrid = htReservationDao.orderIdrid(htqwe);
		
		System.out.println(shopcarBei);
		int cancelall = htShopcarDao.cancelorder(shopcarBei);
		if(cancelall!=0) {
			int updateByPrimaryKeySelectiveReservation = htReservationDao.updateByPrimaryKeySelectiveReservation(htReservation);
			if(updateByPrimaryKeySelectiveReservation!=0) {
				return updateByPrimaryKeySelectiveReservation+cancelall;
			}else {
				return 1;
			}
			
		}else {
			return 0;
		}

//		return 0;
	}

	/**
	 * 订单中心
	 * 袁君选
	 */
	@POST
	@Path("/ordercnetel")
	public List<Map<String, Object>> ordercentel() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> ordercentel = htReservationDao.ordercentel(); 
		return ordercentel;
	}

	/**
	 * 订单详情
	 * 袁君选
	 */
	@POST
	@Path("/orderdetails")
	public List<Map<String, Object>> orderdetails(@QueryParam("reBeiId")Integer reBeiId) {
		List<Map<String,Object>> orderdetails = htReservationDao.orderdetails(reBeiId);
		return orderdetails;
	}

	/**
	 * 已预订
	 * 袁君选
	 */
	@POST
	@Path("/all")
	public List<HtReservation> allorder(@QueryParam("shopcarStatus")Integer shopcarStatus) {
		// TODO Auto-generated method stub
		return htReservationDao.allorder(shopcarStatus);
	}
	
	/**
	 * 确认跳转
	 */
	@POST
	@Path("/confirm")
	public int confirm(@QueryParam("reBeiId")Integer reBeiId) {
		// TODO Auto-generated method stub
		int estimateReoid = htReservationDao.estimateReoid(reBeiId);
		if(estimateReoid==0) {
			return htReservationDao.confirm(reBeiId);
		}else {
			return 0;
		}
		
	}


}
