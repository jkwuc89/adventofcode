package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day33
 *
 * @author Keith Wedinger <br>
 * Created On: 12/6/17
 */

class Day3Test {
    private val day3 = Day3()

    @Test
    internal fun `getSpiralMemoryAccessSteps with 0 throws IllegalArgumentException`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            day3.getSpiralMemoryAccessSteps(0)
        }
    }

    @Test
    internal fun `getSpiralMemoryAccessSteps with puzzle example inputs`() {
        Assertions.assertEquals(0, day3.getSpiralMemoryAccessSteps(1))
        Assertions.assertEquals(3, day3.getSpiralMemoryAccessSteps(12))
        Assertions.assertEquals(2, day3.getSpiralMemoryAccessSteps(23))
        Assertions.assertEquals(31, day3.getSpiralMemoryAccessSteps(1024))
        Assertions.assertEquals(480, day3.getSpiralMemoryAccessSteps(347991))
    }
}