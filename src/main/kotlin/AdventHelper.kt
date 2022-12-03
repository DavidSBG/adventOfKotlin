import java.io.File

object AdventHelper {
    fun inputList(number: Int) = getInputFile(number).readLines()

    private fun getInputFile(number: Int): File {
        return File(javaClass.classLoader.getResource(
            "Day${number.toString().padStart(2, '0')}.txt")?.toURI()
            ?: error("Missing input file for day $number !")
        )
    }
}