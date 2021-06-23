package com.example.myapplication1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.api.RetroInstance
import com.example.myapplication1.api.RetroService
import com.example.myapplication1.model.StudentList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentViewModel : ViewModel() {

    var recyclerListData: MutableLiveData<StudentList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getStudentListObservable(): MutableLiveData<StudentList> {
        return recyclerListData
    }

    fun getStudentsList() {
        val retroInstance = RetroInstance.getRetroInstance()
            .create(RetroService::class.java)
        var call = retroInstance.getStudentList()
        call.enqueue(object : Callback<StudentList> {
            override fun onResponse(call: Call<StudentList>, response: Response<StudentList>) {
                recyclerListData.postValue(response.body())
            }

            override fun onFailure(call: Call<StudentList>, t: Throwable) {
                recyclerListData.postValue(null)
                t.printStackTrace()
            }
        })
    }
}