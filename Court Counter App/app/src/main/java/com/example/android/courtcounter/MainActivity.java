package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView scoreA;
    TextView scoreB;

    Button plus3A;
    Button plus2A;
    Button freeThrowA;
    Button plus3B;
    Button plus2B;
    Button freeThrowB;

    Button resetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setUpListeners();
    }

    private void initializeComponents() {
        scoreA = (TextView) findViewById(R.id.score_a);
        scoreB = (TextView) findViewById(R.id.score_b);

        plus3A = (Button) findViewById(R.id.plus3_a);
        plus2A = (Button) findViewById(R.id.plus2_a);
        freeThrowA = (Button) findViewById(R.id.freethrow_a);
        plus3B = (Button) findViewById(R.id.plus3_b);
        plus2B = (Button) findViewById(R.id.plus2_b);
        freeThrowB = (Button) findViewById(R.id.freethrow_b);

        resetButton = (Button) findViewById(R.id.reset);
    }

    private void setUpListeners() {
        plus3A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreA,3);
            }
        });

        plus2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreA,2);

            }
        });

        freeThrowA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreA,1);

            }
        });


        plus3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreB,3);

            }
        });

        plus2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreB,2);

            }
        });

        freeThrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementXbyN(scoreB,1);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreA.setText(Integer.toString(0));
                scoreB.setText(Integer.toString(0));

            }
        });


    }

    private void incrementXbyN(TextView scoreTextView, int increment) {

        String scoreString = scoreTextView.getText().toString();
        int score = Integer.parseInt(scoreString);

        if (score >= 99){
            String string = null;
            if (scoreTextView.equals(scoreA)){
                string = "Maximum score achieved on "+ "Team A";
            } else if (scoreTextView.equals(scoreB)){
                string = "Maximum score achieved on "+ "Team B";
            }

            if (string != null)
            Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
            return;
        }

        score+=increment;
        scoreTextView.setText(Integer.toString(score));
    }


}
