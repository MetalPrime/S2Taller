package com.example.s2taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelection;
    private TextView viewTextOne;
    private TextView viewTextTwo;
    private TextView viewSign;
    private TextView viewQuestion;
    private TextView viewPuntaction;
    private EditText inputAnswerPutted;
    private ArrayList<Question> questions;
    private Button tryAgainButton;

    //Variables
    //private int numberOne,numberTwo;
    private String selectAnswer;
    private Random randomQuestion;
    private int selectedQuestion;

    private int nextQuestion;
    private String selectedAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar

        buttonSelection = findViewById(R.id.buttonSelection);
        /*viewTextOne = findViewById(R.id.viewNumberOne);
        viewTextTwo = findViewById(R.id.viewNumberTwo);
        viewSign = findViewById(R.id.viewSign);*/
        viewQuestion = findViewById(R.id.questionView);
        inputAnswerPutted = findViewById(R.id.inputAnswerPutted);
        viewPuntaction = findViewById(R.id.viewPuntaction);
        tryAgainButton = findViewById(R.id.TryAgainButtom);

        //Números de variables de preguntas

        /*  numberOne = (int)(Math.random()*25+1);
        Random random = new Random();
        int resultado = random.nextInt(questions.size());
        */
        //ArrayList

        questions = new ArrayList<Question>();

        questions.add(new Question("27/3","9"));
        questions.add(new Question("10*5","50"));
        questions.add(new Question("20+100","120"));
        questions.add(new Question("1000-7","993"));
        questions.add(new Question("50/5","10"));







        buttonSelection.setOnClickListener(
                (v)->{

                /*    for(int i=0;i<5;){
                        if(inputAnswerPutted.getText().toString().equals(questions.get(i).getAnswer())){
                            i++;
                            nextQuestion++;
                            Toast.makeText(this,"Funciona",Toast.LENGTH_LONG).show();
                            Log.e("titulo","Esta funcionando");
                        };
                    }*/
                    //Método con Random
                    randomQuestion = new Random();
                    selectedQuestion = randomQuestion.nextInt(questions.size());
                    selectAnswer = questions.get(selectedQuestion).getAnswer();
                    viewQuestion.setText(questions.get(selectedQuestion).getQuestion());

                if(inputAnswerPutted.getText().toString().equals(selectAnswer)){
                    questions.remove(selectedQuestion);
                    Log.e("titulo","Esta funcionando");
                }


                }
        );
    }




}