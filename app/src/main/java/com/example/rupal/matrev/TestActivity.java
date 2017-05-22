package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    protected RadioButton rb,rb2,rb3,rb4;
    private TextView tv;
    private Button b4;
    private int counter = 1, points = 0;

    List<Question> questions = new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setRadioButtons();
        tv = (TextView) findViewById(R.id.textView5);


        questions.add(new Question("", "", "", "", 2));
        questions.add(new Question("", "", "", "", 0));
        questions.add(new Question("", "", "", "", 3));
    }

    //to disable returning previous questions
    @Override
    public void onBackPressed() {
    }

    public void goToNextQuestion(View view)
    {
        int answer = Integer.parseInt(getStringResourceByName(("qRA" + counter)));

        if (isAnswerRight(answer))
            points++;
        counter++;

        if(counter >= 10)
        {
            b4 = (Button) findViewById(R.id.button4);
            b4.setText(R.string.finishTest);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToResults();
                }
            });
        }

        setRadioButtons();
        String q0 = "q" + counter;
        String s0 = getStringResourceByName(q0);
        String q1 = "q" + counter + "a1";
        String s1 = getStringResourceByName(q1);
        String q2 = "q" + counter + "a2";
        String s2 = getStringResourceByName(q2);
        String q3 = "q" + counter + "a3";
        String s3 = getStringResourceByName(q3);
        String q4 = "q" + counter + "a4";
        String s4 = getStringResourceByName(q4);


        //TextView tw = (TextView) findViewById(R.id.pointsNumber);
        //tw.setText(points);


        tv.setText(s0);
        rb.setText(s1);
        rb2.setText(s2);
        rb3.setText(s3);
        rb4.setText(s4);
        uncheckRadioButtons();
    }

    private void goToResults()
    {
        Intent resultActivity = new Intent(this, ResultActivity.class);
        String pts = "Punkty: " + points;
        resultActivity.putExtra("points", pts);
        startActivity(resultActivity);
    }

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

        // Untick the previous chosen
        if (firstFilled != secondFilled && secondFilled != -1) {
            r.setChecked(false);
            firstFilled = secondFilled;
        }

        // Needed to not untick double clicked buttons
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

    // TODO: CHECK AFTERWARDS IF THIS METHOD WORKS RIGHT
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

    private void fillQuestions(){

    }

}