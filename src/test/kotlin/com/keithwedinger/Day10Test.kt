package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day10
 *
 * @author Keith Wedinger <br>
 * Created On: 12/21/17
 */
class Day10Test {
    private val day10 = Day10()
    @Test
    internal fun `getKnotHashPart1 with sample puzzle input`() {
        Assertions.assertEquals(12,
                day10.getKnotHashPart1(arrayListOf(0, 1, 2, 3, 4), arrayListOf(3, 4, 1, 5)))
    }
}