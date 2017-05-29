package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class OptionsActivity extends BaseActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    @Override
    public void onBackPressed()
    {
        Intent goToMainScreenActivity = new Intent(this, MainActivity.class);
        goToMainScreenActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(goToMainScreenActivity);
    }

    public void onReturnButtonClick(View view)
    {
        onBackPressed();
    }

    public void changeTheme(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId())
        {
            case R.id.checkBox:
                if(checked)
                {
                    Utils.setTheme(getApplicationContext(), 1);
                    recreateActivity();
                }
                break;
            case R.id.checkBox2:
                if(checked)
                {
                    Utils.setTheme(getApplicationContext(), 2);
                    recreateActivity();
                }
                break;
        }
    }

    public void recreateActivity()
    {
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}