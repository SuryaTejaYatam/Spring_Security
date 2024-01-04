package com.Security.PraticeSecurity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.PraticeSecurity.Entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token,Long>{
    
}
