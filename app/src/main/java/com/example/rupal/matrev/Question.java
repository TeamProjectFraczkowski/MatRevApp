package com.example.rupal.matrev;

/**
 * Created by itach on 15.05.2017.
 */

public class Question {
    public String[] questions;
    public int rightId;

    // Constructor
    public  Question(){
        questions = new String[4];
    }

    // Constructor with filling questions, "right" should be 0-3
    public Question(String answer1, String answer2, String answer3, String answer4, int right){

        questions = new String[4];

        questions[0] = answer1;
        questions[1] = answer2;
        questions[2] = answer3;
        questions[3] = answer4;

        rightId = right;
    }


}