package ru.zvezdov.webApp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/hello")
public class Controller {
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String hello(Model model) {
//        model.addAttribute("message", "Hello World");
        return "index";
    }

}
