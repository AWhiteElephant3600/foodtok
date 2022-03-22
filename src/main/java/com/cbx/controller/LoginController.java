package com.cbx.controller;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cbx.common.lang.Result;
import com.cbx.entity.User;
import com.cbx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

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
    public Result login(@Validated @RequestBody User user, HttpServletResponse response){
        User temp = userService.getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        Assert.notNull(temp, "用户不存在");

        if(!temp.getPassword().equals(user.getPassword())){
            return Result.fail("密码不正确");
        }


        return Result.succ(MapUtil.builder()
                .put("username", user.getUsername())
                .map()
        );
    }
}
