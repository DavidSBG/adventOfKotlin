import days.Day01
import days.Day03

object Main {
    private val days = listOf(
        Day03
    )

    @JvmStatic
    fun main(args: Array<String>) {
        if (args.isNotEmpty()) {
            val number = args[0].toInt()
            days.find { it.number == number }?.also { printDay(it) } ?: error("Day $number not found!")
        } else
            println("No day specified, running all")
            days.forEach { printDay(it)}
    }


    private fun printDay(day: Day) {
        println("=== Day ${day.number.toString().padStart(2, '0')}: ${day.title} ===")
        println("|> Part 1: ${day.partOne()}")
        println("|> Part 2: ${day.partTwo()}")
    }
}