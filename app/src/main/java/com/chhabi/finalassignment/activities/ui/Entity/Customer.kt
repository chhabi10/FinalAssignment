package com.chhabi.finalassignment.activities.ui.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
        var fname: String? = null,
        var lname: String? = null,
        var username: String? = null,
        var password: String? = null,
        var age: String?=null,
        var address: String? =null
){
    @PrimaryKey(autoGenerate = true)
    var userId: Int = 0
}