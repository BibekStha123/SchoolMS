/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.entity.Section;
import com.cibt.sms.core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/sections")
public class SectionController extends CrudController<Section>{
    
    public SectionController(){
        this.activeMenu="master";
        this.titleValue="Section";
        this.redirectURI="sections";
        this.viewPath="sections";
    }
    
}
