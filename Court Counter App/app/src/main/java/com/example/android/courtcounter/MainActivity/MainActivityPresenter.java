package com.example.android.courtcounter.MainActivity;

/**
 * Created by Muhammad Muzammil on 10-Sep-17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;

    @Override
    public void start() {

    }

    public MainActivityPresenter(MainActivityContract.View view) {
        this.view = view;
    }


    @Override
    public void incrementXbyN(int increment, int score, MainActivity.Team team) {
        if (score >= 99) {
            String string = null;
            if (team.equals(MainActivity.Team.A)) {
                string = "Maximum score achieved on " + "Team A";
            } else if (team.equals(MainActivity.Team.B)) {
                string = "Maximum score achieved on " + "Team B";
            }

            if (string != null)
                view.showToast(string);
            return;
        }

        if (team.equals(MainActivity.Team.A))
            view.updateTeamAScore(score + increment);
        else if (team.equals(MainActivity.Team.B))
            view.updateTeamBScore(score + increment);

    }
}
