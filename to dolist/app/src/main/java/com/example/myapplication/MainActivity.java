package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAdd;
    private RecyclerView recyclerViewTasks;
    private List<String> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks);
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList);

        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = editTextTask.getText().toString().trim();
                if (!task.isEmpty()) {
                    addTask(task);
                    editTextTask.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Please enter a task", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void addTask(String task) {
        taskList.add(task);
        taskAdapter.notifyDataSetChanged();
    }
}
