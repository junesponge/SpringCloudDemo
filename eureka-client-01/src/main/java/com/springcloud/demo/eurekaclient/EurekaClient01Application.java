package com.springcloud.demo.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClient01Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient01Application.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/say")
	public String say(@RequestParam String word) {
		return "I say '" + word + "' from port:" + port;
	}

	@RequestMapping("/request")
	public String request(@RequestParam String param) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		System.out.println("URI: " + request.getRequestURI());
		System.out.println("Param: " + param);
		return "Request from Port: " + request.getRemotePort();
	}
}
