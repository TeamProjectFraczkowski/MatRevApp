package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    //to disable returning previous questions
    @Override
    public void onBackPressed() {
    }

    public void goToQuestion2(View view)
    {
        setContentView(R.layout.activity_test2);
    }

    public void goToQuestion3(View view)
    {
        setContentView(R.layout.activity_test3);
    }

    public void nextPage(View view){
        // TODO: 23.04.2017 implement switching to another layouts
    }

    //DISCUSS

    //change the button for it
    public void seeResults(View view){
        Intent resultActivity = new Intent(this, ResultActivity.class);
        startActivity(resultActivity);
    }

    public void popupConfirmation(View view) {
        Intent popupActivity = new Intent(this, PopupActivity.class);
        startActivity(popupActivity);
    }
}
