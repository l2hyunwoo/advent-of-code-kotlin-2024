import kotlin.math.abs

fun main() {
    val input = readInput("Day01")
        .map {
            it.split("   ")
        }.flatten()

    fun part1(input: List<String>) {
        val firstList = mutableListOf<String>()
        val secondList = mutableListOf<String>()

        input.forEachIndexed { index, content ->
            if (index % 2 == 0) {
                firstList.add(content)
            } else {
                secondList.add(content)
            }
        }

        firstList.sort()
        secondList.sort()

        var answer = 0
        for (i in firstList.indices) {
            answer += abs(firstList[i].toInt() - secondList[i].toInt())
        }

        println(answer)
    }

    fun part2(input: List<String>) {
        val firstList = mutableListOf<String>()
        val secondList = mutableListOf<String>()

        input.forEachIndexed { index, content ->
            if (index % 2 == 0) {
                firstList.add(content)
            } else {
                secondList.add(content)
            }
        }

        val contrastMap = secondList.groupBy { it }
            .mapValues { it.value.size }

        var answer = 0

        firstList.forEach {
            val key = it.toInt()
            val value = contrastMap[key.toString()] ?: 0
            answer += key * value
        }

        println(answer)
    }
    part2(input)
}
