package org.ccs.app.entrypoints.welcome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/index"})
    public String welcome() {

        return "index";
    }
}