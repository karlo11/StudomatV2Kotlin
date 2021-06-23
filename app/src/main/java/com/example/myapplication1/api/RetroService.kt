package com.example.myapplication1.api

import com.example.myapplication1.model.*
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("CollegesData")
    fun getCollegeList(): Call<CollegeList>

    @GET("ClassesData")
    fun getClassList(): Call<ClassList>

    @GET("MajorsData")
    fun getMajorList(): Call<MajorList>

    @GET("StudentsData")
    fun getStudentList(): Call<StudentList>

    @GET("TeachersData")
    fun getTeacherList(): Call<TeacherList>
}