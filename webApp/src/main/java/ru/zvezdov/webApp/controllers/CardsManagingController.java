package ru.zvezdov.webApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.zvezdov.webApp.dao.CardsDao;
import ru.zvezdov.webApp.model.CardDto;
import ru.zvezdov.webApp.model.GameDto;

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
        model.addAttribute("gameDto", new GameDto());
        return "words";
    }

    @PostMapping("/addnewcard")
    public String addNewCard(@ModelAttribute("carddto") CardDto cardDto, Model model) {
        if (cardDto.isLoadMp3()) {
            System.out.println("Load MP3");
        }
        cardsDao.addCard(cardDto.getWord(), cardDto.getDescription(), "");
        model.addAttribute("cards", cardsDao.getAllCards());
        model.addAttribute("carddto", new CardDto());
        model.addAttribute("gameDto", new GameDto());
        return "words";
    }

    @PostMapping("/playgame")
    public String playGame(@ModelAttribute("gameDto") GameDto gameDto, Model model) {
        model.addAttribute("card", cardsDao.getCardsByGrade(gameDto.getGrade()).get(0));
        return "game";
    }
}
