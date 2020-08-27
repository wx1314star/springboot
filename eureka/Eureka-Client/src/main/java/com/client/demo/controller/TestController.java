package com.client.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/info")
    public String info() {
        @SuppressWarnings("deprecation")
        ServiceInstance instance = client.getLocalServiceInstance();
        String info = "host: " + instance.getHost() + ",service_id: " + instance.getServiceId();
        return info;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
