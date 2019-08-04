/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt.sms.controller;

import com.cibt.sms.core.SiteController;
import com.cibt.sms.utils.FileHelper;
import com.cibt.sms.utils.TextParser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value = "/generator")
public class GeneratorController extends SiteController {

    private String packagePath = "com/cibt/sms/";
    private String generatorPath = "./src/main/java/" + packagePath;
    private String viewPath = "./src/main/resources/templates/";

    public GeneratorController() {
        this.activeMenu = "master";
        this.titleValue = "Generators";
        this.redirectURI = "generator";
    }

    @GetMapping
    public String index(Model model) {
        File file = new File(generatorPath + "entity/");
        model.addAttribute("files", file.list());
//        System.out.println(file.getAbsolutePath());
        return "generator/index";
    }

    @PostMapping
    public String generate(@RequestParam("entity") String entity) {

        String fileName = generatorPath + "/entity/" + entity;
        File file = new File(fileName);

        String templatePath = "./templates/";

        if (file.exists()) {
            try {
                String[] fileToken = entity.split("\\.");
                
                generateRepository(templatePath, fileToken);//Repository generator
                generateController(templatePath, fileToken);//Controller generator
//                generateView(fileToken, templatePath);//View generator

            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
        }
        return "redirect:/generator?success";
    }

    private void generateRepository(String templatePath, String[] fileToken) throws IOException{
        String repositoryPath = generatorPath + "repository/";

        String content = new TextParser().mapData("packageName", packagePath.replace("/", "."))
                .mapData("Entity", fileToken[0])
                .parse(FileHelper.readToEnd(templatePath + "Repository.tpl"));
        
        FileHelper.write(repositoryPath + fileToken[0] + "Repository.java", content);
        System.out.println("Repository Generated");
    }
    
    private void generateController(String templatePath, String[] fileToken)throws IOException{
        String controllerPath = generatorPath+"controller/";
        
        String content = new TextParser().mapData("packageName", packagePath.replace("/", "."))
                                         .mapData("Entity", fileToken[0])
                                         .mapData("url", fileToken[0].toLowerCase())
                                         .parse(FileHelper.readToEnd(templatePath+"Controller.tpl"));
        
        FileHelper.write(controllerPath+fileToken[0]+"Controller.java", content);
        System.out.println("Controller Generated");
    }
    
    public void generateView(String[] fileToken, String templatePath)throws IOException{
        boolean viewTemplate = new File(viewPath+fileToken[0]).mkdir();
        if(viewTemplate){
        String content = FileHelper.readToEnd(templatePath+"View.tpl");
        FileHelper.write(viewPath+fileToken[0]+"/"+"View.html", content);
        }
        System.out.println("view generated");
        
        //Java Inflector
    }
}
