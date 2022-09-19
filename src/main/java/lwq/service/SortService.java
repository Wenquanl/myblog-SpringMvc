package lwq.service;


import lwq.pojo.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortService {
    Integer addsort(String sort_name);
    Integer updatesort(String sort_name,
                       Integer sort_id);
    Integer findTotal();
    List<Sort> querySortPage(Integer startRows);
    List<Sort> querySort();
    Integer deletesort(@Param("sort_id") Integer sort_id);
}
