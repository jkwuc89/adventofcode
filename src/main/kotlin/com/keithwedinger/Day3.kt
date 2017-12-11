package com.keithwedinger

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Day 3 Puzzle
 * http://adventofcode.com/2017/day/3
 *
 * @author Keith Wedinger <br>
 * Created On: 12/6/17
 */
class Day3 {
    fun getSpiralMemoryAccessSteps(input: Int) : Int {
        if (input == 0) throw IllegalArgumentException("0 is invalid input")

        val distance: Int
        if (input == 1) {
            distance = 0
        } else {
            val circle = (ceil(sqrt(input.toDouble())).toInt()) / 2
            val circleZero = (circle.toDouble() * 2 - 1).pow(2).toInt()

            val centers = ArrayList<Int>()
            (1..7 step 2).mapTo(centers) {
                circleZero + it * circle
            }

            val distances = ArrayList<Int>()
            centers.forEach { x ->
                distances.add(abs(input - x))
            }
            distance = (circle + distances.min()!!)
        }
        return distance
    }

    private enum class Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private fun getValue(map: HashMap<Pair<Int, Int>, Int>, key: Pair<Int, Int>): Int {
        var value = 0
        if (map.containsKey(key)) {
            value = map[key]!!
        }
        return value
    }

    fun getNextLargerValue(input: Int) : Int {
        if (input == 0) throw IllegalArgumentException("0 is invalid input")
        
        var x = 0
        var y = 0
        var layerSteps = 1
        var newLayer = true
        var direction = Direction.EAST
        val valueMap = HashMap<Pair<Int, Int>, Int>()
        valueMap.put(Pair(0, 0), 1)
        while (true) {
            var j = 0
            while (j < layerSteps) {
                when (direction) {
                    Direction.NORTH -> y += 1
                    Direction.SOUTH -> y -= 1
                    Direction.EAST -> x += 1
                    Direction.WEST -> x -= 1
                }

                var nextLargerValue = 0

                nextLargerValue += getValue(valueMap, Pair(x, y + 1))
                nextLargerValue += getValue(valueMap, Pair(x, y - 1))
                nextLargerValue += getValue(valueMap, Pair(x + 1, y))
                nextLargerValue += getValue(valueMap, Pair(x + 1, y + 1))
                nextLargerValue += getValue(valueMap, Pair(x + 1, y - 1))
                nextLargerValue += getValue(valueMap, Pair(x - 1, y))
                nextLargerValue += getValue(valueMap, Pair(x - 1, y + 1))
                nextLargerValue += getValue(valueMap, Pair(x - 1, y - 1))

                if (nextLargerValue > input) {
                    return nextLargerValue
                } else {
                    valueMap.put(Pair(x, y), nextLargerValue)
                }
                j++
            }
            direction = when (direction) {
                Direction.NORTH -> Direction.WEST
                Direction.SOUTH -> Direction.EAST
                Direction.EAST -> Direction.NORTH
                Direction.WEST -> Direction.SOUTH
            }
            newLayer = (newLayer.not())
            if (newLayer) {
                layerSteps += 1
            }
        }
    }
}