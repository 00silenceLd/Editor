package swtech.facade.pageDesign.service.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import swtech.facade.pageDesign.service.impl.PageDesignOperatorFacadeImpl;

import com.alibaba.dubbo.rpc.RpcContext;

public class CorsDubboResponseFilter implements ContainerResponseFilter {
//	private static final Log log = LogFactory
//			.getLog(CorsDubboResponseFilter.class);
//	public void filter(ContainerRequestContext req, ContainerResponseContext res)
//			throws IOException {
//        log.info("提请的方法是：" + req.getMethod());
//		log.info("方法：" + req.getMethod());
//		if (req.getMethod().equals("OPTIONS")) {
//			res.getHeaders().add("Access-Control-Allow-Origin", "*");
//			res.getHeaders()
//					.add("Access-Control-Allow-Headers",
//							"Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin,accountid,token");
//			res.getHeaders().add("Access-Control-Allow-Methods", "OPTIONS");
//			res.getHeaders().add("Access-Control-Max-Age", "360");
//		} else if (req.getMethod().equals("GET")) {
//			res.getHeaders().add("Access-Control-Allow-Origin", "*");
//			res.getHeaders()
//					.add("Access-Control-Allow-Headers",
//							"Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin,accountid,token");
//		} else if (req.getMethod().equals("POST")) {
//			res.getHeaders().add("Access-Control-Allow-Origin", "*");
//			res.getHeaders()
//					.add("Access-Control-Allow-Headers",
//							"Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin,accountid,token");
//			res.getHeaders().add("Access-Control-Allow-Methods", "POST");
//			res.getHeaders().add("Access-Control-Max-Age", "360");
//		}
//
//	}
	
	public void filter(ContainerRequestContext req, ContainerResponseContext res)
			throws IOException {
		System.out.println("方法：" + req.getMethod());
		if (req.getMethod().equals("OPTIONS") || req.getMethod().equals("POST")) {
			res.getHeaders().add("Access-Control-Allow-Origin", "*");
			res.getHeaders().add("Access-Control-Allow-Headers","Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin,accountid,jsessionid,token");
			res.getHeaders().add("Access-Control-Allow-Methods","POST, GET, OPTIONS");
			res.getHeaders().add("Access-Control-Max-Age", "360");
		    
		} else if (req.getMethod().equals("GET")) {
			res.getHeaders().add("Access-Control-Allow-Origin", "*");
			res.getHeaders().add("Access-Control-Allow-Headers","Content-Type,x-requested-with,Authorization,Access-Control-Allow-Origin,accountid,jsessionid,token");
		}

	}


}
