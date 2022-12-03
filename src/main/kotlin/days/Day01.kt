package days

import Day

object Day01 : Day(1, "Calorie Counting") {

    private var elves = mutableListOf<Int>()

    init {
        var i = 0
        inputList.forEach { value -> if (value == "") elves.add(i).also { i=0 } else i += value.toInt() }
        elves = elves.sorted().toMutableList()
    }

    override fun partOne() : Int{
        return elves.takeLast(1)[0]
    }

    override fun partTwo() : Int{
        return elves.takeLast(3).sum()
    }

}