package com.example.broadcast_receiver_ag

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var airplaneBroadcastReceiver: AirplaneModeBroadCastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun airplaneModeToggled() {
        airplaneBroadcastReceiver = AirplaneModeBroadCastReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(airplaneBroadcastReceiver, it)
        }
    }

    override fun onStart() {
        super.onStart()

        airplaneModeToggled()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airplaneBroadcastReceiver)
    }
}