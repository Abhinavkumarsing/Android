package com.example.abhinav.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PrivateKey;
import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter=5;
    private Button newuser;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText) findViewById(R.id.etname);
        password = (EditText) findViewById(R.id.etpassword);
        info = (TextView) findViewById(R.id.tvinfo);
        login = (Button) findViewById(R.id.btnlogin);
        info.setText("no of attempts remaining: 5");
        newuser = (Button) findViewById(R.id.newuser);



        newuser.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this, newuser.class);
                startActivity(intent);

            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

    }


    private void validate(String userName, String userPassword){
        if((userName.equals("abhinav"))&&(userPassword.equals("12345"))){
            Intent intent =new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }else{
            counter--;
            info.setText("no of attempts remaining" + String.valueOf(counter));
            if(counter==0){
                login.setEnabled(false);
            }

        }
    }
}
