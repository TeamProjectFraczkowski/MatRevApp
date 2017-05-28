package com.example.rupal.matrev;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by rupal on 27/05/2017.
 */

public class BaseActivity extends AppCompatActivity
{
    private final static int THEME_DEFAULT = 1;
    private final static int THEME_NEW = 2;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        updateTheme();
    }

    public void updateTheme()
    {
        if(Utils.getTheme(getApplicationContext()) <= THEME_DEFAULT)
        {
            setTheme(R.style.AppTheme);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            }
        }
        else if(Utils.getTheme(getApplicationContext()) == THEME_NEW)
        {
            setTheme(R.style.NewTheme);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryLight));
            }
        }
    }
}
