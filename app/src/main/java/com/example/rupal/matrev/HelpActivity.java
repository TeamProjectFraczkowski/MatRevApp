package com.example.rupal.matrev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Paulina on 01.05.2017.
 */

public class HelpActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
    }

    public void onReturnButtonClick(View view)
    {
        super.onBackPressed();
    }
}
