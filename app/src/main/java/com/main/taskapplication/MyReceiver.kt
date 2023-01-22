package com.main.taskapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action.equals("ndroid.intent.action.HEADSET_PLUG")) {
            var state = intent.getIntExtra("state", -1)
            when (state) {
                0 -> context.stopService(Intent(context, MyService::class.java))
                // Toast.makeText(context, "un plugged", Toast.LENGTH_LONG).show()
                1 -> context.startService(Intent(context, MyService::class.java))
                //Toast.makeText(context, " plugged in", Toast.LENGTH_LONG).show()
            }
        }


        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//var result:PendingResult=goAsync() //بعمل كدا لما بكون هشتغل فthread ومش عايزاه يخرج من الميثودonRecive غير لما الthread يخلص
//   Thread(Runnable {
//       Thread.sleep(10000)
//       result.finish() //كدا بقوله خلاص عشان الonReceiver
        // })

    }
}