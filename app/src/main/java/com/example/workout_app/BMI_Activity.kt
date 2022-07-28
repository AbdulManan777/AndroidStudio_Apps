package com.example.workout_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.activity_bmi.*
import java.lang.Math.pow
import java.math.BigDecimal
import java.math.RoundingMode

class BMI_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        setSupportActionBar(toolbar_bmi)

        val actionbar=supportActionBar

        if(actionbar!=null){

            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title="Calculate Your BMI"
        }

        toolbar_bmi.setNavigationOnClickListener{

            onBackPressed()
        }


        btnCalculateBMI.setOnClickListener {

            if(validateBMIValues()==false){

                Toast.makeText(this,"Enter the Values first please to perform calculations"
                ,Toast.LENGTH_LONG).show()
            }

            else {

                CalulcateBMI()

            }
        }

    }


    fun validateBMIValues():Boolean{

        var valid:Boolean=true

        if(etMetricUnitWeight.text.toString().isEmpty()){

            valid =false
        }

        else if(etMetricUnitHeight.text.toString().isEmpty())
            valid=false

        return valid
    }

    fun CalulcateBMI(){

        var weight:Float
        var height:Float

        weight=etMetricUnitWeight.text.toString().toFloat()
        height=etMetricUnitHeight.text.toString().toFloat()

        var bmi=weight/(height*height)

       val bmivalue=BigDecimal(bmi.toDouble()).setScale(2,RoundingMode.HALF_EVEN).toString()

        tvBMIValue.text=bmivalue

        if(bmi<=18.5){

            BMIType.text="UnderWeight"
            BMIDescription.text="You are Weak, need to work on Healthy Diet"
        }

        else if(bmi>18.5 &&bmi<=24.9){

            BMIType.text="Normal"
            BMIDescription.text="Congratulations!! You are Healthy"

        }

        else if(bmi>=25&&bmi<=29.9){

            BMIType.text="OverWeight"
            BMIDescription.text="Enough Fat!! Need to loose Weight"



        }

        else{

            BMIType.text="Obesity"
            BMIDescription.text="Very much fat"



        }

        tvYourBMI.visibility= View.VISIBLE
        tvBMIValue.visibility=View.VISIBLE
        BMIType.visibility=View.VISIBLE
        BMIDescription.visibility=View.VISIBLE


    }





}