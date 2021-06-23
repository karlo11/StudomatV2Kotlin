package com.example.myapplication1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.api.RetroInstance
import com.example.myapplication1.api.RetroService
import com.example.myapplication1.model.TeacherList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {

    var recyclerListdata: MutableLiveData<TeacherList>

    init {
        recyclerListdata = MutableLiveData()
    }

    fun getTeacherListObservable(): MutableLiveData<TeacherList> {
        return recyclerListdata
    }

    fun getTeachersList() {
        val retroInstance = RetroInstance.getRetroInstance()
            .create(RetroService::class.java)
        var call = retroInstance.getTeacherList()
        call.enqueue(object : Callback<TeacherList> {
            override fun onResponse(call: Call<TeacherList>, response: Response<TeacherList>) {
                recyclerListdata.postValue(response.body())
            }

            override fun onFailure(call: Call<TeacherList>, t: Throwable) {
                recyclerListdata.postValue(null)
                t.printStackTrace()
            }
        })
    }
}