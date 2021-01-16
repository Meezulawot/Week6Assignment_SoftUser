package com.meezu.softuser.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.meezu.myapplication.adapter.StudentAdapter
import com.meezu.softuser.BottomActivity.Companion.studentList
import com.meezu.softuser.R

class HomeFragment : Fragment() {

//    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val adapter = StudentAdapter(context, studentList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)

        return view
    }
}