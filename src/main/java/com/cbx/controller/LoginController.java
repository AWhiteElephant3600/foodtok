package com.cbx.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cbx.common.lang.Result;
import com.cbx.entity.User;
import com.cbx.service.UserService;
import com.cbx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author cbx
 * @date 2022/3/22
 * @apiNote
 */
@RestController
public class LoginController extends BaseController{

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Result login(@Validated @RequestBody  User user){
        User temp = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        Assert.notNull(temp, "用户不存在");

        if(!temp.getPassword().equals(MD5Utils.code(user.getPassword()))){
            return Result.fail(401,"密码不正确",null);
        }

        return Result.succ(MapUtil.builder()
                .put("username", user.getUsername())
                .map()
        );
    }

    @PostMapping("/register")
    public Result register(@Validated @RequestBody User user){
        User temp = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        Assert.isNull(temp, "该用户名已存在");

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(MD5Utils.code(user.getPassword()));
        newUser.setCreated(new Date());

        userService.save(newUser);

        return Result.succ("注册成功");
    }
}
