package com.example.thefitlab01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.example.thefitlab01.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
class Signup : AppCompatActivity() {
    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fade_in = AnimationUtils.loadAnimation(this,R.anim.fade_in)
        val bottom_down = AnimationUtils.loadAnimation(this,R.anim.bottom_down)
        binding.linearLayout.animation = bottom_down

        var hander  = Handler()
        var runnable = Runnable{

            binding.cardView2.animation=fade_in
            binding.cardView.animation=fade_in
            binding.constraintLayout.animation=fade_in
            binding.button1.animation=fade_in



        }
        hander.postDelayed(runnable,1000)
        firebaseAuth = FirebaseAuth.getInstance()
        binding.button1.setOnClickListener{
            val email = binding.editTextTextPersonName25.text.toString()
            val password = binding.password1.text.toString()
            val confirmPassword = binding.conpassword.text.toString()
            if (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if (password == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, MainActivity2::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password does not matched", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.loginbutton.setOnClickListener {
            val loginIntent = Intent(this, MainActivity2::class.java)
            startActivity(loginIntent)
        }
    }
}