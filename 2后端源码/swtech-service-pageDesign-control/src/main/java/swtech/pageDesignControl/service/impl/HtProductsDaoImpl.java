package swtech.pageDesignControl.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swtech.pageDesignControl.common.exception.ServiceException;
import swtech.pageDesignControl.common.vo.ReturnMsg;

import swtech.pageDesignControl.entity.HtProducts;
import swtech.pageDesignControl.mapper.HtproductsMapper;
import swtech.pageDesignControl.service.HtproductsDao;


@Service
public class HtProductsDaoImpl  implements HtproductsDao {

	//	 定义一个静态的日志器变量
	private static final Logger logger = LogManager.getLogger(HtProductsDaoImpl.class);

	@Autowired
	private HtproductsMapper htProductsMapper;

	@Override
	@Transactional
	public ReturnMsg insertSelectiveProducts(HtProducts htProducts) {
		ReturnMsg msg = new ReturnMsg(); 
	    	
			//验证参数合法性
	
		if(htProducts==null)throw new ServiceException("htproducts不能为空");

		int i = htProductsMapper.insertSelectiveProducts(htProducts);

//		Integer insertSelectiveProducts = getSessionTemplate().insert("insertSelectiveProducts", htProducts);
	
			//对查询结果进行判断
		if(i==0)throw new ServiceException("操作失败");
	

				msg.setStatus("200");
				msg.setStatusMsg("添加成功");
		      msg.setMsg(i);

	
			
			return msg;
	}

	@Override
	@Transactional
	public  ReturnMsg allProducts(Integer productsCategory) {
		ReturnMsg msg = new ReturnMsg();

		if(productsCategory==null)throw new ServiceException("productsCategory不能为空");

		List<HtProducts> htProducts = htProductsMapper.allProducts(productsCategory);

//		List<HtCategory> all = htCategoryFacade.all();

		if(htProducts==null)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(htProducts);

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().
//				selectList("allProducts", productsCategory);
	}
	
	@Override
	@Transactional
	public  ReturnMsg selectByPrimaryKeyProducts(Integer productsId) {
		ReturnMsg msg = new ReturnMsg();

		if(productsId==null)throw new ServiceException("参数不能为空");

		HtProducts htProducts1 = htProductsMapper.selectByPrimaryKeyProducts(productsId);

		if(htProducts1==null)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(htProducts1);

		return msg;
//		if(productsId==null)throw new ServiceException("productsId不能为空");
//		HtProducts htProducts=getSessionTemplate().selectOne("selectByPrimaryKeyProducts", productsId);
//		//对查询结果进行判断
//
//		return htProducts;
	}

	@Override
	@Transactional
	public  ReturnMsg updateByPrimaryKeySelectiveProducts(HtProducts htProducts) {
		ReturnMsg msg = new ReturnMsg();

		if(htProducts==null)throw new ServiceException("参数不能为空");

		int i = htProductsMapper.updateByPrimaryKeySelectiveProducts(htProducts);

		if(i==0)throw new ServiceException("操作失败");


			msg.setStatus("200");
			msg.setStatusMsg("添加成功");
			msg.setMsg(i);

		return msg;
		// TODO Auto-generated method stub
//		return getSessionTemplate().update("updateByPrimaryKeySelectiveProducts", htProducts);
	}

}
