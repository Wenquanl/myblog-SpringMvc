package lwq.mapper;

import lwq.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserMapper {
    //登录
    User login(@Param("username")String username, @Param("userpwd") String userpwd);
    //注册
    User register(
                  @Param("username") String username,
                  @Param("userpwd") String userpwd,
                  @Param("role_id") Integer role_id,
                  @Param("nickname") String nickname,
                  @Param("phone") String phone,
                  @Param("email") String email,
                  @Param("motto") String motto);
    //不分页查询所有用户
    List<User> findAll(@Param("role_id") Integer role_id);
    //分页查询所有用户
    List<User> queryUserPage(@Param("role_id") Integer role_id,@Param("startRows") Integer startRows);
    //删除用户
    boolean deleteById(Integer id);
    //更新用户密码
    Integer updatepwd(@Param("id") Integer id,@Param("userpwd") String userpwd,@Param("nickname") String nickname);
    //更新用户信息
    Integer update(@Param("id") Integer id,@Param("nickname") String nickname,@Param("phone") String phone,@Param("email") String email,@Param("motto") String motto);
    //根据id找用户（非分页）
    User findById(@Param("id") Integer id);
    //根据用户名找用户(分页)
    List<User> findvague(@Param("nickname") String nickname,@Param("startRows") Integer startRows);
    //总数
    Integer findTotal();

}
