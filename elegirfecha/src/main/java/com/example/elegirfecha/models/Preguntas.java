package com.example.elegirfecha.models;

/**
 * Created by jesus95 on 25/05/17.
 */

public class Preguntas {

    public String mQuestions[] = {
        "En los primeros 4 meses, ¿Que debe comer un cachorro?"
    };

    private String mChoices[][] = {
        {"Croquetas", "Leche", "Carne"}
    };

    private String mCorrectAnswer[] = {"Leche"};

    private String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }


}

