package com.example.thefitlab01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.thefitlab01.databinding.ActivityMain4Binding
import com.example.thefitlab01.databinding.ActivityMain5Binding


class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)


            binding.waterbutton155.setOnClickListener {
                val intent = Intent(this, ToeTouch::class.java)

                startActivity(intent)
            }
            binding.waterbutton1555.setOnClickListener {
                val intent = Intent(this, Plank::class.java)

                startActivity(intent)
            }
            binding.waterbutton1.setOnClickListener {
                val intent = Intent(this, Bridge::class.java)

                startActivity(intent)
            }
            binding.waterbutton15.setOnClickListener {
                val intent = Intent(this, Squats::class.java)

                startActivity(intent)
            }
        }
    }
