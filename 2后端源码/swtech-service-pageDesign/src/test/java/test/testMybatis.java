package test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-context.xml")
public class testMybatis {

//	@Autowired
//	private SqlSessionTemplate template;
	/*@Autowired
	private ClassifyFacadeImpl cfi;
	
	@Test
	public void testInsert() {
		ClassifyTree ct = new ClassifyTree();
		ct.setTreeName("曾");
		ct.setNodeId(4564);
		cfi.saveTreeInitInfo(ct);
		System.out.println(ct);
		
	}
	*/
	
}
