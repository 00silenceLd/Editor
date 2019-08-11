package swtech.facade.pageDesign.service.impl;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.facade.pageDesign.entity.HtReservation;
import swtech.facade.pageDesign.entity.HtShopcar;
import swtech.facade.pageDesign.service.HtShopcarFacade;
import swtech.service.pageDesign.dao.HtReservationDao;
import swtech.service.pageDesign.dao.HtShopcarDao;
/**
 * 餐品加减操作
 * @author 袁君选
 *
 */
@Path("htShopcarFacade")
@Component("htShopcarFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HtShopcarFacadeImpl implements HtShopcarFacade {

	@Autowired
	private HtShopcarDao htShopcarDao;
	
	@Autowired
	private HtReservationDao htReservationDao;
	
	@POST
	@Path("/insertSelectiveShopCar")
	public int insertSelectiveShopCar(HtShopcar record) {
//		System.out.println(record.toString());
		// TODO Auto-generated method stub
		if(record!=null) {
			int insertSelectiveShopCar=htShopcarDao.insertSelectiveShopCar(record);
			return insertSelectiveShopCar;
		}else {
			return 0;
		}	
		
	}

	@POST
	@Path("/allHtShopcar")
	public List<Map<String, Object>> allHtShopcar() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> allHtShopcar=htShopcarDao.allHtShopcar();
//		/**
//		 * goeasy
//		 */
//		 net.sf.json.JSONArray jsonObject = net.sf.json.JSONArray.fromObject(allHtShopcar);
//        String aa=jsonObject.toString();
//        System.out.println(jsonObject);
//        GoEasyDemo goEasyDemo=new GoEasyDemo();
//        goEasyDemo.test(aa);
        
		if(allHtShopcar!=null) {
			return allHtShopcar;
		}else {
			return null;
		}
		
	}

	@POST
	@Path("/deleteByPrimaryKeyShopCar")
	public int deleteByPrimaryKeyShopCar(@QueryParam("productsId")Integer productsId) {
		System.out.println(productsId);
		if(productsId!=null) {
			int deleteByPrimaryKeyShopCar= htShopcarDao.deleteByPrimaryKeyShopCar(productsId);
			if(deleteByPrimaryKeyShopCar!=0) {
				return deleteByPrimaryKeyShopCar;
			}else {
				return 0;
			}
		}else {
			return 0;
		}
	}

	@POST
	@Path("/emptyCart")
	public int emptyCart() {
		// TODO Auto-generated method stub
		int emptyCart=htShopcarDao.emptyCart();
		if(emptyCart>0) {
			return emptyCart;
		}else {
			return 0;
		}
		
	}

	@POST
	@Path("/allorder")
	public List<Map<String, Object>> allorder(@QueryParam("shopBeiId")Integer shopBeiId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> allorder = htShopcarDao.allorder(shopBeiId);
		return allorder;
	}

	/**
	 * 立即支付
	 * 袁君选
	 */
	@POST
	@Path("/paynow")
	public int paynow(HtShopcar htShopcar) {
		// TODO Auto-generated method stub
		int rid=htShopcar.getShopcarBei();
		int orderId=2;
		HtReservation htReservation=new HtReservation();
		htReservation.setRid(rid);
		htReservation.setOrderId(orderId);
		int orderIdrid = htReservationDao.orderIdrid(htReservation);
		
		int paynow = htShopcarDao.paynow(htShopcar);
		if(paynow!=0 && orderIdrid!=0) {
			return paynow+orderIdrid;
		}else{
			return 0;
		}
		
	}

	

}
