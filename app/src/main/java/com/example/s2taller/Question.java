package com.example.s2taller;

import android.util.Log;

import java.util.Random;

public class Question {

    private String question;
    private String answer;
    private int numero1;
    private int numero2;
    private int respuesta;
    private Random randomNumber1;
    private Random randomNumber2;
    private Random randomSigno;
    private int signoValue;
    private String signo;

    public Question() {

        randomNumber1 = new Random();
        randomNumber2 = new Random();
        randomSigno = new Random();
        numero1 = randomNumber1.nextInt(20);
        numero2 = randomNumber2.nextInt(5)+1;
        signoValue = randomSigno.nextInt(4);
        //Log.e("RANDOMaker",this.question);
    }

    public void GenerateRamdomQuestion(){
        switch (signoValue){
            case 0:
                respuesta =numero1+numero2;
                signo = "+";
                break;
            case 1:
                respuesta = numero1-numero2;
                signo = "-";
                break;
            case 2:
                respuesta = numero1*numero2;
                signo = "*";
                break;
            case 3:
                respuesta = (int) numero1/numero2;
                signo = "/";
                break;

        }
        question = Integer.toString(numero1)+ " " + signo + " " +Integer.toString(numero2) ;
        answer = Integer.toString(respuesta);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
