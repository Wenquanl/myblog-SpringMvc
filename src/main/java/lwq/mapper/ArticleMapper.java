package lwq.mapper;

import lwq.pojo.Article;
import lwq.pojo.Comment;
import lwq.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
        //发布文章
        Integer addarticle(@Param("article_title") String article_title,
                           @Param("article_content")String article_content,
                           @Param("release_time") String release_time,
                           @Param("id") Integer id,
                           @Param("article_img") String article_img,
                           @Param("sort_id") Integer sort_id);
        //删除文章
        Integer deleteart(@Param("article_id") Integer article_id);
        //修改文章
        Integer updateart(@Param("article_title") String article_title,
                          @Param("article_content")String article_content,
                          @Param("article_id") Integer article_id,
                          @Param("article_img") String article_img,
                          @Param("sort_id") Integer sort_id);
        //根据文章id查评论
        List<Comment> findcomment(@Param("article_id") Integer article_id);
        //分页查询所有文章
        List<Article> queryArticlePage(Integer startRows);
        List<Article> queryArticlePage1(Integer startRows);
        //分页查自己的文章
        List<Article> findmine(@Param("id") Integer id,@Param("startRows") Integer startRows);
        //查看文章页面
        Article lookarticle(@Param("article_id") Integer article_id);
        //设置文章分类
        Integer setsort(@Param("article_id") Integer article_id,
                        @Param("sort_id") Integer sort_id);
        //根据博文id查询属于什么分类，返回博文详情
        Article lookitemByid(@Param("article_id") Integer article_id);
        //根据分类id查询博文列表
        List<Article> lookBysort(@Param("sort_id") Integer sort_id,@Param("startRows") Integer startRows);
        //博文搜索（模糊+分页）
        List<Article> findblog(@Param("article_title") String article_title,@Param("startRows") Integer startRows);
        //博文搜索（模糊）
        List<Article> findblog1(@Param("article_title") String article_title);
        //博文搜索（模糊）数量
        Integer findblognum1(@Param("article_title") String article_title);
        //查询总数
        Integer findTotal();
        //标签名查文章
        List<Article> findbysort(@Param("sort_name") String sort_name,@Param("startRows") Integer startRows);
        //标签名查文章数
        Integer findbysortnum(@Param("sort_name") String sort_name);
}
