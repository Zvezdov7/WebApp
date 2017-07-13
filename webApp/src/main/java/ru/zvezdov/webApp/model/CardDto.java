package ru.zvezdov.webApp.model;

/**
 * @author Dmitry Zvezdov
 *         12.07.17.
 */
public class CardDto {
    private String word;
    private String description;
    private boolean loadMp3;

    public CardDto() {
    }

    public CardDto(String word, String description, boolean loadMp3) {
        this.word = word;
        this.description = description;
        this.loadMp3 = loadMp3;
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

    public boolean isLoadMp3() {
        return loadMp3;
    }

    public void setLoadMp3(boolean loadMp3) {
        this.loadMp3 = loadMp3;
    }
}
