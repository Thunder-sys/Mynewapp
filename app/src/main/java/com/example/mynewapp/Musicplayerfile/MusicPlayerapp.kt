package com.example.mynewapp.Musicplayerfile

import android.content.res.Resources
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.style.UpdateLayout
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.mynewapp.R
import java.util.concurrent.TimeUnit

class MusicPlayerapp : AppCompatActivity() {

    // Declare Some Variables
    var starttime=0.0
    var finaltime=0.0
    var forwardtime=10000
    var backwardtime=10000
    var oneTimeOnly=0

    //Handler
    var handler:Handler=Handler()

    var mediaPlayer=MediaPlayer()
    lateinit private var mytime:TextView
    lateinit private var seekbar: SeekBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_playerapp)

        var mytitle=findViewById<TextView>(R.id.musictitle)
        mytime=findViewById(R.id.timeing)
        seekbar=findViewById(R.id.seekbarr)

        // Button Declare
        var backforw=findViewById<Button>(R.id.backforward)
        var playbut=findViewById<Button>(R.id.play)

        var fastforv=findViewById<Button>(R.id.fastforward)


        // Inintialze Media Player

         mediaPlayer=MediaPlayer.create(this,R.raw.arjanvally)

        seekbar.isClickable = false

        playbut.setOnClickListener() {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                playbut.setBackgroundResource(R.drawable.playbutton)
            } else {
                mediaPlayer.start()
                playbut.setBackgroundResource(R.drawable.pause)

                finaltime = mediaPlayer.duration.toDouble()
                starttime = mediaPlayer.currentPosition.toDouble()

                if (oneTimeOnly == 0) {
                    // check for Music Run at only first Time
                    seekbar.max = finaltime.toInt()
                    oneTimeOnly = 1

                }

                mytime.setText("" + starttime)
                seekbar.setProgress(starttime.toInt())

                handler.postDelayed(UpdateSongTime, 100)
            }
        }
        //For Give Title of Song
        mytitle.setText(""+resources.getResourceEntryName(R.raw.arjanvally))


        //For Stop the song


        fastforv.setOnClickListener(){
            var temp=starttime
            if ((temp+forwardtime)<=finaltime){
                starttime=starttime+forwardtime
                mediaPlayer.seekTo(starttime.toInt())
            }
            else{
                Toast.makeText(this,"Can't jump forward",Toast.LENGTH_LONG).show()
            }
        }
        backforw.setOnClickListener(){
            var temp=starttime
            if ((temp-backwardtime)>0){
                starttime=starttime-backwardtime
                mediaPlayer.seekTo(starttime.toInt())

        }  else{
                Toast.makeText(this,"Can't jump Back",Toast.LENGTH_LONG).show()
            }
        }

    }
    //Create the Runnable
    val UpdateSongTime:Runnable=object :Runnable{
        override fun run() {
            //Update Time
            starttime=mediaPlayer.currentPosition.toDouble()
            val mymin=TimeUnit.MILLISECONDS.toMinutes(starttime.toLong())
            val mysecon=TimeUnit.MILLISECONDS.toSeconds(starttime.toLong()-TimeUnit.MINUTES.toMillis(mymin))
            mytime.setText(""+mymin+" Min "+mysecon+" Sec")

           /* mytime.text=""+
                    String.format(
                        "%d Min, %d Sec",
                        TimeUnit.MILLISECONDS.toMinutes(starttime.toLong()),

                        TimeUnit.MILLISECONDS.toSeconds(starttime.toLong()-TimeUnit.MINUTES.toSeconds(
                            TimeUnit.MILLISECONDS.toMinutes(
                                starttime.toLong()
                            )
                        ))
                    )*/
            seekbar.progress=starttime.toInt()
            handler.postDelayed(this,100)
        }
    }
}