package com.keithwedinger

/**
 * Day 10 Puzzle
 * http://adventofcode.com/2017/day/10
 *
 * @author Keith Wedinger <br>
 * Created On: 12/21/17
 */

class Day10 {
    /**
     * Rearrange the list as described in the day 10 puzzle
     * @return Pair<Int, Int> containing current position and skip size after rearrange is complete
     */
    private fun rearrangeList(circularList: ArrayList<Int>, lengths: ArrayList<Int>,
                              startingPosition: Int = 0, startingSkipSize: Int = 0): Pair<Int, Int> {
        var currentPosition = startingPosition
        var skipSize = startingSkipSize
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
        return Pair(currentPosition, skipSize)
    }

    fun getKnotHashPart1(circularList: ArrayList<Int>, lengths: ArrayList<Int>): Int {
        rearrangeList(circularList, lengths)
        return (circularList[0] * circularList[1])
    }

    fun getKnotHashPart2(circularList: ArrayList<Int>, lengths: ArrayList<Int>): Int {
        // These are always added to the end to the lengths
        val additionalPuzzleLengths = arrayListOf(17, 31, 73, 47, 23)

        // Convert lengths to their ASCII representations
        val asciiLengths = ArrayList<Int>()
        lengths.mapTo(asciiLengths) {
            it.toString().toCharArray()[0].toInt()
        }
        asciiLengths.addAll(additionalPuzzleLengths)

        // Rearrange the list 64 times
        var currentPositionAndSkipSize = Pair(0, 0)
        for(i in 1..64) {
            currentPositionAndSkipSize = rearrangeList(circularList, asciiLengths,
                    currentPositionAndSkipSize.first, currentPositionAndSkipSize.second)
        }

        return 0
    }
}