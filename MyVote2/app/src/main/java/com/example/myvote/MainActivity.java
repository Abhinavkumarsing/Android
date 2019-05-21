package com.example.myvote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
     private EditText Name;
     private EditText Password;
     private TextView Info;
     private Button Login;
     private int Counter=5;
     private TextView userRegistration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Name=(EditText)findViewById (R.id.etName);
        Password=(EditText)findViewById (R.id.etPassword);
        Info=(TextView)findViewById (R.id.tvInfo);
        Login=(Button)findViewById (R.id.btnLogin);
        userRegistration=(TextView) findViewById (R.id.tvRegister);
        Info.setText ("No Of Atttempts Remaining:5");
        Login.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                validate (Name.getText ().toString (),Password.getText ().toString ());
            }
        });
        userRegistration.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                startActivity (new Intent (MainActivity.this,RegistrationActivity.class));
            }
        });
    }
    private void validate(String userName,String userPassword){
        if ((userName=="Abhinav")&&(userPassword=="12345")){
            Intent intent=new Intent (MainActivity.this,secondActivity.class);
             startActivity (intent);
        }else {
         Counter--;
         Info.setText ("No Of Attempts Remaining:"+String.valueOf (Counter));
         if (Counter==0){
             Login.setEnabled (false);
         }
        }
    }
}
