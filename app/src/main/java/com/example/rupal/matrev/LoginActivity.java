package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.rupal.matrev.R.id.textView10;

/**
 * Created by rupal on 08/05/2017.
 */

public class LoginActivity extends AppCompatActivity
{
    private String password = "Ten23";
    private EditText et;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et = (EditText) findViewById(R.id.editText);
        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = et.getText().toString();
                if(checkPassword(input)){
                    onLoginButtonClick(v);
                }
            }
        });
    }
    ///check the strings for password and if its correct then to the main screen
    boolean checkPassword(String input){
        if(input.equals(password))
            return true;
        else
            return false;
    }
//        int length = 0;
//        int digit = 0;
//        int lower = 0;
//        int upper = 0;
//
//        if(input.length() > 6){
//            length = 1;
//            for(int i=0 ; i<input.length() ; i++){
//                if(isupper(input[i]))
//                    upper = 1;
//                if(islower(input[i]))
//                    lower = 1;
//                if(isdigit(input[i]))
//                    digit = 1;
//            }
//        }
//        return true;
//    }
//    int main() {
//        String password;
//
//        if (checkPassword(password)){
//            Intent loginActivity = new Intent(this, MainActivity.class);
//        }
//        else{
//            Intent loginActivity = new Intent(this, LoginActivity.class);
//        }
//        return 0;
//    }

    /// Switch activity to the study Screen
    public void onLoginButtonClick(View view){
        Intent loginActivity = new Intent(this, MainActivity.class);
        loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginActivity);
        finish();
    }
}
