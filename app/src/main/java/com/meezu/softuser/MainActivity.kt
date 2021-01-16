package com.meezu.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.meezu.myapplication.model.Student

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogIn = findViewById(R.id.btnLogIn)

        btnLogIn.setOnClickListener{

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if(username == "softwarica" && password == "coventry"){
                Toast.makeText(this, "LogIn successfull", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, BottomActivity::class.java)
                startActivity(intent)

            }else{
                Toast.makeText(this, "Invalid username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}