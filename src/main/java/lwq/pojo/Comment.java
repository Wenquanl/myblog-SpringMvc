package lwq.pojo;

public class Comment {
    Integer  comment_id;
    String   comment_con;
    String   comment_time;
    Integer  id;
    Integer  article_id;
    String   article_title;
    String   nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getComment_con() {
        return comment_con;
    }

    public void setComment_con(String comment_con) {
        this.comment_con = comment_con;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "comment{" +
                "comment_id=" + comment_id +
                ", comment_con='" + comment_con + '\'' +
                ", comment_time='" + comment_time + '\'' +
                ", id=" + id +
                ", article_id=" + article_id +
                '}';
    }
}
