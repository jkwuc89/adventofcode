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

    private class Location(internal var x: Int, internal var y: Int) {
        override fun toString(): String {
            return x.toString() + "," + y
        }
    }

    private fun getValue(map: HashMap<String, Int>, x: Int, y: Int): Int {
        var value = 0
        val location = Location(x, y)
        if (map.containsKey(location.toString())) {
            value = map[location.toString()]!!
        }
        return value
    }

    // val input = 347991

    fun getNextLargerValue(input: Int) : Int {
        if (input == 0) throw IllegalArgumentException("0 is invalid input")
        
        var x = 0
        var y = 0
        var layerSteps = 1
        var newLayer: Boolean? = true
        var direction = Direction.EAST
        val valueMap = HashMap<String, Int>()
        valueMap.put(Location(0, 0).toString(), 1)
        while (true) {
            var j = 0
            while (j < layerSteps) {
                when (direction) {
                    Direction.NORTH -> y += 1
                    Direction.SOUTH -> y -= 1
                    Direction.EAST -> x += 1
                    Direction.WEST -> x -= 1
                }

                var value = 0

                value += getValue(valueMap, x, y + 1)
                value += getValue(valueMap, x, y - 1)
                value += getValue(valueMap, x + 1, y)
                value += getValue(valueMap, x + 1, y + 1)
                value += getValue(valueMap, x + 1, y - 1)
                value += getValue(valueMap, x - 1, y)
                value += getValue(valueMap, x - 1, y + 1)
                value += getValue(valueMap, x - 1, y - 1)

                if (value >= input) {
                    return value
                } else {
                    valueMap.put(Location(x, y).toString(), value)
                }
                j += 1
            }
            direction = when (direction) {
                Direction.NORTH -> Direction.WEST
                Direction.SOUTH -> Direction.EAST
                Direction.EAST -> Direction.NORTH
                Direction.WEST -> Direction.SOUTH
            }
            newLayer = (newLayer!!.not())
            if (newLayer) {
                layerSteps += 1
            }
        }
    }
}