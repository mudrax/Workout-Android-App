package com.mudrax.new7minuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toast
import com.mudrax.new7minuteworkout.databinding.ActivityBmiBinding
import com.mudrax.new7minuteworkout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding ?= null// step 1 ... step 0 is to make viewBinding true in gradle project

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)// step 2

        //setContentView(R.layout.activity_main) changes to ->
        setContentView(binding?.root)// step 3

        //val btn: FrameLayout = findViewById(R.id.flStart) changes to ->
        binding?.flStart?.setOnClickListener{
            val intent = Intent(this , ExerciseActivity::class.java)
            startActivity(intent)

        }
        binding?.flBMI?.setOnClickListener{
            val intent = Intent(this , BMI::class.java)
            startActivity(intent)

        }

    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null// step 5-> final step to deallocate memory used for binding
    }
}