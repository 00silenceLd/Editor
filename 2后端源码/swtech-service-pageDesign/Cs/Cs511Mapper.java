package Cs;

import java.util.Map;
import Cs.Cs511;
import Cs.Cs511Example;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import swtech.common.core.dao.BaseDao;

public interface Cs511Mapper extends BaseDao<Cs511> {

public List<Cs511> selectList();

public List<Cs511> searchKey(Cs511 entity);

public List<Cs511> searchAllKey(String str);

public long deleteArray(int[] ids);

public List<Cs511> getQueryPage(Map<String,Object> map);

public long getCount();

public long updateDelete(Map<String, Object> map);

public long isDeleteArray(int[] ids);

public long reNewData(int id);

public long reNewDataArray(int[] ids);

public List<Cs511> getReportForm(String sql);

public List<Cs511> searchIsDelete();

public List<Map<String, String>> getResourceLibrary(String sql);

}