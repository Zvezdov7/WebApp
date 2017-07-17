package ru.zvezdov.webApp.controllers;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.zvezdov.webApp.dao.CardsDao;
import ru.zvezdov.webApp.model.Card;
import ru.zvezdov.webApp.model.CardDto;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
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
        return "redirect:/words/";
    }

    @GetMapping("/deletecard/{id}")
    public String deleteCard(@PathVariable int id) {
        cardsDao.deleteCardById(id);
        return "redirect:/words/";
    }

    @GetMapping(path = "/file.json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public FileSystemResource getJsonFile() throws IOException {
        List<Card> allCards = cardsDao.getAllCards();
        Gson gson = new Gson();
        File file = new File("file");
        FileUtils.writeStringToFile(file, gson.toJson(allCards), "UTF-8");
        return new FileSystemResource(file);
    }

    @PostMapping("/uploadJson")
    public String handleFormUpload(@RequestParam("file") MultipartFile file, @ModelAttribute("cards") List<Card> cards) throws IOException {
            String content = new String(file.getBytes(), "UTF-8");
            Gson gson = new Gson();
            Type type = new TypeToken<List<Card>>(){}.getType();
            List<Card> jsonCards = gson.fromJson(content, type);
            cardsDao.addAllCards(jsonCards);
            cards = cardsDao.getAllCards();
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
