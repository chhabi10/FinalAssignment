package com.chhabi.finalassignment.activities.ui.Entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Customer(
        val _id: String? = null,
        val fname: String? = null,
        val lname: String? = null,
        val identity: String? = null,
        val dob: String? =null,
        val address: String? = null,
        val photo: String?= null
):Parcelable{
    @PrimaryKey(autoGenerate = true)
    var cstId: Int = 0

    constructor(parcel: Parcel) : this(
            parcel.readValue(String::class.java.classLoader) as?String,
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        cstId = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(_id)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(identity)
        parcel.writeString(dob)
        parcel.writeString(address)
        parcel.writeString(photo)
        parcel.writeInt(cstId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Customer> {
        override fun createFromParcel(parcel: Parcel): Customer {
            return Customer(parcel)
        }

        override fun newArray(size: Int): Array<Customer?> {
            return arrayOfNulls(size)
        }
    }
}




