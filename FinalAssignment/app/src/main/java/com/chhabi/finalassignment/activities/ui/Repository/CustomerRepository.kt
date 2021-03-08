package com.chhabi.finalassignment.activities.ui.Repository


import com.chhabi.finalassignment.activities.ui.API.CustomerAPI
import com.chhabi.finalassignment.activities.ui.API.MyAPIRequest
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Response.AddCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.GetAllCustomerResponse
import com.chhabi.finalassignment.activities.ui.Response.ImageResponse
import okhttp3.MultipartBody


class CustomerRepository:MyAPIRequest() {


    val customerAPI=ServiceBuilder.buildService(CustomerAPI::class.java)

    suspend fun addCustomer(customer: Customer):AddCustomerResponse{
        return apiRequest {
            customerAPI.addCustomer(ServiceBuilder.token!!,customer)
        }
    }
    suspend fun getAllCustomer():GetAllCustomerResponse{
        return apiRequest {
            customerAPI.getAllCustomer(ServiceBuilder.token!!)
        }


    }
    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            customerAPI.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
}
