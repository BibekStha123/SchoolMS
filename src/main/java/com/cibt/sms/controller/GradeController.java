/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.Grade;
import com.cibt.sms.core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/grades")
public class GradeController extends CrudController<Grade>{
    
    public GradeController(){
        this.activeMenu="master";
        this.titleValue="Grade";
        this.redirectURI="grades";
        this.viewPath="grades";
    }
}

