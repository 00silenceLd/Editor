package swtech.service.pageDesign.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import swtech.common.entity.ReturnMsg;
import swtech.facade.pageDesign.entity.PageEditor;
import swtech.service.pageDesign.dao.PageDesignDao;

@Component("pageDesignOperatorBiz")
@Transactional(rollbackFor = Exception.class)
public class PageDesignOperatorBiz {
	@Autowired
	private PageDesignDao pageDesignDao; 

	public ReturnMsg savePage(PageEditor pageEditor) { 
		return pageDesignDao.savePage(pageEditor); 
	}

	/**
	 * @param id
	 * @return 
	 */
	public PageEditor selectPage(long id) {
		return pageDesignDao.getByNodeId(id);
	}

	/**
	 * @param page
	 * @return
	 */
	public int updatePageEditor(PageEditor page) {

		return pageDesignDao.updatePageEditor(page);
	}

	/**
	 * @param id
	 * @return
	 */
	public PageEditor selectPageEditor(int id) {

		return pageDesignDao.selectPageEditor(id);
	}

	public ReturnMsg insertComment(String content, String field, Integer contentId, String userName, String datasource, Integer nodeId) {
		
		return pageDesignDao.insertComment(content,field, contentId,userName,datasource,nodeId);
	}

	public ReturnMsg ReleaseResources(PageEditor pageEditor) {
		
		return pageDesignDao.ReleaseResources(pageEditor);
	}

	public int checkColumn(String column, String shareToName) {
		
		return pageDesignDao.checkColumn(column,shareToName);
	}
}
