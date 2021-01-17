package com.meezu.softuser.ui.student

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputLayout
import com.meezu.myapplication.model.Student
import com.meezu.softuser.BottomActivity.Companion.studentList
import com.meezu.softuser.R

class StudentFragment : Fragment() {

//    private lateinit var studentViewModel: StudentViewModel

    private lateinit var text_input_url: TextInputLayout
    private lateinit var text_input_name: TextInputLayout
    private lateinit var text_input_age: TextInputLayout
    private lateinit var group: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var rbOthers: RadioButton
    private lateinit var text_input_address: TextInputLayout
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

        //reference binding
        text_input_url = view.findViewById(R.id.text_input_url)
        text_input_name = view.findViewById(R.id.text_input_name)
        text_input_age = view.findViewById(R.id.text_input_age)
        group = view.findViewById(R.id.group)
        rbMale = view.findViewById(R.id.rbMale)
        rbFemale = view.findViewById(R.id.rbFemale)
        rbOthers = view.findViewById(R.id.rbOthers)
        text_input_address = view.findViewById(R.id.text_input_address)
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

    @SuppressLint("ResourceType")
    private fun addStudent(){
        val profile = text_input_url.editText!!.text.toString()
        val fullName = text_input_name.editText!!.text.toString()
        val age = text_input_age.editText!!.text.toString().toInt()
        val address = text_input_address.editText!!.text.toString()

        when {
            TextUtils.isEmpty(profile) -> {
                text_input_url.error = "Please fill the input"
                text_input_url.requestFocus()

            }
            TextUtils.isEmpty(fullName) -> {
                text_input_name.error = "Please enter name"
                text_input_name.requestFocus()

            }
            TextUtils.isEmpty(age.toString()) -> {
                text_input_age.error = "Please enter age"
                text_input_age.requestFocus()

            }
            group.getCheckedRadioButtonId()<=0 -> {
                rbMale.error = "Please select gender"
                rbFemale.requestFocus()

            }
            TextUtils.isEmpty(address) -> {
                text_input_address.error = "Please enter address"
                text_input_address.requestFocus()

            }else -> {
                val student = Student(profile, fullName, age, gender, address)
                studentList.add(student)

                Toast.makeText(context, "Student added in the list", Toast.LENGTH_SHORT).show();
            }
        }

    }

}