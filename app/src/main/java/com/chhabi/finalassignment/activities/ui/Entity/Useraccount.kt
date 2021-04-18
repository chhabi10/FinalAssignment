package com.chhabi.finalassignment.activities.ui.Entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.PrimaryKey

class Useraccount(
        val _id:String?=null,
        var Accountname: String? = null,
        var Accountnumber: String? = null,
        var amount: String? =null,
        var remarks:String?=null
        ):Parcelable{
@PrimaryKey(autoGenerate = true)
var accountuserId: Int = 0

        constructor(parcel: Parcel) : this(
                parcel.readValue(String::class.java.classLoader) as? String,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
                accountuserId = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeValue(_id)
                parcel.writeString(Accountname)
                parcel.writeString(Accountnumber)
                parcel.writeString(amount)
                parcel.writeString(remarks)
                parcel.writeInt(accountuserId)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Useraccount> {
                override fun createFromParcel(parcel: Parcel): Useraccount {
                        return Useraccount(parcel)
                }

                override fun newArray(size: Int): Array<Useraccount?> {
                        return arrayOfNulls(size)
                }
        }


}