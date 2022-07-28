package com.example.workout_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_finsih.*
import java.text.SimpleDateFormat
import java.util.*

class FinsihActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finsih)


        setSupportActionBar(toolbar_finsih)

        val actionbar=supportActionBar

        if(actionbar!=null){

            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title="Finished Exercise"
        }

        toolbar_finsih.setNavigationOnClickListener{

            onBackPressed()
        }

        btnFinish.setOnClickListener {
            finish()
        }

        storeinDB()
    }


    fun storeinDB(){

        val calender= Calendar.getInstance()
        val dateTime=calender.time
        Log.i("DATE "," " +dateTime)
        val sdf= SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.getDefault())

        val date=sdf.format(dateTime)

        val dbHandler=SqlLiteOpenHelper(this,null)

        dbHandler.addDate(date)

        Log.i("DATE"," "+"ADDED SUCCESSFULLY")
    }




}