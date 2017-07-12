package ru.zvezdov.webApp.model;

/**
 * @author Dmitry Zvezdov
 *         12.07.17.
 */
public class CardDto {
    private String word;
    private String description;

    public CardDto() {
    }

    public CardDto(String word, String description) {
        this.word = word;
        this.description = description;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
