package lwq.controller;

import lwq.common.Result;
import lwq.pojo.User;
import lwq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static lwq.common.ResultCode.ERROR;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "login")
    @ResponseBody
    @CrossOrigin
    public Result loginUser(User user)  {
        // 调用service方法,这一步必须要有
        user = service.login(user.getUsername(), user.getUserpwd());
        if (user != null) {
            return Result.success(user);
        }
        return Result.error(ERROR);
    }

    @RequestMapping(value = "register")
    @ResponseBody
    @CrossOrigin
    public Result register (User user) {
            service.register(user.getUsername(),user.getUserpwd(),user.getRole_id(),user.getNickname(),user.getPhone(),user.getEmail(),user.getMotto());
            user.setId(user.getId());
            return Result.success(user);
    }

    @RequestMapping(value = "list")
    @ResponseBody
    @CrossOrigin
    public Result alllist (Integer role_id)  {
        Map<String, Object> resultMap = service.findAll(role_id);

        return Result.success(resultMap);

    }

    @RequestMapping(value = "listpage")
    @ResponseBody
    @CrossOrigin
    public Result queryUserPage(Integer role_id,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 10;
        int startRows = pageSize*(pageNow-1);
        return Result.success(service.queryUserPage(role_id,startRows));
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    @CrossOrigin
    public Result deleteById (Integer id) {

        if(service.deleteById(id)){
            return Result.success();
        }
            return Result.error(ERROR);

    }
    //用户密码修改
    @RequestMapping(value = "updatepwd")
    @ResponseBody
    @CrossOrigin
    public Result updatePwd(Integer id,String userpwd,String nickname) {
        if(service.updatepwd(id,userpwd,nickname)>0){
            return Result.success();
        }
            return Result.error(ERROR);

    }
    //用户资料修改
    @RequestMapping(value = "update")
    @ResponseBody
    @CrossOrigin
    public Result Update(Integer id,String nickname, String phone,String email,String motto) {
        if(service.update(id,nickname,phone,email,motto)>0){
            return Result.success();
        }
        return Result.error(ERROR);
    }



    @RequestMapping(value = "finduser")
    @ResponseBody
    @CrossOrigin
    public Result finduser (User user) {
        user = service.findById(user.getId());
        if (user != null){
            user.setUsername(null);
            user.setUserpwd(null);
            return Result.success(user);
        }
            return Result.error(ERROR);

    }

    @RequestMapping(value = "findvague")
    @ResponseBody
    @CrossOrigin
    public Result findVague (String nickname,Integer page) {
        int pageNow = page == null ? 1 : page;
        int pageSize = 5;
        int startRows = pageSize*(pageNow-1);
        return  Result.success(service.findvague(nickname,startRows));
    }

    @RequestMapping(value = "count")
    @ResponseBody
    @CrossOrigin
    public Result findTotal() {
        return Result.success(service.findTotal());
    }
}
