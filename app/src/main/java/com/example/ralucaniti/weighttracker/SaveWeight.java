package com.example.ralucaniti.weighttracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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
        String message = intent.getStringExtra(MainActivity.USER_INPUT);

        TextView displayText = (TextView) findViewById(R.id.textView);
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

        ArrayAdapter<Integer> itemsAdapter = new ArrayAdapter<Integer>(this, R.layout.list_view_item, values);
        ListView lv = (ListView) findViewById(R.id.storedValues);
        lv.setAdapter(itemsAdapter);
    }

}
