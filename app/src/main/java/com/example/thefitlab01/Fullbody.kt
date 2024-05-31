package com.example.thefitlab01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.thefitlab01.databinding.ActivityFullbodyBinding
import com.example.thefitlab01.databinding.ActivityMain5Binding


class Fullbody : AppCompatActivity()
{    private lateinit var binding: ActivityFullbodyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityFullbodyBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.waterbutton155.setOnClickListener {
            val intent = Intent(this, BulgSquats::class.java)

            startActivity(intent)
        }
        binding.waterbutton1555.setOnClickListener {
            val intent = Intent(this, Mtnclimber::class.java)

            startActivity(intent)
        }
        binding.waterbutton1.setOnClickListener {
            val intent = Intent(this, Pushups::class.java)

            startActivity(intent)
        }
        binding.waterbutton15.setOnClickListener {
            val intent = Intent(this, ToeTouch::class.java)

            startActivity(intent)
        }
    }
}