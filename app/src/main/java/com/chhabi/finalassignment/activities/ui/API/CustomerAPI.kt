package com.chhabi.finalassignment.activities.ui.API

import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Response.AddCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.GetAllCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.ImageResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface CustomerAPI {
    @POST("add/customer")
    suspend fun addCustomer(
            @Header("Authorization") token: String,
            @Body customer: Customer
    ): Response<AddCustomerResponse>

    

    @GET("get/customer")
    suspend fun getAllCustomer(
            @Header("Authorization") token: String
    ): Response<GetAllCustomerResponse>

//    @DELETE("student/{id}")
//    suspend fun deleteStudent(
//    @Header("Authorization") token: String,
//    @Path("id") id:String
//    ):Response<DeleteStudentResponse>

    @Multipart
    @PUT("customer/{id}/photo")
    suspend fun uploadImage(
            @Header("Authorization") token: String,
            @Path("id") id: String,

            @Part file: MultipartBody.Part
    ): Response<ImageResponse>
}

