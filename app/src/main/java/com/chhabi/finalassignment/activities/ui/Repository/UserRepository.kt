package com.chhabi.finalassignment.activities.ui.Repository

import com.chhabi.finalassignment.activities.ui.API.MyAPIRequest
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.API.UserAPI
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Response.LoginResponse

class UserRepository:MyAPIRequest() {
    val myApi =
            ServiceBuilder.buildService(UserAPI::class.java)
    suspend fun registerUser(customer: Customer): LoginResponse {
        return apiRequest {
            myApi.registerUser(customer)
        }
    }
    suspend fun checkUser(username: String, password: String): LoginResponse {
        return apiRequest {
            myApi.checkUser(username, password)
        }
    }
}
}