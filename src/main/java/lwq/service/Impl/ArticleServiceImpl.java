package lwq.service.Impl;

import lwq.mapper.ArticleMapper;

import lwq.pojo.Article;
import lwq.pojo.Comment;
import lwq.pojo.User;
import lwq.service.ArticleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper mapper;
    @Override
    public Integer addarticle(String article_title, String article_conent, String release_time, Integer id,String article_img,Integer sort_id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        release_time = df.format(new Date());

        return mapper.addarticle(article_title,article_conent,release_time,id,article_img,sort_id);
    }
    @Override
    public Integer deleteart(Integer article_id) {
        if (mapper.deleteart(article_id)>0) {
            return mapper.deleteart(article_id);
        }
        return 0;
    }
    @Override
    public Integer updateart(String article_title, String article_content,Integer article_id,String article_img,Integer sort_id) {
        if(mapper.updateart(article_title,article_content,article_id,article_img,sort_id)>0) {
            return mapper.updateart(article_title,article_content,article_id,article_img,sort_id);
        }
        return 0;
    }
    @Override
    public List<Comment> findcomment(Integer article_id) {
        if(mapper.findcomment(article_id)!=null) {
            return mapper.findcomment(article_id);
        }else {
            return null;
        }
    }

    @Override
    public  List<Article> queryArticlePage(Integer startRows) {
        return mapper.queryArticlePage(startRows);
    }
    @Override
    public  List<Article> queryArticlePage1(Integer startRows) {
        return mapper.queryArticlePage1(startRows);
    }
    @Override
    public  List<Article> findmine(Integer id,Integer startRows) {
        return mapper.findmine(id,startRows);
    }
    @Override
    public Article lookarticle(Integer article_id) {
        if(mapper.lookarticle(article_id)!=null) {
            return mapper.lookarticle(article_id);
        }else {
            return null;
        }
    }
    @Override
    public Integer setsort(Integer article_id, Integer sort_id) {
            return mapper.setsort(article_id,sort_id);
    }

    @Override
    public Article lookitemByid(Integer article_id) {
        if(mapper.lookitemByid(article_id)!=null) {
            return mapper.lookitemByid(article_id);
        }else {
            return null;
        }
    }
    @Override
    public List<Article> lookBysort(Integer sort_id,Integer startRows) {
        if(mapper.lookBysort(sort_id,startRows)!=null) {
            return mapper.lookBysort(sort_id,startRows);
        }
            return null;
    }
    @Override
    public List<Article> findblog(String article_title,Integer startRows) {
        return mapper.findblog(article_title,startRows);
    }
    @Override
    public List<Article> findblog1(String article_title) {
        return mapper.findblog1(article_title);
    }
    @Override
    public Integer findblognum1(String article_title) {
        return mapper.findblognum1(article_title);
    }
    @Override
    public Integer findTotal() {
        return mapper.findTotal();
    }

    @Override
    public List<Article> findbysort(String sort_name,Integer startRows) {
        return mapper.findbysort(sort_name,startRows);
    }
    @Override
    public Integer findbysortnum(String sort_name) {
        return mapper.findbysortnum(sort_name);
    }
}
