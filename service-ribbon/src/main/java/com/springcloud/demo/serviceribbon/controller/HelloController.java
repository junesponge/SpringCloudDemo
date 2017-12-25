package com.springcloud.demo.serviceribbon.controller;

import com.springcloud.demo.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/sayViaRibbonClient")
    public String sayViaRibbonClient(@RequestParam String word) {
        return helloService.sayViaRibbonClient(word);
    }

}
