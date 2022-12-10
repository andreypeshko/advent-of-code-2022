import java.io.File

fun main() {
    val testInput = File("src/main/kotlin/rock_paper_scissors_input.txt").readText()

    fun calculate(input: String): Int {
        var sum = 0

        input.split("\n").map { line ->
            val me = line[2] - 'X' + 1
            val enemy = line[0] - 'A' + 1

            sum += me
            when (enemy - me) {
                -1, 2 -> sum += 6 //won
                0 -> sum += 3 //draw
                -2, 1 -> sum += 0 //loss
            }
        }
        return sum
    }

    println(calculate(testInput))
}