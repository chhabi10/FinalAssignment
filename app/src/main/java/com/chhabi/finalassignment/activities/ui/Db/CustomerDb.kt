package com.chhabi.finalassignment.activities.ui.Db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chhabi.finalassignment.activities.ui.Dao.UserDao
import com.chhabi.finalassignment.activities.ui.Entity.Customer

@Database(
        entities = [(Customer::class)],
        version = 1,
        exportSchema = false
)
abstract class  CustomerDb : RoomDatabase() {
    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var instance: CustomerDb? = null

        fun getInstance(context: Context): CustomerDb {
            if (instance == null) {
                synchronized(CustomerDb::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        CustomerDb::class.java,
                        "CustomerDb"
                ).build()
    }
}