package com.example.mynewapp.Dashboard

import android.app.PendingIntent
import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.mynewapp.LuckyNumberApp.LuckyNumberDashboard
import com.example.mynewapp.Musicplayerfile.MusicPlayerapp
import com.example.mynewapp.R

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        var myluckyapp=findViewById<ImageButton>(R.id.luckimg)
        var mycalcuapp=findViewById<ImageButton>(R.id.calimg)
        var mymusicapp=findViewById<ImageButton>(R.id.musimg)
        var videoplay=findViewById<ImageButton>(R.id.videoplayera)

        mycalcuapp.setOnClickListener(){

            var myappnam="CALCULATOR"
            var mystatus="Complete"
            var intent=Intent(this,StatusActi::class.java)

            intent.putExtra("mycalcuname",myappnam)
            intent.putExtra("mycalcustuatus",mystatus)

            startActivity(intent)
        }

        myluckyapp.setOnClickListener(){

            var myappnam="LUCKY APP"
            var mystatus="Pending"
            var intent=Intent(this,StatusActi::class.java)
            intent.putExtra("mycalcuname",myappnam)
            intent.putExtra("mycalcustuatus",mystatus)

            startActivity(intent)
        }
        mymusicapp.setOnClickListener(){
            var myappnam="Music App"
            var mystatus="Pending"
            var intent=Intent(this,StatusActi::class.java)
            intent.putExtra("mycalcuname",myappnam)
            intent.putExtra("mycalcustuatus",mystatus)

            startActivity(intent)
        }
        videoplay.setOnClickListener(){
            var myappnam="Video App"
            var mystatus="Pending"
            var intent=Intent(this,StatusActi::class.java)
            intent.putExtra("mycalcuname",myappnam)
            intent.putExtra("mycalcustuatus",mystatus)

            startActivity(intent)
        }

    }
}