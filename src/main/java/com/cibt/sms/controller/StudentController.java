/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.CrudController;
import com.cibt.sms.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping("/students")
public class StudentController extends CrudController<Student>{
    
    public StudentController()
    {
        this.activeMenu="master";
        this.titleValue="Student";
        this.redirectURI="students";
        this.viewPath="students";
    }
}
