package com.chrzsean.projects.Spring.Boot.Web.App.login.loginController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//    private AuthenticationService authenticationService;
//
//
//    public LoginController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }
//
//    @RequestMapping(value = "/",method = RequestMethod.GET) //localhost:8080/say-hello
//    public String goToLoginPage(ModelMap model){
//        model.put("name", "chryzsean");
//        return "welcome"; //file name here
//    }
//
//    @RequestMapping(value = "login",method = RequestMethod.POST) //localhost:8080/say-hello
//    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//
//        if (authenticationService.authenticate(name, password)) {
//            model.put("name", name);
//            model.put("password", password);
//
//
////        Authentication
////        user: Bry
////        password: chryzsean
//
//
//            return "welcome"; //file name here
//        }
//
//        model.put("errorMessage", "Invalid Credentials! Please try again");
//
//        return "login";
//
//    }

    @RequestMapping(value = "/",method = RequestMethod.GET) //localhost:8080/say-hello
    public String goToWelcomePage(ModelMap model){
        model.put("name", "getLoggedinUsername");
        return "welcome"; //file name here
    }

    private String getLoggedinUsername(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();


    }






}
