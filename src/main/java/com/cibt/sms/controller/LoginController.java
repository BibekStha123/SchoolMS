/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.SiteController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends SiteController {

    @GetMapping()
    public String index() {
        return "login/index";
    }
    
    @GetMapping("/logout")
    public String logout(HttpServletRequest req)throws ServletException{
        req.logout();
        req.getSession().invalidate();
        return "redirect:/login";
    }
}
