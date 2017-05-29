package com.example.rupal.matrev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.id;
import static com.example.rupal.matrev.R.id.textView10;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by rupal on 08/05/2017.
 */

public class LoginActivity extends BaseActivity
{
    private String password = "Ten23";
    private EditText et;
    private Button b;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Read from the database
        myRef.child("password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                password = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

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

    /// Switch activity to the study Screen
    public void onLoginButtonClick(View view){
        Intent loginActivity = new Intent(this, MainActivity.class);
        loginActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginActivity);
        finish();
    }
}
