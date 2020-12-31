package com.spiderman.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 启用方法授权
 *  <p>@PreAuthorize,@PostAuthorize, @Secured三类注解</p>
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.security.config.MethodSecurityConfig,v 0.1 12/31/20 11:49 AM Exp $$
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class MethodSecurityConfig {
}
