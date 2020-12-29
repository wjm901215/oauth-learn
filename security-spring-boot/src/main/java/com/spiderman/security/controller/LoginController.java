package com.spiderman.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}
