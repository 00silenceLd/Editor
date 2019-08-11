package swtech.facade.pageDesign.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
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

import swtech.facade.pageDesign.entity.HtReseat;
import swtech.facade.pageDesign.service.HtReseatFacade;
import swtech.service.pageDesign.dao.HtReseatDao;
/**
   *   餐桌操作
 * @author 袁君选
 *
 */
@Path("htReseatFacade")
@Component("htReseatFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HtReseatFacadeImpl implements HtReseatFacade {
	
	@Autowired
	private HtReseatDao htReseatDao;

	@POST
	@Path("/resertall")
//	public List<HtReseat> resertall() {
		public Map<String, Object> resertall(@QueryParam("seatstatus")Integer seatstatus) {
		// TODO Auto-generated method stub
		
		Map<String, Object> all=new HashMap<>();
		all.put("resertall",htReseatDao.resertall() );
		all.put("selno",htReseatDao.selno(seatstatus));
//		return htReseatDao.resertall();
		return all;
	}

	@POST
	@Path("/insertSelectiveReseat")
	public int insertSelectiveReseat(HtReseat htReseat) {
		// TODO Auto-generated method stub
		return htReseatDao.insertSelectiveReseat(htReseat);
	}

	@POST
	@Path("/delseat")
	public int delseat() {
		// TODO Auto-generated method stub
		return htReseatDao.delseat();
	}

	@POST
	@Path("/updseat")
	public int updseat(@QueryParam("svalue")String svalue,@QueryParam("updseat")Integer updsert) {
		// TODO Auto-generated method stub
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
		int updseat=htReseatDao.updseat(upd);
		if(updseat>0) {
			return updseat;
		}else {
			return 0;
		}
		
	}

}
