package com.Security.PraticeSecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.PraticeSecurity.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
