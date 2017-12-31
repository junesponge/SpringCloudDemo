package com.springcloud.demo.eurekaclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClient02Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient02Application.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/say")
	public String say(@RequestParam String word) {
		return "I say '" + word + "' from port:" + port;
	}

	@RequestMapping("/callClient01")
	public String callClient01(@RequestParam String word) throws IOException {
		HttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = httpClient.execute(new HttpGet("http://localhost:8762/request?param=" + word));
		// 获取返回消息
		BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer sb = new StringBuffer("");
		String line = "";
		String NL = System.getProperty("line.separator");
		while ((line = in.readLine()) != null) {
			sb.append(line + NL);
		}
		in.close();
		return sb.toString();
	}
}
