package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    protected RadioButton rb,rb2,rb3,rb4;

    List<Question> questions = new ArrayList<Question>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        setRadioButtons();


        questions.add(new Question("", "", "", "", 2));
        questions.add(new Question("", "", "", "", 0));
        questions.add(new Question("", "", "", "", 3));
    }

    //to disable returning previous questions
    @Override
    public void onBackPressed() {
    }

    public void goToQuestion2(View view)
    {
        setContentView(R.layout.activity_test2);
        setRadioButtons();
    }

    public void goToQuestion3(View view)
    {
        setContentView(R.layout.activity_test3);
        setRadioButtons();
    }

    // Fills rb's every time new activity opens
    private void setRadioButtons(){
        rb = (RadioButton) findViewById(R.id.radioButton);
        rb2 = (RadioButton) findViewById(R.id.radioButton2);
        rb3 = (RadioButton) findViewById(R.id.radioButton3);
        rb4 = (RadioButton) findViewById(R.id.radioButton4);
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
    private boolean isAnswerRight(int questionId){

        int right = questions.get(questionId).rightId;

        switch (right) {
            case 0: if (rb.isChecked()) return true;
                break;
            case 1: if (rb2.isChecked()) return true;
                break;
            case 2: if (rb3.isChecked()) return true;
                break;
            case 3: if (rb4.isChecked()) return true;
                break;
            default: return false;
        }

        return false;
    }

    private void fillQuestions(){

    }

}