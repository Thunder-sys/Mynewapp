package com.example.mynewapp.Dashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.mynewapp.LuckyNumberApp.LuckyNumberDashboard
import com.example.mynewapp.Musicplayerfile.MusicPlayerapp
import com.example.mynewapp.Musicplayerfile.SecondMusicActivity
import com.example.mynewapp.MyCalculator.Calculationpoint
import com.example.mynewapp.R
import com.example.mynewapp.VideoPlayer.VideoActivity
import org.w3c.dom.Text

class StatusActi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)

        //Declare Textview and Button
        var myapnm=findViewById<TextView>(R.id.appname)
        var mystatusbutton=findViewById<Button>(R.id.butstatus)

        // We Create Bundle with their address
        var bundle:Bundle?=intent.extras
        var getmyv=bundle?.get("mycalcuname").toString()
        var getstus=bundle?.get("mycalcustuatus").toString()

        // Set Text in TextView and Button View
        myapnm.setText(getmyv)
        mystatusbutton.setText(getstus)

        // Click on MyStatus Button
        mystatusbutton.setOnClickListener(){

            //Check Condition if getmyv == App Name
            if (getmyv=="CALCULATOR"){
                var intent=Intent(this,Calculationpoint::class.java)
                startActivity(intent)
            }else if (getmyv=="LUCKY APP"){
                var intent=Intent(this,LuckyNumberDashboard::class.java)
                startActivity(intent)
            }
            else if (getmyv=="Music App"){
                var intent=Intent(this,MusicPlayerapp::class.java)
                startActivity(intent)
            }
            else if (getmyv=="Video App"){
                var intent=Intent(this,VideoActivity::class.java)
                startActivity(intent)
            }

        }

    }
}