package com.example.myanimefavorit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Anime(
    val name: String,
    val description: String,
    val rating : Float,
    val genre : String,
    val photo: Int
) : Parcelable
