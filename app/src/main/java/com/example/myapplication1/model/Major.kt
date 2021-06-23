package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class Major(
    @SerializedName("Name")
    val name: String,
    @SerializedName("NameAbbreviation")
    val nameAbbreviation: String,
    @SerializedName("ViceDeanFirstName")
    val viceDeanFirstName: String,
    @SerializedName("ViceDeanLastName")
    val viceDeanLastName: String
)