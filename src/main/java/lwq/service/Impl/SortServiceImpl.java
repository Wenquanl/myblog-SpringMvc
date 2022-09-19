package lwq.service.Impl;

import lwq.mapper.SortMapper;
import lwq.pojo.Sort;
import lwq.service.SortService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {
    @Autowired
    private SortMapper mapper;
    @Override
    public Integer addsort(String sort_name) {
        return mapper.addsort(sort_name);
    }

    @Override
    public Integer updatesort(String sort_name, Integer sort_id) {
        if(mapper.updatesort(sort_name,sort_id)>0) {
            return mapper.updatesort(sort_name,sort_id);
        }
        return 0;
    }
    @Override
    public Integer findTotal() {
        return mapper.findTotal();
    }

    @Override
    public List<Sort> querySortPage(Integer startRows) {
        return mapper.querySortPage(startRows);
    }
    @Override
    public List<Sort> querySort() {
        return mapper.querySort();
    }
    @Override
    public Integer deletesort(Integer sort_id) {
        if(mapper.deletesort(sort_id)>0) {
            return mapper.deletesort(sort_id);
        }
        return 0;
    }
}
