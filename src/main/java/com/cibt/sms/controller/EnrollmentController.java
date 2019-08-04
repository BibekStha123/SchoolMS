/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.CrudController;
import com.cibt.sms.entity.Enrollment;
import com.cibt.sms.entity.FiscalYear;
import com.cibt.sms.entity.Grade;
import com.cibt.sms.entity.Section;
import com.cibt.sms.entity.Student;
import com.cibt.sms.repository.FiscalYearRepository;
import com.cibt.sms.repository.GradeRepository;
import com.cibt.sms.repository.SectionRepository;
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
@RequestMapping(value = "/enrollments")
public class EnrollmentController extends CrudController<Enrollment> {

    @Autowired
    StudentRepository stdRepo;
    @Autowired
    SectionRepository secRepo;
    @Autowired
    GradeRepository gradeRepo;
    @Autowired
    FiscalYearRepository yearRepo;

    public EnrollmentController() {
        this.activeMenu = "master";
        this.titleValue = "Enrollment";
        this.redirectURI = "enrollments";
        this.viewPath = "enrollments";
    }

    @GetMapping("/data")
    public String create(Model model) {
        List<Student> stds = stdRepo.findAll();
        List<Section> sections = secRepo.findAll();
        List<Grade> grades = gradeRepo.findAll();
        List<FiscalYear> years = yearRepo.findAll();

        model.addAttribute("stds", stds);
        model.addAttribute("secs", sections);
        model.addAttribute("grades", grades);
        model.addAttribute("years", years);

        return viewPath + "/create";
    }
    
    
}
