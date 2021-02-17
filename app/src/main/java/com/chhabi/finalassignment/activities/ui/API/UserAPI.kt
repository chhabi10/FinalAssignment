package com.chhabi.finalassignment.activities.ui.API

import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserAPI {

    //User registration
    @POST("auth/register")
    suspend fun registerUser(
            @Body customer: Customer
    ):Response<LoginResponse>


    //Login check
    @FormUrlEncoded

    @POST("auth/login")
    suspend fun checkUser(
            @Field("username") username:String,
            @Field("password") password:String
    ):Response<LoginResponse>
}