package com.keithwedinger

import java.io.InputStream

/**
 * Day 7 Puzzle
 * http://adventofcode.com/2017/day/7
 *
 * @author Keith Wedinger <br>
 * Created On: 12/14/17
 */

class Day7 {
    /**
     * Part 1
     */
    fun findBottomProgram(programTowerInputStream: InputStream) : String {
        val programTowerInput = programTowerInputStream.bufferedReader().use { it.readText() }

        // Input regex, 1 = Node ID, 2 = Weight (Unused), 4 = Comma-delimited Children
        val regex = """(\w+) \((\d+)\)( -> ([\w, ]+))?""".toRegex()
        val programNames = HashMap<String, Boolean>()
        val programs = ArrayList<MatchGroupCollection>()

        // Split stream input and split lines into program names and program fields
        programTowerInput.split("\n").forEach{
            val programFields = regex.matchEntire(it)!!.groups
            programNames.put(programFields[1]!!.value, true)
            programs.add(programFields)
        }

        // If there are children, then delete those children from the program names
        // as they obviously cannot be the root node (as they have a parent)
        programs.forEach{ programFields ->
            if (programFields[4] != null) {
                programFields[4]!!.value.split(", ").forEach{
                    programNames.remove(it)
                }
            }
        }

        // Program names map should have 1 node left, the root node.
        var rootProgramName = ""
        if (!programNames.isEmpty()) {
            rootProgramName = programNames.iterator().next().key
        }

        return rootProgramName
    }
}