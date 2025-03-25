package com.chrzsean.projects.Spring.Boot.Web.App.WelcomePage;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password){

        boolean isValidUserName = username.equalsIgnoreCase("Bry");
        boolean isValidPassword = password.equalsIgnoreCase("chryzsean");

        return isValidUserName && isValidPassword;
    }

}
