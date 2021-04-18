package com.chhabi.finalassignment.activities.ui.Response

import com.chhabi.finalassignment.activities.ui.Entity.Useraccount

data class AddUseraccountResponse (
       val success:Boolean?=null,
        val data: Useraccount?=null,
        val message:String?=null
        )