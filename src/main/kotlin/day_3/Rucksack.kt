package day_3

import java.io.File

fun main() {
    val task1Input = File("src/main/kotlin/day_3/test_input.txt").readText().lines()
    val task2Input = File("src/main/kotlin/day_3/test_input_2.txt").readText().lines()

    fun calculate1(input: List<String>): Int {
        return input
            .asSequence()
            .map { Pair(it.substring(0 until it.length / 2), it.substring(it.length / 2)) }
            .map { pair ->
                pair.first.filter { pair.second.contains(it) }
            }
            .map { it[0] }
            .map { if (it.isUpperCase()) it.toLowerCase() - 'A'.code - 5 else it.toUpperCase() - 'A'.code + 1 }
            .sumOf { it.code }
    }

    fun calculate2(input: List<String>): Int {
        return input
            .asSequence()
            .chunked(3)
            .map { item -> item.zipWithNext { left, right ->  left.filter { right.contains(it) }} }
            .map { item -> item.zipWithNext { left, right ->  left.filter { right.contains(it) }} }
            .map { it[0][0] }
            .map { if (it.isUpperCase()) it.toLowerCase() - 'A'.code - 5 else it.toUpperCase() - 'A'.code + 1 }
            .sumOf { it.code }
    }

    println(calculate2(task2Input))
}