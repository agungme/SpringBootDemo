package com.springboot.tools.controller;

import com.springboot.tools.entity.User;
import com.springboot.tools.producer.JmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MsgController {

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value="/user")
    public User sendMessage(@RequestBody User user){
        jmsProducer.sendMessage(user);
        return user;
    }
}