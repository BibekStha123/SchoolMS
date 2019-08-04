/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Bibek
 */
public class CrudController<T> extends SiteController{
    
    protected String viewPath;
    
    @Autowired
    protected JpaRepository<T, Integer> repository;
    
    @GetMapping()
    public String index(Model model){
        model.addAttribute("records", repository.findAll());
        return viewPath+"/index";
    }
    
    @PostMapping
    public String save(T model){
        repository.save(model);
        return "redirect:/"+redirectURI;
    }
    
    @GetMapping(value="/create")
    public String create(){
        return viewPath+"/create";
    }

    @GetMapping(value="/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("record", repository.findById(id).get());
        return viewPath+"/edit";
    }
    
    @GetMapping(value="/delete/{id}")
    public String delete(@PathVariable("id") int id){
        repository.deleteById(id);
        return "redirect:/"+redirectURI;
    }
    
    @GetMapping(value="/json")
    public String getJson(){
        return null;
    }
}
