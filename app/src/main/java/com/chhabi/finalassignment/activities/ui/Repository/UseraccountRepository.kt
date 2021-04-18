package com.chhabi.finalassignment.activities.ui.Repository

import com.chhabi.finalassignment.activities.ui.API.MyAPIRequest
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Entity.Useraccount
import com.chhabi.finalassignment.activities.ui.Response.AddUseraccountResponse
import com.chhabi.finalassignment.activities.ui.Response.GetAllUseraccountResponse

class UseraccountRepository :MyAPIRequest(){
    val UseraccountAPI=ServiceBuilder.buildService(com.chhabi.finalassignment.activities.ui.API.UseraccountAPI::class.java)

    suspend fun addUseraccount(useraccount: Useraccount): AddUseraccountResponse{
        return apiRequest {
            UseraccountAPI.addUseraccount(ServiceBuilder.token!!,useraccount)
        }
    }
    suspend fun getAllUseraccount(): GetAllUseraccountResponse {
        return apiRequest {
            UseraccountAPI.getAllUseraccount(ServiceBuilder.token!!)
        }


    }
}