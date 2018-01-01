package com.springcloud.demo.eurekaclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
public class EurekaClient01Application {

	@Value("${server.port}")
	String port;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

	@Autowired
	void setEnviroment(Environment env) {
		System.out.println("Eureka Client01 from env: " + env.getProperty("appName"));
	}

	@RequestMapping("/say")
	public String say(@RequestParam String word) {
		return "Client01 say '" + word + "' from port:" + port;
	}

	@RequestMapping("/request")
	public String request(@RequestParam String param) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("Param: " + param);
		return "Request from Port: " + request.getRemotePort();
	}
}
