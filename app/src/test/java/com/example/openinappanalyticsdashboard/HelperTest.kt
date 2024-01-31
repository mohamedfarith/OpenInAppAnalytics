package com.example.openinappanalyticsdashboard

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Calendar

@RunWith(JUnit4::class)
class HelperTest {

    @Test
    fun `get greeting for the day should return Good Morning`() {
        Assert.assertEquals("Good Morning", Helper.getGreetingForTheDay(1))
    }

    @Test
    fun `get greeting for the day should return Good Afternoon`() {
        Assert.assertEquals("Good Afternoon", Helper.getGreetingForTheDay(13))
    }

    @Test
    fun `get greeting for the day should return Good Evening`() {
        Assert.assertEquals("Good Evening", Helper.getGreetingForTheDay(16))
    }

    @Test
    fun `get greeting for the day invalid hour case`() {
        Assert.assertEquals("Hello", Helper.getGreetingForTheDay(-1))
    }

    @Test
    fun `extract month from date return Nov`() {
        Assert.assertEquals("Nov", Helper.extractMonthFromDate("2024-11-30"))
    }

    @Test
    fun `extract month from date return Oct`() {
        Assert.assertEquals("Oct", Helper.extractMonthFromDate("2024-10-31"))
    }

    @Test
    fun `extract month from date handle invalid inputCase1`() {
        Assert.assertEquals(null, Helper.extractMonthFromDate("202410-31"))
    }

    @Test
    fun `extract month from date handle invalid inputCase2`() {
        Assert.assertEquals(null, Helper.extractMonthFromDate(""))
    }

    @Test
    fun `extract month and day return 31 Oct`() {
        Assert.assertEquals("31 Oct", Helper.extractMonthAndDay("2024-10-31"))
    }

    @Test
    fun `extract month and day return 09 Aug`() {
        Assert.assertEquals("09 Aug", Helper.extractMonthAndDay("2024-08-09"))
    }

    @Test
    fun `extract month and day handle invalid inputCase1`() {
        Assert.assertEquals(null, Helper.extractMonthAndDay(""))
    }

    @Test
    fun `extract month and day handle invalid inputCase2`() {
        Assert.assertEquals(null, Helper.extractMonthAndDay("2024/08/09"))
    }

    @Test
    fun `find range between dates return 23 Jan - 30 Jan`() {
        Assert.assertEquals(
            "23 Jan - 30 Jan", Helper.findRangeBetweenDates(
                mapOf(
                    "2024-01-22" to 0,
                    "2024-01-23" to 13,
                    "2024-01-24" to 41,
                    "2024-01-25" to 199,
                    "2024-01-26" to 7,
                    "2024-01-27" to 2,
                    "2024-01-28" to 0,
                    "2024-01-29" to 3,
                    "2024-01-30" to 3,
                )
            )
        )
    }

    @Test
    fun `find range between dates return 25 Jan`() {
        Assert.assertEquals(
            "25 Jan", Helper.findRangeBetweenDates(
                mapOf(
                    "2024-01-25" to 199,
                )
            )
        )
    }

    @Test
    fun `find range between dates handle invalid inputCase1`() {
        Assert.assertEquals(
            "", Helper.findRangeBetweenDates(null)
        )
    }

    @Test
    fun `find range between dates handle invalid inputCase2`() {
        Assert.assertEquals(
            "", Helper.findRangeBetweenDates(hashMapOf())
        )
    }
}