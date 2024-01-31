package com.example.openinappanalyticsdashboard

import java.text.SimpleDateFormat
import java.util.Calendar


object Helper {

    fun getGreetingForTheDay(hourOfTheDay: Int): String {
        when (hourOfTheDay) {
            in 0..11 -> {
                return "Good Morning"
            }

            in 12..15 -> {
                return "Good Afternoon"
            }

            in 16..20 -> {
                return "Good Evening"
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

     fun extractMonthAndDay(date: String): String? {
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
        if(chart.isEmpty()){
            return ""
        }
        val map = chart.filter { it.value != 0 }.mapNotNull { extractMonthAndDay(it.key) }
        return if(map.size>1) map.first().plus(" - ").plus(map.last()) else map.first()
    }

    fun Any?.nonNullString(): String {
        val value = this.toString()
        return if (value.contains("null")) "" else value
    }
}