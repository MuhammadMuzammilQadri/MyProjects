package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Total marks: 10
    int score; //Each question has 2 marks
    EditText answer1;
    RadioGroup answer2;
    RadioGroup answer4;
    RadioGroup answer5;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setUpListeners();
    }

    private void initializeComponents() {
        answer1 = (EditText) findViewById(R.id.answer1);
        answer2 = (RadioGroup) findViewById(R.id.answer2);
        answer4 = (RadioGroup) findViewById(R.id.answer4);
        answer5 = (RadioGroup) findViewById(R.id.answer5);
        submitButton = (Button) findViewById(R.id.submit);
    }


    private void setUpListeners() {
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore();
                showResult();
            }
        });
    }

    private void showResult() {

        String string = null;
        if (score == 10){
            string = "Congratulations! You got 10 marks";
        } else if (score > 5){
            string = "You scored " + score + " marks";
        } else if (score <= 5){
            string = "Oops! You need hard work. You got " + score + " marks";
        }

        if (string != null)
        Toast.makeText(MainActivity.this, ""+string, Toast.LENGTH_SHORT).show();
    }

    private void calculateScore() {
        score = 0;
        checkFirstAnswer();
        checkSecondAnswer();
        checkThirdAnswer();
        checkFourthAnswer();
        checkFifthAnswer();
    }

    private void checkFifthAnswer() {

        if (answer5.getCheckedRadioButtonId() == R.id.barack_obama){
            incrementScore();
        }
    }

    private void checkFourthAnswer() {

        if (answer4.getCheckedRadioButtonId() == R.id.twoEyes){
            incrementScore();
        }
    }

    private void checkThirdAnswer() {
        CheckBox view = (CheckBox) findViewById(R.id.view);
        CheckBox textview = (CheckBox) findViewById(R.id.textview);
        CheckBox viewgroup = (CheckBox) findViewById(R.id.viewgroup);

        if (view.isChecked() && textview.isChecked() && !viewgroup.isChecked()){
            incrementScore();
        }

    }

    private void checkSecondAnswer() {
        if (answer2.getCheckedRadioButtonId() == R.id.nawaz_shareef){
            incrementScore();
        }
    }

    private void checkFirstAnswer() {
        String string =  answer1.getText().toString();
        if (string.trim().equalsIgnoreCase(getString(R.string.answer1a))){
            incrementScore();
        }
    }

    private void incrementScore() {
        score += 2;
    }
}
