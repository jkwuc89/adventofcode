package com.keithwedinger

/**
 * Day 2 Puzzle
 * http://adventofcode.com/2017/day/2
 *
 * @author Keith Wedinger <br>
 * Created On: 12/4/17
 */
class Day2 {
    fun checksumUsingMinAndMax(spreadsheet: ArrayList<IntArray>): Long {
        var checksum = 0L

        if (spreadsheet.isEmpty()) {
            throw IllegalArgumentException("spreadsheet is empty")
        }

        spreadsheet.forEach{ currentRow ->
            if (currentRow.isNotEmpty()) {
                checksum += (currentRow.max()!! - currentRow.min()!!)
            } else {
                throw IllegalArgumentException("spreadsheet contains empty row")
            }
        }

        return checksum
    }

    fun checksumUsingEvenlyDivisible(spreadsheet: ArrayList<IntArray>): Long {
        var checksum = 0L

        if (spreadsheet.isEmpty()) {
            throw IllegalArgumentException("spreadsheet is empty")
        }

        spreadsheet.forEach{ currentRow ->
            if (currentRow.isNotEmpty()) {
                currentRow.sortDescending()
                currentRow.forEachIndexed{ index, currentNumInRow ->
                    ((index + 1)..(currentRow.size - 1))
                        .filter { currentNumInRow % currentRow[it] == 0 }
                        .forEach { checksum += currentNumInRow / currentRow[it] }
                }
            } else {
                throw IllegalArgumentException("spreadsheet contains empty row")
            }
        }

        return checksum
    }
}