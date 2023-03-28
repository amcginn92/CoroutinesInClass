package com.example.coroutinesinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {



    val timerHandler = Handler(Looper.getMainLooper()){
        countDownTimer.text = it.what.toString()

        true
    }
    val countDownTimer: TextView by lazy{
        findViewById(R.id.countDownTimer)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        Thread{
            for(i in 100 downTo 1){
                Log.d("Countdown", i.toString())
                Thread.sleep(1000)
//                val msg = Message.obtain()  //obtain from pool
//
//                msg.what = i    //put information into object
//
//                timerHandler.sendMessage(msg)   //send the handler
//                //puts on main thread
                timerHandler.sendEmptyMessage(i)    //shorthand
            }
        }.start()



    }
}