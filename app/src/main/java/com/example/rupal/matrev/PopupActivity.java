package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by rupal on 14/05/2017.
 */

public class PopupActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_abandon_confirmation);
    }

    public void stayThere(View view) {
        super.onBackPressed();
    }

    public void gotoMainScreenAgain(View view) {
        Intent goToMainScreenActivity = new Intent(this, MainActivity.class);
        goToMainScreenActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(goToMainScreenActivity);
    }
}
