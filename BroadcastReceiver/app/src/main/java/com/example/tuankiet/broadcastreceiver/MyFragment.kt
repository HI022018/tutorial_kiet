package com.example.tuankiet.broadcastreceiver


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_my.*

class MyFragment : Fragment() {
    private lateinit var TAG:String
    val br:BroadcastReceiver = object :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val tag=intent?.getStringExtra("tag")
            val value=intent?.getIntExtra("value",textView.text.toString().toInt())
            if(tag==TAG)
                textView.text=value.toString()
        }
    }
    fun setTAG(type:String){
        this.TAG=type
    }
    val intentFilter=IntentFilter(MainActivity.ACTION_CHANGE)
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my, container, false)
    }
    override fun onPause() {
        context?.let { LocalBroadcastManager.getInstance(it).unregisterReceiver(br) }
        super.onPause()
    }

    override fun onResume() {
        context?.let { LocalBroadcastManager.getInstance(it).registerReceiver(br,intentFilter) }
        super.onResume()
    }

}
