package com.chhabi.finalassignment.activities.ui.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chhabi.finalassignment.activities.ui.DAO.CustomerDao
import com.chhabi.finalassignment.activities.ui.DAO.UserDao
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.Entity.User

class Userdb {
    @Database(
            entities = [(Customer::class), (User::class)],
            version = 1,
            exportSchema = false
    )
    abstract class Userdb: RoomDatabase(){
        abstract fun getUserDao(): UserDao
        abstract fun getCustomerDAO(): CustomerDao

        companion object {
            @Volatile
            private var instance: Userdb? = null

            fun getInstance(context: Context): Userdb {
                if (instance == null) {
                    synchronized(Userdb::class) {
                        instance = buildDatabase(context)
                    }
                }
                return instance!!
            }

            private fun buildDatabase(context: Context) =
                    Room.databaseBuilder(
                            context.applicationContext,
                            Userdb::class.java,
                            "StudentDB"
                    ).build()
        }

    }
}