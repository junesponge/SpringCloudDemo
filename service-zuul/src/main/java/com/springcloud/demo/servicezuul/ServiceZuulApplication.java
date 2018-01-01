package com.springcloud.demo.servicezuul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.env.Environment;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
	}

	@Autowired
	void setEnviroment(Environment env) {
		System.out.println("service-zuul from env: " + env.getProperty("service-zuul.appName"));
	}
}
