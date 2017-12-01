package com.keithwedinger

import org.apache.commons.lang3.StringUtils

/**
 * Day 1 Puzzle
 *
 * @author Keith Wedinger <br>
 * Created On: 12/1/17
 */
fun main(args: Array<String>) {
    val day1 = Day1()
    println("Sum = " + day1.sum(""))
}

class Day1 {
    fun sum(input: String) : Long {
        if (input.isEmpty() || !StringUtils.isNumeric(input)) {
            throw IllegalArgumentException("'$input' is empty or non-numeric")
        }
        return 0
    }
}