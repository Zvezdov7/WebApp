package ru.zvezdov.webApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zvezdov.webApp.dao.WordsDao;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/words")
public class WordsManagingController {

    private final WordsDao wordsDao;

    @Autowired
    public WordsManagingController(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("rows", wordsDao.getUsersNum());
        return "words";
    }
}
