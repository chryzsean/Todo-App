package com.chrzsean.projects.Spring.Boot.Web.App.sayHelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PrintOutController {

    @RequestMapping("say-hello") //localhost:8080/say-hello
    @ResponseBody // Returns as is to the browser
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("hello") //localhost:8080/say-hello
    public String sayHelloJsp(){
        return "sayHello"; //file name here
    }



}

