package com.example.thefitlab01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.thefitlab01.databinding.ActivityMain5Binding
import com.example.thefitlab01.databinding.ActivityResisBinding
import com.example.thefitlab01.databinding.ActivityYogaBinding


class Yoga : AppCompatActivity() {
    private lateinit var binding: ActivityYogaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.waterbutton155.setOnClickListener {
            val intent = Intent(this, Trikonasana::class.java)

            startActivity(intent)
        }
        binding.waterbutton1555.setOnClickListener {
            val intent = Intent(this, Adhomukha::class.java)

            startActivity(intent)
        }
        binding.waterbutton1.setOnClickListener {
            val intent = Intent(this, Balasana::class.java)

            startActivity(intent)
        }
        binding.waterbutton15.setOnClickListener {
            val intent = Intent(this, Shavasana::class.java)

            startActivity(intent)
        }

    }
}