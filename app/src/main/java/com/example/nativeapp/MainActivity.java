package com.example.nativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.service.autofill.RegexValidator;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] rating = { "Okay", "Good", "Excellent", "Very Good", "Perfect" };
    EditText restaurantName, restaurantType, price, note, reporter;
    Button submit;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurantName = findViewById(R.id.restaurant_name);
        restaurantType = findViewById(R.id.restaurant_type);
        price = findViewById(R.id.price);
        note = findViewById(R.id.note);
        reporter = findViewById(R.id.reporter);
        submit = findViewById(R.id.btnSubmit);;

//check

        //        init validation
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //      add validation for restaurant Name
        awesomeValidation.addValidation(this,R.id.restaurant_name, RegexTemplate.NOT_EMPTY,R.string.invalidRestaurantName);
        awesomeValidation.addValidation(this,R.id.restaurant_type, RegexTemplate.NOT_EMPTY,R.string.invalidRestaurantName);
        awesomeValidation.addValidation(this,R.id.price, RegexTemplate.NOT_EMPTY,R.string.invalidRestaurantName);
        awesomeValidation.addValidation(this,R.id.note, RegexTemplate.NOT_EMPTY,R.string.invalidRestaurantName);
        awesomeValidation.addValidation(this,R.id.reporter, RegexTemplate.NOT_EMPTY,R.string.invalidRestaurantName);
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT).show();
                }
            }
        });
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
        Toast.makeText(getApplicationContext(), "Selected Rate: "+rating[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }



}