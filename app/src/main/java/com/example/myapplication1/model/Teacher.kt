package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class Teacher(
    @SerializedName("ID")
    val iD: Int,
    @SerializedName("Address")
    val address: Any?,
    @SerializedName("DateOfBirth")
    val dateOfBirth: String,
    @SerializedName("Email")
    val email: String?,
    @SerializedName("FirstName")
    val firstName: String,
    @SerializedName("LastName")
    val lastName: String,
    @SerializedName("OIB")
    val oIB: String,
    @SerializedName("Title")
    val title: String
)