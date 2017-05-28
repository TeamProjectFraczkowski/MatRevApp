package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        Intent intent = getIntent();
        String pts = intent.getStringExtra("points");
        TextView tw = (TextView) findViewById(R.id.pointsNumber);
        tw.setText(pts);

    }



    public void goToMainScreen(View view){
        Intent goToMainAcitivity = new Intent(this, MainActivity.class);
        goToMainAcitivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(goToMainAcitivity);
    }
}
