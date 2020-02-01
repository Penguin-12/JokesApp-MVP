package com.example.mvp_example.View;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_example.Adapters.CustomAdapter;
import com.example.mvp_example.MainContract;
import com.example.mvp_example.Model.Value;
import com.example.mvp_example.Presenter.PresenterImpl;
import com.example.mvp_example.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MyView {
    RecyclerView recyclerView;
    Button button;
    MainContract.Presenter presenter;
    CustomAdapter customAdapter;
    ProgressBar progressBar;
    List<Value> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Chuck Norris Jokes");
        recyclerView = findViewById(R.id.recylerView);
        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        presenter = new PresenterImpl(this, this);
        customAdapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAdapter.emptyCustomAdapterList();
                button.setVisibility(View.INVISIBLE);
                presenter.onClick();
                showProgressBar();
            }
        });

    }

    @Override
    public void fillRecylerView(List<Value> list) {
        customAdapter.list = list;
        customAdapter.notifyDataSetChanged();
    }


    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showButton() {
        button.setVisibility(View.VISIBLE);
    }


}
