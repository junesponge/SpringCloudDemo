package com.springcloud.demo.servicefeign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "EUREKA-CLIENT", fallback = HelloServiceHystrix.class)
public interface HelloService {

    // Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果
    @RequestMapping(value = "/say", method = RequestMethod.GET)
    String sayViaFeignClient(@RequestParam(name = "word") String word);

}
