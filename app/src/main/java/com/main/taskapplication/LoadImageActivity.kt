package com.main.taskapplication


import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.main.taskapplication.databinding.ActivityLoadImageBinding
import java.io.Serializable


class LoadImageActivity : AppCompatActivity(), Runnable {
    lateinit var binding: ActivityLoadImageBinding
    var img: RequestBuilder<Drawable>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setImgBtn.setOnClickListener {
            Thread(Runnable {
                var img = Glide.with(this)
                    .load("https://www.tutorialspoint.com/images/tp-logo-diamond.png")
                runOnUiThread(Runnable {
                    img.into(binding.userImg)
                    binding.setImgBtn.text = "SET IMAGE DONE"
                    binding.setImgBtn.setBackgroundColor(Color.GRAY)
                })
            }).start()
        }
        setImageFromInternet()
        binding.shareBtn.setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND)
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Check Out This App")
            sendIntent.putExtra(Intent.EXTRA_TEXT, "The application Link")
            sendIntent.type = "text/plain"
            startActivity(Intent.createChooser(sendIntent, "Share Via"))
        }
        binding.sendObjSerializableActivityBtn.setOnClickListener {
            var person = Person("Ahmed", 23, "Engineer", 4.4)
            val intent = Intent(this@LoadImageActivity, SendObjActivity::class.java)
            intent.putExtra("object", person)
            startActivity(intent)

        }
        binding.sendObjParcelableActivityBtn.setOnClickListener {
            var personInfo = PersonInfo("Ali", 24, "Doctor", 4.1)
            val intent = Intent(LoadImageActivity@ this, SendObjActivity::class.java)
            intent.putExtra("objectPersonInfo", personInfo)
            intent.putExtra("num", 1)
            startActivity(intent)
        }
        //  threadByClass()
        val t1 = Thread()
        t1.start()
    }


    fun threadByClass() {
        val thread = SleepThread()
        thread.start()
        val string: String = thread.print()
        Handler().post(Runnable {
            binding.threadTx.text = string
        })
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("changeTxBtn", "SET IMAGE DONE")
        //outState.putInt("img",img.)
        outState.putInt("changeColorBtn", Color.GRAY)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        binding.setImgBtn.text = savedInstanceState.getString("changeTxBtn")
        binding.setImgBtn.setBackgroundColor(savedInstanceState.getInt("changeColorBtn"))
        // var i:int=savedInstanceState.getString("img")
        // binding.userImg.setImageResource(()
    }

    fun setImageFromInternet() {
        Thread(Runnable {
            img = Glide.with(this)
                .load("https://images.pexels.com/photos/589841/pexels-photo-589841.jpeg?auto=compress&cs=tinysrgb&w=600")

        }).start()
        Handler(Looper.getMainLooper()).post(Runnable {
            img?.into(binding.setImgHandlerImg)

        })
    }

    open override fun run() {
        runOnUiThread {
            Runnable {
                Toast.makeText(this@LoadImageActivity, "Its a toast!", Toast.LENGTH_LONG).show()

            }
        }
//}
    }
}

data class Person(val name: String, val age: Int, val faculty: String, val grade: Double) :
    Serializable

open class SleepThread : Thread() {
    fun print(): String {
        sleep(5000)
        return ""
    }
}


