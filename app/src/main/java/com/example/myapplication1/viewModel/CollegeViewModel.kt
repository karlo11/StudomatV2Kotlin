package com.example.myapplication1.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication1.api.RetroInstance
import com.example.myapplication1.api.RetroService
import com.example.myapplication1.model.CollegeList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CollegeViewModel : ViewModel() {

    var recyclerListData: MutableLiveData<CollegeList>

    init {
        recyclerListData = MutableLiveData()
    }

    fun getCollegeListObservable(): MutableLiveData<CollegeList> {
        return recyclerListData
    }

    fun getCollegesList() {
        val retroInstance = RetroInstance.getRetroInstance()
            .create(RetroService::class.java)
        var call = retroInstance.getCollegeList()
        call.enqueue(object : Callback<CollegeList> {
            override fun onResponse(call: Call<CollegeList>, response: Response<CollegeList>) {
                recyclerListData.postValue(response.body())
            }

            override fun onFailure(call: Call<CollegeList>, t: Throwable) {
                recyclerListData.postValue(null)
                t.printStackTrace()
            }
        })
    }
}