package lwq.service;

import lwq.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserService {

    User login(String username, String userpwd);
    User register(String username,
                  String userpwd,
                  Integer role_id,
                  String nickname,
                  String phone,
                  String email,
                  String motto);

     Map<String,Object> findAll(Integer role_id);
    List<User> queryUserPage(Integer role_id,Integer startRows);
    public boolean deleteById(Integer id);
    Integer updatepwd(Integer id, String userpwd, String nickname);
    Integer update(Integer id,String nickname,String phone,String email,String motto);

    User findById(Integer id);
    List<User> findvague(String nickname,Integer startRows);
    Integer findTotal();
}
