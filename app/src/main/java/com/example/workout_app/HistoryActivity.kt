package com.example.workout_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)


        setSupportActionBar(toolbar_history)

        val actionbar=supportActionBar

        if(actionbar!=null){

            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.title="History"
        }

        toolbar_history.setNavigationOnClickListener{

            onBackPressed()
        }

        getAllCompletedDates()

    }

    fun getAllCompletedDates(){

        val dbHandler=SqlLiteOpenHelper(this,null)
        val allDatesList=dbHandler.getAllDates()

        if(allDatesList.size>0){

            tvHistory.visibility= View.VISIBLE
            recycle_vHistory.visibility=View.VISIBLE
            NoData.visibility=View.GONE

            recycle_vHistory.layoutManager=LinearLayoutManager(this)
            val historyAdaptor=HistoryAdaptor(allDatesList,this)

            recycle_vHistory.adapter=historyAdaptor




        }

        else{

            tvHistory.visibility= View.GONE
            recycle_vHistory.visibility=View.GONE
            NoData.visibility=View.VISIBLE


        }

    }
}