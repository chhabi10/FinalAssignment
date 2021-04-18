package com.chhabi.finalassignment.activities.ui.Response

import com.chhabi.finalassignment.activities.ui.Entity.Useraccount

data class GetAllUseraccountResponse (
        val success:Boolean?=null,
        val count:Int?=null,
        val data:MutableList<Useraccount>?=null
        )
