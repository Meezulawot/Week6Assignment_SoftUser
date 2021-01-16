package com.meezu.myapplication.model

import java.io.Serializable

data class Student (
    val profile: String,
    val fullName: String,
    val age: Int,
    val gender: String,
    val address: String
        ):Serializable{

    override fun toString(): String {
        return fullName
    }
}