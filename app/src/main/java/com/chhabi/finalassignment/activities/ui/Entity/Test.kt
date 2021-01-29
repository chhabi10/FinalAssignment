package com.chhabi.finalassignment.activities.ui.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
        @PrimaryKey
        var id : Int
)