package com.example.myapplication1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.api.RetroInstance
import com.example.myapplication1.api.RetroService
import com.example.myapplication1.model.ClassList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassViewModel : ViewModel() {

    var recyclerListData: MutableLiveData<ClassList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getClassListObservable(): MutableLiveData<ClassList> {
        return recyclerListData
    }

    fun getClassesList() {
        val retroInstance = RetroInstance.getRetroInstance()
            .create(RetroService::class.java)
        var call = retroInstance.getClassList()
        call.enqueue(object : Callback<ClassList> {
            override fun onResponse(call: Call<ClassList>, response: Response<ClassList>) {
                recyclerListData.postValue(response.body())
            }

            override fun onFailure(call: Call<ClassList>, t: Throwable) {
                recyclerListData.postValue(null)
                t.printStackTrace()
            }
        })
    }
}