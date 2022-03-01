package com.leesuchan.coreui.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern: String = "yyyy-MM-dd"): String {
    return SimpleDateFormat(pattern, Locale.KOREA).format(this)
}