package com.springcloud.demo.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements HelloService {

    @Override
    public String sayViaFeignClient(String word) {
        return "An error has been hit on Feign client, request parameter: " + word;
    }
}
