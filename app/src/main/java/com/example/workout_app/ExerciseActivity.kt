package com.example.workout_app

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout_app.databinding.ActivityExerciseBinding
import com.example.workout_app.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_exercise.*
import kotlinx.android.synthetic.main.custom_dialog.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding: ActivityExerciseBinding?=null

    private var restTimer:CountDownTimer?=null
    private var restProgress=0

    private var exerciseTimer1:CountDownTimer?=null
    private var exerciseRest=0

    private var exerciseList:ArrayList<ExerciseLists>?=null

    private var currtPos=-1

    private var tts:TextToSpeech?=null

    private var player: MediaPlayer? =null

    private var exerciseAdaptor:ExerciseStatusAdaptor?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding= ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        exerciseList=Constants.exerciselistmodel()

        tts= TextToSpeech(this,this)
        setSupportActionBar(binding?.toolBarExercise)

        if(supportActionBar!=null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolBarExercise?.setNavigationOnClickListener{


            customDialog()



        }



        resetProgressTimer()

        setupExerciseRecyclerView()




    }

    fun resetProgressTimer(){



        try{

            val soundURI=(Uri.parse(
                "android.resource://com.example.workout_app/"+R.raw.press_start))

            player=MediaPlayer.create(applicationContext,soundURI)

            player?.isLooping=false
            player?.start()

        }
        catch (e:Exception){
            e.printStackTrace()
        }
        binding?.flProgressBar?.visibility= View.VISIBLE
        binding?.readyText?.visibility=View.VISIBLE
        binding?.tvExercise?.visibility=View.INVISIBLE
        binding?.flProgressExercise?.visibility=View.INVISIBLE
        binding?.imgview?.visibility=View.INVISIBLE
        binding?.upcomingExercise?.visibility=View.VISIBLE
        binding?.exerciseName?.visibility=View.VISIBLE


        if(restTimer!=null){

            restTimer?.cancel()

            restProgress=0
        }

        speaktext("Get Ready for the Upcoming exercise")
        binding?.exerciseName?.text=exerciseList!![currtPos+1].getname()


        restProgressBar()





    }





    fun ExerciseresetProgressTimer(){


        binding?.flProgressBar?.visibility= View.INVISIBLE
        binding?.readyText?.visibility=View.INVISIBLE
        binding?.tvExercise?.visibility=View.VISIBLE
        binding?.flProgressExercise?.visibility=View.VISIBLE
        binding?.imgview?.visibility=View.VISIBLE
        binding?.exerciseName?.visibility=View.INVISIBLE
        binding?.upcomingExercise?.visibility=View.INVISIBLE




        if(exerciseTimer1!=null){

            exerciseTimer1?.cancel()

            exerciseRest=0
        }

        speaktext(exerciseList!![currtPos].getname())


        binding?.imgview?.setImageResource(exerciseList!![currtPos].getImg())
        binding?.tvExercise?.text=exerciseList!![currtPos].getname()

        ExerciseSet()


    }



    fun restProgressBar(){

        binding?.progressBar?.progress=restProgress

        restTimer=object:CountDownTimer(1000,1000){
            override fun onTick(p0: Long) {
                restProgress++
                binding?.progressBar?.progress=1-restProgress
                binding?.timerTv?.text=(1-restProgress).toString()
            }

            override fun onFinish() {

               currtPos++

                exerciseList!![currtPos].setIsSelected(true)
                exerciseAdaptor!!.notifyDataSetChanged()
               ExerciseresetProgressTimer()
            }


        }.start()
    }


    fun ExerciseSet(){


        binding?.ExerciseProgressBar?.progress=exerciseRest

        exerciseTimer1=object:CountDownTimer(1000,1000){
            override fun onTick(p0: Long) {
                exerciseRest++
                binding?.ExerciseProgressBar?.progress=1-exerciseRest
                binding?.ExerciseTimerTv?.text=(1-exerciseRest).toString()
            }

            override fun onFinish() {


                if(currtPos<(exerciseList!!.size)-1) {
                    exerciseList!![currtPos].setIsSelected(false)
                    exerciseList!![currtPos].setIsCompleted(true)
                    exerciseAdaptor!!.notifyDataSetChanged()
                    resetProgressTimer()
                }

                else{
                    Log.i("Hello","g")

                    finish()
                    val intent= Intent(this@ExerciseActivity,FinsihActivity::class.java)
                    startActivity(intent)



                }

            }


        }.start()
    }


    override fun onInit(p0: Int) {

        if(p0==TextToSpeech.SUCCESS){

            val result=tts!!.setLanguage(Locale.US)

            if(result==TextToSpeech.LANG_MISSING_DATA||result==TextToSpeech.LANG_NOT_SUPPORTED){

                Log.e("TTS","The Language is not supported")
            }
        }
        else{
            Log.e("TTS","Initialization Failed")
        }

    }

    fun speaktext(text:String){
      if(tts!!.toString().isEmpty()){

          Toast.makeText(this,"No Text to speak",Toast.LENGTH_LONG).show()
      }
        else {
          tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
      }
    }

    fun setupExerciseRecyclerView(){

        rv_exercise.layoutManager=LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,false)
        exerciseAdaptor= ExerciseStatusAdaptor(exerciseList!!,this)

        rv_exercise.adapter=exerciseAdaptor
    }


    fun customDialog(){

        val customDialog= Dialog(this)

        customDialog.setContentView(R.layout.custom_dialog)
        customDialog.tvYes.setOnClickListener{

            finish()
            customDialog.dismiss()
        }


        customDialog.tvNo.setOnClickListener{
            customDialog.dismiss()
        }

        customDialog.show()



    }





    override fun onDestroy() {
        super.onDestroy()

        if(restTimer!=null){

            restTimer?.cancel()

            restProgress=0
        }


        if(exerciseTimer1!=null){

            exerciseTimer1?.cancel()

            exerciseRest=0
        }

        if(player!=null){

            player!!.stop()
        }

        if(tts!=null){

            tts!!.stop()
            tts!!.shutdown()
        }

        binding=null
    }

}