package com.main.taskapplication

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.main.taskapplication.databinding.ActivitySendObjBinding

class SendObjActivity : AppCompatActivity() {
    lateinit var binding: ActivitySendObjBinding
    lateinit var myIntent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendObjBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myIntent = intent
        getSerializableObject()
        getParcelableObject()

        binding.countBtn.setOnClickListener {
            Thread(Runnable {
                for (i in 1..6) {
                    Thread.sleep(1000)
                    //   runOnUiThread { binding.countTv.text=i.toString() }
                    //  binding.countTv.post { binding.countTv.text=i.toString()  }
                    binding.countTv.postDelayed(
                        Runnable { binding.countTv.text = i.toString() },
                        5000
                    )
                }

            }).start()
        }
        binding.asyncTaskBtn.setOnClickListener {

            ChangeButtonClass().execute()
        }
    }

    fun getSerializableObject() {
        val recivedObj: Person? = (myIntent.getSerializableExtra("object") as Person?)
        with(binding) {
            personName.text = "name: " + recivedObj?.name
            personAge.text = "Age: " + recivedObj?.age
            personFaculty.text = "Faculty: " + recivedObj?.faculty
            personGrade.text = "Grade: " + recivedObj?.grade
            personByParcelable.visibility = View.GONE
        }
    }

    fun getParcelableObject() {
        var receivedObjPar: PersonInfo? = intent.extras?.getParcelable("objectPersonInfo")
        val i = intent.getIntExtra("num", 0)
        with(binding.personByParcelable) {
            append("name: " + receivedObjPar?.name + "\n")
            append("age: " + receivedObjPar?.age + "\n")
            append("faculty: " + receivedObjPar?.faculty + "\n")
            append("Grade: " + receivedObjPar?.grade + "\n")
        }
        if (i == 1) {
            with(binding) {
                personName.visibility = View.GONE
                personAge.visibility = View.GONE
                personFaculty.visibility = View.GONE
                personGrade.visibility = View.GONE
                personByParcelable.visibility = View.VISIBLE
            }
        }
    }

}

open class ChangeButtonClass : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg p0: Void?): Void {
        TODO("Not yet implemented")

    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

    }

}