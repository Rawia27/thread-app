package com.main.taskapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService : Service() {
    lateinit var mp: MediaPlayer

    // انشاء الservice
    override fun onCreate() {
        super.onCreate()
        mp = MediaPlayer.create(this, R.raw.bird)
    }

    //الكود اللي عايزاه يشتغل عند تشغيل ال service
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (!mp.isPlaying)
            mp.start()

        return START_STICKY // دي لزمتها بس لو السيستم عمل kill لل service قبل ما تنتهي وقت ما احتاج ميموري مثلا
        //(START_STICKY)
        //دي معناها ان لو الخدمه السيستم عملها kill قبل ما تكمل ارجع شغلها تاني من غير ما تبعت ال intent
        //(Start Not Sticky)
        //لو مفيش pending intent متشغلش ال service من تاني
        // (START_REDELIVER_INTENT) شغل الخدمة و ابعتلها الانتنت
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mp.isPlaying)
            mp.stop()
        mp.release() //بعملها علشان اعملrelease للresources اللي ماسكها ال mediaPlayer
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}