package com.example.mynewapp.Musicplayerfile

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.mynewapp.R
import org.w3c.dom.Text
import java.util.concurrent.TimeUnit
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes

class SecondMusicActivity : AppCompatActivity() {
   //
    var starttime=0.0
    var finaltime=0.0
    var fastforward=10000
    var backforward=10000
    var runonlyonetime=0

    //Declare all variables

    lateinit var mytitil:TextView
    lateinit var myforwbut:Button
    lateinit var myplaybut:Button
    lateinit var mybackbut:Button
    lateinit var myseek:SeekBar
    lateinit var mytime:TextView

    var mediaplayerr=MediaPlayer()

    var handler=Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_music)

        //
        mytitil=findViewById(R.id.smusictitle)
        myforwbut=findViewById(R.id.sfastforward)
        myplaybut=findViewById(R.id.splay)
        mybackbut=findViewById(R.id.sbackforward)
        myseek=findViewById(R.id.sseekbarr)
        mytime=findViewById(R.id.stimeing)


        mediaplayerr=MediaPlayer.create(this,R.raw.jaishreeram)


        myplaybut.setOnClickListener(){
            if (mediaplayerr.isPlaying){
                myplaybut.setBackgroundResource(R.drawable.playbutton)
                mediaplayerr.pause()
             }else{
                mediaplayerr.start()
                myplaybut.setBackgroundResource(R.drawable.pause)

                starttime=mediaplayerr.currentPosition.toDouble()
                finaltime=mediaplayerr.duration.toDouble()

                if (runonlyonetime == 0){
                    myseek.max=finaltime.toInt()
                    runonlyonetime=1
                }
                myseek.isClickable=false
                myseek.setProgress(starttime.toInt())
                handler.postDelayed(UpdateMyTime,100)
            }
        }
        myforwbut.setOnClickListener(){

            if (starttime<=finaltime){
                starttime=starttime+fastforward
                mediaplayerr.seekTo(starttime.toInt())

            }else{
                Toast.makeText(this,"You can't go Forword",Toast.LENGTH_SHORT).show()
            }
        }
        mybackbut.setOnClickListener(){
            if (backforward>0){
                starttime=starttime-backforward
                mediaplayerr.seekTo(starttime.toInt())

            }  else{
                Toast.makeText(this,"Can't jump Back",Toast.LENGTH_LONG).show()
            }
        }




    }



    val UpdateMyTime:Runnable=object :Runnable{
        override fun run() {
            var mycutim=mediaplayerr.currentPosition.toLong()
            var mymin=TimeUnit.MILLISECONDS.toMinutes(mycutim)
            var mysec=TimeUnit.MILLISECONDS.toSeconds(mycutim-TimeUnit.MINUTES.toMillis(mymin))

            mytime.setText(""+mymin+" Min "+mysec+" Sec")


            myseek.progress=mycutim.toInt()
            handler.postDelayed(this,100)

        }

    }
}


