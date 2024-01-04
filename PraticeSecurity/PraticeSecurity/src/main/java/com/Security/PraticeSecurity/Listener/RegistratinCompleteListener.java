package com.Security.PraticeSecurity.Listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.Security.PraticeSecurity.Entity.User;
import com.Security.PraticeSecurity.Event.RegistrationCompleteEvent;
import com.Security.PraticeSecurity.Service.UserServiceImp;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistratinCompleteListener implements ApplicationListener<RegistrationCompleteEvent>{

    @Autowired
    private UserServiceImp userServiceImp;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {

        //creating the token
        User user=event.getUser();
        String token=UUID.randomUUID().toString();
        userServiceImp.saveToken(user,token);

        //send the token to Mail

        String url=event.getApplicationUrl()+"verification =="+token;
        //send the mail
        log.info("click to verify" ,url);
       
    }
    
}
