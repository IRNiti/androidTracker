package com.example.ralucaniti.weighttracker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    public static final String USER_INPUT = "com.example.myfirstapp.WEIGHT";
    String dataStorage = "storageFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveInput(View view){
        FileOutputStream outputStream;
        String message = "";

        Intent intent = new Intent(this, SaveWeight.class);
        EditText input = (EditText) findViewById(R.id.editText);
        String weightInput = input.getText().toString();
        String csvInput = weightInput+",";
     //   int weight = Integer.parseInt(weightInput);
        try {
            outputStream = openFileOutput(dataStorage, Context.MODE_PRIVATE);
            outputStream.write(csvInput.getBytes());
            outputStream.close();
            message = "Input succesfully saved";
        } catch(Exception e){
            message = "There was an error saving value";
            e.printStackTrace();
        }

        intent.putExtra(USER_INPUT, message);
        startActivity(intent);
    }
}
