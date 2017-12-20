package com.keithwedinger

/**
 * Day 9 Puzzle
 * http://adventofcode.com/2017/day/9
 *
 * @author Keith Wedinger <br>
 * Created On: 12/19/17
 */
class Day9 {
    data class StreamState(var prevChar: Char, var currChar: Char, var garbage: Boolean)

    fun getGroupScoreAndNonCanceledGarbage(stream: String): Pair<Int, Int> {
        val streamChars = stream.toCharArray()
        val streamState = StreamState(' ', ' ', false)
        var depth = 1
        var score = 0
        var garbageCount = 0

        streamChars.forEach { currChar ->
            streamState.currChar = currChar
            when {
                (streamState.prevChar == '!' && streamState.currChar == '!' && streamState.garbage) -> {
                    streamState.prevChar = ' '
                    return@forEach
                }
                (streamState.currChar == '<' && !streamState.garbage) -> streamState.garbage = true
                (streamState.prevChar != '!' && streamState.currChar == '>' && streamState.garbage) -> streamState.garbage = false
                (streamState.currChar == '{' && !streamState.garbage) -> {
                    score += depth
                    depth++
                }
                (streamState.currChar == '}' && !streamState.garbage) -> depth--
                (streamState.prevChar != '!' && streamState.currChar != '!' && streamState.garbage) -> garbageCount++
            }
            streamState.prevChar = streamState.currChar
        }

        return Pair(score, garbageCount)
    }
}