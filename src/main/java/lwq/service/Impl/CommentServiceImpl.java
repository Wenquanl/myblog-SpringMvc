package lwq.service.Impl;


import lwq.mapper.CommentMapper;
import lwq.pojo.Comment;
import lwq.service.CommentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;
    @Override
    public  Integer addcomment(String comment_con, String comment_time, Integer id, Integer article_id) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        comment_time = df.format(new Date());
        return mapper.addcomment(comment_con,comment_time,id,article_id);
    }

    @Override
    public Integer deletecom(Integer comment_id) {
        if (mapper.deletecom(comment_id)>0) {
            return mapper.deletecom(comment_id);
        }
        return 0;
    }

    @Override
    public List<Comment> findcomById(Integer id) {
        if(mapper.findcomById(id)!=null) {
            return mapper.findcomById(id);
        }
        return null;
    }

    @Override
    public Integer updatecom(String comment_con, Integer comment_id) {
        if(mapper.updatecom(comment_con,comment_id)>0) {
            return mapper.updatecom(comment_con,comment_id);
        }
        return 0;
    }

    @Override
    public Integer findTotal() {
        return mapper.findTotal();
    }

    @Override
    public List<Comment> queryCommentPage(Integer startRows) {
        return mapper.queryCommentPage(startRows);
    }

    @Override
    public List<Comment> querycom(String comment_con,Integer startRows) {
        return mapper.querycom(comment_con,startRows);
    }
}

