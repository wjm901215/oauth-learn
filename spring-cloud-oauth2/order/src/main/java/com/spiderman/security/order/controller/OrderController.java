package com.spiderman.security.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.security.order.controller.OrderController,v 0.1 2020-09-04 17:45 Exp $$
 */
@RestController
public class OrderController {

    @GetMapping(value = "/r1")
//    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1() {
        return "访问资源1";
    }
}
