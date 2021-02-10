package com.example.wj.controller;

import com.example.wj.pojo.User;
import com.example.wj.result.Result;
import com.example.wj.service.UserService;
import com.example.wj.result.ResultFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser, HttpSession session){
        //对html 标签进行转义，防止  XSS  攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,requestUser.getPassword());
        usernamePasswordToken.setRememberMe(true);
//        User user = userService.get(username,requestUser.getPassword());

        try{
            subject.login(usernamePasswordToken);
            System.out.println("登录controller这里"+subject.getPrincipals());
            return ResultFactory.buildSuccessResult(username);
        }catch (AuthenticationException e){
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
        /***
        if (null == user){
            return new Result(ResultCode.Failure.getCode(), "test", user);
        }else{
            session.setAttribute("user", user);
            return new Result(200, "test", user);
        }***/

    }
    
    @PostMapping("api/register")
    @ResponseBody
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);
        user.setUsername(username);

        boolean exist = userService.isExist(username);
        if(exist){
            String message = "名字已被使用";
            return ResultFactory.buildFailResult(message);
        }

        //生成盐，默认长度16位
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        //设置hash 算法迭代次数
        int times = 2;
        //得到hash 后的密码
        String encodedPassword = new SimpleHash("md5",password,salt,times).toString();
        //存储用户信息，包括 salt 与 hash 后的密码
        user.setSalt(salt);
        user.setPassword(encodedPassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @ResponseBody
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }

    @ResponseBody
    @GetMapping(value = "api/authentication")
    public String authentication(){
        return "身份认证成功";
    }


}
