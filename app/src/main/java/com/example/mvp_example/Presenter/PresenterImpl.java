package com.example.mvp_example.Presenter;

import android.content.Context;

import com.example.mvp_example.MainContract;
import com.example.mvp_example.Model.InteractorImpl;
import com.example.mvp_example.Model.Value;

import java.util.List;

public class PresenterImpl implements MainContract.Presenter, MainContract.Interactor.InteractorListner {

    MainContract.MyView myView;
    MainContract.Interactor interactor;

    public PresenterImpl(Context context, MainContract.MyView myView) {
        this.myView = myView;
        this.interactor = new InteractorImpl(context);
    }

    @Override
    public void onClick() {
        interactor.getJokesFromInternet(this);
    }


    @Override
    public void onInteractorTaskFinished(List<Value> list) {
        if (myView != null) {
            myView.hideProgressBar();
            myView.showButton();
            myView.fillRecylerView(list);
        }
    }
}

