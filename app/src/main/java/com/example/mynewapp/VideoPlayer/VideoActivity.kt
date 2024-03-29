package com.example.mynewapp.VideoPlayer

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.example.mynewapp.R

class VideoActivity : AppCompatActivity() {
    lateinit var nextvedio:Button
    lateinit var previousvedio:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)


        // Run video from Local Storage
        val videovi=findViewById<VideoView>(R.id.frommymob)
        val mediaController=MediaController(this)

        nextvedio = findViewById(R.id.vedio_next)
        previousvedio = findViewById(R.id.vedio_previous)


            videovi.setVideoPath("android.resource://"+packageName+"/"+R.raw.lionvideo)

            mediaController.setAnchorView(videovi)
            mediaController.setMediaPlayer(videovi)
            videovi.setMediaController(mediaController)
            videovi.start()


        // Video from Web
        val videosecvi=findViewById<VideoView>(R.id.frommyweb)
        val uri= Uri.parse("https://static.videezy.com/system/resources/previews/000/037/800/original/WH054.mp4")
        videosecvi.setVideoURI(uri)

        // Media Controller
        val mediaController2=MediaController(this)


        mediaController2.setAnchorView(videosecvi)
        mediaController2.setMediaPlayer(videosecvi)
        videosecvi.setMediaController(mediaController2)
        videosecvi.start()

    }
}