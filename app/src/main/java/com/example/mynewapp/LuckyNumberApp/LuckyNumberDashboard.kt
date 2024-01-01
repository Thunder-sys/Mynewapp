package com.example.mynewapp.LuckyNumberApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.mynewapp.R
import kotlin.random.Random
import kotlin.random.nextInt

class LuckyNumberDashboard : AppCompatActivity() {
    lateinit var your_name:EditText
    lateinit var lucy_button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky_number_dashboard)

        //lucky of variables
        your_name=findViewById(R.id.yourname)
        lucy_button=findViewById(R.id.luckybutton)

        lucy_button.setOnClickListener(){

            var gettextf=your_name.text.toString()


            if(gettextf==""){
                your_name.setError("Enter Your Name")
            }else{
                var random=Random.nextInt(500..1000)
                var mytextle=gettextf.length
                var asciival=gettextf[0].toInt()
                var mylucge=mytextle+asciival
                var intent=Intent(this,MyLuckyNumber::class.java)
                intent.putExtra("dj",mylucge)
                startActivity(intent)

            }

        }



    }
}