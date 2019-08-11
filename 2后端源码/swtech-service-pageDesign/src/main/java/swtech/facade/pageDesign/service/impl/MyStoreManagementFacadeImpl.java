package swtech.facade.pageDesign.service.impl;

import java.util.Date;
import java.util.HashMap;
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
import com.sun.jmx.snmp.Timestamp;

import swtech.facade.pageDesign.entity.MyBeautyCommodity;
import swtech.facade.pageDesign.entity.MyReservation;
import swtech.facade.pageDesign.entity.MyStoreManagement;
import swtech.facade.pageDesign.service.MyStoreManagementFacade;
import swtech.service.pageDesign.dao.MyBeautyCommodityDao;
import swtech.service.pageDesign.dao.MyReservationDao;
import swtech.service.pageDesign.dao.MyStoreManagementDao;
/**
 * 美业操作
 * @author 袁君选
 *
 */
@Path("myStoreManagementFacade")
@Component("myStoreManagementFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class MyStoreManagementFacadeImpl implements MyStoreManagementFacade {
	
	@Autowired
	private MyBeautyCommodityDao myBeautyCommodityDao;
	
	@Autowired 
	private MyStoreManagementDao myStoreManagementDao;
	
	@Autowired
	private MyReservationDao myReservationDao;

	/**
	 * 店铺上传操作
	 */
	@POST
	@Path("/insertMyStoreManagement")
	public int insertMyStoreManagement(MyStoreManagement myStoreManagement) {
		// TODO Auto-generated method stub
		
		return myStoreManagementDao.insertMyStoreManagement(myStoreManagement);
	}
	
//	@POST
//	@Path("/selectSm")
//	public MyStoreManagement selectSm() {
//		// TODO Auto-generated method stub
//		return myStoreManagementDao.selectSm();
//	}

	/**
	 * 商品上传操作
	 */
//	@POST
//	@Path("/selectByPrimaryKeyBeautyCommodity")
//	public MyBeautyCommodity selectByPrimaryKeyBeautyCommodity(Integer bcId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@POST
	@Path("/updateByPrimaryKeySelectiveCommodity")
	public int updateByPrimaryKeySelectiveCommodity(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return myBeautyCommodityDao.updateByPrimaryKeySelectiveCommodity(myBeautyCommodity);
	}
	
	@POST
	@Path("/deleteByPrimaryKeyCommodity")
	public int deleteByPrimaryKeyCommodity(@QueryParam("bcId") Integer bcId) {
		// TODO Auto-generated method stub
		return myBeautyCommodityDao.deleteByPrimaryKeyCommodity(bcId);
	}
	
	@POST
	@Path("/insertMyBeautyCommodity")
	public int insertMyBeautyCommodity(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return myBeautyCommodityDao.insertMyBeautyCommodity(myBeautyCommodity);
	}

	@POST
	@Path("/selectAll")
	public Map<String,Object> selectAll() {
		// TODO Auto-generated method stub
		Map<String,Object> all= new HashMap<>();
		
		MyStoreManagement selectSm = myStoreManagementDao.selectSm();
		List<MyBeautyCommodity> selectAll = myBeautyCommodityDao.selectAll();
		all.put("msm", selectSm);
		all.put("mbc", selectAll);
		return all;
	}

	@POST
	@Path("/updateByPrimaryKeySelective")
	public int updateByPrimaryKeySelective(MyBeautyCommodity myBeautyCommodity) {
		// TODO Auto-generated method stub
		return myBeautyCommodityDao.updateByPrimaryKeySelective(myBeautyCommodity);
	}

	@POST
	@Path("/selectByPrimaryKey")
	public MyBeautyCommodity selectByPrimaryKey(@QueryParam("bcId") Integer bcId) {
		// TODO Auto-generated method stub
		return myBeautyCommodityDao.selectByPrimaryKey(bcId);
	}
	/**
	 * 预订
	 */

	@POST
	@Path("/insertSelectiveMyReservation")
	public int insertSelectiveMyReservation(MyReservation record) {
		// TODO Auto-generated method stub
		int machineId=1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV<0) {
			hashCodeV = - hashCodeV;
		}
		Timestamp nowTimestamp = new Timestamp(new Date().getTime());
		
		System.out.println(nowTimestamp);
		
		
		System.out.println(hashCodeV);
		String orderid=machineId+String.format("%015d", hashCodeV);
		int MrAuthCode = 0;
		List<Integer> useTheCode = myReservationDao.useTheCode();
		if(useTheCode.size()>0) {
			for(int i=0;i<useTheCode.size();i++) {
				int useThe=(int)((Math.random()*9+1)*100000);
				if(useThe!=useTheCode.get(i)) {
					MrAuthCode=useThe;
					break;
				}
			}
		}else {
			MrAuthCode=(int)((Math.random()*9+1)*100000);
		}
		
		
		record.setMrAuthCode(MrAuthCode);
		record.setMrOrderNumber(orderid);
		return myReservationDao.insertSelectiveMyReservation(record);
	}

	@POST
	@Path("/selectReserva")
	public List<MyReservation> selectReserva(@QueryParam("mrStatus")Integer mrStatus) {
		// TODO Auto-generated method stub
		
		return myReservationDao.selectReserva(mrStatus);
	}

	@POST
	@Path("/updReserva")
	public int updReserva(MyReservation record) {
		// TODO Auto-generated method stub
		System.out.println(record.getMrStatus());
		return myReservationDao.updReserva(record);
	}

	@POST
	@Path("/selectCode")
	public MyReservation selectCode(@QueryParam("code") Integer Code) {
		// TODO Auto-generated method stub
//		System.out.println(myReservationDao.selectCode(Code));
		return myReservationDao.selectCode(Code);
	}

	@POST
	@Path("/selectMrRid")
	public MyReservation selectMrRid(@QueryParam("mrRid") Integer mrRid) {
		// TODO Auto-generated method stub
		return myReservationDao.selectMrRid(mrRid);
	}

	

	

	


}
