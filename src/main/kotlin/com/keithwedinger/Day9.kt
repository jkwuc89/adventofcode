package com.keithwedinger

/**
 * Day 9 Puzzle
 * http://adventofcode.com/2017/day/9
 *
 * @author Keith Wedinger <br>
 * Created On: 12/19/17
 */

/*
func part2() -> Int {
    var answer = 0
    var garbage = false
    var depth = 1
    var prevChar: Character = " "

    for currChar in input {

        switch (prevChar, currChar, garbage) {
        case ("!", "!", true):
            prevChar = " "
            continue
        case ("!", _, true):
            break
        case (_, "<", false):
            garbage = true
        case (_, ">", true):
            garbage = false
        case (_, "{", false):
            depth += 1
        case (_, "}", false):
            depth -= 1
        case(_, _, true):
            if currChar != "!" {
                answer += 1
            }
        default:
            break
        }

        prevChar = currChar
    }

    return answer
}
 */


class Day9 {
    data class StreamState(var prevChar: Char, var currChar: Char, var garbage: Boolean)

    fun getGroupScoreAndNonCanceledGarbage(stream: String): Pair<Int, Int> {
        val streamChars = stream.toCharArray()
        val streamState = StreamState(' ', ' ', false)
        var canceledChar = false
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