/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.SiteController;
import com.cibt.sms.entity.Enrollment;
import com.cibt.sms.entity.UserRole;
import com.cibt.sms.repository.EnrollmentRepository;
import com.cibt.sms.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserRoleRepository repo;
    @Autowired
    private EnrollmentRepository enrollmentRepository;
    
    public HomeController()
    {
        this.titleValue = "Dashboard";
        this.activeMenu= "dashboard";
    }
        
    
    @GetMapping()
    public String index()
    {
//        for(UserRole role : repo.findByUserId(1)){
//            System.out.println("User: "+role.getUser().getUserName());
//            System.out.println("Role: "+role.getRole().getName());
//        }
//        for(Enrollment enroll : enrollmentRepository.findByStudentId(1)){
//            System.out.println("Student name: "+enroll.getStudent().getFirstName());
//        }
        return "index";
    }
            
}
