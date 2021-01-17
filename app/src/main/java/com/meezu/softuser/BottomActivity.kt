package com.meezu.softuser

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.meezu.myapplication.model.Student

class BottomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_student, R.id.navigation_aboutus))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        loadStudent()
    }

    private fun loadStudent(){
        studentList.add(Student("https://i.pinimg.com/originals/22/10/c3/2210c329ea63083603396cf3f765d0f5.jpg", "Johnny Depp", 27, "Male", "Kathmandu"))
        studentList.add(Student("https://www.dreampirates.in/images/img/12-09-2020-8170-jennifer-lawrence-hollywood-actress-117.jpg", "Jennifer", 19, "Male", "Pokhara"))
        studentList.add(Student("https://theenglishpost.com/wp-content/uploads/2019/06/Katrina-Kaif_640x440.jpg", "Katrina Kaif", 20, "Female", "London"))
    }

    companion object {
        var studentList = arrayListOf<Student>();
    }
}