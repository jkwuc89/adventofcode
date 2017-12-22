package com.keithwedinger

/**
 * Day 10 Puzzle
 * http://adventofcode.com/2017/day/10
 *
 * @author Keith Wedinger <br>
 * Created On: 12/21/17
 */

class Day10 {
    fun getKnotHashPart1(circularList: ArrayList<Int>, lengths: ArrayList<Int>) : Int {
        var currentPosition = 0
        var skipSize = 0
        val validLengths = lengths.filter {
            it <= circularList.size
        }

        validLengths.forEach { length ->
            var numbersLeft = length
            val reversedSublist = ArrayList<Int>()

            // Get the sublist to reverse
            var index = currentPosition
            while (numbersLeft > 0) {
                if (index >= circularList.size) {
                    index = 0
                }
                reversedSublist.add(circularList[index])
                index++
                numbersLeft--
            }

            // Reverse the sublist
            reversedSublist.reverse()

            // Replace list contents with reversed sublist
            index = currentPosition
            reversedSublist.forEach {
                if (index >= circularList.size) {
                    index = 0
                }
                circularList[index] = it
                index++
            }

            // Adjust currentPosition by length + skipSize, wrapping when necessary
            currentPosition += (length + skipSize)
            if (currentPosition >= circularList.size) {
                currentPosition -= circularList.size
            }
            skipSize++
        }

        return (circularList[0] * circularList[1])
    }
}