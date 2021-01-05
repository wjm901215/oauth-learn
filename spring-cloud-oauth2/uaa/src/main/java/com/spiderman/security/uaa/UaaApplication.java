package com.spiderman.security.uaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 *
 * @author SpiderMan
 * @version 1.0.0: com.spiderman.security.uaa.UaaApplication,v 0.1 2020-09-04 11:16 Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients(basePackages = {"com.spiderman.security.uaa"})
public class UaaApplication  {

    public static void main(String[] args) {
        SpringApplication.run(UaaApplication.class, args);
    }
}


