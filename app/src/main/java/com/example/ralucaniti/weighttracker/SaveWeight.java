package com.example.ralucaniti.weighttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class SaveWeight extends AppCompatActivity {

    String dataStorage = "storageFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_weight);

        Intent intent = getIntent();
     //   int weight = intent.getIntExtra(MainActivity.USER_INPUT, 0);
        String message = intent.getStringExtra(MainActivity.USER_INPUT);

        TextView displayText = (TextView) findViewById(R.id.textView);
      //  displayText.setText(String.valueOf(weight));
        displayText.setText(message);

        FileInputStream inputStream;
        ArrayList values = new ArrayList();

        try{
            inputStream = openFileInput(dataStorage);
            int c;
            String temp = "";
            while((c=inputStream.read()) != -1){
                if(c == ','){
                    values.add(Integer.parseInt(temp));
                    temp = "";
                } else {
                    temp = temp + Character.toString((char) c);
                }
            }
            inputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
