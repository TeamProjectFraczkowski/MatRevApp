package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /// Switch activity to the test Screen
    public void onTestButtonClick(View view){
        Intent testActivity = new Intent(this, TestActivity.class);
        startActivity(testActivity);
    }

    /// Switch activity to the revision screen
    public void  onRevisionButtonClick(View view){
        Intent revisionActivity = new Intent(this, RevisionActivity.class);
        startActivity(revisionActivity);
    }
}
