package com.example.noti;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();

    private static final String NAME = "database-todos";
    private static AppDatabase INSTANCE;

    public static AppDatabase getDbInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}