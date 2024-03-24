package com.example.aston_intensiv_4

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ContactModel(
    val id: Int,
    var firstName: String,
    var lastName: String,
    var phoneNumber: String,
    var imgLink: String
) : Parcelable {

}

