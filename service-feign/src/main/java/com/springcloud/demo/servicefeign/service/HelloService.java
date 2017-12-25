package com.springcloud.demo.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-CLIENT")
public interface HelloService {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    String sayViaFeignClient(@RequestParam(name = "word") String word);

}
