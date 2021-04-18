package com.chhabi.finalassignment.activities.ui.API

import com.chhabi.finalassignment.activities.ui.Entity.Customer
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val BASE_URL =
        "http://10.0.2.2:95/"
//            "http://localhost:95/"
    var token: String? = null
  var userData:MutableList<Customer>?=null
    private val okHttp = OkHttpClient.Builder()
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build())

    //Create retrofit instance
    private val retrofit = retrofitBuilder.build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "/" + arr[1] + arr[2] + "/uploads/"
    }
}