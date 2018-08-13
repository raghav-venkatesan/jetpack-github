package com.example.raghav.jetpackgithub

import com.example.raghav.jetpackgithub.util.convertTimeFormat
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateUtilTest {
    @Test
    fun inputIsCorrect() {
        val dateString = "2016-08-22T16:56:26Z"
        assertEquals("Aug 22, 2016 4:56:26 PM", convertTimeFormat(dateString))
    }

    @Test
    fun inputIsWrong() {
        val dateString = "2016-08-2T16:56:26Z"
        assertNotEquals("Aug 22, 2016 4:56:26 PM", convertTimeFormat(dateString))
    }
}
