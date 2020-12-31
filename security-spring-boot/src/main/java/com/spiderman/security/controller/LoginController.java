package com.spiderman.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.vote.AuthenticatedVoter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @RequestMapping("/login/invalid")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String invalid() {
        return "Session 已过期，请重新登录";
    }
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

        return getUsername()+" 访问资源1";
    }

    /**
     * 测试资源2 * @return
     */
    @GetMapping(value = "/r/r2")
    public String r2() {
        return getUsername()+" 访问资源2";
    }

    /**
     * 测试资源3 * @return
     */
    @GetMapping(value = "/r/r3")
    public String r3() {
        return getUsername()+" 访问资源3";
    }


    /**
     * 测试资源3 * @return
     * 增加方法授权注解，@PreAuthorize
     */
    @GetMapping(value = "/r/r4")
//    @Secured(AuthenticatedVoter.IS_AUTHENTICATED_FULLY)
    @PreAuthorize("hasAuthority('p4')")
    public String r4() {
        return " 方法授权测试";
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
