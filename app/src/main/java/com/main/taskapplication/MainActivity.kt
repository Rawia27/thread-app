package com.main.taskapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.main.taskapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.playBtn.setOnClickListener {
            val intent = Intent(baseContext, MyService::class.java)
            startService(intent)
        }
        binding.stopBtn.setOnClickListener {
            val intent = Intent(baseContext, MyService::class.java)
            stopService(intent)
            startActivity(Intent(this, ReceiverActivity::class.java))

        }
    }
// Example on companion obj:
//    companion object {
//        private const val TAG = "MainActivity"
//    }

}