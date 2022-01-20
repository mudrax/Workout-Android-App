package com.mudrax.new7minuteworkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mudrax.new7minuteworkout.databinding.ActivityExerciseBinding
import com.mudrax.new7minuteworkout.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private var binding:ActivityResultBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //step 1
        setSupportActionBar(binding?.toolbarResult)//layout starts supporting toolbar
        //making a back button

        if(supportActionBar!=null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }//step 2 of back button

        binding?.toolbarResult?.setNavigationOnClickListener{
            onBackPressed()
        }//step 1 : what function back button will do

        binding?.btnFinish?.setOnClickListener{
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}