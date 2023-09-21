package com.NaserGharbieh.Authentication.controller;

import com.NaserGharbieh.Authentication.Repositories.SiteUserRepository;
import com.NaserGharbieh.Authentication.models.SiteUser;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController{
    @Autowired
    SiteUserRepository siteUserRepository;


    @GetMapping("/signup")
    public String getSignUpPage(){
        return"/signup.html";
    }
    @GetMapping("/")
    public String gethomePage(){
        return"/home.html";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return"/login.html";
    }




    @PostMapping("/signup")
    public RedirectView signUpUserWithBCrypt(String username,String password){
        String hashedPassword= BCrypt.hashpw(password,BCrypt.gensalt(12));

        SiteUser siteUser=new SiteUser(username, hashedPassword);
        siteUserRepository.save(siteUser);

    return new RedirectView("/login");
    }




    @PostMapping("/login")
    public RedirectView logInUser(HttpServletRequest request, String username, String password){
        SiteUser userFromDb =siteUserRepository.findByUsername(username);

        if((userFromDb==null)||!(BCrypt.checkpw(password,userFromDb.getPassword()))){
            return new RedirectView("/login");
        }
        HttpSession session= request.getSession();
        session.setAttribute("username", username);
        return new RedirectView("/posts");
    }

    @PostMapping("/logout")
    public RedirectView logoutUser(HttpServletRequest request ){
        HttpSession session=request.getSession();
        session.invalidate();

    return new RedirectView("/login");}



}
