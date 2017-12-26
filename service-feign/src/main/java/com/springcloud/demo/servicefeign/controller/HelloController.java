package com.springcloud.demo.servicefeign.controller;

import com.springcloud.demo.servicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/sayViaFeignClient", method = RequestMethod.GET)
    public String sayViaFeignClient(@RequestParam String word) {
        return helloService.sayViaFeignClient(word);
    }
}
