package com.example.thefitlab01

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.thefitlab01.databinding.ActivityMain3Binding

class MainActivity3: AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        val bottom_down = AnimationUtils.loadAnimation(this,R.anim.bottom_down)
        binding.linearLayout.animation = bottom_down

        var hander  = Handler()
        var runnable = Runnable{

            binding.waterbutton1555.animation=fade_in
            binding.waterbutton15.animation=fade_in
            binding.waterbutton1.animation=fade_in
            binding.waterbutton155.animation=fade_in
            binding.cardView3.animation=fade_in
            binding.cardView2.animation=fade_in



        }
        hander.postDelayed(runnable,1000)
        binding.waterbutton1.setOnClickListener {
            val intent = Intent(this, Yoga::class.java)

            startActivity(intent)
        }
        binding.waterbutton155.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)

            startActivity(intent)
        }
        binding.waterbutton15.setOnClickListener {
            val intent = Intent(this, resis::class.java)

            startActivity(intent)
        }
        binding.waterbutton1555.setOnClickListener {
            val intent = Intent(this, Fullbody::class.java)

            startActivity(intent)
        }


    }

}

