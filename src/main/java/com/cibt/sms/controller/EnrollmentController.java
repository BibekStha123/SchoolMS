/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.CrudController;
import com.cibt.sms.entity.Enrollment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/enrollments")
public class EnrollmentController extends CrudController<Enrollment>{
    public EnrollmentController(){
        this.activeMenu="master";
        this.titleValue="Enrollment";
        this.redirectURI="enrollments";
        this.viewPath="enrollments";
    }
}
