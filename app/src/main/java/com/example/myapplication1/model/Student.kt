package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class Student(
    @SerializedName("Address")
    val address: String,
    @SerializedName("DateOfBirth")
    val dateOfBirth: String,
    @SerializedName("DateOfEnrollment")
    val dateOfEnrollment: String,
    @SerializedName("Email")
    val email: String,
    @SerializedName("FirstName")
    val firstName: String,
    @SerializedName("JMBAG")
    val jMBAG: String,
    @SerializedName("LastName")
    val lastName: String,
    @SerializedName("OIB")
    val oIB: String?
)