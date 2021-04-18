package com.chhabi.finalassignment

import com.chhabi.finalassignment.activities.ui.Entity.User
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class Usertesting {
    private lateinit var userRepository:UserRepository

    @Test
    fun checkLogin()= runBlocking{
        userRepository= UserRepository()
        val response= userRepository.checkUser("hamal","hamal123")
        val expectedResult= true
       val actualResult =response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun registerUser()= runBlocking{
        userRepository= UserRepository()
        val user= User(fname="test",lname="test",username="testusername",password="testpassword")
        userRepository= UserRepository()
        val response= userRepository.registerUser(user)
        val expectedResult= true
        val actualResult =response.success
        Assert.assertEquals(expectedResult, actualResult)
    }
}