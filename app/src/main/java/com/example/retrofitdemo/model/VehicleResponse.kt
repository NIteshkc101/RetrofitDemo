package com.example.retrofitdemo.model

import android.os.Parcel
import android.os.Parcelable

data class VehicleResponse(


    val chassis_number: String?,
    val color: String?,
    val model: String?,
    val photo_count: Int,
    val purchase_date: String?,
    val purchase_destination: String?,
    val reference_number: String?,
    val sales_person: String?,
    val vehicle_image: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(chassis_number)
        parcel.writeString(color)
        parcel.writeString(model)
        parcel.writeInt(photo_count)
        parcel.writeString(purchase_date)
        parcel.writeString(purchase_destination)
        parcel.writeString(reference_number)
        parcel.writeString(sales_person)
        parcel.writeString(vehicle_image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VehicleResponse> {
        override fun createFromParcel(parcel: Parcel): VehicleResponse {
            return VehicleResponse(parcel)
        }

        override fun newArray(size: Int): Array<VehicleResponse?> {
            return arrayOfNulls(size)
        }
    }
}