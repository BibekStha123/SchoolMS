/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.CrudController;
import com.cibt.sms.entity.Guardian;
import com.cibt.sms.entity.Student;
import com.cibt.sms.repository.GuardianRepository;
import com.cibt.sms.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping("/students")
public class StudentController extends CrudController<Student> {

    @Autowired
    private GuardianRepository guardianRepo;
    @Autowired
    private StudentRepository repository;

    public StudentController() {
        this.activeMenu = "master";
        this.titleValue = "Student";
        this.redirectURI = "students";
        this.viewPath = "students";
    }

    @Override
    public String index(Model model) {
        List<Guardian> guardians = guardianRepo.findAll();
        model.addAttribute("records", repository.findAll());
        model.addAttribute("guardians", guardians);
        return viewPath + "/index";
    }

    @GetMapping("/data")
    public String createData(Model model) {
        List<Guardian> guardians = guardianRepo.findAll();
        model.addAttribute("guardians", guardians);
        return viewPath + "/create";
    }
}
