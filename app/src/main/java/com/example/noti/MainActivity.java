package com.example.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addTodoBtn = findViewById(R.id.addTodoBtn);
        addTodoBtn.setOnClickListener(this::onAddTodoHandler);
        initializeListAdapter();
    }

    private void onAddTodoHandler(View v) {
        Intent i = new Intent(getApplicationContext(), TodoDetails.class);
        startActivity(i);
    }

    private void initializeListAdapter() {
        List<Todo> todos = AppDatabase.getDbInstance(getApplicationContext()).todoDao().getAllTodos();
        TodoListAdapter adapter = new TodoListAdapter(this, todos);
        ListView listView = findViewById(R.id.list_view_container);
        listView.setAdapter(adapter);
    }
}