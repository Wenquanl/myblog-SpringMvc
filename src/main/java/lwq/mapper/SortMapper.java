package lwq.mapper;


import lwq.pojo.Sort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SortMapper {
    //新增分类
    Integer addsort(@Param("sort_name") String sort_name);
    //修改分类
    Integer updatesort(@Param("sort_name") String sort_name,
                       @Param("sort_id") Integer sort_id);
    //查总数
    Integer findTotal();
    //分类列表（分页）
    List<Sort> querySortPage(Integer startRows);
    //列表
    List<Sort> querySort();
    //删除分类
    Integer deletesort(@Param("sort_id") Integer sort_id);

}
