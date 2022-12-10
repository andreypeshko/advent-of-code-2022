import java.io.File

fun main() {
    val testInput = File("src/main/kotlin/rock_paper_scissors_input.txt").readText()

    fun calculate(input: String): Int {
        var sum = 0
        var lineNo = sum
        input.split("\n").map { line ->
            println(++lineNo)
            println(line)
            when (line) {
                "A X" -> sum += 4 "A Y" -> sum += 8 "A Z" -> sum += 3
                "B X" -> sum += 1 "B Y" -> sum += 5 "B Z" -> sum += 9
                "C X" -> sum += 7 "C Y" -> sum += 2 "C Z" -> sum += 6
            }
            println("$sum ")
        }
        return sum
    }

    println(calculate(testInput))
}
