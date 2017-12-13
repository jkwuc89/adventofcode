package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day6
 *
 * @author Keith Wedinger <br>
 * Created On: 12/13/17
 */

class Day6Test {
    private val day6 = Day6()
    private val puzzleInput = arrayListOf<Int>(11, 11, 13, 7, 0, 15, 5, 5, 4, 4, 1, 1, 7, 1, 15, 11)

    @Test
    internal fun `reallocateMemoryPart1 with puzzle sample input`() {
        Assertions.assertEquals(5, day6.reallocateMemoryPart1(arrayListOf(0, 2, 7, 0)))
    }

    @Test
    internal fun `reallocateMemoryPart1 with puzzle input`() {
        Assertions.assertEquals(4074, day6.reallocateMemoryPart1(puzzleInput))
    }
}