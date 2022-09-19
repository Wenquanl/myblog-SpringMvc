package lwq.mapper;

import lwq.pojo.Article;
import lwq.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    //添加评论（输入博文id和用户id）
    Integer addcomment(@Param("comment_con") String comment_con,
                       @Param("comment_time") String comment_time,
                       @Param("id") Integer id,
                       @Param("article_id") Integer article_id);
    //删除评论
    Integer deletecom(@Param("comment_id") Integer comment_id);
    //个人所有评论列表
    List<Comment> findcomById(@Param("id") Integer id);
    //修改评论
    Integer updatecom(@Param("comment_con") String comment_con,
                      @Param("comment_id") Integer comment_id);
    //总数
    Integer findTotal();
    //分页查询所有评论
    List<Comment> queryCommentPage(Integer startRows);
    //模糊查询（分页）
    List<Comment> querycom(@Param("comment_con") String comment_con,@Param("startRows") Integer startRows);
}
