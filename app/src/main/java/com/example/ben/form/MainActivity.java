package com.example.ben.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText name;
    private EditText email;
    private EditText user;
    private DatePicker simpleDatePicker;
    private Button submit;
    private int AGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleDatePicker = (DatePicker) findViewById(R.id.simpleDatePicker);
        submit = (Button) findViewById(R.id.submitButton);
        // perform click event on submit button
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim().isEmpty()){
                    name.setError("Please enter your name");
                    name.requestFocus();
                } else if(email.getText().toString().trim().isEmpty()){
                    email.setError("Please enter your Email");
                    email.requestFocus();
                } else if (user.getText().toString().trim().isEmpty()){
                    user.setError("Please enter your username");
                    user.requestFocus();
                } else{
                    // get the values for day of month , day and year from a date picker
                    String day = "Day = " + simpleDatePicker.getDayOfMonth();
                    String month = "Month = " + (simpleDatePicker.getMonth() + 1);
                    String year = "Year = " + simpleDatePicker.getYear();

                    int thisYear = Calendar.getInstance().get(Calendar.YEAR);
                    int thisMonth = Calendar.getInstance().get(Calendar.MONTH);
                    int today = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                    if(thisYear - Integer.parseInt(year) ==18){
                        if(Integer.parseInt(month) <= thisMonth){
                            if (Integer.parseInt(month) <= today){
                                sendMessage();
                                AGE = 18;
                            }
                        }
                    }
                    if(thisYear-Integer.parseInt(year)>18){
                        sendMessage();
                        AGE = thisYear-Integer.parseInt(year);
                    }
                }
                name=(EditText)findViewById(R.id.name);
                email=(EditText)findViewById(R.id.email);
                user=(EditText)findViewById(R.id.user);

                Log.i(TAG, "onCreate()");
            }
        });
    }

    public void sendMessage() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.putExtra("name", name.getText().toString());
        intent.putExtra("email", email.getText().toString());
        intent.putExtra("user", user.getText().toString());
        intent.putExtra("age", AGE);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, name.getText().toString());
        outState.putString(Constants.KEY_EMAIL, email.getText().toString());
        outState.putString(Constants.KEY_USER, user.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            name.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }

        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
            email.setText((String) savedInstanceState.get(Constants.KEY_EMAIL));
        }

        if (savedInstanceState.containsKey(Constants.KEY_USER)) {
            user.setText((String) savedInstanceState.get(Constants.KEY_USER));
        }
    }
}
