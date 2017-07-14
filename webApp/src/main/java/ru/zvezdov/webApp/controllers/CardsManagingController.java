package ru.zvezdov.webApp.controllers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.zvezdov.webApp.dao.CardsDao;
import ru.zvezdov.webApp.model.Card;
import ru.zvezdov.webApp.model.CardDto;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/words")
public class CardsManagingController {

    private static final Logger logger = LogManager.getLogger(CardsManagingController.class);
    private final CardsDao cardsDao;

    @Autowired
    public CardsManagingController(CardsDao cardsDao) {
        this.cardsDao = cardsDao;
    }

    @GetMapping
    public String showPage() {
        logger.info("Hello");
        return "words";
    }

    @PostMapping("/addnewcard")
    public String addNewCard(CardDto cardDto) {
        if (cardDto.isLoadMp3()) {
            System.out.println("Load MP3");
        }
        cardsDao.addCard(cardDto.getWord(), cardDto.getDescription(), "");
        return "words";
    }

    @ModelAttribute("carddto")
    public CardDto getCardDto() {
        return new CardDto();
    }
    @ModelAttribute("cards")
    public List<Card> getCards() {
        return cardsDao.getAllCards();
    }
}
