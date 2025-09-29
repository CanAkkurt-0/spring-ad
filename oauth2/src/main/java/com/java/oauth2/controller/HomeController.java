package com.java.oauth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        String name = principal.getFullName();
        String email = principal.getEmail();
        String username = principal.getPreferredUsername();
        System.out.println(principal);

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("username", username);
        return "home";
    }

    @GetMapping("/java-gilde")
    public String javaGilde(Model model, @AuthenticationPrincipal OidcUser principal) {
        String name = principal.getFullName();
        String email = principal.getEmail();
        String username = principal.getPreferredUsername();
        System.out.println(principal);

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("username", username);
        return "java-gilde";
    }




    @GetMapping("/admin")
    public String admin(Model model, @AuthenticationPrincipal OidcUser principal) {
        String name = principal.getFullName();
        String email = principal.getEmail();
        String username = principal.getPreferredUsername();

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("username", username);
        return "admin";
    }
}
