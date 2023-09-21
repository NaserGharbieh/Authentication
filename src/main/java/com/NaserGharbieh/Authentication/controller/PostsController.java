package com.NaserGharbieh.Authentication.controller;

import com.NaserGharbieh.Authentication.Repositories.PostsRepository;
import com.NaserGharbieh.Authentication.Repositories.SiteUserRepository;
import com.NaserGharbieh.Authentication.models.Post;
import com.NaserGharbieh.Authentication.models.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostsController {
   @Autowired
   SiteUserRepository siteUserRepository;
   @Autowired
  PostsRepository  postsRepository;

    @GetMapping ("/posts")
    public String getPostsPage(HttpServletRequest request, Model m){
        HttpSession session=request.getSession();
        if(session.getAttribute("username")== null){
            return "login.html";
        }

        String username=session.getAttribute("username").toString();
      List<Post> posts = postsRepository.findAll();
      m.addAttribute("posts",posts);
        m.addAttribute("username" ,username);


    return "posts.html";}




    @PostMapping("/add-post")
    public RedirectView addPost(String postText, HttpServletRequest request ){
        HttpSession session=request.getSession();

        String usernameFromSession=session.getAttribute("username").toString();
        SiteUser siteUser=siteUserRepository.findByUsername(usernameFromSession);
        if (siteUser != null && postText !="") {
            Post postFromUser=new Post(postText,siteUser);

            postsRepository.save(postFromUser);
        }else {return new RedirectView("/login");}


    return new RedirectView("/posts");}
}
