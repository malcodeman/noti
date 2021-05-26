package com.example.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_details);

        Button cancelBtn = findViewById(R.id.cancelBtn);
        Button saveBtn = findViewById(R.id.saveBtn);

        cancelBtn.setOnClickListener(this::onCancelHandler);
        saveBtn.setOnClickListener(this::onSaveHandler);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long uid = extras.getLong(MainActivity.TODO_ID);
            Todo todo = AppDatabase.getDbInstance(this).todoDao().getTodoById((int) uid);
            EditText titleInput = findViewById(R.id.titleInput);
            EditText descriptionInput = findViewById(R.id.descriptionInput);
            titleInput.setText(todo.getTitle());
            descriptionInput.setText(todo.getDescription());
            cancelBtn.setText(R.string.delete);
            saveBtn.setText(R.string.update);
            cancelBtn.setOnClickListener(v -> onDeleteHandler(uid));
            saveBtn.setOnClickListener(v -> onUpdateHandler(titleInput.getText().toString(), descriptionInput.getText().toString(), uid));
        }
    }

    private  void goToMain(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    private void onDeleteHandler(long uid) {
        AppDatabase.getDbInstance(this).todoDao().deleteTodo((int) uid);
        goToMain();
    }

    private void onUpdateHandler(String title, String description, long uid) {
        AppDatabase.getDbInstance(this).todoDao().update(title, description, (int) uid);
        goToMain();
    }

    private void onCancelHandler(View v) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    private void onSaveHandler(View v) {
        AppDatabase db = AppDatabase.getDbInstance(getApplicationContext());
        EditText title = findViewById(R.id.titleInput);
        EditText description = findViewById(R.id.descriptionInput);
        if (title.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Title required!",
                    Toast.LENGTH_LONG).show();
            title.requestFocus();
        } else if (description.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Description required!",
                    Toast.LENGTH_LONG).show();
            description.requestFocus();
        } else {
            Todo newTodo = new Todo(title.getText().toString(), description.getText().toString());
            db.todoDao().insertTodos(newTodo);
            goToMain();
        }
    }
}