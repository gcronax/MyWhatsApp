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
        "1",
        R.drawable.image,
        "1"
    ),
    item(
        "1",
        R.drawable.image1,
        "2"
    ),
    item(
        "3",
        R.drawable.image2,
        "3"
    ),
    item(
        "3",
        R.drawable.image3,
        "4"
    ),
    item(
        "3",
        R.drawable.image4,
        "5"
    ),
    item(
        "1",
        R.drawable.image5,
        "6"
    ),
    item(
        "2",
        R.drawable.image6,
        "7"
    ),
    item(
        "1",
        R.drawable.image7,
        "8"
    ),
    item(
        "2",
        R.drawable.image8,
        "9"
    ),
    )
