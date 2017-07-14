package ru.zvezdov.webApp.model;

/**
 * Created by Dmitry on 12.07.2017.
 */
public class Card {
    private int id;
    private String word;
    private String description;
    private int grade;
    private String mp3path;

    public Card(int id, String word, String description, int grade, String mp3path) {
        this.id = id;
        this.word = word;
        this.description = description;
        this.grade = grade;
        this.mp3path = mp3path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void incGrade() {
        this.grade++;
    }

    public void decGrade() {
        this.grade--;
    }

    public String getMp3path() {
        return mp3path;
    }

    public void setMp3path(String mp3path) {
        this.mp3path = mp3path;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", description='" + description + '\'' +
                ", grade=" + grade +
                ", mp3path='" + mp3path + '\'' +
                '}';
    }
}
