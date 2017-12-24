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
    private val puzzleLengthsSampleInput = arrayListOf(3, 4, 1, 5)
    private val puzzleLengthsInput = arrayListOf(230, 1, 2, 221, 97, 252, 168, 169, 57, 99, 0, 254, 181, 255, 235, 167)

    @Test
    internal fun `getKnotHashPart1 with sample puzzle input`() {
        Assertions.assertEquals(12,
                day10.getKnotHashPart1(arrayListOf(0, 1, 2, 3, 4), puzzleLengthsSampleInput))
    }

    @Test
    internal fun `getKnotHashPart1 with puzzle input`() {
        val puzzleListInput = ArrayList<Int>()
        puzzleListInput += 0..255
        Assertions.assertEquals(2928,
                day10.getKnotHashPart1(puzzleListInput, puzzleLengthsInput))
    }

    @Test
    internal fun `getKnotHashPart2 with sample puzzle input`() {
        Assertions.assertEquals(12,
                day10.getKnotHashPart2(arrayListOf(0, 1, 2, 3, 4), puzzleLengthsSampleInput))
    }
}