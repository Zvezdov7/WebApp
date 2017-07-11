package ru.zvezdov.webApp.controllers;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/words")
public class WordsManagingController {

    @GetMapping
    public String showPage() {
        return "words";
    }
}
