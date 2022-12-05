package days

import Day
import java.util.ArrayDeque

object Day05 : Day(5,"Supply Stacks") {

    private val stackPositions = listOf(1,5,9,13,17,21,25,29,33)

    private var stacks = mutableListOf<ArrayDeque<Char>>()
    private var secondStacks = mutableListOf<ArrayDeque<Char>>()

    private var movementPlan = mutableListOf<List<Int>>()

    init {
        val stackList = inputList.subList(0,9)
        val movementList = inputList.subList(10, inputList.size)

        for(i:Int in stackPositions){
            stacks.add(ArrayDeque())
            secondStacks.add(ArrayDeque())
                stackList.forEach {
                    try {
                        if(!it[i].isDigit() && (it[i] != ' ')) stacks[stackPositions.indexOf(i)].addLast(it[i])
                        if(!it[i].isDigit() && (it[i] != ' ')) secondStacks[stackPositions.indexOf(i)].addLast(it[i])
                    } catch (e:StringIndexOutOfBoundsException){}
                }
        }
        movementPlan = movementList.map { it.split("move ", " from ", " to ").filter { it!="" }.map { it.toInt() } } as MutableList
    }


    override fun partOne(): Any {
        movementPlan.forEach { move(stacks[it[1]-1], stacks[it[2]-1], it[0]) }
        return stacks.map { it.first() }
    }

    override fun partTwo(): Any {
        movementPlan.forEach { move9001(secondStacks[it[1]-1], secondStacks[it[2]-1], it[0]) }
        return secondStacks.map { it.first() }
    }

    private fun move(sourceStack: ArrayDeque<Char>, targetStack: ArrayDeque<Char>, times: Int) {
        for (i : Int in IntRange(1,times)) {
            var item = sourceStack.pop()
            targetStack.push(item)
        }
    }
    private fun move9001(sourceStack: ArrayDeque<Char>, targetStack: ArrayDeque<Char>, times: Int) {
        var tmpList = ArrayDeque<Char>()
        for (i : Int in IntRange(1,times)) {
            var item = sourceStack.pop()
            tmpList.push(item)
        }
        tmpList.forEach { _ -> targetStack.push(tmpList.pop()) }
    }
}