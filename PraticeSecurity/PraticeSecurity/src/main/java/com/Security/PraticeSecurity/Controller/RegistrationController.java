package com.Security.PraticeSecurity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.PraticeSecurity.Entity.User;
import com.Security.PraticeSecurity.Event.RegistrationCompleteEvent;
import com.Security.PraticeSecurity.Model.UserModel;
import com.Security.PraticeSecurity.Service.UserServiceImp;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/")
public class RegistrationController {

    @Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public User register(@RequestBody UserModel usermodel,final HttpServletRequest request)
    {
          User user = userServiceImp.register(usermodel);
           publisher.publishEvent(new RegistrationCompleteEvent(user,createUrl(request) ));

          return user;
    }

    private String createUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":/"+request.getServerPort()+request.getContextPath();
    }

    


    
}
