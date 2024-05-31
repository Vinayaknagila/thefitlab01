package com.example.thefitlab01

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thefitlab01.databinding.ActivityMain5Binding
import com.example.thefitlab01.databinding.ActivitySetTargetBinding

class SetTarget : AppCompatActivity(){

private lateinit var binding: ActivitySetTargetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySetTargetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        val bottom_down = AnimationUtils.loadAnimation(this,R.anim.bottom_down)
        binding.topLinearLayout.animation = bottom_down

        var hander  = Handler()
        var runnable = Runnable {

            binding.cardView2.animation = fade_in
            binding.cardView.animation = fade_in
            binding.imageView.animation = fade_in
        }
        hander.postDelayed(runnable,1000)

        binding.button111.setOnClickListener {
            val settarget = binding.editTextTextPersonName200.text.toString()
            val intent = Intent(this, MainActivity5::class.java)
            intent.putExtra("TARGET_VALUE", settarget.toInt())
            startActivity(intent)
        }



    }
}