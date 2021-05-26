package com.example.noti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addTodoBtn = findViewById(R.id.addTodoBtn);
        addTodoBtn.setOnClickListener(this::onAddTodoHandler);
    }

    private void onAddTodoHandler(View v){
        Intent i = new Intent(getApplicationContext(), TodoDetails.class);
        startActivity(i);
    }
}