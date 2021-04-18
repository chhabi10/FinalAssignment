package com.chhabi.finalassignment

import com.chhabi.finalassignment.activities.ui.CustomerActivity
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Entity.User
import com.chhabi.finalassignment.activities.ui.Repository.CustomerRepository
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class Customeraddedtesting {
    private lateinit var customerRepository:CustomerRepository
    @Test
    fun CustomerActivity()= runBlocking{
        customerRepository= CustomerRepository()
        val customer= Customer(fname="cb",lname="bist",identity = "13",dob = "2051-01-9",address = "kathmandu")
        customerRepository= CustomerRepository()
        val response= customerRepository.addCustomer(customer)
        val expectedResult= true
        val actualResult =response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
}