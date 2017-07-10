package ru.zvezdov.webApp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello World");
        return "Hello";
    }

}
