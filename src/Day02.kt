import kotlin.math.abs

fun main() {
    val input = readInput("Day02")
        .map { it.split(" ") }
        .map { it.map { element -> element.toInt() } }

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
        TODO()
    }

    println(part1(input))

//    input.forEach { list ->
//        list.forEach { print("$it ") }
//        println()
//    }
}
