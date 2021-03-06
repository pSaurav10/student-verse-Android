package com.example.studentverse.activity.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder

import com.google.gson.Gson




object ServiceBuilder {
        private const val BASE_URL =
        "http://10.0.2.2:5000/"
//        private const val BASE_URL =
//        "http://localhost:5000/"
//        private const val BASE_URL =
//        "https://student-verse.herokuapp.com/"

    var token: String? = null
    private val okHttp = OkHttpClient.Builder()
    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttp.build())

    //Create retrofit instance
    private val retrofit = retrofitBuilder.build()

    //Generic function
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    fun loadImagepath():String{
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "/" + arr[1] + arr[2] + "picture/"
    }
}