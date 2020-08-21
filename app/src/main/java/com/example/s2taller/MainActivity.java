package com.example.s2taller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonSelection;
    private TextView viewTextOne;
    private TextView viewTextTwo;
    private TextView viewSign;
    private TextView viewPuntaction;
    private EditText inputAnswerPutted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referenciar

        buttonSelection = findViewById(R.id.buttonSelection);
        viewTextOne = findViewById(R.id.viewNumberOne);
        viewTextTwo = findViewById(R.id.viewNumberTwo);
        viewSign = findViewById(R.id.viewSign);
        inputAnswerPutted = findViewById(R.id.inputAnswerPutted);
        viewPuntaction = findViewById(R.id.viewPuntaction);


    }
}