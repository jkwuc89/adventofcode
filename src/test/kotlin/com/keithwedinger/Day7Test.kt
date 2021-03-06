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
        val testInputStream = this.javaClass.getResourceAsStream("/Day7SamplePuzzleInput.txt")
        Assertions.assertEquals("tknk", day7.findBottomProgram(testInputStream))
    }

    @Test
    internal fun `findBottomProgram with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7PuzzleInput.txt")
        Assertions.assertEquals("fbgguv", day7.findBottomProgram(testInputStream))
    }

    @Test
    internal fun `solvePart1 with puzzle sample input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7SamplePuzzleInput.txt")
        Assertions.assertEquals("tknk", day7.solvePart1(testInputStream))
    }

    @Test
    internal fun `solvePart1 with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7PuzzleInput.txt")
        Assertions.assertEquals("fbgguv", day7.solvePart1(testInputStream))
    }

    @Test
    internal fun `solvePart2 with puzzle sample input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7SamplePuzzleInput.txt")
        Assertions.assertEquals(60, day7.solvePart2(testInputStream))
    }

    @Test
    internal fun `solvePart2 with puzzle input`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day7PuzzleInput.txt")
        Assertions.assertEquals(1864, day7.solvePart2(testInputStream))
    }
}