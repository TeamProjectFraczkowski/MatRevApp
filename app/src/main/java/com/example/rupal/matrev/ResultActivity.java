package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);

    }

    public void goToMainScreen(View view){
        Intent goToMainAcitivity = new Intent(this, MainActivity.class);
        startActivity(goToMainAcitivity);
    }
}
