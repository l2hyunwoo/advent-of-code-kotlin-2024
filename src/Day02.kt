import kotlin.math.abs

fun main() {
    val input = readInput("Day02")
        .map { it.split(" ") }
        .map { it.map { element -> element.toInt() } }

    fun isSafe(row: List<Int>): Boolean {
        val isUp = row.zipWithNext().all { (a, b) -> b - a in (1..3) }
        val isDown = row.zipWithNext().all { (a, b) -> a - b in (1..3) }
        return isUp || isDown
    }

    fun part1(input: List<List<Int>>): Int {
        var answer = 0
        input.forEach { list ->
            var isValidated = true
            val sorted = list.sorted()
            val isSorted = list.zip(sorted).all { it.first == it.second } or
                    list.zip(sorted.asReversed()).all { it.first == it.second }
            if (isSorted) {
                val comparator = list.drop(1)
                comparator.forEachIndexed { index, item ->
                    val isRanged = abs(item - list[index]) in 1..3
                    if (!isRanged) {
                        isValidated = false
                        return@forEachIndexed
                    }
                }
                if (isValidated) answer++
            } else {
                isValidated = false
            }
        }
        return answer
    }

    fun part2(input: List<List<Int>>): Int {
        return input.count { row ->
            isSafe(row) || row.indices.any { i ->
                val sublist = row.subList(0, i) + row.subList(i + 1, row.size)
                isSafe(sublist)
            }
        }
    }

    println(part2(input))
}
