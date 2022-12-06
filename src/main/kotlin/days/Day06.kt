package days

import Day

object Day06 : Day(6,"Tuning Trouble") {

    override fun partOne(): Int {
        for((i, _) in inputAsString.withIndex()){
            if(hasNoDuplicates(inputAsString.substring(i, i+4)))
                return i+4
        }
        return 0
    }

    override fun partTwo(): Int {
        for((i, _) in inputAsString.withIndex()){
            if(hasNoDuplicates(inputAsString.substring(i, i+14)))
                return i+14
        }
        return 0
    }

    private fun hasNoDuplicates(string : String) : Boolean {
        var set : MutableSet<Char> = mutableSetOf()
        string.forEach { set.add(it) }
        return set.size.equals(string.length)
    }
}