package com.keithwedinger

/**
 * Day 5 Puzzle
 * http://adventofcode.com/2017/day/5
 *
 * @author Keith Wedinger <br>
 * Created On: 12/13/17
 */

class Day6 {
    fun reallocateMemoryPart1(banks: ArrayList<Int>): Int {
        var cycles = 1
        var reallocationSeenBefore = false
        val reallocationResults = HashMap<Int, Int>()

        while (!reallocationSeenBefore) {
            // Get the blocks to reallocate
            var blocksToReallocate = banks.max()!!
            val blocksToReallocateIndex = banks.indexOfFirst { it == blocksToReallocate }

            // Reset reallocated blocks to 0
            banks[blocksToReallocateIndex] = 0

            // Perform the block reallocation
            var reallocationIndex = blocksToReallocateIndex + 1
            while (blocksToReallocate > 0) {
                if (reallocationIndex == banks.size) {
                    reallocationIndex = 0
                }
                banks[reallocationIndex]++
                blocksToReallocate--
                reallocationIndex++
            }

            // Did the reallocation repeat itself?
            val reallocatedBanksHash = banks.hashCode()
            if (reallocationResults.containsKey(reallocatedBanksHash)) {
                reallocationSeenBefore = true
            } else {
                reallocationResults.put(reallocatedBanksHash, 0)
                cycles++
            }
        }

        return cycles
    }
}