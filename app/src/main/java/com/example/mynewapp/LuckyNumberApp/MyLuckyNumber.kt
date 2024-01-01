package com.example.mynewapp.LuckyNumberApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mynewapp.R

class MyLuckyNumber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_lucky_number)
        var catch_lucky=findViewById<TextView>(R.id.catchlucky)

        var bundle:Bundle?=intent.extras
        var mycatchi=bundle?.get("dj").toString()
        catch_lucky.setText(mycatchi)

    }
}