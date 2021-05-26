package com.example.noti;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAllTodos();

    @Insert
    void insertTodos(Todo... todos);

    @Delete
    void deleteTodo(Todo todo);
}