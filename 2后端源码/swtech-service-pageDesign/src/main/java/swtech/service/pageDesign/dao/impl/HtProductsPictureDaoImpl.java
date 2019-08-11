package swtech.service.pageDesign.dao.impl;

import org.springframework.stereotype.Repository;

import swtech.common.core.dao.BaseDaoImpl;
import swtech.facade.pageDesign.entity.HtProductsPicture;
import swtech.service.pageDesign.dao.HtProductsPictureDao;

@Repository("HtProductsPictureDao")
public class HtProductsPictureDaoImpl extends BaseDaoImpl<HtProductsPicture> implements HtProductsPictureDao{

	@Override
	public int insertSelectiveHtProductsPicture(HtProductsPicture htProductsPicture) {
		// TODO Auto-generated method stub
		return getSessionTemplate().insert("insertSelectiveHtProductsPicture", htProductsPicture);
	}

	@Override
	public HtProductsPicture theme() {
		// TODO Auto-generated method stub
		return getSessionTemplate().selectOne("theme");
	}

}
