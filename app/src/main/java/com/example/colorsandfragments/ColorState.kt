package com.example.colorsandfragments

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parceler
import kotlinx.parcelize.Parcelize

@Parcelize
data class ColorState(var colorCount : Int=0) : Parcelable {
    //обычно поля в конструкторе делают val?

    //почему приватный companion object??
    private companion object : Parceler<ColorState> {

        override fun create(parcel: Parcel): ColorState {
            val colorState = ColorState()
            colorState.colorCount = parcel.readInt()
            return colorState
        }

        override fun ColorState.write(parcel: Parcel, flags: Int) {

            parcel.writeInt(colorCount)
        }

    }

    }
