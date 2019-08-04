/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.User;
import com.cibt.sms.core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/users")
public class UserController extends CrudController<User>{
    
    public UserController(){
        this.activeMenu="master";
        this.titleValue="User";
        this.redirectURI="users";
        this.viewPath="users";
    }
}

