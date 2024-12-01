import kotlin.math.abs

fun main() {
    val input = readInput("Day01")
        .map {
            it.split("   ")
        }.flatten()

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
