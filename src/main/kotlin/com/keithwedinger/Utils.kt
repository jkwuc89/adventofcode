package com.keithwedinger

import java.io.InputStream

/**
 * Utility methods shared amongst all tests
 *
 * @author Keith Wedinger <br>
 * Created On: 12/18/17
 */
class Utils {
    fun readTestInput(testInputStream: InputStream) : List<String> {
        val testInput = testInputStream.bufferedReader().use { it.readText() }
        return testInput.split("\n")
    }
}