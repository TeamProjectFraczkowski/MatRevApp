package com.example.rupal.matrev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /// Switch activity to the study Screen
    public void onStudyButtonClick(View view){
        Intent studyActivity = new Intent(this, StudyActivity.class);
        startActivity(studyActivity);
    }

    /// Switch activity to the test Screen
    public void onTestButtonClick(View view){
        Intent testActivity = new Intent(this, TestActivity.class);
        startActivity(testActivity);
    }

    /// Switch activity to the revision screen
    public void  onRevisionButtonClick(View view){
        Intent revisionActivity = new Intent(this, RevisionActivity.class);
        startActivity(revisionActivity);
    }

    /// Switch activity to the options screen
    public void  onOptionsButtonClick(View view){
        Intent optionsActivity = new Intent(this, OptionsActivity.class);
        startActivity(optionsActivity);
    }

    /// Switch activity to the help screen
    public void  onHelpButtonClick(View view){
        Intent helpActivity = new Intent(this, HelpActivity.class);
        startActivity(helpActivity);
    }

    //to exit the app on back button in main menu
    private Boolean exit = false;
    @Override
    public void onBackPressed(){
        if (exit)
        {
            finish(); // finish activity
        }
        else
        {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
        }
    }
}
