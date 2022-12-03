package days

import Day

object Day02 : Day(2, "Rock, Paper, Scissor") {


    //1 Rock, 2 Paper, 3 Scissor
    private val shapes01 = mutableListOf<Pair<Int, Int>>()

    private val winningShapes = listOf(Pair(1,2), Pair(2,3), Pair(3,1))
    private val loosingShapes = listOf(Pair(2,1), Pair(3,2), Pair(1,3))


    init {
        inputList.forEach { shapes01.add(Pair("ABC".indexOf(it[0])+1, "XYZ".indexOf(it[2])+1)) }
    }

    override fun partOne() : Int{
        var points = 0
        shapes01.forEach {
            points += if (winningShapes.contains(it)) {
                6 + it.second
            } else if (loosingShapes.contains(it)) {
                it.second
            } else {
                3 +it.second
            }
        }
        return points
    }

    override fun partTwo(): String {
        return "Implemented in java and to lazy to do again"
    }

}