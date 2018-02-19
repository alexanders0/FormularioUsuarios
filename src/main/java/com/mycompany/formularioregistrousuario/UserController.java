/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.formularioregistrousuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author alexanders0
 */

@Controller
public class UserController {
    
    User user;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/")
    public ModelAndView index() {
    	Iterable<User> listUsers = userService.getUserList(); //list of users
        return new ModelAndView("manage_users").addObject("users", listUsers);
    }
    
    @RequestMapping("/manage_users")
    public ModelAndView manageUsers() {
    	Iterable<User> listUsers = userService.getUserList(); //list of users
        return new ModelAndView("manage_users").addObject("users", listUsers);
    }
    
    @RequestMapping("/new_user")
    public ModelAndView newUser() {
        return new ModelAndView("new_user");
    }
    
    @RequestMapping(value = "/insert_user", method = { RequestMethod.GET, RequestMethod.POST })
    public String insertUser(@RequestParam String firstName, 
    		@RequestParam String lastName, 
                @RequestParam String username,
                @RequestParam String password,
    		@RequestParam Integer identityCard,
                @RequestParam String birthdate,
                @RequestParam String birthplace,
                @RequestParam String email,
                @RequestParam Integer phone,
                @RequestParam String address
    		) {
    	
    	userService.createUser(firstName, lastName, username, password, identityCard, birthdate, birthplace, email, phone, address);
    	
    	return "redirect:/manage_users";
    }
    
    @RequestMapping("/get_user")
    public ModelAndView getUser(@RequestParam Integer identityCard) {
        
        user = userService.getUser(identityCard);
        return new ModelAndView("get_user").addObject("user", user);
        
    }
}
