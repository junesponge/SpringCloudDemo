package com.springcloud.demo.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hitError") // 指定断路器调用方法
    public String sayViaRibbonClient(String word) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/say?word=" + word, String.class);
    }

    public String hitError(String word) {
        return "An error has been hit on Ribbon client, request parameter: " + word;
    }
}
