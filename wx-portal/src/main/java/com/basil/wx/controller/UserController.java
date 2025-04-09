package com.basil.wx.controller;

import com.basil.wx.pojo.Users;
import com.basil.wx.service.IuserService;
import com.basil.wx.utils.OpenIDUtil;
import com.basil.wx.utils.Result;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IuserService userService;

    @RequestMapping("/login")
    public Result login(@RequestBody String code, HttpSession session) {
        String openId = OpenIDUtil.getOpenID(code);
        //0e3QxY000rQFXT1FGE100QhZ4Q2QxY0l (临时的可变的，存活时间到了或是解析一次就会消失)
        //System.out.println("code: " + code);
        //oqx396_Vzss3UE1P-Xp_VKlTSu4E (每个用户是固定的)
        //System.out.println("openId: " + openId);
        //卫操作
        if (code == null) {
            return Result.error("登录失败");
        }
        if (openId == null) {
            return Result.error("用户信息错误");
        }
        //验证登录
        Users user = userService.login(openId);
        if (user != null && (user.getStatus() == 0 || user.getIsDeleted() == 0)) {
            session.setAttribute("user", user);
            return Result.ok("登录成功", user);
        } else if (user != null && (user.getStatus() == 1 || user.getIsDeleted() == 1)) {
            return new Result(4, "用户被禁用");
        } else {
            return new Result(3, "请先注册", openId);
        }
    }

    @RequestMapping("/register")
    public Result register(@RequestBody Users user, HttpSession session) {
        System.out.println("user: " + user);
        if (user.getOpenId() == null) {
            return Result.error("用户信息错误");
        }
        userService.register(user);
        session.setAttribute("user", user);
        return Result.ok("注册成功", user);
    }
}
