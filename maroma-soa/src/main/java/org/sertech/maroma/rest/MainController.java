package org.sertech.maroma.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by German on 28/07/2016.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage(){
        return "index.html";
    }
}
