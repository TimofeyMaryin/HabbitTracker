package com.broad.habbit.domain

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

fun getCurrentDate(): String {
    val locale = Locale("ru")
    val dateFormat = SimpleDateFormat("dd MMM yyyy", locale)
    Log.e("TAG", "getCurrentDate: ${dateFormat.format(Date())}", )
    return dateFormat.format(Date())
}