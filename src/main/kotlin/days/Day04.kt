package days

import Day

object Day04 : Day(4,"Camp Cleanup") {

    private var cleanupPlan = mutableListOf<Pair<List<Int>, List<Int>>>()

    init {
        cleanupPlan = inputList.map { Pair(
            IntRange(getDigit(it, 0), getDigit(it, 1)).toList()
            , IntRange(getDigit(it, 2), getDigit(it, 3)).toList())
        } as MutableList
    }

    override fun partOne(): Any {
        return cleanupPlan.fold(0) {
                acc, value -> if(value.first.containsAll(value.second) || value.second.containsAll(value.first))
                    acc+1 else acc}
    }

    override fun partTwo(): Any {
        return cleanupPlan.fold(0) {
                acc, value -> if(value.first.any() {it in value.second})
            acc+1 else acc}
    }

    private fun getDigit(string : String, position: Int) : Int{
        return string.split("-", ",")[position].toInt()
    }
}
