package com.chhabi.finalassignment.activities.ui.Response

import com.chhabi.finalassignment.activities.ui.Entity.Customer

data class GetAllCustomerResponse(
        val success:Boolean?=null,
         val count:Int?=null,
       val data:MutableList<Customer>?=null
)
