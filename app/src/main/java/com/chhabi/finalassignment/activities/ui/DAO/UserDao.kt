package com.chhabi.finalassignment.activities.ui.DAO

import androidx.room.*
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Entity.User

@Dao
interface UserDao {
    @Insert
    suspend fun registerUser(user: User)

    @Query("select * from User where username=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): User
}
