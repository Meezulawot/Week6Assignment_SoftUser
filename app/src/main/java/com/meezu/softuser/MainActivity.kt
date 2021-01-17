package com.meezu.softuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.meezu.myapplication.model.Student

class MainActivity : AppCompatActivity() {

    private lateinit var text_input_username: TextInputLayout
    private lateinit var text_input_pass: TextInputLayout
    private lateinit var btnLogIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_input_username = findViewById(R.id.text_input_username)
        text_input_pass = findViewById(R.id.text_input_pass)
        btnLogIn = findViewById(R.id.btnLogIn)

        btnLogIn.setOnClickListener{
            logIn()
        }
    }

    private fun logIn(){
        val username = text_input_username.editText!!.text.toString()
        val password = text_input_pass.editText!!.text.toString()

        when {
            TextUtils.isEmpty(username) -> {
                text_input_username.error = "Please enter username"
                text_input_username.requestFocus()

            }
            TextUtils.isEmpty(password) -> {
                text_input_pass.error = "Please enter password"
                text_input_pass.requestFocus()

            }
            username == "softwarica" && password == "coventry" -> {
                Toast.makeText(this, "LogIn successfull", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, BottomActivity::class.java)
                startActivity(intent)

            }
            else -> {
                Toast.makeText(this, "Invalid username and password", Toast.LENGTH_SHORT).show()
            }
        }

    }
}