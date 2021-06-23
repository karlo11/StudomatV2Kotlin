package com.example.myapplication1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.api.RetroInstance
import com.example.myapplication1.api.RetroService
import com.example.myapplication1.model.MajorList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MajorViewModel : ViewModel() {

    var recyclerListData: MutableLiveData<MajorList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getMajorListObservable(): MutableLiveData<MajorList> {
        return recyclerListData
    }

    fun getMajorsList() {
        val retroInstance = RetroInstance.getRetroInstance()
            .create(RetroService::class.java)
        var call = retroInstance.getMajorList()
        call.enqueue(object : Callback<MajorList> {
            override fun onResponse(call: Call<MajorList>, response: Response<MajorList>) {
                recyclerListData.postValue(response.body())
            }

            override fun onFailure(call: Call<MajorList>, t: Throwable) {
                recyclerListData.postValue(null)
                t.printStackTrace()
            }
        })
    }
}