package com.example.openinappanalyticsdashboard

import java.text.SimpleDateFormat
import java.util.Calendar


object Helper {

    fun getGreetingForTheDay(): String {
        val c = Calendar.getInstance()
        when (c[Calendar.HOUR_OF_DAY]) {
            in 0..11 -> {
                return "Good Morning"
            }

            in 12..15 -> {
                return "Good Afternoon"
            }

            in 16..20 -> {
                return "Good Evening"
            }

            in 21..23 -> {
                return "Good Night"
            }
        }
        return "Hello"
    }

    fun extractMonthFromDate(date: String): String? {
        try {
            val date = SimpleDateFormat("yyyy-MM-dd").parse(date)
            val calendar = Calendar.getInstance()
            calendar.time = date
            return SimpleDateFormat("MMM").format(calendar.time)
        } catch (e: Exception) {
            return null
        }

    }

    private fun extractMonthAndDay(date: String): String? {
        try {
            val date = SimpleDateFormat("yyyy-MM-dd").parse(date)
            val calendar = Calendar.getInstance()
            calendar.time = date
            return SimpleDateFormat("dd").format(calendar.time).plus(" ")
                .plus(SimpleDateFormat("MMM").format(calendar.time))
        } catch (e: Exception) {
            return null
        }
    }

    fun findRangeBetweenDates(chart: Map<String, Int>?): String {
        if (chart == null) {
            return ""
        }
        val map = chart.filter { it.value != 0 }.mapNotNull { extractMonthAndDay(it.key) }
        return map.first().plus(" - ").plus(map.last())
    }

    fun Any?.nonNullString(): String {
        val value = this.toString()
        return if (value.contains("null")) "" else value
    }
}