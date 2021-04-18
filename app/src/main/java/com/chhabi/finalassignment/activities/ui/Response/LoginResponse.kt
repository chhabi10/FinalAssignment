package com.chhabi.finalassignment.activities.ui.Response

import com.chhabi.finalassignment.activities.ui.Entity.Customer

data class LoginResponse(
        val success:Boolean?=null,
        val token:String?=null,
        val message:String?=null,
       val userData:MutableList<Customer>?=null
)