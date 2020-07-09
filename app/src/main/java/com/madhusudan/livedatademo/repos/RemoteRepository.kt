package com.madhusudan.livedatademo.repos

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.madhusudan.livedatademo.ui.interfaces.RetrofitApiService
import com.madhusudan.livedatademo.network.data.Example
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository {

    fun callAPI(): MutableLiveData<Example> {
        val mutableLiveData = MutableLiveData<Example>()

        RetrofitApiService().fetchData(String())
            .enqueue(object : Callback<Example> {
                override fun onFailure(call: Call<Example>, t: Throwable) {
                    Log.d("Error", "Coudn't get the data")

                }
                override fun onResponse(call: Call<Example>, response: Response<Example>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())

                    } else {
                        Log.d("Error", "Coudn't get the data")
                    }
                }
            })
        return mutableLiveData
    }
}


