package day_2

import java.io.File

fun main() {
    val testInput = File("src/main/kotlin/day_2/rock_paper_scissors_input.txt").readText()

    fun calculate1(input: String): Int {
        var sum = 0

        input.split("\n").map { line ->
            val me = line[2] - 'X' + 1
            val enemy = line[0] - 'A' + 1

            sum += me
            when (enemy - me) {
                -1, 2 -> sum += 6 // won
                0 -> sum += 3 // draw
                -2, 1 -> sum += 0 // loss
            }
        }
        return sum
    }

    fun calculate2(input: String): Int {
        var sum = 0

        input.split("\n").map { line ->
            val result = (line[2] - 'X') * 3
            val enemy = line[0] - 'A' + 1

            sum += result
            when (result - enemy) {
                3, 2, -2 -> sum += 1 // rock
                5, 1, -3 -> sum += 2 // paper
                4, 0, -1 -> sum += 3 // scissors
            }
        }
        return sum
    }

    println(calculate2(testInput))
}