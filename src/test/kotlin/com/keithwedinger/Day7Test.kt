package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day7
 *
 * @author Keith Wedinger <br>
 * Created On: 12/14/17
 */

class Day7Test {
    private val day7 = Day7()

    @Test
    internal fun `findBottomProgram with puzzle sample input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7Part1SamplePuzzleInput.txt")
        Assertions.assertEquals("tknk", day7.findBottomProgram(testInputStream))
    }

    @Test
    internal fun `findBottomProgram with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7Part1PuzzleInput.txt")
        Assertions.assertEquals("fbgguv", day7.findBottomProgram(testInputStream))
    }
}