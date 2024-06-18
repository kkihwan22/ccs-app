package org.ccs.app.entrypoints.authenticate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationPageController {

    @GetMapping("/pages/signup")
    public String pageSignup() {
        return "signup";
    }
}
