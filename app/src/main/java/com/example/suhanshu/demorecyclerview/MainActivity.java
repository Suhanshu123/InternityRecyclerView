package com.example.suhanshu.demorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    List<Movies> movie_list = new ArrayList<>();
    MoviesAdapter moviesAdapter;
    Button btn;
    int flag=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moviesAdapter = new MoviesAdapter(movie_list);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));


        btn=findViewById(R.id.button);
        btn.setOnClickListener(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(moviesAdapter);

        prepareMovieData();


    }

        private void prepareMovieData() {
            Movies movie = new Movies("Mad Max: Fury Road", "Action & Adventure", "2015");
            movie_list.add(movie);

            movie = new Movies("Inside Out", "Animation, Kids & Family", "2015");
            movie_list.add(movie);

            movie = new Movies("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
            movie_list.add(movie);


           moviesAdapter.notifyDataSetChanged();

        }

    @Override
    public void onClick(View view) {

        if(flag==1) {

            Movies movie;

            movie = new Movies("Shaun the Sheep", "Animation", "2015");
            movie_list.add(movie);

            movie = new Movies("The Martian", "Science Fiction & Fantasy", "2015");
            movie_list.add(movie);
            moviesAdapter.notifyDataSetChanged();
            flag=0;
        }
        else if(flag==0){
//            Movies movie;
            movie_list.remove(3);
            movie_list.remove(3);
            moviesAdapter.notifyDataSetChanged();
            flag=1;

        }
    }
}

