package com.main.taskapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.main.taskapplication.databinding.ActivitySendObjBinding

class SendObjActivity : AppCompatActivity() {
    lateinit var binding: ActivitySendObjBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendObjBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val myIntent = intent
        val recivedObj: Person? = (myIntent?.getSerializableExtra("object") as Person?)
        binding.personName.text = "name: " + recivedObj?.name
        binding.personAge.text = "Age: " + recivedObj?.age
        binding.personFaculty.text = "Faculty: " + recivedObj?.faculty
        binding.personGrade.text = "Grade: " + recivedObj?.grade
        binding.personByParcelable.visibility = View.GONE


        var receivedObjPar: PersonInfo? = intent.extras?.getParcelable("objectPersonInfo")
        val i = intent.getIntExtra("num", 0)
        binding.personByParcelable.append("name: " + receivedObjPar?.name + "\n")
        binding.personByParcelable.append("age: " + receivedObjPar?.age + "\n")
        binding.personByParcelable.append("faculty: " + receivedObjPar?.faculty + "\n")
        binding.personByParcelable.append("Grade: " + receivedObjPar?.grade + "\n")
        if (i == 1) {
            binding.personName.visibility = View.GONE
            binding.personAge.visibility = View.GONE
            binding.personFaculty.visibility = View.GONE
            binding.personGrade.visibility = View.GONE
            binding.personByParcelable.visibility = View.VISIBLE
        }
    }
}