/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.EnquirySource;
import com.cibt.sms.core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/enquirysource")
public class EnquirySourceController extends CrudController<EnquirySource>{
    
    public EnquirySourceController(){
        this.activeMenu="master";
        this.titleValue="EnquirySource";
        this.redirectURI="enquirysource";
        this.viewPath="enquirysource";
    }
}

