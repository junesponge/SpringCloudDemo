package com.springcloud.demo.serviceribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String say(String word) {
        return restTemplate.getForObject("http://EUREKA-CLIENT/say?word=" + word, String.class);
    }
}
