package com.main.taskapplication

import android.os.Parcel
import android.os.Parcelable

data class PersonInfo(val name: String?, val age: Int, val faculty: String?, val grade: Double) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(faculty)
        parcel.writeDouble(grade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonInfo> {
        override fun createFromParcel(parcel: Parcel): PersonInfo {
            return PersonInfo(parcel)
        }

        override fun newArray(size: Int): Array<PersonInfo?> {
            return arrayOfNulls(size)
        }
    }

}
