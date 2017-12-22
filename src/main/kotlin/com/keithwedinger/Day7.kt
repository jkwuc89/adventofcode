package com.keithwedinger

import java.io.InputStream
import kotlin.math.absoluteValue

/**
 * Day 7 Puzzle
 * http://adventofcode.com/2017/day/7
 *
 * @author Keith Wedinger <br>
 * Created On: 12/14/17
 */
class Day7 {
    private val utils = Utils()

    /**
     * Part 1
     */
    fun findBottomProgram(programTowerInputStream: InputStream): String {
        // Input regex, 1 = Node ID, 2 = Weight, 4 = Comma-delimited Children
        val regex = """(\w+) \((\d+)\)( -> ([\w, ]+))?""".toRegex()
        val programNames = HashMap<String, Boolean>()
        val programs = ArrayList<MatchGroupCollection>()

        // Split stream input and split lines into program names and program fields
        utils.readTestInput(programTowerInputStream).forEach {
            val programFields = regex.matchEntire(it)!!.groups
            programNames.put(programFields[1]!!.value, true)
            programs.add(programFields)
        }

        // If there are children, then delete those children from the program names
        // as they obviously cannot be the root node (as they have a parent)
        programs.forEach { programFields ->
            if (programFields[4] != null) {
                programFields[4]!!.value.split(", ").forEach {
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

    /**
     * From Day 7 solutions thread on subreddit
     */
    fun solvePart1(programTowerInputStream: InputStream): String {
        val headOfTree = parseInput(utils.readTestInput(programTowerInputStream))
        return headOfTree.name
    }

    fun solvePart2(programTowerInputStream: InputStream): Int {
        val headOfTree = parseInput(utils.readTestInput(programTowerInputStream))
        return headOfTree.findImbalance()
    }

    private fun parseInput(input: List<String>): Node {
        val nodesByName = mutableMapOf<String, Node>()
        val parentChildPairs = mutableSetOf<Pair<Node, String>>()
        val rowRegex = """\w+""".toRegex()

        input.forEach {
            val groups = rowRegex.findAll(it).toList().map { it.value }
            val node = Node(groups[0], groups[1].toInt())
            nodesByName.put(node.name, node)

            groups.drop(2).forEach {
                parentChildPairs.add(Pair(node, it))
            }
        }

        parentChildPairs.forEach { (parent, childName) ->
            with(nodesByName.getValue(childName)) {
                parent.children.add(this)
                this.parent = parent
            }
        }

        // Find the one node we have without a parent. Or freak out.
        return nodesByName.values.firstOrNull { it.parent == null }
                ?: throw IllegalStateException("No head node?!")
    }

}

data class Node(val name: String,
                private val weight: Int,
                val children: MutableList<Node> = mutableListOf(),
                var parent: Node? = null) {

    fun findImbalance(imbalance: Int? = null): Int =
        if (imbalance != null && childrenAreBalanced) {
            // We end when I have a positive imbalance and my children are balanced.
            weight - imbalance
        } else {
            // Find the child tree that is off.
            val subtreesByWeight = children.groupBy { it.totalWeight }

            // Find the imbalanced child tree (they will be the lone node in the list, when grouped by weight)
            val badTree = subtreesByWeight.minBy { it.value.size }?.value?.first()
                    ?: throw IllegalStateException("Should not be balanced here.")

            // Recurse, passing down our imbalance. If we don't know the imbalance, calculate it.
            // Calculate the imbalance as the absolute value of the difference of all distinct weights
            badTree.findImbalance(imbalance ?: subtreesByWeight.keys.reduce { a, b -> a - b }.absoluteValue)
        }

    private val totalWeight: Int by lazy {
        weight + children.sumBy { it.totalWeight }
    }

    private val childrenAreBalanced: Boolean by lazy {
        children.map { it.totalWeight }.distinct().size == 1
    }
}