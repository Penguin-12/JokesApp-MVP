package com.example.mvp_example;

import com.example.mvp_example.Model.Value;

import java.util.List;

public interface MainContract {

    interface MyView {

        void fillRecylerView(List<Value> list);

        void showProgressBar();

        void hideProgressBar();

        void showButton();
    }

    interface Presenter {
        void onClick();

    }

    interface Interactor {
        void getJokesFromInternet(InteractorListner interactorListner);

        interface InteractorListner {
            void onInteractorTaskFinished(List<Value> list);
        }

    }
}
