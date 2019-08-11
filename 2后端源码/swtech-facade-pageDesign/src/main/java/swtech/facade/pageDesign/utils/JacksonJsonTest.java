package swtech.facade.pageDesign.utils;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.ObjectMapper;

import swtech.facade.pageDesign.entity.GuanliControl;
import swtech.facade.pageDesign.entity.BaseControl;
import swtech.facade.pageDesign.entity.TextControl;

/**
 * 
 * @author xinchun.wang 
   @email: 532002108@qq.com
 * @createTime 2015-3-24 下午8:27:12
 */
public class JacksonJsonTest {
	public static void main(String[] args) throws Exception {
		List<BaseControl> dataList = new ArrayList<BaseControl>();
	    GuanliControl ac=new GuanliControl();
	    
	    ac.setStyle("width: 80px;height: 30px;");
		dataList.add(ac); 
		TextControl txt=new TextControl();
		txt.setName("dsfsa");
		txt.setDatasource("dsdfasdfasd");
		dataList.add(txt);
		
		D d = new D();
		d.setList(dataList);
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(d);
		System.out.println(data);
		D result = mapper.readValue(data, D.class);

		System.out.println(result.getList());
	}

	public static class D {
		List<BaseControl> list;

		public List<BaseControl> getList() {
			return list;
		}

		public void setList(List<BaseControl> list) {
			this.list = list;
		}

	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "typeName")
	@JsonSubTypes({ @JsonSubTypes.Type(value = B.class, name = "B"),
			@JsonSubTypes.Type(value = C.class, name = "C"),
			@JsonSubTypes.Type(value = GuanliControl.class, name = "AC")
	})
	public static class A {
		protected int a;

		public A() {
		}

		public A(int a) {
			this.a = a;
		}

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
	public static class B extends A {
		public B() {
		}

		public B(int b, int a) {
			super(a);
		}

		private int b;

		public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}
	}

	@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "typeName")
	public static class C extends A {
		private String c;

		public C() {
		}

		public C(String c, int a) {
			super(a);
			this.c = c;
		}

		public String getC() {
			return c;
		}

		public void setC(String c) {
			this.c = c;
		}

	}
}

