package com.example.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TODO_ID = "MainActivity/TODO_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addTodoBtn = findViewById(R.id.addTodoBtn);
        addTodoBtn.setOnClickListener(this::onAddTodoHandler);
        initializeListAdapter();
        ListView listView = findViewById(R.id.todosList);
        listView.setOnItemClickListener(this::listItemOnClickHandler);
    }

    private void listItemOnClickHandler(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, TodoDetails.class);
        intent.putExtra(TODO_ID, id);
        startActivity(intent);
    }

    private void onAddTodoHandler(View v) {
        Intent i = new Intent(getApplicationContext(), TodoDetails.class);
        startActivity(i);
    }

    private void initializeListAdapter() {
        List<Todo> todos = AppDatabase.getDbInstance(getApplicationContext()).todoDao().getAllTodos();
        TodoListAdapter adapter = new TodoListAdapter(this, todos);
        ListView listView = findViewById(R.id.todosList);
        listView.setAdapter(adapter);
        if (todos.size() == 0) {
            TextView emptyState = findViewById(R.id.emptyState);
            emptyState.setVisibility(View.VISIBLE);
        }
    }
}