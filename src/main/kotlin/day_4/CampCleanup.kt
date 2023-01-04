package day_4

import java.io.File

fun main() {
    val testInput = File("src/main/kotlin/day_4/camp_cleanup.txt").readText().lines()

    fun calculate1(input: List<String>): Int {
        return input.map { line ->
            line.split(",")
        }.map { Pair(it[0], it[1]) }.map {
            it.let { pair ->
                pair.first.split("-").map { value -> value.toInt() }.let { firstList ->
                    Pair(firstList[0], firstList[1])
                } to pair.second.split("-").map { value -> value.toInt() }.let { secondList ->
                    Pair(secondList[0], secondList[1])
                }
            }
        }.filter { pairs ->
            pairs.first.first >= pairs.second.first && pairs.first.second <= pairs.second.second ||
                    pairs.first.first <= pairs.second.first && pairs.first.second >= pairs.second.second
        }.size
    }

    fun calculate2(input: List<String>): Int {
        return input.map { line ->
            line.split(",")
        }.map { Pair(it[0], it[1]) }.map {
            it.let { pair ->
                pair.first.split("-").map { value -> value.toInt() }.let { firstList ->
                    IntRange(firstList[0], firstList[1])
                } to pair.second.split("-").map { value -> value.toInt() }.let { secondList ->
                    IntRange(secondList[0], secondList[1])
                }
            }
        }.count { pair -> pair.first.intersect(pair.second).isNotEmpty() }

    }

    println(calculate1(testInput))
    println(calculate2(testInput))
}
