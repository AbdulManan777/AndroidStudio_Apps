package com.example.workout_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.workout_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        binding?.btnStart?.setOnClickListener{

            val intent=Intent(this, ExerciseActivity::class.java)

            startActivity(intent)
        }

        binding?.llBMI?.setOnClickListener{

            val intent=Intent(this,BMI_Activity::class.java)
            startActivity(intent)
        }

        binding?.llHistory?.setOnClickListener{

            val intent=Intent(this,HistoryActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onDestroy() {
        super.onDestroy()

        binding=null
    }
}