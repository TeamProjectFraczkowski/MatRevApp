package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    //to disable returning previous questions
    @Override
    public void onBackPressed() {
    }

    public void goToQuestion2(View view)
    {
        setContentView(R.layout.activity_test2);
    }

    public void goToQuestion3(View view)
    {
        setContentView(R.layout.activity_test3);
    }

    public void nextPage(View view){
        // TODO: 23.04.2017 implement switching to another layouts
    }

    //DISCUSS

    //change the button for it
    public void seeResults(View view){
        Intent resultActivity = new Intent(this, ResultActivity.class);
        startActivity(resultActivity);
    }

    public void popupConfirmation(View view) {
        Intent popupActivity = new Intent(this, PopupActivity.class);
        startActivity(popupActivity);
    }

    public void radio_clicked(View view) {
        checkButtons(R.id.radioButton, R.id.radioButton2, R.id.radioButton3, R.id.radioButton4);
    }

    private boolean filled = false;

    private void checkButtons(int id1, int id2, int id3, int id4)
    {
        RadioButton rb = (RadioButton) findViewById(id1);
        RadioButton rb2 = (RadioButton) findViewById(id2);
        RadioButton rb3 = (RadioButton) findViewById(id3);
        RadioButton rb4 = (RadioButton) findViewById(id4);

        if (filled)
        {
            fillSecond(rb, rb2, rb3, rb4);
            clearButton();
        }

        else {
            fill(rb,rb2,rb3,rb4);
            filled = true;
        }

    }

    private void clearButton()
    {
            r.setChecked(false);
            firstFilled = secondFilled;
        }

    {
        if (r1.isChecked())
            firstFilled = r1.getId();
        if (r2.isChecked())
            firstFilled = r2.getId();
        if (r3.isChecked())
            firstFilled = r3.getId();
        if (r4.isChecked())
            firstFilled = r4.getId();
    }

    {
        if (r1.isChecked() && r1.getId() != firstFilled)
            secondFilled = r1.getId();
        if (r2.isChecked() && r2.getId() != firstFilled)
            secondFilled = r2.getId();
        if (r3.isChecked() && r3.getId() != firstFilled)
            secondFilled = r3.getId();
        if (r4.isChecked() && r4.getId() != firstFilled)
            secondFilled = r4.getId();
    }
}
