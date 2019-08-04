/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.Guardian;
import com.cibt.sms.core.CrudController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/guardians")
public class GuardianController extends CrudController<Guardian>{
    
    @Autowired
    private MailSender mailSender;
    
    public GuardianController(){
        this.activeMenu="master";
        this.titleValue="Guardian";
        this.redirectURI="guardians";
        this.viewPath="guardians";
    }
}

