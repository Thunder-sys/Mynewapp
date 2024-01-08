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
    lateinit private var previous:Button
    lateinit private var Next:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_playerapp)

        var mytitle=findViewById<TextView>(R.id.musictitle)
        mytime=findViewById(R.id.timeing)
        seekbar=findViewById(R.id.seekbarr)
        previous=findViewById(R.id.music_previous)
        Next=findViewById(R.id.music_Next)

        // Button Declare
        var backforw=findViewById<Button>(R.id.backforward)
        var playbut=findViewById<Button>(R.id.play)

        var fastforv=findViewById<Button>(R.id.fastforward)


        // Inintialze Media Player



        seekbar.isClickable = false


        previous.setOnClickListener(){
            mediaPlayer=MediaPlayer.create(this,R.raw.arjanvally)

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
        }
        Next.setOnClickListener(){
            mediaPlayer=MediaPlayer.create(this,R.raw.jaishreeram)

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
        }
        //For Give Title of Song
        mytitle.setText(""+resources.getResourceEntryName(R.raw.arjanvally))


        //For Stop the song
        fastforv.setOnClickListener(){
            starttime=mediaPlayer.currentPosition.toDouble()
            if (starttime>=0){
                starttime=starttime+forwardtime
                seekbar.setProgress(starttime.toInt())
                mediaPlayer.seekTo(starttime.toInt())
            }
            else{
                Toast.makeText(this,"Can't jump forward",Toast.LENGTH_LONG).show()
            }
        }
        backforw.setOnClickListener(){
            starttime=mediaPlayer.currentPosition.toDouble()
            if (starttime>=0){
                starttime=starttime-backwardtime
                seekbar.setProgress(starttime.toInt())
                mediaPlayer.seekTo(starttime.toInt())
            }
        }

    }
    //Create the Runnable
    val UpdateSongTime:Runnable=object :Runnable{
        override fun run() {
            var mytimec =mediaPlayer.currentPosition.toLong()
            var mymin=TimeUnit.MILLISECONDS.toMinutes(mytimec)
            var mysec=TimeUnit.MILLISECONDS.toSeconds(mytimec-TimeUnit.MINUTES.toMillis(mymin))


            if (mysec<10) {
                mytime.setText("0" + mymin + ":0" + mysec)
            }
            else if (mymin<10){
                mytime.setText("0" + mymin + ":" + mysec)
            }
            else{
                mytime.setText("" + mymin + ":" + mysec)
            }


            seekbar.progress=mytimec.toInt()
            handler.postDelayed(this,100)
        }
    }
}