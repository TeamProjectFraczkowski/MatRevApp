package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by rupal on 23/04/2017.
 */

public class RevisionActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revision);
    }

    public void onTopic1ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic1Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic2ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic2Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic3ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic3Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic4ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic4Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic5ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic5Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic6ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic6Activity.class);
        startActivity(topicActivity);
    }

    public void onTopic7ButtonClick(View view){
        Intent topicActivity = new Intent(this, RevisionTopic7Activity.class);
        startActivity(topicActivity);
    }
}
