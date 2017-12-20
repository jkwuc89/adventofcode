package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day8
 *
 * @author Keith Wedinger <br>
 * Created On: 12/14/17
 */

class Day8Test {
    private val day8 = Day8()

    @Test
    internal fun `runProgramAndReturnLargestAndMaxRegisterValue with puzzle sample input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day8SamplePuzzleInput.txt")
        Assertions.assertEquals(Pair(1, 10), day8.runProgramAndReturnLargestAndMaxRegisterValue(testInputStream))
    }

    @Test
    internal fun `runProgramAndReturnLargestRegisterValue with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day8PuzzleInput.txt")
        Assertions.assertEquals(Pair(5215, 6419), day8.runProgramAndReturnLargestAndMaxRegisterValue(testInputStream))
    }
}