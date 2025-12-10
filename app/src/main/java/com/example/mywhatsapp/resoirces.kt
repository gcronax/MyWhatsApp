package com.example.mywhatsapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


data class item(
    val tipo: String,
    val img: Int,
    val text: String
)

val items: List<item> =listOf(
    item(
        "playas",
        R.drawable.image,
        "playas1"
    ),
    item(
        "ciudades",
        R.drawable.image1,
        "ciudades2"
    ),
    item(
        "ciudades",
        R.drawable.image2,
        "ciudades3"
    ),
    item(
        "playas",
        R.drawable.image3,
        "playas4"
    ),
    item(
        "ciudades",
        R.drawable.image4,
        "ciudades5"
    ),
    item(
        "ciudades",
        R.drawable.image5,
        "ciudades6"
    ),
    item(
        "pueblos",
        R.drawable.image6,
        "pueblos7"
    ),
    item(
        "pueblos",
        R.drawable.image7,
        "pueblos8"
    ),
    item(
        "ciudades",
        R.drawable.image8,
        "ciudades9"
    ),
    )
