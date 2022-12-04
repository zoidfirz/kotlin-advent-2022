fun main() {
    partOneSolution()
    partTwoSolution()

}

private fun partOneSolution() {
    val data = readInput("main/resources/Day04_input")
    var counter = 0
    data.forEach { chunk ->
//        separate the input into separate arrays
        val (one, two) = chunk.split(",")
        val (groupOneStart, groupOneEnd) = one.split("-")
        val (groupTwoStart, groupTwoEnd) = two.split("-")


        if (groupOneStart.toInt() <= groupTwoStart.toInt() && groupOneEnd.toInt() >= groupTwoEnd.toInt()) {
            counter += 1
        } else if (groupTwoStart.toInt() <= groupOneStart.toInt() && groupTwoEnd.toInt() >= groupOneEnd.toInt()) {
            counter += 1
        }

    }
    println(counter)
}

private fun partTwoSolution() {
    val data = readInput("main/resources/Day04_input")
    var counter = 0
    data.forEach { chunk ->
//        separate the input into separate arrays
        val (one, two) = chunk.split(",")
        val (groupOneStart, groupOneEnd) = one.split("-")
        val (groupTwoStart, groupTwoEnd) = two.split("-")


        if (groupOneStart.toInt() <= groupTwoStart.toInt() && groupOneEnd.toInt() >= groupTwoStart.toInt()) {
            counter += 1
        } else if (groupTwoStart.toInt() <= groupOneStart.toInt() && groupTwoEnd.toInt() >= groupOneStart.toInt()) {
            counter += 1
        }

    }
    println(counter)
}