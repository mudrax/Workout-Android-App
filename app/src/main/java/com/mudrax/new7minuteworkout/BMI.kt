package com.mudrax.new7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.mudrax.new7minuteworkout.databinding.ActivityBmiBinding

class BMI : AppCompatActivity() {
    private var binding: ActivityBmiBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //step 1
        setSupportActionBar(binding?.tbBmi)//layout starts supporting toolbar
        //making a back button

        if(supportActionBar!=null)
        {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.title = "CALCULATE BMI"
        }//step 2 of back button

        binding?.tbBmi?.setNavigationOnClickListener{
            onBackPressed()
        }//step 1 : what function back button will do

        binding?.rgBmi?.setOnCheckedChangeListener { _, checkedId:Int ->
            if(checkedId == R.id.rb_leftMetric)
            {
                resetData()
                binding?.etHeight?.hint = "HEIGHT( in cm )"
                binding?.etWeight?.hint = "WEIGHT( in kg )"
            }
            else
            {
                resetData()
                binding?.etHeight?.hint = "HEIGHT( in inches )"
                binding?.etWeight?.hint = "WEIGHT( in lbs )"
            }

        }


        binding?.btnCalculate?.setOnClickListener{

            if(binding?.etHeight?.text.toString()?.isEmpty() || binding?.etWeight?.text.toString().isEmpty())
            {
                Toast.makeText(this, "Please Enter a Valid Input", Toast.LENGTH_SHORT).show()
            }
            else
            {
                // radioButtons are not clicked and checked by onclick Listner rather we use setOnCheckedChangeListner
                binding?.rgBmi?.setOnCheckedChangeListener { _, checkedId:Int ->
                    if(checkedId == R.id.rb_leftMetric)
                    {
                        metricSystemBMICalculation()
                    }
                    else
                    {
                        usSystemBMICalculation()
                    }

                }

            }

        }




    }

    fun resetData()
    {
        binding?.etHeight?.setHint(null)
        binding?.etWeight?.setHint(null)
    }

    fun metricSystemBMICalculation()
    {
        binding?.tvBmiDesc?.visibility = View.VISIBLE
        binding?.tvBmiCalculated?.visibility = View.VISIBLE
        binding?.tvYourBmi?.visibility = View.VISIBLE


        val stringHeight = binding?.etHeight?.text.toString()
        val floatHeight = (stringHeight.toFloat())/100

        val stringWeight = binding?.etWeight?.text.toString()
        val floatWeight = stringWeight.toFloat()

        val bmiCalculation = floatWeight / (floatHeight*floatHeight)

        binding?.tvBmiCalculated?.text = bmiCalculation.toString()

        when{
            (bmiCalculation>0 && bmiCalculation<18.5)->{
                binding?.tvBmiDesc?.text = "Underweight 😞 You should focus on maintaining more Mass"
            }
            (bmiCalculation in 18.5..24.9)->{

                binding?.tvBmiDesc?.text = "Normal 😃 !! Congratulations,Now the key is to maintain the Body"
            }
            (bmiCalculation in 25.0..29.9)->{

                binding?.tvBmiDesc?.text = "Overweight, Work hard and eat Good and most importantly Be Active ☺"
            }
            (bmiCalculation in 30.0..34.5)->{

                binding?.tvBmiDesc?.text = "Obese  😣 Exercise hard and Controlling the Diet is Key!  "
            }
            (bmiCalculation >=35)->{

                binding?.tvBmiDesc?.text = "Extremely Obese.. This is THE RED ALERT. But dont worry this app will help you getting Lean 😉"
            }

        }
    }

    fun usSystemBMICalculation()
    {
        binding?.tvBmiDesc?.visibility = View.VISIBLE
        binding?.tvBmiCalculated?.visibility = View.VISIBLE
        binding?.tvYourBmi?.visibility = View.VISIBLE

        val stringHeight = binding?.etHeight?.text.toString()
        val floatHeight = (stringHeight.toFloat())/100

        val stringWeight = binding?.etWeight?.text.toString()
        val floatWeight = stringWeight.toFloat()


        val bmiCalculation = (floatWeight / (floatHeight*floatHeight))*703

        binding?.tvBmiCalculated?.text = bmiCalculation.toString()

        when{
            (bmiCalculation>0 && bmiCalculation<18.5)->{
                binding?.tvBmiDesc?.text = "Underweight 😞 You should focus on maintaining more Mass"
            }
            (bmiCalculation in 18.5..24.9)->{

                binding?.tvBmiDesc?.text = "Normal 😃 !! Congratulations,Now the key is to maintain the Body"
            }
            (bmiCalculation in 25.0..29.9)->{

                binding?.tvBmiDesc?.text = "Overweight, Work hard and eat Good and most importantly Be Active ☺"
            }
            (bmiCalculation in 30.0..34.5)->{

                binding?.tvBmiDesc?.text = "Obese  😣 Exercise hard and Controlling the Diet is Key!  "
            }
            (bmiCalculation >=35)->{

                binding?.tvBmiDesc?.text = "Extremely Obese.. This is THE RED ALERT. But dont worry this app will help you getting Lean 😉"
            }

        }
    }



    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}