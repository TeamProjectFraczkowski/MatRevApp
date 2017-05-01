package com.example.rupal.matrev;

/**
 * Created by Paulina on 01.05.2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

    }

    /// Switch activity to topic 1
    public void onTopic1ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopicActivity.class);
        startActivity(topic1Activity);
    }
}

