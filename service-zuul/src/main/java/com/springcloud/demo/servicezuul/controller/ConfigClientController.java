package com.springcloud.demo.servicezuul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${appName}")
    private String appName;

    @RequestMapping("/appName")
    public String getAppName() {
        return appName;
    }
}
