/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.CrudController;
import com.cibt.sms.entity.FiscalYear;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping("/fiscalyears")
public class FiscalYearController extends CrudController<FiscalYear>{
    public FiscalYearController(){
        this.activeMenu="master";
        this.titleValue="Fiscal Year";
        this.redirectURI="fiscalyears";
        this.viewPath="fiscalyears";
    }
}
