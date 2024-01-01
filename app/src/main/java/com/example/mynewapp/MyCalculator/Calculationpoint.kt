package com.example.mynewapp.MyCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mynewapp.R

class Calculationpoint : AppCompatActivity() {
    public lateinit var kr0:Button
    public lateinit var kr1:Button
    public lateinit var kr2:Button
    public lateinit var mywr:TextView
    public lateinit var tempva:TextView

    var myv=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculationpoint)
        kr0 = findViewById<Button>(R.id.fr0)
        kr1 = findViewById<Button>(R.id.fr1)
        kr2 = findViewById<Button>(R.id.fr2)

        // Top Three Text View
        mywr = findViewById<TextView>(R.id.writnum)
        tempva = findViewById<TextView>(R.id.currv)
        var mrse = findViewById<TextView>(R.id.result)


/*
        var currenval = 0
        var prevv = 0*/

        // Three Buttons equl, Plus
        var myequl=findViewById<Button>(R.id.equl)
        var addk = findViewById<Button>(R.id.add)





        // first take variable
        var myadv=0
        myequl.setOnClickListener(){
            myadv==1
            Toast.makeText(this,"You Enter on Add Button",Toast.LENGTH_SHORT).show()
        }


        do {
            var myholdval=""
            var mytempval=""

            kr0.setOnClickListener(){
                var myzr="0"
                myholdval=myholdval+myzr
                mytempval=mytempval+myzr
                mywr.setText(myholdval)
                tempva.setText(mytempval)


            }
            kr1.setOnClickListener(){
                var myzr="1"
                myholdval=myholdval+myzr
                mytempval=mytempval+myzr
                mywr.setText(myholdval)
                tempva.setText(mytempval)
            }
            kr2.setOnClickListener(){
                var myzr="2"
                myholdval=myholdval+myzr
                mytempval=mytempval+myzr
                mywr.setText(myholdval)
                tempva.setText(mytempval)

            }
            addk.setOnClickListener(){
                var mytktmv=tempva.text.toString().toInt()
                var mytkre=mrse.text.toString().toInt()
                var sumi=mytktmv+mytkre

                mrse.setText(""+sumi)

                var myzr="+"
                myholdval=myholdval+myzr
                mywr.setText(myholdval)
                mytempval=""

            }
        }while (myadv==1)





        /*var mystiv=""
        var mycli= ""



        do {

            mystiv = ""
            mycli = ""

            kr0.setOnClickListener() {
                var myvl = "0"
                mystiv = mystiv + myvl
                mycli = mycli + myvl
                mywr.setText(mystiv)
            }
            kr1.setOnClickListener() {
                var myvl = "1"
                mystiv = mystiv + myvl
                mycli = mycli + myvl
                mywr.setText(mystiv)
            }


        } while (myv==1)
        tempva.setText("")
        addk.setOnClickListener(){


            myv==1


            mywr.setText(mystiv)
            var mypren=mywr.text.toString()


            tempva.setText(mystiv)

            var addv=mrse.text.toString().toInt()
            var prev=tempva.text.toString().toInt()
            var myva=addv+prev
            mrse.setText(""+myva)
           

        }

   *//*     fun operator(currenval:Int,prevv:Int){
            
        }*//*

    }
    fun myadd(){

    }
*/


    }

}
