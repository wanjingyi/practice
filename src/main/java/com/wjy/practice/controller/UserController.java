package com.wjy.practice.controller;

import com.wjy.practice.domain.User;
import com.wjy.practice.resp.CommonResp;
import com.wjy.practice.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    //用户登录
    @GetMapping("/login")
    public CommonResp<User> login(User user) {
        CommonResp<User> commonResp = new CommonResp();
        if (!ObjectUtils.isEmpty(user)) {
            User one = userService.selectUserById(user.getId());
            commonResp.setData(one);
        }else {
            commonResp.setSuccess(false);
            commonResp.setMessage("用户不存在");
        }
        return commonResp;
    }

    //用户注册
    @GetMapping("/register")
    public CommonResp<User> register(User user) {
        CommonResp<User> commonResp = new CommonResp();
        if (!ObjectUtils.isEmpty(user)) {
            userService.insertUser(user);
            commonResp.setData(user);
        }else {
            commonResp.setSuccess(false);
            commonResp.setMessage("注册信息不能为空");
        }
        return commonResp;
    }
}
