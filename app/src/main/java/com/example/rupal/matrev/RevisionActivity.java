package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by rupal on 23/04/2017.
 */

public class RevisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revision);
    }

    public void onTopic1ButtonClick(View view){
        Intent topic1Activity = new Intent(this, RevisionTopicActivity.class);
        startActivity(topic1Activity);
    }
}
