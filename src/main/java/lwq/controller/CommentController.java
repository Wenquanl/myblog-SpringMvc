package lwq.controller;

import lwq.common.Result;
import lwq.pojo.Comment;
import lwq.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @RequestMapping(value = "add")
    @ResponseBody
    @CrossOrigin
    public Result addComment (Comment comment) {
        service.addcomment(comment.getComment_con(),comment.getComment_time(),comment.getId(),comment.getArticle_id());
        return Result.success();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    @CrossOrigin
    public Result deleteCom (Integer comment_id) {
        service.deletecom(comment_id);
        return Result.success();
    }

    @RequestMapping(value = "findbyid")
    @ResponseBody
    @CrossOrigin

    public Result findComById (Integer id) {
        List<Comment> comListid = service.findcomById(id);
        return Result.success(comListid);
    }

    @RequestMapping(value = "update")
    @ResponseBody
    @CrossOrigin
    public Result updateCom(String comment_con,Integer comment_id) {
        service.updatecom(comment_con,comment_id);
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
    public Result queryCommentPage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.queryCommentPage(startRows));
        data.setCount(service.findTotal());
        return data;
    }

    @RequestMapping(value = "querycom")
    @ResponseBody
    @CrossOrigin
    public Result queryCom (String comment_con,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.querycom(comment_con,startRows));
        return data;
    }
}
