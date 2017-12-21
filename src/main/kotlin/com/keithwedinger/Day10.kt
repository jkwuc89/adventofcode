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
        var insertPositionForSublist = currentPosition
        var skipSize = 0
        val validLengths = lengths.filter {
            it <= circularList.size
        }

        validLengths.forEach { length ->
            insertPositionForSublist = currentPosition + skipSize
            var numbersLeft= length
            val reversedSublist = ArrayList<Int>()

            // Get the sublist to reverse
            while (numbersLeft > 0) {
                if (currentPosition == circularList.size) {
                    currentPosition = 0
                }
                reversedSublist.add(circularList[currentPosition])
                currentPosition++
                numbersLeft--
            }

            // Reverse the sublist
            reversedSublist.reverse()

            // Replace list contents with reversed sublist
            var currentReplacePosition = insertPositionForSublist
            reversedSublist.forEach {
                if (currentReplacePosition == circularList.size) {
                    currentReplacePosition = 0
                }
                circularList[currentReplacePosition] = it
                currentReplacePosition++
            }

            skipSize++
        }

        return 0
    }
}