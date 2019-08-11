package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.LayuiTabReturn;
import swtech.facade.pageDesign.entity.WebUrlManage;
import swtech.facade.pageDesign.service.WebUrlManageFacade;
import swtech.facade.pageDesign.service.WebUrlManageFacadeService;





/*
 * 

 ┏┓　　　┏┓
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
 * @ClassName: WebUrlManageFacadeImpl
 * @author 曾智宏
 * @date 2019年7月20日
 * @Description: 
 * a标签跳转地址管理
 *
 */
@Path("webUrlManageFacade")
@Component("webUrlManageFacade")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8,ContentType.TEXT_XML_UTF_8})
public class WebUrlManageFacadeImpl implements WebUrlManageFacade{
	private static final Logger log = LoggerFactory.getLogger(WebUrlManageFacadeImpl.class);

	@Autowired
	private WebUrlManageFacadeService wumService;

	@Override
	@POST
	@Path("/saveWebUrl")
	public ReturnMsg saveWebUrl(WebUrlManage webUrlManage) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg=wumService.saveWebUrl(webUrlManage);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("保存/修改URL失败");
			msg.setMsg(e.getMessage());
		}

		return msg;
	}

	@Override
	@POST
	@Path("/deleteWebUrl")
	public ReturnMsg deleteWebUrl(List<Integer> idList) {
		ReturnMsg msg = new ReturnMsg();
		try {
			msg=wumService.deleteWebUrl(idList);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("删除URL失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}

	@Override
	@GET
	@Path("/getAllWebUrl")
	public LayuiTabReturn getAllWebUrl(@QueryParam("page") Integer page,@QueryParam("limit") Integer limit) {
		LayuiTabReturn msg = new LayuiTabReturn();
		try {
			msg=wumService.getAllWebUrl(page,limit);
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			msg.setStatus("201");
			msg.setStatusMsg("查询URL失败");
			msg.setMsg(e.getMessage());
		}
		return msg;
	}







}
