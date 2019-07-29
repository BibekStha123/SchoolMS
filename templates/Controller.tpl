/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package {{packageName}}controller;

import {{packageName}}entity.{{Entity}};
import {{packageName}}core.CrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Bibek
 */
@Controller
@RequestMapping(value="/{{url}}")
public class {{Entity}}Controller extends CrudController<{{Entity}}>{
    
    public {{Entity}}Controller(){
        this.activeMenu="master";
        this.titleValue="{{Entity}}";
        this.redirectURI="{{url}}";
        this.viewPath="{{url}}";
    }
}

