package com.example.nativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] rating = { "Okay", "Good", "Excellent", "Very Good", "Perfect" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinService = (Spinner) findViewById(R.id.service_rating);
        Spinner spinCleanliness = (Spinner) findViewById(R.id.cleanliness_rating);
        Spinner spinFood = (Spinner) findViewById(R.id.food_rating);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rating);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinService.setAdapter(adapter);
        spinService.setOnItemSelectedListener(this);
        spinCleanliness.setAdapter(adapter);
        spinCleanliness.setOnItemSelectedListener(this);
        spinFood.setAdapter(adapter);
        spinFood.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), "Selected User: "+rating[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

}