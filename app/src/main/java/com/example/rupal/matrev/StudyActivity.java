package com.example.rupal.matrev;

/**
 * Created by Paulina on 01.05.2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class StudyActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

    }

    /// Switch activity to topic 1
    public void onTopic1ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopicActivity.class);
        startActivity(topic1Activity);
    }

    public void onTopic2ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic2Activity.class);
        startActivity(topic1Activity);
    }

    public void onTopic3ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic3Activity.class);
        startActivity(topic1Activity);
    }

    public void onTopic4ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic4Activity.class);
        startActivity(topic1Activity);
    }

    public void onTopic5ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic5Activity.class);
        startActivity(topic1Activity);
    }

    public void onTopic6ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic6Activity.class);
        startActivity(topic1Activity);
    }

    public void onTopic7ButtonClick(View view){
        Intent topic1Activity = new Intent(this, StudyTopic7Activity.class);
        startActivity(topic1Activity);
    }
}

