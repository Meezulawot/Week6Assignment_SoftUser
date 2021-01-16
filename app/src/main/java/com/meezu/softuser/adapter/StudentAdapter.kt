package com.meezu.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.meezu.myapplication.model.Student
import com.meezu.softuser.R
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
        val context: Context?,
        val studentList: ArrayList<Student>

    ) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>(){

    class StudentViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgProfile : CircleImageView
        val tvFullName: TextView
        val tvAge: TextView
        val tvGender: TextView
        val tvAddress: TextView

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFullName = view.findViewById(R.id.tvFullname)
            tvAge = view.findViewById(R.id.tvAge)
            tvGender = view.findViewById(R.id.tvGender)
            tvAddress = view.findViewById(R.id.tvAddress)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val students = studentList[position]
            holder.tvFullName.text = students.fullName
            holder.tvAge.text = students.age.toString()
            holder.tvGender.text = students.gender
            holder.tvAddress.text = students.address

        Glide.with(context!!)
            .load(students.profile)
            .into(holder.imgProfile)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}