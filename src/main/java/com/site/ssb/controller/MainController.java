package com.site.ssb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping(value = "/")
    @ResponseBody
    public String index() {
        return "Hello this is main page";
    }
}
