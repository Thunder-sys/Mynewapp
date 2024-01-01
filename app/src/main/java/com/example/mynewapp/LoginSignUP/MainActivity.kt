package com.example.mynewapp.LoginSignUP

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mynewapp.R

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mylogi=findViewById<Button>(R.id.loginbuto)
        mylogi.setOnClickListener(){
            var inte=Intent(this, MySignUP::class.java)
            startActivity(inte)
        }


    }
}