package com.example.myvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name =(EditText)findViewById (R.id.idtd);
        Password=(EditText)findViewById (R.id.passtd);
        Info=(TextView)findViewById (R.id.tvinfo);
        Login=(Button)findViewById (R.id.btnlogin);
        Info.setText ("no of attempts remaining :5");

        Login.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                validate (Name.getText ().toString (),Password.getText ().toString ());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if ((userName.equals( "Abhinav"))&&(userPassword.equals ("12345"))) {
            Intent intent = new Intent (MainActivity.this, SecondActivity.class);
            startActivity (intent);
        }
        else{
            Counter--;
            Info.setText ("no of attempts remaining"+String.valueOf (Counter));
            if (Counter==0){
                Login.setEnabled (false);
            }
        }
    }
}
