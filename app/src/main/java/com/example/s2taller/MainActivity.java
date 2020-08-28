package com.example.s2taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelection;
    private TextView viewQuestion;
    private TextView viewPuntaction;
    private TextView cronometer;
    private EditText inputAnswerPutted;
    private ArrayList<Question> questions;
    private Button tryAgainButton;

    //Variables

    //Variables en generador de preguntas a mano

    private String selectAnswer;
    private Random randomQuestion;
    private int selectedQuestion;

    //Variables en generador de generador de preguntas random


    //Varibles usadas en ambos métodos
    private int updateCronometer;
    private int updatePunctation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar

        buttonSelection = findViewById(R.id.buttonSelection);
        viewQuestion = findViewById(R.id.questionView);
        inputAnswerPutted = findViewById(R.id.inputAnswerPutted);
        viewPuntaction = findViewById(R.id.viewPuntaction);
        tryAgainButton = findViewById(R.id.TryAgainButtom);
        cronometer = findViewById(R.id.cronometer);

        questions = new ArrayList<Question>();
        //Método Bonito
        //Se generan las preguntas aleatorias
        for(int i=0;i<50; i++){
            questions.add(new Question());
            questions.get(i).GenerateRamdomQuestion();
            Log.e("Prueba Señorial",questions.get(i).getQuestion());
        }


        updateCronometer = 30;
        cronometer.setText(Integer.toString(updateCronometer));
        new Thread(
                ()->{
                    while (true){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(
                                ()->{

                                    Log.e("titulo", String.valueOf(cronometer));
                                    if(updateCronometer ==0){
                                        cronometer.setText("Stop");
                                        updateCronometer = 0;
                                        Log.e("no valid","Respuesta incorrecta");
                                        questions.removeAll(questions);
                                       // questions.add(new Question("Has fallado, Gracias por jugar", "Cerrar app"));
                                        tryAgainButton.setVisibility(View.VISIBLE);
                                        Thread.interrupted();
                                    } else{
                                        updateCronometer--;
                                        cronometer.setText(Integer.toString(updateCronometer));
                                    }
                                }
                        );

                    }




                }
        ).start();


        mainActions();

        restart();


    }

    public void mainActions(){

        randomQuestion = new Random();
        selectedQuestion = randomQuestion.nextInt(questions.size());
        viewQuestion.setText(questions.get(selectedQuestion).getQuestion());
        tryAgainButton.setVisibility(View.GONE);

        updatePunctation = Integer.parseInt(viewPuntaction.getText().toString());


        buttonSelection.setOnClickListener(
                (v)->{


                    ///////////////////Método con Random
                    selectAnswer = questions.get(selectedQuestion).getAnswer();


                    if(inputAnswerPutted.getText().toString().equals(selectAnswer) ){
                        questions.remove(selectedQuestion);
                        Log.e("titulo","Esta funcionando");

                        if(questions.size()==0){
                           // questions.add(new Question("Felicidades Terminaste", "Cerrar app"));
                            buttonSelection.setVisibility(View.GONE);
                            Thread.interrupted();
                        }
                        //Método con Random
                        selectedQuestion = randomQuestion.nextInt(questions.size());
                        updatePunctation +=15;
                        viewPuntaction.setText(Integer.toString(updatePunctation));
                        viewQuestion.setText(questions.get(selectedQuestion).getQuestion());
                        updateCronometer = 30;




                    } else {
                        Log.e("no valid","Respuesta incorrecta");
                        questions.removeAll(questions);
                        tryAgainButton.setVisibility(View.VISIBLE);
                        buttonSelection.setVisibility(View.GONE);

                    }

                    ///////////////////////


                }
        );
    }

    public void restart(){
        tryAgainButton.setOnClickListener(
                (v)->{
                    mainActions();
                    updateCronometer = 30;
                    viewPuntaction.setText("0");
                    updatePunctation = 0;
                    Log.e("titulo","Se reinicio");

                }
        );
    }






}