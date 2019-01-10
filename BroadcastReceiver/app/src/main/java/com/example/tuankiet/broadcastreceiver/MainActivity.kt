package com.example.tuankiet.broadcastreceiver

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val ACTION_CHANGE="CHANGE"
        const val TAG_M="M"
        const val TAG_N="N"
    }
    var valueM=0
    var valueN=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (fragM as MyFragment).apply {
            view?.setBackgroundColor(resources.getColor(R.color.backgroundFragmentM))
            setTAG(TAG_M)
        }
        (fragN as MyFragment).apply {
            view?.setBackgroundColor(resources.getColor(R.color.backgroundFragmentN))
            setTAG(TAG_N)
        }
        btnBroadcastM.setOnClickListener {
            valueM++
            val intent= Intent(ACTION_CHANGE)
            intent.putExtra("tag", TAG_M)
            intent.putExtra("value",valueM)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
        btnBroadcastN.setOnClickListener {
            val intent=Intent(ACTION_CHANGE)
            intent.putExtra("tag", TAG_N)
            valueN--
            intent.putExtra("value",valueN)
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
        }
    }
}
