import days.Day01
import days.Day02
import days.Day03
import days.Day04

object Main {
    private val days = listOf(
            Day01,
            Day02,
            Day03,
            Day04,
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
        val header = "=== Day ${day.number.toString().padStart(2, '0')}: ${day.title} ==="
        println(header)
        println("O> Part 1: ${day.partOne()}")
        println("O> Part 2: ${day.partTwo()}")
    }
}