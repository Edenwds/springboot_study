package com.example.filehandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/file")
    public String file(){
        return "fileupload";
    }

    @RequestMapping("/multifile")
    public String multiFile(){
        return "multiFileUpload";
    }
}
