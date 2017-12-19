package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day7
 *
 * @author Keith Wedinger <br>
 * Created On: 12/14/17
 */

class Day8Test {
    private val day8 = Day8()

    @Test
    internal fun `runProgramAndReturnLargestRegisterValue with puzzle sample input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day8SamplePuzzleInput.txt")
        Assertions.assertEquals(1, day8.runProgramAndReturnLargestRegisterValue(testInputStream))
    }

    @Test
    internal fun `runProgramAndReturnLargestRegisterValue with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day8PuzzleInput.txt")
        Assertions.assertEquals(5215, day8.runProgramAndReturnLargestRegisterValue(testInputStream))
    }
}