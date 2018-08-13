package com.example.raghav.jetpackgithub.util

import java.text.SimpleDateFormat
import java.util.*

fun convertTimeFormat(time: String): String {
    val inputDf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputDf = SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.getDefault())
    return outputDf.format(inputDf.parse(time))
}