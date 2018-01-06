package com.springcloud.demo.eurekaclient.controller;

import com.springcloud.demo.eurekaclient.bean.TblUser;
import com.springcloud.demo.eurekaclient.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RefreshScope
public class HelloController {

    @Value("${appName}")
    private String appName;

    @RequestMapping("/appName")
    public String driverClass() {
        return appName;
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/hello"}, method = RequestMethod.GET)
    public String say() {
        return "world.";
    }

    @RequestMapping(value = {"/findAll"}, method = RequestMethod.GET)
    public List<TblUser> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public TblUser addUser(@RequestParam("name") String name, @RequestParam("age") int age) {
        TblUser user = new TblUser();
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.GET)
    public TblUser addUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") int age) {
        TblUser user = new TblUser();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userRepository.save(user);
    }
}
