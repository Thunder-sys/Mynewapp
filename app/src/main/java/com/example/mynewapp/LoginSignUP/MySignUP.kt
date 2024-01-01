package com.example.mynewapp.LoginSignUP

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mynewapp.R

class MySignUP : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_sign_up)
        var mybut:Button=findViewById(R.id.signupbu)
        mybut.setOnClickListener(){
            var mygolog=Intent(this, MainActivity::class.java)

            startActivity(mygolog)
        }

    }
}