package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for com.keithwedinger.Day1
 *
 * @author Keith Wedinger <br>
 * Created On: 12/1/17
 */

class Day1Test {
    private val day1 = Day1()

    @Test
    internal fun `Sum with 1 digit returns 0`() {
        Assertions.assertEquals(0, day1.sum("1"))
    }

    @Test
    internal fun `Sum with empty string throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sum("")
        }
    }

    @Test
    internal fun `Sum with non-numeric input throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day1.sum("Non numeric input")
        }
    }
}