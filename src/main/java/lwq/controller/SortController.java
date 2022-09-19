package lwq.controller;

import lwq.common.Result;
import lwq.pojo.Sort;
import lwq.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sort")
public class SortController {
    @Autowired
    private SortService service;
    @RequestMapping(value = "add")
    @ResponseBody
    @CrossOrigin
    public Result addSort(Sort sort) {
        service.addsort(sort.getSort_name());
        return Result.success();
    }


    @RequestMapping(value = "update")
    @ResponseBody
    @CrossOrigin
    public Result update (String sort_name,Integer sort_id) {
        service.updatesort(sort_name,sort_id);
        return Result.success();
    }

    @RequestMapping(value = "count")
    @ResponseBody
    @CrossOrigin
    public Result findTotal() {
        return Result.success(service.findTotal());
    }

    @RequestMapping(value = "query")
    @ResponseBody
    @CrossOrigin
    public Result querySortPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return Result.success(service.querySortPage(startRows));
    }

    @RequestMapping(value = "query1")
    @ResponseBody
    @CrossOrigin
    public Result querySort() {
        return Result.success(service.querySort());
    }


    @RequestMapping(value = "delete")
    @ResponseBody
    @CrossOrigin
    public Result deleteSort (Integer sort_id) {
        service.deletesort(sort_id);
        return Result.success();
    }
}
