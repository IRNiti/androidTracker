package com.example.ralucaniti.weighttracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String USER_INPUT = "com.example.myfirstapp.WEIGHT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveInput(View view){
        Intent intent = new Intent(this, SaveWeight.class);
        EditText input = (EditText) findViewById(R.id.editText);
        String weightInput = input.getText().toString();
        int weight = Integer.parseInt(weightInput);
        intent.putExtra(USER_INPUT, weight);
        startActivity(intent);
    }
}
