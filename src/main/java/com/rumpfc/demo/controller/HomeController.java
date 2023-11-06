package com.rumpfc.demo.controller;

import com.rumpfc.demo.service.LogicExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LogicExecutionService logicExecutionService;

    @Autowired
    public HomeController(LogicExecutionService logicExecutionService) {
        this.logicExecutionService = logicExecutionService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("normal")
    public String normalCall() {
        logicExecutionService.callNormally();
        return "normal";
    }

    @GetMapping("invoke")
    public String invokeCall() {
        logicExecutionService.callByInvocation();
        return "invoke";
    }
}
