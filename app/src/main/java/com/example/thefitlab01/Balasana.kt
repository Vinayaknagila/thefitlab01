package com.example.thefitlab01

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class Balasana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balasana)
        var start = findViewById<Button>(R.id.buttonsignup)
        val videoView = findViewById<VideoView>(R.id.videoView10)

        // Get the video file from the raw resources
        val videoPath = "android.resource://" + packageName + "/" + R.raw.ustravid

        // Set the video URI and create a media controller
        val videoUri = Uri.parse(videoPath)
        videoView.setVideoURI(videoUri)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Start the video
        videoView.start()
        start.setOnClickListener {
            val  intent = Intent(this, Timer::class.java)

            startActivity(intent)
        }
    }
}