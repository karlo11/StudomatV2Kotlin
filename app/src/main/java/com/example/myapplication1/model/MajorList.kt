package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class MajorList(
    @SerializedName("Majors")
    val data: List<Major>
)