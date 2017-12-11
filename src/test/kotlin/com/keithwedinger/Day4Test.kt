package com.keithwedinger

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Tests for Day4
 *
 * @author Keith Wedinger <br>
 * Created On: 12/6/17
 */

class Day4Test {
    private val day4 = Day4()

    @Test
    internal fun `isValidPassphrasePart1 with empty string returns false`() {
        Assertions.assertFalse(day4.isValidPassphrasePart1(""))
    }

    @Test
    internal fun `isValidPassphrasePart1 with sample passphrases from puzzle`() {
        Assertions.assertTrue(day4.isValidPassphrasePart1("aa bb cc dd ee"))
        Assertions.assertFalse(day4.isValidPassphrasePart1("aa bb cc dd aa"))
        Assertions.assertTrue(day4.isValidPassphrasePart1("aa bb cc dd aaa"))
    }

    @Test
    internal fun `isValidPassphrasePart1 with sample passphrases from file`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day4Part1SamplePassphrases.txt")
        Assertions.assertEquals(2, day4.countValidPassphrases(testInputStream))
    }

    @Test
    internal fun `isValidPassphrasePart1 with puzzle input from file`() {
        val testInputStream = this.javaClass.getResourceAsStream("/Day4Part1PassphraseInput.txt")
        Assertions.assertEquals(325, day4.countValidPassphrases(testInputStream))
    }
}