package fsa.training.ThinhNV_JWD.L.A101.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {


    @GetMapping("/login")
    public String login() {
        return "view/auth/login";
    }

}
