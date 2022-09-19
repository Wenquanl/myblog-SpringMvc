package lwq.service;

import lwq.pojo.Article;
import lwq.pojo.Comment;
import lwq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    public Integer addarticle(String article_title,
                              String article_content,
                              String release_time,
                              Integer id,
                              String article_img,
                              Integer sort_id);
    Integer deleteart(Integer article_id);
    Integer updateart(String article_title,
                      String article_content,
                      Integer article_id,
                      String article_img,
                      Integer sort_id);
    List<Comment> findcomment(Integer article_id);
    List<Article> queryArticlePage(Integer startRows);
    List<Article> queryArticlePage1(Integer startRows);
    List<Article> findmine(Integer id,Integer startRows);
    Article lookarticle(Integer article_id);
    Integer setsort(Integer article_id,
                    Integer sort_id);
    Article lookitemByid(Integer article_id);
    List<Article> lookBysort(Integer sort_id,Integer startRows);
    List<Article> findblog(String article_title,Integer startRows);
    List<Article> findblog1(String article_title);
    Integer findblognum1(String article_title);
    Integer findTotal();
    List<Article> findbysort(String sort_name,Integer startRows);
    Integer findbysortnum(String sort_name);
}
