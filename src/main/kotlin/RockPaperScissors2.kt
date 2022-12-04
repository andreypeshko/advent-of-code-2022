import java.io.File

fun main() {
    val testInput = File("src/main/kotlin/rock_paper_scissors_input.txt").readText()

    fun calculate(input: String): Int {
        var sum = 0

        input.split("\n").map { line ->
            val me = line[2] - 'X' + 1
            val enemy = line[0] - 'A' + 1

            when (enemy - me) {
                in (-3..-1) -> sum += 6 + me // won
                0 -> sum += 3 + me // draw
                in (1..3) -> sum += 0 + me// lose
            }
        }
        return sum
    }

    println(calculate(testInput))
}
