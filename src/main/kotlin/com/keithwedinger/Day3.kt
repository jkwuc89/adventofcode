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
}