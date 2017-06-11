package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestActivity extends BaseActivity {

    protected RadioButton rb,rb2,rb3,rb4;
    private TextView tv;
    protected ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    private Button b4;
    private int counter = 1, points = 0, qNumber = -1, answer = -1;
    private int[] availableNumbers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setRadioButtons();
        iv1 = (ImageView) findViewById(R.id.imageView2);
        iv2 = (ImageView) findViewById(R.id.imageView8);
        iv3 = (ImageView) findViewById(R.id.imageView9);
        iv4 = (ImageView) findViewById(R.id.imageView10);
        iv5 = (ImageView) findViewById(R.id.imageView11);
        iv6 = (ImageView) findViewById(R.id.imageView12);
        iv7 = (ImageView) findViewById(R.id.imageView13);
        iv8 = (ImageView) findViewById(R.id.imageView14);

        iv1.setVisibility(View.INVISIBLE);
        iv2.setVisibility(View.INVISIBLE);
        iv3.setVisibility(View.INVISIBLE);
        iv4.setVisibility(View.INVISIBLE);
        iv5.setVisibility(View.INVISIBLE);
        iv6.setVisibility(View.INVISIBLE);
        iv7.setVisibility(View.INVISIBLE);
        iv8.setVisibility(View.INVISIBLE);

        // TODO: Change this after increasing number of questions
        availableNumbers = new int[10];

        for (int i = 0; i < 10; i++)
        {
            availableNumbers[i] = i + 1;
        }

        tv = (TextView) findViewById(R.id.textView5);

        qNumber = getNextQuestionNumber();
        setStrings();
    }

    //to disable returning previous questions
    @Override
    public void onBackPressed() {
    }

    @Override
    public void onResume() {
        super.onResume();

        iv1.setVisibility(View.VISIBLE);
        iv2.setVisibility(View.VISIBLE);
        iv3.setVisibility(View.VISIBLE);
        iv4.setVisibility(View.VISIBLE);
        iv5.setVisibility(View.VISIBLE);
        iv6.setVisibility(View.VISIBLE);
        iv7.setVisibility(View.VISIBLE);
        iv8.setVisibility(View.VISIBLE);
    }

    public void goToNextQuestion(View view)
    {
        if (isAnswerRight(answer))
            points++;

        counter++;

        if(counter >= 10)
        {
            qNumber = getNextQuestionNumber();
            setRadioButtons();
            setStrings();
            uncheckRadioButtons();
            b4 = (Button) findViewById(R.id.button4);
            b4.setText(R.string.finishTest);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToResults();
                }
            });
        }

        else {
            qNumber = getNextQuestionNumber();
            setRadioButtons();
            setStrings();
            uncheckRadioButtons();
        }
    }

    private void setStrings()
    {
        answer = Integer.parseInt(getStringResourceByName(("qRA" + qNumber)));

        String q0 = "q" + qNumber;
        String s0 = getStringResourceByName(q0);
        String q1 = "q" + qNumber + "a1";
        String s1 = getStringResourceByName(q1);
        String q2 = "q" + qNumber + "a2";
        String s2 = getStringResourceByName(q2);
        String q3 = "q" + qNumber + "a3";
        String s3 = getStringResourceByName(q3);
        String q4 = "q" + qNumber + "a4";
        String s4 = getStringResourceByName(q4);

        tv.setText(s0);
        rb.setText(s1);
        rb2.setText(s2);
        rb3.setText(s3);
        rb4.setText(s4);
    }

    private int getNextQuestionNumber()
    {
        boolean belongs = false;
        Random rnd  = new Random();
        int num = -1, qNumber = -1;

        while (num == -1) {
            num = rnd.nextInt(11) + 1;

            for (int i = 0; i < 10; i++) {
                if (availableNumbers[i] == num) {
                    availableNumbers[i] = -1;
                    qNumber = num;

                    num = -2;
                }
            }

            if (num != -2)
                num = -1;
        }

        String str = "" + qNumber;
        Log.d("qNumber",str );
        return  qNumber;
    }

    private void goToResults()
    {
        Intent resultActivity = new Intent(this, ResultActivity.class);
        String pts = "Punkty: " + points;
        resultActivity.putExtra("points", pts);
        startActivity(resultActivity);
    }

    // Sets Checked property to false
    private void uncheckRadioButtons()
    {
        rb.setChecked(false);
        rb2.setChecked(false);
        rb3.setChecked(false);
        rb4.setChecked(false);
    }


    // Fills rb's every time new activity opens
    private void setRadioButtons(){
        rb = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
    }

    private String getStringResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }

    //change the button for it
    public void seeResults(View view){
        Intent resultActivity = new Intent(this, ResultActivity.class);
        startActivity(resultActivity);
    }

    public void popupConfirmation(View view) {
        Intent popupActivity = new Intent(this, PopupActivity.class);
        startActivity(popupActivity);
    }

    // Reacts when one of the radio buttons is pressed
    public void radio_clicked(View view) {
        checkButtons();
    }

    private boolean filled = false;
    private int firstFilled, secondFilled = -1; // -1 is needed to know when secondfilled have not been filled
    private void checkButtons()
    {
        if (filled)
        {
            fillSecond();
            clearButton();
        }

        // Works if no button is ticked
        else {
            fill();
            filled = true;
        }

    }

    // Clears previous chosen button
    private void clearButton()
    {
        RadioButton r = (RadioButton) findViewById(firstFilled);

        // Unticks the previous chosen
        if (firstFilled != secondFilled && secondFilled != -1) {
            r.setChecked(false);
            firstFilled = secondFilled;
        }

        // Unticks double clicked buttons
        else
        {
            r.setChecked(true);
        }
    }

    // Sets id of first chosen button to firstfilled
    private void fill()
    {
        if (rb.isChecked())
            firstFilled = rb.getId();
        if (rb2.isChecked())
            firstFilled = rb2.getId();
        if (rb3.isChecked())
            firstFilled = rb3.getId();
        if (rb4.isChecked())
            firstFilled = rb4.getId();
    }

    // Sets id of all but first selected radio button
    private void fillSecond()
    {
        if (rb.isChecked() && rb.getId() != firstFilled)
            secondFilled = rb.getId();
        if (rb2.isChecked() && rb2.getId() != firstFilled)
            secondFilled = rb2.getId();
        if (rb3.isChecked() && rb3.getId() != firstFilled)
            secondFilled = rb3.getId();
        if (rb4.isChecked() && rb4.getId() != firstFilled)
            secondFilled = rb4.getId();
    }

    // Returns true if answer on this page is right
    private boolean isAnswerRight(int rightId){

        switch (rightId) {
            case 1: if (rb.isChecked()) return true;
                break;
            case 2: if (rb2.isChecked()) return true;
                break;
            case 3: if (rb3.isChecked()) return true;
                break;
            case 4: if (rb4.isChecked()) return true;
                break;
            default: return false;
        }

        return false;
    }

}