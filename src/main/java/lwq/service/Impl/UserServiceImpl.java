package lwq.service.Impl;

import lwq.mapper.UserMapper;
import lwq.pojo.User;
import lwq.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User login(String username, String userpwd) {

        User user = mapper.login(username, userpwd);
        if (user != null && user.getUserpwd().equals(userpwd) && user.getUsername().equals(username)) {
            user.setUserpwd(null);
            user.setUsername(null);
            return user;
        }else {
            return null;
        }
    }

    @Override
    public User register(String username, String userpwd, Integer role_id, String nickname,String phone, String email, String motto) {
        User user = mapper.register( username, userpwd, 2, nickname,phone,email,motto);
        return user;
    }

    @Override
    public Integer update(Integer id,String nickname,String phone,String email,String motto) {
        return mapper.update(id,nickname,phone,email,motto);
    }

    @Override
    public Map<String, Object> findAll(Integer role_id) {

        List<User> userList = mapper.findAll(role_id);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", userList);
        return resultMap;
    }

    @Override
    public  List<User> queryUserPage(Integer role_id,Integer startRows) {
        return mapper.queryUserPage(role_id,startRows);
    }


    @Override
    public boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        if (mapper.deleteById(id)) {
            return true;
        }
        return false;
    }
    @Override
    public Integer updatepwd(Integer id,String userpwd,String nickname) {

        return mapper.updatepwd(id,userpwd,nickname);
    }

    @Override
    public User findById(Integer id) {
        User user = mapper.findById(id);
        return user;
    }

    @Override
    public List<User> findvague(String nickname,Integer startRows) {

        return mapper.findvague(nickname,startRows);
    }
    @Override
    public Integer findTotal() {
        return mapper.findTotal();
    }
//    @Override
//    public List<User> findvague(HashMap<String,Object>) {
//        return mapper.findvague(nickname,startRows);
//    }
}
