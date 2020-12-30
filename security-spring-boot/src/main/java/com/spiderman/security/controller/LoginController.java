package com.spiderman.security.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 总体说明
 * <p>具体说明</p>
 *
 * @author SpiderMan
 * @version 1.0.0.: com.spiderman.security.controller.LoginController,v 0.1 12/28/20 8:59 PM Exp $$
 */
@RestController
public class LoginController {

    /**
     * 登录成功
     */
    @RequestMapping(value = "/loginSuccess",produces = { MediaType.TEXT_PLAIN_VALUE})
    public String success() {

        return getUsername()+"登录成功";
    }

    /**
     * 测试资源1 * @return
     */
    @GetMapping(value = "/r/r1")
    public String r1() {

        return " 访问资源1";
    }

    /**
     * 测试资源2 * @return
     */
    @GetMapping(value = "/r/r2")
    public String r2() {
        return " 访问资源2";
    }

    /**
     * 获取当前登录用户名 * @return
     */
    private String getUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.isAuthenticated()){
            return null;
        }
        Object principal = authentication.getPrincipal();
        String username;
        if (principal instanceof org.springframework.security.core.userdetails.UserDetails) {
            username =
                    ((org.springframework.security.core.userdetails.UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}
