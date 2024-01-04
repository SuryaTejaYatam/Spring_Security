package com.Security.PraticeSecurity.Event;

import org.springframework.context.ApplicationEvent;

import com.Security.PraticeSecurity.Entity.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.applicationUrl = applicationUrl;
        this.user = user;

    }

}
