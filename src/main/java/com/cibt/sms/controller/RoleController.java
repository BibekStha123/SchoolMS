/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.Role;
import com.cibt.sms.core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/roles")
public class RoleController extends CrudController<Role>{
    
    public RoleController(){
        this.activeMenu="master";
        this.titleValue="Role";
        this.redirectURI="roles";
        this.viewPath="roles";
    }
}

