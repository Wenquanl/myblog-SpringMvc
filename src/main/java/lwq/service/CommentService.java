package lwq.service;


import lwq.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {

    Integer addcomment(String comment_con,
                       String comment_time,
                       Integer id,
                       Integer article_id);
    Integer deletecom(Integer comment_id);
    List<Comment> findcomById(Integer id);
    Integer updatecom(String comment_con,
                      Integer comment_id);
    Integer findTotal();
    List<Comment> queryCommentPage(Integer startRows);
    List<Comment> querycom(String comment_con,Integer startRows);

}
