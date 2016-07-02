package com.example.android.reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.reportcard.ReportCard.Subject;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
        DemoReportCard();


    }

    private void DemoReportCard() {
        ReportCard reportCard = new ReportCard();
        Subject subject1 = new Subject("Math",97);
        reportCard.addSubject(subject1);

        reportCard.addSubject(new Subject("Physics",95));
        reportCard.addSubject(new Subject("Chemistry",90));
        reportCard.addSubject(new Subject("Biology",85));

        reportCard.removeSubject("physics");

        try {
            reportCard.addSubject(new Subject("Biology",80)); //This will throw exception
        } catch (Exception e) {
            e.printStackTrace();
        }

        reportCard.removeSubject(subject1);

        reportCard.addSubject(new Subject("Math",98));
        reportCard.addSubject(new Subject("Data Structure",90));

        reportCard.getSubject("data structure").setMarks(99);

        textView.setText(reportCard.toString());
    }
}
