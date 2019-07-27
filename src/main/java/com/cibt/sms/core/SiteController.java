/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.core;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Bibek
 */
public abstract class SiteController {
    
    protected String titleValue, redirectURI, activeMenu; 
    
    @ModelAttribute("title")
    public String getTitleValue()
    {
        return titleValue;
    }
    
    @ModelAttribute("redirectURI")
    public String getRedirectURI()
    {
        return redirectURI;
    }
    
    @ModelAttribute("activeMenu")
    public String getActiveMenu(){
        return activeMenu;
    }
}
