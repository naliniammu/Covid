package com.madhusudan.livedatademo.ui.interfaces

import com.madhusudan.livedatademo.network.data.Example
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {


    @GET("data.json?")
    fun fetchData(@Query("statewise") statewise:String): Call<Example>

    companion object {
       var BASE_URL:String = "https://api.covid19india.org/"
        operator fun invoke(): RetrofitApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApiService::class.java)
        }
    }
}