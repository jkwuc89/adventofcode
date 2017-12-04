package com.keithwedinger

/**
 * Day 1 Puzzle
 *
 * @author Keith Wedinger <br>
 * Created On: 12/4/17
 */

fun main(args: Array<String>) {

}

class Day2 {
    fun checksum(spreadsheet: ArrayList<IntArray>): Long {
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
}