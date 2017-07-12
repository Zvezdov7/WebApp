package ru.zvezdov.webApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zvezdov.webApp.dao.CardsDao;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/words")
public class WordsManagingController {

    private final CardsDao cardsDao;

    @Autowired
    public WordsManagingController(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("rows", cardsDao.getUsersNum());
        model.addAttribute("cards", cardsDao.getAllCards());
        return "words";
    }
}
