abstract class Day(val number: Int, val title: String) {
    protected val inputList by lazy { AdventHelper.inputList(number) }
    protected val inputAsString by lazy { AdventHelper.inputAsString(number) }

    abstract fun partOne(): Any
    abstract fun partTwo(): Any
}