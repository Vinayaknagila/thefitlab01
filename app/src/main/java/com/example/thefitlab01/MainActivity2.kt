package com.example.thefitlab01

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils

import android.widget.Toast

import com.example.thefitlab01.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth
class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        val bottom_down = AnimationUtils.loadAnimation(this,R.anim.bottom_down)
        binding.topLinearLayout.animation = bottom_down

        var hander  = Handler()
        var runnable = Runnable{

            binding.cardView2.animation=fade_in
            binding.cardView.animation=fade_in
            binding.constraintLayout.animation=fade_in
            binding.button1.animation=fade_in



        }
        hander.postDelayed(runnable,1000)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.button1.setOnClickListener {
            val email = binding.editTextTextPersonName23.text.toString()
            val password = binding.password.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, MainActivity5::class.java)
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.buttonsignup.setOnClickListener {
            val signupIntent = Intent(this, Signup::class.java)
            startActivity(signupIntent)
        }
    }
        }










