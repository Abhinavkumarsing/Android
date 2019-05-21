package com.example.mylog;

import android.app.Activity;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener
{
    private Button MyButton;
    private String tag=MainActivity.class.getSimpleName ();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        MyButton=findViewById (R.id.button);
        MyButton.setOnClickListener (MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        Log.d (tag,"Button Clicked");

    }
}
