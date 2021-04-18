package com.chhabi.finalassignment.activities.ui.API

import com.chhabi.finalassignment.activities.ui.Entity.Useraccount
import com.chhabi.finalassignment.activities.ui.Response.AddCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.AddUseraccountResponse
import com.chhabi.finalassignment.activities.ui.Response.GetAllCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.GetAllUseraccountResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface UseraccountAPI {

    @POST("add/useraccount")
    suspend fun addUseraccount(
            @Header("Authorization") token:String,
            @Body useraccount: Useraccount
    ): Response<AddUseraccountResponse>


    @GET("get/useraccount")
    suspend fun getAllUseraccount(
            @Header("Authorization") token:String
    ): Response<GetAllUseraccountResponse>
}