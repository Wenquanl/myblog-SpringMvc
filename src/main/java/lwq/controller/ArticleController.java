package lwq.controller;

import lwq.common.Result;
import lwq.pojo.Article;

import lwq.pojo.Comment;
import lwq.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static lwq.common.ResultCode.ERROR;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService service;
//添加文章
    @RequestMapping(value = "add")
    @ResponseBody
    @CrossOrigin
    public Result addArticle (Article article) {
        service.addarticle(article.getArticle_title(),article.getArticle_content(),article.getRelease_time(),article.getId(),article.getArticle_img(),article.getSort_id());
        return Result.success();
    }
    //删除文章
    @RequestMapping(value = "delete")
    @ResponseBody
    @CrossOrigin
    public Result deleteArt (Integer article_id) {
        service.deleteart(article_id);
        return Result.success();
    }
    //修改文章
    @RequestMapping(value = "update")
    @ResponseBody
    @CrossOrigin
    public Result updateArt (String article_title,String article_content,Integer article_id,String article_img,Integer sort_id) {
        service.updateart(article_title,article_content,article_id,article_img,sort_id);
        return Result.success();
    }


//根据博文id找评论，展示评论列表
    @RequestMapping(value = "findComment")
    @ResponseBody
    @CrossOrigin
    public Result findComment(Comment comment) {
        List<Comment> commentlist = service.findcomment(comment.getArticle_id());
        return Result.success(commentlist);
    }

//主页博客分页
    @RequestMapping(value = "page")
    @ResponseBody
    @CrossOrigin
    public Result queryArticlePage(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.queryArticlePage(startRows));
        data.setCount(service.findTotal());
        return data;
    }

    @RequestMapping(value = "page1")
    @ResponseBody
    @CrossOrigin

    public Result queryArticlePage1(Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.queryArticlePage1(startRows));
        data.setCount(service.findTotal());
        return data;
    }

//个人中心博客分页
    @RequestMapping(value = "minepage")
    @ResponseBody
    @CrossOrigin

    public Result findMine(Integer id,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data =Result.success(service.findmine(id,startRows));
//        data.setCount();
    return data;
    }
//查看博文
    @RequestMapping(value = "look")
    @ResponseBody
    @CrossOrigin

    public Result lookarticle(Integer article_id){
        Article article = service.lookarticle(article_id);
        return Result.success(article);
    }
    //设置分类
    @RequestMapping(value = "setsort")
    @ResponseBody
    @CrossOrigin
    public Result setSort(Integer article_id,Integer sort_id) {
        if(service.setsort(article_id,sort_id)>0) {
            return Result.success(service.setsort(article_id,sort_id));
        }
            return  Result.error(ERROR);

    }
    //查博文分类
    @RequestMapping(value = "itemsort")
    @ResponseBody
    @CrossOrigin

    public Result lookitemByid(Integer article_id) {
        Article article = service.lookitemByid(article_id);
        return Result.success(article);
    }
    //分类博文列表
    @RequestMapping(value = "listbysort")
    @ResponseBody
    @CrossOrigin
    public List<Article> lookBysort(Integer sort_id,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        return service.lookBysort(sort_id,startRows);
    }

    //模糊搜索(分页)
    @RequestMapping(value = "find")
    @ResponseBody
    @CrossOrigin
    public Result findBlog(String article_title,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.findblog(article_title,startRows));
            data.setCount(service.findblognum1(article_title));
            return data;

    }
    //模糊搜索(不分页)
    @RequestMapping(value = "findbynopage")
    @ResponseBody
    @CrossOrigin
    public Result findBlog(String article_title) {

        Result data = Result.success(service.findblog1(article_title));
            data.setCount(service.findblognum1(article_title));
            return data;
    }

    //总数
    @RequestMapping(value = "count")
    @ResponseBody
    @CrossOrigin
    public Result findTotal() {
        return Result.success(service.findTotal());
    }


    @RequestMapping(value = "sortpage")
    @ResponseBody
    @CrossOrigin
    public Result findBysort (String sort_name,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 8;
        int startRows = pageSize*(pageNow-1);
        Result data = Result.success(service.findbysort(sort_name,startRows));
        data.setCount(service.findbysortnum(sort_name));
        return data;
    }

}
