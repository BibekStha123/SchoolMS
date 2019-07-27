/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.SiteController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/")
public class HomeController extends SiteController {
    
    public HomeController()
    {
        this.titleValue = "Dashboard";
        this.activeMenu= "dashboard";
    }
        
    
    @GetMapping()
    public String index()
    {
        return "index";
    }
            
}
