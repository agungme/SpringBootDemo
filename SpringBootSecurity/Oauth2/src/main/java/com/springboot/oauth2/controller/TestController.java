package com.springboot.oauth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/all")
    public String allAccess() {
        return "Public access...";
    }

    @GetMapping("/user")
    public String userAccess(@AuthenticationPrincipal OAuth2User principal){
        //return principal.toString();
        return "Welcome <b>"+principal.getAttribute("name")+"</b>. User access here...";
    }


}
