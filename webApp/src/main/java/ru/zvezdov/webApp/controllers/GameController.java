package ru.zvezdov.webApp.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.zvezdov.webApp.dao.CardsDao;
import ru.zvezdov.webApp.model.Card;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

/**
 * Created by Dmitry on 14.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/game")
public class GameController {
    private static final Logger logger = LogManager.getLogger(CardsManagingController.class);
    private final CardsDao cardsDao;

    @Autowired
    public GameController(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @PostMapping
    public String playGame(@RequestParam int grade, Model model, HttpSession session) {
        logger.info("Grade:" + grade);
        session.setAttribute("grade", grade);
        logger.info(session.getAttribute("grade"));
        List<Card> cardsByGrade = cardsDao.getCardsByGrade(grade);
        if (cardsByGrade.isEmpty()) {
            session.removeAttribute("grade");
            return "redirect:/words";
        }
        Random random = new Random();
        Card card = cardsByGrade.get(random.nextInt(cardsByGrade.size()));
        session.setAttribute("card", card);
        session.setAttribute("cards", cardsByGrade);
        return "game";
    }

    @GetMapping("/know")
    public String know(@SessionAttribute("card") Card card, @SessionAttribute("cards") List<Card> cards, HttpSession session) {
        cards.remove(card);
        card.incGrade();
        cardsDao.updateCard(card);
        if (cards.isEmpty()) {
            session.removeAttribute("cards");
            session.removeAttribute("grade");
            session.removeAttribute("card");
            return "redirect:/words";
        }
        session.setAttribute("card", cards.get(0));
        return "game";
    }

    @GetMapping("/donotknow")
    public String donotknow(@SessionAttribute("card") Card card, @SessionAttribute("grade") int grade, HttpSession session) {
        List<Card> cardsByGrade = cardsDao.getCardsByGrade(grade);
        if (cardsByGrade.isEmpty()) {
            session.removeAttribute("grade");
            session.removeAttribute("cards");
            session.removeAttribute("card");
            return "redirect:/words";
        }
        Random random = new Random();
        card = cardsByGrade.get(random.nextInt(cardsByGrade.size()));
        session.setAttribute("card", card);
        session.setAttribute("cards", cardsByGrade);
        return "game";
    }

    @GetMapping("/stopgame")
    public String donotknow(HttpSession session) {
        session.removeAttribute("grade");
        session.removeAttribute("cards");
        session.removeAttribute("card");
        return "redirect:/words";
    }
}
