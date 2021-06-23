package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class CollegeList(

    @SerializedName("Colleges")
    val data: List<College>
)