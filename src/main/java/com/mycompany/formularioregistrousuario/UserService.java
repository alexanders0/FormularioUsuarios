/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formularioregistrousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alexanders0
 */

@Service
public class UserService {
    
    User user;
	
    @Autowired
    private UserRepository userRepository;
    
    public User getUser(Integer identityCard){
        return userRepository.findByIdentityCard(identityCard);	
    }
    
    public Iterable<User> getUserList(){
        return userRepository.findAll();
    }
    
    public void createUser(String firstName, 
            String lastName, String username, 
            String password, 
            Integer identityCard, 
            String birthdate, 
            String birthplace, 
            String email, 
            Integer phone, 
            String address){
        userRepository.save(new User(firstName, lastName, username, password, identityCard, birthdate, birthplace, email, phone, address));
    }
    
}
