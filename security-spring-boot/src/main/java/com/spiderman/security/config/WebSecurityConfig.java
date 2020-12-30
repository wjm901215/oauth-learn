package com.spiderman.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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

    /**
     * 配置安全拦截机制
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //访问/r/r1资源的 url需要拥有p1权限。
                .antMatchers("/r/r1").hasAuthority("p1")
                //访问/r/r2资源的 url需要拥有p2权限。
                .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().successForwardUrl("/login‐success");

    }
}