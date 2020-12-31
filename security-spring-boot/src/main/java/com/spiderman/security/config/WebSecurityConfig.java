package com.spiderman.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全配置
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置用户信息服务
     */
    /*@Override
    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password(encoder.encode("123")).authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password(encoder.encode("456")).authorities("p2").build());

        return manager;
    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /*
                规则的顺序是重要的,更具体的规则应该先写
                保护URL常用的方法有:
                    authenticated() 保护URL，需要用户登录
                    permitAll() 指定URL无需保护，一般应用与静态资源文件
                    hasRole(String role) 限制单个角色访问，角色将被增加 “ROLE_” .所以”ADMIN” 将和 “ROLE_ADMIN”进行比较. hasAuthority(String authority) 限制单个权限访问
                    hasAnyRole(String... roles)允许多个角色访问.
                    hasAnyAuthority(String... authorities) 允许多个权限访问.
                    access(String attribute) 该方法使用 SpEL表达式, 所以可以创建复杂的限制.
                    hasIpAddress(String ipaddressExpression) 限制IP地址或子网
                 */
                //访问/r/r1资源的 url需要拥有p1权限。
                .antMatchers("/r/r1").hasAuthority("p1")
                //访问/r/r2资源的 url需要拥有p2权限。
                .antMatchers("/r/r2").hasAuthority("p2")
                //同时拥有p1/p2权限才可以访问/r/r3资源
                .antMatchers("/r/r3").access("hasAuthority('p1') and hasAuthority('p2')")
                .antMatchers("/r/**").authenticated()
                .anyRequest().permitAll();
        //增加自定义登录
        http.formLogin()
                //指定我们自己的登录页,spring security以重定向方式跳转到/login-view
                .loginPage("/loginView")
                //指定登录处理的URL，也就是用户名、密码表单提交的目的路径
                .loginProcessingUrl("/login")
                .successForwardUrl("/loginSuccess");
        //会话控制
        http.sessionManagement()
                //超时调用 login/invalid
                .invalidSessionUrl("/login/invalid")
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        //增加自定义退出
        http
                .logout()
                .logoutUrl("/logout").logoutSuccessUrl("/loginView?logout");

        // 关闭CSRF跨域
        http.csrf().disable();

    }
}