package com.chhabi.finalassignment.activities.ui.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.chhabi.finalassignment.activities.ui.Entity.Customer

@Dao
interface CustomerDao {
    @Insert
    suspend fun registercustomer(customer: Customer)

    @Query("select * from Customer where username=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): Customer
}