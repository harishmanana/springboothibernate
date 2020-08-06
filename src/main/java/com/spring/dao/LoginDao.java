package com.spring.dao;

import java.util.List;

import com.spring.model.Login;
 
public interface LoginDao {
 
    void saveLogin(Login loginDetails);
     
    List<Login> findAllLogins();
     
    void deleteLoginByUsername(String usernamee);
     
    Login findByUsername(String username);
     
    void updateLogin(Login loginDetails);
}