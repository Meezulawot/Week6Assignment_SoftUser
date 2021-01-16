package com.meezu.softuser.ui.student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.meezu.myapplication.model.Student
import com.meezu.softuser.BottomActivity.Companion.studentList
import com.meezu.softuser.R

class StudentFragment : Fragment() {

//    private lateinit var studentViewModel: StudentViewModel

    private lateinit var etImageUrl: EditText
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var group: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var etAddress: EditText
    private lateinit var btnAdd: Button
    private var gender = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        studentViewModel =
//            ViewModelProvider(this).get(StudentViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_student, container, false)
//        val textView: TextView = root.findViewById(R.id.text_dashboard)
//        studentViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
//        return root

        val view = inflater.inflate(R.layout.fragment_student, container, false)
        etImageUrl = view.findViewById(R.id.etImgUrl)
        etFullName = view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        group = view.findViewById(R.id.group)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        etAddress = view.findViewById(R.id.etAddress)
        btnAdd = view.findViewById(R.id.btnAdd)

        radioEvent()
        btnAdd.setOnClickListener{
            addStudent()
        }

        return view
    }

    private fun radioEvent(){
        group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rbMale -> {
                    gender = rbMale.text.toString()
                }
                R.id.rbFemale -> {
                    gender = rbFemale.text.toString()
                }
                R.id.rbOthers -> {
                    gender = rbOthers.text.toString()
                }
            }
        }
    }

    private fun addStudent(){
        val profile = etImageUrl.text.toString()
        val fullName = etFullName.text.toString()
        val age = etAge.text.toString().toInt()
        val address = etAddress.text.toString()

        val student = Student(profile, fullName, age, gender, address)
        studentList.add(student)

        Toast.makeText(context, "Student added in the list", Toast.LENGTH_SHORT).show();
    }
}