package com.keithwedinger

import java.io.InputStream

/**
 * Day 8 Puzzle
 * http://adventofcode.com/2017/day/8
 *
 * @author Keith Wedinger <br>
 * Created On: 12/19/17
 */

class Day8 {
    private val utils = Utils()
    /**
     * Returns a Pair containing the following:
     * Largest register value currently stored
     * Maximum register value encountered while running the program
     */
    fun runProgramAndReturnLargestAndMaxRegisterValue(program: InputStream): Pair<Int, Int> {
        val instructions = utils.readTestInput(program)
        var maxRegisterValue = 0
        val registers = HashMap<String, Int>()
        instructions.forEach{
            // Each instruction consists the following parts:
            // [0] register
            // [1] dec or inc
            // [2] dec or inc value
            // [3] if
            // [4] register to check in condition
            // [5] condition operator
            // [6] condition value to check
            // Example: b inc 5 if a > 1
            val instructionParts = it.split(" ")
            val register = instructionParts[0]
            val isIncrementOperation = (instructionParts[1] == "inc")
            val operationValue = instructionParts[2].toInt()
            val registerToCheck = instructionParts[4]
            val conditionOperator = instructionParts[5]
            val valueToCheck = instructionParts[6].toInt()

            // New registers default to value of 0
            var currentRegisterValue = 0
            if (registers.containsKey(register)) {
                currentRegisterValue = registers[register]!!
            } else {
                registers.put(register, 0)
            }

            // Get value of register in condition statement, defaults to 0
            // if the register does not exist yet
            val conditionRegisterValue = registers[registerToCheck] ?: 0

            // Check the operation condition
            val performOperation = when(conditionOperator) {
                ">" -> conditionRegisterValue > valueToCheck
                "<" -> conditionRegisterValue < valueToCheck
                "==" -> conditionRegisterValue == valueToCheck
                "!=" -> conditionRegisterValue != valueToCheck
                ">=" -> conditionRegisterValue >= valueToCheck
                "<=" -> conditionRegisterValue <= valueToCheck
                else -> false
            }

            // Perform the increment or decrement if condition was met
            if (performOperation) {
                if (isIncrementOperation) {
                    registers[register] = currentRegisterValue + operationValue
                } else {
                    registers[register] = currentRegisterValue - operationValue
                }
                maxRegisterValue = maxOf(maxRegisterValue, registers[register] ?: 0)
            }
        }

        // Return the largest register value
        return Pair(registers.values.max() ?: 0, maxRegisterValue)
    }
}