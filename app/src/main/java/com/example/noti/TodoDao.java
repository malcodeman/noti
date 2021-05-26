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

    @Query("DELETE FROM todo WHERE uid = :uid")
    void deleteTodo(int uid);

    @Query("SELECT * FROM todo WHERE uid = :uid LIMIT 1")
    Todo getTodoById(int uid);

    @Query("UPDATE todo SET title = :title, description = :description WHERE uid = :uid")
    void update(String title, String description, int uid);
}