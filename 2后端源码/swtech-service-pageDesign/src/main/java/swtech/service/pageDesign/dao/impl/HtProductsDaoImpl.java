package swtech.service.pageDesign.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDao;
import swtech.common.core.dao.BaseDaoImpl;
import swtech.common.entity.ReturnMsg;
import swtech.common.page.PageBean;
import swtech.common.page.PageParam;
import swtech.facade.pageDesign.entity.HtCategory;
import swtech.facade.pageDesign.entity.HtProducts;
import swtech.facade.pageDesign.util.exception.ServiceException;
import swtech.service.pageDesign.dao.HtproductsDao;

@Repository("HtproductsDao")
public class HtProductsDaoImpl extends BaseDaoImpl<HtProducts> implements HtproductsDao {


	@Override
	public ReturnMsg insertSelectiveProducts(HtProducts htProducts) {
		ReturnMsg msg = new ReturnMsg(); 
	    	
			//验证参数合法性
	
			if(htProducts==null)throw new ServiceException("record不能为空");
		
//			//封装参数，查询数据库
//			HtCategory params = new HtCategory(record);
			
			Integer insertSelectiveProducts = getSessionTemplate().insert("insertSelectiveProducts", htProducts);
	
			//对查询结果进行判断
	
			if(insertSelectiveProducts!=0) {	
				msg.setStatus("200");
				msg.setStatusMsg("添加成功");
			}else {
				msg.setStatus("108");
				msg.setStatusMsg("添加失败");
			}
	
			
			return msg;
	}

	@Override
	public List<HtProducts> allProducts(Integer productsCategory) {
		// TODO Auto-generated method stub
//		HtProducts htProducts=new HtProducts(productsCategory);
		return getSessionTemplate().
				selectList("allProducts", productsCategory);
	}
	
	@Override
	public HtProducts selectByPrimaryKeyProducts(Integer productsId) {
		
		if(productsId==null)throw new ServiceException("productsId不能为空");
		HtProducts htProducts=getSessionTemplate().selectOne("selectByPrimaryKeyProducts", productsId);
		//对查询结果进行判断
	
		return htProducts;
	}

	@Override
	public int updateByPrimaryKeySelectiveProducts(HtProducts htProducts) {
		// TODO Auto-generated method stub
		return getSessionTemplate().update("updateByPrimaryKeySelectiveProducts", htProducts);
	}

}
