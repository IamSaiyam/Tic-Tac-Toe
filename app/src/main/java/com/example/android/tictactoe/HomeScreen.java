package com.example.android.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    public void startPlay(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void startHelp(View view){
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
    public void startAbout(View view){
        Intent intent = new Intent(this, AboutUs.class);
        startActivity(intent);
    }
    public void startContact(View view){
        Intent intent = new Intent(this, ContactUs.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
    }
}