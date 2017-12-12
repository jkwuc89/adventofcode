package com.keithwedinger

/**
 * Day 5 Puzzle
 * http://adventofcode.com/2017/day/5
 *
 * @author Keith Wedinger <br>
 * Created On: 12/12/17
 */

class Day5 {
    fun traverseJumpMaze(maze: ArrayList<Int>) : Int {
        var currentPosition = 0
        var newPosition = 0
        var exited = false
        var jumps = 0

        while(!exited) {
            newPosition = currentPosition + maze[currentPosition]
            maze[currentPosition]++
            currentPosition = newPosition
            jumps++
            exited = (currentPosition < 0 || currentPosition >= maze.size)
        }

        // Return the number of jumps it took to exit the maze
        return jumps
    }
}