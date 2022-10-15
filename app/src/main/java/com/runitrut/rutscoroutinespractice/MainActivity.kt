package com.runitrut.rutscoroutinespractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO SECOND TODO, start a coroutine VIA "GlobeScope.launch{}"
        /* every coroutine needs to start in a coroutine scope */
        //inside the scope, defines what the coroutines does. Asynchronously
        // suspend function can only happen within a suspend function, or by a coroutine
        GlobalScope.launch {
            // This DELAY, delays the coroutine by 3000L, or 3 seconds
            delay(3000L)
            //This log happens on a COROUTINE SCOPE
            Log.d(TAG, "Coroutines says hello form thread ${Thread.currentThread().name}" )

        }



        // This log happens on the MAIN thread, so will be EXECUTED before the coroutine
        Log.d(TAG, "Hello form thread ${Thread.currentThread().name}" )

        GlobalScope.launch{
            val networkCallerAnswer = doNetworkCall()
            val networkCallerAnswer2 = doNetworkCall2()
            Log.d(TAG, networkCallerAnswer)
            Log.d(TAG, networkCallerAnswer2)
        }

    }

    private suspend fun doNetworkCall(): String {
        delay(3000L)
        return "After the delay/network call is executed, its returns vvv this vvvv"
    }
    private suspend fun doNetworkCall2(): String {
        delay(9000L)
        return "After the delay/network call is executed, its returns vvv this vvvv"
    }
}