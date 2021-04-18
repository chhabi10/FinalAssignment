package com.chhabi.finalassignment.activities.ui.Response

import com.chhabi.finalassignment.activities.ui.Entity.Customer

data class AddCustomerResponse(
        val success:Boolean?=null,
        val data:Customer?=null,
        val message:String?=null
)
