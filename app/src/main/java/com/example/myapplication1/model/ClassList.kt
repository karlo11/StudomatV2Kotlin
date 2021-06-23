package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class ClassList(

    @SerializedName("Classes")
    val data: List<Class>
)