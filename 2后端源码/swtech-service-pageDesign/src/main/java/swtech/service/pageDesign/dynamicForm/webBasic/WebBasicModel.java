package swtech.service.pageDesign.dynamicForm.webBasic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WebBasicModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer page;
	
	private Integer pageSize; 

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
  
}
