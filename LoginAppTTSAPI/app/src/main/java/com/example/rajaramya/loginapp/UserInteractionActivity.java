package com.example.rajaramya.loginapp;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class UserInteractionActivity extends AppCompatActivity {
    TextToSpeech ttsobject;
    String text;
    EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        e = (EditText)findViewById(R.id.editText3);
        ttsobject = new TextToSpeech(UserInteractionActivity.this,new TextToSpeech.OnInitListener(){
            @Override
        public void onInit(int status){
                if(status == TextToSpeech.SUCCESS){
                    ttsobject.setLanguage(Locale.UK);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported in device",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    public void speaking(View v){
        text = e.getText().toString();
        ttsobject.speak(text, TextToSpeech.QUEUE_FLUSH,null);

    }

}
