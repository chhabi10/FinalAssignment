package com.chhabi.finalassignment.activities.ui.Entity

import androidx.room.Entity

@Entity
data class Customer (

        val _id: String? = null,
        val fullname: String? = null,
        val age: Int? = null,
        val address: String? = null,
        val photo: String?= null


    )
