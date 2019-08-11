package test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.service.impl.PageDesignQueryFacadeImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-context.xml"})
public class PageDesignTest {
	@Autowired
	private PageDesignQueryFacadeImpl query;
	
	@Test
	public void test()throws Exception{
		ReturnMsg result = query.getPageContent(1077);
		print(result);
	}

	public void print(Object result) {
		if (result != null){
			System.out.println(result);
		} else {
			System.out.println("返回的数据为空~~");
		}
	}

}
