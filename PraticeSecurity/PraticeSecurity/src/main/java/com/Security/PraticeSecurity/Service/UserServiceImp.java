package com.Security.PraticeSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Security.PraticeSecurity.Entity.Token;
import com.Security.PraticeSecurity.Entity.User;
import com.Security.PraticeSecurity.Event.TokenRepository;
import com.Security.PraticeSecurity.Model.UserModel;
import com.Security.PraticeSecurity.Repository.UserRepository;

@Service
public class UserServiceImp {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private TokenRepository tokenRepository;

    @Autowired
    private UserRepository userRepository;

  
    public User register(UserModel userModel) {
        User user = new User();
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
         user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(user);
        return user;
    }


    public void saveToken(User user, String token) {

        Token tokens= new Token(token,user);
        tokenRepository.save(tokens);

    }
}
    

