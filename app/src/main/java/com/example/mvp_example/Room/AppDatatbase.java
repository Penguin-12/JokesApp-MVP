package com.example.mvp_example.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mvp_example.Model.Value;


@Database(entities = {Value.class}, version = 1, exportSchema = false)

public abstract class AppDatatbase extends RoomDatabase {
    public abstract JokeValueDao jokeValueDao();
}
