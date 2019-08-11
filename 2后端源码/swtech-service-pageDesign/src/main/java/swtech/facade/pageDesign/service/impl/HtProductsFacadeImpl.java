package swtech.facade.pageDesign.service.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.HtProducts;
import swtech.facade.pageDesign.entity.HtProductsPicture;
import swtech.facade.pageDesign.service.HtProductsFacade;
import swtech.service.pageDesign.dao.HtProductsPictureDao;
import swtech.service.pageDesign.dao.HtproductsDao;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 袁君选
 * @author Administrator
 *	餐品上传操作
 */
@Path("htProductsFacade")
@Component("htProductsFacade")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8 })
public class HtProductsFacadeImpl   implements HtProductsFacade {
	
	@Autowired
	private HtproductsDao htproductsDao;
	
	@Autowired
	private HtProductsPictureDao htProductsPictureDao;
	
//	/**
//	 * 图片上传处理
//	 * 袁君选
//	 */
//	@POST
//	@Path("/uploadPicture")
//	public void uploadPicture(@QueryParam(value="file")MultipartFile file){
////		HttpServletRequest request;
////		HttpServletResponse response;
//        HtResponseResult result = new HtResponseResult();
//        Map<String, Object> map = new HashMap<String, Object>();
//        File targetFile=null;
//        String url="";//返回存储路径
//        int code=1;
//        System.out.println(file);
//        String fileName=file.getOriginalFilename();//获取文件名加后缀
//        if(fileName!=null&&fileName!=""){
////            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() +"/upload/imgs/";//存储路径
////            String path = request.getSession().getServletContext().getRealPath("upload/imgs"); //文件存储位置
////            String returnUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();//存储路径
////            String path = request.getSession().getServletContext().getRealPath(""); //文件存储位置
//            String path = "E://tupian"; //文件存储位置
//            String fileF = fileName.substring(fileName.lastIndexOf("."), fileName.length());//文件后缀
//            fileName=new Date().getTime()+"_"+new Random().nextInt(1000)+fileF;//新的文件名
//
//            //先判断文件是否存在
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//            String fileAdd = sdf.format(new Date());
//            //获取文件夹路径
//            File file1 =new File(path+"/"+fileAdd);
//            //如果文件夹不存在则创建    
//            if(!file1 .exists()  && !file1 .isDirectory()){
//                file1 .mkdir();
//            }
//            //将图片存入文件夹
//            targetFile = new File(file1, fileName);
//            try {
//                //将上传的文件写到服务器上指定的文件。
//                file.transferTo(targetFile);
////                url=returnUrl+fileAdd+"/"+fileName;
//                url=path+fileAdd+"/"+fileName;
//                code=0;
//                result.setCode(code);
//                result.setMessage("图片上传成功");
//                map.put("url", url);
//                result.setResult(map);
//            } catch (Exception e) {
//                e.printStackTrace();
//                result.setMessage("系统异常，图片上传失败");
//            }
//        }
////        writeJson(response, result);
//    }
	

	/**
	 * 餐品上传
	 * 袁君选
	 */
	@POST
	@Path("/insertSelectiveProducts")
	public ReturnMsg insertSelectiveProducts(HtProducts htProducts) {
	
//		System.out.println(htProducts.toString());
		ReturnMsg msg = new ReturnMsg(); 
		try {
			msg = htproductsDao.insertSelectiveProducts(htProducts);
		} catch (Exception e) {
			e.printStackTrace();
			msg.setStatus("201");
			msg.setStatusMsg(e.getMessage());
		}
		return msg;
	}

	@POST
	@Path("/allProducts")
	public List<HtProducts> allProducts(@QueryParam("productsCategory")Integer productsCategory) {
		// TODO Auto-generated method stub
		System.out.println(productsCategory);
		return htproductsDao.allProducts(productsCategory);
	}
	
	@POST
	@Path("/selectByPrimaryKey")
	public HtProducts selectByPrimaryKeyProducts(@QueryParam("productsId") Integer productsId) {
			HtProducts htProducts = htproductsDao.selectByPrimaryKeyProducts(productsId);
			System.out.println(htProducts);
		
		return htProducts;
	}

	@POST
	@Path("/insertSelectiveHtProductsPicture")
	public int insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture) {
		// TODO Auto-generated method stub
		System.out.println("fasdfas");
		System.out.println(htProductsPicture.getHppUrl());
		return htProductsPictureDao.insertSelectiveHtProductsPicture(htProductsPicture);
	}

	@POST
	@Path("/theme")
	public HtProductsPicture theme() {
		// TODO Auto-generated method stub
		return htProductsPictureDao.theme();
	}

}
