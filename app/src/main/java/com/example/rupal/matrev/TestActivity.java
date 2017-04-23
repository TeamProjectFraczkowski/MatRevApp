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


    public void nextPage(View view){
        // TODO: 23.04.2017 implement switching to another layouts
    }

    public void seeResults(View view){
        Intent resultActivity = new Intent(this, ResultActivity.class);

        startActivity(resultActivity);
    }
}
