package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class College(
    @SerializedName("Address")
    val address: String,
    @SerializedName("DeanFirstName")
    val deanFirstName: String,
    @SerializedName("DeanLastName")
    val deanLastName: String,
    @SerializedName("FoundationYear")
    val foundationYear: Int,
    @SerializedName("Name")
    val name: String
)