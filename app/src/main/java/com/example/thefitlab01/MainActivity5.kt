package com.example.thefitlab01

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.example.thefitlab01.databinding.ActivityMain5Binding


class MainActivity5 : AppCompatActivity(),SensorEventListener {
    private lateinit var binding: ActivityMain5Binding


    private var sensorManager : SensorManager?=null
    private var running = false
    private var totalSteps = 0f
    private var previousSteps =0f
    private var currentsteps =0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        loaddata()
        resetSteps()
        binding.steptarget.setOnClickListener{
            val intent = Intent(this@MainActivity5 , SetTarget::class.java)
            startActivity(intent)
        }
        binding.exerbutton1.setOnClickListener {
            val intent = Intent(this@MainActivity5 , MainActivity3::class.java)
            startActivity(intent)
        }
        binding.waterbutton.setOnClickListener {
            val intent = Intent(this@MainActivity5 , waterReminder::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        running = true
         val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepSensor==null){
            Toast.makeText(this,"Sensor not found",Toast.LENGTH_SHORT).show()

        }
        else{
            sensorManager?.registerListener(this,stepSensor,SensorManager.SENSOR_DELAY_NORMAL)

        }
    }

    override fun onSensorChanged(event: SensorEvent) {
        if (running) {
            totalSteps = event.values[0]
            currentsteps = totalSteps - previousSteps


            binding.stepstaken.text = ("$currentsteps")
            binding.circularbar.apply {
                setProgressWithAnimation(currentsteps)
            }
            val intent = intent
            if (intent != null) {
                if (intent.hasExtra("TARGET_VALUE")) {
                    val targetValue = intent.getIntExtra("TARGET_VALUE", 0).toFloat()
                    binding.circularbar.apply {
                        progressMax = targetValue
                    }

                }


            }

        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
   private fun resetSteps(){
       binding.stepstaken.setOnClickListener{
           Toast.makeText(this,"Long press to reset",Toast.LENGTH_SHORT).show()

       }
       binding.stepstaken.setOnLongClickListener{
           previousSteps =totalSteps
           binding.stepstaken.text=0.toString()
           binding.circularbar.progress= 0F
           savedata()
           true
       }

    }
    private fun savedata(){
        val sharedPreferences = getSharedPreferences("thefitlab01", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1",previousSteps)
        editor.apply()
    }
    private fun loaddata(){
        val sharedPreferences = getSharedPreferences("thefitlab01", Context.MODE_PRIVATE)
        val savednumber = sharedPreferences.getFloat("key1", 0F)
        Log.d("MainActivity5","$savednumber")
        previousSteps = savednumber

    }
}