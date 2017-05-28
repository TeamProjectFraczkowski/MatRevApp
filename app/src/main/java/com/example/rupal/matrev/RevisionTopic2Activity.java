package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Paulina on 01.05.2017.
 */

public class RevisionTopic2Activity extends BaseActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revision2_slide1);

    }

    public void goToRevision3(View view) {
        Intent goToRev3Act = new Intent(this, RevisionTopic3Activity.class);
        startActivity(goToRev3Act);
    }
}
