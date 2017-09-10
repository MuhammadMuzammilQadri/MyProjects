package com.example.android.courtcounter.MainActivity;

import com.example.android.courtcounter.BasePresenter;
import com.example.android.courtcounter.BaseView;

/**
 * Created by Muhammad Muzammil on 10-Sep-17.
 */

public interface MainActivityContract {
    interface View extends BaseView<Presenter> {

        String getScoreA();

        String getScoreB();

        void showToast(String string);

        void updateTeamAScore(int score);

        void updateTeamBScore(int score);

        void resetScore();
    }

    interface Presenter extends BasePresenter {
        void incrementXbyN(int increment, int score, MainActivity.Team team);
    }

}
