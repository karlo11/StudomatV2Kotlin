package com.example.myapplication1.model


import com.google.gson.annotations.SerializedName

data class Class(
    @SerializedName("Details")
    val details: String?,
    @SerializedName("HoursOfAudit")
    val hoursOfAudit: Int,
    @SerializedName("HoursOfConstr")
    val hoursOfConstr: Int,
    @SerializedName("HoursOfHomework")
    val hoursOfHomework: Int,
    @SerializedName("HoursOfLab")
    val hoursOfLab: Int,
    @SerializedName("HoursOfLectures")
    val hoursOfLectures: Int,
    @SerializedName("HoursOfSeminar")
    val hoursOfSeminar: Int,
    @SerializedName("ISVUNumber")
    val iSVUNumber: String,
    @SerializedName("MajorID")
    val majorID: Int,
    @SerializedName("Name")
    val name: String,
    @SerializedName("NumberOfECTS")
    val numberOfECTS: Int,
    @SerializedName("Semester")
    val semester: Int,
    @SerializedName("TeacherID")
    val teacherID: Int
)