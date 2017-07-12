package ru.zvezdov.webApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zvezdov.webApp.dao.CardsDao;
import ru.zvezdov.webApp.model.CardDto;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/words")
public class CardsManagingController {

    private final CardsDao cardsDao;

    @Autowired
    public CardsManagingController(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @GetMapping
    public String showPage(Model model) {
        model.addAttribute("cards", cardsDao.getAllCards());
        model.addAttribute("carddto", new CardDto());
        return "words";
    }

    @PostMapping("/addnewcard")
    public String addNewCard(@ModelAttribute("carddto") CardDto cardDto, Model model) {
        cardsDao.addCard(cardDto.getWord(), cardDto.getDescription(), "");
        model.addAttribute("cards", cardsDao.getAllCards());
        return "words";
    }
}
