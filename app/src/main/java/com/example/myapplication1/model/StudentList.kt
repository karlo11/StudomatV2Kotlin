package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class StudentList(
    @SerializedName("Students")
    val data: List<Student>
)