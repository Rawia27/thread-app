package com.main.taskapplication

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.main.taskapplication.databinding.ActivityReceiverBinding

class ReceiverActivity : AppCompatActivity() {
    lateinit var binding: ActivityReceiverBinding
    lateinit var receiver: MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receiver = MyReceiver()
        val filter = IntentFilter(Intent.ACTION_HEADSET_PLUG)
        registerReceiver(receiver, filter)
        binding.stopBtn.setOnClickListener {
            startActivity(Intent(this, LoadImageActivity::class.java))
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}