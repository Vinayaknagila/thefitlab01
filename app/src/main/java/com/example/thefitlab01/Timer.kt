package com.example.thefitlab01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import android.media.MediaPlayer
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView


class Timer : AppCompatActivity() {
    lateinit var textView: TextView
    private lateinit var timer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        textView = findViewById(R.id.textView24)
        var time1 = findViewById<Button>(R.id.button)
        var pause = findViewById<Button>(R.id.button2)
        var mediaPlayer : MediaPlayer = MediaPlayer.create(this, R.raw.timer)

        time1.setOnClickListener {

            mediaPlayer.start()

            // time count down for 30 seconds,
            // with 1 second as countDown interval
            timer=object : CountDownTimer(31000, 1000) {

                // Callback function, fired on regular interval
                override fun onTick(millisUntilFinished: Long) {
                    textView.setText("Seconds Remaining: " + millisUntilFinished / 1000)
                }

                // Callback function, fired
                // when the time is up
                override fun onFinish() {
                    textView.setText("done!")
                }

            }.start()
        }
        pause.setOnClickListener {

            mediaPlayer.stop()



                fun onstop(){
                    super.onStop()
                    timer.cancel()

                }
            onstop()
            }

        }






        }


