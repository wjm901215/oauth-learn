package com.spiderman.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义UserDetailService
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //登录账号 System.out.println("username="+username); //根据账号去数据库查询... //这里暂时使用静态数据
        String password="$2a$10$pApu4N5q.NFos50QBLuWjOCRgSe5v0fuXzHiIrMFRT4OfgshdatQa";
        UserDetails userDetails =
                User.withUsername(username).password(password).authorities("p1").build();
        return userDetails;
    }
}