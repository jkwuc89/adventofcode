package com.keithwedinger

import org.apache.commons.lang3.StringUtils
import java.lang.Character.getNumericValue

/**
 * Day 1 Puzzle
 * http://adventofcode.com/2017/day/1
 *
 * @author Keith Wedinger <br>
 * Created On: 12/1/17
 */
class Day1 {
    fun sumUsingNextDigit(input: String): Long {
        if (input.isEmpty() || !StringUtils.isNumeric(input)) {
            throw IllegalArgumentException("'$input' is empty or non-numeric")
        }

        val inputArray = input.toCharArray()
        var sum = 0L

        for (i in 0..inputArray.size - 2) {
            val currentNumber = getNumericValue(inputArray[i])
            val nextNumber = getNumericValue(inputArray[i + 1])
            if (currentNumber == nextNumber) sum += currentNumber
        }

        val firstNumber = getNumericValue(inputArray.first())
        val lastNumber = getNumericValue(inputArray.last())
        if (firstNumber == lastNumber) sum += firstNumber

        return sum
    }

    fun sumUsingDigitHalfwayForward(input: String): Long {
        if (input.isEmpty() || !StringUtils.isNumeric(input)) {
            throw IllegalArgumentException("'$input' is empty or non-numeric")
        }

        val inputArray = input.toCharArray()
        val halfwayIndexIncrement = inputArray.size / 2
        val lastIndex = inputArray.size - 1
        var sum = 0L

        for (i in 0..lastIndex) {
            val currentNumber = getNumericValue(inputArray[i])
            var halfwayForwardIndex = i + halfwayIndexIncrement
            if (halfwayForwardIndex > lastIndex) {
                halfwayForwardIndex -= inputArray.size
            }
            val numberHalfwayForward = getNumericValue(inputArray[halfwayForwardIndex])
            if (currentNumber == numberHalfwayForward) sum += currentNumber
        }

        return sum
    }
}