package com.chhabi.finalassignment.activities.ui.DAO

import androidx.room.*
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Entity.User

@Dao
interface CustomerDao {


    @Insert
    suspend fun insertCustomer(customer: Customer)

    @Query("SELECT * FROM Customer")
    suspend fun getAllCustomer() : List<Customer>

    @Update
    suspend fun updateCustomer(customer: Customer)

    @Delete
    suspend fun DeleteCustomer(customer: Customer)

}