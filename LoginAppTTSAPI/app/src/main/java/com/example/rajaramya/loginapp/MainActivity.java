package com.example.rajaramya.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        LoginFunc();
    }
    public void LoginFunc(){
        username = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.editText2);
        loginbtn = (Button)findViewById(R.id.button);
        loginbtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                public void onClick(View v){
                        if(username.getText().toString().equals("username")&&password.getText().toString().equals("password")){
                            Toast.makeText(MainActivity.this,"user and password are correct",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.rajaramya.loginapp.UserInteractionActivity");
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this,"user and password are incorrect",Toast.LENGTH_SHORT).show();
                        }

                    }


                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
