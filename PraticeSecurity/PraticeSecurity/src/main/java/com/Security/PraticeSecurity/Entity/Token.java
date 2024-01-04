package com.Security.PraticeSecurity.Entity;

import java.util.Calendar;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Token {

    private static final int time=10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expirationTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "USER_TOKEN"))
    private User user;

    public Token(String token,User user)
    {
        super();
        this.token=token;
        this.user=user;
        this.expirationTime=calculateTime(time);
    }
     public Token(String token)
    {
        super();
        this.token=token;
        this.expirationTime=calculateTime(time);
    }

    private Date calculateTime(int time2) {

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,time2);
        return new Date(calendar.getTime().getTime());
    }

}