package ru.zvezdov.webApp.model;

/**
 * Created by Dmitry on 13.07.2017.
 */
public class GameDto {
    private int grade;

    public GameDto() {
    }

    public GameDto(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
