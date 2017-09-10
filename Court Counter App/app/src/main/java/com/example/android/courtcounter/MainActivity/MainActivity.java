package com.example.android.courtcounter.MainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.courtcounter.R;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    TextView scoreA;
    TextView scoreB;

    Button plus3A;
    Button plus2A;
    Button freeThrowA;
    Button plus3B;
    Button plus2B;
    Button freeThrowB;

    Button resetButton;
    private MainActivityContract.Presenter mPresenter;


    enum Team {
        A, B
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        setUpListeners();

        setPresenter(new MainActivityPresenter(this));
        mPresenter.start();
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
                int score = Integer.parseInt(scoreA.getText().toString());
                mPresenter.incrementXbyN(3, score, Team.A);

            }
        });

        plus2A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(scoreA.getText().toString());
                mPresenter.incrementXbyN(2, score, Team.A);

            }
        });

        freeThrowA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(scoreA.getText().toString());
                mPresenter.incrementXbyN(1, score, Team.A);

            }
        });


        plus3B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(scoreB.getText().toString());
                mPresenter.incrementXbyN(3, score, Team.B);

            }
        });

        plus2B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(scoreB.getText().toString());
                mPresenter.incrementXbyN(2, score, Team.B);

            }
        });

        freeThrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = Integer.parseInt(scoreB.getText().toString());
                mPresenter.incrementXbyN(1, score, Team.B);

            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetScore();

            }
        });


    }

    @Override
    public void resetScore() {
        scoreA.setText(Integer.toString(0));
        scoreB.setText(Integer.toString(0));
    }


    public void setPresenter(MainActivityContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public String getScoreA() {
        return scoreA.getText().toString();
    }

    @Override
    public String getScoreB() {
        return scoreB.getText().toString();
    }

    @Override
    public void showToast(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateTeamAScore(int score) {
        scoreA.setText(String.valueOf(score));
    }

    @Override
    public void updateTeamBScore(int score) {
        scoreB.setText(String.valueOf(score));
    }
}
