package com.example.myapplication1.model

import com.example.myapplication1.adapter.RecyclerViewAdapter
import com.google.gson.annotations.SerializedName


data class TeacherList(

    @SerializedName("Teachers")
    val data: List<Teacher>
)